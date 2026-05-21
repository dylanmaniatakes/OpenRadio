package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class J extends Fragment {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f3913d = 0;

    /* renamed from: c, reason: collision with root package name */
    public Z2.c f3914c;

    public final void a(EnumC0243m enumC0243m) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            F3.i.e(activity, "activity");
            M.d(activity, enumC0243m);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(EnumC0243m.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(EnumC0243m.ON_DESTROY);
        this.f3914c = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(EnumC0243m.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        Z2.c cVar = this.f3914c;
        if (cVar != null) {
            ((G) cVar.f3147d).a();
        }
        a(EnumC0243m.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        Z2.c cVar = this.f3914c;
        if (cVar != null) {
            G g = (G) cVar.f3147d;
            int i5 = g.f3907c + 1;
            g.f3907c = i5;
            if (i5 == 1 && g.f3910f) {
                g.h.e(EnumC0243m.ON_START);
                g.f3910f = false;
            }
        }
        a(EnumC0243m.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(EnumC0243m.ON_STOP);
    }
}
