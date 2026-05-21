package J1;

import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Pair;
import j1.C0599a;
import j1.C0600b;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: J1.z1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0126z1 extends Q1 {

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f1468f;
    public final C0069g0 g;
    public final C0069g0 h;

    /* renamed from: i, reason: collision with root package name */
    public final C0069g0 f1469i;

    /* renamed from: j, reason: collision with root package name */
    public final C0069g0 f1470j;

    /* renamed from: k, reason: collision with root package name */
    public final C0069g0 f1471k;

    /* renamed from: l, reason: collision with root package name */
    public final C0069g0 f1472l;

    public C0126z1(V1 v12) {
        super(v12);
        this.f1468f = new HashMap();
        C0072h0 c0072h0 = ((C0113v0) this.f84c).f1416j;
        C0113v0.i(c0072h0);
        this.g = new C0069g0(c0072h0, "last_delete_stale", 0L);
        C0072h0 c0072h02 = ((C0113v0) this.f84c).f1416j;
        C0113v0.i(c0072h02);
        this.h = new C0069g0(c0072h02, "last_delete_stale_batch", 0L);
        C0072h0 c0072h03 = ((C0113v0) this.f84c).f1416j;
        C0113v0.i(c0072h03);
        this.f1469i = new C0069g0(c0072h03, "backoff", 0L);
        C0072h0 c0072h04 = ((C0113v0) this.f84c).f1416j;
        C0113v0.i(c0072h04);
        this.f1470j = new C0069g0(c0072h04, "last_upload", 0L);
        C0072h0 c0072h05 = ((C0113v0) this.f84c).f1416j;
        C0113v0.i(c0072h05);
        this.f1471k = new C0069g0(c0072h05, "last_upload_attempt", 0L);
        C0072h0 c0072h06 = ((C0113v0) this.f84c).f1416j;
        C0113v0.i(c0072h06);
        this.f1472l = new C0069g0(c0072h06, "midnight_offset", 0L);
    }

    @Override // J1.Q1
    public final void m() {
    }

    public final Pair n(String str) {
        C0123y1 c0123y1;
        C0599a c0599aA;
        j();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.f1421p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.f1468f;
        C0123y1 c0123y12 = (C0123y1) map.get(str);
        if (c0123y12 != null && jElapsedRealtime < c0123y12.f1463c) {
            return new Pair(c0123y12.f1461a, Boolean.valueOf(c0123y12.f1462b));
        }
        G g = H.f799b;
        C0068g c0068g = c0113v0.f1415i;
        long jR = c0068g.r(str, g) + jElapsedRealtime;
        try {
            try {
                c0599aA = C0600b.a(c0113v0.f1411c);
            } catch (PackageManager.NameNotFoundException unused) {
                if (c0123y12 != null && jElapsedRealtime < c0123y12.f1463c + c0068g.r(str, H.f802c)) {
                    return new Pair(c0123y12.f1461a, Boolean.valueOf(c0123y12.f1462b));
                }
                c0599aA = null;
            }
        } catch (Exception e5) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1083o.b(e5, "Unable to get advertising id");
            c0123y1 = new C0123y1("", false, jR);
        }
        if (c0599aA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String str2 = c0599aA.f7564c;
        boolean z5 = c0599aA.f7563b;
        c0123y1 = str2 != null ? new C0123y1(str2, z5, jR) : new C0123y1("", z5, jR);
        map.put(str, c0123y1);
        return new Pair(c0123y1.f1461a, Boolean.valueOf(c0123y1.f1462b));
    }

    public final String o(String str, boolean z4) {
        j();
        String str2 = z4 ? (String) n(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestU = a2.u();
        if (messageDigestU == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestU.digest(str2.getBytes())));
    }
}
