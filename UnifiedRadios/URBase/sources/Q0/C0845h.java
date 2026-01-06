package q0;

import android.content.Context;
import androidx.recyclerview.widget.C0258e;
import s3.C0898h;
import s3.C0899i;

/* renamed from: q0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0845h implements p0.c {

    /* renamed from: j, reason: collision with root package name */
    public final Context f9301j;

    /* renamed from: k, reason: collision with root package name */
    public final String f9302k;

    /* renamed from: l, reason: collision with root package name */
    public final C0258e f9303l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9304m;
    public final boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final C0898h f9305o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9306p;

    public C0845h(Context context, String str, C0258e c0258e, boolean z4, boolean z5) {
        F3.i.f(context, "context");
        F3.i.f(c0258e, "callback");
        this.f9301j = context;
        this.f9302k = str;
        this.f9303l = c0258e;
        this.f9304m = z4;
        this.n = z5;
        this.f9305o = new C0898h(new H0.g(3, this));
    }

    @Override // p0.c
    public final C0840c Q() {
        return ((C0844g) this.f9305o.a()).a(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f9305o.f9691k != C0899i.f9693a) {
            ((C0844g) this.f9305o.a()).close();
        }
    }

    @Override // p0.c
    public final void setWriteAheadLoggingEnabled(boolean z4) {
        if (this.f9305o.f9691k != C0899i.f9693a) {
            C0844g c0844g = (C0844g) this.f9305o.a();
            F3.i.f(c0844g, "sQLiteOpenHelper");
            c0844g.setWriteAheadLoggingEnabled(z4);
        }
        this.f9306p = z4;
    }
}
