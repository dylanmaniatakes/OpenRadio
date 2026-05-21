package k2;

import android.graphics.Typeface;
import com.google.android.gms.internal.measurement.D1;

/* loaded from: classes.dex */
public final class b extends D.b {
    public final /* synthetic */ D1 h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d f7918i;

    public b(d dVar, D1 d12) {
        this.f7918i = dVar;
        this.h = d12;
    }

    @Override // D.b
    public final void g(int i5) {
        this.f7918i.f7933m = true;
        this.h.l(i5);
    }

    @Override // D.b
    public final void h(Typeface typeface) {
        d dVar = this.f7918i;
        dVar.n = Typeface.create(typeface, dVar.f7925c);
        dVar.f7933m = true;
        this.h.m(dVar.n, false);
    }
}
