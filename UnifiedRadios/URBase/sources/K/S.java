package k;

import android.graphics.Typeface;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class S extends D.b {
    public final /* synthetic */ int h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7693i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ WeakReference f7694j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ X f7695k;

    public S(X x4, int i5, int i6, WeakReference weakReference) {
        this.f7695k = x4;
        this.h = i5;
        this.f7693i = i6;
        this.f7694j = weakReference;
    }

    @Override // D.b
    public final void g(int i5) {
    }

    @Override // D.b
    public final void h(Typeface typeface) {
        int i5 = this.h;
        if (i5 != -1) {
            typeface = W.a(typeface, i5, (this.f7693i & 2) != 0);
        }
        X x4 = this.f7695k;
        if (x4.f7738m) {
            x4.f7737l = typeface;
            TextView textView = (TextView) this.f7694j.get();
            if (textView != null) {
                WeakHashMap weakHashMap = O.Y.f1904a;
                if (O.J.b(textView)) {
                    textView.post(new F0.j(textView, typeface, x4.f7735j, 5));
                } else {
                    textView.setTypeface(typeface, x4.f7735j);
                }
            }
        }
    }
}
