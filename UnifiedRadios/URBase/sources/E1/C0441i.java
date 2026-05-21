package e1;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: e1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0441i implements g1.b, f1.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f6173c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6174d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6175e;

    public /* synthetic */ C0441i(long j5, Object obj, Object obj2) {
        this.f6174d = obj;
        this.f6175e = obj2;
        this.f6173c = j5;
    }

    @Override // f1.h
    public Object apply(Object obj) throws SQLException {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        b1.c cVar = (b1.c) this.f6175e;
        String string = Integer.toString(cVar.f4526j);
        String str = (String) this.f6174d;
        boolean zBooleanValue = ((Boolean) f1.j.W(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, string}), new A2.i(18))).booleanValue();
        long j5 = this.f6173c;
        int i5 = cVar.f4526j;
        if (zBooleanValue) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j5 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i5)});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(i5));
            contentValues.put("events_dropped_count", Long.valueOf(j5));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    @Override // g1.b
    public Object execute() {
        C0442j c0442j = (C0442j) this.f6174d;
        long jA = c0442j.g.a() + this.f6173c;
        f1.j jVar = (f1.j) c0442j.f6178c;
        jVar.getClass();
        jVar.o(new f1.f(jA, (Y0.i) this.f6175e));
        return null;
    }
}
