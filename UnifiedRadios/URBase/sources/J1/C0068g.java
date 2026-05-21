package J1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import w1.C0931b;

/* renamed from: J1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0068g extends B.u {

    /* renamed from: d, reason: collision with root package name */
    public Boolean f1213d;

    /* renamed from: e, reason: collision with root package name */
    public String f1214e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC0065f f1215f;
    public Boolean g;

    public final boolean k() {
        ((C0113v0) this.f84c).getClass();
        Boolean boolU = u("firebase_analytics_collection_deactivated");
        return boolU != null && boolU.booleanValue();
    }

    public final boolean l(String str) {
        return "1".equals(this.f1215f.b(str, "measurement.event_sampling_enabled"));
    }

    public final boolean m() {
        if (this.f1213d == null) {
            Boolean boolU = u("app_measurement_lite");
            this.f1213d = boolU;
            if (boolU == null) {
                this.f1213d = Boolean.FALSE;
            }
        }
        return this.f1213d.booleanValue() || !((C0113v0) this.f84c).g;
    }

    public final String n(String str) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            q1.E.i(str2);
            return str2;
        } catch (ClassNotFoundException e5) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.b(e5, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e6) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.b(e6, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e7) {
            Z z6 = c0113v0.f1417k;
            C0113v0.k(z6);
            z6.h.b(e7, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e8) {
            Z z7 = c0113v0.f1417k;
            C0113v0.k(z7);
            z7.h.b(e8, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final double o(String str, G g) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) g.a(null)).doubleValue();
        }
        String strB = this.f1215f.b(str, g.f739a);
        if (TextUtils.isEmpty(strB)) {
            return ((Double) g.a(null)).doubleValue();
        }
        try {
            return ((Double) g.a(Double.valueOf(Double.parseDouble(strB)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) g.a(null)).doubleValue();
        }
    }

    public final int p(String str, G g) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) g.a(null)).intValue();
        }
        String strB = this.f1215f.b(str, g.f739a);
        if (TextUtils.isEmpty(strB)) {
            return ((Integer) g.a(null)).intValue();
        }
        try {
            return ((Integer) g.a(Integer.valueOf(Integer.parseInt(strB)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) g.a(null)).intValue();
        }
    }

    public final long q() {
        ((C0113v0) this.f84c).getClass();
        return 119002L;
    }

    public final long r(String str, G g) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) g.a(null)).longValue();
        }
        String strB = this.f1215f.b(str, g.f739a);
        if (TextUtils.isEmpty(strB)) {
            return ((Long) g.a(null)).longValue();
        }
        try {
            return ((Long) g.a(Long.valueOf(Long.parseLong(strB)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) g.a(null)).longValue();
        }
    }

    public final Bundle s() {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        try {
            Context context = c0113v0.f1411c;
            Context context2 = c0113v0.f1411c;
            PackageManager packageManager = context.getPackageManager();
            Z z4 = c0113v0.f1417k;
            if (packageManager == null) {
                C0113v0.k(z4);
                z4.h.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoA = C0931b.a(context2).a(128, context2.getPackageName());
            if (applicationInfoA != null) {
                return applicationInfoA.metaData;
            }
            C0113v0.k(z4);
            z4.h.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.b(e5, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final H0 t(String str, boolean z4) {
        Object obj;
        q1.E.f(str);
        Bundle bundleS = s();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (bundleS == null) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleS.get(str);
        }
        H0 h02 = H0.UNINITIALIZED;
        if (obj == null) {
            return h02;
        }
        if (Boolean.TRUE.equals(obj)) {
            return H0.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return H0.DENIED;
        }
        if (z4 && "eu_consent_policy".equals(obj)) {
            return H0.POLICY;
        }
        Z z6 = c0113v0.f1417k;
        C0113v0.k(z6);
        z6.f1080k.b(str, "Invalid manifest metadata for");
        return h02;
    }

    public final Boolean u(String str) {
        q1.E.f(str);
        Bundle bundleS = s();
        if (bundleS != null) {
            if (bundleS.containsKey(str)) {
                return Boolean.valueOf(bundleS.getBoolean(str));
            }
            return null;
        }
        Z z4 = ((C0113v0) this.f84c).f1417k;
        C0113v0.k(z4);
        z4.h.a("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final String v(String str, G g) {
        return TextUtils.isEmpty(str) ? (String) g.a(null) : (String) g.a(this.f1215f.b(str, g.f739a));
    }

    public final boolean w(String str, G g) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) g.a(null)).booleanValue();
        }
        String strB = this.f1215f.b(str, g.f739a);
        return TextUtils.isEmpty(strB) ? ((Boolean) g.a(null)).booleanValue() : ((Boolean) g.a(Boolean.valueOf("1".equals(strB)))).booleanValue();
    }

    public final boolean x() {
        Boolean boolU = u("google_analytics_automatic_screen_reporting_enabled");
        return boolU == null || boolU.booleanValue();
    }
}
