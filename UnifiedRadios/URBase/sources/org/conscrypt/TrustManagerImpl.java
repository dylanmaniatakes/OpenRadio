package org.conscrypt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509ExtendedTrustManager;
import org.conscrypt.ct.CTPolicy;
import org.conscrypt.ct.CTVerifier;

/* loaded from: classes.dex */
public final class TrustManagerImpl extends X509ExtendedTrustManager {
    private static ConscryptHostnameVerifier defaultHostnameVerifier;
    private final X509Certificate[] acceptedIssuers;
    private final CertBlocklist blocklist;
    private boolean ctEnabledOverride;
    private CTPolicy ctPolicy;
    private CTVerifier ctVerifier;
    private final Exception err;
    private final CertificateFactory factory;
    private ConscryptHostnameVerifier hostnameVerifier;
    private final TrustedCertificateIndex intermediateIndex;
    private CertPinManager pinManager;
    private final KeyStore rootKeyStore;
    private final TrustedCertificateIndex trustedCertificateIndex;
    private final ConscryptCertStore trustedCertificateStore;
    private final CertPathValidator validator;
    private static final Logger logger = Logger.getLogger(TrustManagerImpl.class.getName());
    private static final TrustAnchorComparator TRUST_ANCHOR_COMPARATOR = new TrustAnchorComparator();

    public static class ExtendedKeyUsagePKIXCertPathChecker extends PKIXCertPathChecker {
        private static final String EKU_anyExtendedKeyUsage = "2.5.29.37.0";
        private static final String EKU_clientAuth = "1.3.6.1.5.5.7.3.2";
        private static final String EKU_msSGC = "1.3.6.1.4.1.311.10.3.3";
        private static final String EKU_nsSGC = "2.16.840.1.113730.4.1";
        private static final String EKU_serverAuth = "1.3.6.1.5.5.7.3.1";
        private final boolean clientAuth;
        private final X509Certificate leaf;
        private static final String EKU_OID = "2.5.29.37";
        private static final Set<String> SUPPORTED_EXTENSIONS = Collections.unmodifiableSet(new HashSet(Arrays.asList(EKU_OID)));

        @Override // java.security.cert.PKIXCertPathChecker
        public void check(Certificate certificate, Collection<String> collection) throws CertificateParsingException, CertPathValidatorException {
            X509Certificate x509Certificate = this.leaf;
            if (certificate != x509Certificate) {
                return;
            }
            try {
                List<String> extendedKeyUsage = x509Certificate.getExtendedKeyUsage();
                if (extendedKeyUsage == null) {
                    return;
                }
                for (String str : extendedKeyUsage) {
                    if (!str.equals(EKU_anyExtendedKeyUsage)) {
                        if (this.clientAuth) {
                            if (str.equals(EKU_clientAuth)) {
                            }
                        } else if (!str.equals(EKU_serverAuth) && !str.equals(EKU_nsSGC) && !str.equals(EKU_msSGC)) {
                        }
                    }
                    collection.remove(EKU_OID);
                    return;
                }
                throw new CertPathValidatorException("End-entity certificate does not have a valid extendedKeyUsage.");
            } catch (CertificateParsingException e5) {
                throw new CertPathValidatorException(e5);
            }
        }

        @Override // java.security.cert.PKIXCertPathChecker
        public Set<String> getSupportedExtensions() {
            return SUPPORTED_EXTENSIONS;
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public void init(boolean z4) throws CertPathValidatorException {
        }

        @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
        public boolean isForwardCheckingSupported() {
            return true;
        }

        private ExtendedKeyUsagePKIXCertPathChecker(boolean z4, X509Certificate x509Certificate) {
            this.clientAuth = z4;
            this.leaf = x509Certificate;
        }
    }

    public static class TrustAnchorComparator implements Comparator<TrustAnchor> {
        private static final CertificatePriorityComparator CERT_COMPARATOR = new CertificatePriorityComparator();

        private TrustAnchorComparator() {
        }

        @Override // java.util.Comparator
        public int compare(TrustAnchor trustAnchor, TrustAnchor trustAnchor2) {
            return CERT_COMPARATOR.compare(trustAnchor.getTrustedCert(), trustAnchor2.getTrustedCert());
        }
    }

    public TrustManagerImpl(KeyStore keyStore) {
        this(keyStore, null);
    }

