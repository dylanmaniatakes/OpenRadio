package org.conscrypt;

import com.unified.ur1.SatelliteTracker.h;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
final class CryptoUpcalls {
    private static final Logger logger = Logger.getLogger(CryptoUpcalls.class.getName());

    private CryptoUpcalls() {
    }

    public static byte[] ecSignDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr) {
        if ("EC".equals(privateKey.getAlgorithm())) {
            return signDigestWithPrivateKey(privateKey, bArr, "NONEwithECDSA");
        }
        throw new RuntimeException("Unexpected key type: " + privateKey.toString());
    }

    private static ArrayList<Provider> getExternalProviders(String str) {
        ArrayList<Provider> arrayList = new ArrayList<>(1);
        for (Provider provider : Security.getProviders(str)) {
            if (!Conscrypt.isConscrypt(provider)) {
                arrayList.add(provider);
            }
        }
        if (arrayList.isEmpty()) {
            logger.warning("Could not find external provider for algorithm: " + str);
        }
        return arrayList;
    }

    public static byte[] rsaDecryptWithPrivateKey(PrivateKey privateKey, int i5, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i5, 2, bArr);
    }

    private static byte[] rsaOpWithPrivateKey(PrivateKey privateKey, int i5, int i6, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String str;
        Cipher cipher;
        String algorithm = privateKey.getAlgorithm();
        if (!"RSA".equals(algorithm)) {
            logger.warning("Unexpected key type: " + algorithm);
            return null;
        }
        if (i5 == 1) {
            str = "PKCS1Padding";
        } else if (i5 == 3) {
            str = "NoPadding";
        } else {
            if (i5 != 4) {
                logger.warning("Unsupported OpenSSL/BoringSSL padding: " + i5);
                return null;
            }
            str = "OAEPPadding";
        }
        String strConcat = "RSA/ECB/".concat(str);
        try {
            cipher = Cipher.getInstance(strConcat);
            cipher.init(i6, privateKey);
        } catch (InvalidKeyException e5) {
            logger.log(Level.WARNING, "Preferred provider doesn't support key:", (Throwable) e5);
        } catch (NoSuchAlgorithmException unused) {
            logger.warning("Unsupported cipher algorithm: " + strConcat);
            return null;
        } catch (NoSuchPaddingException unused2) {
            logger.warning("Unsupported cipher algorithm: " + strConcat);
            return null;
        }
        if (Conscrypt.isConscrypt(cipher.getProvider())) {
            cipher = null;
        }
        if (cipher == null) {
            Iterator<Provider> it = getExternalProviders(h.s("Cipher.", strConcat)).iterator();
            while (it.hasNext()) {
                try {
                    cipher = Cipher.getInstance(strConcat, it.next());
                    cipher.init(i6, privateKey);
                    break;
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException unused3) {
                    cipher = null;
                }
            }
            if (cipher == null) {
                logger.warning("Could not find provider for algorithm: " + strConcat);
                return null;
            }
        }
        try {
            return cipher.doFinal(bArr);
        } catch (Exception e6) {
            logger.log(Level.WARNING, "Exception while decrypting message with " + privateKey.getAlgorithm() + " private key using " + strConcat + ":", (Throwable) e6);
            return null;
        }
    }

    public static byte[] rsaSignDigestWithPrivateKey(PrivateKey privateKey, int i5, byte[] bArr) {
        return rsaOpWithPrivateKey(privateKey, i5, 1, bArr);
    }

    private static byte[] signDigestWithPrivateKey(PrivateKey privateKey, byte[] bArr, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Signature signature;
        try {
            signature = Signature.getInstance(str);
            signature.initSign(privateKey);
        } catch (InvalidKeyException e5) {
            logger.warning("Preferred provider doesn't support key:");
            e5.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
            logger.warning("Unsupported signature algorithm: " + str);
            return null;
        }
        if (Conscrypt.isConscrypt(signature.getProvider())) {
            signature = null;
        }
        if (signature == null) {
            Iterator<Provider> it = getExternalProviders(h.s("Signature.", str)).iterator();
            RuntimeException runtimeException = null;
            while (it.hasNext()) {
                try {
                    signature = Signature.getInstance(str, it.next());
                    signature.initSign(privateKey);
                    break;
                } catch (RuntimeException e6) {
                    if (runtimeException == null) {
                        runtimeException = e6;
                    }
                    signature = null;
                } catch (InvalidKeyException | NoSuchAlgorithmException unused2) {
                    signature = null;
                }
            }
            if (signature == null) {
                if (runtimeException != null) {
                    throw runtimeException;
                }
                logger.warning("Could not find provider for algorithm: " + str);
                return null;
            }
        }
        try {
            signature.update(bArr);
            return signature.sign();
        } catch (Exception e7) {
            logger.log(Level.WARNING, "Exception while signing message with " + privateKey.getAlgorithm() + " private key:", (Throwable) e7);
            return null;
        }
    }
}
