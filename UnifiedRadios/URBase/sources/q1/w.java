package q1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import n1.C0785b;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class w extends AbstractC0873a {
    public static final Parcelable.Creator<w> CREATOR = new x(0);

    /* renamed from: j, reason: collision with root package name */
    public final int f9421j;

    /* renamed from: k, reason: collision with root package name */
    public final IBinder f9422k;

    /* renamed from: l, reason: collision with root package name */
    public final C0785b f9423l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9424m;
    public final boolean n;

    public w(int i5, IBinder iBinder, C0785b c0785b, boolean z4, boolean z5) {
        this.f9421j = i5;
        this.f9422k = iBinder;
        this.f9423l = c0785b;
        this.f9424m = z4;
        this.n = z5;
    }

    public final boolean equals(Object obj) {
        Object s4;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (this.f9423l.equals(wVar.f9423l)) {
            Object s5 = null;
            IBinder iBinder = this.f9422k;
            if (iBinder == null) {
                s4 = null;
            } else {
                int i5 = AbstractBinderC0850a.f9344d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                s4 = iInterfaceQueryLocalInterface instanceof InterfaceC0859j ? (InterfaceC0859j) iInterfaceQueryLocalInterface : new S(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = wVar.f9422k;
            if (iBinder2 != null) {
                int i6 = AbstractBinderC0850a.f9344d;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                s5 = iInterfaceQueryLocalInterface2 instanceof InterfaceC0859j ? (InterfaceC0859j) iInterfaceQueryLocalInterface2 : new S(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (E.l(s4, s5)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f9421j);
        A2.b.B(parcel, 2, this.f9422k);
        A2.b.D(parcel, 3, this.f9423l, i5);
        A2.b.M(parcel, 4, 4);
        parcel.writeInt(this.f9424m ? 1 : 0);
        A2.b.M(parcel, 5, 4);
        parcel.writeInt(this.n ? 1 : 0);
        A2.b.K(I, parcel);
    }
}
