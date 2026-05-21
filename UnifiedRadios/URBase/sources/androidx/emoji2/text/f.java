package androidx.emoji2.text;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.I;
import androidx.recyclerview.widget.X;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public int f3603a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3604b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3605c;

    public f(X x4) {
        this.f3603a = Integer.MIN_VALUE;
        this.f3605c = new Rect();
        this.f3604b = x4;
    }

    public static f a(X x4, int i5) {
        if (i5 == 0) {
            return new I(x4, 0);
        }
        if (i5 == 1) {
            return new I(x4, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public int m() {
        if (Integer.MIN_VALUE == this.f3603a) {
            return 0;
        }
        return l() - this.f3603a;
    }

    public abstract int n(View view);

    public abstract int o(View view);

    public abstract void p(int i5);

    public f(i iVar) {
        this.f3603a = 0;
        this.f3605c = new c();
        this.f3604b = iVar;
    }
}
