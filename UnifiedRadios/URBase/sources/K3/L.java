package k3;

import android.media.MediaPlayer;
import android.util.Log;
import com.google.android.gms.internal.measurement.C1;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class L implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7984a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ O f7985b;

    public /* synthetic */ L(O o5, int i5) {
        this.f7984a = i5;
        this.f7985b = o5;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i5, int i6) {
        switch (this.f7984a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                O o5 = this.f7985b;
                sb.append(o5.f8001b.f5970w);
                sb.append(" PTT sound error - starting transmission anyway");
                Log.e("UR Broadcast", sb.toString());
                LaunchActivity launchActivity = o5.f8001b;
                if (launchActivity.f5965u != null) {
                    C1 c1 = new C1(launchActivity, h4.c.E(launchActivity));
                    LaunchActivity launchActivity2 = o5.f8001b;
                    c1.d(launchActivity2, launchActivity2.f5965u);
                }
                try {
                    mediaPlayer.release();
                    break;
                } catch (Exception e5) {
                    Log.e("UR Broadcast", "Error releasing MediaPlayer after error", e5);
                    return true;
                }
            case 1:
                Log.e("UR Broadcast", "PTT sound error - starting transmission anyway");
                O o6 = this.f7985b;
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
                    Log.e("UR Broadcast", "Error releasing MediaPlayer after error", e6);
                    return true;
                }
            default:
                Log.e("UR Broadcast", "PTT sound error - starting transmission anyway");
                O o7 = this.f7985b;
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
                    Log.e("UR Broadcast", "Error releasing MediaPlayer after error", e7);
                    return true;
                }
        }
        return true;
    }
}
