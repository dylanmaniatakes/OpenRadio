package org.conscrypt.ct;

import com.unified.ur1.SatelliteTracker.h;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class DigitallySigned {
    private final HashAlgorithm hashAlgorithm;
    private final byte[] signature;
    private final SignatureAlgorithm signatureAlgorithm;

    public enum HashAlgorithm {
        NONE,
        MD5,
        SHA1,
        SHA224,
        SHA256,
        SHA384,
        SHA512;

        private static HashAlgorithm[] values = values();

        public static HashAlgorithm valueOf(int i5) {
            try {
                return values[i5];
            } catch (IndexOutOfBoundsException e5) {
                throw new IllegalArgumentException(h.a(i5, "Invalid hash algorithm "), e5);
            }
        }
    }

    public enum SignatureAlgorithm {
        ANONYMOUS,
        RSA,
        DSA,
        ECDSA;

        private static SignatureAlgorithm[] values = values();

        public static SignatureAlgorithm valueOf(int i5) {
            try {
                return values[i5];
            } catch (IndexOutOfBoundsException e5) {
                throw new IllegalArgumentException(h.a(i5, "Invalid signature algorithm "), e5);
            }
        }
    }

    public DigitallySigned(HashAlgorithm hashAlgorithm, SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this.hashAlgorithm = hashAlgorithm;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signature = bArr;
    }

    public static DigitallySigned decode(InputStream inputStream) throws SerializationException {
        try {
            return new DigitallySigned(Serialization.readNumber(inputStream, 1), Serialization.readNumber(inputStream, 1), Serialization.readVariableBytes(inputStream, 2));
        } catch (IllegalArgumentException e5) {
            throw new SerializationException(e5);
        }
    }

    public String getAlgorithm() {
        return this.hashAlgorithm + "with" + this.signatureAlgorithm;
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public SignatureAlgorithm getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public DigitallySigned(int i5, int i6, byte[] bArr) {
        this(HashAlgorithm.valueOf(i5), SignatureAlgorithm.valueOf(i6), bArr);
    }

    public static DigitallySigned decode(byte[] bArr) throws SerializationException {
        return decode(new ByteArrayInputStream(bArr));
    }
}
