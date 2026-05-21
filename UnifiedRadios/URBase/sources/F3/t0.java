package f3;

import android.media.MediaPlayer;
import android.util.Log;

/* loaded from: classes.dex */
public final /* synthetic */ class t0 implements MediaPlayer.OnErrorListener {
    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
        Log.e("SoundCustomizationManager", "Error playing notification sound: what=" + i5 + ", extra=" + i6);
        mediaPlayer.release();
        return true;
    }
}
