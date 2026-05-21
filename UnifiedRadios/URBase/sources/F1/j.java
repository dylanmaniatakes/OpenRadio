package f1;

import X2.m;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import e1.C0441i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final class j implements d, g1.c, c {

    /* renamed from: o, reason: collision with root package name */
    public static final V0.c f6460o = new V0.c("proto");

    /* renamed from: j, reason: collision with root package name */
    public final l f6461j;

    /* renamed from: k, reason: collision with root package name */
    public final h1.d f6462k;

    /* renamed from: l, reason: collision with root package name */
    public final h1.d f6463l;

    /* renamed from: m, reason: collision with root package name */
    public final C0475a f6464m;
    public final InterfaceC0877a n;

    public j(h1.d dVar, h1.d dVar2, C0475a c0475a, l lVar, InterfaceC0877a interfaceC0877a) {
        this.f6461j = lVar;
        this.f6462k = dVar;
        this.f6463l = dVar2;
        this.f6464m = c0475a;
        this.n = interfaceC0877a;
    }

    public static String V(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((C0476b) it.next()).f6449a);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object W(Cursor cursor, h hVar) {
        try {
            return hVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static Long c(SQLiteDatabase sQLiteDatabase, Y0.i iVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(iVar.f2912a, String.valueOf(i1.a.a(iVar.f2914c))));
        byte[] bArr = iVar.f2913b;
        if (bArr != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(" and extras is null");
        }
        Cursor cursorQuery = sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public final Object D(g1.b bVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        h1.d dVar = this.f6463l;
        long jA = dVar.a();
        while (true) {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Object objExecute = bVar.execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    sQLiteDatabaseA.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e5) {
                if (dVar.a() >= this.f6464m.f6446c + jA) {
                    throw new g1.a("Timed out while trying to acquire the lock.", e5);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final SQLiteDatabase a() {
        l lVar = this.f6461j;
        Objects.requireNonNull(lVar);
        h1.d dVar = this.f6463l;
        long jA = dVar.a();
        while (true) {
            try {
                return lVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e5) {
                if (dVar.a() >= this.f6464m.f6446c + jA) {
                    throw new g1.a("Timed out while trying to open db.", e5);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6461j.close();
    }

    public final Object o(h hVar) {
        SQLiteDatabase sQLiteDatabaseA = a();
        sQLiteDatabaseA.beginTransaction();
        try {
            Object objApply = hVar.apply(sQLiteDatabaseA);
            sQLiteDatabaseA.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final ArrayList s(SQLiteDatabase sQLiteDatabase, Y0.i iVar, int i5) {
        ArrayList arrayList = new ArrayList();
        Long lC = c(sQLiteDatabase, iVar);
        if (lC == null) {
            return arrayList;
        }
        W(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lC.toString()}, null, null, null, String.valueOf(i5)), new m(this, arrayList, iVar, 2));
        return arrayList;
    }

    public final void x(long j5, b1.c cVar, String str) {
        o(new C0441i(j5, str, cVar));
    }
}
