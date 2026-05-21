package J1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.C0305c1;
import com.google.android.gms.internal.measurement.C0310d1;
import com.google.android.gms.internal.measurement.C0315e1;
import com.google.android.gms.internal.measurement.C0320f1;
import com.google.android.gms.internal.measurement.C0337i3;
import com.google.android.gms.internal.measurement.InterfaceC0342j3;
import com.google.android.gms.internal.measurement.M3;
import g0.AbstractC0535a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import u1.C0906a;

/* renamed from: J1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0089n extends Q1 {
    public static final String[] h = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f1304i = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f1305j = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f1306k = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f1307l = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f1308m = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] n = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f1309o = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f1310p = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f1311q = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f1312r = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    /* renamed from: f, reason: collision with root package name */
    public final C0086m f1313f;
    public final U g;

    public C0089n(V1 v12) {
        super(v12);
        this.g = new U(((C0113v0) this.f84c).f1421p);
        ((C0113v0) this.f84c).getClass();
        this.f1313f = new C0086m(this, ((C0113v0) this.f84c).f1411c);
    }

    public static final String S(List list) {
        return list.isEmpty() ? "" : AbstractC0535a.l(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    public static final void Z(ContentValues contentValues, Object obj) {
        q1.E.f("value");
        q1.E.i(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    public final void A(Long l5) {
        String str;
        j();
        k();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0113v0.f1415i.w(null, H.f771M0) && U()) {
            long jA0 = a0("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + l5 + " AND retry_count =  2147483647 LIMIT 1", null);
            Z z4 = c0113v0.f1417k;
            if (jA0 > 0) {
                C0113v0.k(z4);
                z4.f1080k.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseF0 = f0();
                if (c0113v0.f1415i.w(null, H.f776P0)) {
                    c0113v0.f1421p.getClass();
                    str = " SET retry_count = retry_count + 1, last_upload_timestamp = " + System.currentTimeMillis();
                } else {
                    str = " SET retry_count = retry_count + 1 ";
                }
                sQLiteDatabaseF0.execSQL("UPDATE upload_queue" + str + " WHERE rowid = " + l5 + " AND retry_count < 2147483647");
            } catch (SQLiteException e5) {
                C0113v0.k(z4);
                z4.h.b(e5, "Error incrementing retry count. error");
            }
        }
    }

    public final void B() {
        j();
        k();
        if (U()) {
            V1 v12 = this.f902d;
            long jA = v12.f1023k.g.a();
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            c0113v0.f1421p.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) H.f768L.a(null)).longValue()) {
                v12.f1023k.g.b(jElapsedRealtime);
                j();
                k();
                if (U()) {
                    SQLiteDatabase sQLiteDatabaseF0 = f0();
                    c0113v0.f1421p.getClass();
                    int iDelete = sQLiteDatabaseF0.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) H.f777Q.a(null)).longValue())});
                    if (iDelete > 0) {
                        Z z4 = c0113v0.f1417k;
                        C0113v0.k(z4);
                        z4.f1084p.b(Integer.valueOf(iDelete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    public final void C(String str, String str2) {
        q1.E.f(str);
        q1.E.f(str2);
        j();
        k();
        try {
            f0().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.d("Error deleting user property. appId", Z.q(str), c0113v0.f1420o.f(str2), e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.D(java.lang.String):void");
    }

    public final void E() {
        k();
        f0().setTransactionSuccessful();
    }

    public final void F(V v4, boolean z4) {
        j();
        k();
        String strC = v4.c();
        q1.E.i(strC);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strC);
        J0 j02 = J0.ANALYTICS_STORAGE;
        V1 v12 = this.f902d;
        if (z4) {
            contentValues.put("app_instance_id", (String) null);
        } else if (v12.j0(strC).k(j02)) {
            contentValues.put("app_instance_id", v4.d());
        }
        contentValues.put("gmp_app_id", v4.g());
        boolean zK = v12.j0(strC).k(J0.AD_STORAGE);
        C0113v0 c0113v0 = v4.f980a;
        if (zK) {
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.j();
            contentValues.put("resettable_device_id_hash", v4.f984e);
        }
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.j();
        contentValues.put("last_bundle_index", Long.valueOf(v4.g));
        C0104s0 c0104s03 = c0113v0.f1418l;
        C0113v0.k(c0104s03);
        c0104s03.j();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(v4.h));
        C0104s0 c0104s04 = c0113v0.f1418l;
        C0113v0.k(c0104s04);
        c0104s04.j();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(v4.f986i));
        contentValues.put("app_version", v4.e());
        C0104s0 c0104s05 = c0113v0.f1418l;
        C0113v0.k(c0104s05);
        c0104s05.j();
        contentValues.put("app_store", v4.f989l);
        C0104s0 c0104s06 = c0113v0.f1418l;
        C0113v0.k(c0104s06);
        c0104s06.j();
        contentValues.put("gmp_version", Long.valueOf(v4.f990m));
        C0104s0 c0104s07 = c0113v0.f1418l;
        C0113v0.k(c0104s07);
        c0104s07.j();
        contentValues.put("dev_cert_hash", Long.valueOf(v4.n));
        C0104s0 c0104s08 = c0113v0.f1418l;
        C0113v0.k(c0104s08);
        c0104s08.j();
        contentValues.put("measurement_enabled", Boolean.valueOf(v4.f991o));
        C0104s0 c0104s09 = c0113v0.f1418l;
        C0113v0.k(c0104s09);
        c0104s09.j();
        contentValues.put("day", Long.valueOf(v4.f970K));
        C0104s0 c0104s010 = c0113v0.f1418l;
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("daily_public_events_count", Long.valueOf(v4.f971L));
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("daily_events_count", Long.valueOf(v4.f972M));
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("daily_conversions_count", Long.valueOf(v4.f973N));
        C0104s0 c0104s011 = c0113v0.f1418l;
        C0113v0.k(c0104s011);
        c0104s011.j();
        contentValues.put("config_fetched_time", Long.valueOf(v4.f978S));
        C0104s0 c0104s012 = c0113v0.f1418l;
        C0113v0.k(c0104s012);
        c0104s012.j();
        contentValues.put("failed_config_fetch_time", Long.valueOf(v4.f979T));
        contentValues.put("app_version_int", Long.valueOf(v4.S()));
        contentValues.put("firebase_instance_id", v4.f());
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("daily_error_events_count", Long.valueOf(v4.f974O));
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("daily_realtime_events_count", Long.valueOf(v4.f975P));
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("health_monitor_sample", v4.f976Q);
        contentValues.put("android_id", (Long) 0L);
        C0104s0 c0104s013 = c0113v0.f1418l;
        C0113v0.k(c0104s013);
        c0104s013.j();
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(v4.f992p));
        contentValues.put("admob_app_id", v4.a());
        contentValues.put("dynamite_version", Long.valueOf(v4.T()));
        if (v12.j0(strC).k(j02)) {
            C0104s0 c0104s014 = c0113v0.f1418l;
            C0113v0.k(c0104s014);
            c0104s014.j();
            contentValues.put("session_stitching_token", v4.f997u);
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(v4.t()));
        C0104s0 c0104s015 = c0113v0.f1418l;
        C0113v0.k(c0104s015);
        c0104s015.j();
        contentValues.put("target_os_version", Long.valueOf(v4.f999w));
        C0104s0 c0104s016 = c0113v0.f1418l;
        C0113v0.k(c0104s016);
        c0104s016.j();
        contentValues.put("session_stitching_token_hash", Long.valueOf(v4.f1000x));
        M3.b();
        C0113v0 c0113v02 = (C0113v0) this.f84c;
        if (c0113v02.f1415i.w(strC, H.f787V0)) {
            C0104s0 c0104s017 = c0113v0.f1418l;
            C0113v0.k(c0104s017);
            c0104s017.j();
            contentValues.put("ad_services_version", Integer.valueOf(v4.f1001y));
            C0104s0 c0104s018 = c0113v0.f1418l;
            C0113v0.k(c0104s018);
            c0104s018.j();
            contentValues.put("attribution_eligibility_status", Long.valueOf(v4.f963C));
        }
        C0104s0 c0104s019 = c0113v0.f1418l;
        C0113v0.k(c0104s019);
        c0104s019.j();
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(v4.f1002z));
        contentValues.put("npa_metadata_value", v4.U());
        C0104s0 c0104s020 = c0113v0.f1418l;
        C0113v0.k(c0104s020);
        c0104s020.j();
        contentValues.put("bundle_delivery_index", Long.valueOf(v4.f967G));
        contentValues.put("sgtm_preview_key", v4.i());
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("dma_consent_state", Integer.valueOf(v4.f965E));
        C0113v0.k(c0104s010);
        c0104s010.j();
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(v4.f966F));
        contentValues.put("serialized_npa_metadata", v4.h());
        G g = H.f776P0;
        C0068g c0068g = c0113v02.f1415i;
        if (c0068g.w(strC, g)) {
            contentValues.put("client_upload_eligibility", Integer.valueOf(v4.R()));
        }
        C0104s0 c0104s021 = c0113v0.f1418l;
        C0113v0.k(c0104s021);
        c0104s021.j();
        ArrayList arrayList = v4.f996t;
        Z z5 = c0113v02.f1417k;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                C0113v0.k(z5);
                z5.f1080k.b(strC, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        ((InterfaceC0342j3) C0337i3.f4960k.f4961j.f10447j).getClass();
        if (c0068g.w(null, H.f765J0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        C0104s0 c0104s022 = c0113v0.f1418l;
        C0113v0.k(c0104s022);
        c0104s022.j();
        contentValues.put("unmatched_pfo", v4.f961A);
        C0104s0 c0104s023 = c0113v0.f1418l;
        C0113v0.k(c0104s023);
        c0104s023.j();
        contentValues.put("unmatched_uwa", v4.f962B);
        C0104s0 c0104s024 = c0113v0.f1418l;
        C0113v0.k(c0104s024);
        c0104s024.j();
        contentValues.put("ad_campaign_info", v4.I);
        try {
            SQLiteDatabase sQLiteDatabaseF0 = f0();
            if (sQLiteDatabaseF0.update("apps", contentValues, "app_id = ?", new String[]{strC}) == 0 && sQLiteDatabaseF0.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                C0113v0.k(z5);
                z5.h.b(Z.q(strC), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e5) {
            C0113v0.k(z5);
            z5.h.c(Z.q(strC), e5, "Error storing app. appId");
        }
    }

    public final void G(String str, K0 k02) {
        q1.E.i(str);
        j();
        k();
        H(str, n0(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", k02.j());
        R(contentValues);
    }

    public final void H(String str, K0 k02) {
        q1.E.i(str);
        q1.E.i(k02);
        j();
        k();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", k02.j());
        contentValues.put("consent_source", Integer.valueOf(k02.f880b));
        R(contentValues);
    }

    public final boolean I(String str) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0113v0.f1415i.w(null, H.f771M0)) {
            if (c0113v0.f1415i.w(null, H.f776P0)) {
                EnumC0079j1[] enumC0079j1Arr = {EnumC0079j1.GOOGLE_SIGNAL};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(enumC0079j1Arr[0].f1277j));
                String strS = S(arrayList);
                String strN = N();
                StringBuilder sb = new StringBuilder("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
                sb.append(strS);
                sb.append(" AND NOT ");
                sb.append(strN);
                return a0(sb.toString(), new String[]{str}) != 0;
            }
            if (a0("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=? AND NOT ".concat(N()), new String[]{str}) != 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean J(String str, String str2) {
        return a0("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final void K(String str, String str2) {
        q1.E.f(str);
        q1.E.f(str2);
        j();
        k();
        try {
            f0().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e5) {
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.d("Error deleting conditional property", Z.q(str), c0113v0.f1420o.f(str2), e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.C0103s L(java.lang.String r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.L(java.lang.String, java.lang.String, java.lang.String):J1.s");
    }

    public final W1 M(String str, long j5, byte[] bArr, String str2, String str3, int i5, int i6, long j6, long j7, long j8) {
        EnumC0079j1 enumC0079j1;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (zIsEmpty) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1083o.a("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            C0305c1 c0305c1 = (C0305c1) C0060d0.P(C0310d1.q(), bArr);
            EnumC0079j1[] enumC0079j1ArrValues = EnumC0079j1.values();
            int length = enumC0079j1ArrValues.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    enumC0079j1 = EnumC0079j1.UNKNOWN;
                    break;
                }
                enumC0079j1 = enumC0079j1ArrValues[i7];
                if (enumC0079j1.f1277j == i5) {
                    break;
                }
                i7++;
            }
            if (enumC0079j1 != EnumC0079j1.GOOGLE_SIGNAL && enumC0079j1 != EnumC0079j1.GOOGLE_SIGNAL_PENDING && i6 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = Collections.unmodifiableList(((C0310d1) c0305c1.f4913k).v()).iterator();
                while (it.hasNext()) {
                    C0315e1 c0315e1 = (C0315e1) ((C0320f1) it.next()).g();
                    c0315e1.g();
                    C0320f1.w1((C0320f1) c0315e1.f4913k, i6);
                    arrayList.add((C0320f1) c0315e1.e());
                }
                c0305c1.g();
                C0310d1.y((C0310d1) c0305c1.f4913k);
                c0305c1.g();
                C0310d1.w((C0310d1) c0305c1.f4913k, arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length2 = strArrSplit.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length2) {
                        break;
                    }
                    String str4 = strArrSplit[i8];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        Z z5 = c0113v0.f1417k;
                        C0113v0.k(z5);
                        z5.h.b(str4, "Invalid upload header: ");
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i8++;
                }
            }
            return new W1(j5, (C0310d1) c0305c1.e(), str2, map, enumC0079j1, j7, j8, i6);
        } catch (IOException e5) {
            Z z6 = c0113v0.f1417k;
            C0113v0.k(z6);
            z6.h.c(str, e5, "Failed to queued MeasurementBatch from upload_queue. appId");
            return null;
        }
    }

    public final String N() {
        ((C0113v0) this.f84c).f1421p.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Locale locale = Locale.US;
        Long l5 = (Long) H.f779R.a(null);
        l5.getClass();
        return "(" + ("(upload_type = 1 AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + l5 + ")") + " OR " + ("(upload_type != 1 AND ABS(creation_timestamp - " + jCurrentTimeMillis + ") > " + ((Long) H.f777Q.a(null)).longValue() + ")") + ")";
    }

    public final String O(String str, String[] strArr) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = f0().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return "";
                }
                String string = cursorRawQuery.getString(0);
                cursorRawQuery.close();
                return string;
            } catch (SQLiteException e5) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.h.c(str, e5, "Database error");
                throw e5;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final void P(String str, String str2) {
        q1.E.f(str2);
        j();
        k();
        try {
            f0().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.h.c(Z.q(str2), e5, "Error deleting snapshot. appId");
        }
    }

    public final void Q(String str, C0103s c0103s) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        q1.E.i(c0103s);
        j();
        k();
        ContentValues contentValues = new ContentValues();
        String str2 = c0103s.f1369a;
        contentValues.put("app_id", str2);
        contentValues.put("name", c0103s.f1370b);
        contentValues.put("lifetime_count", Long.valueOf(c0103s.f1371c));
        contentValues.put("current_bundle_count", Long.valueOf(c0103s.f1372d));
        contentValues.put("last_fire_timestamp", Long.valueOf(c0103s.f1374f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(c0103s.g));
        contentValues.put("last_bundled_day", c0103s.h);
        contentValues.put("last_sampled_complex_event_id", c0103s.f1375i);
        contentValues.put("last_sampling_rate", c0103s.f1376j);
        contentValues.put("current_session_count", Long.valueOf(c0103s.f1373e));
        Boolean bool = c0103s.f1377k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (f0().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.h.b(Z.q(str2), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e5) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.c(Z.q(str2), e5, "Error storing event aggregates. appId");
        }
    }

    public final void R(ContentValues contentValues) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        try {
            SQLiteDatabase sQLiteDatabaseF0 = f0();
            if (contentValues.getAsString("app_id") == null) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1079j.b(Z.q("app_id"), "Value of the primary key is not set.");
            } else if (sQLiteDatabaseF0.update("consent_settings", contentValues, "app_id = ?", new String[]{r4}) == 0 && sQLiteDatabaseF0.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.h.c(Z.q("consent_settings"), Z.q("app_id"), "Failed to insert/update table (got -1). key");
            }
        } catch (SQLiteException e5) {
            Z z6 = c0113v0.f1417k;
            C0113v0.k(z6);
            z6.h.d("Error storing into table. key", Z.q("consent_settings"), Z.q("app_id"), e5);
        }
    }

    public final void T(String str, K1 k1) {
        j();
        k();
        q1.E.f(str);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.f1421p.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        G g = H.f850u0;
        long jLongValue = jCurrentTimeMillis - ((Long) g.a(null)).longValue();
        long j5 = k1.f882k;
        Z z4 = c0113v0.f1417k;
        if (j5 < jLongValue || j5 > ((Long) g.a(null)).longValue() + jCurrentTimeMillis) {
            C0113v0.k(z4);
            z4.f1080k.d("Storing trigger URI outside of the max retention time span. appId, now, timestamp", Z.q(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j5));
        }
        C0113v0.k(z4);
        z4.f1084p.a("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", k1.f881j);
        contentValues.put("source", Integer.valueOf(k1.f883l));
        contentValues.put("timestamp_millis", Long.valueOf(j5));
        try {
            if (f0().insert("trigger_uris", null, contentValues) == -1) {
                C0113v0.k(z4);
                z4.h.b(Z.q(str), "Failed to insert trigger URI (got -1). appId");
            }
        } catch (SQLiteException e5) {
            C0113v0.k(z4);
            z4.h.c(Z.q(str), e5, "Error storing trigger URI. appId");
        }
    }

    public final boolean U() {
        return ((C0113v0) this.f84c).f1411c.getDatabasePath("google_app_measurement.db").exists();
    }

    public final void V(String str, Long l5, long j5, com.google.android.gms.internal.measurement.X0 x02) {
        j();
        k();
        q1.E.i(x02);
        q1.E.f(str);
        byte[] bArrC = x02.c();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        Z z4 = c0113v0.f1417k;
        Z z5 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1084p.c(c0113v0.f1420o.d(str), Integer.valueOf(bArrC.length), "Saving complex main event, appId, data size");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l5);
        contentValues.put("children_to_process", Long.valueOf(j5));
        contentValues.put("main_event", bArrC);
        try {
            if (f0().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                C0113v0.k(z5);
                z5.h.b(Z.q(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e5) {
            C0113v0.k(z5);
            z5.h.c(Z.q(str), e5, "Error storing complex main event. appId");
        }
    }

    public final boolean W(C0062e c0062e) {
        j();
        k();
        String str = c0062e.f1191j;
        q1.E.i(str);
        Z1 z1P0 = p0(str, c0062e.f1193l.f1071k);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (z1P0 == null) {
            long jA0 = a0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            c0113v0.getClass();
            if (jA0 >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", c0062e.f1192k);
        contentValues.put("name", c0062e.f1193l.f1071k);
        Object objA = c0062e.f1193l.a();
        q1.E.i(objA);
        Z(contentValues, objA);
        contentValues.put("active", Boolean.valueOf(c0062e.n));
        contentValues.put("trigger_event_name", c0062e.f1195o);
        contentValues.put("trigger_timeout", Long.valueOf(c0062e.f1197q));
        a2 a2Var = c0113v0.n;
        Z z4 = c0113v0.f1417k;
        C0113v0.i(a2Var);
        contentValues.put("timed_out_event", a2.k0(c0062e.f1196p));
        contentValues.put("creation_timestamp", Long.valueOf(c0062e.f1194m));
        C0113v0.i(c0113v0.n);
        contentValues.put("triggered_event", a2.k0(c0062e.f1198r));
        contentValues.put("triggered_timestamp", Long.valueOf(c0062e.f1193l.f1072l));
        contentValues.put("time_to_live", Long.valueOf(c0062e.f1199s));
        contentValues.put("expired_event", a2.k0(c0062e.f1200t));
        try {
            if (f0().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            C0113v0.k(z4);
            z4.h.b(Z.q(str), "Failed to insert/update conditional user property (got -1)");
            return true;
        } catch (SQLiteException e5) {
            C0113v0.k(z4);
            z4.h.c(Z.q(str), e5, "Error storing conditional user property");
            return true;
        }
    }

    public final boolean X(Z1 z12) {
        j();
        k();
        String str = z12.f1090a;
        String str2 = z12.f1092c;
        Z1 z1P0 = p0(str, str2);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        String str3 = z12.f1091b;
        if (z1P0 == null) {
            if (a2.f0(str2)) {
                if (a0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= Math.max(Math.min(c0113v0.f1415i.p(str, H.f784U), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jA0 = a0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, str3});
                c0113v0.getClass();
                if (jA0 >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", str3);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(z12.f1093d));
        Z(contentValues, z12.f1094e);
        try {
            if (f0().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.b(Z.q(str), "Failed to insert/update user property (got -1). appId");
            return true;
        } catch (SQLiteException e5) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.c(Z.q(str), e5, "Error storing user property. appId");
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc A[Catch: all -> 0x006f, SQLiteException -> 0x0072, TryCatch #3 {SQLiteException -> 0x0072, blocks: (B:19:0x0067, B:40:0x00b8, B:42:0x00dc, B:43:0x00ee, B:44:0x00f3, B:45:0x0103, B:47:0x0109, B:48:0x0119, B:50:0x0122, B:53:0x0136, B:55:0x0156, B:56:0x015f, B:57:0x0169, B:62:0x01a4, B:61:0x0194, B:65:0x01ab, B:52:0x012f, B:67:0x01bd), top: B:83:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ee A[Catch: all -> 0x006f, SQLiteException -> 0x0072, TRY_LEAVE, TryCatch #3 {SQLiteException -> 0x0072, blocks: (B:19:0x0067, B:40:0x00b8, B:42:0x00dc, B:43:0x00ee, B:44:0x00f3, B:45:0x0103, B:47:0x0109, B:48:0x0119, B:50:0x0122, B:53:0x0136, B:55:0x0156, B:56:0x015f, B:57:0x0169, B:62:0x01a4, B:61:0x0194, B:65:0x01ab, B:52:0x012f, B:67:0x01bd), top: B:83:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(java.lang.String r21, long r22, long r24, E0.d r26) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.Y(java.lang.String, long, long, E0.d):void");
    }

    public final long a0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = f0().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j5 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j5;
            } catch (SQLiteException e5) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.h.c(str, e5, "Database error");
                throw e5;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long b0(String str, String[] strArr, long j5) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = f0().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j5 = cursorRawQuery.getLong(0);
                }
                cursorRawQuery.close();
                return j5;
            } catch (SQLiteException e5) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.h.c(str, e5, "Database error");
                throw e5;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long c0(String str, C0310d1 c0310d1, String str2, Map map, EnumC0079j1 enumC0079j1, Long l5) {
        int iDelete;
        j();
        k();
        q1.E.i(c0310d1);
        q1.E.f(str);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (!c0113v0.f1415i.w(null, H.f771M0)) {
            return -1L;
        }
        j();
        k();
        boolean zU = U();
        C0906a c0906a = c0113v0.f1421p;
        Z z4 = c0113v0.f1417k;
        if (zU) {
            V1 v12 = this.f902d;
            long jA = v12.f1023k.h.a();
            c0906a.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jA) > ((Long) H.f768L.a(null)).longValue()) {
                v12.f1023k.h.b(jElapsedRealtime);
                j();
                k();
                if (U() && (iDelete = f0().delete("upload_queue", N(), new String[0])) > 0) {
                    C0113v0.k(z4);
                    z4.f1084p.b(Integer.valueOf(iDelete), "Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted");
                }
                G g = H.f776P0;
                C0068g c0068g = c0113v0.f1415i;
                if (c0068g.w(null, g)) {
                    q1.E.f(str);
                    j();
                    k();
                    try {
                        int iP = c0068g.p(str, H.f747A);
                        if (iP > 0) {
                            f0().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iP)});
                        }
                    } catch (SQLiteException e5) {
                        C0113v0.k(z4);
                        z4.h.c(Z.q(str), e5, "Error deleting over the limit queued batches. appId");
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        byte[] bArrC = c0310d1.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrC);
        contentValues.put("upload_uri", str2);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) "\r\n");
            }
        }
        contentValues.put("upload_headers", sb.toString());
        contentValues.put("upload_type", Integer.valueOf(enumC0079j1.f1277j));
        c0906a.getClass();
        contentValues.put("creation_timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l5 != null) {
            contentValues.put("associated_row_id", l5);
        }
        try {
            long jInsert = f0().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            C0113v0.k(z4);
            z4.h.b(str, "Failed to insert MeasurementBatch (got -1) to upload_queue. appId");
            return -1L;
        } catch (SQLiteException e6) {
            C0113v0.k(z4);
            z4.h.c(str, e6, "Error storing MeasurementBatch to upload_queue. appId");
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0089 A[Catch: all -> 0x0063, SQLiteException -> 0x009a, TryCatch #0 {SQLiteException -> 0x009a, blocks: (B:15:0x0068, B:17:0x0089, B:20:0x009c), top: B:30:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c A[Catch: all -> 0x0063, SQLiteException -> 0x009a, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x009a, blocks: (B:15:0x0068, B:17:0x0089, B:20:0x009c), top: B:30:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d0(java.lang.String r16) {
        /*
            r15 = this;
            r1 = r15
            r2 = r16
            java.lang.Object r0 = r1.f84c
            r3 = r0
            J1.v0 r3 = (J1.C0113v0) r3
            q1.E.f(r16)
            java.lang.String r4 = "first_open_count"
            q1.E.f(r4)
            r15.j()
            r15.k()
            android.database.sqlite.SQLiteDatabase r5 = r15.f0()
            r5.beginTransaction()
            r6 = 0
            java.lang.String r0 = "select first_open_count from app2 where app_id=?"
            java.lang.String[] r8 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r9 = -1
            long r11 = r15.b0(r0, r8, r9)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            java.lang.String r8 = "app2"
            java.lang.String r13 = "app_id"
            if (r0 != 0) goto L68
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r0.<init>()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r0.put(r13, r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r11 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r0.put(r4, r11)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            java.lang.String r12 = "previous_install_count"
            r0.put(r12, r11)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r11 = 0
            r12 = 5
            long r11 = r5.insertWithOnConflict(r8, r11, r0, r12)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r0 != 0) goto L67
            J1.Z r0 = r3.f1417k     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            J1.C0113v0.k(r0)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            J1.X r0 = r0.h     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            java.lang.String r8 = "Failed to insert column (got -1). appId"
            J1.Y r11 = J1.Z.q(r16)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r0.c(r11, r4, r8)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            goto Lb3
        L63:
            r0 = move-exception
            goto Lb7
        L65:
            r0 = move-exception
            goto La2
        L67:
            r11 = r6
        L68:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            r0.<init>()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            r0.put(r13, r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            r13 = 1
            long r13 = r13 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            r0.put(r4, r13)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r13 = "app_id = ?"
            java.lang.String[] r14 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            int r0 = r5.update(r8, r0, r13, r14)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            long r13 = (long) r0     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            int r0 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r0 != 0) goto L9c
            J1.Z r0 = r3.f1417k     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            J1.C0113v0.k(r0)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            J1.X r0 = r0.h     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r6 = "Failed to update column (got 0). appId"
            J1.Y r7 = J1.Z.q(r16)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            r0.c(r7, r4, r6)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            goto Lb3
        L9a:
            r0 = move-exception
            goto La1
        L9c:
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L9a
            r9 = r11
            goto Lb3
        La1:
            r6 = r11
        La2:
            J1.Z r3 = r3.f1417k     // Catch: java.lang.Throwable -> L63
            J1.C0113v0.k(r3)     // Catch: java.lang.Throwable -> L63
            J1.X r3 = r3.h     // Catch: java.lang.Throwable -> L63
            java.lang.String r8 = "Error inserting column. appId"
            J1.Y r2 = J1.Z.q(r16)     // Catch: java.lang.Throwable -> L63
            r3.d(r8, r2, r4, r0)     // Catch: java.lang.Throwable -> L63
            r9 = r6
        Lb3:
            r5.endTransaction()
            return r9
        Lb7:
            r5.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.d0(java.lang.String):long");
    }

    public final long e0(String str) {
        q1.E.f(str);
        return b0("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase f0() {
        j();
        try {
            return this.f1313f.getWritableDatabase();
        } catch (SQLiteException e5) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(e5, "Error opening database");
            throw e5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.V g0(java.lang.String r53) {
        /*
            Method dump skipped, instructions count: 1035
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.g0(java.lang.String):J1.V");
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00f4: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:25:0x00f4 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.C0062e h0(java.lang.String r28, java.lang.String r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.h0(java.lang.String, java.lang.String):J1.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final L0.m i0(java.lang.String r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            q1.E.f(r11)
            r10.j()
            r10.k()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f0()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r3 = "apps"
            java.lang.String r4 = "remote_config"
            java.lang.String r5 = "config_last_modified_time"
            java.lang.String r6 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r9 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            if (r3 != 0) goto L32
            goto L80
        L32:
            r3 = 0
            byte[] r3 = r2.getBlob(r3)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            boolean r6 = r2.moveToNext()     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            if (r6 == 0) goto L5c
            J1.Z r6 = r0.f1417k     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            J1.C0113v0.k(r6)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            J1.X r6 = r6.h     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            J1.Y r8 = J1.Z.q(r11)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            r6.b(r8, r7)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            goto L5c
        L58:
            r11 = move-exception
            goto L69
        L5a:
            r3 = move-exception
            goto L70
        L5c:
            if (r3 != 0) goto L5f
            goto L80
        L5f:
            L0.m r6 = new L0.m     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            r7 = 1
            r6.<init>(r3, r4, r5, r7)     // Catch: java.lang.Throwable -> L58 android.database.sqlite.SQLiteException -> L5a
            r2.close()
            return r6
        L69:
            r1 = r2
            goto L86
        L6b:
            r11 = move-exception
            goto L86
        L6d:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L70:
            J1.Z r0 = r0.f1417k     // Catch: java.lang.Throwable -> L58
            J1.C0113v0.k(r0)     // Catch: java.lang.Throwable -> L58
            J1.X r0 = r0.h     // Catch: java.lang.Throwable -> L58
            java.lang.String r4 = "Error querying remote config. appId"
            J1.Y r11 = J1.Z.q(r11)     // Catch: java.lang.Throwable -> L58
            r0.c(r11, r3, r4)     // Catch: java.lang.Throwable -> L58
        L80:
            if (r2 == 0) goto L85
            r2.close()
        L85:
            return r1
        L86:
            if (r1 == 0) goto L8b
            r1.close()
        L8b:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.i0(java.lang.String):L0.m");
    }

    public final C0077j j0(long j5, String str, boolean z4, boolean z5, boolean z6, boolean z7) {
        return k0(j5, str, 1L, false, false, z4, false, z5, z6, z7);
    }

    public final C0077j k0(long j5, String str, long j6, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        q1.E.f(str);
        j();
        k();
        String[] strArr = {str};
        C0077j c0077j = new C0077j();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseF0 = f0();
                cursorQuery = sQLiteDatabaseF0.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getLong(0) == j5) {
                        c0077j.f1264b = cursorQuery.getLong(1);
                        c0077j.f1263a = cursorQuery.getLong(2);
                        c0077j.f1265c = cursorQuery.getLong(3);
                        c0077j.f1266d = cursorQuery.getLong(4);
                        c0077j.f1267e = cursorQuery.getLong(5);
                        c0077j.f1268f = cursorQuery.getLong(6);
                        c0077j.g = cursorQuery.getLong(7);
                    }
                    if (z4) {
                        c0077j.f1264b += j6;
                    }
                    if (z5) {
                        c0077j.f1263a += j6;
                    }
                    if (z6) {
                        c0077j.f1265c += j6;
                    }
                    if (z7) {
                        c0077j.f1266d += j6;
                    }
                    if (z8) {
                        c0077j.f1267e += j6;
                    }
                    if (z9) {
                        c0077j.f1268f += j6;
                    }
                    if (z10) {
                        c0077j.g += j6;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j5));
                    contentValues.put("daily_public_events_count", Long.valueOf(c0077j.f1263a));
                    contentValues.put("daily_events_count", Long.valueOf(c0077j.f1264b));
                    contentValues.put("daily_conversions_count", Long.valueOf(c0077j.f1265c));
                    contentValues.put("daily_error_events_count", Long.valueOf(c0077j.f1266d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(c0077j.f1267e));
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(c0077j.f1268f));
                    contentValues.put("daily_registered_triggers_count", Long.valueOf(c0077j.g));
                    sQLiteDatabaseF0.update("apps", contentValues, "app_id=?", strArr);
                } else {
                    Z z11 = c0113v0.f1417k;
                    C0113v0.k(z11);
                    z11.f1080k.b(Z.q(str), "Not updating daily counts, app is not known. appId");
                }
            } catch (SQLiteException e5) {
                Z z12 = c0113v0.f1417k;
                C0113v0.k(z12);
                z12.h.c(Z.q(str), e5, "Error updating daily counts. appId");
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return c0077j;
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final C0103s l0(String str, com.google.android.gms.internal.measurement.X0 x02, String str2) {
        C0103s c0103sL = L("events", str, x02.v());
        if (c0103sL != null) {
            long j5 = c0103sL.f1373e + 1;
            long j6 = c0103sL.f1372d + 1;
            return new C0103s(c0103sL.f1369a, c0103sL.f1370b, c0103sL.f1371c + 1, j6, j5, c0103sL.f1374f, c0103sL.g, c0103sL.h, c0103sL.f1375i, c0103sL.f1376j, c0103sL.f1377k);
        }
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1080k.c(Z.q(str), c0113v0.f1420o.d(str2), "Event aggregate wasn't created during raw event logging. appId, event");
        return new C0103s(str, x02.v(), 1L, 1L, 1L, x02.s(), 0L, null, null, null, null);
    }

    @Override // J1.Q1
    public final void m() {
    }

    public final K0 m0(String str) {
        q1.E.i(str);
        j();
        k();
        return K0.e(100, O("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String n() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.f0()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L22 android.database.sqlite.SQLiteException -> L24
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            if (r2 == 0) goto L37
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1c
            r0.close()
            return r1
        L1a:
            r1 = move-exception
            goto L1e
        L1c:
            r2 = move-exception
            goto L27
        L1e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3d
        L22:
            r0 = move-exception
            goto L3d
        L24:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L27:
            java.lang.Object r3 = r6.f84c     // Catch: java.lang.Throwable -> L1a
            J1.v0 r3 = (J1.C0113v0) r3     // Catch: java.lang.Throwable -> L1a
            J1.Z r3 = r3.f1417k     // Catch: java.lang.Throwable -> L1a
            J1.C0113v0.k(r3)     // Catch: java.lang.Throwable -> L1a
            J1.X r3 = r3.h     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r2, r4)     // Catch: java.lang.Throwable -> L1a
        L37:
            if (r0 == 0) goto L3c
            r0.close()
        L3c:
            return r1
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.n():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.K0 n0(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            q1.E.i(r5)
            r4.j()
            r4.k()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r1 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.f0()     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            android.database.Cursor r5 = r3.rawQuery(r1, r5)     // Catch: java.lang.Throwable -> L47 android.database.sqlite.SQLiteException -> L4a
            boolean r1 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            if (r1 != 0) goto L36
            J1.Z r1 = r0.f1417k     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            J1.C0113v0.k(r1)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            J1.X r1 = r1.f1084p     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            java.lang.String r3 = "No data found"
            r1.a(r3)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
        L2e:
            r5.close()
            goto L5c
        L32:
            r0 = move-exception
            goto L45
        L34:
            r1 = move-exception
            goto L4d
        L36:
            r1 = 0
            java.lang.String r1 = r5.getString(r1)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            r3 = 1
            int r3 = r5.getInt(r3)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            J1.K0 r2 = J1.K0.e(r3, r1)     // Catch: java.lang.Throwable -> L32 android.database.sqlite.SQLiteException -> L34
            goto L2e
        L45:
            r2 = r5
            goto L62
        L47:
            r5 = move-exception
            r0 = r5
            goto L62
        L4a:
            r5 = move-exception
            r1 = r5
            r5 = r2
        L4d:
            J1.Z r0 = r0.f1417k     // Catch: java.lang.Throwable -> L32
            J1.C0113v0.k(r0)     // Catch: java.lang.Throwable -> L32
            J1.X r0 = r0.h     // Catch: java.lang.Throwable -> L32
            java.lang.String r3 = "Error querying database."
            r0.b(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L5c
            goto L2e
        L5c:
            if (r2 != 0) goto L61
            J1.K0 r5 = J1.K0.f878c
            return r5
        L61:
            return r2
        L62:
            if (r2 == 0) goto L67
            r2.close()
        L67:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.n0(java.lang.String):J1.K0");
    }

    public final List o(String str, String str2, String str3) {
        q1.E.f(str);
        j();
        k();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return p(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.W1 o0(java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.o0(java.lang.String):J1.W1");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0056, code lost:
    
        r3 = r2.f1417k;
        J1.C0113v0.k(r3);
        r3.h.b(1000, "Read more than the max allowed conditional properties, ignoring extra");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List p(java.lang.String r29, java.lang.String[] r30) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.p(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.Z1 p0(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            q1.E.f(r12)
            q1.E.f(r13)
            r11.j()
            r11.k()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f0()     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "set_timestamp"
            java.lang.String r5 = "value"
            java.lang.String r6 = "origin"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6}     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            java.lang.String r5 = "app_id=? and name=?"
            java.lang.String[] r6 = new java.lang.String[]{r12, r13}     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            r9 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L70 android.database.sqlite.SQLiteException -> L72
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            if (r3 != 0) goto L35
            goto L8b
        L35:
            r3 = 0
            long r8 = r2.getLong(r3)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            r3 = 1
            java.lang.Object r10 = r11.q0(r2, r3)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            if (r10 != 0) goto L42
            goto L8b
        L42:
            r3 = 2
            java.lang.String r6 = r2.getString(r3)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            J1.Z1 r3 = new J1.Z1     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            r4 = r3
            r5 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            if (r4 == 0) goto L6a
            J1.Z r4 = r0.f1417k     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            J1.C0113v0.k(r4)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            J1.X r4 = r4.h     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            java.lang.String r5 = "Got multiple records for user property, expected one. appId"
            J1.Y r6 = J1.Z.q(r12)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            r4.b(r6, r5)     // Catch: java.lang.Throwable -> L66 android.database.sqlite.SQLiteException -> L68
            goto L6a
        L66:
            r12 = move-exception
            goto L6e
        L68:
            r3 = move-exception
            goto L75
        L6a:
            r2.close()
            return r3
        L6e:
            r1 = r2
            goto L91
        L70:
            r12 = move-exception
            goto L91
        L72:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L75:
            J1.Z r4 = r0.f1417k     // Catch: java.lang.Throwable -> L66
            J1.C0113v0.k(r4)     // Catch: java.lang.Throwable -> L66
            J1.X r4 = r4.h     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "Error querying user property. appId"
            J1.Y r12 = J1.Z.q(r12)     // Catch: java.lang.Throwable -> L66
            J1.S r0 = r0.f1420o     // Catch: java.lang.Throwable -> L66
            java.lang.String r13 = r0.f(r13)     // Catch: java.lang.Throwable -> L66
            r4.d(r5, r12, r13, r3)     // Catch: java.lang.Throwable -> L66
        L8b:
            if (r2 == 0) goto L90
            r2.close()
        L90:
            return r1
        L91:
            if (r1 == 0) goto L96
            r1.close()
        L96:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.p0(java.lang.String, java.lang.String):J1.Z1");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List q(java.lang.String r28, J1.O1 r29, int r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.q(java.lang.String, J1.O1, int):java.util.List");
    }

    public final Object q0(Cursor cursor, int i5) {
        int type = cursor.getType(i5);
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (type == 0) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i5));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i5));
        }
        if (type == 3) {
            return cursor.getString(i5);
        }
        if (type == 4) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.a("Loaded invalid blob type value, ignoring it");
            return null;
        }
        Z z6 = c0113v0.f1417k;
        C0113v0.k(z6);
        z6.h.b(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    public final List r(String str) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        q1.E.f(str);
        j();
        k();
        ?? arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                c0113v0.getClass();
                cursorQuery = f0().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j5 = cursorQuery.getLong(2);
                        Object objQ0 = q0(cursorQuery, 3);
                        if (objQ0 == null) {
                            Z z4 = c0113v0.f1417k;
                            C0113v0.k(z4);
                            z4.h.b(Z.q(str), "Read invalid user property value, ignoring it. appId");
                        } else {
                            arrayList.add(new Z1(str, str2, string, j5, objQ0));
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e5) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.h.c(Z.q(str), e5, "Error querying user properties. appId");
                arrayList = Collections.emptyList();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ac, code lost:
    
        J1.C0113v0.k(r7);
        r7.h.b(1000, "Read more than the max allowed user properties, ignoring excess");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0119  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List s(java.lang.String r18, java.lang.String r19, java.lang.String r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.s(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0268 A[Catch: SQLiteException -> 0x0285, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x0285, blocks: (B:83:0x024d, B:85:0x0268), top: B:102:0x024d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.lang.String r27, java.lang.Long r28, java.lang.String r29, android.os.Bundle r30) {
        /*
            Method dump skipped, instructions count: 677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0089n.t(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    public final void u() {
        k();
        f0().beginTransaction();
    }

    public final void v(String str) {
        C0103s c0103sL;
        P("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = f0().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (c0103sL = L("events", str, string)) != null) {
                            Q("events_snapshot", c0103sL);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e5) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.h.c(Z.q(str), e5, "Error creating snapshot. appId");
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void w(ArrayList arrayList) {
        q1.E.i(arrayList);
        j();
        k();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            if (i5 != 0) {
                sb.append(",");
            }
            sb.append(((Long) arrayList.get(i5)).longValue());
        }
        sb.append(")");
        int iDelete = f0().delete("raw_events", sb.toString(), null);
        if (iDelete != arrayList.size()) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.h.c(Integer.valueOf(iDelete), Integer.valueOf(arrayList.size()), "Deleted fewer rows from raw events table than expected");
        }
    }

    public final void x(Long l5) {
        j();
        k();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        C0068g c0068g = c0113v0.f1415i;
        Z z4 = c0113v0.f1417k;
        if (c0068g.w(null, H.f771M0)) {
            try {
                if (f0().delete("upload_queue", "rowid=?", new String[]{l5.toString()}) != 1) {
                    C0113v0.k(z4);
                    z4.f1080k.a("Deleted fewer rows from upload_queue than expected");
                }
            } catch (SQLiteException e5) {
                C0113v0.k(z4);
                z4.h.b(e5, "Failed to delete a MeasurementBatch in a upload_queue table");
                throw e5;
            }
        }
    }

    public final void y() {
        k();
        f0().endTransaction();
    }

    public final void z(List list) throws SQLException {
        j();
        k();
        q1.E.i(list);
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        if (U()) {
            String strL = AbstractC0535a.l("(", TextUtils.join(",", list), ")");
            long jA0 = a0("SELECT COUNT(1) FROM queue WHERE rowid IN " + strL + " AND retry_count =  2147483647 LIMIT 1", null);
            C0113v0 c0113v0 = (C0113v0) this.f84c;
            if (jA0 > 0) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1080k.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                f0().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + strL + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e5) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.h.b(e5, "Error incrementing retry count. error");
            }
        }
    }
}
