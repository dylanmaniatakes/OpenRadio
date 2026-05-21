package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4246a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4247b;

    /* renamed from: c, reason: collision with root package name */
    public int f4248c;

    /* renamed from: d, reason: collision with root package name */
    public int f4249d;

    /* renamed from: e, reason: collision with root package name */
    public int f4250e;

    /* renamed from: f, reason: collision with root package name */
    public int f4251f;
    public int g;
    public Object h;

    public /* synthetic */ h0(int i5) {
        this.f4246a = i5;
    }

    public void a(RecyclerView recyclerView) {
        int i5 = this.f4251f;
        if (i5 >= 0) {
            this.f4251f = -1;
            recyclerView.Q(i5);
            this.f4247b = false;
            return;
        }
        if (!this.f4247b) {
            this.g = 0;
            return;
        }
        Interpolator interpolator = (Interpolator) this.h;
        if (interpolator != null && this.f4250e < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i6 = this.f4250e;
        if (i6 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.f4110g0.c(this.f4248c, this.f4249d, i6, interpolator);
        int i7 = this.g + 1;
        this.g = i7;
        if (i7 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f4247b = false;
    }

    public String toString() {
        switch (this.f4246a) {
            case 1:
                if (!this.f4247b) {
                    return "TileStates";
                }
                StringBuilder sb = new StringBuilder("TileStates: ");
                sb.append(this.f4248c);
                sb.append(" = ");
                sb.append(this.f4249d);
                sb.append("(U) + ");
                sb.append(this.f4250e);
                sb.append("(E) + ");
                sb.append(this.f4251f);
                sb.append("(S) + ");
                return com.unified.ur1.SatelliteTracker.h.d(sb, this.g, "(N)");
            default:
                return super.toString();
        }
    }
}
