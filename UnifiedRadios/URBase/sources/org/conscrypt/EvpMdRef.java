package org.conscrypt;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: classes.dex */
final class EvpMdRef {
    static final String MGF1_ALGORITHM_NAME = "MGF1";
    static final String MGF1_OID = "1.2.840.113549.1.1.8";

    public static final class MD5 {
        static final long EVP_MD;
        static final String JCA_NAME = "MD5";
        static final String OID = "1.2.840.113549.2.5";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("md5");
            EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private MD5() {
        }
    }

    public static final class SHA1 {
        static final long EVP_MD;
        static final String JCA_NAME = "SHA-1";
        static final String OID = "1.3.14.3.2.26";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha1");
            EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private SHA1() {
        }
    }

    public static final class SHA224 {
        static final long EVP_MD;
        static final String JCA_NAME = "SHA-224";
        static final String OID = "2.16.840.1.101.3.4.2.4";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha224");
            EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private SHA224() {
        }
    }

    public static final class SHA256 {
        static final long EVP_MD;
        static final String JCA_NAME = "SHA-256";
        static final String OID = "2.16.840.1.101.3.4.2.1";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha256");
            EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private SHA256() {
        }
    }

    public static final class SHA384 {
        static final long EVP_MD;
        static final String JCA_NAME = "SHA-384";
        static final String OID = "2.16.840.1.101.3.4.2.2";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha384");
            EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private SHA384() {
        }
    }

    public static final class SHA512 {
        static final long EVP_MD;
        static final String JCA_NAME = "SHA-512";
        static final String OID = "2.16.840.1.101.3.4.2.3";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha512");
            EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private SHA512() {
        }
    }

    private EvpMdRef() {
    }

    public static int getDigestSizeBytesByJcaDigestAlgorithmStandardName(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.US);
        if ("SHA-256".equals(upperCase)) {
            return SHA256.SIZE_BYTES;
        }
        if ("SHA-512".equals(upperCase)) {
            return SHA512.SIZE_BYTES;
        }
        if ("SHA-1".equals(upperCase)) {
            return SHA1.SIZE_BYTES;
        }
        if ("SHA-384".equals(upperCase)) {
            return SHA384.SIZE_BYTES;
        }
        if ("SHA-224".equals(upperCase)) {
            return SHA224.SIZE_BYTES;
        }
        throw new NoSuchAlgorithmException("Unsupported algorithm: ".concat(str));
    }

    public static long getEVP_MDByJcaDigestAlgorithmStandardName(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.US);
        if ("SHA-256".equals(upperCase)) {
            return SHA256.EVP_MD;
        }
        if ("SHA-512".equals(upperCase)) {
            return SHA512.EVP_MD;
        }
        if ("SHA-1".equals(upperCase)) {
            return SHA1.EVP_MD;
        }
        if ("SHA-384".equals(upperCase)) {
            return SHA384.EVP_MD;
        }
        if ("SHA-224".equals(upperCase)) {
            return SHA224.EVP_MD;
        }
        throw new NoSuchAlgorithmException("Unsupported algorithm: ".concat(str));
    }

    public static String getJcaDigestAlgorithmStandardName(String str) {
        String upperCase = str.toUpperCase(Locale.US);
        String str2 = "SHA-256";
        if (!"SHA-256".equals(upperCase) && !"2.16.840.1.101.3.4.2.1".equals(upperCase)) {
            str2 = "SHA-512";
            if (!"SHA-512".equals(upperCase) && !"2.16.840.1.101.3.4.2.3".equals(upperCase)) {
                str2 = "SHA-1";
                if (!"SHA-1".equals(upperCase) && !"1.3.14.3.2.26".equals(upperCase)) {
                    str2 = "SHA-384";
                    if (!"SHA-384".equals(upperCase) && !"2.16.840.1.101.3.4.2.2".equals(upperCase)) {
                        str2 = "SHA-224";
                        if (!"SHA-224".equals(upperCase) && !"2.16.840.1.101.3.4.2.4".equals(upperCase)) {
                            return null;
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static String getJcaDigestAlgorithmStandardNameFromEVP_MD(long j5) {
        if (j5 == MD5.EVP_MD) {
            return "MD5";
        }
        if (j5 == SHA1.EVP_MD) {
            return "SHA-1";
        }
        if (j5 == SHA224.EVP_MD) {
            return "SHA-224";
        }
        if (j5 == SHA256.EVP_MD) {
            return "SHA-256";
        }
        if (j5 == SHA384.EVP_MD) {
            return "SHA-384";
        }
        if (j5 == SHA512.EVP_MD) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("Unknown EVP_MD reference");
    }
}
