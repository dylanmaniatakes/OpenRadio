package J1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.M3;
import u1.C0906a;

/* renamed from: J1.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0086m extends SQLiteOpenHelper {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1298j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ B.u f1299k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0086m(C0089n c0089n, Context context) {
        this(context, "google_app_measurement.db");
        this.f1298j = 0;
        this.f1299k = c0089n;
    }

    private final void a(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }

    private final void c(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }

    private final void o(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }

    private final void s(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        switch (this.f1298j) {
            case 0:
                C0089n c0089n = (C0089n) this.f1299k;
                U u4 = c0089n.g;
                C0113v0 c0113v0 = (C0113v0) c0089n.f84c;
                c0113v0.getClass();
                if (u4.f954d != 0) {
                    ((C0906a) u4.f955e).getClass();
                    if (SystemClock.elapsedRealtime() - u4.f954d < 3600000) {
                        throw new SQLiteException("Database open failed");
                    }
                }
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteException unused) {
                    U u5 = c0089n.g;
                    ((C0906a) u5.f955e).getClass();
                    u5.f954d = SystemClock.elapsedRealtime();
                    Z z4 = c0113v0.f1417k;
                    C0113v0.k(z4);
                    z4.h.a("Opening the database failed, dropping and recreating it");
                    if (!c0113v0.f1411c.getDatabasePath("google_app_measurement.db").delete()) {
                        Z z5 = c0113v0.f1417k;
                        C0113v0.k(z5);
                        z5.h.b("google_app_measurement.db", "Failed to delete corrupted db file");
                    }
                    try {
                        SQLiteDatabase writableDatabase = super.getWritableDatabase();
                        u5.f954d = 0L;
                        return writableDatabase;
                    } catch (SQLiteException e5) {
                        Z z6 = c0113v0.f1417k;
                        C0113v0.k(z6);
                        z6.h.b(e5, "Failed to open freshly created database");
                        throw e5;
                    }
                }
            default:
                try {
                    return super.getWritableDatabase();
                } catch (SQLiteDatabaseLockedException e6) {
                    throw e6;
                } catch (SQLiteException unused2) {
                    Q q4 = (Q) this.f1299k;
                    C0113v0 c0113v02 = (C0113v0) q4.f84c;
                    Z z7 = c0113v02.f1417k;
                    C0113v0.k(z7);
                    z7.h.a("Opening the local database failed, dropping and recreating it");
                    if (!c0113v02.f1411c.getDatabasePath("google_app_measurement_local.db").delete()) {
                        Z z8 = c0113v02.f1417k;
                        C0113v0.k(z8);
                        z8.h.b("google_app_measurement_local.db", "Failed to delete corrupted local db file");
                    }
                    try {
                        return super.getWritableDatabase();
                    } catch (SQLiteException e7) {
                        Z z9 = ((C0113v0) q4.f84c).f1417k;
                        C0113v0.k(z9);
                        z9.h.b(e7, "Failed to open local database. Events will bypass local storage");
                        return null;
                    }
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        switch (this.f1298j) {
            case 0:
                Z z4 = ((C0113v0) ((C0089n) this.f1299k).f84c).f1417k;
                C0113v0.k(z4);
                L0.e(z4, sQLiteDatabase);
                break;
            default:
                Z z5 = ((C0113v0) ((Q) this.f1299k).f84c).f1417k;
                C0113v0.k(z5);
                L0.e(z5, sQLiteDatabase);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        int i7 = this.f1298j;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) throws Throwable {
        switch (this.f1298j) {
            case 0:
                C0113v0 c0113v0 = (C0113v0) ((C0089n) this.f1299k).f84c;
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                L0.c(z4, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", C0089n.h);
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "events_snapshot", "CREATE TABLE IF NOT EXISTS events_snapshot ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, last_bundled_timestamp INTEGER, last_bundled_day INTEGER, last_sampled_complex_event_id INTEGER, last_sampling_rate INTEGER, last_exempt_from_sampling INTEGER, current_session_count INTEGER, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp,last_bundled_timestamp,last_bundled_day,last_sampled_complex_event_id,last_sampling_rate,last_exempt_from_sampling,current_session_count", null);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", C0089n.f1305j);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", C0089n.f1306k);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", C0089n.f1308m);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", C0089n.f1307l);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", C0089n.n);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", C0089n.f1309o);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", C0089n.f1310p);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", C0089n.f1311q);
                M3.b();
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "trigger_uris", "CREATE TABLE IF NOT EXISTS trigger_uris ( app_id TEXT NOT NULL, trigger_uri TEXT NOT NULL, timestamp_millis INTEGER NOT NULL, source INTEGER NOT NULL);", "app_id,trigger_uri,source,timestamp_millis", C0089n.f1312r);
                C0113v0.k(z5);
                L0.c(z5, sQLiteDatabase, "upload_queue", "CREATE TABLE IF NOT EXISTS upload_queue ( app_id TEXT NOT NULL, upload_uri TEXT NOT NULL, upload_headers TEXT NOT NULL, upload_type INTEGER NOT NULL, measurement_batch BLOB NOT NULL, retry_count INTEGER NOT NULL, creation_timestamp INTEGER NOT NULL );", "app_id,upload_uri,upload_headers,upload_type,measurement_batch,retry_count,creation_timestamp", C0089n.f1304i);
                break;
            default:
                Z z6 = ((C0113v0) ((Q) this.f1299k).f84c).f1417k;
                C0113v0.k(z6);
                L0.c(z6, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", Q.g);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        int i7 = this.f1298j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0086m(Q q4, Context context) {
        this(context, "google_app_measurement_local.db");
        this.f1298j = 1;
        this.f1299k = q4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0086m(Context context, String str) {
        super(context, true == str.equals("") ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
        int i5 = com.google.android.gms.internal.measurement.D.f4670d;
    }
}
