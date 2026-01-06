package f3;

import android.location.Location;
import android.location.LocationListener;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.adapters.RepeaterDirectoryActivity;
import com.unified.ur1.adapters.RepeaterMapActivity;
import f.AbstractActivityC0472i;

/* loaded from: classes.dex */
public final class l0 implements LocationListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6740c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f6741d;

    public /* synthetic */ l0(AbstractActivityC0472i abstractActivityC0472i, int i5) {
        this.f6740c = i5;
        this.f6741d = abstractActivityC0472i;
    }

    private final void a(String str) {
    }

    private final void b(String str) {
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        switch (this.f6740c) {
            case 0:
                RepeaterDirectoryActivity repeaterDirectoryActivity = (RepeaterDirectoryActivity) this.f6741d;
                if (!repeaterDirectoryActivity.f5699o && location.hasAccuracy() && location.getAccuracy() <= 50.0f) {
                    repeaterDirectoryActivity.f5698m.removeCallbacksAndMessages(null);
                    repeaterDirectoryActivity.n(location);
                    repeaterDirectoryActivity.j();
                    if (repeaterDirectoryActivity.f5697l && location.getProvider().equals("gps")) {
                        try {
                            repeaterDirectoryActivity.f5690c.removeUpdates(this);
                            repeaterDirectoryActivity.f5690c.requestLocationUpdates("gps", 500000L, 3000.0f, this);
                            repeaterDirectoryActivity.f5697l = false;
                            break;
                        } catch (SecurityException e5) {
                            Log.e("RepeaterDirectory", "Error adjusting location updates", e5);
                            return;
                        }
                    }
                }
                break;
            default:
                RepeaterMapActivity repeaterMapActivity = (RepeaterMapActivity) this.f6741d;
                if (!repeaterMapActivity.f5710k) {
                    repeaterMapActivity.r(location.getLatitude(), location.getLongitude());
                    repeaterMapActivity.f5710k = true;
                    k4.d dVar = new k4.d(repeaterMapActivity.f5708i, repeaterMapActivity.f5709j);
                    ((l4.f) repeaterMapActivity.f5705d).c(dVar);
                    ((l4.f) repeaterMapActivity.f5705d).d(10.0d);
                    repeaterMapActivity.k(dVar);
                    repeaterMapActivity.j(dVar);
                    repeaterMapActivity.n();
                    repeaterMapActivity.f5706e.removeUpdates(this);
                    break;
                }
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        switch (this.f6740c) {
            case 0:
                RepeaterDirectoryActivity repeaterDirectoryActivity = (RepeaterDirectoryActivity) this.f6741d;
                Toast.makeText(repeaterDirectoryActivity, str + " disabled", 0).show();
                if (str.equals("gps")) {
                    int i5 = RepeaterDirectoryActivity.f5689s;
                    repeaterDirectoryActivity.l();
                    break;
                }
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        switch (this.f6740c) {
            case 0:
                Toast.makeText((RepeaterDirectoryActivity) this.f6741d, str + " enabled", 0).show();
                break;
        }
    }
}
