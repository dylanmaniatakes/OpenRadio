package com.google.firebase.ktx;

import E2.c;
import E2.d;
import F2.a;
import F2.b;
import F2.j;
import F2.r;
import N3.AbstractC0143q;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;

@Keep
/* loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        a aVarA = b.a(new r(E2.a.class, AbstractC0143q.class));
        aVarA.a(new j(new r(E2.a.class, Executor.class), 1, 0));
        aVarA.f542f = W2.a.f2613d;
        b bVarB = aVarA.b();
        a aVarA2 = b.a(new r(c.class, AbstractC0143q.class));
        aVarA2.a(new j(new r(c.class, Executor.class), 1, 0));
        aVarA2.f542f = W2.a.f2614e;
        b bVarB2 = aVarA2.b();
        a aVarA3 = b.a(new r(E2.b.class, AbstractC0143q.class));
        aVarA3.a(new j(new r(E2.b.class, Executor.class), 1, 0));
        aVarA3.f542f = W2.a.f2615f;
        b bVarB3 = aVarA3.b();
        a aVarA4 = b.a(new r(d.class, AbstractC0143q.class));
        aVarA4.a(new j(new r(d.class, Executor.class), 1, 0));
        aVarA4.f542f = W2.a.g;
        return t3.j.y(bVarB, bVarB2, bVarB3, aVarA4.b());
    }
}
