package J1;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class C0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f709a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f710b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f711c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f712d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ E0 f713e;

    public /* synthetic */ C0(E0 e02, String str, String str2, String str3, int i5) {
        this.f709a = i5;
        this.f710b = str;
        this.f711c = str2;
        this.f712d = str3;
        this.f713e = e02;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f709a) {
            case 0:
                E0 e02 = this.f713e;
                e02.f728c.j();
                C0089n c0089n = e02.f728c.f1019e;
                V1.J(c0089n);
                return c0089n.s(this.f710b, this.f711c, this.f712d);
            case 1:
                E0 e03 = this.f713e;
                e03.f728c.j();
                C0089n c0089n2 = e03.f728c.f1019e;
                V1.J(c0089n2);
                return c0089n2.s(this.f710b, this.f711c, this.f712d);
            case 2:
                E0 e04 = this.f713e;
                e04.f728c.j();
                C0089n c0089n3 = e04.f728c.f1019e;
                V1.J(c0089n3);
                return c0089n3.o(this.f710b, this.f711c, this.f712d);
            default:
                E0 e05 = this.f713e;
                e05.f728c.j();
                C0089n c0089n4 = e05.f728c.f1019e;
                V1.J(c0089n4);
                return c0089n4.o(this.f710b, this.f711c, this.f712d);
        }
    }
}
