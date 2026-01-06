package k3;

import android.media.MediaPlayer;

/* renamed from: k3.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0679c0 implements MediaPlayer.OnCompletionListener {
    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
    }
}
