package com.google.firebase.installations;

import A2.g;
import A2.i;
import D0.p;
import E2.a;
import E2.b;
import F2.c;
import F2.r;
import G2.j;
import O2.f;
import R2.d;
import R2.e;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.D1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@Keep
/* loaded from: classes.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    /* JADX INFO: Access modifiers changed from: private */
    public static e lambda$getComponents$0(c cVar) {
        return new d((g) cVar.a(g.class), cVar.e(f.class), (ExecutorService) cVar.c(new r(a.class, ExecutorService.class)), new j((Executor) cVar.c(new r(b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<F2.b> getComponents() {
        F2.a aVarB = F2.b.b(e.class);
        aVarB.f537a = LIBRARY_NAME;
        aVarB.a(F2.j.a(g.class));
        aVarB.a(new F2.j(0, 1, f.class));
        aVarB.a(new F2.j(new r(a.class, ExecutorService.class), 1, 0));
        aVarB.a(new F2.j(new r(b.class, Executor.class), 1, 0));
        aVarB.f542f = new i(11);
        F2.b bVarB = aVarB.b();
        O2.e eVar = new O2.e(0);
        F2.a aVarB2 = F2.b.b(O2.e.class);
        aVarB2.f541e = 1;
        aVarB2.f542f = new p(1, eVar);
        return Arrays.asList(bVarB, aVarB2.b(), D1.d(LIBRARY_NAME, "18.0.0"));
    }
}
