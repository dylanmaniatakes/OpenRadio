package k3;

import android.media.MediaPlayer;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;

/* loaded from: classes.dex */
public final class H implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DMRBridge f7964a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7965b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ O f7966c;

    public H(O o5, DMRBridge dMRBridge, int i5) {
        this.f7966c = o5;
        this.f7964a = dMRBridge;
        this.f7965b = i5;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f7966c.f8001b.f5885L0) {
            this.f7964a.A(this.f7965b);
        }
        mediaPlayer.release();
    }
}
