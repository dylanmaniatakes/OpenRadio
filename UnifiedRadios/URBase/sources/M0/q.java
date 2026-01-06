package M0;

import J1.V0;
import android.content.Context;
import android.os.Build;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: p, reason: collision with root package name */
    public static final String f1694p = C0.t.f("WorkForegroundRunnable");

    /* renamed from: j, reason: collision with root package name */
    public final N0.k f1695j = new N0.k();

    /* renamed from: k, reason: collision with root package name */
    public final Context f1696k;

    /* renamed from: l, reason: collision with root package name */
    public final L0.o f1697l;

    /* renamed from: m, reason: collision with root package name */
    public final C0.s f1698m;
    public final C0.j n;

    /* renamed from: o, reason: collision with root package name */
    public final L0.i f1699o;

    public q(Context context, L0.o oVar, C0.s sVar, r rVar, L0.i iVar) {
        this.f1696k = context;
        this.f1697l = oVar;
        this.f1698m = sVar;
        this.n = rVar;
        this.f1699o = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f1697l.f1574q || Build.VERSION.SDK_INT >= 31) {
            this.f1695j.j(null);
            return;
        }
        N0.k kVar = new N0.k();
        L0.i iVar = this.f1699o;
        ((V0) iVar.f1550f).execute(new D.m(this, 8, kVar));
        kVar.a(new RunnableC0999a(25, this, kVar, false), (V0) iVar.f1550f);
    }
}
