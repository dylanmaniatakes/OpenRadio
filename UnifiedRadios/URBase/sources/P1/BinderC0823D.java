package p1;

import D1.C0007e;
import android.content.Context;
import android.os.Handler;
import java.util.Set;
import n1.C0785b;

/* renamed from: p1.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0823D extends L1.c implements o1.i, o1.j {

    /* renamed from: k, reason: collision with root package name */
    public static final C0007e f9086k = K1.b.f1505a;

    /* renamed from: d, reason: collision with root package name */
    public final Context f9087d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f9088e;

    /* renamed from: f, reason: collision with root package name */
    public final C0007e f9089f;
    public final Set g;
    public final D0.w h;

    /* renamed from: i, reason: collision with root package name */
    public L1.a f9090i;

    /* renamed from: j, reason: collision with root package name */
    public v f9091j;

    public BinderC0823D(Context context, Handler handler, D0.w wVar) {
        super("com.google.android.gms.signin.internal.ISignInCallbacks", 0);
        this.f9087d = context;
        this.f9088e = handler;
        this.h = wVar;
        this.g = (Set) wVar.f310c;
        this.f9089f = f9086k;
    }

    @Override // o1.i
    public final void a(int i5) {
        v vVar = this.f9091j;
        t tVar = (t) vVar.f9154f.f9123j.get(vVar.f9150b);
        if (tVar != null) {
            if (tVar.f9143k) {
                tVar.p(new C0785b(17));
            } else {
                tVar.a(i5);
            }
        }
    }

    @Override // o1.j
    public final void b(C0785b c0785b) {
        this.f9091j.a(c0785b);
    }

    @Override // o1.i
    public final void c() {
        this.f9090i.C(this);
    }
}
