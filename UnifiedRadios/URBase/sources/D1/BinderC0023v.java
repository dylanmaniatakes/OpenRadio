package D1;

import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;

/* renamed from: D1.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0023v extends AbstractBinderC0013k implements InterfaceC0004b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ N1.k f406c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC0023v(N1.k kVar) {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
        this.f406c = kVar;
    }

    @Override // D1.InterfaceC0004b
    public final void m(LocationSettingsResult locationSettingsResult) {
        h4.f.m(locationSettingsResult.getStatus(), new LocationSettingsResponse(locationSettingsResult), this.f406c);
    }

    @Override // D1.AbstractBinderC0013k
    public final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 != 1) {
            return false;
        }
        LocationSettingsResult locationSettingsResult = (LocationSettingsResult) AbstractC0019q.a(parcel, LocationSettingsResult.CREATOR);
        AbstractC0019q.c(parcel);
        m(locationSettingsResult);
        return true;
    }
}
