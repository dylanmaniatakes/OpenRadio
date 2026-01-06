package q0;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* renamed from: q0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0838a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9283a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9284b;

    public /* synthetic */ C0838a(int i5, Object obj) {
        this.f9283a = i5;
        this.f9284b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        switch (this.f9283a) {
            case 0:
                p0.e eVar = (p0.e) this.f9284b;
                F3.i.f(eVar, "$query");
                F3.i.c(sQLiteQuery);
                eVar.c(new C0846i(sQLiteQuery));
                break;
            default:
                C0839b c0839b = (C0839b) this.f9284b;
                F3.i.f(c0839b, "$tmp0");
                F3.i.c(sQLiteQuery);
                c0839b.f9285j.c(new C0846i(sQLiteQuery));
                break;
        }
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }
}
