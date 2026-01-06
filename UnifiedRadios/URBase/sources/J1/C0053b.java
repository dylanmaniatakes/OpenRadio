package J1;

import com.google.android.gms.internal.measurement.AbstractC0311d2;
import com.google.android.gms.internal.measurement.C0352l3;
import com.google.android.gms.internal.measurement.C0365o1;
import com.google.android.gms.internal.measurement.C0374q0;
import com.google.android.gms.internal.measurement.C0383s0;
import com.google.android.gms.internal.measurement.C0398v0;
import com.google.android.gms.internal.measurement.C0408x0;
import com.google.android.gms.internal.measurement.C0413y0;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* renamed from: J1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0053b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1114a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1115b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f1116c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f1117d;

    /* renamed from: e, reason: collision with root package name */
    public Long f1118e;

    /* renamed from: f, reason: collision with root package name */
    public Long f1119f;
    public final /* synthetic */ int g;
    public final /* synthetic */ C0056c h;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractC0311d2 f1120i;

    public C0053b(C0056c c0056c, String str, int i5, AbstractC0311d2 abstractC0311d2, int i6) {
        this.g = i6;
        this.h = c0056c;
        this.f1114a = str;
        this.f1115b = i5;
        this.f1120i = abstractC0311d2;
    }

    public static Boolean f(BigDecimal bigDecimal, C0398v0 c0398v0, double d5) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        q1.E.i(c0398v0);
        if (c0398v0.u()) {
            if (c0398v0.z() != 1) {
                if (c0398v0.z() == 5) {
                    if (!c0398v0.y() || !c0398v0.x()) {
                        return null;
                    }
                } else if (!c0398v0.v()) {
                    return null;
                }
                int iZ = c0398v0.z();
                if (c0398v0.z() == 5) {
                    if (C0060d0.n(c0398v0.s()) && C0060d0.n(c0398v0.r())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(c0398v0.s());
                            bigDecimal4 = new BigDecimal(c0398v0.r());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!C0060d0.n(c0398v0.q())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(c0398v0.q());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iZ == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i5 = iZ - 1;
                if (i5 == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i5 == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i5 != 3) {
                    if (i5 == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d5 != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d5).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d5).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    public static Boolean g(String str, C0413y0 c0413y0, Z z4) {
        List listS;
        q1.E.i(c0413y0);
        if (str == null || !c0413y0.w() || c0413y0.x() == 1) {
            return null;
        }
        if (c0413y0.x() == 7) {
            if (c0413y0.p() == 0) {
                return null;
            }
        } else if (!c0413y0.v()) {
            return null;
        }
        int iX = c0413y0.x();
        boolean zT = c0413y0.t();
        String strR = (zT || iX == 2 || iX == 7) ? c0413y0.r() : c0413y0.r().toUpperCase(Locale.ENGLISH);
        if (c0413y0.p() == 0) {
            listS = null;
        } else {
            listS = c0413y0.s();
            if (!zT) {
                ArrayList arrayList = new ArrayList(listS.size());
                Iterator it = listS.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listS = Collections.unmodifiableList(arrayList);
            }
        }
        String str2 = iX == 2 ? strR : null;
        if (iX == 7) {
            if (listS == null || listS.isEmpty()) {
                return null;
            }
        } else if (strR == null) {
            return null;
        }
        if (!zT && iX != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (iX - 1) {
            case 1:
                if (str2 != null) {
                    try {
                        break;
                    } catch (PatternSyntaxException unused) {
                        if (z4 == null) {
                            return null;
                        }
                        z4.f1080k.b(str2, "Invalid regular expression in REGEXP audience filter. expression");
                        return null;
                    }
                }
                break;
            case 6:
                if (listS != null) {
                    break;
                }
                break;
        }
        return null;
    }

    public static Boolean h(long j5, C0398v0 c0398v0) {
        try {
            return f(new BigDecimal(j5), c0398v0, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean i(Boolean bool, boolean z4) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z4);
    }

    public final int a() {
        switch (this.g) {
            case 0:
                return ((C0374q0) this.f1120i).q();
            default:
                return ((C0408x0) this.f1120i).p();
        }
    }

    public final boolean b() {
        switch (this.g) {
            case 0:
                return ((C0374q0) this.f1120i).B();
            default:
                return false;
        }
    }

    public final boolean c() {
        switch (this.g) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(java.lang.Long r19, java.lang.Long r20, com.google.android.gms.internal.measurement.X0 r21, long r22, J1.C0103s r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0053b.d(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.X0, long, J1.s, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean e(Long l5, Long l6, C0365o1 c0365o1, boolean z4) {
        C0352l3.a();
        C0113v0 c0113v0 = (C0113v0) this.h.f84c;
        boolean zW = c0113v0.f1415i.w(this.f1114a, H.f752C0);
        C0408x0 c0408x0 = (C0408x0) this.f1120i;
        boolean zU = c0408x0.u();
        boolean zV = c0408x0.v();
        boolean zW2 = c0408x0.w();
        Object[] objArr = zU || zV || zW2;
        Boolean boolI = null;
        boolF = null;
        Boolean boolF = null;
        boolI = null;
        boolI = null;
        boolI = null;
        Boolean boolF2 = null;
        boolI = null;
        Z z5 = c0113v0.f1417k;
        if (z4 && objArr != true) {
            C0113v0.k(z5);
            z5.f1084p.c(Integer.valueOf(this.f1115b), c0408x0.x() ? Integer.valueOf(c0408x0.p()) : null, "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID");
            return true;
        }
        C0383s0 c0383s0Q = c0408x0.q();
        boolean zU2 = c0383s0Q.u();
        boolean zG = c0365o1.G();
        S s4 = c0113v0.f1420o;
        if (zG) {
            if (c0383s0Q.w()) {
                boolI = i(h(c0365o1.r(), c0383s0Q.q()), zU2);
            } else {
                C0113v0.k(z5);
                z5.f1080k.b(s4.f(c0365o1.u()), "No number filter for long property. property");
            }
        } else if (c0365o1.E()) {
            if (c0383s0Q.w()) {
                double dP = c0365o1.p();
                try {
                    boolF = f(new BigDecimal(dP), c0383s0Q.q(), Math.ulp(dP));
                } catch (NumberFormatException unused) {
                }
                boolI = i(boolF, zU2);
            } else {
                C0113v0.k(z5);
                z5.f1080k.b(s4.f(c0365o1.u()), "No number filter for double property. property");
            }
        } else if (!c0365o1.I()) {
            C0113v0.k(z5);
            z5.f1080k.b(s4.f(c0365o1.u()), "User property has no value, property");
        } else if (c0383s0Q.y()) {
            String strV = c0365o1.v();
            C0413y0 c0413y0R = c0383s0Q.r();
            C0113v0.k(z5);
            boolI = i(g(strV, c0413y0R, z5), zU2);
        } else if (!c0383s0Q.w()) {
            C0113v0.k(z5);
            z5.f1080k.b(s4.f(c0365o1.u()), "No string or number filter defined. property");
        } else if (C0060d0.n(c0365o1.v())) {
            String strV2 = c0365o1.v();
            C0398v0 c0398v0Q = c0383s0Q.q();
            if (C0060d0.n(strV2)) {
                try {
                    boolF2 = f(new BigDecimal(strV2), c0398v0Q, 0.0d);
                } catch (NumberFormatException unused2) {
                }
            }
            boolI = i(boolF2, zU2);
        } else {
            C0113v0.k(z5);
            z5.f1080k.c(s4.f(c0365o1.u()), c0365o1.v(), "Invalid user property value for Numeric number filter. property, value");
        }
        C0113v0.k(z5);
        z5.f1084p.b(boolI == null ? "null" : boolI, "Property filter result");
        if (boolI == null) {
            return false;
        }
        this.f1116c = Boolean.TRUE;
        if (zW2 && !boolI.booleanValue()) {
            return true;
        }
        if (!z4 || c0408x0.u()) {
            this.f1117d = boolI;
        }
        if (boolI.booleanValue() && objArr != false && c0365o1.H()) {
            long jS = c0365o1.s();
            if (l5 != null) {
                jS = l5.longValue();
            }
            if (zW && c0408x0.u() && !c0408x0.v() && l6 != null) {
                jS = l6.longValue();
            }
            if (c0408x0.v()) {
                this.f1119f = Long.valueOf(jS);
            } else {
                this.f1118e = Long.valueOf(jS);
            }
        }
        return true;
    }
}
