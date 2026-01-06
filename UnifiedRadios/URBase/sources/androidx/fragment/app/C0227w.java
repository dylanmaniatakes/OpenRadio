package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.EnumC0243m;
import f.AbstractActivityC0472i;

/* renamed from: androidx.fragment.app.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0227w implements o0.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0230z f3892a;

    public C0227w(AbstractActivityC0472i abstractActivityC0472i) {
        this.f3892a = abstractActivityC0472i;
    }

    @Override // o0.b
    public final Bundle a() {
        Bundle bundle = new Bundle();
        AbstractActivityC0230z abstractActivityC0230z = this.f3892a;
        abstractActivityC0230z.markFragmentsCreated();
        abstractActivityC0230z.mFragmentLifecycleRegistry.e(EnumC0243m.ON_STOP);
        V vN = abstractActivityC0230z.mFragments.f3650a.f3654f.N();
        if (vN != null) {
            bundle.putParcelable("android:support:fragments", vN);
        }
        return bundle;
    }
}
