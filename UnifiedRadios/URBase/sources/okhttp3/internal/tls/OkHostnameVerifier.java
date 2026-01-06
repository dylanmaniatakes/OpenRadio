package okhttp3.internal.tls;

import F3.i;
import M3.e;
import M3.m;
import com.unified.ur1.SatelliteTracker.h;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import t3.q;

/* loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        i.e(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        i.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i5) throws CertificateParsingException {
        Object obj;
        q qVar = q.f9711j;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return qVar;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && i.a(list.get(0), Integer.valueOf(i5)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return qVar;
        }
    }

    private final boolean isAscii(String str) {
        int i5;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(h.c("endIndex < beginIndex: ", " < ", length2, 0).toString());
        }
        if (length2 > str.length()) {
            StringBuilder sbF = h.f("endIndex > string.length: ", length2, " > ");
            sbF.append(str.length());
            throw new IllegalArgumentException(sbF.toString().toString());
        }
        long j5 = 0;
        int i6 = 0;
        while (i6 < length2) {
            char cCharAt = str.charAt(i6);
            if (cCharAt < 128) {
                j5++;
            } else {
                if (cCharAt < 2048) {
                    i5 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i5 = 3;
                } else {
                    int i7 = i6 + 1;
                    char cCharAt2 = i7 < length2 ? str.charAt(i7) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j5++;
                        i6 = i7;
                    } else {
                        j5 += 4;
                        i6 += 2;
                    }
                }
                j5 += i5;
            }
            i6++;
        }
        return length == ((int) j5);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strAsciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(strAsciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (i.a(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        i.f(x509Certificate, "certificate");
        return t3.i.F(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        i.f(str, "host");
        i.f(sSLSession, "session");
        if (!isAscii(str)) {
            return false;
        }
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            i.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(str, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String str, X509Certificate x509Certificate) {
        i.f(str, "host");
        i.f(x509Certificate, "certificate");
        return Util.canParseAsIpAddress(str) ? verifyIpAddress(str, x509Certificate) : verifyHostname(str, x509Certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !m.x(str, ".", false) && !m.q(str, "..") && str2 != null && str2.length() != 0 && !m.x(str2, ".", false) && !m.q(str2, "..")) {
            if (!m.q(str, ".")) {
                str = str.concat(".");
            }
            if (!m.q(str2, ".")) {
                str2 = str2.concat(".");
            }
            String strAsciiToLowercase = asciiToLowercase(str2);
            if (!e.z(strAsciiToLowercase, "*")) {
                return i.a(str, strAsciiToLowercase);
            }
            if (!m.x(strAsciiToLowercase, "*.", false) || e.C(strAsciiToLowercase, '*', 1, false, 4) != -1 || str.length() < strAsciiToLowercase.length() || "*.".equals(strAsciiToLowercase)) {
                return false;
            }
            String strSubstring = strAsciiToLowercase.substring(1);
            i.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (!m.q(str, strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || e.F(str, '.', length - 1, 4) == -1;
        }
        return false;
    }
}
