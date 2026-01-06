package J1;

import android.text.TextUtils;
import java.util.LinkedHashMap;

/* renamed from: J1.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0090n0 extends q.f {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0093o0 f1314f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0090n0(C0093o0 c0093o0) {
        super(20);
        this.f1314f = c0093o0;
    }

    @Override // q.f
    public final Object a(Object obj) throws Throwable {
        com.google.android.gms.internal.measurement.H0 h02;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        String str = (String) obj;
        q1.E.f(str);
        C0093o0 c0093o0 = this.f1314f;
        boolean zW = ((C0113v0) c0093o0.f84c).f1415i.w(null, H.f832n1);
        C0090n0 c0090n0 = c0093o0.f1330l;
        if (zW) {
            c0093o0.k();
            q1.E.f(str);
            C0089n c0089n = c0093o0.f902d.f1019e;
            V1.J(c0089n);
            L0.m mVarI0 = c0089n.i0(str);
            if (mVarI0 == null) {
                return null;
            }
            Z z4 = ((C0113v0) c0093o0.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1084p.b(str, "Populate EES config from database on cache miss. appId");
            c0093o0.s(str, c0093o0.p(str, (byte[]) mVarI0.f1556d));
            synchronized (c0090n0) {
                linkedHashMap2 = new LinkedHashMap(c0090n0.f9257a);
            }
            return (com.google.android.gms.internal.measurement.E) linkedHashMap2.get(str);
        }
        c0093o0.k();
        q1.E.f(str);
        if (TextUtils.isEmpty(str) || (h02 = (com.google.android.gms.internal.measurement.H0) c0093o0.f1328j.getOrDefault(str, null)) == null || h02.p() == 0) {
            return null;
        }
        q.b bVar = c0093o0.f1328j;
        if (!bVar.containsKey(str) || bVar.getOrDefault(str, null) == null) {
            c0093o0.r(str);
        } else {
            c0093o0.s(str, (com.google.android.gms.internal.measurement.H0) bVar.getOrDefault(str, null));
        }
        synchronized (c0090n0) {
            linkedHashMap = new LinkedHashMap(c0090n0.f9257a);
        }
        return (com.google.android.gms.internal.measurement.E) linkedHashMap.get(str);
    }
}
