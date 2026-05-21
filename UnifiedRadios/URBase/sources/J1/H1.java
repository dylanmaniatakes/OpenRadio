package J1;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class H1 {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f864a;

    public H1(Map map) {
        HashMap map2 = new HashMap();
        this.f864a = map2;
        map2.putAll(map);
    }

    public final Bundle a() {
        G g = H.f822j1;
        boolean zBooleanValue = ((Boolean) g.a(null)).booleanValue();
        HashMap map = this.f864a;
        if (!zBooleanValue ? !(!"1".equals(map.get("GoogleConsent")) || !"1".equals(map.get("gdprApplies")) || !"1".equals(map.get("EnableAdvertiserConsentMode"))) : !(!"1".equals(map.get("gdprApplies")) || !"1".equals(map.get("EnableAdvertiserConsentMode")))) {
            if (((Boolean) g.a(null)).booleanValue() && map.get("Version") != null) {
                if (d() >= 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("ad_storage", true != Objects.equals(map.get("AuthorizePurpose1"), "1") ? "denied" : "granted");
                    bundle.putString("ad_personalization", (Objects.equals(map.get("AuthorizePurpose3"), "1") && Objects.equals(map.get("AuthorizePurpose4"), "1")) ? "granted" : "denied");
                    if (d() >= 4) {
                        bundle.putString("ad_user_data", (Objects.equals(map.get("AuthorizePurpose1"), "1") && Objects.equals(map.get("AuthorizePurpose7"), "1")) ? "granted" : "denied");
                    }
                    return bundle;
                }
            }
            return e();
        }
        return Bundle.EMPTY;
    }

    public final String b() throws NumberFormatException {
        HashMap map = this.f864a;
        StringBuilder sb = new StringBuilder("1");
        int i5 = -1;
        try {
            String str = (String) map.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i5 = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i5 < 0 || i5 > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i5 >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i5 & 63));
        }
        int iD = d();
        if (iD < 0 || iD > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(iD));
        }
        int i6 = true != "1".equals(map.get("gdprApplies")) ? 0 : 2;
        int i7 = i6 | 4;
        if ("1".equals(map.get("EnableAdvertiserConsentMode"))) {
            i7 = i6 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i7));
        return sb.toString();
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        y2.h hVar = J1.f877a;
        int i5 = hVar.f10502m;
        for (int i6 = 0; i6 < i5; i6++) {
            String str = (String) hVar.get(i6);
            HashMap map = this.f864a;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }

    public final int d() {
        try {
            String str = (String) this.f864a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final Bundle e() {
        int iD;
        HashMap map = this.f864a;
        if ("1".equals(map.get("GoogleConsent")) && (iD = d()) >= 0) {
            String str = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                String str2 = "denied";
                if (str.length() > 0) {
                    bundle.putString("ad_storage", str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString("ad_personalization", (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && iD >= 4) {
                    if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                        str2 = "granted";
                    }
                    bundle.putString("ad_user_data", str2);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof H1) {
            return c().equalsIgnoreCase(((H1) obj).c());
        }
        return false;
    }

    public final int hashCode() {
        return c().hashCode();
    }

    public final String toString() {
        return c();
    }
}
