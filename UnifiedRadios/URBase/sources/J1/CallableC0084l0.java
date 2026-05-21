package J1;

import com.google.android.gms.internal.measurement.C0380r2;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* renamed from: J1.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class CallableC0084l0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1291a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0093o0 f1292b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1293c;

    public /* synthetic */ CallableC0084l0(C0093o0 c0093o0, String str, int i5) {
        this.f1291a = i5;
        this.f1292b = c0093o0;
        this.f1293c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1291a) {
            case 0:
                L0.e eVar = new L0.e(6, this.f1292b, this.f1293c, false);
                C0380r2 c0380r2 = new C0380r2("internal.remoteConfig", 0);
                c0380r2.f4953k.put("getValue", new com.google.android.gms.internal.measurement.I1(eVar));
                return c0380r2;
            case 1:
                return new com.google.android.gms.internal.measurement.I1(new CallableC0084l0(this.f1292b, this.f1293c, 2));
            default:
                C0093o0 c0093o0 = this.f1292b;
                C0089n c0089n = c0093o0.f902d.f1019e;
                V1.J(c0089n);
                String str = this.f1293c;
                V vG0 = c0089n.g0(str);
                HashMap map = new HashMap();
                map.put("platform", "android");
                map.put("package_name", str);
                ((C0113v0) c0093o0.f84c).f1415i.q();
                map.put("gmp_version", 119002L);
                if (vG0 != null) {
                    String strE = vG0.e();
                    if (strE != null) {
                        map.put("app_version", strE);
                    }
                    map.put("app_version_int", Long.valueOf(vG0.S()));
                    map.put("dynamite_version", Long.valueOf(vG0.T()));
                }
                return map;
        }
    }
}
