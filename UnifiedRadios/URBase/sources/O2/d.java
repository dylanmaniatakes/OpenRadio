package O2;

import K.m;
import N1.r;
import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class d implements f, g {

    /* renamed from: a, reason: collision with root package name */
    public final Q2.a f2028a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f2029b;

    /* renamed from: c, reason: collision with root package name */
    public final Q2.a f2030c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f2031d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f2032e;

    public d(Context context, String str, Set set, Q2.a aVar, Executor executor) {
        this.f2028a = new A2.c(context, str);
        this.f2031d = set;
        this.f2032e = executor;
        this.f2030c = aVar;
        this.f2029b = context;
    }

    public final r a() {
        if (!m.a(this.f2029b)) {
            return AbstractC0930a.i("");
        }
        return AbstractC0930a.c(this.f2032e, new c(0, this));
    }

    public final void b() {
        if (this.f2031d.size() <= 0) {
            AbstractC0930a.i(null);
        } else if (!m.a(this.f2029b)) {
            AbstractC0930a.i(null);
        } else {
            AbstractC0930a.c(this.f2032e, new c(1, this));
        }
    }
}
