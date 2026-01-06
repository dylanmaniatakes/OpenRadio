package f3;

import android.location.Location;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.adapters.RepeaterDirectoryActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6713j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RepeaterDirectoryActivity f6714k;

    public /* synthetic */ g0(RepeaterDirectoryActivity repeaterDirectoryActivity, int i5) {
        this.f6713j = i5;
        this.f6714k = repeaterDirectoryActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RepeaterDirectoryActivity repeaterDirectoryActivity = this.f6714k;
        switch (this.f6713j) {
            case 0:
                if (repeaterDirectoryActivity.f5696k == null && !repeaterDirectoryActivity.f5699o) {
                    repeaterDirectoryActivity.j();
                    Toast.makeText(repeaterDirectoryActivity, "Unable to get GPS location. Please check GPS settings or move to an area with better GPS signal.", 1).show();
                    try {
                        Location lastKnownLocation = repeaterDirectoryActivity.f5690c.getLastKnownLocation("network");
                        if (lastKnownLocation != null) {
                            repeaterDirectoryActivity.n(lastKnownLocation);
                            Toast.makeText(repeaterDirectoryActivity, "Using network location (less accurate)", 0).show();
                            break;
                        }
                    } catch (SecurityException e5) {
                        Log.e("RepeaterDirectory", "Error getting network location", e5);
                        return;
                    }
                }
                break;
            case 1:
                int i5 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.getClass();
                Toast.makeText(repeaterDirectoryActivity, "Error connecting to server and no cached data available", 1).show();
                break;
            default:
                int i6 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.getClass();
                Toast.makeText(repeaterDirectoryActivity, "Using cached repeater data due to server error", 1).show();
                break;
        }
    }
}
