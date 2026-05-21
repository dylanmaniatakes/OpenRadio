package s;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import f3.C0513e;
import java.util.ArrayList;

/* renamed from: s.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0879b {

    /* renamed from: d, reason: collision with root package name */
    public final C0878a f9540d;

    /* renamed from: a, reason: collision with root package name */
    public C0883f f9537a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f9538b = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9539c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f9541e = false;

    public C0879b(C0513e c0513e) {
        this.f9540d = new C0878a(this, c0513e);
    }

    public final void a(C0880c c0880c, int i5) {
        this.f9540d.j(c0880c.j(i5), 1.0f);
        this.f9540d.j(c0880c.j(i5), -1.0f);
    }

    public final void b(C0883f c0883f, C0883f c0883f2, C0883f c0883f3, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.f9538b = i5;
        }
        if (z4) {
            this.f9540d.j(c0883f, 1.0f);
            this.f9540d.j(c0883f2, -1.0f);
            this.f9540d.j(c0883f3, -1.0f);
        } else {
            this.f9540d.j(c0883f, -1.0f);
            this.f9540d.j(c0883f2, 1.0f);
            this.f9540d.j(c0883f3, 1.0f);
        }
    }

    public final void c(C0883f c0883f, C0883f c0883f2, C0883f c0883f3, int i5) {
        boolean z4 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z4 = true;
            }
            this.f9538b = i5;
        }
        if (z4) {
            this.f9540d.j(c0883f, 1.0f);
            this.f9540d.j(c0883f2, -1.0f);
            this.f9540d.j(c0883f3, 1.0f);
        } else {
            this.f9540d.j(c0883f, -1.0f);
            this.f9540d.j(c0883f2, 1.0f);
            this.f9540d.j(c0883f3, -1.0f);
        }
    }

    public C0883f d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f9537a == null && this.f9538b == BitmapDescriptorFactory.HUE_RED && this.f9540d.f() == 0;
    }

    public final C0883f f(boolean[] zArr, C0883f c0883f) {
        int i5;
        int iF = this.f9540d.f();
        C0883f c0883f2 = null;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < iF; i6++) {
            float fH = this.f9540d.h(i6);
            if (fH < BitmapDescriptorFactory.HUE_RED) {
                C0883f c0883fG = this.f9540d.g(i6);
                if ((zArr == null || !zArr[c0883fG.f9560k]) && c0883fG != c0883f && (((i5 = c0883fG.f9569u) == 3 || i5 == 4) && fH < f5)) {
                    f5 = fH;
                    c0883f2 = c0883fG;
                }
            }
        }
        return c0883f2;
    }

    public final void g(C0883f c0883f) {
        C0883f c0883f2 = this.f9537a;
        if (c0883f2 != null) {
            this.f9540d.j(c0883f2, -1.0f);
            this.f9537a.f9561l = -1;
            this.f9537a = null;
        }
        float fK = this.f9540d.k(c0883f, true) * (-1.0f);
        this.f9537a = c0883f;
        if (fK == 1.0f) {
            return;
        }
        this.f9538b /= fK;
        this.f9540d.d(fK);
    }

    public final void h(C0880c c0880c, C0883f c0883f, boolean z4) {
        if (c0883f == null || !c0883f.f9563o) {
            return;
        }
        float fE = this.f9540d.e(c0883f);
        this.f9538b = (c0883f.n * fE) + this.f9538b;
        this.f9540d.k(c0883f, z4);
        if (z4) {
            c0883f.b(this);
        }
        if (this.f9540d.f() == 0) {
            this.f9541e = true;
            c0880c.f9544a = true;
        }
    }

    public void i(C0880c c0880c, C0879b c0879b, boolean z4) {
        float fL = this.f9540d.l(c0879b, z4);
        this.f9538b = (c0879b.f9538b * fL) + this.f9538b;
        if (z4) {
            c0879b.f9537a.b(this);
        }
        if (this.f9537a == null || this.f9540d.f() != 0) {
            return;
        }
        this.f9541e = true;
        c0880c.f9544a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            s.f r0 = r10.f9537a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            s.f r1 = r10.f9537a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = com.unified.ur1.SatelliteTracker.h.b(r0, r1)
            float r1 = r10.f9538b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = s.AbstractC0882e.b(r0)
            float r1 = r10.f9538b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r3
            goto L36
        L35:
            r1 = r4
        L36:
            s.a r5 = r10.f9540d
            int r5 = r5.f()
        L3c:
            if (r4 >= r5) goto L9c
            s.a r6 = r10.f9540d
            s.f r6 = r6.g(r4)
            if (r6 != 0) goto L47
            goto L99
        L47:
            s.a r7 = r10.f9540d
            float r7 = r7.h(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = com.unified.ur1.SatelliteTracker.h.b(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = com.unified.ur1.SatelliteTracker.h.b(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = com.unified.ur1.SatelliteTracker.h.b(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = com.unified.ur1.SatelliteTracker.h.b(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r3
        L99:
            int r4 = r4 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r1 = "0.0"
            java.lang.String r0 = com.unified.ur1.SatelliteTracker.h.b(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s.C0879b.toString():java.lang.String");
    }
}
