package f3;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/* loaded from: classes.dex */
public final /* synthetic */ class w0 implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6819a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6820b;

    public /* synthetic */ w0(int i5, Object obj) {
        this.f6819a = i5;
        this.f6820b = obj;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
        switch (this.f6819a) {
            case 0:
                E0 e02 = (E0) this.f6820b;
                e02.getClass();
                Log.e("SoundCustomizationManager", "Error playing sound preview: what=" + i5 + ", extra=" + i6);
                mediaPlayer.release();
                e02.f6572j = null;
                ((Activity) ((Context) e02.f6571i)).runOnUiThread(new x0(e02, 0));
                break;
            default:
                Log.e("SoundCustomizationManager", "Error playing " + ((String) this.f6820b) + " sound: what=" + i5 + ", extra=" + i6);
                mediaPlayer.release();
                break;
        }
        return true;
    }
}