    private static X509Certificate[] acceptedIssuers(KeyStore keyStore) throws KeyStoreException {
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(enumerationAliases.nextElement());
                if (x509Certificate != null) {
                    arrayList.add(x509Certificate);
                }
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (KeyStoreException unused) {
            return new X509Certificate[0];
        }
    }

    private void checkBlocklist(X509Certificate x509Certificate) throws CertificateException {
        CertBlocklist certBlocklist = this.blocklist;
        if (certBlocklist == null || !certBlocklist.isPublicKeyBlockListed(x509Certificate.getPublicKey())) {
            return;
        }
        throw new CertificateException("Certificate blocklisted by public key: " + x509Certificate);
    }

    private void checkCT(String str, List<X509Certificate> list, byte[] bArr, byte[] bArr2) throws CertificateException {
        if (!this.ctPolicy.doesResultConformToPolicy(this.ctVerifier.verifySignedCertificateTimestamps(list, bArr2, bArr), str, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]))) {
            throw new CertificateException("Certificate chain does not conform to required transparency policy.");
        }
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession, SSLParameters sSLParameters, boolean z4) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        byte[] ocspDataFromSession;
        byte[] tlsSctDataFromSession;
        String peerHost;
        if (sSLSession != null) {
            peerHost = sSLSession.getPeerHost();
            ocspDataFromSession = getOcspDataFromSession(sSLSession);
            tlsSctDataFromSession = getTlsSctDataFromSession(sSLSession);
        } else {
            ocspDataFromSession = null;
            tlsSctDataFromSession = null;
            peerHost = null;
        }
        if (sSLSession == null || sSLParameters == null || !"HTTPS".equalsIgnoreCase(sSLParameters.getEndpointIdentificationAlgorithm()) || getHttpsVerifier().verify(x509CertificateArr, peerHost, sSLSession)) {
            return checkTrusted(x509CertificateArr, ocspDataFromSession, tlsSctDataFromSession, str, peerHost, z4);
        }
        throw new CertificateException("No subjectAltNames on the certificate match");
    }

    private List<X509Certificate> checkTrustedRecursive(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, boolean z4, ArrayList<X509Certificate> arrayList, ArrayList<TrustAnchor> arrayList2, Set<X509Certificate> set) throws CertificateException {
        X509Certificate trustedCert = arrayList2.isEmpty() ? arrayList.get(arrayList.size() - 1) : arrayList2.get(arrayList2.size() - 1).getTrustedCert();
        checkBlocklist(trustedCert);
        if (trustedCert.getIssuerDN().equals(trustedCert.getSubjectDN())) {
            return verifyChain(arrayList, arrayList2, str, z4, bArr, bArr2);
        }
        boolean z5 = false;
        CertificateException certificateException = null;
        for (TrustAnchor trustAnchor : sortPotentialAnchors(findAllTrustAnchorsByIssuerAndSignature(trustedCert))) {
            X509Certificate trustedCert2 = trustAnchor.getTrustedCert();
            if (!set.contains(trustedCert2)) {
                set.add(trustedCert2);
                arrayList2.add(trustAnchor);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z4, arrayList, arrayList2, set);
                } catch (CertificateException e5) {
                    arrayList2.remove(arrayList2.size() - 1);
                    set.remove(trustedCert2);
                    certificateException = e5;
                    z5 = true;
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            if (z5) {
                throw certificateException;
            }
            return verifyChain(arrayList, arrayList2, str, z4, bArr, bArr2);
        }
        for (int i5 = 1; i5 < x509CertificateArr.length; i5++) {
            X509Certificate x509Certificate = x509CertificateArr[i5];
            if (!set.contains(x509Certificate) && trustedCert.getIssuerDN().equals(x509Certificate.getSubjectDN())) {
                try {
                    x509Certificate.checkValidity();
                    ChainStrengthAnalyzer.checkCert(x509Certificate);
                    set.add(x509Certificate);
                    arrayList.add(x509Certificate);
                    try {
                        return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z4, arrayList, arrayList2, set);
                    } catch (CertificateException e6) {
                        set.remove(x509Certificate);
                        arrayList.remove(arrayList.size() - 1);
                        certificateException = e6;
                    }
                } catch (CertificateException e7) {
                    certificateException = new CertificateException("Unacceptable certificate: " + x509Certificate.getSubjectX500Principal(), e7);
                }
            }
        }
        Iterator<TrustAnchor> it = sortPotentialAnchors(this.intermediateIndex.findAllByIssuerAndSignature(trustedCert)).iterator();
        while (it.hasNext()) {
            X509Certificate trustedCert3 = it.next().getTrustedCert();
            if (!set.contains(trustedCert3)) {
                set.add(trustedCert3);
                arrayList.add(trustedCert3);
                try {
                    return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str, z4, arrayList, arrayList2, set);
                } catch (CertificateException e8) {
                    arrayList.remove(arrayList.size() - 1);
                    set.remove(trustedCert3);
                    certificateException = e8;
                }
            }
        }
        if (certificateException != null) {
            throw certificateException;
        }
        throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, this.factory.generateCertPath(arrayList), -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set, java.util.Set<java.security.cert.TrustAnchor>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Set<java.security.cert.TrustAnchor>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    private Set<TrustAnchor> findAllTrustAnchorsByIssuerAndSignature(X509Certificate x509Certificate) {
        ConscryptCertStore conscryptCertStore;
        ?? FindAllByIssuerAndSignature = this.trustedCertificateIndex.findAllByIssuerAndSignature(x509Certificate);
        if (FindAllByIssuerAndSignature.isEmpty() && (conscryptCertStore = this.trustedCertificateStore) != null) {
            Set<X509Certificate> setFindAllIssuers = conscryptCertStore.findAllIssuers(x509Certificate);
            if (setFindAllIssuers.isEmpty()) {
                return FindAllByIssuerAndSignature;
            }
            FindAllByIssuerAndSignature = new HashSet(setFindAllIssuers.size());
            Iterator<X509Certificate> it = setFindAllIssuers.iterator();
            while (it.hasNext()) {
                FindAllByIssuerAndSignature.add(this.trustedCertificateIndex.index(it.next()));
            }
        }
        return FindAllByIssuerAndSignature;
    }

    private TrustAnchor findTrustAnchorBySubjectAndPublicKey(X509Certificate x509Certificate) {
        X509Certificate trustAnchor;
        TrustAnchor trustAnchorFindBySubjectAndPublicKey = this.trustedCertificateIndex.findBySubjectAndPublicKey(x509Certificate);
        if (trustAnchorFindBySubjectAndPublicKey != null) {
            return trustAnchorFindBySubjectAndPublicKey;
        }
        ConscryptCertStore conscryptCertStore = this.trustedCertificateStore;
        if (conscryptCertStore == null || (trustAnchor = conscryptCertStore.getTrustAnchor(x509Certificate)) == null) {
            return null;
        }
        return new TrustAnchor(trustAnchor, null);
    }

    public static synchronized ConscryptHostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerifier;
    }

    private static SSLSession getHandshakeSessionOrThrow(SSLSocket sSLSocket) throws CertificateException {
        SSLSession handshakeSession = sSLSocket.getHandshakeSession();
        if (handshakeSession != null) {
            return handshakeSession;
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    private ConscryptHostnameVerifier getHttpsVerifier() {
        ConscryptHostnameVerifier conscryptHostnameVerifier = this.hostnameVerifier;
        return conscryptHostnameVerifier != null ? conscryptHostnameVerifier : Platform.getDefaultHostnameVerifier();
    }

    private static byte[] getOcspDataFromSession(SSLSession sSLSession) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        List<byte[]> statusResponses;
        if (sSLSession instanceof ConscryptSession) {
            statusResponses = ((ConscryptSession) sSLSession).getStatusResponses();
        } else {
            try {
                Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getStatusResponses", null);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(sSLSession, null);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5.getCause());
            }
            statusResponses = objInvoke instanceof List ? (List) objInvoke : null;
        }
        if (statusResponses == null || statusResponses.isEmpty()) {
            return null;
        }
        return statusResponses.get(0);
    }

    private byte[] getTlsSctDataFromSession(SSLSession sSLSession) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (sSLSession instanceof ConscryptSession) {
            return ((ConscryptSession) sSLSession).getPeerSignedCertificateTimestamp();
        }
        try {
            Method declaredMethod = sSLSession.getClass().getDeclaredMethod("getPeerSignedCertificateTimestamp", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(sSLSession, null);
            if (objInvoke instanceof byte[]) {
                return (byte[]) objInvoke;
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException unused) {
            return null;
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5.getCause());
        }
    }

    public static synchronized void setDefaultHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        defaultHostnameVerifier = conscryptHostnameVerifier;
    }

    private void setOcspResponses(PKIXParameters pKIXParameters, X509Certificate x509Certificate, byte[] bArr) {
        PKIXRevocationChecker pKIXRevocationChecker;
        if (bArr == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(pKIXParameters.getCertPathCheckers());
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                pKIXRevocationChecker = null;
                break;
            }
            PKIXCertPathChecker pKIXCertPathChecker = (PKIXCertPathChecker) it.next();
            if (pKIXCertPathChecker instanceof PKIXRevocationChecker) {
                pKIXRevocationChecker = (PKIXRevocationChecker) pKIXCertPathChecker;
                break;
            }
        }
        if (pKIXRevocationChecker == null) {
            try {
                pKIXRevocationChecker = (PKIXRevocationChecker) this.validator.getRevocationChecker();
                arrayList.add(pKIXRevocationChecker);
                pKIXRevocationChecker.setOptions(Collections.singleton(PKIXRevocationChecker.Option.ONLY_END_ENTITY));
            } catch (UnsupportedOperationException unused) {
                return;
            }
        }
        pKIXRevocationChecker.setOcspResponses(Collections.singletonMap(x509Certificate, bArr));
        pKIXParameters.setCertPathCheckers(arrayList);
    }

    private static Collection<TrustAnchor> sortPotentialAnchors(Set<TrustAnchor> set) {
        if (set.size() <= 1) {
            return set;
        }
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList, TRUST_ANCHOR_COMPARATOR);
        return arrayList;
    }

    private static Set<TrustAnchor> trustAnchors(X509Certificate[] x509CertificateArr) {
        HashSet hashSet = new HashSet(x509CertificateArr.length);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            hashSet.add(new TrustAnchor(x509Certificate, null));
        }
        return hashSet;
    }

    private List<X509Certificate> verifyChain(List<X509Certificate> list, List<TrustAnchor> list2, String str, boolean z4, byte[] bArr, byte[] bArr2) throws CertificateException, CertPathValidatorException, InvalidAlgorithmParameterException {
        try {
            CertPath certPathGenerateCertPath = this.factory.generateCertPath(list);
            if (list2.isEmpty()) {
                throw new CertificateException(new CertPathValidatorException("Trust anchor for certification path not found.", null, certPathGenerateCertPath, -1));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            Iterator<TrustAnchor> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getTrustedCert());
            }
            CertPinManager certPinManager = this.pinManager;
            if (certPinManager != null) {
                certPinManager.checkChainPinning(str, arrayList);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                checkBlocklist((X509Certificate) it2.next());
            }
            if (!z4 && (this.ctEnabledOverride || (str != null && Platform.isCTVerificationRequired(str)))) {
                checkCT(str, arrayList, bArr, bArr2);
            }
            if (list.isEmpty()) {
                return arrayList;
            }
            ChainStrengthAnalyzer.check(list);
            try {
                try {
                    HashSet hashSet = new HashSet();
                    hashSet.add(list2.get(0));
                    PKIXParameters pKIXParameters = new PKIXParameters(hashSet);
                    pKIXParameters.setRevocationEnabled(false);
                    X509Certificate x509Certificate = list.get(0);
                    setOcspResponses(pKIXParameters, x509Certificate, bArr);
                    pKIXParameters.addCertPathChecker(new ExtendedKeyUsagePKIXCertPathChecker(z4, x509Certificate));
                    this.validator.validate(certPathGenerateCertPath, pKIXParameters);
                    for (int i5 = 1; i5 < list.size(); i5++) {
                        this.intermediateIndex.index(list.get(i5));
                    }
                    return arrayList;
                } catch (InvalidAlgorithmParameterException e5) {
                    throw new CertificateException("Chain validation failed", e5);
                }
            } catch (CertPathValidatorException e6) {
                throw new CertificateException("Chain validation failed", e6);
            }
        } catch (CertificateException e7) {
            logger.fine("Rejected candidate cert chain due to error: " + e7.getMessage());
            throw e7;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        checkTrusted(x509CertificateArr, str, null, null, true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        checkTrusted(x509CertificateArr, str, null, null, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        return x509CertificateArr != null ? (X509Certificate[]) x509CertificateArr.clone() : acceptedIssuers(this.rootKeyStore);
    }

    public ConscryptHostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        SSLSession sSLSession;
        SSLParameters sSLParameters;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        return checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, false);
    }

    public void handleTrustStorageUpdate() {
        X509Certificate[] x509CertificateArr = this.acceptedIssuers;
        if (x509CertificateArr == null) {
            this.trustedCertificateIndex.reset();
        } else {
            this.trustedCertificateIndex.reset(trustAnchors(x509CertificateArr));
        }
    }

    public void setCTEnabledOverride(boolean z4) {
        this.ctEnabledOverride = z4;
    }

    public void setCTPolicy(CTPolicy cTPolicy) {
        this.ctPolicy = cTPolicy;
    }

    public void setCTVerifier(CTVerifier cTVerifier) {
        this.ctVerifier = cTVerifier;
    }

    public void setHostnameVerifier(ConscryptHostnameVerifier conscryptHostnameVerifier) {
        this.hostnameVerifier = conscryptHostnameVerifier;
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager) {
        this(keyStore, certPinManager, null);
    }

    public List<X509Certificate> checkClientTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, null, null, str, str2, true);
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) throws CertificateException {
        return checkTrusted(x509CertificateArr, null, null, str, str2, false);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore) {
        this(keyStore, certPinManager, conscryptCertStore, null);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        SSLSession sSLSession;
        SSLParameters sSLParameters;
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLSession handshakeSessionOrThrow = getHandshakeSessionOrThrow(sSLSocket);
            sSLParameters = sSLSocket.getSSLParameters();
            sSLSession = handshakeSessionOrThrow;
        } else {
            sSLSession = null;
            sSLParameters = null;
        }
        checkTrusted(x509CertificateArr, str, sSLSession, sSLParameters, true);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, socket);
    }

    public TrustManagerImpl(KeyStore keyStore, CertPinManager certPinManager, ConscryptCertStore conscryptCertStore, CertBlocklist certBlocklist) {
        this(keyStore, certPinManager, conscryptCertStore, certBlocklist, null, null, null);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        getTrustedChainForServer(x509CertificateArr, str, sSLEngine);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TrustManagerImpl(java.security.KeyStore r6, org.conscrypt.CertPinManager r7, org.conscrypt.ConscryptCertStore r8, org.conscrypt.CertBlocklist r9, org.conscrypt.ct.CTLogStore r10, org.conscrypt.ct.CTVerifier r11, org.conscrypt.ct.CTPolicy r12) throws java.security.NoSuchAlgorithmException, java.security.cert.CertificateException {
        /*
            Method dump skipped, instructions count: 179
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.TrustManagerImpl.<init>(java.security.KeyStore, org.conscrypt.CertPinManager, org.conscrypt.ConscryptCertStore, org.conscrypt.CertBlocklist, org.conscrypt.ct.CTLogStore, org.conscrypt.ct.CTVerifier, org.conscrypt.ct.CTPolicy):void");
    }

    public List<X509Certificate> checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) throws CertificateException {
        return checkTrusted(x509CertificateArr, str, sSLSession, null, false);
    }

    public List<X509Certificate> getTrustedChainForServer(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession != null) {
            return checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), false);
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws IllegalAccessException, NoSuchMethodException, SecurityException, CertificateException, IllegalArgumentException, InvocationTargetException {
        SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        if (handshakeSession != null) {
            checkTrusted(x509CertificateArr, str, handshakeSession, sSLEngine.getSSLParameters(), true);
            return;
        }
        throw new CertificateException("Not in handshake; no session available");
    }

    private List<X509Certificate> checkTrusted(X509Certificate[] x509CertificateArr, byte[] bArr, byte[] bArr2, String str, String str2, boolean z4) throws CertificateException {
        if (x509CertificateArr != null && x509CertificateArr.length != 0 && str != null && str.length() != 0) {
            if (this.err == null) {
                HashSet hashSet = new HashSet();
                ArrayList<X509Certificate> arrayList = new ArrayList<>();
                ArrayList<TrustAnchor> arrayList2 = new ArrayList<>();
                X509Certificate x509Certificate = x509CertificateArr[0];
                TrustAnchor trustAnchorFindTrustAnchorBySubjectAndPublicKey = findTrustAnchorBySubjectAndPublicKey(x509Certificate);
                if (trustAnchorFindTrustAnchorBySubjectAndPublicKey != null) {
                    arrayList2.add(trustAnchorFindTrustAnchorBySubjectAndPublicKey);
                    hashSet.add(trustAnchorFindTrustAnchorBySubjectAndPublicKey.getTrustedCert());
                } else {
                    arrayList.add(x509Certificate);
                }
                hashSet.add(x509Certificate);
                return checkTrustedRecursive(x509CertificateArr, bArr, bArr2, str2, z4, arrayList, arrayList2, hashSet);
            }
            throw new CertificateException(this.err);
        }
        throw new IllegalArgumentException("null or zero-length parameter");
    }
}
