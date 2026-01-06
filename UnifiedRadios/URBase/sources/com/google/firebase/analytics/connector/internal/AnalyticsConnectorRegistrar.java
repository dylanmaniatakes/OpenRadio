package com.google.firebase.analytics.connector.internal;

import A2.g;
import C2.a;
import C2.b;
import F2.c;
import F2.j;
import F2.l;
import O2.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.C0354m0;
import com.google.android.gms.internal.measurement.D1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import q1.E;

@Keep
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    public static a lambda$getComponents$0(c cVar) {
        boolean z4;
        g gVar = (g) cVar.a(g.class);
        Context context = (Context) cVar.a(Context.class);
        N2.c cVar2 = (N2.c) cVar.a(N2.c.class);
        E.i(gVar);
        E.i(context);
        E.i(cVar2);
        E.i(context.getApplicationContext());
        if (b.f183b == null) {
            synchronized (b.class) {
                try {
                    if (b.f183b == null) {
                        Bundle bundle = new Bundle(1);
                        gVar.a();
                        if ("[DEFAULT]".equals(gVar.f27b)) {
                            ((l) cVar2).a(new C2.c(0), new e(2));
                            gVar.a();
                            V2.a aVar = (V2.a) gVar.g.get();
                            synchronized (aVar) {
                                z4 = aVar.f2534a;
                            }
                            bundle.putBoolean("dataCollectionDefaultEnabled", z4);
                        }
                        b.f183b = new b(C0354m0.c(context, bundle).f4983d);
                    }
                } finally {
                }
            }
        }
        return b.f183b;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<F2.b> getComponents() {
        F2.a aVarB = F2.b.b(a.class);
        aVarB.a(j.a(g.class));
        aVarB.a(j.a(Context.class));
        aVarB.a(j.a(N2.c.class));
        aVarB.f542f = new e(11);
        if (aVarB.f540d != 0) {
            throw new IllegalStateException("Instantiation type has already been set.");
        }
        aVarB.f540d = 2;
        return Arrays.asList(aVarB.b(), D1.d("fire-analytics", "22.4.0"));
    }
}
