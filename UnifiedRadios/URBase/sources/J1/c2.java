package J1;

import com.google.android.gms.internal.measurement.C0330h1;
import com.google.android.gms.internal.measurement.C0335i1;
import com.google.android.gms.internal.measurement.C0340j1;
import com.google.android.gms.internal.measurement.C0345k1;
import com.google.android.gms.internal.measurement.C0352l3;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1181a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1182b;

    /* renamed from: c, reason: collision with root package name */
    public final C0335i1 f1183c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f1184d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f1185e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f1186f;
    public final q.b g;
    public final /* synthetic */ C0056c h;

    public c2(C0056c c0056c, String str) {
        this.h = c0056c;
        this.f1181a = str;
        this.f1182b = true;
        this.f1184d = new BitSet();
        this.f1185e = new BitSet();
        this.f1186f = new q.b();
        this.g = new q.b();
    }

    public final com.google.android.gms.internal.measurement.T0 a(int i5) {
        ArrayList arrayList;
        List listEmptyList;
        com.google.android.gms.internal.measurement.S0 s0Q = com.google.android.gms.internal.measurement.T0.q();
        s0Q.g();
        com.google.android.gms.internal.measurement.T0.t((com.google.android.gms.internal.measurement.T0) s0Q.f4913k, i5);
        s0Q.g();
        com.google.android.gms.internal.measurement.T0.v((com.google.android.gms.internal.measurement.T0) s0Q.f4913k, this.f1182b);
        C0335i1 c0335i1 = this.f1183c;
        if (c0335i1 != null) {
            s0Q.g();
            com.google.android.gms.internal.measurement.T0.w((com.google.android.gms.internal.measurement.T0) s0Q.f4913k, c0335i1);
        }
        C0330h1 c0330h1T = C0335i1.t();
        ArrayList arrayListT = C0060d0.T(this.f1184d);
        c0330h1T.g();
        C0335i1.A((C0335i1) c0330h1T.f4913k, arrayListT);
        ArrayList arrayListT2 = C0060d0.T(this.f1185e);
        c0330h1T.g();
        C0335i1.C((C0335i1) c0330h1T.f4913k, arrayListT2);
        Map map = this.f1186f;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(map.size());
            for (Integer num : map.keySet()) {
                int iIntValue = num.intValue();
                Long l5 = (Long) map.get(num);
                if (l5 != null) {
                    com.google.android.gms.internal.measurement.U0 u0R = com.google.android.gms.internal.measurement.V0.r();
                    u0R.g();
                    com.google.android.gms.internal.measurement.V0.t((com.google.android.gms.internal.measurement.V0) u0R.f4913k, iIntValue);
                    long jLongValue = l5.longValue();
                    u0R.g();
                    com.google.android.gms.internal.measurement.V0.s((com.google.android.gms.internal.measurement.V0) u0R.f4913k, jLongValue);
                    arrayList.add((com.google.android.gms.internal.measurement.V0) u0R.e());
                }
            }
        }
        if (arrayList != null) {
            c0330h1T.g();
            C0335i1.z((C0335i1) c0330h1T.f4913k, arrayList);
        }
        q.b bVar = this.g;
        if (bVar == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(bVar.f9278l);
            Iterator it = ((q.h) bVar.keySet()).iterator();
            while (it.hasNext()) {
                Integer num2 = (Integer) it.next();
                C0340j1 c0340j1S = C0345k1.s();
                int iIntValue2 = num2.intValue();
                c0340j1S.g();
                C0345k1.v((C0345k1) c0340j1S.f4913k, iIntValue2);
                List list = (List) bVar.getOrDefault(num2, null);
                if (list != null) {
                    Collections.sort(list);
                    c0340j1S.g();
                    C0345k1.u((C0345k1) c0340j1S.f4913k, list);
                }
                arrayList2.add((C0345k1) c0340j1S.e());
            }
            listEmptyList = arrayList2;
        }
        c0330h1T.g();
        C0335i1.B((C0335i1) c0330h1T.f4913k, listEmptyList);
        s0Q.g();
        com.google.android.gms.internal.measurement.T0.u((com.google.android.gms.internal.measurement.T0) s0Q.f4913k, (C0335i1) c0330h1T.e());
        return (com.google.android.gms.internal.measurement.T0) s0Q.e();
    }

    public final void b(C0053b c0053b) {
        int iA = c0053b.a();
        if (c0053b.f1116c != null) {
            this.f1185e.set(iA, true);
        }
        Boolean bool = c0053b.f1117d;
        if (bool != null) {
            this.f1184d.set(iA, bool.booleanValue());
        }
        if (c0053b.f1118e != null) {
            Integer numValueOf = Integer.valueOf(iA);
            Map map = this.f1186f;
            Long l5 = (Long) map.get(numValueOf);
            long jLongValue = c0053b.f1118e.longValue() / 1000;
            if (l5 == null || jLongValue > l5.longValue()) {
                map.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (c0053b.f1119f != null) {
            q.b bVar = this.g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) bVar.getOrDefault(numValueOf2, null);
            if (arrayList == null) {
                arrayList = new ArrayList();
                bVar.put(numValueOf2, arrayList);
            }
            if (c0053b.c()) {
                arrayList.clear();
            }
            C0352l3.a();
            C0113v0 c0113v0 = (C0113v0) this.h.f84c;
            C0068g c0068g = c0113v0.f1415i;
            G g = H.f756E0;
            String str = this.f1181a;
            if (c0068g.w(str, g) && c0053b.b()) {
                arrayList.clear();
            }
            C0352l3.a();
            if (!c0113v0.f1415i.w(str, g)) {
                arrayList.add(Long.valueOf(c0053b.f1119f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(c0053b.f1119f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public c2(C0056c c0056c, String str, C0335i1 c0335i1, BitSet bitSet, BitSet bitSet2, q.b bVar, q.b bVar2) {
        this.h = c0056c;
        this.f1181a = str;
        this.f1184d = bitSet;
        this.f1185e = bitSet2;
        this.f1186f = bVar;
        this.g = new q.b();
        Iterator it = ((q.h) bVar2.keySet()).iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) bVar2.getOrDefault(num, null));
            this.g.put(num, arrayList);
        }
        this.f1182b = false;
        this.f1183c = c0335i1;
    }
}
