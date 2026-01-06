package j0;

import android.view.Choreographer;

/* renamed from: j0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0594g {
    public static void a(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: j0.f
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j5) {
                runnable.run();
            }
        });
    }
}
