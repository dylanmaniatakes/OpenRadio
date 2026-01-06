package k3;

import android.widget.ImageButton;

/* renamed from: k3.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0685f0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8125j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ImageButton f8126k;

    public /* synthetic */ RunnableC0685f0(ImageButton imageButton, int i5) {
        this.f8125j = i5;
        this.f8126k = imageButton;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8125j) {
            case 0:
                try {
                    this.f8126k.setClickable(true);
                    break;
                } catch (Exception e5) {
                    com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Error setting PTT clickable: "), "Unified - Main Activity");
                    return;
                }
            default:
                this.f8126k.setClickable(false);
                break;
        }
    }
}
