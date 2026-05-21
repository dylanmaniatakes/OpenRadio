package D1;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzo;
import java.util.Objects;
import n1.C0787d;
import q1.AbstractC0858i;

/* loaded from: classes.dex */
public final class D extends AbstractC0858i {

    /* renamed from: A, reason: collision with root package name */
    public final q.k f333A;

    /* renamed from: B, reason: collision with root package name */
    public final q.k f334B;

    /* renamed from: C, reason: collision with root package name */
    public final q.k f335C;

    public D(Context context, Looper looper, D0.w wVar, o1.i iVar, o1.j jVar) {
        super(context, looper, 23, wVar, iVar, jVar);
        this.f333A = new q.k();
        this.f334B = new q.k();
        this.f335C = new q.k();
    }

    public final void B(Location location, N1.k kVar) throws RemoteException {
        if (!G(zzo.zzh)) {
            a0 a0Var = (a0) t();
            Parcel parcelZza = a0Var.zza();
            AbstractC0019q.b(parcelZza, location);
            a0Var.zzc(13, parcelZza);
            kVar.a(null);
            return;
        }
        a0 a0Var2 = (a0) t();
        BinderC0026y binderC0026y = new BinderC0026y(null, kVar);
        Parcel parcelZza2 = a0Var2.zza();
        AbstractC0019q.b(parcelZza2, location);
        parcelZza2.writeStrongBinder(binderC0026y);
        a0Var2.zzc(85, parcelZza2);
    }

