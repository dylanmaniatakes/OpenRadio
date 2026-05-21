package q0;

import android.database.sqlite.SQLiteProgram;

/* renamed from: q0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0846i implements p0.d {

    /* renamed from: j, reason: collision with root package name */
    public final SQLiteProgram f9307j;

    public C0846i(SQLiteProgram sQLiteProgram) {
        F3.i.f(sQLiteProgram, "delegate");
        this.f9307j = sQLiteProgram;
    }

    @Override // p0.d
    public final void I(int i5, long j5) {
        this.f9307j.bindLong(i5, j5);
    }

    @Override // p0.d
    public final void M(int i5, byte[] bArr) {
        this.f9307j.bindBlob(i5, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9307j.close();
    }

    @Override // p0.d
    public final void h(int i5, String str) {
        F3.i.f(str, "value");
        this.f9307j.bindString(i5, str);
    }

    @Override // p0.d
    public final void t(int i5) {
        this.f9307j.bindNull(i5);
    }

    @Override // p0.d
    public final void v(int i5, double d5) {
        this.f9307j.bindDouble(i5, d5);
    }
}
