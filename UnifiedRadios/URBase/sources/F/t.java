package f;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import f3.C0513e;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class t extends u {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6365c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f6366d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f6367e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(x xVar, C0513e c0513e) {
        super(xVar);
        this.f6366d = xVar;
        this.f6367e = c0513e;
    }

    @Override // f.u
    public final IntentFilter d() {
        switch (this.f6365c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // f.u
    public final int e() {
        Location location;
        boolean z4;
        long j5;
        switch (this.f6365c) {
            case 0:
                return ((PowerManager) this.f6367e).isPowerSaveMode() ? 2 : 1;
            default:
                C0513e c0513e = (C0513e) this.f6367e;
                C0460F c0460f = (C0460F) c0513e.f6688e;
                if (c0460f.f6257b > System.currentTimeMillis()) {
                    z4 = c0460f.f6256a;
                } else {
                    Context context = (Context) c0513e.f6686c;
                    int iB = C.h.b(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location lastKnownLocation = null;
                    LocationManager locationManager = (LocationManager) c0513e.f6687d;
                    if (iB == 0) {
                        try {
                        } catch (Exception e5) {
                            Log.d("TwilightManager", "Failed to get last known location", e5);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (C.h.b(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e6) {
                            Log.d("TwilightManager", "Failed to get last known location", e6);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (C0459E.f6252d == null) {
                            C0459E.f6252d = new C0459E();
                        }
                        C0459E c0459e = C0459E.f6252d;
                        c0459e.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        c0459e.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        z4 = c0459e.f6255c == 1;
                        long j6 = c0459e.f6254b;
                        long j7 = c0459e.f6253a;
                        c0459e.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                        long j8 = c0459e.f6254b;
                        if (j6 == -1 || j7 == -1) {
                            j5 = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis <= j7) {
                                j8 = jCurrentTimeMillis > j6 ? j7 : j6;
                            }
                            j5 = j8 + 60000;
                        }
                        c0460f.f6256a = z4;
                        c0460f.f6257b = j5;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i5 = Calendar.getInstance().get(11);
                        if (i5 < 6 || i5 >= 22) {
                            z4 = true;
                        }
                    }
                }
                return z4 ? 2 : 1;
        }
    }

    @Override // f.u
    public final void g() {
        switch (this.f6365c) {
            case 0:
                this.f6366d.o(true, true);
                break;
            default:
                this.f6366d.o(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(x xVar, Context context) {
        super(xVar);
        this.f6366d = xVar;
        this.f6367e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
