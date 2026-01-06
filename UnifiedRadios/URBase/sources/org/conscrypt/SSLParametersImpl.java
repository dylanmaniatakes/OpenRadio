package org.conscrypt;

import java.security.AlgorithmConstraints;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
final class SSLParametersImpl implements Cloneable {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static volatile SSLParametersImpl defaultParameters;
    private static volatile X509KeyManager defaultX509KeyManager;
    private static volatile X509TrustManager defaultX509TrustManager;
    private AlgorithmConstraints algorithmConstraints;
    ApplicationProtocolSelectorAdapter applicationProtocolSelector;
    byte[] applicationProtocols;
    boolean channelIdEnabled;
    private final ClientSessionContext clientSessionContext;
    private boolean client_mode;
    private boolean ctVerificationEnabled;
    private boolean enable_session_creation;
    String[] enabledCipherSuites;
    String[] enabledProtocols;
    private String endpointIdentificationAlgorithm;
    boolean isEnabledProtocolsFiltered;
    private boolean need_client_auth;
    byte[] ocspResponse;
    private final PSKKeyManager pskKeyManager;
    byte[] sctExtension;
    private final ServerSessionContext serverSessionContext;
    private Collection<SNIMatcher> sniMatchers;
    private boolean useCipherSuitesOrder;
    boolean useSessionTickets;
    private Boolean useSni;
    private boolean want_client_auth;
    private final X509KeyManager x509KeyManager;
    private final X509TrustManager x509TrustManager;

    public interface AliasChooser {
        String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr);

