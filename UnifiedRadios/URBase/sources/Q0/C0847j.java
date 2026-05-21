package q0;

import android.database.sqlite.SQLiteStatement;

/* renamed from: q0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0847j extends C0846i implements p0.d {

    /* renamed from: k, reason: collision with root package name */
    public final SQLiteStatement f9308k;

    public C0847j(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f9308k = sQLiteStatement;
    }

    public final long a() {
        return this.f9308k.executeInsert();
    }

    public final int c() {
        return this.f9308k.executeUpdateDelete();
    }
}
