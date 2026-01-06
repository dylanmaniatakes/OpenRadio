package B0;

import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f106a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f107b;

    public /* synthetic */ h(ViewPager2 viewPager2, int i5) {
        this.f106a = i5;
        this.f107b = viewPager2;
    }

    @Override // B0.k
    public void a(int i5) {
        switch (this.f106a) {
            case 0:
                if (i5 == 0) {
                    this.f107b.d();
                    break;
                }
                break;
        }
    }

    @Override // B0.k
    public final void c(int i5) {
        switch (this.f106a) {
            case 0:
                ViewPager2 viewPager2 = this.f107b;
                if (viewPager2.f4463f != i5) {
                    viewPager2.f4463f = i5;
                    viewPager2.f4476v.o();
                    break;
                }
                break;
            default:
                ViewPager2 viewPager22 = this.f107b;
                viewPager22.clearFocus();
                if (viewPager22.hasFocus()) {
                    viewPager22.f4467l.requestFocus(2);
                    break;
                }
                break;
        }
    }
}