        String chooseServerAlias(X509KeyManager x509KeyManager, String str);
    }

    public interface PSKCallbacks {
        String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str);

        String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager);

        SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2);
    }

    public SSLParametersImpl(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom, ClientSessionContext clientSessionContext, ServerSessionContext serverSessionContext, String[] strArr) throws KeyManagementException {
        this.client_mode = true;
        this.need_client_auth = false;
        this.want_client_auth = false;
        this.enable_session_creation = true;
        this.applicationProtocols = EmptyArray.BYTE;
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
        if (keyManagerArr == null) {
            this.x509KeyManager = getDefaultX509KeyManager();
            this.pskKeyManager = null;
        } else {
            this.x509KeyManager = findFirstX509KeyManager(keyManagerArr);
            this.pskKeyManager = findFirstPSKKeyManager(keyManagerArr);
        }
        if (trustManagerArr == null) {
            this.x509TrustManager = getDefaultX509TrustManager();
        } else {
            this.x509TrustManager = findFirstX509TrustManager(trustManagerArr);
        }
        this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(strArr == null ? NativeCrypto.DEFAULT_PROTOCOLS : strArr).clone();
        this.enabledCipherSuites = getDefaultCipherSuites((this.x509KeyManager == null && this.x509TrustManager == null) ? false : true, this.pskKeyManager != null);
    }

    private static X509KeyManager createDefaultX509KeyManager() throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyManagementException {
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(null, null);
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();
            X509KeyManager x509KeyManagerFindFirstX509KeyManager = findFirstX509KeyManager(keyManagers);
            if (x509KeyManagerFindFirstX509KeyManager != null) {
                return x509KeyManagerFindFirstX509KeyManager;
            }
            throw new KeyManagementException("No X509KeyManager among default KeyManagers: " + Arrays.toString(keyManagers));
        } catch (KeyStoreException e5) {
            throw new KeyManagementException(e5);
        } catch (NoSuchAlgorithmException e6) {
            throw new KeyManagementException(e6);
        } catch (UnrecoverableKeyException e7) {
            throw new KeyManagementException(e7);
        }
    }

    private static X509TrustManager createDefaultX509TrustManager() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            X509TrustManager x509TrustManagerFindFirstX509TrustManager = findFirstX509TrustManager(trustManagers);
            if (x509TrustManagerFindFirstX509TrustManager != null) {
                return x509TrustManagerFindFirstX509TrustManager;
            }
            throw new KeyManagementException("No X509TrustManager in among default TrustManagers: " + Arrays.toString(trustManagers));
        } catch (KeyStoreException e5) {
            throw new KeyManagementException(e5);
        } catch (NoSuchAlgorithmException e6) {
            throw new KeyManagementException(e6);
        }
    }

    private static String[] filterFromCipherSuites(String[] strArr, Set<String> set) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!set.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
    }

    private static String[] filterFromProtocols(String[] strArr, String str) {
        if (strArr.length == 1 && str.equals(strArr[0])) {
            return EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (!str.equals(str2)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
    }

    private static PSKKeyManager findFirstPSKKeyManager(KeyManager[] keyManagerArr) {
        int length = keyManagerArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            KeyManager keyManager = keyManagerArr[i5];
            if (keyManager instanceof PSKKeyManager) {
                return (PSKKeyManager) keyManager;
            }
            if (keyManager != null) {
                try {
                    return DuckTypedPSKKeyManager.getInstance(keyManager);
                } catch (NoSuchMethodException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    private static X509KeyManager findFirstX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        return null;
    }

    private static X509TrustManager findFirstX509TrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    public static SSLParametersImpl getDefault() throws KeyManagementException {
        SSLParametersImpl sSLParametersImpl = defaultParameters;
        if (sSLParametersImpl == null) {
            sSLParametersImpl = new SSLParametersImpl((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null, new ClientSessionContext(), new ServerSessionContext(), (String[]) null);
            defaultParameters = sSLParametersImpl;
        }
        return (SSLParametersImpl) sSLParametersImpl.clone();
    }

    private static String[] getDefaultCipherSuites(boolean z4, boolean z5) {
        return z4 ? z5 ? SSLUtils.concat(NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"}) : SSLUtils.concat(NativeCrypto.DEFAULT_X509_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"}) : z5 ? SSLUtils.concat(NativeCrypto.DEFAULT_PSK_CIPHER_SUITES, new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"}) : new String[]{"TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
    }

    private static X509KeyManager getDefaultX509KeyManager() throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, KeyManagementException {
        X509KeyManager x509KeyManager = defaultX509KeyManager;
        if (x509KeyManager != null) {
            return x509KeyManager;
        }
        X509KeyManager x509KeyManagerCreateDefaultX509KeyManager = createDefaultX509KeyManager();
        defaultX509KeyManager = x509KeyManagerCreateDefaultX509KeyManager;
        return x509KeyManagerCreateDefaultX509KeyManager;
    }

    public static X509TrustManager getDefaultX509TrustManager() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        X509TrustManager x509TrustManager = defaultX509TrustManager;
        if (x509TrustManager != null) {
            return x509TrustManager;
        }
        X509TrustManager x509TrustManagerCreateDefaultX509TrustManager = createDefaultX509TrustManager();
        defaultX509TrustManager = x509TrustManagerCreateDefaultX509TrustManager;
        return x509TrustManagerCreateDefaultX509TrustManager;
    }

    private boolean isSniEnabledByDefault() {
        try {
            String property = System.getProperty("jsse.enableSNIExtension", "true");
            if ("true".equalsIgnoreCase(property)) {
                return true;
            }
            if ("false".equalsIgnoreCase(property)) {
                return false;
            }
            throw new RuntimeException("Can only set \"jsse.enableSNIExtension\" to \"true\" or \"false\"");
        } catch (SecurityException unused) {
            return true;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public SSLParametersImpl cloneWithTrustManager(X509TrustManager x509TrustManager) {
        return new SSLParametersImpl(this.clientSessionContext, this.serverSessionContext, this.x509KeyManager, this.pskKeyManager, x509TrustManager, this);
    }

    public AlgorithmConstraints getAlgorithmConstraints() {
        return this.algorithmConstraints;
    }

    public ApplicationProtocolSelectorAdapter getApplicationProtocolSelector() {
        return this.applicationProtocolSelector;
    }

    public String[] getApplicationProtocols() {
        return SSLUtils.decodeProtocols(this.applicationProtocols);
    }

    public ClientSessionContext getClientSessionContext() {
        return this.clientSessionContext;
    }

    public boolean getEnableSessionCreation() {
        return this.enable_session_creation;
    }

    public String[] getEnabledCipherSuites() {
        return Arrays.asList(this.enabledProtocols).contains("TLSv1.3") ? SSLUtils.concat(NativeCrypto.SUPPORTED_TLS_1_3_CIPHER_SUITES, this.enabledCipherSuites) : (String[]) this.enabledCipherSuites.clone();
    }

    public String[] getEnabledProtocols() {
        return (String[]) this.enabledProtocols.clone();
    }

    public String getEndpointIdentificationAlgorithm() {
        return this.endpointIdentificationAlgorithm;
    }

    public boolean getNeedClientAuth() {
        return this.need_client_auth;
    }

    public byte[] getOCSPResponse() {
        return this.ocspResponse;
    }

    public PSKKeyManager getPSKKeyManager() {
        return this.pskKeyManager;
    }

    public Collection<SNIMatcher> getSNIMatchers() {
        if (this.sniMatchers == null) {
            return null;
        }
        return new ArrayList(this.sniMatchers);
    }

    public AbstractSessionContext getSessionContext() {
        return this.client_mode ? this.clientSessionContext : this.serverSessionContext;
    }

    public boolean getUseCipherSuitesOrder() {
        return this.useCipherSuitesOrder;
    }

    public boolean getUseClientMode() {
        return this.client_mode;
    }

    public boolean getUseSni() {
        Boolean bool = this.useSni;
        return bool != null ? bool.booleanValue() : isSniEnabledByDefault();
    }

    public boolean getWantClientAuth() {
        return this.want_client_auth;
    }

    public X509KeyManager getX509KeyManager() {
        return this.x509KeyManager;
    }

    public X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    public boolean isCTVerificationEnabled(String str) {
        if (str == null) {
            return false;
        }
        if (this.ctVerificationEnabled) {
            return true;
        }
        return Platform.isCTVerificationRequired(str);
    }

    public void setAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.algorithmConstraints = algorithmConstraints;
    }

    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.applicationProtocolSelector = applicationProtocolSelectorAdapter;
    }

    public void setApplicationProtocols(String[] strArr) {
        this.applicationProtocols = SSLUtils.encodeProtocols(strArr);
    }

    public void setCTVerificationEnabled(boolean z4) {
        this.ctVerificationEnabled = z4;
    }

    public void setEnableSessionCreation(boolean z4) {
        this.enable_session_creation = z4;
    }

    public void setEnabledCipherSuites(String[] strArr) {
        this.enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(filterFromCipherSuites(strArr, NativeCrypto.SUPPORTED_TLS_1_3_CIPHER_SUITES_SET));
    }

    public void setEnabledProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        String[] strArrFilterFromProtocols = filterFromProtocols(strArr, "SSLv3");
        this.isEnabledProtocolsFiltered = strArr.length != strArrFilterFromProtocols.length;
        this.enabledProtocols = (String[]) NativeCrypto.checkEnabledProtocols(strArrFilterFromProtocols).clone();
    }

    public void setEndpointIdentificationAlgorithm(String str) {
        this.endpointIdentificationAlgorithm = str;
    }

    public void setNeedClientAuth(boolean z4) {
        this.need_client_auth = z4;
        this.want_client_auth = false;
    }

    public void setOCSPResponse(byte[] bArr) {
        this.ocspResponse = bArr;
    }

    public void setSCTExtension(byte[] bArr) {
        this.sctExtension = bArr;
    }

    public void setSNIMatchers(Collection<SNIMatcher> collection) {
        this.sniMatchers = collection != null ? new ArrayList(collection) : null;
    }

    public void setUseCipherSuitesOrder(boolean z4) {
        this.useCipherSuitesOrder = z4;
    }

    public void setUseClientMode(boolean z4) {
        this.client_mode = z4;
    }

    public void setUseSessionTickets(boolean z4) {
        this.useSessionTickets = z4;
    }

    public void setUseSni(boolean z4) {
        this.useSni = Boolean.valueOf(z4);
    }

    public void setWantClientAuth(boolean z4) {
        this.want_client_auth = z4;
        this.need_client_auth = false;
    }

    private SSLParametersImpl(ClientSessionContext clientSessionContext, ServerSessionContext serverSessionContext, X509KeyManager x509KeyManager, PSKKeyManager pSKKeyManager, X509TrustManager x509TrustManager, SSLParametersImpl sSLParametersImpl) {
        this.client_mode = true;
        this.need_client_auth = false;
        this.want_client_auth = false;
        this.enable_session_creation = true;
        this.applicationProtocols = EmptyArray.BYTE;
        this.clientSessionContext = clientSessionContext;
        this.serverSessionContext = serverSessionContext;
        this.x509KeyManager = x509KeyManager;
        this.pskKeyManager = pSKKeyManager;
        this.x509TrustManager = x509TrustManager;
        String[] strArr = sSLParametersImpl.enabledProtocols;
        this.enabledProtocols = strArr == null ? null : (String[]) strArr.clone();
        this.isEnabledProtocolsFiltered = sSLParametersImpl.isEnabledProtocolsFiltered;
        String[] strArr2 = sSLParametersImpl.enabledCipherSuites;
        this.enabledCipherSuites = strArr2 == null ? null : (String[]) strArr2.clone();
        this.client_mode = sSLParametersImpl.client_mode;
        this.need_client_auth = sSLParametersImpl.need_client_auth;
        this.want_client_auth = sSLParametersImpl.want_client_auth;
        this.enable_session_creation = sSLParametersImpl.enable_session_creation;
        this.endpointIdentificationAlgorithm = sSLParametersImpl.endpointIdentificationAlgorithm;
        this.useCipherSuitesOrder = sSLParametersImpl.useCipherSuitesOrder;
        this.ctVerificationEnabled = sSLParametersImpl.ctVerificationEnabled;
        byte[] bArr = sSLParametersImpl.sctExtension;
        this.sctExtension = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = sSLParametersImpl.ocspResponse;
        this.ocspResponse = bArr2 == null ? null : (byte[]) bArr2.clone();
        byte[] bArr3 = sSLParametersImpl.applicationProtocols;
        this.applicationProtocols = bArr3 != null ? (byte[]) bArr3.clone() : null;
        this.applicationProtocolSelector = sSLParametersImpl.applicationProtocolSelector;
        this.useSessionTickets = sSLParametersImpl.useSessionTickets;
        this.useSni = sSLParametersImpl.useSni;
        this.channelIdEnabled = sSLParametersImpl.channelIdEnabled;
    }
}
