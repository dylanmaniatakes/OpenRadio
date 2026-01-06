package org.conscrypt;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class CertificatePriorityComparator implements Comparator<X509Certificate> {
    private static final Map<String, Integer> ALGORITHM_OID_PRIORITY_MAP;
    private static final Integer PRIORITY_MD5 = 6;
    private static final Integer PRIORITY_SHA1 = 5;
    private static final Integer PRIORITY_SHA224 = 4;
    private static final Integer PRIORITY_SHA256 = 3;
    private static final Integer PRIORITY_SHA384 = 2;
    private static final Integer PRIORITY_SHA512 = 1;
    private static final Integer PRIORITY_UNKNOWN = -1;

    static {
        HashMap map = new HashMap();
        ALGORITHM_OID_PRIORITY_MAP = map;
        map.put("1.2.840.113549.1.1.13", 1);
        map.put("1.2.840.113549.1.1.12", 2);
        map.put("1.2.840.113549.1.1.11", 3);
        map.put("1.2.840.113549.1.1.14", 4);
        map.put("1.2.840.113549.1.1.5", 5);
        map.put("1.2.840.113549.1.1.4", 6);
        map.put("1.2.840.10045.4.3.4", 1);
        map.put("1.2.840.10045.4.3.3", 2);
        map.put("1.2.840.10045.4.3.2", 3);
        map.put("1.2.840.10045.4.3.1", 4);
        map.put("1.2.840.10045.4.1", 5);
    }

    private int compareKeyAlgorithm(PublicKey publicKey, PublicKey publicKey2) {
        String algorithm = publicKey.getAlgorithm();
        if (algorithm.equalsIgnoreCase(publicKey2.getAlgorithm())) {
            return 0;
        }
        return "EC".equalsIgnoreCase(algorithm) ? 1 : -1;
    }

    private int compareKeySize(PublicKey publicKey, PublicKey publicKey2) {
        if (publicKey.getAlgorithm().equalsIgnoreCase(publicKey2.getAlgorithm())) {
            return getKeySize(publicKey) - getKeySize(publicKey2);
        }
        throw new IllegalArgumentException("Keys are not of the same type");
    }

    private int compareSignatureAlgorithm(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        Map<String, Integer> map = ALGORITHM_OID_PRIORITY_MAP;
        Integer num = map.get(x509Certificate.getSigAlgOID());
        Integer num2 = map.get(x509Certificate2.getSigAlgOID());
        if (num == null) {
            num = PRIORITY_UNKNOWN;
        }
        if (num2 == null) {
            num2 = PRIORITY_UNKNOWN;
        }
        return num2.intValue() - num.intValue();
    }

    private int compareStrength(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        PublicKey publicKey = x509Certificate.getPublicKey();
        PublicKey publicKey2 = x509Certificate2.getPublicKey();
        int iCompareKeyAlgorithm = compareKeyAlgorithm(publicKey, publicKey2);
        if (iCompareKeyAlgorithm != 0) {
            return iCompareKeyAlgorithm;
        }
        int iCompareKeySize = compareKeySize(publicKey, publicKey2);
        return iCompareKeySize != 0 ? iCompareKeySize : compareSignatureAlgorithm(x509Certificate, x509Certificate2);
    }

    private int getKeySize(PublicKey publicKey) {
        if (publicKey instanceof ECPublicKey) {
            return ((ECPublicKey) publicKey).getParams().getCurve().getField().getFieldSize();
        }
        if (publicKey instanceof RSAPublicKey) {
            return ((RSAPublicKey) publicKey).getModulus().bitLength();
        }
        throw new IllegalArgumentException("Unsupported public key type: ".concat(publicKey.getClass().getName()));
    }

    @Override // java.util.Comparator
    public int compare(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        boolean zEquals = x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
        boolean zEquals2 = x509Certificate2.getSubjectDN().equals(x509Certificate2.getIssuerDN());
        if (zEquals != zEquals2) {
            return zEquals2 ? 1 : -1;
        }
        int iCompareStrength = compareStrength(x509Certificate2, x509Certificate);
        if (iCompareStrength != 0) {
            return iCompareStrength;
        }
        int iCompareTo = x509Certificate2.getNotAfter().compareTo(x509Certificate.getNotAfter());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        return x509Certificate2.getNotBefore().compareTo(x509Certificate.getNotBefore());
    }
}
