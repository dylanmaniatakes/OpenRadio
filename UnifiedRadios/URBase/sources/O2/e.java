package O2;

import D1.AbstractC0019q;
import D1.BinderC0024w;
import D1.C0017o;
import D1.C0021t;
import D1.D;
import D1.InterfaceC0015m;
import D1.a0;
import F2.t;
import J1.F;
import J1.H;
import N1.j;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C0337i3;
import com.google.android.gms.internal.measurement.C0347k3;
import com.google.android.gms.internal.measurement.C0352l3;
import com.google.android.gms.internal.measurement.C0362n3;
import com.google.android.gms.internal.measurement.D3;
import com.google.android.gms.internal.measurement.E3;
import com.google.android.gms.internal.measurement.F3;
import com.google.android.gms.internal.measurement.G3;
import com.google.android.gms.internal.measurement.H3;
import com.google.android.gms.internal.measurement.I3;
import com.google.android.gms.internal.measurement.InterfaceC0342j3;
import com.google.android.gms.internal.measurement.InterfaceC0357m3;
import com.google.android.gms.internal.measurement.M3;
import com.google.android.gms.internal.measurement.O3;
import com.google.android.gms.internal.measurement.T2;
import com.google.android.gms.internal.measurement.U2;
import com.google.android.gms.internal.measurement.V2;
import com.google.android.gms.internal.measurement.W2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.internal.measurement.e4;
import com.google.android.gms.internal.measurement.g4;
import com.google.android.gms.internal.measurement.h4;
import com.google.android.gms.internal.measurement.i4;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsApi;
import com.google.android.gms.location.zzac;
import com.google.android.gms.location.zzad;
import com.google.android.gms.location.zzo;
import com.google.android.gms.maps.model.PinConfig;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import java.util.List;
import o1.k;
import o1.l;
import p1.o;

/* loaded from: classes.dex */
public final class e implements N2.a, N1.b, o, InterfaceC0015m, SettingsApi, F2.e, F {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ e f2033d = new e(4);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ e f2034e = new e(5);

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ e f2035f = new e(6);
    public static final /* synthetic */ e g = new e(7);
    public static final /* synthetic */ e h = new e(8);

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ e f2036i = new e(9);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2037c;

    public /* synthetic */ e(int i5) {
        this.f2037c = i5;
    }

    public static final boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    @Override // J1.F
    public Object a() {
        switch (this.f2037c) {
            case o1.f.ERROR /* 13 */:
                List list = H.f796a;
                ((C0362n3) ((InterfaceC0357m3) C0352l3.f4978k.f4979j.f10447j)).getClass();
                Boolean bool = (Boolean) C0362n3.f5000b.b();
                bool.getClass();
                return bool;
            case o1.f.INTERRUPTED /* 14 */:
                List list2 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4860o0.b()).longValue());
            case 15:
                List list3 = H.f796a;
                ((I3) ((H3) G3.f4695k.f4696j.f10447j)).getClass();
                Boolean bool2 = (Boolean) I3.f4702a.b();
                bool2.getClass();
                return bool2;
            case 16:
                List list4 = H.f796a;
                ((p4) ((o4) n4.f5002k.f5003j.f10447j)).getClass();
                Boolean bool3 = (Boolean) p4.f5018a.b();
                bool3.getClass();
                return bool3;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                List list5 = H.f796a;
                ((C0347k3) ((InterfaceC0342j3) C0337i3.f4960k.f4961j.f10447j)).getClass();
                Boolean bool4 = (Boolean) C0347k3.f4972a.b();
                bool4.getClass();
                return bool4;
            case 18:
                List list6 = H.f796a;
                ((V2) ((U2) T2.f4773k.f4774j.f10447j)).getClass();
                Boolean bool5 = (Boolean) V2.f4791a.b();
                bool5.getClass();
                return bool5;
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                List list7 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool6 = (Boolean) g4.g.b();
                bool6.getClass();
                return bool6;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                List list8 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4845f0.b()).longValue());
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                List list9 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool7 = (Boolean) g4.f4942e.b();
                bool7.getClass();
                return bool7;
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                List list10 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool8 = (Boolean) g4.f4941d.b();
                bool8.getClass();
                return bool8;
            case 23:
                List list11 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool9 = (Boolean) g4.f4938a.b();
                bool9.getClass();
                return bool9;
            case 24:
                ((F3) ((E3) D3.f4675k.f4676j.f10447j)).getClass();
                Boolean bool10 = (Boolean) F3.f4692a.b();
                bool10.getClass();
                return bool10;
            case 25:
                List list12 = H.f796a;
                ((O3) M3.f4742k.get()).getClass();
                Boolean bool11 = (Boolean) O3.f4747a.b();
                bool11.getClass();
                return bool11;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                List list13 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4851j0.b()).longValue());
            case 27:
                List list14 = H.f796a;
                ((O3) M3.f4742k.get()).getClass();
                Boolean bool12 = (Boolean) O3.f4750d.b();
                bool12.getClass();
                return bool12;
            case 28:
                List list15 = H.f796a;
                ((O3) M3.f4742k.get()).getClass();
                Boolean bool13 = (Boolean) O3.f4749c.b();
                bool13.getClass();
                return bool13;
            default:
                List list16 = H.f796a;
                ((j4) ((i4) h4.f4950k.f4951j.f10447j)).getClass();
                Boolean bool14 = (Boolean) j4.f4967a.b();
                bool14.getClass();
                return bool14;
        }
    }

    @Override // F2.e
    public Object b(t tVar) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(tVar);
    }

    @Override // N1.b
    public /* synthetic */ Object c(j jVar) {
        int i5 = this.f2037c;
        return null;
    }

    @Override // com.google.android.gms.location.SettingsApi
    public l checkLocationSettings(k kVar, LocationSettingsRequest locationSettingsRequest) {
        new C0021t(C0017o.f398i, kVar);
        throw null;
    }

    @Override // D1.InterfaceC0015m
    public /* synthetic */ void d(D d5, p1.l lVar, boolean z4, N1.k kVar) {
        switch (this.f2037c) {
            case 7:
                d5.M(lVar, z4, kVar);
                break;
            default:
                d5.L(lVar, z4, kVar);
                break;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        switch (this.f2037c) {
            case 5:
                N1.k kVar = (N1.k) obj2;
                D d5 = (D) obj;
                zzad zzadVarZza = zzac.zza();
                if (!d5.G(zzo.zzj)) {
                    a0 a0Var = (a0) d5.t();
                    String packageName = d5.f9348c.getPackageName();
                    Parcel parcelZza = a0Var.zza();
                    parcelZza.writeString(packageName);
                    Parcel parcelZzb = a0Var.zzb(34, parcelZza);
                    LocationAvailability locationAvailability = (LocationAvailability) AbstractC0019q.a(parcelZzb, LocationAvailability.CREATOR);
                    parcelZzb.recycle();
                    kVar.a(locationAvailability);
                    break;
                } else {
                    a0 a0Var2 = (a0) d5.t();
                    D1.F f5 = new D1.F(5, null, new BinderC0024w(2, kVar), null, null);
                    Parcel parcelZza2 = a0Var2.zza();
                    AbstractC0019q.b(parcelZza2, zzadVarZza);
                    AbstractC0019q.b(parcelZza2, f5);
                    a0Var2.zzc(91, parcelZza2);
                    break;
                }
            default:
                ((D) obj).O((N1.k) obj2);
                break;
        }
    }
}
