package J1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.AbstractC0412y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class I extends A1.a implements J {
    public I(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService", 2);
    }

    @Override // J1.J
    public final void C(C0062e c0062e, b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, c0062e);
        AbstractC0412y.c(parcelB, b2Var);
        H(12, parcelB);
    }

    @Override // J1.J
    public final void D(b2 b2Var, Bundle bundle, L l5) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        AbstractC0412y.c(parcelB, bundle);
        AbstractC0412y.d(parcelB, l5);
        H(31, parcelB);
    }

    @Override // J1.J
    public final void E(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(26, parcelB);
    }

    @Override // J1.J
    public final void F(long j5, String str, String str2, String str3) {
        Parcel parcelB = b();
        parcelB.writeLong(j5);
        parcelB.writeString(str);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        H(10, parcelB);
    }

    @Override // J1.J
    public final List G(String str, String str2, String str3, boolean z4) {
        Parcel parcelB = b();
        parcelB.writeString(null);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        ClassLoader classLoader = AbstractC0412y.f5138a;
        parcelB.writeInt(z4 ? 1 : 0);
        Parcel parcelC = c(15, parcelB);
        ArrayList arrayListCreateTypedArrayList = parcelC.createTypedArrayList(Y1.CREATOR);
        parcelC.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // J1.J
    public final byte[] d(C0112v c0112v, String str) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, c0112v);
        parcelB.writeString(str);
        Parcel parcelC = c(9, parcelB);
        byte[] bArrCreateByteArray = parcelC.createByteArray();
        parcelC.recycle();
        return bArrCreateByteArray;
    }

    @Override // J1.J
    public final void e(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(25, parcelB);
    }

    @Override // J1.J
    public final void g(b2 b2Var, C0059d c0059d) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        AbstractC0412y.c(parcelB, c0059d);
        H(30, parcelB);
    }

    @Override // J1.J
    public final List h(String str, String str2, b2 b2Var) {
        Parcel parcelB = b();
        parcelB.writeString(str);
        parcelB.writeString(str2);
        AbstractC0412y.c(parcelB, b2Var);
        Parcel parcelC = c(16, parcelB);
        ArrayList arrayListCreateTypedArrayList = parcelC.createTypedArrayList(C0062e.CREATOR);
        parcelC.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // J1.J
    public final void i(b2 b2Var, O1 o12, N n) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        AbstractC0412y.c(parcelB, o12);
        AbstractC0412y.d(parcelB, n);
        H(29, parcelB);
    }

    @Override // J1.J
    public final void k(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(18, parcelB);
    }

    @Override // J1.J
    public final String l(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        Parcel parcelC = c(11, parcelB);
        String string = parcelC.readString();
        parcelC.recycle();
        return string;
    }

    @Override // J1.J
    public final void n(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(4, parcelB);
    }

    @Override // J1.J
    public final void o(b2 b2Var, Bundle bundle) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, bundle);
        AbstractC0412y.c(parcelB, b2Var);
        H(19, parcelB);
    }

    @Override // J1.J
    public final void r(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(20, parcelB);
    }

    @Override // J1.J
    public final C0074i s(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        Parcel parcelC = c(21, parcelB);
        C0074i c0074i = (C0074i) AbstractC0412y.a(parcelC, C0074i.CREATOR);
        parcelC.recycle();
        return c0074i;
    }

    @Override // J1.J
    public final List t(String str, String str2, String str3) {
        Parcel parcelB = b();
        parcelB.writeString(null);
        parcelB.writeString(str2);
        parcelB.writeString(str3);
        Parcel parcelC = c(17, parcelB);
        ArrayList arrayListCreateTypedArrayList = parcelC.createTypedArrayList(C0062e.CREATOR);
        parcelC.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // J1.J
    public final void v(C0112v c0112v, b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, c0112v);
        AbstractC0412y.c(parcelB, b2Var);
        H(1, parcelB);
    }

    @Override // J1.J
    public final void w(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(6, parcelB);
    }

    @Override // J1.J
    public final void x(b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, b2Var);
        H(27, parcelB);
    }

    @Override // J1.J
    public final List y(String str, String str2, boolean z4, b2 b2Var) {
        Parcel parcelB = b();
        parcelB.writeString(str);
        parcelB.writeString(str2);
        ClassLoader classLoader = AbstractC0412y.f5138a;
        parcelB.writeInt(z4 ? 1 : 0);
        AbstractC0412y.c(parcelB, b2Var);
        Parcel parcelC = c(14, parcelB);
        ArrayList arrayListCreateTypedArrayList = parcelC.createTypedArrayList(Y1.CREATOR);
        parcelC.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // J1.J
    public final void z(Y1 y12, b2 b2Var) {
        Parcel parcelB = b();
        AbstractC0412y.c(parcelB, y12);
        AbstractC0412y.c(parcelB, b2Var);
        H(2, parcelB);
    }
}
