package org.conscrypt;

import com.unified.ur1.SatelliteTracker.h;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes.dex */
public abstract class OpenSSLEvpCipher extends OpenSSLCipher {
    private boolean calledUpdate;
    private final NativeRef.EVP_CIPHER_CTX cipherCtx;
    private int modeBlockSize;

    public OpenSSLEvpCipher(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
        this.cipherCtx = new NativeRef.EVP_CIPHER_CTX(NativeCrypto.EVP_CIPHER_CTX_new());
    }

    private void reset() {
        NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0L, this.encodedKey, this.iv, isEncrypting());
        this.calledUpdate = false;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int doFinalInternal(byte[] bArr, int i5, int i6) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int iEVP_CipherFinal_ex;
        if (!isEncrypting() && !this.calledUpdate) {
            return 0;
        }
        int length = bArr.length - i5;
        if (length >= i6) {
            iEVP_CipherFinal_ex = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr, i5);
        } else {
            byte[] bArr2 = new byte[i6];
            int iEVP_CipherFinal_ex2 = NativeCrypto.EVP_CipherFinal_ex(this.cipherCtx, bArr2, 0);
            if (iEVP_CipherFinal_ex2 > length) {
                throw new ShortBufferWithoutStackTraceException(h.c("buffer is too short: ", " > ", iEVP_CipherFinal_ex2, length));
            }
            if (iEVP_CipherFinal_ex2 > 0) {
                System.arraycopy(bArr2, 0, bArr, i5, iEVP_CipherFinal_ex2);
            }
            iEVP_CipherFinal_ex = iEVP_CipherFinal_ex2;
        }
        reset();
        return (iEVP_CipherFinal_ex + i5) - i5;
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void engineInitInternal(byte[] bArr, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] iv = algorithmParameterSpec instanceof IvParameterSpec ? ((IvParameterSpec) algorithmParameterSpec).getIV() : null;
        long jEVP_get_cipherbyname = NativeCrypto.EVP_get_cipherbyname(getCipherName(bArr.length, this.mode));
        if (jEVP_get_cipherbyname == 0) {
            throw new InvalidAlgorithmParameterException("Cannot find name for key length = " + (bArr.length * 8) + " and mode = " + this.mode);
        }
        boolean zIsEncrypting = isEncrypting();
        int iEVP_CIPHER_iv_length = NativeCrypto.EVP_CIPHER_iv_length(jEVP_get_cipherbyname);
        if (iv != null || iEVP_CIPHER_iv_length == 0) {
            if (iEVP_CIPHER_iv_length == 0 && iv != null) {
                throw new InvalidAlgorithmParameterException("IV not used in " + this.mode + " mode");
            }
            if (iv != null && iv.length != iEVP_CIPHER_iv_length) {
                StringBuilder sbF = h.f("expected IV length of ", iEVP_CIPHER_iv_length, " but was ");
                sbF.append(iv.length);
                throw new InvalidAlgorithmParameterException(sbF.toString());
            }
        } else {
            if (!zIsEncrypting) {
                throw new InvalidAlgorithmParameterException("IV must be specified in " + this.mode + " mode");
            }
            iv = new byte[iEVP_CIPHER_iv_length];
            if (secureRandom != null) {
                secureRandom.nextBytes(iv);
            } else {
                NativeCrypto.RAND_bytes(iv);
            }
        }
        this.iv = iv;
        if (supportsVariableSizeKey()) {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, jEVP_get_cipherbyname, null, null, zIsEncrypting);
            NativeCrypto.EVP_CIPHER_CTX_set_key_length(this.cipherCtx, bArr.length);
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, 0L, bArr, iv, isEncrypting());
        } else {
            NativeCrypto.EVP_CipherInit_ex(this.cipherCtx, jEVP_get_cipherbyname, bArr, iv, zIsEncrypting);
        }
        NativeCrypto.EVP_CIPHER_CTX_set_padding(this.cipherCtx, getPadding() == OpenSSLCipher.Padding.PKCS5PADDING);
        this.modeBlockSize = NativeCrypto.EVP_CIPHER_CTX_block_size(this.cipherCtx);
        this.calledUpdate = false;
    }

    public abstract String getCipherName(int i5, OpenSSLCipher.Mode mode);

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i5) {
        if (this.modeBlockSize == 1) {
            return i5;
        }
        int i6 = NativeCrypto.get_EVP_CIPHER_CTX_buf_len(this.cipherCtx);
        if (getPadding() == OpenSSLCipher.Padding.NOPADDING) {
            return i6 + i5;
        }
        int i7 = i5 + i6 + (NativeCrypto.get_EVP_CIPHER_CTX_final_used(this.cipherCtx) ? this.modeBlockSize : 0);
        int i8 = i7 + ((i7 % this.modeBlockSize != 0 || isEncrypting()) ? this.modeBlockSize : 0);
        return i8 - (i8 % this.modeBlockSize);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getOutputSizeForUpdate(int i5) {
        return getOutputSizeForFinal(i5);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int updateInternal(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8) throws ShortBufferException {
        int length = bArr2.length - i7;
        if (length < i8) {
            throw new ShortBufferWithoutStackTraceException(h.c("output buffer too small during update: ", " < ", length, i8));
        }
        int iEVP_CipherUpdate = NativeCrypto.EVP_CipherUpdate(this.cipherCtx, bArr2, i7, bArr, i5, i6) + i7;
        this.calledUpdate = true;
        return iEVP_CipherUpdate - i7;
    }
}
