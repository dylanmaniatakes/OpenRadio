package q0;

import S3.w;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import java.io.Closeable;

/* renamed from: q0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0840c implements Closeable {

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f9286k = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f9287l = new String[0];

    /* renamed from: j, reason: collision with root package name */
    public final SQLiteDatabase f9288j;

    public C0840c(SQLiteDatabase sQLiteDatabase) {
        F3.i.f(sQLiteDatabase, "delegate");
        this.f9288j = sQLiteDatabase;
    }

    public final void D(String str, Object[] objArr) throws SQLException {
        F3.i.f(str, "sql");
        F3.i.f(objArr, "bindArgs");
        this.f9288j.execSQL(str, objArr);
    }

    public final boolean V() {
        return this.f9288j.inTransaction();
    }

    public final boolean W() {
        SQLiteDatabase sQLiteDatabase = this.f9288j;
        F3.i.f(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public final Cursor X(String str) {
        F3.i.f(str, "query");
        return Y(new w(str, 1));
    }

    public final Cursor Y(p0.e eVar) {
        Cursor cursorRawQueryWithFactory = this.f9288j.rawQueryWithFactory(new C0838a(1, new C0839b(eVar)), eVar.a(), f9287l, null);
        F3.i.e(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    public final Cursor Z(p0.e eVar, CancellationSignal cancellationSignal) {
        String strA = eVar.a();
        String[] strArr = f9287l;
        F3.i.c(cancellationSignal);
        C0838a c0838a = new C0838a(0, eVar);
        SQLiteDatabase sQLiteDatabase = this.f9288j;
        F3.i.f(sQLiteDatabase, "sQLiteDatabase");
        F3.i.f(strA, "sql");
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(c0838a, strA, strArr, null, cancellationSignal);
        F3.i.e(cursorRawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return cursorRawQueryWithFactory;
    }

    public final void a() {
        this.f9288j.beginTransaction();
    }

    public final void a0() {
        this.f9288j.setTransactionSuccessful();
    }

    public final int b0(String str, int i5, ContentValues contentValues, String str2, Object[] objArr) throws SQLException {
        F3.i.f(str, "table");
        F3.i.f(contentValues, "values");
        if (contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values".toString());
        }
        int size = contentValues.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(f9286k[i5]);
        sb.append(str);
        sb.append(" SET ");
        int i6 = 0;
        for (String str3 : contentValues.keySet()) {
            sb.append(i6 > 0 ? "," : "");
            sb.append(str3);
            objArr2[i6] = contentValues.get(str3);
            sb.append("=?");
            i6++;
        }
        if (objArr != null) {
            for (int i7 = size; i7 < length; i7++) {
                objArr2[i7] = objArr[i7 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String string = sb.toString();
        F3.i.e(string, "StringBuilder().apply(builderAction).toString()");
        C0847j c0847jO = o(string);
        int length2 = objArr2.length;
        int i8 = 0;
        while (i8 < length2) {
            Object obj = objArr2[i8];
            i8++;
            if (obj == null) {
                c0847jO.t(i8);
            } else if (obj instanceof byte[]) {
                c0847jO.M(i8, (byte[]) obj);
            } else if (obj instanceof Float) {
                c0847jO.v(i8, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                c0847jO.v(i8, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                c0847jO.I(i8, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                c0847jO.I(i8, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                c0847jO.I(i8, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                c0847jO.I(i8, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                c0847jO.h(i8, (String) obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i8 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
                c0847jO.I(i8, ((Boolean) obj).booleanValue() ? 1L : 0L);
            }
        }
        return c0847jO.f9308k.executeUpdateDelete();
    }

    public final void c() {
        this.f9288j.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9288j.close();
    }

    public final boolean isOpen() {
        return this.f9288j.isOpen();
    }

    public final C0847j o(String str) throws SQLException {
        F3.i.f(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f9288j.compileStatement(str);
        F3.i.e(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new C0847j(sQLiteStatementCompileStatement);
    }

    public final void s() {
        this.f9288j.endTransaction();
    }

    public final void x(String str) throws SQLException {
        F3.i.f(str, "sql");
        this.f9288j.execSQL(str);
    }
}
