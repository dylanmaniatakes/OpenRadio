package k3;

import android.media.MediaPlayer;
import android.util.Log;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class Q implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f8011a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8012b;

    public Q(LaunchActivity launchActivity, Runnable runnable) {
        this.f8012b = launchActivity;
        this.f8011a = runnable;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        Log.d("UR Broadcast", "ROIP PTT sound finished playing");
        this.f8011a.run();
        try {
            mediaPlayer.release();
        } catch (Exception e5) {
            Log.e("UR Broadcast", "Error releasing MediaPlayer after completion", e5);
        }
        LaunchActivity launchActivity = this.f8012b;
        if (launchActivity.f5892P0 == mediaPlayer) {
            launchActivity.f5892P0 = null;
        }
    }
}
