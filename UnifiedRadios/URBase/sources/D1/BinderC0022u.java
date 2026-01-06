package D1;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.zzw;
import com.google.android.gms.location.zzz;

/* renamed from: D1.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0022u extends AbstractBinderC0013k implements Z {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f403c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ N1.k f404d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f405e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BinderC0022u(N1.k kVar, AbstractBinderC0013k abstractBinderC0013k, int i5) {
        this();
        this.f403c = i5;
        this.f404d = kVar;
        this.f405e = abstractBinderC0013k;
    }

    private final void a() {
    }

    @Override // D1.Z
    public final void A(X x4) {
        switch (this.f403c) {
            case 0:
                h4.f.m(x4.f386j, null, this.f404d);
                break;
            case 1:
                h4.f.m(x4.f386j, this.f405e, this.f404d);
                break;
            default:
                h4.f.m(x4.f386j, null, this.f404d);
                break;
        }
    }

    @Override // D1.AbstractBinderC0013k
    public final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        if (i5 == 1) {
            X x4 = (X) AbstractC0019q.a(parcel, X.CREATOR);
            AbstractC0019q.c(parcel);
            A(x4);
        } else {
            if (i5 != 2) {
                return false;
            }
            zze();
        }
        return true;
    }

    @Override // D1.Z
    public final void zze() throws RemoteException {
        switch (this.f403c) {
            case 0:
                ((zzw) this.f405e).zzf();
                break;
            case 1:
                break;
            default:
                ((zzz) this.f405e).zze();
                break;
        }
    }

    public BinderC0022u() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BinderC0022u(Boolean bool, N1.k kVar) {
        this();
        this.f403c = 1;
        this.f405e = bool;
        this.f404d = kVar;
    }
}
