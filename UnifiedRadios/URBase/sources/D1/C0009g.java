package D1;

import android.app.PendingIntent;
import com.google.android.gms.location.ActivityRecognitionClient;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.DeviceOrientationListener;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.FusedOrientationProviderClient;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.location.zza;
import com.google.android.gms.location.zzb;
import com.google.android.gms.location.zzo;
import h1.C0559c;
import java.util.List;
import java.util.concurrent.Executor;
import n1.C0787d;

/* renamed from: D1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0009g extends o1.h implements ActivityRecognitionClient, FusedOrientationProviderClient, GeofencingClient, SettingsClient {

    /* renamed from: i, reason: collision with root package name */
    public static final o1.d f390i = new o1.d("ActivityRecognition.API", new C0007e(0), new C0559c());

    @Override // com.google.android.gms.location.GeofencingClient
    public N1.j addGeofences(GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.e(geofencingRequest, 5, pendingIntent);
        dVarB.f2525b = 2424;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.SettingsClient
    public N1.j checkLocationSettings(LocationSettingsRequest locationSettingsRequest) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new Z2.c(5, locationSettingsRequest);
        dVarB.f2525b = 2426;
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.SettingsClient
    public N1.j isGoogleLocationAccuracyEnabled() {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = n2.e.f8784j;
        dVarB.f2525b = 2444;
        dVarB.f2528e = new C0787d[]{zzo.zzm};
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.ActivityRecognitionClient
    public N1.j removeActivityTransitionUpdates(PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new C0010h(0, pendingIntent);
        dVarB.f2525b = 2406;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.ActivityRecognitionClient
    public N1.j removeActivityUpdates(PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new B0.l(1, pendingIntent);
        dVarB.f2525b = 2402;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.GeofencingClient
    public N1.j removeGeofences(PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new C0010h(1, pendingIntent);
        dVarB.f2525b = 2425;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedOrientationProviderClient
    public N1.j removeOrientationUpdates(DeviceOrientationListener deviceOrientationListener) {
        return c(h4.d.e(deviceOrientationListener, "DeviceOrientationListener"), 2440).i(C2.c.f188o, n2.e.f8783i);
    }

    @Override // com.google.android.gms.location.ActivityRecognitionClient
    public N1.j removeSleepSegmentUpdates(PendingIntent pendingIntent) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.l(3, pendingIntent);
        dVarB.f2525b = 2411;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.ActivityRecognitionClient
    public N1.j requestActivityTransitionUpdates(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent) {
        activityTransitionRequest.zza(this.f8902b);
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.s(activityTransitionRequest, 2, pendingIntent);
        dVarB.f2525b = 2405;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.ActivityRecognitionClient
    public N1.j requestActivityUpdates(long j5, PendingIntent pendingIntent) {
        zza zzaVar = new zza();
        zzaVar.zza(j5);
        zzb zzbVarZzb = zzaVar.zzb();
        zzbVarZzb.zza(this.f8902b);
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.e(zzbVarZzb, 3, pendingIntent);
        dVarB.f2525b = 2401;
        return d(1, dVarB.a());
    }

    @Override // com.google.android.gms.location.FusedOrientationProviderClient
    public N1.j requestOrientationUpdates(DeviceOrientationRequest deviceOrientationRequest, Executor executor, DeviceOrientationListener deviceOrientationListener) {
        androidx.emoji2.text.e eVarD = h4.d.d(deviceOrientationListener, "DeviceOrientationListener", executor);
        L0.c cVar = new L0.c(5, eVarD, deviceOrientationRequest, false);
        B0.l lVar = new B0.l(2, eVarD);
        m1.m mVar = new m1.m();
        mVar.f8545d = cVar;
        mVar.f8546e = lVar;
        mVar.f8547f = eVarD;
        mVar.f8544c = 2434;
        return b(mVar.a());
    }

    @Override // com.google.android.gms.location.ActivityRecognitionClient
    public N1.j requestSleepSegmentUpdates(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest) {
        q1.E.j(pendingIntent, "PendingIntent must be specified.");
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.c(this, pendingIntent, sleepSegmentRequest);
        dVarB.f2528e = new C0787d[]{zzo.zzb};
        dVarB.f2525b = 2410;
        return d(0, dVarB.a());
    }

    @Override // com.google.android.gms.location.GeofencingClient
    public N1.j removeGeofences(List list) {
        V1.d dVarB = V1.d.b();
        dVarB.f2527d = new L0.l(5, list);
        dVarB.f2525b = 2425;
        return d(1, dVarB.a());
    }
}
