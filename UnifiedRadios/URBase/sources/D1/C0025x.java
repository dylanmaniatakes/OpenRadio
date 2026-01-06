package D1;

import android.os.RemoteException;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* renamed from: D1.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0025x extends LocationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ N1.k f409a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ D f410b;

    public C0025x(D d5, N1.k kVar) {
        this.f409a = kVar;
        this.f410b = d5;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public final void onLocationResult(LocationResult locationResult) {
        this.f409a.c(locationResult.getLastLocation());
        try {
            this.f410b.M(h4.d.e(this, "GetCurrentLocation"), false, new N1.k());
        } catch (RemoteException unused) {
        }
    }
}
