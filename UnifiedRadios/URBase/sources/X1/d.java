package X1;

import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2752b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f2753c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager, int i5) {
        super(1);
        this.f2752b = i5;
        switch (i5) {
            case 1:
                this.f2753c = carouselLayoutManager;
                super(0);
                break;
            default:
                this.f2753c = carouselLayoutManager;
                break;
        }
    }

    @Override // X1.e
    public final int c() {
        switch (this.f2752b) {
            case 0:
                return this.f2753c.f4189o;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f2753c;
                return carouselLayoutManager.f4189o - carouselLayoutManager.B();
        }
    }

    @Override // X1.e
    public final int d() {
        switch (this.f2752b) {
            case 0:
                return this.f2753c.C();
            default:
                return 0;
        }
    }

    @Override // X1.e
    public final int e() {
        switch (this.f2752b) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = this.f2753c;
                return carouselLayoutManager.n - carouselLayoutManager.D();
            default:
                return this.f2753c.n;
        }
    }

    @Override // X1.e
    public final int f() {
        switch (this.f2752b) {
            case 0:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f2753c;
                if (carouselLayoutManager.G0()) {
                    return carouselLayoutManager.n;
                }
                return 0;
        }
    }

    @Override // X1.e
    public final int g() {
        switch (this.f2752b) {
            case 0:
                return 0;
            default:
                return this.f2753c.E();
        }
    }
}
