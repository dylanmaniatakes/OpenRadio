package J1;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import com.unified.ur1.R;
import java.io.File;

/* loaded from: classes.dex */
public abstract class L0 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f884a = {"ad_activeview", "ad_click", "ad_exposure", "ad_query", "ad_reward", "adunit_exposure", "app_clear_data", "app_exception", "app_remove", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "app_upgrade", "app_update", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "session_start_with_rollout", "user_engagement", "ad_impression", "screen_view", "ga_extra_parameter", "app_background", "firebase_campaign"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f885b = {"ad_impression"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f886c = {"_aa", "_ac", "_xa", "_aq", "_ar", "_xu", "_cd", "_ae", "_ui", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "_ug", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_ssr", "_e", "_ai", "_vs", "_ep", "_ab", "_cmp"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f887d = {"purchase", "refund", "add_payment_info", "add_shipping_info", "add_to_cart", "add_to_wishlist", "begin_checkout", "remove_from_cart", "select_item", "select_promotion", "view_cart", "view_item", "view_item_list", "view_promotion", "ecommerce_purchase", "purchase_refund", "set_checkout_option", "checkout_progress", "select_content", "view_search_results"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f888e = {"ga_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "ga_error", "ga_error_value", "ga_error_length", "ga_event_origin", "ga_screen", "ga_screen_class", "ga_screen_id", "ga_previous_screen", "ga_previous_class", "ga_previous_id", "manual_tracking", "message_device_time", "message_id", "message_name", "message_time", "message_tracking_id", "message_type", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "cached_campaign", "deferred_analytics_collection", "ga_session_number", "ga_session_id", "campaign_extra_referrer", "app_in_background", "firebase_feature_rollouts", "customer_buyer_stage", "firebase_conversion", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "session_number", "session_id"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f889f = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_mst", "_ndt", "_nmid", "_nmn", "_nmt", "_nmtid", "_nmc", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_cc", "_dac", "_sno", "_sid", "_cer", "_aib", "_ffr", "_cbs", "_c", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_sno", "_sid"};
    public static final String[] g = {"items"};
    public static final String[] h = {"affiliation", "coupon", "creative_name", "creative_slot", "currency", "_cbs", "discount", "index", "item_id", "item_brand", "item_category", "item_category2", "item_category3", "item_category4", "item_category5", "item_list_name", "item_list_id", "item_name", "item_variant", "location_id", "payment_type", "price", "promotion_id", "promotion_name", "quantity", "shipping", "shipping_tier", "tax", "transaction_id", "value", "item_list", "checkout_step", "checkout_option", "item_location_id"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f890i = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "last_advertising_id_reset", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f891j = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_lair", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    /* renamed from: k, reason: collision with root package name */
    public static O2.e f892k;

    public static Object a(Bundle bundle, String str, Class cls, Object obj) {
        Object obj2 = bundle.get(str);
        if (obj2 == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return obj2;
        }
        String canonicalName = cls.getCanonicalName();
        String canonicalName2 = obj2.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder("Invalid conditional user property field type. '");
        sb.append(str);
        sb.append("' expected [");
        sb.append(canonicalName);
        sb.append("] but was [");
        throw new IllegalStateException(com.unified.ur1.SatelliteTracker.h.e(sb, canonicalName2, "]"));
    }

    public static String b(Context context) {
        try {
            return context.getResources().getResourcePackageName(R.string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f A[Catch: SQLiteException -> 0x0099, TryCatch #0 {SQLiteException -> 0x0099, blocks: (B:22:0x0040, B:24:0x0061, B:26:0x006f, B:28:0x0077, B:29:0x007a, B:30:0x0098, B:34:0x009d, B:36:0x00a0, B:38:0x00a8, B:39:0x00af, B:40:0x00b2, B:42:0x00b8, B:45:0x00c7, B:46:0x00ca, B:23:0x005a), top: B:54:0x0040, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d A[Catch: SQLiteException -> 0x0099, LOOP:1: B:34:0x009d->B:39:0x00af, LOOP_START, PHI: r1
      0x009d: PHI (r1v5 int) = (r1v4 int), (r1v6 int) binds: [B:33:0x009b, B:39:0x00af] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {SQLiteException -> 0x0099, blocks: (B:22:0x0040, B:24:0x0061, B:26:0x006f, B:28:0x0077, B:29:0x007a, B:30:0x0098, B:34:0x009d, B:36:0x00a0, B:38:0x00a8, B:39:0x00af, B:40:0x00b2, B:42:0x00b8, B:45:0x00c7, B:46:0x00ca, B:23:0x005a), top: B:54:0x0040, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8 A[Catch: SQLiteException -> 0x0099, TryCatch #0 {SQLiteException -> 0x0099, blocks: (B:22:0x0040, B:24:0x0061, B:26:0x006f, B:28:0x0077, B:29:0x007a, B:30:0x0098, B:34:0x009d, B:36:0x00a0, B:38:0x00a8, B:39:0x00af, B:40:0x00b2, B:42:0x00b8, B:45:0x00c7, B:46:0x00ca, B:23:0x005a), top: B:54:0x0040, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(J1.Z r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.L0.c(J1.Z, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static String d(String str, String[] strArr, String[] strArr2) {
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i5 = 0; i5 < iMin; i5++) {
            String str2 = strArr[i5];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i5];
            }
        }
        return null;
    }

    public static void e(Z z4, SQLiteDatabase sQLiteDatabase) {
        if (z4 == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        String path = sQLiteDatabase.getPath();
        int i5 = com.google.android.gms.internal.measurement.D.f4670d;
        File file = new File(path);
        boolean readable = file.setReadable(false, false);
        X x4 = z4.f1080k;
        if (!readable) {
            x4.a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            x4.a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            x4.a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        x4.a("Failed to turn on database write permission for owner");
    }

    public static void f(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }

    public static String g(Context context, String str) {
        q1.E.i(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str)) {
            str = b(context);
        }
        int identifier = resources.getIdentifier("google_app_id", "string", str);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
