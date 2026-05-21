package B0;

import X2.t;
import androidx.recyclerview.widget.P;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class g extends P {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f104a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f105b;

    public /* synthetic */ g(int i5, Object obj) {
        this.f104a = i5;
        this.f105b = obj;
    }

    @Override // androidx.recyclerview.widget.P
    public final void a() {
        switch (this.f104a) {
            case 0:
                ViewPager2 viewPager2 = (ViewPager2) this.f105b;
                viewPager2.g = true;
                viewPager2.n.f102l = true;
                break;
            default:
                ((t) this.f105b).o();
                break;
        }
    }

    @Override // androidx.recyclerview.widget.P
    public final void b(int i5, int i6, Object obj) {
        a();
    }

    @Override // androidx.recyclerview.widget.P
    public final void c(int i5, int i6) {
        a();
    }

    @Override // androidx.recyclerview.widget.P
    public final void d(int i5, int i6) {
        a();
    }

    @Override // androidx.recyclerview.widget.P
    public final void e(int i5, int i6) {
        a();
    }
}
