package O;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class E {

    /* renamed from: a, reason: collision with root package name */
    public int f1889a;

    /* renamed from: b, reason: collision with root package name */
    public int f1890b;

    /* renamed from: c, reason: collision with root package name */
    public int f1891c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1892d;

    public E() {
        if (J1.D.f718e == null) {
            J1.D.f718e = new J1.D(18);
        }
    }

    public int a(int i5) {
        if (i5 < this.f1891c) {
            return ((ByteBuffer) this.f1892d).getShort(this.f1890b + i5);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public Object d(View view) {
        if (Build.VERSION.SDK_INT >= this.f1890b) {
            return b(view);
        }
        Object tag = view.getTag(this.f1889a);
        if (((Class) this.f1892d).isInstance(tag)) {
            return tag;
        }
        return null;
    }

    public void e(View view, Object obj) {
        if (Build.VERSION.SDK_INT >= this.f1890b) {
            c(view, obj);
            return;
        }
        if (f(d(view), obj)) {
            View.AccessibilityDelegate accessibilityDelegateB = Y.b(view);
            C0156c c0156c = accessibilityDelegateB == null ? null : accessibilityDelegateB instanceof C0152a ? ((C0152a) accessibilityDelegateB).f1910a : new C0156c(accessibilityDelegateB);
            if (c0156c == null) {
                c0156c = new C0156c();
            }
            Y.k(view, c0156c);
            view.setTag(this.f1889a, obj);
            Y.f(view, this.f1891c);
        }
    }

    public abstract boolean f(Object obj, Object obj2);
}
