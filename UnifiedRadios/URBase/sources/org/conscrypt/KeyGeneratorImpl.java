package org.conscrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class KeyGeneratorImpl extends KeyGeneratorSpi {
    private final String algorithm;
    private int keySizeBits;
    protected SecureRandom secureRandom;

    public static final class AES extends KeyGeneratorImpl {
        public AES() {
            super("AES", 128);
        }

        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i5) {
            if (i5 != 128 && i5 != 192 && i5 != 256) {
                throw new InvalidParameterException("Key size must be either 128, 192, or 256 bits");
            }
        }
    }

    public static final class ARC4 extends KeyGeneratorImpl {
        public ARC4() {
            super("ARC4", 128);
        }

        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i5) {
            if (i5 < 40 || 2048 < i5) {
                throw new InvalidParameterException("Key size must be between 40 and 2048 bits");
            }
        }
    }

    public static final class ChaCha20 extends KeyGeneratorImpl {
        public ChaCha20() {
            super("ChaCha20", PSKKeyManager.MAX_KEY_LENGTH_BYTES);
        }

        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i5) {
            if (i5 != 256) {
                throw new InvalidParameterException("Key size must be 256 bits");
            }
        }
    }

    public static final class DESEDE extends KeyGeneratorImpl {
        public DESEDE() {
            super("DESEDE", 192);
        }

        @Override // org.conscrypt.KeyGeneratorImpl
        public void checkKeySize(int i5) {
            if (i5 != 112 && i5 != 168) {
                throw new InvalidParameterException("Key size must be either 112 or 168 bits");
            }
        }

        @Override // org.conscrypt.KeyGeneratorImpl
        public byte[] doKeyGeneration(int i5) {
            byte[] bArr = new byte[24];
            this.secureRandom.nextBytes(bArr);
            for (int i6 = 0; i6 < 24; i6++) {
                if (Integer.bitCount(bArr[i6]) % 2 == 0) {
                    bArr[i6] = (byte) (bArr[i6] ^ 1);
                }
            }
            if (i5 == 14) {
                System.arraycopy(bArr, 0, bArr, 16, 8);
            }
            return bArr;
        }
    }

    public static final class HmacMD5 extends KeyGeneratorImpl {
        public HmacMD5() {
            super("HmacMD5", 128);
        }
    }

    public static final class HmacSHA1 extends KeyGeneratorImpl {
        public HmacSHA1() {
            super("HmacSHA1", 160);
        }
    }

    public static final class HmacSHA224 extends KeyGeneratorImpl {
        public HmacSHA224() {
            super("HmacSHA224", 224);
        }
    }

    public static final class HmacSHA256 extends KeyGeneratorImpl {
        public HmacSHA256() {
            super("HmacSHA256", PSKKeyManager.MAX_KEY_LENGTH_BYTES);
        }
    }

    public static final class HmacSHA384 extends KeyGeneratorImpl {
        public HmacSHA384() {
            super("HmacSHA384", 384);
        }
    }

    public static final class HmacSHA512 extends KeyGeneratorImpl {
        public HmacSHA512() {
            super("HmacSHA512", 512);
        }
    }

    public void checkKeySize(int i5) {
        if (i5 <= 0) {
            throw new InvalidParameterException("Key size must be positive");
        }
    }

    public byte[] doKeyGeneration(int i5) {
        byte[] bArr = new byte[i5];
        this.secureRandom.nextBytes(bArr);
        return bArr;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() {
        if (this.secureRandom == null) {
            this.secureRandom = new SecureRandom();
        }
        return new SecretKeySpec(doKeyGeneration((this.keySizeBits + 7) / 8), this.algorithm);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    private KeyGeneratorImpl(String str, int i5) {
        this.algorithm = str;
        this.keySizeBits = i5;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("Unknown param type: ".concat(algorithmParameterSpec.getClass().getName()));
        }
        throw new InvalidAlgorithmParameterException("No params provided");
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i5, SecureRandom secureRandom) {
        checkKeySize(i5);
        this.keySizeBits = i5;
        this.secureRandom = secureRandom;
    }
}
