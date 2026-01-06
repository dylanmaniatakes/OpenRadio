package J1;

import D1.C0016n;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* loaded from: classes.dex */
public final /* synthetic */ class S0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f948j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0058c1 f949k;

    public /* synthetic */ S0(C0058c1 c0058c1, int i5) {
        this.f948j = i5;
        this.f949k = c0058c1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f948j) {
            case 0:
                C0058c1 c0058c1 = this.f949k;
                c0058c1.j();
                C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
                C0072h0 c0072h0 = c0113v0.f1416j;
                C0113v0.i(c0072h0);
                boolean zB = c0072h0.f1249w.b();
                Z z4 = c0113v0.f1417k;
                if (zB) {
                    C0113v0.k(z4);
                    z4.f1083o.a("Deferred Deep Link already retrieved. Not fetching again.");
                    break;
                } else {
                    C0072h0 c0072h02 = c0113v0.f1416j;
                    C0113v0.i(c0072h02);
                    C0069g0 c0069g0 = c0072h02.f1250x;
                    long jA = c0069g0.a();
                    c0069g0.b(1 + jA);
                    if (jA >= 5) {
                        C0113v0.k(z4);
                        z4.f1080k.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        c0072h02.f1249w.a(true);
                        break;
                    } else {
                        if (c0058c1.f1177v == null) {
                            c0058c1.f1177v = new U0(c0058c1, c0113v0, 3);
                        }
                        c0058c1.f1177v.c(0L);
                        break;
                    }
                }
            case 1:
                this.f949k.r();
                break;
            case 2:
                C0107t0 c0107t0 = this.f949k.f1175t;
                C0113v0 c0113v02 = c0107t0.f1391c;
                C0104s0 c0104s0 = c0113v02.f1418l;
                C0113v0.k(c0104s0);
                c0104s0.j();
                if (c0107t0.c()) {
                    boolean zD = c0107t0.d();
                    C0058c1 c0058c12 = c0113v02.f1423r;
                    C0072h0 c0072h03 = c0113v02.f1416j;
                    if (zD) {
                        C0113v0.i(c0072h03);
                        c0072h03.f1252z.h(null);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "(not set)");
                        bundle.putString("medium", "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        C0113v0.j(c0058c12);
                        c0058c12.u("auto", "_cmpx", bundle);
                    } else {
                        C0113v0.i(c0072h03);
                        C0016n c0016n = c0072h03.f1252z;
                        String strG = c0016n.g();
                        if (TextUtils.isEmpty(strG)) {
                            Z z5 = c0113v02.f1417k;
                            C0113v0.k(z5);
                            z5.f1078i.a("Cache still valid but referrer not found");
                        } else {
                            long jA2 = c0072h03.f1232A.a() / 3600000;
                            Uri uri = Uri.parse(strG);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(uri.getPath(), bundle2);
                            for (String str : uri.getQueryParameterNames()) {
                                bundle2.putString(str, uri.getQueryParameter(str));
                            }
                            ((Bundle) pair.second).putLong("_cc", (jA2 - 1) * 3600000);
                            Object obj = pair.first;
                            String str2 = obj == null ? "app" : (String) obj;
                            C0113v0.j(c0058c12);
                            c0058c12.u(str2, "_cmp", (Bundle) pair.second);
                        }
                        c0016n.h(null);
                    }
                    C0113v0.i(c0072h03);
                    c0072h03.f1232A.b(0L);
                    break;
                }
                break;
            default:
                this.f949k.r();
                break;
        }
    }
}
