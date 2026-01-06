package J1;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class A0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f699j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f700k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f701l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f702m;
    public final /* synthetic */ Object n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f703o;

    public /* synthetic */ A0(Object obj, Object obj2, Object obj3, Object obj4, long j5, int i5) {
        this.f699j = i5;
        this.f700k = obj2;
        this.f701l = obj3;
        this.n = obj4;
        this.f702m = j5;
        this.f703o = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f699j) {
            case 0:
                String str = (String) this.f701l;
                E0 e02 = (E0) this.f703o;
                String str2 = (String) this.f700k;
                if (str2 != null) {
                    C0082k1 c0082k1 = new C0082k1((String) this.n, str2, this.f702m);
                    V1 v12 = e02.f728c;
                    v12.e().j();
                    String str3 = v12.I;
                    if (str3 != null) {
                        str3.equals(str);
                    }
                    v12.I = str;
                    v12.f1013H = c0082k1;
                    break;
                } else {
                    V1 v13 = e02.f728c;
                    v13.e().j();
                    String str4 = v13.I;
                    if (str4 == null || str4.equals(str)) {
                        v13.I = str;
                        v13.f1013H = null;
                        break;
                    }
                }
                break;
            case 1:
                Object obj = this.n;
                ((C0058c1) this.f703o).E(this.f702m, obj, (String) this.f700k, (String) this.f701l);
                break;
            default:
                Bundle bundle = (Bundle) this.f700k;
                bundle.remove("screen_name");
                bundle.remove("screen_class");
                C0091n1 c0091n1 = (C0091n1) this.f703o;
                a2 a2Var = ((C0113v0) c0091n1.f84c).n;
                C0113v0.i(a2Var);
                Bundle bundleN = a2Var.n("screen_view", bundle, null, false);
                c0091n1.o((C0082k1) this.f701l, (C0082k1) this.n, this.f702m, true, bundleN);
                break;
        }
    }
}
