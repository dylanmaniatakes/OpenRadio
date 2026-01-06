package m3;

import android.util.Log;
import k3.C0675a0;
import q3.AbstractC0869a;

/* renamed from: m3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0773i implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f8607a;

    public C0773i(C0675a0 c0675a0) {
        this.f8607a = c0675a0;
    }

    @Override // m3.v
    public final void a(D0.w wVar) {
        StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.h("Unified - DmrBusiness", "==== VERSION RESPONSE RECEIVED ====", "Command: "), (String) wVar.f310c, "Unified - DmrBusiness", "Data: ");
        String str = (String) wVar.g;
        com.unified.ur1.SatelliteTracker.h.q(sbI, str, "Unified - DmrBusiness");
        try {
            Log.d("Unified - DmrBusiness", "As text: ".concat(new String(AbstractC0869a.c(str))));
        } catch (Exception e5) {
            Log.e("Unified - DmrBusiness", "Error converting to text", e5);
        }
        v vVar = this.f8607a;
        if (vVar != null) {
            vVar.a(wVar);
        }
    }
}
