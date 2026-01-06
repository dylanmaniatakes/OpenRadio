package M0;

import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1681a = C0.t.f("PackageManagerHelper");

    public static void a(Context context, Class cls, boolean z4) {
        String str = f1681a;
        try {
            int componentEnabledSetting = context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, cls.getName()));
            boolean z5 = false;
            if (componentEnabledSetting != 0 && componentEnabledSetting == 1) {
                z5 = true;
            }
            if (z4 == z5) {
                C0.t.d().a(str, "Skipping component enablement for ".concat(cls.getName()));
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z4 ? 1 : 2, 1);
            C0.t tVarD = C0.t.d();
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z4 ? "enabled" : "disabled");
            tVarD.a(str, sb.toString());
        } catch (Exception e5) {
            C0.t tVarD2 = C0.t.d();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z4 ? "enabled" : "disabled");
            String string = sb2.toString();
            if (tVarD2.f174a <= 3) {
                Log.d(str, string, e5);
            }
        }
    }
}
