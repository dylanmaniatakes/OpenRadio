package k;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class d1 extends V.b {
    public static final Parcelable.Creator<d1> CREATOR = new B0.p(10);

    /* renamed from: l, reason: collision with root package name */
    public int f7760l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7761m;

    public d1(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7760l = parcel.readInt();
        this.f7761m = parcel.readInt() != 0;
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f7760l);
        parcel.writeInt(this.f7761m ? 1 : 0);
    }
}
