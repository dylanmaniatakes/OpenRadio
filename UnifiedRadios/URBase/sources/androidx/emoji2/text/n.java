package androidx.emoji2.text;

import J1.D;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import g0.AbstractC0535a;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class n implements i {

    /* renamed from: c, reason: collision with root package name */
    public final Context f3626c;

    /* renamed from: d, reason: collision with root package name */
    public final F2.t f3627d;

    /* renamed from: e, reason: collision with root package name */
    public final D f3628e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f3629f;
    public Handler g;
    public Executor h;

    /* renamed from: i, reason: collision with root package name */
    public ThreadPoolExecutor f3630i;

    /* renamed from: j, reason: collision with root package name */
    public h4.d f3631j;

    public n(Context context, F2.t tVar) {
        D d5 = o.f3632d;
        this.f3629f = new Object();
        h4.f.c(context, "Context cannot be null");
        this.f3626c = context.getApplicationContext();
        this.f3627d = tVar;
        this.f3628e = d5;
    }

    public final void a() {
        synchronized (this.f3629f) {
            try {
                this.f3631j = null;
                Handler handler = this.g;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.g = null;
                ThreadPoolExecutor threadPoolExecutor = this.f3630i;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.h = null;
                this.f3630i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f3629f) {
            try {
                if (this.f3631j == null) {
                    return;
                }
                if (this.h == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f3630i = threadPoolExecutor;
                    this.h = threadPoolExecutor;
                }
                this.h.execute(new C0.e(10, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final L.i c() {
        try {
            D d5 = this.f3628e;
            Context context = this.f3626c;
            F2.t tVar = this.f3627d;
            d5.getClass();
            L.h hVarA = L.c.a(context, tVar);
            int i5 = hVarA.f1521c;
            if (i5 != 0) {
                throw new RuntimeException(AbstractC0535a.j("fetchFonts failed (", i5, ")"));
            }
            L.i[] iVarArr = (L.i[]) hVarA.f1522d;
            if (iVarArr == null || iVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return iVarArr[0];
        } catch (PackageManager.NameNotFoundException e5) {
            throw new RuntimeException("provider not found", e5);
        }
    }

    @Override // androidx.emoji2.text.i
    public final void d(h4.d dVar) {
        synchronized (this.f3629f) {
            this.f3631j = dVar;
        }
        b();
    }
}
