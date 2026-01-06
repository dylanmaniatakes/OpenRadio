package G2;

import B0.l;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f627j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f f628k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Runnable f629l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ l f630m;

    public /* synthetic */ e(f fVar, Runnable runnable, l lVar, int i5) {
        this.f627j = i5;
        this.f628k = fVar;
        this.f629l = runnable;
        this.f630m = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f627j) {
            case 0:
                f fVar = this.f628k;
                fVar.getClass();
                final Runnable runnable = this.f629l;
                final l lVar = this.f630m;
                final int i5 = 0;
                fVar.f631j.execute(new Runnable() { // from class: G2.c
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i5) {
                            case 0:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e5) {
                                    ((h) lVar.f110d).j(e5);
                                    throw e5;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e6) {
                                    ((h) lVar.f110d).j(e6);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                l lVar2 = lVar;
                                try {
                                    runnable2.run();
                                    ((h) lVar2.f110d).i(null);
                                    return;
                                } catch (Exception e7) {
                                    ((h) lVar2.f110d).j(e7);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                f fVar2 = this.f628k;
                fVar2.getClass();
                final Runnable runnable2 = this.f629l;
                final l lVar2 = this.f630m;
                final int i6 = 2;
                fVar2.f631j.execute(new Runnable() { // from class: G2.c
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i6) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e5) {
                                    ((h) lVar2.f110d).j(e5);
                                    throw e5;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e6) {
                                    ((h) lVar2.f110d).j(e6);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                l lVar22 = lVar2;
                                try {
                                    runnable22.run();
                                    ((h) lVar22.f110d).i(null);
                                    return;
                                } catch (Exception e7) {
                                    ((h) lVar22.f110d).j(e7);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                f fVar3 = this.f628k;
                fVar3.getClass();
                final Runnable runnable3 = this.f629l;
                final l lVar3 = this.f630m;
                final int i7 = 1;
                fVar3.f631j.execute(new Runnable() { // from class: G2.c
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i7) {
                            case 0:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e5) {
                                    ((h) lVar3.f110d).j(e5);
                                    throw e5;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e6) {
                                    ((h) lVar3.f110d).j(e6);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                l lVar22 = lVar3;
                                try {
                                    runnable22.run();
                                    ((h) lVar22.f110d).i(null);
                                    return;
                                } catch (Exception e7) {
                                    ((h) lVar22.f110d).j(e7);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
