package h4;

import h1.C0558b;
import java.util.concurrent.atomic.AtomicReference;
import k4.t;
import k4.v;

/* loaded from: classes.dex */
public final class k extends m {

    /* renamed from: e, reason: collision with root package name */
    public final e f7101e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f7102f;
    public final n g;
    public final g h;

    /* renamed from: i, reason: collision with root package name */
    public final v f7103i;

    /* renamed from: j, reason: collision with root package name */
    public final C0558b f7104j;

    public k(i4.c cVar, e eVar, n nVar) {
        super(e4.a.g().f6226d, e4.a.g().f6228f);
        this.f7102f = new AtomicReference();
        this.h = new g(this, 1);
        this.f7103i = new v();
        this.f7104j = new C0558b(1);
        this.f7101e = eVar;
        this.g = nVar;
        i(cVar);
    }

    @Override // h4.m
    public final void b() {
        a();
        this.f7107a.shutdown();
        e eVar = this.f7101e;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // h4.m
    public final int c() {
        i4.d dVar = (i4.d) this.f7102f.get();
        return dVar != null ? dVar.f7368b : t.f8315b;
    }

    @Override // h4.m
    public final int d() {
        i4.d dVar = (i4.d) this.f7102f.get();
        if (dVar != null) {
            return dVar.f7367a;
        }
        return 0;
    }

    @Override // h4.m
    public final String e() {
        return "downloader";
    }

    @Override // h4.m
    public final M0.d f() {
        return this.h;
    }

    @Override // h4.m
    public final boolean g() {
        return true;
    }

    @Override // h4.m
    public final void i(i4.c cVar) {
        boolean z4 = cVar instanceof i4.d;
        AtomicReference atomicReference = this.f7102f;
        if (z4) {
            atomicReference.set((i4.d) cVar);
        } else {
            atomicReference.set(null);
        }
    }
}
