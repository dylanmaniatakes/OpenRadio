package f3;

import android.media.MediaPlayer;

/* loaded from: classes.dex */
public final /* synthetic */ class B0 implements MediaPlayer.OnCompletionListener {
    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
}
