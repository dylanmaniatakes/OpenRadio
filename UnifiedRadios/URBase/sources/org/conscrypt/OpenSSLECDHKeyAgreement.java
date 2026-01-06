package org.conscrypt;

import com.unified.ur1.SatelliteTracker.h;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.conscrypt.NativeRef;

/* loaded from: classes.dex */
public final class OpenSSLECDHKeyAgreement extends KeyAgreementSpi {
    private int mExpectedResultLength;
    private OpenSSLKey mOpenSslPrivateKey;
    private byte[] mResult;

    private void checkCompleted() {
        if (this.mResult == null) {
            throw new IllegalStateException("Key agreement not completed");
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z4) throws IndexOutOfBoundsException, InvalidKeyException {
        if (this.mOpenSslPrivateKey == null) {
            throw new IllegalStateException("Not initialized");
        }
        if (!z4) {
            throw new IllegalStateException("ECDH only has one phase");
        }
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        if (!(key instanceof PublicKey)) {
            throw new InvalidKeyException("Not a public key: " + key.getClass());
        }
        OpenSSLKey openSSLKeyFromPublicKey = OpenSSLKey.fromPublicKey((PublicKey) key);
        byte[] bArr = new byte[this.mExpectedResultLength];
        int iECDH_compute_key = NativeCrypto.ECDH_compute_key(bArr, 0, openSSLKeyFromPublicKey.getNativeRef(), this.mOpenSslPrivateKey.getNativeRef());
        if (iECDH_compute_key == -1) {
            throw new RuntimeException(h.a(iECDH_compute_key, "Engine returned "));
        }
        int i5 = this.mExpectedResultLength;
        if (iECDH_compute_key != i5) {
            if (iECDH_compute_key >= i5) {
                throw new RuntimeException("Engine produced a longer than expected result. Expected: " + this.mExpectedResultLength + ", actual: " + iECDH_compute_key);
            }
            byte[] bArr2 = this.mResult;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            bArr = new byte[iECDH_compute_key];
        }
        this.mResult = bArr;
        return null;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i5) throws ShortBufferException {
        checkCompleted();
        int length = bArr.length - i5;
        byte[] bArr2 = this.mResult;
        if (bArr2.length <= length) {
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            return this.mResult.length;
        }
        throw new ShortBufferWithoutStackTraceException("Needed: " + this.mResult.length + ", available: " + length);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        if (!(key instanceof PrivateKey)) {
            throw new InvalidKeyException("Not a private key: " + key.getClass());
        }
        OpenSSLKey openSSLKeyFromPrivateKey = OpenSSLKey.fromPrivateKey((PrivateKey) key);
        this.mExpectedResultLength = (NativeCrypto.EC_GROUP_get_degree(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(openSSLKeyFromPrivateKey.getNativeRef()))) + 7) / 8;
        this.mOpenSslPrivateKey = openSSLKeyFromPrivateKey;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        checkCompleted();
        return this.mResult;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        checkCompleted();
        return new SecretKeySpec(engineGenerateSecret(), str);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            engineInit(key, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }
}
