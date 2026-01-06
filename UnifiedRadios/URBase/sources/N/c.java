package N;

import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1756a;

    /* renamed from: b, reason: collision with root package name */
    public int f1757b;

    public c(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1756a = new Object[i5];
    }

    public Object a() {
        int i5 = this.f1757b;
        if (i5 <= 0) {
            return null;
        }
        int i6 = i5 - 1;
        Object[] objArr = this.f1756a;
        Object obj = objArr[i6];
        objArr[i6] = null;
        this.f1757b = i5 - 1;
        return obj;
    }

    public void b(Object obj) {
        int i5 = this.f1757b;
        Object[] objArr = this.f1756a;
        if (i5 < objArr.length) {
            objArr[i5] = obj;
            this.f1757b = i5 + 1;
        }
    }

    public boolean c(Object obj) {
        int i5 = 0;
        while (true) {
            int i6 = this.f1757b;
            Object[] objArr = this.f1756a;
            if (i5 >= i6) {
                if (i6 >= objArr.length) {
                    return false;
                }
                objArr[i6] = obj;
                this.f1757b = i6 + 1;
                return true;
            }
            if (objArr[i5] == obj) {
                throw new IllegalStateException("Already in the pool!");
            }
            i5++;
        }
    }

    public c() {
        this.f1756a = new Object[PSKKeyManager.MAX_KEY_LENGTH_BYTES];
    }
}
