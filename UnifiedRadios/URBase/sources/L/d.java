package L;

import F2.t;
import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1508a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1509b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f1510c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t f1511d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1512e;

    public /* synthetic */ d(String str, Context context, t tVar, int i5, int i6) {
        this.f1508a = i6;
        this.f1509b = str;
        this.f1510c = context;
        this.f1511d = tVar;
        this.f1512e = i5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1508a) {
            case 0:
                return g.a(this.f1509b, this.f1510c, this.f1511d, this.f1512e);
            default:
                try {
                    return g.a(this.f1509b, this.f1510c, this.f1511d, this.f1512e);
                } catch (Throwable unused) {
                    return new f(-3);
                }
        }
    }
}
