package com.google.firebase.messaging;

import A2.g;
import F2.c;
import F2.j;
import F2.r;
import P2.a;
import R2.e;
import Z2.b;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.D1;
import com.google.firebase.components.ComponentRegistrar;
import com.unified.ur1.SatelliteTracker.h;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(r rVar, c cVar) {
        g gVar = (g) cVar.a(g.class);
        h.p(cVar.a(a.class));
        return new FirebaseMessaging(gVar, cVar.e(b.class), cVar.e(O2.g.class), (e) cVar.a(e.class), cVar.d(rVar), (N2.c) cVar.a(N2.c.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<F2.b> getComponents() {
        r rVar = new r(H2.b.class, V0.e.class);
        F2.a aVarB = F2.b.b(FirebaseMessaging.class);
        aVarB.f537a = LIBRARY_NAME;
        aVarB.a(j.a(g.class));
        aVarB.a(new j(0, 0, a.class));
        aVarB.a(new j(0, 1, b.class));
        aVarB.a(new j(0, 1, O2.g.class));
        aVarB.a(j.a(e.class));
        aVarB.a(new j(rVar, 0, 1));
        aVarB.a(j.a(N2.c.class));
        aVarB.f542f = new O2.b(rVar, 1);
        if (aVarB.f540d != 0) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        aVarB.f540d = 1;
        return Arrays.asList(aVarB.b(), D1.d(LIBRARY_NAME, "24.1.1"));
    }
}
