package G2;

import B0.l;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import e1.C0442j;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements g, g1.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f616c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f617d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f618e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f619f;
    public final /* synthetic */ Object g;

    public /* synthetic */ b(f fVar, Object obj, long j5, TimeUnit timeUnit, int i5) {
        this.f616c = i5;
        this.f617d = fVar;
        this.g = obj;
        this.f618e = j5;
        this.f619f = timeUnit;
    }

    @Override // G2.g
    public ScheduledFuture a(l lVar) {
        switch (this.f616c) {
            case 0:
                f fVar = (f) this.f617d;
                fVar.getClass();
                return fVar.f632k.schedule(new e(fVar, (Runnable) this.g, lVar, 1), this.f618e, (TimeUnit) this.f619f);
            default:
                f fVar2 = (f) this.f617d;
                fVar2.getClass();
                return fVar2.f632k.schedule(new D0.e(fVar2, (Callable) this.g, lVar, 1), this.f618e, (TimeUnit) this.f619f);
        }
    }

    @Override // g1.b
    public Object execute() {
        C0442j c0442j = (C0442j) this.f617d;
        f1.j jVar = (f1.j) c0442j.f6178c;
        jVar.getClass();
        Iterable iterable = (Iterable) this.g;
        if (iterable.iterator().hasNext()) {
            String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + f1.j.V(iterable);
            SQLiteDatabase sQLiteDatabaseA = jVar.a();
            sQLiteDatabaseA.beginTransaction();
            try {
                sQLiteDatabaseA.compileStatement(str).execute();
                Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        jVar.x(cursorRawQuery.getInt(0), b1.c.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
                cursorRawQuery.close();
                sQLiteDatabaseA.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseA.endTransaction();
            }
        }
        jVar.o(new f1.f(c0442j.g.a() + this.f618e, (Y0.i) this.f619f));
        return null;
    }

    public /* synthetic */ b(C0442j c0442j, Iterable iterable, Y0.i iVar, long j5) {
        this.f616c = 2;
        this.f617d = c0442j;
        this.g = iterable;
        this.f619f = iVar;
        this.f618e = j5;
    }
}
