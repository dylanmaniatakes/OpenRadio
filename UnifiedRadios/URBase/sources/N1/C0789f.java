package n1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.PendingIntentCompat;
import q1.Q;
import u1.AbstractC0907b;
import w1.C0931b;

/* renamed from: n1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0789f {

    /* renamed from: a, reason: collision with root package name */
    public static final int f8739a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0789f f8740b;

    static {
        int i5 = AbstractC0791h.f8746e;
        f8739a = 12451000;
        f8740b = new C0789f();
    }

    public Intent a(int i5, Context context, String str) {
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                return null;
            }
            int i6 = Q.f9343a;
            Uri uriFromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(uriFromParts);
            return intent;
        }
        if (context != null && AbstractC0907b.b(context)) {
            int i7 = Q.f9343a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder("gcore_");
        sb.append(f8739a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(C0931b.a(context).b(0, context.getPackageName()).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String string = sb.toString();
        int i8 = Q.f9343a;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder builderAppendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(string)) {
            builderAppendQueryParameter.appendQueryParameter("pcampaignid", string);
        }
        intent3.setData(builderAppendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public final PendingIntent b(int i5, Context context, String str) {
        Intent intentA = a(i5, context, str);
        if (intentA == null) {
            return null;
        }
        return PendingIntentCompat.getActivity(context, 0, intentA, 134217728, false);
    }

    public int c(Context context, int i5) {
        int iB = AbstractC0791h.b(context, i5);
        if (iB != 18 ? iB == 1 ? AbstractC0791h.c(context) : false : true) {
            return 18;
        }
        return iB;
    }
}
