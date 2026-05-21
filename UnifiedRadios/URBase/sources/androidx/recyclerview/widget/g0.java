package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class g0 extends V.b {
    public static final Parcelable.Creator<g0> CREATOR = new B0.p(5);

    /* renamed from: l, reason: collision with root package name */
    public Parcelable f4239l;

    public g0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4239l = parcel.readParcelable(classLoader == null ? X.class.getClassLoader() : classLoader);
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeParcelable(this.f4239l, 0);
    }
}
