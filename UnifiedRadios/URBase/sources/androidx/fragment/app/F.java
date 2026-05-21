package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import f.AbstractActivityC0472i;

/* loaded from: classes.dex */
public abstract class F extends D {

    /* renamed from: c, reason: collision with root package name */
    public final Activity f3651c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f3652d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f3653e;

    /* renamed from: f, reason: collision with root package name */
    public final U f3654f;

    public F(AbstractActivityC0472i abstractActivityC0472i) {
        Handler handler = new Handler();
        this.f3654f = new U();
        this.f3651c = abstractActivityC0472i;
        this.f3652d = abstractActivityC0472i;
        this.f3653e = handler;
    }
}
