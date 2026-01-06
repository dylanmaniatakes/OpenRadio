package k3;

import android.media.MediaPlayer;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;

/* loaded from: classes.dex */
public final class I implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DMRBridge f7969a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7970b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ O f7971c;

    public I(O o5, DMRBridge dMRBridge, int i5) {
        this.f7971c = o5;
        this.f7969a = dMRBridge;
        this.f7970b = i5;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
        if (this.f7971c.f8001b.f5885L0) {
            this.f7969a.A(this.f7970b);
        }
        mediaPlayer.release();
        return true;
    }
}
