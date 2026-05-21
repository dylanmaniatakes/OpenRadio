package androidx.activity;

import android.window.BackEvent;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f3222a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3223b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3224c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3225d;

    public b(BackEvent backEvent) {
        F3.i.f(backEvent, "backEvent");
        a aVar = a.f3221a;
        float fD = aVar.d(backEvent);
        float fE = aVar.e(backEvent);
        float fB = aVar.b(backEvent);
        int iC = aVar.c(backEvent);
        this.f3222a = fD;
        this.f3223b = fE;
        this.f3224c = fB;
        this.f3225d = iC;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f3222a + ", touchY=" + this.f3223b + ", progress=" + this.f3224c + ", swipeEdge=" + this.f3225d + '}';
    }
}
