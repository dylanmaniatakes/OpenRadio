package androidx.emoji2.text;

import J1.RunnableC0115w;
import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.InterfaceC0235e;
import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import s0.C0884a;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements s0.b {
    @Override // s0.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // s0.b
    public final /* bridge */ /* synthetic */ Object b(Context context) {
        c(context);
        return Boolean.TRUE;
    }

    public final void c(Context context) {
        Object objB;
        o oVar = new o(new L0.l(context));
        oVar.f3603a = 1;
        if (j.f3607j == null) {
            synchronized (j.f3606i) {
                try {
                    if (j.f3607j == null) {
                        j.f3607j = new j(oVar);
                    }
                } finally {
                }
            }
        }
        C0884a c0884aC = C0884a.c(context);
        c0884aC.getClass();
        synchronized (C0884a.f9571e) {
            try {
                objB = c0884aC.f9572a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = c0884aC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final AbstractC0245o lifecycle = ((InterfaceC0249t) objB).getLifecycle();
        lifecycle.a(new InterfaceC0235e() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0235e
            public final void onResume() {
                EmojiCompatInitializer.this.getClass();
                b.a(Looper.getMainLooper()).postDelayed(new RunnableC0115w(1), 500L);
                lifecycle.b(this);
            }
        });
    }
}
