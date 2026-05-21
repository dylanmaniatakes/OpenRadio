package J1;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class D0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f720a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b2 f721b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f722c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ E0 f723d;

    public /* synthetic */ D0(E0 e02, b2 b2Var, Bundle bundle, int i5) {
        this.f720a = i5;
        this.f721b = b2Var;
        this.f722c = bundle;
        this.f723d = e02;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f720a) {
            case 0:
                E0 e02 = this.f723d;
                e02.f728c.j();
                return e02.f728c.i(this.f721b, this.f722c);
            default:
                E0 e03 = this.f723d;
                e03.f728c.j();
                return e03.f728c.i(this.f721b, this.f722c);
        }
    }
}
