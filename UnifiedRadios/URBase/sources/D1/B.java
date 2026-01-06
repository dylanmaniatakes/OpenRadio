package D1;

import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzv;
import f3.C0519j;

/* loaded from: classes.dex */
public final class B extends zzv {

    /* renamed from: c, reason: collision with root package name */
    public final A f331c;

    public B(A a2) {
        this.f331c = a2;
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzd(LocationResult locationResult) {
        this.f331c.a().b(new C0519j(3, locationResult));
    }

    @Override // com.google.android.gms.location.zzw
    public final void zze(LocationAvailability locationAvailability) {
        this.f331c.a().b(new L0.l(6, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzf() {
        this.f331c.a().b(new Z2.c(6, this));
    }
}
