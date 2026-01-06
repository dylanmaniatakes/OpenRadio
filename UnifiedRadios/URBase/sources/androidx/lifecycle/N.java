package androidx.lifecycle;

import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0230z;
import java.util.Map;
import s3.C0898h;

/* loaded from: classes.dex */
public final class N implements o0.b {

    /* renamed from: a, reason: collision with root package name */
    public final o0.c f3927a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3928b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f3929c;

    /* renamed from: d, reason: collision with root package name */
    public final C0898h f3930d;

    public N(o0.c cVar, AbstractActivityC0230z abstractActivityC0230z) {
        F3.i.f(cVar, "savedStateRegistry");
        this.f3927a = cVar;
        this.f3930d = new C0898h(new H0.g(1, abstractActivityC0230z));
    }

    @Override // o0.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3929c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((O) this.f3930d.a()).f3931d.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((K) entry.getValue()).f3920e.a();
            if (!F3.i.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.f3928b = false;
        return bundle;
    }
}
