package G2;

import B0.l;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f623c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f624d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Runnable f625e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f626f;
    public final /* synthetic */ long g;
    public final /* synthetic */ TimeUnit h;

    public /* synthetic */ d(f fVar, Runnable runnable, long j5, long j6, TimeUnit timeUnit, int i5) {
        this.f623c = i5;
        this.f624d = fVar;
        this.f625e = runnable;
        this.f626f = j5;
        this.g = j6;
        this.h = timeUnit;
    }

    @Override // G2.g
    public final ScheduledFuture a(l lVar) {
        switch (this.f623c) {
            case 0:
                f fVar = this.f624d;
                fVar.getClass();
                return fVar.f632k.scheduleAtFixedRate(new e(fVar, this.f625e, lVar, 0), this.f626f, this.g, this.h);
            default:
                f fVar2 = this.f624d;
                fVar2.getClass();
                return fVar2.f632k.scheduleWithFixedDelay(new e(fVar2, this.f625e, lVar, 2), this.f626f, this.g, this.h);
        }
    }
}