    public final void C(androidx.emoji2.text.e eVar, DeviceOrientationRequest deviceOrientationRequest, N1.k kVar) {
        p1.l lVar = (p1.l) eVar.f3602c;
        Objects.requireNonNull(lVar);
        synchronized (this.f335C) {
            try {
                BinderC0027z binderC0027z = (BinderC0027z) this.f335C.getOrDefault(lVar, null);
                if (binderC0027z == null) {
                    binderC0027z = new BinderC0027z();
                    binderC0027z.f413c = eVar;
                    this.f335C.put(lVar, binderC0027z);
                } else {
                    synchronized (binderC0027z) {
                        try {
                            androidx.emoji2.text.e eVar2 = binderC0027z.f413c;
                            if (eVar2 != eVar) {
                                eVar2.a();
                                binderC0027z.f413c = eVar;
                            }
                        } finally {
                        }
                    }
                }
                a0 a0Var = (a0) t();
                W w4 = new W(1, new V(deviceOrientationRequest, V.f378m, null), binderC0027z, new BinderC0022u(null, kVar));
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, w4);
                a0Var.zzc(75, parcelZza);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void D(p1.l lVar, N1.k kVar) {
        synchronized (this.f335C) {
            try {
                BinderC0027z binderC0027z = (BinderC0027z) this.f335C.remove(lVar);
                if (binderC0027z == null) {
                    kVar.a(Boolean.FALSE);
                    return;
                }
                synchronized (binderC0027z) {
                    binderC0027z.f413c.a();
                }
                a0 a0Var = (a0) t();
                W w4 = new W(2, null, binderC0027z, new BinderC0022u(Boolean.TRUE, kVar));
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, w4);
                a0Var.zzc(75, parcelZza);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void E(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, N1.k kVar) {
        if (G(zzo.zzn)) {
            a0 a0Var = (a0) t();
            BinderC0026y binderC0026y = new BinderC0026y(null, kVar);
            Parcel parcelZza = a0Var.zza();
            AbstractC0019q.b(parcelZza, geofencingRequest);
            AbstractC0019q.b(parcelZza, pendingIntent);
            parcelZza.writeStrongBinder(binderC0026y);
            a0Var.zzc(97, parcelZza);
            return;
        }
        a0 a0Var2 = (a0) t();
        BinderC0024w binderC0024w = new BinderC0024w(0, kVar);
        Parcel parcelZza2 = a0Var2.zza();
        AbstractC0019q.b(parcelZza2, geofencingRequest);
        AbstractC0019q.b(parcelZza2, pendingIntent);
        parcelZza2.writeStrongBinder(binderC0024w.asBinder());
        a0Var2.zzc(57, parcelZza2);
    }

    public final void F(K k5, N1.k kVar) {
        if (G(zzo.zzn)) {
            a0 a0Var = (a0) t();
            BinderC0026y binderC0026y = new BinderC0026y(null, kVar);
            Parcel parcelZza = a0Var.zza();
            AbstractC0019q.b(parcelZza, k5);
            parcelZza.writeStrongBinder(binderC0026y);
            a0Var.zzc(98, parcelZza);
            return;
        }
        a0 a0Var2 = (a0) t();
        BinderC0024w binderC0024w = new BinderC0024w(0, kVar);
        Parcel parcelZza2 = a0Var2.zza();
        AbstractC0019q.b(parcelZza2, k5);
        parcelZza2.writeStrongBinder(binderC0024w.asBinder());
        a0Var2.zzc(74, parcelZza2);
    }

    public final boolean G(C0787d c0787d) {
        C0787d c0787d2;
        C0787d[] c0787dArrH = h();
        if (c0787dArrH != null) {
            int i5 = 0;
            while (true) {
                if (i5 >= c0787dArrH.length) {
                    c0787d2 = null;
                    break;
                }
                c0787d2 = c0787dArrH[i5];
                if (c0787d.f8734j.equals(c0787d2.f8734j)) {
                    break;
                }
                i5++;
            }
            if (c0787d2 != null && c0787d2.a() >= c0787d.a()) {
                return true;
            }
        }
        return false;
    }

    public final void H(LastLocationRequest lastLocationRequest, N1.k kVar) {
        if (G(zzo.zzj)) {
            a0 a0Var = (a0) t();
            F f5 = new F(4, null, new BinderC0024w(1, kVar), null, null);
            Parcel parcelZza = a0Var.zza();
            AbstractC0019q.b(parcelZza, lastLocationRequest);
            AbstractC0019q.b(parcelZza, f5);
            a0Var.zzc(90, parcelZza);
            return;
        }
        if (!G(zzo.zzf)) {
            a0 a0Var2 = (a0) t();
            Parcel parcelZzb = a0Var2.zzb(7, a0Var2.zza());
            Location location = (Location) AbstractC0019q.a(parcelZzb, Location.CREATOR);
            parcelZzb.recycle();
            kVar.a(location);
            return;
        }
        a0 a0Var3 = (a0) t();
        BinderC0024w binderC0024w = new BinderC0024w(1, kVar);
        Parcel parcelZza2 = a0Var3.zza();
        AbstractC0019q.b(parcelZza2, lastLocationRequest);
        parcelZza2.writeStrongBinder(binderC0024w.asBinder());
        a0Var3.zzc(82, parcelZza2);
    }

    public final void I(A a2, LocationRequest locationRequest, N1.k kVar) {
        C c2;
        androidx.emoji2.text.e eVarA = a2.a();
        p1.l lVar = (p1.l) eVarA.f3602c;
        Objects.requireNonNull(lVar);
        boolean zG = G(zzo.zzj);
        synchronized (this.f333A) {
            try {
                C c5 = (C) this.f333A.getOrDefault(lVar, null);
                if (c5 == null || zG) {
                    C c6 = new C(a2);
                    this.f333A.put(lVar, c6);
                    c2 = c6;
                } else {
                    c5.f332c.b(eVarA);
                    c2 = c5;
                    c5 = null;
                }
                if (zG) {
                    ((a0) t()).b(new F(1, c5 == null ? null : c5, c2, null, lVar.a()), locationRequest, new BinderC0026y(null, kVar));
                } else {
                    ((a0) t()).a(new I(1, new H(locationRequest, null, false, false, false, false, Long.MAX_VALUE), c2, null, null, new BinderC0022u(kVar, c2, 2), lVar.a()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void J(A a2, LocationRequest locationRequest, N1.k kVar) {
        B b5;
        androidx.emoji2.text.e eVarA = a2.a();
        p1.l lVar = (p1.l) eVarA.f3602c;
        Objects.requireNonNull(lVar);
        boolean zG = G(zzo.zzj);
        synchronized (this.f334B) {
            try {
                B b6 = (B) this.f334B.getOrDefault(lVar, null);
                if (b6 == null || zG) {
                    B b7 = new B(a2);
                    this.f334B.put(lVar, b7);
                    b5 = b7;
                } else {
                    b6.f331c.b(eVarA);
                    b5 = b6;
                    b6 = null;
                }
                if (zG) {
                    ((a0) t()).b(new F(2, b6 == null ? null : b6, b5, null, lVar.a()), locationRequest, new BinderC0026y(null, kVar));
                } else {
                    ((a0) t()).a(new I(1, new H(locationRequest, null, false, false, false, false, Long.MAX_VALUE), null, b5, null, new BinderC0022u(kVar, b5, 0), lVar.a()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void K(PendingIntent pendingIntent, LocationRequest locationRequest, N1.k kVar) {
        if (G(zzo.zzj)) {
            ((a0) t()).b(new F(3, null, null, pendingIntent, null), locationRequest, new BinderC0026y(null, kVar));
            return;
        }
        a0 a0Var = (a0) t();
        H h = new H(locationRequest, null, false, false, false, false, Long.MAX_VALUE);
        BinderC0022u binderC0022u = new BinderC0022u(null, kVar);
        int iHashCode = pendingIntent.hashCode();
        StringBuilder sb = new StringBuilder(String.valueOf(iHashCode).length() + 14);
        sb.append("PendingIntent@");
        sb.append(iHashCode);
        a0Var.a(new I(1, h, null, null, pendingIntent, binderC0022u, sb.toString()));
    }

    public final void L(p1.l lVar, boolean z4, N1.k kVar) {
        synchronized (this.f333A) {
            try {
                C c2 = (C) this.f333A.remove(lVar);
                if (c2 == null) {
                    kVar.a(Boolean.FALSE);
                    return;
                }
                c2.f332c.a().a();
                if (!z4) {
                    kVar.a(Boolean.TRUE);
                } else if (G(zzo.zzj)) {
                    a0 a0Var = (a0) t();
                    int iIdentityHashCode = System.identityHashCode(c2);
                    StringBuilder sb = new StringBuilder(String.valueOf(iIdentityHashCode).length() + 18);
                    sb.append("ILocationListener@");
                    sb.append(iIdentityHashCode);
                    F f5 = new F(1, null, c2, null, sb.toString());
                    BinderC0026y binderC0026y = new BinderC0026y(Boolean.TRUE, kVar);
                    Parcel parcelZza = a0Var.zza();
                    AbstractC0019q.b(parcelZza, f5);
                    parcelZza.writeStrongBinder(binderC0026y);
                    a0Var.zzc(89, parcelZza);
                } else {
                    ((a0) t()).a(new I(2, null, c2, null, null, new BinderC0022u(Boolean.TRUE, kVar), null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void M(p1.l lVar, boolean z4, N1.k kVar) {
        synchronized (this.f334B) {
            try {
                B b5 = (B) this.f334B.remove(lVar);
                if (b5 == null) {
                    kVar.a(Boolean.FALSE);
                    return;
                }
                b5.f331c.a().a();
                if (!z4) {
                    kVar.a(Boolean.TRUE);
                } else if (G(zzo.zzj)) {
                    a0 a0Var = (a0) t();
                    int iIdentityHashCode = System.identityHashCode(b5);
                    StringBuilder sb = new StringBuilder(String.valueOf(iIdentityHashCode).length() + 18);
                    sb.append("ILocationCallback@");
                    sb.append(iIdentityHashCode);
                    F f5 = new F(2, null, b5, null, sb.toString());
                    BinderC0026y binderC0026y = new BinderC0026y(Boolean.TRUE, kVar);
                    Parcel parcelZza = a0Var.zza();
                    AbstractC0019q.b(parcelZza, f5);
                    parcelZza.writeStrongBinder(binderC0026y);
                    a0Var.zzc(89, parcelZza);
                } else {
                    ((a0) t()).a(new I(2, null, null, b5, null, new BinderC0022u(Boolean.TRUE, kVar), null));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void N(PendingIntent pendingIntent, N1.k kVar) {
        if (!G(zzo.zzj)) {
            ((a0) t()).a(new I(2, null, null, null, pendingIntent, new BinderC0022u(null, kVar), null));
            return;
        }
        a0 a0Var = (a0) t();
        F f5 = new F(3, null, null, pendingIntent, null);
        BinderC0026y binderC0026y = new BinderC0026y(null, kVar);
        Parcel parcelZza = a0Var.zza();
        AbstractC0019q.b(parcelZza, f5);
        parcelZza.writeStrongBinder(binderC0026y);
        a0Var.zzc(89, parcelZza);
    }

    public final void O(N1.k kVar) {
        if (!G(zzo.zzg)) {
            a0 a0Var = (a0) t();
            Parcel parcelZza = a0Var.zza();
            int i5 = AbstractC0019q.f402a;
            parcelZza.writeInt(1);
            a0Var.zzc(12, parcelZza);
            kVar.a(null);
            return;
        }
        a0 a0Var2 = (a0) t();
        BinderC0026y binderC0026y = new BinderC0026y(null, kVar);
        Parcel parcelZza2 = a0Var2.zza();
        int i6 = AbstractC0019q.f402a;
        parcelZza2.writeInt(1);
        parcelZza2.writeStrongBinder(binderC0026y);
        a0Var2.zzc(84, parcelZza2);
    }

    public final void P(N1.k kVar) {
        if (!G(zzo.zzg)) {
            a0 a0Var = (a0) t();
            Parcel parcelZza = a0Var.zza();
            int i5 = AbstractC0019q.f402a;
            parcelZza.writeInt(0);
            a0Var.zzc(12, parcelZza);
            kVar.a(Boolean.TRUE);
            return;
        }
        a0 a0Var2 = (a0) t();
        BinderC0026y binderC0026y = new BinderC0026y(Boolean.TRUE, kVar);
        Parcel parcelZza2 = a0Var2.zza();
        int i6 = AbstractC0019q.f402a;
        parcelZza2.writeInt(0);
        parcelZza2.writeStrongBinder(binderC0026y);
        a0Var2.zzc(84, parcelZza2);
    }

    @Override // q1.AbstractC0854e, o1.c
    public final int f() {
        return 11717000;
    }

    @Override // q1.AbstractC0854e
    public final /* synthetic */ IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof a0 ? (a0) iInterfaceQueryLocalInterface : new a0(iBinder);
    }

    @Override // q1.AbstractC0854e
    public final C0787d[] q() {
        return zzo.zzp;
    }

    @Override // q1.AbstractC0854e
    public final String u() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // q1.AbstractC0854e
    public final String v() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // q1.AbstractC0854e
    public final void x() {
        System.currentTimeMillis();
        synchronized (this.f333A) {
            this.f333A.clear();
        }
        synchronized (this.f334B) {
            this.f334B.clear();
        }
        synchronized (this.f335C) {
            this.f335C.clear();
        }
    }
}
