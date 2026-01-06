package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes.dex */
public class OpenSSLEvpCipherARC4 extends OpenSSLEvpCipher {
    public OpenSSLEvpCipherARC4() {
        super(OpenSSLCipher.Mode.ECB, OpenSSLCipher.Padding.NOPADDING);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i5) throws InvalidKeyException {
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedMode(OpenSSLCipher.Mode mode) throws NoSuchAlgorithmException {
        if (mode == OpenSSLCipher.Mode.NONE || mode == OpenSSLCipher.Mode.ECB) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedPadding(OpenSSLCipher.Padding padding) throws NoSuchPaddingException {
        if (padding == OpenSSLCipher.Padding.NOPADDING) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "ARCFOUR";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 0;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    public String getCipherName(int i5, OpenSSLCipher.Mode mode) {
        return "rc4";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public boolean supportsVariableSizeKey() {
        return true;
    }
}
