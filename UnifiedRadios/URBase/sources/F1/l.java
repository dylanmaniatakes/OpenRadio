package f1;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class l extends SQLiteOpenHelper {

    /* renamed from: l, reason: collision with root package name */
    public static final String f6466l = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* renamed from: m, reason: collision with root package name */
    public static final int f6467m = 5;
    public static final List n = Arrays.asList(new k(0), new k(1), new k(2), new k(3), new k(4));

    /* renamed from: j, reason: collision with root package name */
    public final int f6468j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6469k;

    public l(int i5, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i5);
        this.f6469k = false;
        this.f6468j = i5;
    }

    public static void a(SQLiteDatabase sQLiteDatabase, int i5, int i6) throws SQLException {
        List list = n;
        if (i6 <= list.size()) {
            while (i5 < i6) {
                ((k) list.get(i5)).a(sQLiteDatabase);
                i5++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i5 + " to " + i6 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f6469k = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (!this.f6469k) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, this.f6468j);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        if (!this.f6469k) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i6);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.f6469k) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) throws SQLException {
        if (!this.f6469k) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i5, i6);
    }
}
