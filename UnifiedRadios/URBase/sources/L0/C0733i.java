package l0;

import D1.C0016n;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import h4.r;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k3.RunnableC0691i0;
import m.C0758f;
import q0.C0840c;
import q0.C0847j;

/* renamed from: l0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0733i {

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f8339m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0737m f8340a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f8341b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f8342c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f8343d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f8344e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f8345f;
    public volatile C0847j g;
    public final C0016n h;

    /* renamed from: i, reason: collision with root package name */
    public final C0758f f8346i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f8347j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f8348k;

    /* renamed from: l, reason: collision with root package name */
    public final RunnableC0691i0 f8349l;

    public C0733i(AbstractC0737m abstractC0737m, HashMap map, HashMap map2, String... strArr) {
        String lowerCase;
        F3.i.f(abstractC0737m, "database");
        this.f8340a = abstractC0737m;
        this.f8341b = map;
        this.f8344e = new AtomicBoolean(false);
        this.h = new C0016n(strArr.length);
        F3.i.e(Collections.newSetFromMap(new IdentityHashMap()), "newSetFromMap(IdentityHashMap())");
        this.f8346i = new C0758f();
        this.f8347j = new Object();
        this.f8348k = new Object();
        this.f8342c = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String str = strArr[i5];
            Locale locale = Locale.US;
            F3.i.e(locale, "US");
            String lowerCase2 = str.toLowerCase(locale);
            F3.i.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            this.f8342c.put(lowerCase2, Integer.valueOf(i5));
            String str2 = (String) this.f8341b.get(strArr[i5]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                F3.i.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i5] = lowerCase2;
        }
        this.f8343d = strArr2;
        for (Map.Entry entry : this.f8341b.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            F3.i.e(locale2, "US");
            String lowerCase3 = str3.toLowerCase(locale2);
            F3.i.e(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
            if (this.f8342c.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                F3.i.e(lowerCase4, "this as java.lang.String).toLowerCase(locale)");
                LinkedHashMap linkedHashMap = this.f8342c;
                F3.i.f(linkedHashMap, "<this>");
                Object obj = linkedHashMap.get(lowerCase3);
                if (obj == null && !linkedHashMap.containsKey(lowerCase3)) {
                    throw new NoSuchElementException("Key " + ((Object) lowerCase3) + " is missing in the map.");
                }
                linkedHashMap.put(lowerCase4, obj);
            }
        }
        this.f8349l = new RunnableC0691i0(4, this);
    }

    public final boolean a() {
        C0840c c0840c = this.f8340a.f8366a;
        if (!(c0840c != null && c0840c.isOpen())) {
            return false;
        }
        if (!this.f8345f) {
            this.f8340a.h().Q();
        }
        if (this.f8345f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void b(r rVar) {
        synchronized (this.f8346i) {
        }
    }

    public final void c(C0840c c0840c, int i5) throws SQLException {
        c0840c.x("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i5 + ", 0)");
        String str = this.f8343d[i5];
        String[] strArr = f8339m;
        for (int i6 = 0; i6 < 3; i6++) {
            String str2 = strArr[i6];
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + h4.f.i(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i5 + " AND invalidated = 0; END";
            F3.i.e(str3, "StringBuilder().apply(builderAction).toString()");
            c0840c.x(str3);
        }
    }

    public final void d() {
    }

    public final void e(C0840c c0840c) {
        F3.i.f(c0840c, "database");
        if (c0840c.V()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.f8340a.h.readLock();
            F3.i.e(lock, "readWriteLock.readLock()");
            lock.lock();
            try {
                synchronized (this.f8347j) {
                    int[] iArrC = this.h.c();
                    if (iArrC == null) {
                        return;
                    }
                    if (c0840c.W()) {
                        c0840c.c();
                    } else {
                        c0840c.a();
                    }
                    try {
                        int length = iArrC.length;
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < length) {
                            int i7 = iArrC[i5];
                            int i8 = i6 + 1;
                            if (i7 == 1) {
                                c(c0840c, i6);
                            } else if (i7 == 2) {
                                String str = this.f8343d[i6];
                                String[] strArr = f8339m;
                                for (int i9 = 0; i9 < 3; i9++) {
                                    String str2 = "DROP TRIGGER IF EXISTS " + h4.f.i(str, strArr[i9]);
                                    F3.i.e(str2, "StringBuilder().apply(builderAction).toString()");
                                    c0840c.x(str2);
                                }
                            }
                            i5++;
                            i6 = i8;
                        }
                        c0840c.a0();
                        c0840c.s();
                    } catch (Throwable th) {
                        c0840c.s();
                        throw th;
                    }
                }
            } finally {
                lock.unlock();
            }
        } catch (SQLiteException e5) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e5);
        } catch (IllegalStateException e6) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
        }
    }
}
