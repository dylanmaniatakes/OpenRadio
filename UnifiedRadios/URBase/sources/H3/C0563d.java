package h3;

import android.util.SparseIntArray;
import com.unified.ur1.R;

/* renamed from: h3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0563d extends AbstractC0562c {

    /* renamed from: q, reason: collision with root package name */
    public static final SparseIntArray f7087q;

    /* renamed from: p, reason: collision with root package name */
    public long f7088p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f7087q = sparseIntArray;
        sparseIntArray.put(R.id.memoryName, 1);
        sparseIntArray.put(R.id.memoryFrequency, 2);
        sparseIntArray.put(R.id.memoryMenu, 3);
    }

    @Override // androidx.databinding.e
    public final void w() {
        synchronized (this) {
            this.f7088p = 0L;
        }
    }

    @Override // androidx.databinding.e
    public final boolean x() {
        synchronized (this) {
            try {
                return this.f7088p != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
