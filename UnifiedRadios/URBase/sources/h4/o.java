package h4;

import C0.A;
import a.AbstractC0203a;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class o implements e {

    /* renamed from: d, reason: collision with root package name */
    public static File f7115d = null;

    /* renamed from: e, reason: collision with root package name */
    public static SQLiteDatabase f7116e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f7117f = false;

    /* renamed from: a, reason: collision with root package name */
    public long f7118a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final L0.e f7119b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7114c = new Object();
    public static final String[] g = {"tile", "expires"};

    public o() {
        L0.e eVar = new L0.e(new A(22, this));
        this.f7119b = eVar;
        d();
        if (f7117f) {
            return;
        }
        f7117f = true;
        eVar.i();
    }

    public static void c(Exception exc) {
        if (exc instanceof SQLiteException) {
            String simpleName = ((SQLiteException) exc).getClass().getSimpleName();
            if (simpleName.equals("SQLiteFullException") || simpleName.equals("SQLiteBindOrColumnIndexOutOfRangeException") || simpleName.equals("SQLiteTableLockedException") || simpleName.equals("SQLiteMisuseException") || simpleName.equals("SQLiteBlobTooBigException") || simpleName.equals("SQLiteConstraintException") || simpleName.equals("SQLiteDatatypeMismatchException")) {
                return;
            }
            synchronized (f7114c) {
                try {
                    SQLiteDatabase sQLiteDatabase = f7116e;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        f7116e = null;
                    }
                } finally {
                }
            }
        }
    }

    public static SQLiteDatabase d() {
        SQLiteDatabase sQLiteDatabase = f7116e;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        synchronized (f7114c) {
            e4.a.g().b(null).mkdirs();
            File file = new File(e4.a.g().b(null).getAbsolutePath() + File.separator + "cache.db");
            f7115d = file;
            if (f7116e == null) {
                try {
                    SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                    f7116e = sQLiteDatabaseOpenOrCreateDatabase;
                    sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS tiles (key INTEGER , provider TEXT, tile BLOB, expires INTEGER, PRIMARY KEY (key, provider));");
                } catch (Exception e5) {
                    Log.e("OsmDroid", "Unable to start the sqlite tile writer. Check external storage availability.", e5);
                    c(e5);
                    return null;
                }
            }
        }
        return f7116e;
    }

    @Override // h4.e
    public final boolean a(i4.c cVar, long j5, ByteArrayInputStream byteArrayInputStream, Long l5) throws Throwable {
        L0.e eVar = this.f7119b;
        SQLiteDatabase sQLiteDatabaseD = d();
        if (sQLiteDatabaseD == null || !sQLiteDatabaseD.isOpen()) {
            StringBuilder sb = new StringBuilder("Unable to store cached tile from ");
            sb.append(((i4.d) cVar).f7369c);
            sb.append(" ");
            sb.append(k4.l.k(j5));
            com.unified.ur1.SatelliteTracker.h.q(sb, ", database not available.", "OsmDroid");
            int i5 = j4.a.f7622a;
            return false;
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    long j6 = (int) (j5 >> 58);
                    int i6 = (int) j6;
                    long jG = (((j6 << i6) + k4.l.g(j5)) << i6) + k4.l.h(j5);
                    contentValues.put("provider", ((i4.d) cVar).f7369c);
                    byte[] bArr = new byte[512];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i7 = byteArrayInputStream.read(bArr);
                            if (i7 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, i7);
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            Log.e("OsmDroid", "SQLiteFullException while saving tile.", e);
                            eVar.i();
                            c(e);
                            byteArrayOutputStream.close();
                            return false;
                        } catch (Exception e6) {
                            e = e6;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            Log.e("OsmDroid", "Unable to store cached tile from " + ((i4.d) cVar).f7369c + " " + k4.l.k(j5) + " db is not null", e);
                            int i8 = j4.a.f7622a;
                            c(e);
                            byteArrayOutputStream.close();
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused) {
                            }
                            throw th;
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    contentValues.put("key", Long.valueOf(jG));
                    contentValues.put("tile", byteArray);
                    contentValues.put("expires", l5);
                    sQLiteDatabaseD.replaceOrThrow("tiles", null, contentValues);
                    e4.a.g().getClass();
                    if (System.currentTimeMillis() > this.f7118a + e4.a.g().f6235p) {
                        this.f7118a = System.currentTimeMillis();
                        eVar.i();
                    }
                    byteArrayOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteFullException e7) {
                e = e7;
            } catch (Exception e8) {
                e = e8;
            }
        } catch (IOException unused2) {
        }
        return false;
    }

    @Override // h4.e
    public final void b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [i4.d] */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.io.ByteArrayInputStream, java.io.Closeable, java.io.InputStream] */
    public final g4.g e(i4.c cVar, long j5) throws Throwable {
        Cursor cursorQuery;
        long j6;
        byte[] blob;
        Cursor cursor = null;
        try {
            try {
                long jG = k4.l.g(j5);
                long jH = k4.l.h(j5);
                long j7 = (int) (j5 >> 58);
                int i5 = (int) j7;
                cursorQuery = d().query("tiles", g, "key=? and provider=?", new String[]{String.valueOf((((j7 << i5) + jG) << i5) + jH), ((i4.d) cVar).f7369c}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e5) {
            e = e5;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                blob = cursorQuery.getBlob(0);
                j6 = cursorQuery.getLong(1);
            } else {
                j6 = 0;
                blob = null;
            }
            if (blob == null) {
                e4.a.g().getClass();
                cursorQuery.close();
                return null;
            }
            cursorQuery.close();
            try {
                ?? byteArrayInputStream = new ByteArrayInputStream(blob);
                try {
                    g4.g gVarB = ((i4.d) cVar).b(byteArrayInputStream);
                    if (j6 < System.currentTimeMillis() && gVarB != null) {
                        e4.a.g().getClass();
                        int[] iArr = g4.g.f7067d;
                        gVarB.f7068a = new int[]{-2};
                    }
                    AbstractC0203a.c(byteArrayInputStream);
                    return gVarB;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = byteArrayInputStream;
                    if (cursor != null) {
                        AbstractC0203a.c(cursor);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e6) {
            e = e6;
            c(e);
            throw e;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
