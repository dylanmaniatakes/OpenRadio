package n2;

import D1.AbstractC0019q;
import D1.BinderC0022u;
import D1.BinderC0024w;
import D1.C0005c;
import D1.D;
import D1.a0;
import J1.F;
import J1.H;
import J1.InterfaceC0065f;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C0302b3;
import com.google.android.gms.internal.measurement.C0337i3;
import com.google.android.gms.internal.measurement.C0347k3;
import com.google.android.gms.internal.measurement.C0352l3;
import com.google.android.gms.internal.measurement.C0362n3;
import com.google.android.gms.internal.measurement.InterfaceC0297a3;
import com.google.android.gms.internal.measurement.InterfaceC0342j3;
import com.google.android.gms.internal.measurement.InterfaceC0357m3;
import com.google.android.gms.internal.measurement.M3;
import com.google.android.gms.internal.measurement.N2;
import com.google.android.gms.internal.measurement.O2;
import com.google.android.gms.internal.measurement.O3;
import com.google.android.gms.internal.measurement.P2;
import com.google.android.gms.internal.measurement.P3;
import com.google.android.gms.internal.measurement.Q3;
import com.google.android.gms.internal.measurement.R3;
import com.google.android.gms.internal.measurement.S3;
import com.google.android.gms.internal.measurement.T3;
import com.google.android.gms.internal.measurement.U3;
import com.google.android.gms.internal.measurement.V3;
import com.google.android.gms.internal.measurement.W2;
import com.google.android.gms.internal.measurement.W3;
import com.google.android.gms.internal.measurement.X3;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.internal.measurement.Y3;
import com.google.android.gms.internal.measurement.Z2;
import com.google.android.gms.internal.measurement.Z3;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.e4;
import com.google.android.gms.internal.measurement.g4;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.gms.internal.measurement.l4;
import com.google.android.gms.internal.measurement.m4;
import com.google.android.gms.location.ActivityRecognitionApi;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.PinConfig;
import java.util.List;

/* loaded from: classes.dex */
public class e implements ActivityRecognitionApi, N1.b, p1.o, InterfaceC0065f, F {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ e f8780d = new e(4);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ e f8781e = new e(5);

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ e f8782f = new e(6);
    public static final /* synthetic */ e g = new e(7);
    public static final /* synthetic */ e h = new e(8);

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ e f8783i = new e(9);

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ e f8784j = new e(10);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8785c;

    public /* synthetic */ e(int i5) {
        this.f8785c = i5;
    }

