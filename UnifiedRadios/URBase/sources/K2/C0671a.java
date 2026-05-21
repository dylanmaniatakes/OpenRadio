package k2;

import android.graphics.Typeface;
import com.google.android.gms.internal.measurement.D1;
import f3.C0519j;
import g2.C0538b;

/* renamed from: k2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0671a extends D1 {

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f7915b;

    /* renamed from: c, reason: collision with root package name */
    public final C0519j f7916c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7917d;

    public C0671a(C0519j c0519j, Typeface typeface) {
        this.f7915b = typeface;
        this.f7916c = c0519j;
    }

    @Override // com.google.android.gms.internal.measurement.D1
    public final void l(int i5) {
        if (this.f7917d) {
            return;
        }
        C0538b c0538b = (C0538b) this.f7916c.f6730d;
        if (c0538b.j(this.f7915b)) {
            c0538b.h(false);
        }
    }

    @Override // com.google.android.gms.internal.measurement.D1
    public final void m(Typeface typeface, boolean z4) {
        if (this.f7917d) {
            return;
        }
        C0538b c0538b = (C0538b) this.f7916c.f6730d;
        if (c0538b.j(typeface)) {
            c0538b.h(false);
        }
    }
}
