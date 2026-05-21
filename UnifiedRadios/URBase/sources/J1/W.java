package J1;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.IOException;
import java.util.Map;
import u1.AbstractC0907b;

/* loaded from: classes.dex */
public final class W implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1038j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final int f1039k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1040l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f1041m;
    public final Object n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f1042o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f1043p;

    public W(Z z4, int i5, String str, Object obj, Object obj2, Object obj3) {
        this.f1039k = i5;
        this.f1040l = str;
        this.f1041m = obj;
        this.n = obj2;
        this.f1042o = obj3;
        this.f1043p = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1038j) {
            case 0:
                Z z4 = (Z) this.f1043p;
                C0072h0 c0072h0 = ((C0113v0) z4.f84c).f1416j;
                C0113v0.i(c0072h0);
                if (!c0072h0.f733d) {
                    Log.println(6, z4.t(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                if (z4.f1076e == 0) {
                    C0068g c0068g = ((C0113v0) z4.f84c).f1415i;
                    if (c0068g.g == null) {
                        synchronized (c0068g) {
                            try {
                                if (c0068g.g == null) {
                                    C0113v0 c0113v0 = (C0113v0) c0068g.f84c;
                                    ApplicationInfo applicationInfo = c0113v0.f1411c.getApplicationInfo();
                                    if (AbstractC0907b.g == null) {
                                        AbstractC0907b.g = Application.getProcessName();
                                    }
                                    String str = AbstractC0907b.g;
                                    if (applicationInfo != null) {
                                        String str2 = applicationInfo.processName;
                                        c0068g.g = Boolean.valueOf(str2 != null && str2.equals(str));
                                    }
                                    if (c0068g.g == null) {
                                        c0068g.g = Boolean.TRUE;
                                        Z z5 = c0113v0.f1417k;
                                        C0113v0.k(z5);
                                        z5.h.a("My process not in the list of running processes");
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    if (c0068g.g.booleanValue()) {
                        z4.f1076e = 'C';
                    } else {
                        z4.f1076e = 'c';
                    }
                }
                if (z4.f1077f < 0) {
                    ((C0113v0) z4.f84c).f1415i.q();
                    z4.f1077f = 119002L;
                }
                char cCharAt = "01VDIWEA?".charAt(this.f1039k);
                char c2 = z4.f1076e;
                long j5 = z4.f1077f;
                String str3 = this.f1040l;
                String strR = Z.r(true, str3, this.f1041m, this.n, this.f1042o);
                StringBuilder sb = new StringBuilder("2");
                sb.append(cCharAt);
                sb.append(c2);
                sb.append(j5);
                String strE = com.unified.ur1.SatelliteTracker.h.e(sb, ":", strR);
                if (strE.length() > 1024) {
                    strE = str3.substring(0, 1024);
                }
                E0.d dVar = c0072h0.h;
                if (dVar != null) {
                    C0072h0 c0072h02 = (C0072h0) dVar.f460e;
                    c0072h02.j();
                    if (((C0072h0) dVar.f460e).p().getLong((String) dVar.f457b, 0L) == 0) {
                        dVar.d();
                    }
                    if (strE == null) {
                        strE = "";
                    }
                    SharedPreferences sharedPreferencesP = c0072h02.p();
                    String str4 = (String) dVar.f458c;
                    long j6 = sharedPreferencesP.getLong(str4, 0L);
                    String str5 = (String) dVar.f459d;
                    if (j6 <= 0) {
                        SharedPreferences.Editor editorEdit = c0072h02.p().edit();
                        editorEdit.putString(str5, strE);
                        editorEdit.putLong(str4, 1L);
                        editorEdit.apply();
                        return;
                    }
                    a2 a2Var = ((C0113v0) c0072h02.f84c).n;
                    C0113v0.i(a2Var);
                    long jNextLong = a2Var.v().nextLong() & Long.MAX_VALUE;
                    long j7 = j6 + 1;
                    long j8 = Long.MAX_VALUE / j7;
                    SharedPreferences.Editor editorEdit2 = c0072h02.p().edit();
                    if (jNextLong < j8) {
                        editorEdit2.putString(str5, strE);
                    }
                    editorEdit2.putLong(str4, j7);
                    editorEdit2.apply();
                    return;
                }
                return;
            default:
                ((InterfaceC0054b0) this.f1041m).h(this.f1040l, this.f1039k, (IOException) ((Throwable) this.n), (byte[]) this.f1042o, (Map) this.f1043p);
                return;
        }
    }

    public /* synthetic */ W(String str, InterfaceC0054b0 interfaceC0054b0, int i5, IOException iOException, byte[] bArr, Map map) {
        q1.E.i(interfaceC0054b0);
        this.f1041m = interfaceC0054b0;
        this.f1039k = i5;
        this.n = iOException;
        this.f1042o = bArr;
        this.f1040l = str;
        this.f1043p = map;
    }
}