    @Override // J1.F
    public Object a() {
        switch (this.f8785c) {
            case o1.f.ERROR /* 13 */:
                List list = H.f796a;
                ((C0362n3) ((InterfaceC0357m3) C0352l3.f4978k.f4979j.f10447j)).getClass();
                Boolean bool = (Boolean) C0362n3.f4999a.b();
                bool.getClass();
                return bool;
            case o1.f.INTERRUPTED /* 14 */:
                List list2 = H.f796a;
                ((C0362n3) ((InterfaceC0357m3) C0352l3.f4978k.f4979j.f10447j)).getClass();
                Boolean bool2 = (Boolean) C0362n3.f5001c.b();
                bool2.getClass();
                return bool2;
            case 15:
                List list3 = H.f796a;
                ((m4) ((l4) k4.f4974k.f4975j.f10447j)).getClass();
                Boolean bool3 = (Boolean) m4.f4986a.b();
                bool3.getClass();
                return bool3;
            case 16:
                List list4 = H.f796a;
                ((C0302b3) ((InterfaceC0297a3) Z2.f4885k.f4886j.f10447j)).getClass();
                return Integer.valueOf((int) ((Long) C0302b3.f4904a.b()).longValue());
            case o1.f.API_NOT_CONNECTED /* 17 */:
                List list5 = H.f796a;
                ((C0347k3) ((InterfaceC0342j3) C0337i3.f4960k.f4961j.f10447j)).getClass();
                Boolean bool4 = (Boolean) C0347k3.f4973b.b();
                bool4.getClass();
                return bool4;
            case 18:
                List list6 = H.f796a;
                ((a4) ((Z3) Y3.f4877k.f4878j.f10447j)).getClass();
                Boolean bool5 = (Boolean) a4.f4893a.b();
                bool5.getClass();
                return bool5;
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                List list7 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool6 = (Boolean) g4.f4940c.b();
                bool6.getClass();
                return bool6;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                List list8 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool7 = (Boolean) g4.h.b();
                bool7.getClass();
                return bool7;
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                List list9 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool8 = (Boolean) g4.f4943f.b();
                bool8.getClass();
                return bool8;
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                List list10 = H.f796a;
                ((g4) e4.f4928k.get()).getClass();
                Boolean bool9 = (Boolean) g4.f4939b.b();
                bool9.getClass();
                return bool9;
            case 23:
                List list11 = H.f796a;
                ((P2) ((O2) N2.f4744k.f4745j.f10447j)).getClass();
                Boolean bool10 = (Boolean) P2.f4754a.b();
                bool10.getClass();
                return bool10;
            case 24:
                List list12 = H.f796a;
                ((O3) M3.f4742k.get()).getClass();
                Boolean bool11 = (Boolean) O3.f4752f.b();
                bool11.getClass();
                return bool11;
            case 25:
                List list13 = H.f796a;
                ((O3) M3.f4742k.get()).getClass();
                Boolean bool12 = (Boolean) O3.h.b();
                bool12.getClass();
                return bool12;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                List list14 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4853k0.b()).longValue());
            case 27:
                List list15 = H.f796a;
                ((R3) ((Q3) P3.f4755k.f4756j.f10447j)).getClass();
                Boolean bool13 = (Boolean) R3.f4766a.b();
                bool13.getClass();
                return bool13;
            case 28:
                ((X3) ((W3) V3.f4792k.f4793j.f10447j)).getClass();
                Boolean bool14 = (Boolean) X3.f4802a.b();
                bool14.getClass();
                return bool14;
            default:
                List list16 = H.f796a;
                ((U3) ((T3) S3.f4770k.f4771j.f10447j)).getClass();
                Boolean bool15 = (Boolean) U3.f4778a.b();
                bool15.getClass();
                return bool15;
        }
    }

    @Override // J1.InterfaceC0065f
    public String b(String str, String str2) {
        return null;
    }

    @Override // N1.b
    public /* synthetic */ Object c(N1.j jVar) {
        int i5 = this.f8785c;
        return null;
    }

    public boolean d() {
        return this instanceof f;
    }

    public void e(float f5, float f6, float f7, w wVar) {
        wVar.c(f5, BitmapDescriptorFactory.HUE_RED);
    }

    public int f(Object obj) {
        return ((L.i) obj).f1525c;
    }

    public boolean g(Object obj) {
        return ((L.i) obj).f1526d;
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        switch (this.f8785c) {
            case 6:
                ((D) obj).H(new LastLocationRequest.Builder().build(), (N1.k) obj2);
                break;
            case 7:
                a0 a0Var = (a0) ((D) obj).t();
                BinderC0022u binderC0022u = new BinderC0022u(null, (N1.k) obj2);
                Parcel parcelZza = a0Var.zza();
                int i5 = AbstractC0019q.f402a;
                parcelZza.writeStrongBinder(binderC0022u.asBinder());
                a0Var.zzc(67, parcelZza);
                break;
            case 8:
                ((D) obj).P((N1.k) obj2);
                break;
            default:
                a0 a0Var2 = (a0) ((D) obj).t();
                BinderC0024w binderC0024w = new BinderC0024w(3, (N1.k) obj2);
                Parcel parcelZza2 = a0Var2.zza();
                int i6 = AbstractC0019q.f402a;
                parcelZza2.writeStrongBinder(binderC0024w.asBinder());
                a0Var2.zzc(95, parcelZza2);
                break;
        }
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public o1.l removeActivityUpdates(o1.k kVar, PendingIntent pendingIntent) {
        new C0005c(kVar, 0);
        throw null;
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public o1.l requestActivityUpdates(o1.k kVar, long j5, PendingIntent pendingIntent) {
        new C0005c(kVar, 0);
        throw null;
    }
}
