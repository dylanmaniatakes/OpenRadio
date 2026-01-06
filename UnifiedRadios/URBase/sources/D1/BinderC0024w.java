package D1;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationAvailability;

/* renamed from: D1.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0024w extends AbstractBinderC0013k {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f407c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ N1.k f408d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC0024w(int i5, N1.k kVar) {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
        this.f407c = i5;
        switch (i5) {
            case 1:
                this.f408d = kVar;
                super("com.google.android.gms.location.internal.ILocationStatusCallback");
                break;
            case 2:
                this.f408d = kVar;
                super("com.google.android.gms.location.internal.ILocationAvailabilityStatusCallback");
                break;
            case 3:
                this.f408d = kVar;
                super("com.google.android.gms.location.internal.IBooleanStatusCallback");
                break;
            default:
                this.f408d = kVar;
                break;
        }
    }

    @Override // D1.AbstractBinderC0013k
    public final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        switch (this.f407c) {
            case 0:
                N1.k kVar = this.f408d;
                if (i5 == 1) {
                    int i7 = parcel.readInt();
                    parcel.createStringArray();
                    AbstractC0019q.c(parcel);
                    h4.f.m(new Status(GeofenceStatusCodes.zza(i7), null, null, null), null, kVar);
                    break;
                } else if (i5 == 2) {
                    int i8 = parcel.readInt();
                    parcel.createStringArray();
                    AbstractC0019q.c(parcel);
                    h4.f.m(new Status(GeofenceStatusCodes.zza(i8), null, null, null), null, kVar);
                    break;
                } else if (i5 == 3) {
                    int i9 = parcel.readInt();
                    AbstractC0019q.c(parcel);
                    h4.f.m(new Status(GeofenceStatusCodes.zza(i9), null, null, null), null, kVar);
                    break;
                }
                break;
            case 1:
                if (i5 == 1) {
                    Status status = (Status) AbstractC0019q.a(parcel, Status.CREATOR);
                    Location location = (Location) AbstractC0019q.a(parcel, Location.CREATOR);
                    AbstractC0019q.c(parcel);
                    h4.f.m(status, location, this.f408d);
                    break;
                }
                break;
            case 2:
                if (i5 == 1) {
                    Status status2 = (Status) AbstractC0019q.a(parcel, Status.CREATOR);
                    LocationAvailability locationAvailability = (LocationAvailability) AbstractC0019q.a(parcel, LocationAvailability.CREATOR);
                    AbstractC0019q.c(parcel);
                    h4.f.m(status2, locationAvailability, this.f408d);
                    break;
                }
                break;
            default:
                if (i5 == 1) {
                    Status status3 = (Status) AbstractC0019q.a(parcel, Status.CREATOR);
                    boolean z4 = parcel.readInt() != 0;
                    AbstractC0019q.c(parcel);
                    h4.f.m(status3, Boolean.valueOf(z4), this.f408d);
                    break;
                }
                break;
        }
        return true;
    }
}
