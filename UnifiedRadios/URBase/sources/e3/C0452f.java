package e3;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import f.AbstractActivityC0472i;
import g0.AbstractC0535a;

/* renamed from: e3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0452f implements LocationListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6210c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LocationManager f6211d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f6212e;

    public /* synthetic */ C0452f(AbstractActivityC0472i abstractActivityC0472i, LocationManager locationManager, int i5) {
        this.f6210c = i5;
        this.f6212e = abstractActivityC0472i;
        this.f6211d = locationManager;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        switch (this.f6210c) {
            case 0:
                Log.d("UnifiedOnTheAir", "Location changed: " + location.getLatitude() + "," + location.getLongitude());
                if (location.getLatitude() != 0.0d && location.getLongitude() != 0.0d) {
                    k4.d dVar = new k4.d(location.getLatitude(), location.getLongitude());
                    UnifiedOnTheAirActivity unifiedOnTheAirActivity = (UnifiedOnTheAirActivity) this.f6212e;
                    ((l4.f) unifiedOnTheAirActivity.f5561f).c(dVar);
                    ((l4.f) unifiedOnTheAirActivity.f5561f).d(15.0d);
                    unifiedOnTheAirActivity.j(dVar);
                    this.f6211d.removeUpdates(this);
                    Toast.makeText(unifiedOnTheAirActivity, "Location found", 0).show();
                    break;
                } else {
                    Log.w("UnifiedOnTheAir", "Received invalid location: 0,0");
                    break;
                }
                break;
            default:
                Log.d("RadioTeamsActivity", "Location changed: " + location.getLatitude() + "," + location.getLongitude());
                if (location.getLatitude() != 0.0d && location.getLongitude() != 0.0d) {
                    k4.d dVar2 = new k4.d(location.getLatitude(), location.getLongitude());
                    RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) this.f6212e;
                    ((l4.f) radioTeamsActivity.g).c(dVar2);
                    ((l4.f) radioTeamsActivity.g).d(15.0d);
                    radioTeamsActivity.j(dVar2);
                    this.f6211d.removeUpdates(this);
                    Toast.makeText(radioTeamsActivity, "Location found", 0).show();
                    break;
                } else {
                    Log.w("RadioTeamsActivity", "Received invalid location: 0,0");
                    break;
                }
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        switch (this.f6210c) {
            case 0:
                AbstractC0535a.v("Provider disabled: ", str, "UnifiedOnTheAir");
                break;
            default:
                AbstractC0535a.v("Provider disabled: ", str, "RadioTeamsActivity");
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        switch (this.f6210c) {
            case 0:
                AbstractC0535a.v("Provider enabled: ", str, "UnifiedOnTheAir");
                break;
            default:
                AbstractC0535a.v("Provider enabled: ", str, "RadioTeamsActivity");
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i5, Bundle bundle) {
        switch (this.f6210c) {
            case 0:
                Log.d("UnifiedOnTheAir", "Provider status changed: " + str + " status: " + i5);
                break;
            default:
                Log.d("RadioTeamsActivity", "Provider status changed: " + str + " status: " + i5);
                break;
        }
    }
}
