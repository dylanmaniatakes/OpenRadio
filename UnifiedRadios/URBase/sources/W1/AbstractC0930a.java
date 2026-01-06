package w1;

import B.v;
import C2.c;
import F3.i;
import N1.d;
import N1.j;
import N1.l;
import N1.m;
import N1.o;
import N1.p;
import N1.r;
import O.C0159d0;
import a.AbstractC0203a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k.G0;
import l0.C0736l;
import q1.E;
import r.g;
import y1.f;

/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0930a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f10124a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f10125b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f10126c = true;

    public static Object a(j jVar) throws InterruptedException {
        E.h("Must not be called on the main application thread");
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        E.j(jVar, "Task must not be null");
        if (jVar.e()) {
            return q(jVar);
        }
        m mVar = new m();
        c cVar = l.f1791b;
        jVar.b(cVar, mVar);
        jVar.a(cVar, mVar);
        r rVar = (r) jVar;
        rVar.f1805b.g(new o(cVar, (d) mVar));
        rVar.p();
        mVar.f1792c.await();
        return q(jVar);
    }

    public static Object b(j jVar, long j5, TimeUnit timeUnit) throws TimeoutException {
        E.h("Must not be called on the main application thread");
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        E.j(jVar, "Task must not be null");
        E.j(timeUnit, "TimeUnit must not be null");
        if (jVar.e()) {
            return q(jVar);
        }
        m mVar = new m();
        c cVar = l.f1791b;
        jVar.b(cVar, mVar);
        jVar.a(cVar, mVar);
        r rVar = (r) jVar;
        rVar.f1805b.g(new o(cVar, (d) mVar));
        rVar.p();
        if (mVar.f1792c.await(j5, timeUnit)) {
            return q(jVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static r c(Executor executor, Callable callable) {
        E.j(executor, "Executor must not be null");
        r rVar = new r();
        executor.execute(new p(2, rVar, callable, false));
        return rVar;
    }

    public static final void d(View view) {
        i.f(view, "<this>");
        C0159d0 c0159d0 = new C0159d0(view, null);
        L3.d dVar = new L3.d();
        dVar.f1632m = AbstractC0203a.e(c0159d0, dVar, dVar);
        while (dVar.hasNext()) {
            View view2 = (View) dVar.next();
            U.a aVar = (U.a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new U.a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList = aVar.f2459a;
            int iX = t3.j.x(arrayList);
            if (-1 < iX) {
                h.p(arrayList.get(iX));
                throw null;
            }
        }
    }

    public static final C0736l h(Context context, Class cls, String str) {
        i.f(context, "context");
        if (!M3.m.s(str)) {
            return new C0736l(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    public static r i(Object obj) {
        r rVar = new r();
        rVar.m(obj);
        return rVar;
    }

    public static ColorStateList j(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !v.q(drawable)) {
            return null;
        }
        return v.d(drawable).getColorStateList();
    }

    public static Drawable k(Context context, int i5) {
        return G0.c().e(context, i5);
    }

    public static synchronized boolean l(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f10124a;
        if (context2 != null && (bool = f10125b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f10125b = null;
        Boolean boolValueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        f10125b = boolValueOf;
        f10124a = applicationContext;
        return boolValueOf.booleanValue();
    }

    public static void o(Outline outline, Path path) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            outline.setPath(path);
            return;
        }
        if (i5 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    public static void p(ViewGroup viewGroup, boolean z4) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z4);
        } else if (f10126c) {
            try {
                viewGroup.suppressLayout(z4);
            } catch (NoSuchMethodError unused) {
                f10126c = false;
            }
        }
    }

    public static Object q(j jVar) throws ExecutionException {
        if (jVar.f()) {
            return jVar.d();
        }
        if (((r) jVar).f1807d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(jVar.c());
    }

    public static void r(int i5, int i6) {
        String strL;
        if (i5 < 0 || i5 >= i6) {
            if (i5 < 0) {
                strL = f.L("%s (%s) must not be negative", "index", Integer.valueOf(i5));
            } else {
                if (i6 < 0) {
                    throw new IllegalArgumentException(h.a(i6, "negative size: "));
                }
                strL = f.L("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i5), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(strL);
        }
    }

    public static void s(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException((i5 < 0 || i5 > i7) ? t(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? t(i6, i7, "end index") : f.L("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5)));
        }
    }

    public static String t(int i5, int i6, String str) {
        if (i5 < 0) {
            return f.L("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return f.L("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        throw new IllegalArgumentException(h.a(i6, "negative size: "));
    }

    public abstract boolean e(g gVar, r.c cVar, r.c cVar2);

    public abstract boolean f(g gVar, Object obj, Object obj2);

    public abstract boolean g(g gVar, r.f fVar, r.f fVar2);

    public abstract void m(r.f fVar, r.f fVar2);

    public abstract void n(r.f fVar, Thread thread);
}
