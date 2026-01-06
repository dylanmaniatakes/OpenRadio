package androidx.databinding;

import android.database.SQLException;
import android.view.Choreographer;

/* loaded from: classes.dex */
public final class d implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3582a;

    public d(e eVar) {
        this.f3582a = eVar;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j5) throws InterruptedException, SQLException {
        this.f3582a.f3585b.run();
    }
}
