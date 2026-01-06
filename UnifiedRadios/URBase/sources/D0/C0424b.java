package d0;

import J1.C;
import androidx.lifecycle.S;
import com.unified.ur1.SatelliteTracker.h;
import q.l;

/* renamed from: d0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0424b extends S {

    /* renamed from: e, reason: collision with root package name */
    public static final C f6097e = new C(27);

    /* renamed from: d, reason: collision with root package name */
    public final l f6098d = new l();

    @Override // androidx.lifecycle.S
    public final void b() {
        l lVar = this.f6098d;
        int i5 = lVar.f9282l;
        if (i5 > 0) {
            h.p(lVar.f9281k[0]);
            throw null;
        }
        Object[] objArr = lVar.f9281k;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        lVar.f9282l = 0;
    }
}
