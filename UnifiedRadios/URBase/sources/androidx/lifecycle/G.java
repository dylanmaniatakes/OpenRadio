package androidx.lifecycle;

import android.os.Handler;

/* loaded from: classes.dex */
public final class G implements InterfaceC0249t {

    /* renamed from: k, reason: collision with root package name */
    public static final G f3906k = new G();

    /* renamed from: c, reason: collision with root package name */
    public int f3907c;

    /* renamed from: d, reason: collision with root package name */
    public int f3908d;
    public Handler g;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3909e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3910f = true;
    public final C0251v h = new C0251v(this);

    /* renamed from: i, reason: collision with root package name */
    public final C0.e f3911i = new C0.e(11, this);

    /* renamed from: j, reason: collision with root package name */
    public final Z2.c f3912j = new Z2.c(14, this);

    public final void a() {
        int i5 = this.f3908d + 1;
        this.f3908d = i5;
        if (i5 == 1) {
            if (this.f3909e) {
                this.h.e(EnumC0243m.ON_RESUME);
                this.f3909e = false;
            } else {
                Handler handler = this.g;
                F3.i.c(handler);
                handler.removeCallbacks(this.f3911i);
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0249t
    public final AbstractC0245o getLifecycle() {
        return this.h;
    }
}
