package D1;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

/* renamed from: D1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0014l implements FusedLocationProviderApi {
    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l flushLocations(o1.k kVar) {
        new C0011i(kVar, 1);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final Location getLastLocation(o1.k kVar) {
        q1.E.b(kVar != null, "GoogleApiClient parameter is required.");
        kVar.getClass();
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final LocationAvailability getLocationAvailability(o1.k kVar) {
        q1.E.b(kVar != null, "GoogleApiClient parameter is required.");
        kVar.getClass();
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l removeLocationUpdates(o1.k kVar, PendingIntent pendingIntent) {
        new C0011i(kVar, pendingIntent);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l requestLocationUpdates(o1.k kVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        new C0011i(kVar, pendingIntent, locationRequest);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l setMockLocation(o1.k kVar, Location location) {
        new C0011i(kVar, location);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l setMockMode(o1.k kVar, boolean z4) {
        new C0011i(kVar, 1);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l removeLocationUpdates(o1.k kVar, LocationCallback locationCallback) {
        new C0011i(kVar, locationCallback);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l requestLocationUpdates(o1.k kVar, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            q1.E.j(looper, "invalid null looper");
        }
        new C0011i(kVar, h4.d.c(looper, locationCallback, "LocationCallback"), locationRequest);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l removeLocationUpdates(o1.k kVar, LocationListener locationListener) {
        new C0012j(kVar, locationListener);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l requestLocationUpdates(o1.k kVar, LocationRequest locationRequest, LocationListener locationListener) {
        Looper looperMyLooper = Looper.myLooper();
        q1.E.j(looperMyLooper, "invalid null looper");
        new C0011i(kVar, h4.d.c(looperMyLooper, locationListener, "LocationListener"), locationRequest);
        throw null;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public final o1.l requestLocationUpdates(o1.k kVar, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            q1.E.j(looper, "invalid null looper");
        }
        new C0011i(kVar, h4.d.c(looper, locationListener, "LocationListener"), locationRequest);
        throw null;
    }
}
