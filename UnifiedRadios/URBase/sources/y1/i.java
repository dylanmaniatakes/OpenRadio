package y1;

import android.os.Parcel;
import x1.BinderC0963d;
import x1.InterfaceC0961b;

/* loaded from: classes.dex */
public final class i extends A1.a {
    public final InterfaceC0961b J(BinderC0963d binderC0963d, String str, int i5) {
        Parcel parcelB = b();
        C1.a.c(parcelB, binderC0963d);
        parcelB.writeString(str);
        parcelB.writeInt(i5);
        return com.unified.ur1.SatelliteTracker.h.k(a(2, parcelB));
    }

    public final InterfaceC0961b K(BinderC0963d binderC0963d, String str, int i5, BinderC0963d binderC0963d2) {
        Parcel parcelB = b();
        C1.a.c(parcelB, binderC0963d);
        parcelB.writeString(str);
        parcelB.writeInt(i5);
        C1.a.c(parcelB, binderC0963d2);
        return com.unified.ur1.SatelliteTracker.h.k(a(8, parcelB));
    }

    public final InterfaceC0961b L(BinderC0963d binderC0963d, String str, int i5) {
        Parcel parcelB = b();
        C1.a.c(parcelB, binderC0963d);
        parcelB.writeString(str);
        parcelB.writeInt(i5);
        return com.unified.ur1.SatelliteTracker.h.k(a(4, parcelB));
    }

    public final InterfaceC0961b M(BinderC0963d binderC0963d, String str, boolean z4, long j5) {
        Parcel parcelB = b();
        C1.a.c(parcelB, binderC0963d);
        parcelB.writeString(str);
        parcelB.writeInt(z4 ? 1 : 0);
        parcelB.writeLong(j5);
        return com.unified.ur1.SatelliteTracker.h.k(a(7, parcelB));
    }
}
