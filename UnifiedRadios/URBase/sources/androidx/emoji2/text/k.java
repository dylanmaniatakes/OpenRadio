package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class k extends h4.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h4.d f3614a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f3615b;

    public k(h4.d dVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f3614a = dVar;
        this.f3615b = threadPoolExecutor;
    }

    @Override // h4.d
    public final void i(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f3615b;
        try {
            this.f3614a.i(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // h4.d
    public final void j(L0.i iVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f3615b;
        try {
            this.f3614a.j(iVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
