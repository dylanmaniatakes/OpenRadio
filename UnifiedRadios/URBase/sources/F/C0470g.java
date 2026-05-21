package f;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* renamed from: f.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0470g implements o0.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6345a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6346b;

    public C0470g(o0.c cVar) {
        F3.i.f(cVar, "registry");
        this.f6346b = new LinkedHashSet();
        cVar.c("androidx.savedstate.Restarter", this);
    }

    @Override // o0.b
    public final Bundle a() {
        switch (this.f6345a) {
            case 0:
                Bundle bundle = new Bundle();
                ((AbstractActivityC0472i) this.f6346b).getDelegate().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f6346b));
                return bundle2;
        }
    }

    public C0470g(AbstractActivityC0472i abstractActivityC0472i) {
        this.f6346b = abstractActivityC0472i;
    }
}
