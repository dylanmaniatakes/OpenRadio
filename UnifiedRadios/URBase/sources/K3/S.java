package k3;

import android.media.MediaPlayer;
import android.util.Log;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class S implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f8016a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8017b;

    public S(LaunchActivity launchActivity, Runnable runnable) {
        this.f8017b = launchActivity;
        this.f8016a = runnable;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
        Log.e("UR Broadcast", "ROIP PTT sound error, starting transmission anyway: what=" + i5 + ", extra=" + i6);
        this.f8016a.run();
        try {
            mediaPlayer.release();
        } catch (Exception e5) {
            Log.e("UR Broadcast", "Error releasing MediaPlayer after error", e5);
        }
        LaunchActivity launchActivity = this.f8017b;
        if (launchActivity.f5892P0 != mediaPlayer) {
            return true;
        }
        launchActivity.f5892P0 = null;
        return true;
    }
}
