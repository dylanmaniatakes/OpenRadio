package k4;

/* loaded from: classes.dex */
public final class m implements k {

    /* renamed from: j, reason: collision with root package name */
    public long[] f8283j;

    /* renamed from: k, reason: collision with root package name */
    public int f8284k;

    @Override // k4.k
    public final boolean a(long j5) {
        if (this.f8283j == null) {
            return false;
        }
        for (int i5 = 0; i5 < this.f8284k; i5++) {
            if (this.f8283j[i5] == j5) {
                return true;
            }
        }
        return false;
    }

    public final void b(int i5) {
        if (i5 == 0) {
            return;
        }
        long[] jArr = this.f8283j;
        if (jArr == null || jArr.length < i5) {
            synchronized (this) {
                try {
                    long[] jArr2 = new long[i5];
                    long[] jArr3 = this.f8283j;
                    if (jArr3 != null) {
                        System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
                    }
                    this.f8283j = jArr2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
