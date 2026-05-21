package org.conscrypt.ct;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import org.conscrypt.ct.VerifiedSCT;

/* loaded from: classes.dex */
public class CTLogInfo {
    private final String description;
    private final byte[] logId;
    private final PublicKey publicKey;
    private final String url;

    public CTLogInfo(PublicKey publicKey, String str, String str2) {
        try {
            this.logId = MessageDigest.getInstance("SHA-256").digest(publicKey.getEncoded());
            this.publicKey = publicKey;
            this.description = str;
            this.url = str2;
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CTLogInfo)) {
            return false;
        }
        CTLogInfo cTLogInfo = (CTLogInfo) obj;
        return this.publicKey.equals(cTLogInfo.publicKey) && this.description.equals(cTLogInfo.description) && this.url.equals(cTLogInfo.url);
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getID() {
        return this.logId;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode() + ((this.description.hashCode() + ((this.publicKey.hashCode() + 31) * 31)) * 31);
    }

    public VerifiedSCT.Status verifySingleSCT(SignedCertificateTimestamp signedCertificateTimestamp, CertificateEntry certificateEntry) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (!Arrays.equals(signedCertificateTimestamp.getLogID(), getID())) {
            return VerifiedSCT.Status.UNKNOWN_LOG;
        }
        try {
            byte[] bArrEncodeTBS = signedCertificateTimestamp.encodeTBS(certificateEntry);
            try {
                Signature signature = Signature.getInstance(signedCertificateTimestamp.getSignature().getAlgorithm());
                try {
                    signature.initVerify(this.publicKey);
                    try {
                        signature.update(bArrEncodeTBS);
                        return !signature.verify(signedCertificateTimestamp.getSignature().getSignature()) ? VerifiedSCT.Status.INVALID_SIGNATURE : VerifiedSCT.Status.VALID;
                    } catch (SignatureException e5) {
                        throw new RuntimeException(e5);
                    }
                } catch (InvalidKeyException unused) {
                    return VerifiedSCT.Status.INVALID_SCT;
                }
            } catch (NoSuchAlgorithmException unused2) {
                return VerifiedSCT.Status.INVALID_SCT;
            }
        } catch (SerializationException unused3) {
            return VerifiedSCT.Status.INVALID_SCT;
        }
    }
}
