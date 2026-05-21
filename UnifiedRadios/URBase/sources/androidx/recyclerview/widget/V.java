package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4172a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ X f4173b;

    public /* synthetic */ V(X x4, int i5) {
        this.f4172a = i5;
        this.f4173b = x4;
    }

    public final View a(int i5) {
        switch (this.f4172a) {
        }
        return this.f4173b.u(i5);
    }

    public final int b(View view) {
        switch (this.f4172a) {
            case 0:
                Y y4 = (Y) view.getLayoutParams();
                this.f4173b.getClass();
                return view.getRight() + ((Y) view.getLayoutParams()).f4191b.right + ((ViewGroup.MarginLayoutParams) y4).rightMargin;
            default:
                Y y5 = (Y) view.getLayoutParams();
                this.f4173b.getClass();
                return view.getBottom() + ((Y) view.getLayoutParams()).f4191b.bottom + ((ViewGroup.MarginLayoutParams) y5).bottomMargin;
        }
    }

    public final int c(View view) {
        switch (this.f4172a) {
            case 0:
                Y y4 = (Y) view.getLayoutParams();
                this.f4173b.getClass();
                return (view.getLeft() - ((Y) view.getLayoutParams()).f4191b.left) - ((ViewGroup.MarginLayoutParams) y4).leftMargin;
            default:
                Y y5 = (Y) view.getLayoutParams();
                this.f4173b.getClass();
                return (view.getTop() - ((Y) view.getLayoutParams()).f4191b.top) - ((ViewGroup.MarginLayoutParams) y5).topMargin;
        }
    }

    public final int d() {
        switch (this.f4172a) {
            case 0:
                X x4 = this.f4173b;
                return x4.n - x4.D();
            default:
                X x5 = this.f4173b;
                return x5.f4189o - x5.B();
        }
    }

    public final int e() {
        switch (this.f4172a) {
            case 0:
                return this.f4173b.C();
            default:
                return this.f4173b.E();
        }
    }
}
