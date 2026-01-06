package J1;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.AbstractBinderC0407x;
import com.google.android.gms.internal.measurement.AbstractC0412y;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.maps.model.PinConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n1.AbstractC0791h;
import n1.C0792i;
import org.conscrypt.FileClientSessionCache;
import r1.AbstractC0873a;
import u1.AbstractC0907b;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class E0 extends AbstractBinderC0407x implements J {

    /* renamed from: c, reason: collision with root package name */
    public final V1 f728c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f729d;

    /* renamed from: e, reason: collision with root package name */
    public String f730e;

    public E0(V1 v12) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        q1.E.i(v12);
        this.f728c = v12;
        this.f730e = null;
    }

    @Override // J1.J
    public final void C(C0062e c0062e, b2 b2Var) {
        q1.E.i(c0062e);
        q1.E.i(c0062e.f1193l);
        H(b2Var);
        C0062e c0062e2 = new C0062e(c0062e);
        c0062e2.f1191j = b2Var.f1138j;
        c(new F0.e(this, c0062e2, b2Var, 2, false));
    }

    @Override // J1.J
    public final void D(b2 b2Var, Bundle bundle, L l5) {
        H(b2Var);
        String str = b2Var.f1138j;
        q1.E.i(str);
        this.f728c.e().t(new RunnableC0116w0(this, b2Var, bundle, l5, str));
    }

    @Override // J1.J
    public final void E(b2 b2Var) {
        q1.E.f(b2Var.f1138j);
        q1.E.i(b2Var.f1126D);
        b(new RunnableC0119x0(this, b2Var, 1));
    }

    @Override // J1.J
    public final void F(long j5, String str, String str2, String str3) {
        c(new A0(this, str2, str3, str, j5, 0));
    }

    @Override // J1.J
    public final List G(String str, String str2, String str3, boolean z4) {
        I(str, true);
        V1 v12 = this.f728c;
        try {
            List<Z1> list = (List) v12.e().p(new C0(this, str, str2, str3, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Z1 z12 : list) {
                if (z4 || !a2.e0(z12.f1092c)) {
                    arrayList.add(new Y1(z12));
                }
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            Z zC = v12.c();
            zC.h.c(Z.q(str), e, "Failed to get user properties as. appId");
            return Collections.emptyList();
        } catch (ExecutionException e6) {
            e = e6;
            Z zC2 = v12.c();
            zC2.h.c(Z.q(str), e, "Failed to get user properties as. appId");
            return Collections.emptyList();
        }
    }

    public final void H(b2 b2Var) {
        q1.E.i(b2Var);
        String str = b2Var.f1138j;
        q1.E.f(str);
        I(str, false);
        this.f728c.g().T(b2Var.f1139k, b2Var.f1152y);
    }

    public final void I(String str, boolean z4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        V1 v12 = this.f728c;
        if (zIsEmpty) {
            v12.c().h.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z4) {
            try {
                if (this.f729d == null) {
                    boolean z5 = true;
                    if (!"com.google.android.gms".equals(this.f730e) && !AbstractC0907b.a(v12.n.f1411c, Binder.getCallingUid()) && !C0792i.a(v12.n.f1411c).b(Binder.getCallingUid())) {
                        z5 = false;
                    }
                    this.f729d = Boolean.valueOf(z5);
                }
                if (this.f729d.booleanValue()) {
                    return;
                }
            } catch (SecurityException e5) {
                v12.c().h.b(Z.q(str), "Measurement Service called with invalid calling package. appId");
                throw e5;
            }
        }
        if (this.f730e == null) {
            Context context = v12.n.f1411c;
            int callingUid = Binder.getCallingUid();
            int i5 = AbstractC0791h.f8746e;
            if (AbstractC0907b.c(callingUid, context, str)) {
                this.f730e = str;
            }
        }
        if (str.equals(this.f730e)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    public final void J(C0112v c0112v, b2 b2Var) {
        V1 v12 = this.f728c;
        v12.j();
        v12.o(c0112v, b2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.AbstractBinderC0407x
    public final boolean a(int i5, Parcel parcel, Parcel parcel2) {
        boolean z4;
        List listEmptyList;
        V1 v12 = this.f728c;
        ArrayList arrayList = null;
        L k5 = null;
        N m5 = null;
        switch (i5) {
            case 1:
                C0112v c0112v = (C0112v) AbstractC0412y.a(parcel, C0112v.CREATOR);
                b2 b2Var = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                v(c0112v, b2Var);
                parcel2.writeNoException();
                return true;
            case 2:
                Y1 y12 = (Y1) AbstractC0412y.a(parcel, Y1.CREATOR);
                b2 b2Var2 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                z(y12, b2Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                b2 b2Var3 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                n(b2Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                C0112v c0112v2 = (C0112v) AbstractC0412y.a(parcel, C0112v.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                AbstractC0412y.b(parcel);
                q1.E.i(c0112v2);
                q1.E.f(string);
                I(string, true);
                c(new F0.e(this, c0112v2, string, 4, false));
                parcel2.writeNoException();
                return true;
            case 6:
                b2 b2Var4 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                w(b2Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                b2 b2Var5 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                Object[] objArr = parcel.readInt() != 0;
                AbstractC0412y.b(parcel);
                H(b2Var5);
                String str = b2Var5.f1138j;
                q1.E.i(str);
                try {
                    List<Z1> list = (List) v12.e().p(new CallableC0125z0(this, 0, str)).get();
                    ArrayList arrayList2 = new ArrayList(list.size());
                    for (Z1 z12 : list) {
                        if (objArr != false || !a2.e0(z12.f1092c)) {
                            arrayList2.add(new Y1(z12));
                        }
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e5) {
                    e = e5;
                    v12.c().h.c(Z.q(str), e, "Failed to get user properties. appId");
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                } catch (ExecutionException e6) {
                    e = e6;
                    v12.c().h.c(Z.q(str), e, "Failed to get user properties. appId");
                    parcel2.writeNoException();
                    parcel2.writeTypedList(arrayList);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                C0112v c0112v3 = (C0112v) AbstractC0412y.a(parcel, C0112v.CREATOR);
                String string2 = parcel.readString();
                AbstractC0412y.b(parcel);
                byte[] bArrD = d(c0112v3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrD);
                return true;
            case 10:
                long j5 = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                AbstractC0412y.b(parcel);
                F(j5, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                b2 b2Var6 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                String strL = l(b2Var6);
                parcel2.writeNoException();
                parcel2.writeString(strL);
                return true;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                C0062e c0062e = (C0062e) AbstractC0412y.a(parcel, C0062e.CREATOR);
                b2 b2Var7 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                C(c0062e, b2Var7);
                parcel2.writeNoException();
                return true;
            case o1.f.ERROR /* 13 */:
                C0062e c0062e2 = (C0062e) AbstractC0412y.a(parcel, C0062e.CREATOR);
                AbstractC0412y.b(parcel);
                q1.E.i(c0062e2);
                q1.E.i(c0062e2.f1193l);
                q1.E.f(c0062e2.f1191j);
                I(c0062e2.f1191j, true);
                c(new RunnableC0999a(9, this, new C0062e(c0062e2), false));
                parcel2.writeNoException();
                return true;
            case o1.f.INTERRUPTED /* 14 */:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                ClassLoader classLoader = AbstractC0412y.f5138a;
                z4 = parcel.readInt() != 0;
                b2 b2Var8 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                List listY = y(string6, string7, z4, b2Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listY);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                ClassLoader classLoader2 = AbstractC0412y.f5138a;
                z4 = parcel.readInt() != 0;
                AbstractC0412y.b(parcel);
                List listG = G(string8, string9, string10, z4);
                parcel2.writeNoException();
                parcel2.writeTypedList(listG);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                b2 b2Var9 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                List listH = h(string11, string12, b2Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listH);
                return true;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                AbstractC0412y.b(parcel);
                List listT = t(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listT);
                return true;
            case 18:
                b2 b2Var10 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                k(b2Var10);
                parcel2.writeNoException();
                return true;
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                Bundle bundle = (Bundle) AbstractC0412y.a(parcel, Bundle.CREATOR);
                b2 b2Var11 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                o(b2Var11, bundle);
                parcel2.writeNoException();
                return true;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                b2 b2Var12 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                r(b2Var12);
                parcel2.writeNoException();
                return true;
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                b2 b2Var13 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                C0074i c0074iS = s(b2Var13);
                parcel2.writeNoException();
                if (c0074iS == null) {
                    parcel2.writeInt(0);
                } else {
                    parcel2.writeInt(1);
                    c0074iS.writeToParcel(parcel2, 1);
                }
                return true;
            case 24:
                b2 b2Var14 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                Bundle bundle2 = (Bundle) AbstractC0412y.a(parcel, Bundle.CREATOR);
                AbstractC0412y.b(parcel);
                H(b2Var14);
                String str2 = b2Var14.f1138j;
                q1.E.i(str2);
                if (v12.d0().w(null, H.f816h1)) {
                    try {
                        listEmptyList = (List) v12.e().q(new D0(this, b2Var14, bundle2, 0)).get(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e7) {
                        v12.c().h.c(Z.q(str2), e7, "Failed to get trigger URIs. appId");
                        listEmptyList = Collections.emptyList();
                    }
                } else {
                    try {
                        listEmptyList = (List) v12.e().p(new D0(this, b2Var14, bundle2, 1)).get();
                    } catch (InterruptedException | ExecutionException e8) {
                        v12.c().h.c(Z.q(str2), e8, "Failed to get trigger URIs. appId");
                        listEmptyList = Collections.emptyList();
                    }
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(listEmptyList);
                return true;
            case 25:
                b2 b2Var15 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                e(b2Var15);
                parcel2.writeNoException();
                return true;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                b2 b2Var16 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                E(b2Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                b2 b2Var17 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                AbstractC0412y.b(parcel);
                x(b2Var17);
                parcel2.writeNoException();
                return true;
            case 29:
                b2 b2Var18 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                O1 o12 = (O1) AbstractC0412y.a(parcel, O1.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    m5 = iInterfaceQueryLocalInterface instanceof N ? (N) iInterfaceQueryLocalInterface : new M(strongBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback", 2);
                }
                AbstractC0412y.b(parcel);
                i(b2Var18, o12, m5);
                parcel2.writeNoException();
                return true;
            case 30:
                b2 b2Var19 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                C0059d c0059d = (C0059d) AbstractC0412y.a(parcel, C0059d.CREATOR);
                AbstractC0412y.b(parcel);
                g(b2Var19, c0059d);
                parcel2.writeNoException();
                return true;
            case 31:
                b2 b2Var20 = (b2) AbstractC0412y.a(parcel, b2.CREATOR);
                Bundle bundle3 = (Bundle) AbstractC0412y.a(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    k5 = iInterfaceQueryLocalInterface2 instanceof L ? (L) iInterfaceQueryLocalInterface2 : new K(strongBinder2, "com.google.android.gms.measurement.internal.ITriggerUrisCallback", 2);
                }
                AbstractC0412y.b(parcel);
                D(b2Var20, bundle3, k5);
                parcel2.writeNoException();
                return true;
        }
    }

    public final void b(Runnable runnable) {
        V1 v12 = this.f728c;
        if (v12.e().v()) {
            runnable.run();
        } else {
            v12.e().u(runnable);
        }
    }

    public final void c(Runnable runnable) {
        V1 v12 = this.f728c;
        if (v12.e().v()) {
            runnable.run();
        } else {
            v12.e().t(runnable);
        }
    }

    @Override // J1.J
    public final byte[] d(C0112v c0112v, String str) {
        q1.E.f(str);
        q1.E.i(c0112v);
        I(str, true);
        V1 v12 = this.f728c;
        Z zC = v12.c();
        C0113v0 c0113v0 = v12.n;
        S s4 = c0113v0.f1420o;
        String str2 = c0112v.f1398j;
        zC.f1083o.b(s4.d(str2), "Log and bundle. event");
        v12.f().getClass();
        long jNanoTime = System.nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) v12.e().q(new CallableC0087m0(this, c0112v, str)).get();
            if (bArr == null) {
                v12.c().h.b(Z.q(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            v12.f().getClass();
            v12.c().f1083o.d("Log and bundle processed. event, size, time_ms", c0113v0.f1420o.d(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e5) {
            e = e5;
            Z zC2 = v12.c();
            zC2.h.d("Failed to log and bundle. appId, event, error", Z.q(str), c0113v0.f1420o.d(str2), e);
            return null;
        } catch (ExecutionException e6) {
            e = e6;
            Z zC22 = v12.c();
            zC22.h.d("Failed to log and bundle. appId, event, error", Z.q(str), c0113v0.f1420o.d(str2), e);
            return null;
        }
    }

    @Override // J1.J
    public final void e(b2 b2Var) {
        q1.E.f(b2Var.f1138j);
        q1.E.i(b2Var.f1126D);
        b(new RunnableC0119x0(this, b2Var, 0));
    }

    @Override // J1.J
    public final void g(b2 b2Var, C0059d c0059d) {
        if (this.f728c.d0().w(null, H.f776P0)) {
            H(b2Var);
            c(new F0.e(this, b2Var, c0059d, 1));
        }
    }

    @Override // J1.J
    public final List h(String str, String str2, b2 b2Var) {
        H(b2Var);
        String str3 = b2Var.f1138j;
        q1.E.i(str3);
        V1 v12 = this.f728c;
        try {
            return (List) v12.e().p(new C0(this, str3, str, str2, 2)).get();
        } catch (InterruptedException | ExecutionException e5) {
            v12.c().h.b(e5, "Failed to get conditional user properties");
            return Collections.emptyList();
        }
    }

    @Override // J1.J
    public final void i(b2 b2Var, O1 o12, N n) {
        V1 v12 = this.f728c;
        if (v12.d0().w(null, H.f776P0)) {
            H(b2Var);
            String str = b2Var.f1138j;
            q1.E.i(str);
            v12.e().t(new RunnableC0122y0((Object) this, (Serializable) str, (AbstractC0873a) o12, (Object) n, 0));
            return;
        }
        try {
            n.B(new P1(Collections.emptyList()));
            v12.c().f1084p.a("[sgtm] Client upload is not enabled on the service side.");
        } catch (RemoteException e5) {
            v12.c().f1080k.b(e5, "[sgtm] UploadBatchesCallback failed.");
        }
    }

    @Override // J1.J
    public final void k(b2 b2Var) {
        String str = b2Var.f1138j;
        q1.E.f(str);
        I(str, false);
        c(new RunnableC0119x0(this, b2Var, 5));
    }

    @Override // J1.J
    public final String l(b2 b2Var) {
        H(b2Var);
        V1 v12 = this.f728c;
        try {
            return (String) v12.e().p(new CallableC0125z0(v12, 2, b2Var)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            Z zC = v12.c();
            zC.h.c(Z.q(b2Var.f1138j), e5, "Failed to get app instance id. appId");
            return null;
        }
    }

    @Override // J1.J
    public final void n(b2 b2Var) {
        H(b2Var);
        c(new RunnableC0119x0(this, b2Var, 2));
    }

    @Override // J1.J
    public final void o(b2 b2Var, Bundle bundle) {
        H(b2Var);
        String str = b2Var.f1138j;
        q1.E.i(str);
        c(new RunnableC0122y0(this, bundle, str, b2Var));
    }

    @Override // J1.J
    public final void r(b2 b2Var) {
        q1.E.f(b2Var.f1138j);
        q1.E.i(b2Var.f1126D);
        b(new RunnableC0119x0(this, b2Var, 6));
    }

    @Override // J1.J
    public final C0074i s(b2 b2Var) {
        H(b2Var);
        String str = b2Var.f1138j;
        q1.E.f(str);
        V1 v12 = this.f728c;
        try {
            return (C0074i) v12.e().q(new CallableC0125z0(this, 1, b2Var)).get(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            Z zC = v12.c();
            zC.h.c(Z.q(str), e5, "Failed to get consent. appId");
            return new C0074i(null);
        }
    }

    @Override // J1.J
    public final List t(String str, String str2, String str3) {
        I(str, true);
        V1 v12 = this.f728c;
        try {
            return (List) v12.e().p(new C0(this, str, str2, str3, 3)).get();
        } catch (InterruptedException | ExecutionException e5) {
            v12.c().h.b(e5, "Failed to get conditional user properties as");
            return Collections.emptyList();
        }
    }

    @Override // J1.J
    public final void v(C0112v c0112v, b2 b2Var) {
        q1.E.i(c0112v);
        H(b2Var);
        c(new F0.e(this, c0112v, b2Var, 3, false));
    }

    @Override // J1.J
    public final void w(b2 b2Var) {
        H(b2Var);
        c(new RunnableC0119x0(this, b2Var, 4));
    }

    @Override // J1.J
    public final void x(b2 b2Var) {
        H(b2Var);
        c(new RunnableC0119x0(this, b2Var, 3));
    }

    @Override // J1.J
    public final List y(String str, String str2, boolean z4, b2 b2Var) {
        H(b2Var);
        String str3 = b2Var.f1138j;
        q1.E.i(str3);
        V1 v12 = this.f728c;
        try {
            List<Z1> list = (List) v12.e().p(new C0(this, str3, str, str2, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Z1 z12 : list) {
                if (z4 || !a2.e0(z12.f1092c)) {
                    arrayList.add(new Y1(z12));
                }
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            Z zC = v12.c();
            zC.h.c(Z.q(str3), e, "Failed to query user properties. appId");
            return Collections.emptyList();
        } catch (ExecutionException e6) {
            e = e6;
            Z zC2 = v12.c();
            zC2.h.c(Z.q(str3), e, "Failed to query user properties. appId");
            return Collections.emptyList();
        }
    }

    @Override // J1.J
    public final void z(Y1 y12, b2 b2Var) {
        q1.E.i(y12);
        H(b2Var);
        c(new F0.e(this, y12, b2Var, 5, false));
    }
}
