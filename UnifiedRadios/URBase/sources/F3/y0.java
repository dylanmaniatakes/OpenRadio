package f3;

import android.media.MediaPlayer;

/* loaded from: classes.dex */
public final /* synthetic */ class y0 implements MediaPlayer.OnPreparedListener {
    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
        mediaPlayer.start();
    }
}
