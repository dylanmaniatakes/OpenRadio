package f3;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.adapters.LocationDisplayActivity;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.primary.OptionsActivity;
import f.AbstractActivityC0472i;
import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class r implements LocationListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6786c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f6787d;

    public /* synthetic */ r(AbstractActivityC0472i abstractActivityC0472i, int i5) {
        this.f6786c = i5;
        this.f6787d = abstractActivityC0472i;
    }

    private final void a(String str) {
    }

    private final void b(String str) {
    }

    private final void c(String str, int i5, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        AbstractActivityC0472i abstractActivityC0472i = this.f6787d;
        switch (this.f6786c) {
            case 0:
                Log.d("LocationDisplayActivity", String.format("Fresh location received: %.6f, %.6f (accuracy: %.1fm)", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Float.valueOf(location.getAccuracy())));
                int i5 = LocationDisplayActivity.f5669q;
                LocationDisplayActivity locationDisplayActivity = (LocationDisplayActivity) abstractActivityC0472i;
                locationDisplayActivity.p();
                locationDisplayActivity.n(location.getLatitude(), location.getLongitude());
                break;
            case 1:
                String strS = com.unified.ur1.SatelliteTracker.h.s("📍 My Location: ", "https://maps.google.com/?q=" + location.getLatitude() + "," + location.getLongitude());
                int i6 = ChatActivity.f5725L;
                ChatActivity chatActivity = (ChatActivity) abstractActivityC0472i;
                chatActivity.y(strS, null);
                Toast.makeText(chatActivity, "Location sent!", 0).show();
                break;
            default:
                OptionsActivity optionsActivity = (OptionsActivity) abstractActivityC0472i;
                optionsActivity.f5991e = location;
                optionsActivity.f5992f = true;
                Log.d("Unified - Settings", String.format("GPS location updated: %.4f, %.4f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
                optionsActivity.f5990d.removeUpdates(this);
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        switch (this.f6786c) {
            case 0:
                Log.d("LocationDisplayActivity", "Provider disabled: " + str);
                if ("gps".equals(str)) {
                    int i5 = LocationDisplayActivity.f5669q;
                    ((LocationDisplayActivity) this.f6787d).r();
                    break;
                }
                break;
            case 1:
                break;
            default:
                AbstractC0535a.v("Location provider disabled: ", str, "Unified - Settings");
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        switch (this.f6786c) {
            case 0:
                AbstractC0535a.v("Provider enabled: ", str, "LocationDisplayActivity");
                break;
            case 1:
                break;
            default:
                AbstractC0535a.v("Location provider enabled: ", str, "Unified - Settings");
                break;
        }
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i5, Bundle bundle) {
        switch (this.f6786c) {
            case 0:
                Log.d("LocationDisplayActivity", "Provider status changed: " + str + " status: " + i5);
                break;
            case 1:
                break;
            default:
                Log.d("Unified - Settings", "Location provider status changed: " + str + " status: " + i5);
                break;
        }
    }
}
