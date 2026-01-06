package com.google.firebase.datatransport;

import A2.i;
import F2.b;
import F2.c;
import F2.j;
import F2.r;
import V0.e;
import W0.a;
import Y0.q;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.D1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e lambda$getComponents$0(c cVar) {
        q.b((Context) cVar.a(Context.class));
        return q.a().c(a.f2575f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e lambda$getComponents$1(c cVar) {
        q.b((Context) cVar.a(Context.class));
        return q.a().c(a.f2575f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ e lambda$getComponents$2(c cVar) {
        q.b((Context) cVar.a(Context.class));
        return q.a().c(a.f2574e);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        F2.a aVarB = b.b(e.class);
        aVarB.f537a = LIBRARY_NAME;
        aVarB.a(j.a(Context.class));
        aVarB.f542f = new i(8);
        b bVarB = aVarB.b();
        F2.a aVarA = b.a(new r(H2.a.class, e.class));
        aVarA.a(j.a(Context.class));
        aVarA.f542f = new i(9);
        b bVarB2 = aVarA.b();
        F2.a aVarA2 = b.a(new r(H2.b.class, e.class));
        aVarA2.a(j.a(Context.class));
        aVarA2.f542f = new i(10);
        return Arrays.asList(bVarB, bVarB2, aVarA2.b(), D1.d(LIBRARY_NAME, "18.2.0"));
    }
}
