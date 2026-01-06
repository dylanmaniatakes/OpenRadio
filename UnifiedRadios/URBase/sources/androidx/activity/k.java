package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.AbstractActivityC0230z;
import com.google.android.gms.location.DeviceOrientationRequest;

/* loaded from: classes.dex */
public final class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: k, reason: collision with root package name */
    public Runnable f3233k;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3235m;

    /* renamed from: j, reason: collision with root package name */
    public final long f3232j = SystemClock.uptimeMillis() + DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3234l = false;

    public k(AbstractActivityC0230z abstractActivityC0230z) {
        this.f3235m = abstractActivityC0230z;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f3233k = runnable;
        View decorView = this.f3235m.getWindow().getDecorView();
        if (!this.f3234l) {
            decorView.postOnAnimation(new C0.e(8, this));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z4;
        Runnable runnable = this.f3233k;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f3232j) {
                this.f3234l = false;
                this.f3235m.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f3233k = null;
        l lVar = this.f3235m.mFullyDrawnReporter;
        synchronized (lVar.f3236a) {
            z4 = lVar.f3237b;
        }
        if (z4) {
            this.f3234l = false;
            this.f3235m.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3235m.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }

    @Override // androidx.activity.j
    public final void s(View view) {
        if (this.f3234l) {
            return;
        }
        this.f3234l = true;
        view.getViewTreeObserver().addOnDrawListener(this);
    }
}
