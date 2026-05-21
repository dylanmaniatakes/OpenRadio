package J1;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C0356m2;
import com.google.android.gms.internal.measurement.C0375q1;
import com.google.android.gms.internal.measurement.C0376q2;
import com.google.android.gms.internal.measurement.C0379r1;
import com.google.android.gms.internal.measurement.C0418z0;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: J1.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0093o0 extends Q1 implements InterfaceC0065f {

    /* renamed from: f, reason: collision with root package name */
    public final q.b f1326f;
    public final q.b g;
    public final q.b h;

    /* renamed from: i, reason: collision with root package name */
    public final q.b f1327i;

    /* renamed from: j, reason: collision with root package name */
    public final q.b f1328j;

    /* renamed from: k, reason: collision with root package name */
    public final q.b f1329k;

    /* renamed from: l, reason: collision with root package name */
    public final C0090n0 f1330l;

    /* renamed from: m, reason: collision with root package name */
    public final Z2.c f1331m;
    public final q.b n;

    /* renamed from: o, reason: collision with root package name */
    public final q.b f1332o;

    /* renamed from: p, reason: collision with root package name */
    public final q.b f1333p;

    public C0093o0(V1 v12) {
        super(v12);
        this.f1326f = new q.b();
        this.g = new q.b();
        this.h = new q.b();
        this.f1327i = new q.b();
        this.f1328j = new q.b();
        this.n = new q.b();
        this.f1332o = new q.b();
        this.f1333p = new q.b();
        this.f1329k = new q.b();
        this.f1330l = new C0090n0(this);
        this.f1331m = new Z2.c(9, this);
    }

    public static final q.b t(com.google.android.gms.internal.measurement.H0 h02) {
        q.b bVar = new q.b();
        for (com.google.android.gms.internal.measurement.L0 l02 : h02.C()) {
            bVar.put(l02.p(), l02.q());
        }
        return bVar;
    }

    public static final J0 u(int i5) {
        int i6 = i5 - 1;
        if (i6 == 1) {
            return J0.AD_STORAGE;
        }
        if (i6 == 2) {
            return J0.ANALYTICS_STORAGE;
        }
        if (i6 == 3) {
            return J0.AD_USER_DATA;
        }
        if (i6 != 4) {
            return null;
        }
        return J0.AD_PERSONALIZATION;
    }

    public final boolean A(String str, J0 j02) {
        j();
        r(str);
        com.google.android.gms.internal.measurement.C0 c0X = x(str);
        if (c0X == null) {
            return false;
        }
        Iterator it = c0X.r().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0418z0 c0418z0 = (C0418z0) it.next();
            if (j02 == u(c0418z0.q())) {
                if (c0418z0.p() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean B(String str, String str2) {
        Boolean bool;
        j();
        r(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f1327i.getOrDefault(str, null);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean C(String str, String str2) {
        Boolean bool;
        j();
        r(str);
        if ("1".equals(b(str, "measurement.upload.blacklist_internal")) && a2.e0(str2)) {
            return true;
        }
        if ("1".equals(b(str, "measurement.upload.blacklist_public")) && a2.f0(str2)) {
            return true;
        }
        Map map = (Map) this.h.getOrDefault(str, null);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x03ef, code lost:
    
        r7 = r1.c();
        r8 = new android.content.ContentValues();
        r8.put(r3, r27);
        r23 = r0;
        r8.put("audience_id", java.lang.Integer.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0408, code lost:
    
        if (r1.x() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x040a, code lost:
    
        r0 = java.lang.Integer.valueOf(r1.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0413, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0414, code lost:
    
        r8.put("filter_id", r0);
        r25 = r3;
        r8.put("property_name", r1.s());
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0426, code lost:
    
        if (r1.y() == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0428, code lost:
    
        r0 = java.lang.Boolean.valueOf(r1.w());
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0431, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0432, code lost:
    
        r8.put("session_scoped", r0);
        r8.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0446, code lost:
    
        if (r9.f0().insertWithOnConflict("property_filters", null, r8, 5) != (-1)) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0448, code lost:
    
        r0 = r5.f1417k;
        J1.C0113v0.k(r0);
        r0.h.b(J1.Z.q(r27), "Failed to insert property filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0459, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x045b, code lost:
    
        r0 = r23;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0461, code lost:
    
        r1 = r5.f1417k;
        J1.C0113v0.k(r1);
        r1.h.c(J1.Z.q(r27), r0, "Error storing property filter. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0471, code lost:
    
        r9.k();
        r9.j();
        q1.E.f(r27);
        r0 = r9.f0();
        r3 = r21;
        r0.delete("property_filters", r3, new java.lang.String[]{r27, java.lang.String.valueOf(r6)});
        r0.delete("event_filters", r3, new java.lang.String[]{r27, java.lang.String.valueOf(r6)});
        r21 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0498, code lost:
    
        r3 = r22;
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0280, code lost:
    
        r7 = r0.v().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x028c, code lost:
    
        if (r7.hasNext() == false) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0298, code lost:
    
        if (((com.google.android.gms.internal.measurement.C0408x0) r7.next()).x() != false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x029a, code lost:
    
        r0 = r5.f1417k;
        J1.C0113v0.k(r0);
        r0.f1080k.c(J1.Z.q(r27), java.lang.Integer.valueOf(r6), "Property filter with no ID. Audience definition ignored. appId, audienceId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x02b0, code lost:
    
        r7 = r0.u().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02bc, code lost:
    
        r22 = r3;
        r3 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02c8, code lost:
    
        if (r7.hasNext() == false) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x02ca, code lost:
    
        r8 = (com.google.android.gms.internal.measurement.C0374q0) r7.next();
        r9.k();
        r9.j();
        q1.E.f(r27);
        q1.E.i(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02e4, code lost:
    
        if (r8.u().isEmpty() == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02e6, code lost:
    
        r0 = r5.f1417k;
        J1.C0113v0.k(r0);
        r0 = r0.f1080k;
        r4 = J1.Z.q(r27);
        r5 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02fb, code lost:
    
        if (r8.C() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x02fd, code lost:
    
        r7 = java.lang.Integer.valueOf(r8.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0306, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0307, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r7));
        r24 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0312, code lost:
    
        r23 = r7;
        r7 = r8.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0318, code lost:
    
        r24 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x031a, code lost:
    
        r1 = new android.content.ContentValues();
        r1.put("app_id", r27);
        r1.put("audience_id", java.lang.Integer.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x032d, code lost:
    
        if (r8.C() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x032f, code lost:
    
        r3 = java.lang.Integer.valueOf(r8.q());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x033b, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x033c, code lost:
    
        r1.put("filter_id", r3);
        r1.put("event_name", r8.u());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x034c, code lost:
    
        if (r8.D() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x034e, code lost:
    
        r3 = java.lang.Boolean.valueOf(r8.A());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0357, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0358, code lost:
    
        r1.put("session_scoped", r3);
        r1.put("data", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x036c, code lost:
    
        if (r9.f0().insertWithOnConflict("event_filters", null, r1, 5) != (-1)) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x036e, code lost:
    
        r1 = r5.f1417k;
        J1.C0113v0.k(r1);
        r1.h.b(J1.Z.q(r27), "Failed to insert event filter (got -1). appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x037e, code lost:
    
        r3 = r22;
        r7 = r23;
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0386, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0387, code lost:
    
        r1 = r5.f1417k;
        J1.C0113v0.k(r1);
        r1.h.c(J1.Z.q(r27), r0, "Error storing event filter. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0399, code lost:
    
        r24 = r1;
        r0 = r0.v().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03a7, code lost:
    
        if (r0.hasNext() == false) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03a9, code lost:
    
        r1 = (com.google.android.gms.internal.measurement.C0408x0) r0.next();
        r9.k();
        r9.j();
        q1.E.f(r27);
        q1.E.i(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03c3, code lost:
    
        if (r1.s().isEmpty() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03c5, code lost:
    
        r0 = r5.f1417k;
        J1.C0113v0.k(r0);
        r0 = r0.f1080k;
        r4 = J1.Z.q(r27);
        r5 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03da, code lost:
    
        if (r1.x() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03dc, code lost:
    
        r1 = java.lang.Integer.valueOf(r1.p());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x03e5, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x03e6, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r1));
     */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05ea A[Catch: SQLiteException -> 0x05fb, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x05fb, blocks: (B:153:0x05d3, B:155:0x05ea), top: B:178:0x05d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0617  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.lang.String r27, byte[] r28, java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 1585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0093o0.D(java.lang.String, byte[], java.lang.String, java.lang.String):void");
    }

    @Override // J1.InterfaceC0065f
    public final String b(String str, String str2) {
        j();
        r(str);
        Map map = (Map) this.f1326f.getOrDefault(str, null);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    @Override // J1.Q1
    public final void m() {
    }

    public final boolean n(String str) {
        j();
        r(str);
        q.b bVar = this.g;
        return bVar.getOrDefault(str, null) != null && ((Set) bVar.getOrDefault(str, null)).contains("app_instance_id");
    }

    public final boolean o(String str) {
        j();
        r(str);
        q.b bVar = this.g;
        if (bVar.getOrDefault(str, null) != null) {
            return ((Set) bVar.getOrDefault(str, null)).contains("os_version") || ((Set) bVar.getOrDefault(str, null)).contains("device_info");
        }
        return false;
    }

    public final com.google.android.gms.internal.measurement.H0 p(String str, byte[] bArr) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.H0.v();
        }
        try {
            com.google.android.gms.internal.measurement.H0 h02 = (com.google.android.gms.internal.measurement.H0) ((com.google.android.gms.internal.measurement.G0) C0060d0.P(com.google.android.gms.internal.measurement.H0.u(), bArr)).e();
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1084p.c(h02.J() ? Long.valueOf(h02.r()) : null, h02.H() ? h02.x() : null, "Parsed config. version, gmp_app_id");
            return h02;
        } catch (C0356m2 e5) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.f1080k.c(Z.q(str), e5, "Unable to merge remote config. appId");
            return com.google.android.gms.internal.measurement.H0.v();
        } catch (RuntimeException e6) {
            Z z6 = c0113v0.f1417k;
            C0113v0.k(z6);
            z6.f1080k.c(Z.q(str), e6, "Unable to merge remote config. appId");
            return com.google.android.gms.internal.measurement.H0.v();
        }
    }

    public final void q(String str, com.google.android.gms.internal.measurement.G0 g02) {
        HashSet hashSet = new HashSet();
        q.b bVar = new q.b();
        q.b bVar2 = new q.b();
        q.b bVar3 = new q.b();
        Iterator it = Collections.unmodifiableList(((com.google.android.gms.internal.measurement.H0) g02.f4913k).A()).iterator();
        while (it.hasNext()) {
            hashSet.add(((com.google.android.gms.internal.measurement.D0) it.next()).p());
        }
        for (int i5 = 0; i5 < ((com.google.android.gms.internal.measurement.H0) g02.f4913k).q(); i5++) {
            com.google.android.gms.internal.measurement.E0 e02 = (com.google.android.gms.internal.measurement.E0) ((com.google.android.gms.internal.measurement.H0) g02.f4913k).t(i5).g();
            boolean zIsEmpty = e02.h().isEmpty();
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            if (zIsEmpty) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1080k.a("EventConfig contained null event name");
            } else {
                String strH = e02.h();
                String strD = L0.d(e02.h(), L0.f884a, L0.f886c);
                if (!TextUtils.isEmpty(strD)) {
                    e02.g();
                    com.google.android.gms.internal.measurement.F0.r((com.google.android.gms.internal.measurement.F0) e02.f4913k, strD);
                    g02.g();
                    com.google.android.gms.internal.measurement.H0.F((com.google.android.gms.internal.measurement.H0) g02.f4913k, i5, (com.google.android.gms.internal.measurement.F0) e02.e());
                }
                if (((com.google.android.gms.internal.measurement.F0) e02.f4913k).u() && ((com.google.android.gms.internal.measurement.F0) e02.f4913k).s()) {
                    bVar.put(strH, Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.F0) e02.f4913k).v() && ((com.google.android.gms.internal.measurement.F0) e02.f4913k).t()) {
                    bVar2.put(e02.h(), Boolean.TRUE);
                }
                if (((com.google.android.gms.internal.measurement.F0) e02.f4913k).w()) {
                    if (((com.google.android.gms.internal.measurement.F0) e02.f4913k).p() < 2 || ((com.google.android.gms.internal.measurement.F0) e02.f4913k).p() > 65535) {
                        Z z5 = c0113v0.f1417k;
                        C0113v0.k(z5);
                        z5.f1080k.c(e02.h(), Integer.valueOf(((com.google.android.gms.internal.measurement.F0) e02.f4913k).p()), "Invalid sampling rate. Event name, sample rate");
                    } else {
                        bVar3.put(e02.h(), Integer.valueOf(((com.google.android.gms.internal.measurement.F0) e02.f4913k).p()));
                    }
                }
            }
        }
        this.g.put(str, hashSet);
        this.h.put(str, bVar);
        this.f1327i.put(str, bVar2);
        this.f1329k.put(str, bVar3);
    }

    public final void r(String str) {
        k();
        j();
        q1.E.f(str);
        q.b bVar = this.f1328j;
        if (bVar.getOrDefault(str, null) == null) {
            C0089n c0089n = this.f902d.f1019e;
            V1.J(c0089n);
            L0.m mVarI0 = c0089n.i0(str);
            q.b bVar2 = this.f1333p;
            q.b bVar3 = this.f1332o;
            q.b bVar4 = this.n;
            q.b bVar5 = this.f1326f;
            if (mVarI0 != null) {
                com.google.android.gms.internal.measurement.G0 g02 = (com.google.android.gms.internal.measurement.G0) p(str, (byte[]) mVarI0.f1556d).g();
                q(str, g02);
                bVar5.put(str, t((com.google.android.gms.internal.measurement.H0) g02.e()));
                bVar.put(str, (com.google.android.gms.internal.measurement.H0) g02.e());
                s(str, (com.google.android.gms.internal.measurement.H0) g02.e());
                bVar4.put(str, ((com.google.android.gms.internal.measurement.H0) g02.f4913k).y());
                bVar3.put(str, (String) mVarI0.f1557e);
                bVar2.put(str, (String) mVarI0.f1558f);
                return;
            }
            bVar5.put(str, null);
            this.h.put(str, null);
            this.g.put(str, null);
            this.f1327i.put(str, null);
            bVar.put(str, null);
            bVar4.put(str, null);
            bVar3.put(str, null);
            bVar2.put(str, null);
            this.f1329k.put(str, null);
        }
    }

    public final void s(String str, com.google.android.gms.internal.measurement.H0 h02) {
        if (h02.p() == 0) {
            C0090n0 c0090n0 = this.f1330l;
            if (str == null) {
                c0090n0.getClass();
                throw new NullPointerException("key == null");
            }
            synchronized (c0090n0) {
                try {
                    if (c0090n0.f9257a.remove(str) != null) {
                        c0090n0.f9258b--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1084p.b(Integer.valueOf(h02.p()), "EES programs found");
        C0379r1 c0379r1 = (C0379r1) h02.B().get(0);
        try {
            com.google.android.gms.internal.measurement.E e5 = new com.google.android.gms.internal.measurement.E();
            ((HashMap) ((C0376q2) e5.f4677a.f1550f).f5023a).put("internal.remoteConfig", new CallableC0084l0(this, str, 0));
            ((HashMap) ((C0376q2) e5.f4677a.f1550f).f5023a).put("internal.appMetadata", new CallableC0084l0(this, str, 1));
            ((HashMap) ((C0376q2) e5.f4677a.f1550f).f5023a).put("internal.logger", new CallableC0087m0(this));
            e5.a(c0379r1);
            this.f1330l.c(str, e5);
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.f1084p.c(str, Integer.valueOf(c0379r1.p().p()), "EES program loaded for appId, activities");
            for (C0375q1 c0375q1 : c0379r1.p().r()) {
                Z z6 = c0113v0.f1417k;
                C0113v0.k(z6);
                z6.f1084p.b(c0375q1.p(), "EES program activity");
            }
        } catch (com.google.android.gms.internal.measurement.O unused) {
            Z z7 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z7);
            z7.h.b(str, "Failed to load EES program. appId");
        }
    }

    public final int v(String str, String str2) {
        Integer num;
        j();
        r(str);
        Map map = (Map) this.f1329k.getOrDefault(str, null);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final H0 w(String str, J0 j02) {
        j();
        r(str);
        com.google.android.gms.internal.measurement.C0 c0X = x(str);
        H0 h02 = H0.UNINITIALIZED;
        if (c0X == null) {
            return h02;
        }
        for (C0418z0 c0418z0 : c0X.t()) {
            if (u(c0418z0.q()) == j02) {
                int iP = c0418z0.p() - 1;
                return iP != 1 ? iP != 2 ? h02 : H0.DENIED : H0.GRANTED;
            }
        }
        return h02;
    }

    public final com.google.android.gms.internal.measurement.C0 x(String str) {
        j();
        r(str);
        com.google.android.gms.internal.measurement.H0 h0Y = y(str);
        if (h0Y == null || !h0Y.G()) {
            return null;
        }
        return h0Y.s();
    }

    public final com.google.android.gms.internal.measurement.H0 y(String str) {
        k();
        j();
        q1.E.f(str);
        r(str);
        return (com.google.android.gms.internal.measurement.H0) this.f1328j.getOrDefault(str, null);
    }

    public final String z(String str) {
        j();
        r(str);
        return (String) this.n.getOrDefault(str, null);
    }
}
