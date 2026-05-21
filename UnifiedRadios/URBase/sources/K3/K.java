package k3;

import android.media.MediaPlayer;
import android.util.Log;
import com.google.android.gms.internal.measurement.C1;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class K implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7979a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ O f7980b;

    public /* synthetic */ K(O o5, int i5) {
        this.f7979a = i5;
        this.f7980b = o5;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        switch (this.f7979a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                O o5 = this.f7980b;
                sb.append(o5.f8001b.f5970w);
                sb.append(" PTT sound finished - starting transmission");
                Log.d("UR Broadcast", sb.toString());
                LaunchActivity launchActivity = o5.f8001b;
                if (launchActivity.f5965u != null && launchActivity.f5972w1) {
                    C1 c1 = new C1(launchActivity, h4.c.E(launchActivity));
                    LaunchActivity launchActivity2 = o5.f8001b;
                    c1.d(launchActivity2, launchActivity2.f5965u);
                }
                try {
                    mediaPlayer.release();
                    break;
                } catch (Exception e5) {
                    Log.e("UR Broadcast", "Error releasing MediaPlayer", e5);
                    return;
                }
                break;
            case 1:
                Log.d("UR Broadcast", "FM PTT sound finished - starting transmission");
                O o6 = this.f7980b;
                LaunchActivity launchActivity3 = o6.f8001b;
                if (launchActivity3.f5965u != null) {
                    C1 c12 = new C1(launchActivity3, h4.c.E(launchActivity3));
                    LaunchActivity launchActivity4 = o6.f8001b;
                    c12.d(launchActivity4, launchActivity4.f5965u);
                }
                try {
                    mediaPlayer.release();
                    break;
                } catch (Exception e6) {
                    Log.e("UR Broadcast", "Error releasing MediaPlayer", e6);
                    return;
                }
            default:
                Log.d("UR Broadcast", "FM PTT sound finished - starting transmission");
                O o7 = this.f7980b;
                LaunchActivity launchActivity5 = o7.f8001b;
                if (launchActivity5.f5965u != null) {
                    C1 c13 = new C1(launchActivity5, h4.c.E(launchActivity5));
                    LaunchActivity launchActivity6 = o7.f8001b;
                    c13.d(launchActivity6, launchActivity6.f5965u);
                }
                try {
                    mediaPlayer.release();
                    break;
                } catch (Exception e7) {
                    Log.e("UR Broadcast", "Error releasing MediaPlayer", e7);
                }
        }
    }
}
