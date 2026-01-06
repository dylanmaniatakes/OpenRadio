package q1;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import n1.AbstractC0791h;
import org.conscrypt.FileClientSessionCache;
import u1.AbstractC0907b;
import w1.C0931b;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final q.k f9410a = new q.k();

    /* renamed from: b, reason: collision with root package name */
    public static Locale f9411b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            Context context2 = C0931b.a(context).f707a;
            return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context, int i5) {
        Resources resources = context.getResources();
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? resources.getString(R.string.ok) : resources.getString(com.unified.ur1.R.string.common_google_play_services_enable_button) : resources.getString(com.unified.ur1.R.string.common_google_play_services_update_button) : resources.getString(com.unified.ur1.R.string.common_google_play_services_install_button);
    }

    public static String c(Context context, int i5) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i5 == 1) {
            return resources.getString(com.unified.ur1.R.string.common_google_play_services_install_text, strA);
        }
        if (i5 == 2) {
            return AbstractC0907b.b(context) ? resources.getString(com.unified.ur1.R.string.common_google_play_services_wear_update_text) : resources.getString(com.unified.ur1.R.string.common_google_play_services_update_text, strA);
        }
        if (i5 == 3) {
            return resources.getString(com.unified.ur1.R.string.common_google_play_services_enable_text, strA);
        }
        if (i5 == 5) {
            return e(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i5 == 7) {
            return e(context, "common_google_play_services_network_error_text", strA);
        }
        if (i5 == 9) {
            return resources.getString(com.unified.ur1.R.string.common_google_play_services_unsupported_text, strA);
        }
        if (i5 == 20) {
            return e(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i5) {
            case 16:
                return e(context, "common_google_play_services_api_unavailable_text", strA);
            case o1.f.API_NOT_CONNECTED /* 17 */:
                return e(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(com.unified.ur1.R.string.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(com.unified.ur1.R.string.common_google_play_services_unknown_issue, strA);
        }
    }

    public static String d(Context context, int i5) {
        Resources resources = context.getResources();
        switch (i5) {
            case 1:
                return resources.getString(com.unified.ur1.R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(com.unified.ur1.R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(com.unified.ur1.R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return f(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return f(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case o1.f.ERROR /* 13 */:
            case o1.f.INTERRUPTED /* 14 */:
            case 15:
            case o1.f.REMOTE_EXCEPTION /* 19 */:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i5);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return f(context, "common_google_play_services_sign_in_failed_title");
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return f(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String e(Context context, String str, String str2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        String strF = f(context, str);
        if (strF == null) {
            strF = resources.getString(com.unified.ur1.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strF, str2);
    }

    public static String f(Context context, String str) {
        Resources resourcesForApplication;
        q.k kVar = f9410a;
        synchronized (kVar) {
            try {
                Locale locale = K.e.a(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(f9411b)) {
                    kVar.clear();
                    f9411b = locale;
                }
                String str2 = (String) kVar.getOrDefault(str, null);
                if (str2 != null) {
                    return str2;
                }
                int i5 = AbstractC0791h.f8746e;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication == null) {
                    return null;
                }
                int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: ".concat(str));
                    return null;
                }
                String string = resourcesForApplication.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    Log.w("GoogleApiAvailability", "Got empty resource: ".concat(str));
                    return null;
                }
                f9410a.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
