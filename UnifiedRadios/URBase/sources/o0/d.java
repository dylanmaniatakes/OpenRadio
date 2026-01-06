package o0;

import F3.i;
import O.C0175n;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0244n;
import androidx.savedstate.Recreator;
import java.util.Map;
import m.C0756d;
import m.C0758f;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f8892a;

    /* renamed from: b, reason: collision with root package name */
    public final c f8893b = new c();

    /* renamed from: c, reason: collision with root package name */
    public boolean f8894c;

    public d(e eVar) {
        this.f8892a = eVar;
    }

    public final void a() {
        e eVar = this.f8892a;
        AbstractC0245o lifecycle = eVar.getLifecycle();
        if (((C0251v) lifecycle).f3971c != EnumC0244n.f3962k) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new Recreator(eVar));
        c cVar = this.f8893b;
        cVar.getClass();
        if (!(!cVar.f8887b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new C0175n(1, cVar));
        cVar.f8887b = true;
        this.f8894c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.f8894c) {
            a();
        }
        C0251v c0251v = (C0251v) this.f8892a.getLifecycle();
        if (!(!(c0251v.f3971c.compareTo(EnumC0244n.f3964m) >= 0))) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + c0251v.f3971c).toString());
        }
        c cVar = this.f8893b;
        if (!cVar.f8887b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!cVar.f8889d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        cVar.f8888c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        cVar.f8889d = true;
    }

    public final void c(Bundle bundle) {
        i.f(bundle, "outBundle");
        c cVar = this.f8893b;
        cVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = cVar.f8888c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0758f c0758f = cVar.f8886a;
        c0758f.getClass();
        C0756d c0756d = new C0756d(c0758f);
        c0758f.f8506l.put(c0756d, Boolean.FALSE);
        while (c0756d.hasNext()) {
            Map.Entry entry = (Map.Entry) c0756d.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
