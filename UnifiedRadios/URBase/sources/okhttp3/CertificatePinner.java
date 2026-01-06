package okhttp3;

import E3.a;
import F3.f;
import F3.i;
import F3.j;
import J1.C;
import M3.e;
import M3.m;
import W3.o;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import t3.h;
import t3.k;
import t3.q;
import t3.s;
import t3.u;

/* loaded from: classes.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String str, String... strArr) {
            i.f(str, "pattern");
            i.f(strArr, "pins");
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.AbstractCollection, java.util.LinkedHashSet, java.util.Set] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Set] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.util.Set] */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
        public final CertificatePinner build() {
            s sVar;
            List<Pin> list = this.pins;
            i.f(list, "<this>");
            boolean z4 = list instanceof Collection;
            s sVar2 = s.f9713j;
            if (z4) {
                List<Pin> list2 = list;
                int size = list2.size();
                sVar = sVar2;
                if (size != 0) {
                    if (size != 1) {
                        ?? linkedHashSet = new LinkedHashSet(u.w(list2.size()));
                        t3.i.G(list, linkedHashSet);
                        sVar = linkedHashSet;
                    } else {
                        ?? Singleton = Collections.singleton(list instanceof List ? list.get(0) : list.iterator().next());
                        i.e(Singleton, "singleton(element)");
                        sVar = Singleton;
                    }
                }
            } else {
                ?? linkedHashSet2 = new LinkedHashSet();
                t3.i.G(list, linkedHashSet2);
                int size2 = linkedHashSet2.size();
                sVar = sVar2;
                if (size2 != 0) {
                    if (size2 != 1) {
                        sVar = linkedHashSet2;
                    } else {
                        ?? Singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                        i.e(Singleton2, "singleton(element)");
                        sVar = Singleton2;
                    }
                }
            }
            return new CertificatePinner(sVar, null, 2, false ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final String pin(Certificate certificate) {
            i.f(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).a();
        }

        public final o sha1Hash(X509Certificate x509Certificate) {
            i.f(x509Certificate, "<this>");
            o oVar = o.f2649m;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            i.e(encoded, "publicKey.encoded");
            return C.l(encoded).b("SHA-1");
        }

        public final o sha256Hash(X509Certificate x509Certificate) {
            i.f(x509Certificate, "<this>");
            o oVar = o.f2649m;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            i.e(encoded, "publicKey.encoded");
            return C.l(encoded).b("SHA-256");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final class Pin {
        private final o hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            i.f(str, "pattern");
            i.f(str2, "pin");
            if ((!m.x(str, "*.", false) || e.D(str, "*", 1, false, 4) != -1) && ((!m.x(str, "**.", false) || e.D(str, "*", 2, false, 4) != -1) && e.D(str, "*", 0, false, 6) != -1)) {
                throw new IllegalArgumentException("Unexpected pattern: ".concat(str).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: ".concat(str));
            }
            this.pattern = canonicalHost;
            if (m.x(str2, "sha1/", false)) {
                this.hashAlgorithm = "sha1";
                o oVar = o.f2649m;
                String strSubstring = str2.substring(5);
                i.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                o oVarG = C.g(strSubstring);
                if (oVarG == null) {
                    throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
                }
                this.hash = oVarG;
                return;
            }
            if (!m.x(str2, "sha256/", false)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(str2));
            }
            this.hashAlgorithm = "sha256";
            o oVar2 = o.f2649m;
            String strSubstring2 = str2.substring(7);
            i.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            o oVarG2 = C.g(strSubstring2);
            if (oVarG2 == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(str2));
            }
            this.hash = oVarG2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return i.a(this.pattern, pin.pattern) && i.a(this.hashAlgorithm, pin.hashAlgorithm) && i.a(this.hash, pin.hash);
        }

        public final o getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return this.hash.hashCode() + ((this.hashAlgorithm.hashCode() + (this.pattern.hashCode() * 31)) * 31);
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            i.f(x509Certificate, "certificate");
            String str = this.hashAlgorithm;
            if (i.a(str, "sha256")) {
                return i.a(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
            }
            if (i.a(str, "sha1")) {
                return i.a(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
            }
            return false;
        }

        public final boolean matchesHostname(String str) {
            i.f(str, "hostname");
            if (m.x(this.pattern, "**.", false)) {
                int length = this.pattern.length() - 3;
                int length2 = str.length() - length;
                if (!m.t(str.length() - length, 3, length, str, this.pattern, false)) {
                    return false;
                }
                if (length2 != 0 && str.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!m.x(this.pattern, "*.", false)) {
                    return str.equals(this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = str.length() - length3;
                if (!m.t(str.length() - length3, 1, length3, str, this.pattern, false) || e.F(str, '.', length4 - 1, 4) != -1) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.a();
        }
    }

    /* renamed from: okhttp3.CertificatePinner$check$1, reason: invalid class name */
    public static final class AnonymousClass1 extends j implements a {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List<Certificate> $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends Certificate> list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override // E3.a
        public final List<X509Certificate> invoke() {
            List<Certificate> listClean;
            CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
            if (certificateChainCleaner$okhttp == null || (listClean = certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname)) == null) {
                listClean = this.$peerCertificates;
            }
            ArrayList arrayList = new ArrayList(k.A(listClean));
            for (Certificate certificate : listClean) {
                i.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        i.f(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return Companion.pin(certificate);
    }

    public static final o sha1Hash(X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    public static final o sha256Hash(X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        i.f(str, "hostname");
        i.f(list, "peerCertificates");
        check$okhttp(str, new AnonymousClass1(list, str));
    }

    public final void check$okhttp(String str, a aVar) throws SSLPeerUnverifiedException {
        i.f(str, "hostname");
        i.f(aVar, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(str);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) aVar.invoke();
        for (X509Certificate x509Certificate : list) {
            o oVarSha256Hash = null;
            o oVarSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                if (i.a(hashAlgorithm, "sha256")) {
                    if (oVarSha256Hash == null) {
                        oVarSha256Hash = Companion.sha256Hash(x509Certificate);
                    }
                    if (i.a(pin.getHash(), oVarSha256Hash)) {
                        return;
                    }
                } else {
                    if (!i.a(hashAlgorithm, "sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (oVarSha1Hash == null) {
                        oVarSha1Hash = Companion.sha1Hash(x509Certificate);
                    }
                    if (i.a(pin.getHash(), oVarSha1Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(Companion.pin(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String string = sb.toString();
        i.e(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (i.a(certificatePinner.pins, this.pins) && i.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String str) {
        i.f(str, "hostname");
        Set<Pin> set = this.pins;
        List arrayList = q.f9711j;
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(str)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                F3.o.a(arrayList).add(obj);
            }
        }
        return arrayList;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        i.f(certificateChainCleaner, "certificateChainCleaner");
        return i.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public final void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        i.f(str, "hostname");
        i.f(certificateArr, "peerCertificates");
        check(str, h.y(certificateArr));
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i5, f fVar) {
        this(set, (i5 & 2) != 0 ? null : certificateChainCleaner);
    }
}
