package J0;

import D.m;
import J1.V0;
import android.content.Context;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final L0.i f686a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f687b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f688c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f689d;

    /* renamed from: e, reason: collision with root package name */
    public Object f690e;

    public f(Context context, L0.i iVar) {
        F3.i.f(iVar, "taskExecutor");
        this.f686a = iVar;
        Context applicationContext = context.getApplicationContext();
        F3.i.e(applicationContext, "context.applicationContext");
        this.f687b = applicationContext;
        this.f688c = new Object();
        this.f689d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.f688c) {
            Object obj2 = this.f690e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.f690e = obj;
                ((V0) this.f686a.f1550f).execute(new m(t3.i.H(this.f689d), 7, this));
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
