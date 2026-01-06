package J1;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
public final class B0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f704j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.M f705k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f706l;

    public /* synthetic */ B0(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.M m5, int i5) {
        this.f704j = i5;
        this.f705k = m5;
        this.f706l = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f704j) {
            case 0:
                C0120x1 c0120x1R = this.f706l.f5155c.r();
                c0120x1R.j();
                c0120x1R.k();
                c0120x1R.A(new F0.e(c0120x1R, c0120x1R.x(false), this.f705k, 8, false));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.f706l;
                a2 a2Var = appMeasurementDynamiteService.f5155c.n;
                C0113v0.i(a2Var);
                C0113v0 c0113v0 = appMeasurementDynamiteService.f5155c;
                a2Var.F(this.f705k, c0113v0.f1406D != null && c0113v0.f1406D.booleanValue());
                break;
        }
    }
}
