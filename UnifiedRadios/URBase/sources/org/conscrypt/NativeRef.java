package org.conscrypt;

/* loaded from: classes.dex */
abstract class NativeRef {
    final long address;

    public static final class EC_GROUP extends NativeRef {
        public EC_GROUP(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.EC_GROUP_clear_free(j5);
        }
    }

    public static final class EC_POINT extends NativeRef {
        public EC_POINT(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.EC_POINT_clear_free(j5);
        }
    }

    public static final class EVP_CIPHER_CTX extends NativeRef {
        public EVP_CIPHER_CTX(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.EVP_CIPHER_CTX_free(j5);
        }
    }

    public static final class EVP_MD_CTX extends NativeRef {
        public EVP_MD_CTX(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.EVP_MD_CTX_destroy(j5);
        }
    }

    public static final class EVP_PKEY extends NativeRef {
        public EVP_PKEY(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.EVP_PKEY_free(j5);
        }
    }

    public static final class EVP_PKEY_CTX extends NativeRef {
        public EVP_PKEY_CTX(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.EVP_PKEY_CTX_free(j5);
        }
    }

    public static final class HMAC_CTX extends NativeRef {
        public HMAC_CTX(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.HMAC_CTX_free(j5);
        }
    }

    public static final class SSL_SESSION extends NativeRef {
        public SSL_SESSION(long j5) {
            super(j5);
        }

        @Override // org.conscrypt.NativeRef
        public void doFree(long j5) {
            NativeCrypto.SSL_SESSION_free(j5);
        }
    }

    public NativeRef(long j5) {
        if (j5 == 0) {
            throw new NullPointerException("address == 0");
        }
        this.address = j5;
    }

    public abstract void doFree(long j5);

    public boolean equals(Object obj) {
        return (obj instanceof NativeRef) && ((NativeRef) obj).address == this.address;
    }

    public void finalize() throws Throwable {
        try {
            long j5 = this.address;
            if (j5 != 0) {
                doFree(j5);
            }
        } finally {
            super.finalize();
        }
    }

    public int hashCode() {
        long j5 = this.address;
        return (int) (j5 ^ (j5 >>> 32));
    }
}
