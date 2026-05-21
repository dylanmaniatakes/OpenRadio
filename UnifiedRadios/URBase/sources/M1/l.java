package m1;

import X2.s;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f8539a;

    /* renamed from: b, reason: collision with root package name */
    public final N1.k f8540b = new N1.k();

    /* renamed from: c, reason: collision with root package name */
    public final int f8541c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f8542d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f8543e;

    public l(int i5, int i6, Bundle bundle, int i7) {
        this.f8543e = i7;
        this.f8539a = i5;
        this.f8541c = i6;
        this.f8542d = bundle;
    }

    public final void a(Bundle bundle) {
        switch (this.f8543e) {
            case 0:
                if (!bundle.getBoolean("ack", false)) {
                    c(new s("Invalid response to one way request", null));
                    break;
                } else {
                    d(null);
                    break;
                }
            default:
                Bundle bundle2 = bundle.getBundle("data");
                if (bundle2 == null) {
                    bundle2 = Bundle.EMPTY;
                }
                d(bundle2);
                break;
        }
    }

    public final boolean b() {
        switch (this.f8543e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void c(s sVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + sVar.toString());
        }
        this.f8540b.f1789a.l(sVar);
    }

    public final void d(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f8540b.a(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f8541c + " id=" + this.f8539a + " oneWay=" + b() + "}";
    }
}
