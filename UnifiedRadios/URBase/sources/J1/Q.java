package J1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/* loaded from: classes.dex */
public final class Q extends E {
    public static final String[] g = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};

    /* renamed from: e, reason: collision with root package name */
    public final C0086m f930e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f931f;

    public Q(C0113v0 c0113v0) {
        super(c0113v0);
        this.f930e = new C0086m(this, ((C0113v0) this.f84c).f1411c);
    }

    @Override // J1.E
    public final boolean m() {
        return false;
    }

    public final SQLiteDatabase n() {
        if (this.f931f) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f930e.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f931f = true;
        return null;
    }

    public final void o() {
        int iDelete;
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        j();
        try {
            SQLiteDatabase sQLiteDatabaseN = n();
            if (sQLiteDatabaseN == null || (iDelete = sQLiteDatabaseN.delete("messages", null, null)) <= 0) {
                return;
            }
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1084p.b(Integer.valueOf(iDelete), "Reset local analytics data. records");
        } catch (SQLiteException e5) {
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.h.b(e5, "Error resetting local analytics data. error");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0073 A[PHI: r4
      0x0073: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:28:0x006a, B:34:0x0083, B:31:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.j()
            boolean r1 = r10.f931f
            if (r1 == 0) goto Lb
            goto L9b
        Lb:
            java.lang.Object r1 = r10.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            android.content.Context r2 = r1.f1411c
            java.lang.String r3 = "google_app_measurement_local.db"
            java.io.File r2 = r2.getDatabasePath(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L9b
            r2 = 0
            r3 = 5
            r4 = r3
        L20:
            if (r2 >= r3) goto L8f
            r5 = 1
            r6 = 0
            android.database.sqlite.SQLiteDatabase r6 = r10.n()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            if (r6 != 0) goto L34
            r10.f931f = r5     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            goto L9b
        L2e:
            r0 = move-exception
            goto L89
        L30:
            r7 = move-exception
            goto L51
        L32:
            r7 = move-exception
            goto L77
        L34:
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            r9 = 3
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            java.lang.String[] r9 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            r6.delete(r7, r8, r9)     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            r6.endTransaction()     // Catch: java.lang.Throwable -> L2e android.database.sqlite.SQLiteException -> L30 android.database.sqlite.SQLiteFullException -> L32 android.database.sqlite.SQLiteDatabaseLockedException -> L6b
            r6.close()
            return
        L51:
            if (r6 == 0) goto L5c
            boolean r8 = r6.inTransaction()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L5c
            r6.endTransaction()     // Catch: java.lang.Throwable -> L2e
        L5c:
            J1.Z r8 = r1.f1417k     // Catch: java.lang.Throwable -> L2e
            J1.C0113v0.k(r8)     // Catch: java.lang.Throwable -> L2e
            J1.X r8 = r8.h     // Catch: java.lang.Throwable -> L2e
            r8.b(r7, r0)     // Catch: java.lang.Throwable -> L2e
            r10.f931f = r5     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L86
            goto L73
        L6b:
            long r7 = (long) r4     // Catch: java.lang.Throwable -> L2e
            android.os.SystemClock.sleep(r7)     // Catch: java.lang.Throwable -> L2e
            int r4 = r4 + 20
            if (r6 == 0) goto L86
        L73:
            r6.close()
            goto L86
        L77:
            J1.Z r8 = r1.f1417k     // Catch: java.lang.Throwable -> L2e
            J1.C0113v0.k(r8)     // Catch: java.lang.Throwable -> L2e
            J1.X r8 = r8.h     // Catch: java.lang.Throwable -> L2e
            r8.b(r7, r0)     // Catch: java.lang.Throwable -> L2e
            r10.f931f = r5     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L86
            goto L73
        L86:
            int r2 = r2 + 1
            goto L20
        L89:
            if (r6 == 0) goto L8e
            r6.close()
        L8e:
            throw r0
        L8f:
            J1.Z r0 = r1.f1417k
            J1.C0113v0.k(r0)
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            J1.X r0 = r0.f1080k
            r0.a(r1)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.Q.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0122 A[PHI: r8 r11
      0x0122: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:67:0x0110, B:82:0x013b, B:75:0x0120] A[DONT_GENERATE, DONT_INLINE]
      0x0122: PHI (r11v8 android.database.sqlite.SQLiteDatabase) = 
      (r11v6 android.database.sqlite.SQLiteDatabase)
      (r11v7 android.database.sqlite.SQLiteDatabase)
      (r11v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:67:0x0110, B:82:0x013b, B:75:0x0120] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r19, byte[] r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.Q.q(int, byte[]):boolean");
    }
}
