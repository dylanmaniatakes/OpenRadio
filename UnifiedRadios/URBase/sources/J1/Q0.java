package J1;

import android.os.Bundle;
import java.util.Iterator;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final /* synthetic */ class Q0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f932j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Bundle f933k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0058c1 f934l;

    public /* synthetic */ Q0(C0058c1 c0058c1, Bundle bundle, int i5) {
        this.f932j = i5;
        this.f934l = c0058c1;
        this.f933k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        switch (this.f932j) {
            case 0:
                Bundle bundle2 = this.f933k;
                boolean zIsEmpty = bundle2.isEmpty();
                C0058c1 c0058c1 = this.f934l;
                if (zIsEmpty) {
                    bundle = bundle2;
                } else {
                    C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
                    C0072h0 c0072h0 = c0113v0.f1416j;
                    C0113v0.i(c0072h0);
                    bundle = new Bundle(c0072h0.f1233B.q());
                    Iterator<String> it = bundle2.keySet().iterator();
                    while (true) {
                        boolean zHasNext = it.hasNext();
                        L0.l lVar = c0058c1.f1180y;
                        C0068g c0068g = c0113v0.f1415i;
                        Z z4 = c0113v0.f1417k;
                        a2 a2Var = c0113v0.n;
                        if (zHasNext) {
                            String next = it.next();
                            Object obj = bundle2.get(next);
                            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                                C0113v0.i(a2Var);
                                if (a2.b0(obj)) {
                                    a2.D(lVar, null, 27, null, null, 0);
                                }
                                C0113v0.k(z4);
                                z4.f1082m.c(next, obj, "Invalid default event parameter type. Name, value");
                            } else if (a2.e0(next)) {
                                C0113v0.k(z4);
                                z4.f1082m.b(next, "Invalid default event parameter name. Name");
                            } else if (obj == null) {
                                bundle.remove(next);
                            } else {
                                C0113v0.i(a2Var);
                                c0068g.getClass();
                                if (a2Var.W("param", next, 500, obj)) {
                                    a2Var.E(bundle, next, obj);
                                }
                            }
                        } else {
                            C0113v0.i(a2Var);
                            a2 a2Var2 = ((C0113v0) c0068g.f84c).n;
                            C0113v0.i(a2Var2);
                            int i5 = a2Var2.d0(201500000) ? 100 : 25;
                            if (bundle.size() > i5) {
                                Iterator it2 = new TreeSet(bundle.keySet()).iterator();
                                int i6 = 0;
                                while (it2.hasNext()) {
                                    String str = (String) it2.next();
                                    i6++;
                                    if (i6 > i5) {
                                        bundle.remove(str);
                                    }
                                }
                                C0113v0.i(a2Var);
                                a2.D(lVar, null, 26, null, null, 0);
                                C0113v0.k(z4);
                                z4.f1082m.a("Too many default event parameters set. Discarding beyond event parameter limit");
                            }
                        }
                    }
                }
                C0113v0 c0113v02 = (C0113v0) c0058c1.f84c;
                C0072h0 c0072h02 = c0113v02.f1416j;
                C0113v0.i(c0072h02);
                c0072h02.f1233B.s(bundle);
                if (bundle2.isEmpty()) {
                    if (!c0113v02.f1415i.w(null, H.f806d1)) {
                    }
                }
                ((C0113v0) c0058c1.f84c).r().s(bundle);
                break;
            case 1:
                C0058c1 c0058c12 = this.f934l;
                c0058c12.j();
                c0058c12.k();
                Bundle bundle3 = this.f933k;
                q1.E.i(bundle3);
                String string = bundle3.getString("name");
                String string2 = bundle3.getString("origin");
                q1.E.f(string);
                q1.E.f(string2);
                q1.E.i(bundle3.get("value"));
                C0113v0 c0113v03 = (C0113v0) c0058c12.f84c;
                if (!c0113v03.b()) {
                    Z z5 = c0113v03.f1417k;
                    C0113v0.k(z5);
                    z5.f1084p.a("Conditional property not set since app measurement is disabled");
                    break;
                } else {
                    Y1 y12 = new Y1(bundle3.getLong("triggered_timestamp"), bundle3.get("value"), string, string2);
                    try {
                        a2 a2Var3 = c0113v03.n;
                        C0113v0.i(a2Var3);
                        bundle3.getString("app_id");
                        C0112v c0112vP = a2Var3.p(bundle3.getString("triggered_event_name"), bundle3.getBundle("triggered_event_params"), string2, 0L, true);
                        C0113v0.i(a2Var3);
                        bundle3.getString("app_id");
                        C0112v c0112vP2 = a2Var3.p(bundle3.getString("timed_out_event_name"), bundle3.getBundle("timed_out_event_params"), string2, 0L, true);
                        bundle3.getString("app_id");
                        c0113v03.r().r(new C0062e(bundle3.getString("app_id"), string2, y12, bundle3.getLong("creation_timestamp"), false, bundle3.getString("trigger_event_name"), c0112vP2, bundle3.getLong("trigger_timeout"), c0112vP, bundle3.getLong("time_to_live"), a2Var3.p(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), string2, 0L, true)));
                        break;
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
            default:
                C0058c1 c0058c13 = this.f934l;
                c0058c13.j();
                c0058c13.k();
                Bundle bundle4 = this.f933k;
                q1.E.i(bundle4);
                String string3 = bundle4.getString("name");
                q1.E.f(string3);
                C0113v0 c0113v04 = (C0113v0) c0058c13.f84c;
                if (!c0113v04.b()) {
                    Z z6 = c0113v04.f1417k;
                    C0113v0.k(z6);
                    z6.f1084p.a("Conditional property not cleared since app measurement is disabled");
                    break;
                } else {
                    Y1 y13 = new Y1(0L, null, string3, "");
                    try {
                        a2 a2Var4 = c0113v04.n;
                        C0113v0.i(a2Var4);
                        bundle4.getString("app_id");
                        c0113v04.r().r(new C0062e(bundle4.getString("app_id"), "", y13, bundle4.getLong("creation_timestamp"), bundle4.getBoolean("active"), bundle4.getString("trigger_event_name"), null, bundle4.getLong("trigger_timeout"), null, bundle4.getLong("time_to_live"), a2Var4.p(bundle4.getString("expired_event_name"), bundle4.getBundle("expired_event_params"), "", bundle4.getLong("creation_timestamp"), true)));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        return;
                    }
                }
        }
    }
}
