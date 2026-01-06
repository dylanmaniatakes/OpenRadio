package J1;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class S1 extends M1 {
    public static final boolean m(String str) {
        String str2 = (String) H.f847t.a(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    public final String k(String str) {
        C0093o0 c0093o0 = this.f902d.f1017c;
        V1.J(c0093o0);
        String strZ = c0093o0.z(str);
        if (TextUtils.isEmpty(strZ)) {
            return (String) H.f842r.a(null);
        }
        Uri uri = Uri.parse((String) H.f842r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strZ + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }

    public final boolean l(String str, String str2) {
        V1 v12 = this.f902d;
        C0093o0 c0093o0 = v12.f1017c;
        V1.J(c0093o0);
        com.google.android.gms.internal.measurement.H0 h0Y = c0093o0.y(str);
        if (h0Y == null) {
            return false;
        }
        C0089n c0089n = v12.f1019e;
        V1.J(c0089n);
        V vG0 = c0089n.g0(str);
        if (vG0 == null) {
            return false;
        }
        if (!h0Y.I() || h0Y.w().p() != 100) {
            a2 a2Var = ((C0113v0) this.f84c).n;
            C0113v0.i(a2Var);
            if (!a2Var.a0(str, vG0.i())) {
                return !TextUtils.isEmpty(str2) && Math.abs(str2.hashCode() % 100) < h0Y.w().p();
            }
        }
        return true;
    }
}
