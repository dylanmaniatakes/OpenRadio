package D1;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzo;
import f3.C0519j;
import h1.C0559c;
import java.util.concurrent.Executor;
import n1.C0787d;
import w1.AbstractC0930a;

/* renamed from: D1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0017o extends o1.h implements FusedLocationProviderClient {

    /* renamed from: i, reason: collision with root package name */
    public static final o1.d f398i = new o1.d("LocationServices.API", new C0007e(1), new C0559c());

    /* renamed from: j, reason: collision with root package name */
    public static final Object f399j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static Object f400k;

    public final N1.r e(LocationRequest locationRequest, androidx.emoji2.text.e eVar) {
        C0016n c0016n = new C0016n(this, eVar, O2.e.f2036i);
        L0.e eVar2 = new L0.e(c0016n, 4, locationRequest);
        m1.m mVar = new m1.m();
        mVar.f8545d = eVar2;
        mVar.f8546e = c0016n;
        mVar.f8547f = eVar;
        mVar.f8544c = 2435;
        return b(mVar.a());
    }

    public final N1.r f(LocationRequest locationRequest, androidx.emoji2.text.e eVar) {
        C0016n c0016n = new C0016n(this, eVar, O2.e.g);
        L0.s sVar = new L0.s(c0016n, 4, locationRequest);
        m1.m mVar = new m1.m();
        mVar.f8545d = sVar;
        mVar.f8546e = c0016n;
        mVar.f8547f = eVar;
        mVar.f8544c = 2436;
        return b(mVar.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j flushLocations() {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = n2.e.g;
        dVarB.f2525b = 2422;
        return d(1, dVarB.a());
    }

    public final N1.r g(DeviceOrientationRequest deviceOrientationRequest, androidx.emoji2.text.e eVar) {
        L0.s sVar = new L0.s(eVar, 3, deviceOrientationRequest);
        C0519j c0519j = new C0519j(2, eVar);
        m1.m mVar = new m1.m();
        mVar.f8545d = sVar;
        mVar.f8546e = c0519j;
        mVar.f8547f = eVar;
        mVar.f8544c = 2434;
        return b(mVar.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j getCurrentLocation(int i5, N1.a aVar) {
        CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
        builder.setPriority(i5);
        CurrentLocationRequest currentLocationRequestBuild = builder.build();
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.l(4, currentLocationRequestBuild);
        dVarB.f2525b = 2415;
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j getLastLocation() {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = n2.e.f8782f;
        dVarB.f2525b = 2414;
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j getLocationAvailability() {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = O2.e.f2034e;
        dVarB.f2525b = 2416;
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j removeDeviceOrientationUpdates(DeviceOrientationListener deviceOrientationListener) {
        return c(h4.d.e(deviceOrientationListener, "DeviceOrientationListener"), 2440).i(C2.c.f187m, n2.e.f8780d);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j removeLocationUpdates(PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new Z2.c(4, pendingIntent);
        dVarB.f2525b = 2418;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, DeviceOrientationListener deviceOrientationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            q1.E.j(looper, "invalid null looper");
        }
        return g(deviceOrientationRequest, h4.d.c(looper, deviceOrientationListener, "DeviceOrientationListener"));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.c(4, pendingIntent, locationRequest, false);
        dVarB.f2525b = 2417;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j setMockLocation(Location location) {
        q1.E.a(location != null);
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new C0018p(location);
        dVarB.f2525b = 2421;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j setMockMode(boolean z4) {
        synchronized (f399j) {
            try {
                if (!z4) {
                    Object obj = f400k;
                    if (obj != null) {
                        f400k = null;
                        return c(h4.d.e(obj, "Object"), 2420).i(C2.c.f186l, O2.e.f2033d);
                    }
                } else if (f400k == null) {
                    Object obj2 = new Object();
                    f400k = obj2;
                    m1.m mVar = new m1.m();
                    mVar.f8545d = O2.e.h;
                    mVar.f8546e = n2.e.h;
                    mVar.f8547f = h4.d.c(Looper.getMainLooper(), obj2, "Object");
                    mVar.f8544c = 2420;
                    return b(mVar.a());
                }
                return AbstractC0930a.i(null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j getLastLocation(LastLocationRequest lastLocationRequest) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new Z2.c(3, lastLocationRequest);
        dVarB.f2525b = 2414;
        dVarB.f2528e = new C0787d[]{zzo.zzf};
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j removeLocationUpdates(LocationCallback locationCallback) {
        return c(h4.d.e(locationCallback, "LocationCallback"), 2418).i(C2.c.f185k, O2.e.f2035f);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestDeviceOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, Executor executor, DeviceOrientationListener deviceOrientationListener) {
        return g(deviceOrientationRequest, h4.d.d(deviceOrientationListener, "DeviceOrientationListener", executor));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            q1.E.j(looper, "invalid null looper");
        }
        return f(locationRequest, h4.d.c(looper, locationCallback, "LocationCallback"));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j getCurrentLocation(CurrentLocationRequest currentLocationRequest, N1.a aVar) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.l(4, currentLocationRequest);
        dVarB.f2525b = 2415;
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j removeLocationUpdates(LocationListener locationListener) {
        return c(h4.d.e(locationListener, "LocationListener"), 2418).i(C2.c.n, n2.e.f8781e);
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            q1.E.j(looper, "invalid null looper");
        }
        return e(locationRequest, h4.d.c(looper, locationListener, "LocationListener"));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestLocationUpdates(LocationRequest locationRequest, Executor executor, LocationCallback locationCallback) {
        return f(locationRequest, h4.d.d(locationCallback, "LocationCallback", executor));
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient
    public final N1.j requestLocationUpdates(LocationRequest locationRequest, Executor executor, LocationListener locationListener) {
        return e(locationRequest, h4.d.d(locationListener, "LocationListener", executor));
    }
}
