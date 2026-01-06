package q0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.recyclerview.widget.C0258e;
import h4.r;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import r0.C0872a;
import s.AbstractC0882e;

/* renamed from: q0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0844g extends SQLiteOpenHelper {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f9294q = 0;

    /* renamed from: j, reason: collision with root package name */
    public final Context f9295j;

    /* renamed from: k, reason: collision with root package name */
    public final C0841d f9296k;

    /* renamed from: l, reason: collision with root package name */
    public final C0258e f9297l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9298m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final C0872a f9299o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9300p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0844g(Context context, String str, final C0841d c0841d, final C0258e c0258e, boolean z4) {
        super(context, str, null, c0258e.f4224b, new DatabaseErrorHandler() { // from class: q0.e
            @Override // android.database.DatabaseErrorHandler
            public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                F3.i.f(c0258e, "$callback");
                C0841d c0841d2 = c0841d;
                F3.i.f(c0841d2, "$dbRef");
                int i5 = C0844g.f9294q;
                F3.i.e(sQLiteDatabase, "dbObj");
                C0840c c0840cK = r.k(c0841d2, sQLiteDatabase);
                Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + c0840cK + ".path");
                SQLiteDatabase sQLiteDatabase2 = c0840cK.f9288j;
                if (!sQLiteDatabase2.isOpen()) {
                    String path = sQLiteDatabase2.getPath();
                    if (path != null) {
                        C0258e.f(path);
                        return;
                    }
                    return;
                }
                List<Pair<String, String>> attachedDbs = null;
                try {
                    try {
                        attachedDbs = sQLiteDatabase2.getAttachedDbs();
                    } catch (SQLiteException unused) {
                    }
                    try {
                        c0840cK.close();
                    } catch (IOException unused2) {
                    }
                    if (attachedDbs != null) {
                        return;
                    }
                } finally {
                    if (attachedDbs != null) {
                        Iterator<T> it = attachedDbs.iterator();
                        while (it.hasNext()) {
                            Object obj = ((Pair) it.next()).second;
                            F3.i.e(obj, "p.second");
                            C0258e.f((String) obj);
                        }
                    } else {
                        String path2 = sQLiteDatabase2.getPath();
                        if (path2 != null) {
                            C0258e.f(path2);
                        }
                    }
                }
            }
        });
        F3.i.f(context, "context");
        F3.i.f(c0258e, "callback");
        this.f9295j = context;
        this.f9296k = c0841d;
        this.f9297l = c0258e;
        this.f9298m = z4;
        if (str == null) {
            str = UUID.randomUUID().toString();
            F3.i.e(str, "randomUUID().toString()");
        }
        this.f9299o = new C0872a(str, context.getCacheDir(), false);
    }

    public final C0840c a(boolean z4) throws IOException {
        C0872a c0872a = this.f9299o;
        try {
            c0872a.a((this.f9300p || getDatabaseName() == null) ? false : true);
            this.n = false;
            SQLiteDatabase sQLiteDatabaseS = s(z4);
            if (!this.n) {
                C0840c c0840cC = c(sQLiteDatabaseS);
                c0872a.b();
                return c0840cC;
            }
            close();
            C0840c c0840cA = a(z4);
            c0872a.b();
            return c0840cA;
        } catch (Throwable th) {
            c0872a.b();
            throw th;
        }
    }

    public final C0840c c(SQLiteDatabase sQLiteDatabase) {
        F3.i.f(sQLiteDatabase, "sqLiteDatabase");
        return r.k(this.f9296k, sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        C0872a c0872a = this.f9299o;
        try {
            c0872a.a(c0872a.f9511a);
            super.close();
            this.f9296k.f9289a = null;
            this.f9300p = false;
        } finally {
            c0872a.b();
        }
    }

    public final SQLiteDatabase o(boolean z4) {
        if (z4) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            F3.i.e(writableDatabase, "{\n                super.…eDatabase()\n            }");
            return writableDatabase;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        F3.i.e(readableDatabase, "{\n                super.…eDatabase()\n            }");
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        F3.i.f(sQLiteDatabase, "db");
        boolean z4 = this.n;
        C0258e c0258e = this.f9297l;
        if (!z4 && c0258e.f4224b != sQLiteDatabase.getVersion()) {
            sQLiteDatabase.setMaxSqlCacheSize(1);
        }
        try {
            c0258e.p(c(sQLiteDatabase));
        } catch (Throwable th) {
            throw new C0843f(1, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        F3.i.f(sQLiteDatabase, "sqLiteDatabase");
        try {
            this.f9297l.q(c(sQLiteDatabase));
        } catch (Throwable th) {
            throw new C0843f(2, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        F3.i.f(sQLiteDatabase, "db");
        this.n = true;
        try {
            this.f9297l.r(c(sQLiteDatabase), i5, i6);
        } catch (Throwable th) {
            throw new C0843f(4, th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        F3.i.f(sQLiteDatabase, "db");
        if (!this.n) {
            try {
                this.f9297l.s(c(sQLiteDatabase));
            } catch (Throwable th) {
                throw new C0843f(5, th);
            }
        }
        this.f9300p = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        F3.i.f(sQLiteDatabase, "sqLiteDatabase");
        this.n = true;
        try {
            this.f9297l.t(c(sQLiteDatabase), i5, i6);
        } catch (Throwable th) {
            throw new C0843f(3, th);
        }
    }

    public final SQLiteDatabase s(boolean z4) throws Throwable {
        File parentFile;
        String databaseName = getDatabaseName();
        boolean z5 = this.f9300p;
        Context context = this.f9295j;
        if (databaseName != null && !z5 && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
            }
        }
        try {
            return o(z4);
        } catch (Throwable unused) {
            super.close();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused2) {
            }
            try {
                return o(z4);
            } catch (Throwable th) {
                super.close();
                if (th instanceof C0843f) {
                    C0843f c0843f = th;
                    int iC = AbstractC0882e.c(c0843f.f9292j);
                    Throwable th2 = c0843f.f9293k;
                    if (iC == 0 || iC == 1 || iC == 2 || iC == 3 || !(th2 instanceof SQLiteException)) {
                        throw th2;
                    }
                } else if (!(th instanceof SQLiteException) || databaseName == null || !this.f9298m) {
                    throw th;
                }
                context.deleteDatabase(databaseName);
                try {
                    return o(z4);
                } catch (C0843f e5) {
                    throw e5.f9293k;
                }
            }
        }
    }
}
