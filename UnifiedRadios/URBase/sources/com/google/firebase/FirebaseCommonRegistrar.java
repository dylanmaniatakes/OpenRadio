package com.google.firebase;

import A2.i;
import F2.a;
import F2.b;
import F2.j;
import F2.r;
import O2.d;
import O2.e;
import O2.f;
import O2.g;
import android.content.Context;
import android.os.Build;
import com.google.android.gms.internal.measurement.D1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import s3.C0893c;

/* loaded from: classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String a(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        a aVarB = b.b(Z2.b.class);
        aVarB.a(new j(2, 0, Z2.a.class));
        aVarB.f542f = new i(16);
        arrayList.add(aVarB.b());
        r rVar = new r(E2.a.class, Executor.class);
        a aVar = new a(d.class, new Class[]{f.class, g.class});
        aVar.a(j.a(Context.class));
        aVar.a(j.a(A2.g.class));
        aVar.a(new j(2, 0, e.class));
        aVar.a(new j(1, 1, Z2.b.class));
        aVar.a(new j(rVar, 1, 0));
        aVar.f542f = new O2.b(rVar, 0);
        arrayList.add(aVar.b());
        arrayList.add(D1.d("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(D1.d("fire-core", "21.0.0"));
        arrayList.add(D1.d("device-name", a(Build.PRODUCT)));
        arrayList.add(D1.d("device-model", a(Build.DEVICE)));
        arrayList.add(D1.d("device-brand", a(Build.BRAND)));
        arrayList.add(D1.g("android-target-sdk", new i(0)));
        arrayList.add(D1.g("android-min-sdk", new i(1)));
        arrayList.add(D1.g("android-platform", new i(2)));
        arrayList.add(D1.g("android-installer", new i(3)));
        try {
            C0893c.f9685k.getClass();
            str = "1.9.10";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(D1.d("kotlin", str));
        }
        return arrayList;
    }
}
