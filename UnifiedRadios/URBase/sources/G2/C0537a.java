package g2;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: g2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0537a extends V.b {
    public static final Parcelable.Creator<C0537a> CREATOR = new B0.p(6);

    /* renamed from: l, reason: collision with root package name */
    public boolean f6867l;

    public C0537a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6867l = parcel.readInt() == 1;
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f6867l ? 1 : 0);
    }
}
