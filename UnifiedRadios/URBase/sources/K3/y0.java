package k3;

import android.os.Handler;
import android.util.Log;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class y0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8250j;

    public y0(LaunchActivity launchActivity) {
        this.f8250j = launchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LaunchActivity launchActivity = this.f8250j;
        if (launchActivity.f5955q1) {
            boolean z4 = launchActivity.getSharedPreferences("radioteams_settings", 0).getBoolean("KEY_RADIOTEAMS_ENABLED", false);
            y0 y0Var = launchActivity.f5868C1;
            if (!z4) {
                Log.d("Unified - Main Activity", "RadioTeams disabled, stopping team sync handler");
                Handler handler = launchActivity.f5946n1;
                if (handler != null) {
                    handler.removeCallbacks(y0Var);
                    return;
                }
                return;
            }
            String string = launchActivity.getSharedPreferences("radioteams_settings", 0).getString("KEY_RADIOTEAMS_ID", "None");
            if (string == null || string.isEmpty()) {
                Log.d("Unified - Main Activity", "No team_id configured, skipping team sync");
                Handler handler2 = launchActivity.f5946n1;
                if (handler2 == null || !launchActivity.f5955q1) {
                    return;
                }
                handler2.postDelayed(y0Var, 120000L);
                return;
            }
            if (launchActivity.f5900U.equals("N4KYS")) {
                StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("Unified - Main Activity", "Team Sync URL: https://ur1.unifiedradios.com/api-teams/team_user_update.php", "Team Sync - Callsign: ");
                sbH.append(launchActivity.f5900U);
                sbH.append(", Team: ");
                sbH.append(string);
                Log.d("Unified - Main Activity", sbH.toString());
            }
            new Thread(new g3.k(this, 11, string)).start();
        }
    }
}
