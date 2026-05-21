package f3;

import android.media.MediaPlayer;
import android.util.Log;

/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6813a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6814b;

    public /* synthetic */ v0(int i5, Object obj) {
        this.f6813a = i5;
        this.f6814b = obj;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        switch (this.f6813a) {
            case 0:
                E0 e02 = (E0) this.f6814b;
                e02.getClass();
                mediaPlayer.release();
                e02.f6572j = null;
                break;
            default:
                Log.d("SoundCustomizationManager", ((String) this.f6814b) + " sound playback completed");
                mediaPlayer.release();
                break;
        }
    }
}
