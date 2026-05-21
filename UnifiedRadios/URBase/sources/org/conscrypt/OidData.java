package org.conscrypt;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class OidData {
    private static final Map<String, String> OID_TO_NAME_MAP;

    static {
        HashMap map = new HashMap();
        OID_TO_NAME_MAP = map;
        map.put("1.2.840.113549.1.1.2", "MD2withRSA");
        map.put("1.2.840.113549.1.1.4", "MD5withRSA");
        map.put("1.2.840.113549.1.1.5", "SHA1withRSA");
        map.put("1.2.840.10040.4.3", "SHA1withDSA");
        map.put("1.2.840.10045.4.1", "SHA1withECDSA");
        map.put("1.2.840.113549.1.1.14", "SHA224withRSA");
        map.put("1.2.840.113549.1.1.11", "SHA256withRSA");
        map.put("1.2.840.113549.1.1.12", "SHA384withRSA");
        map.put("1.2.840.113549.1.1.13", "SHA512withRSA");
        map.put("2.16.840.1.101.3.4.3.1", "SHA224withDSA");
        map.put("2.16.840.1.101.3.4.3.2", "SHA256withDSA");
        map.put("1.2.840.10045.4.3.1", "SHA224withECDSA");
        map.put("1.2.840.10045.4.3.2", "SHA256withECDSA");
        map.put("1.2.840.10045.4.3.3", "SHA384withECDSA");
        map.put("1.2.840.10045.4.3.4", "SHA512withECDSA");
    }

    private OidData() {
    }

    public static String oidToAlgorithmName(String str) {
        return OID_TO_NAME_MAP.get(str);
    }
}
