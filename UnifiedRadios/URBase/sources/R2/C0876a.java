package r2;

import B0.p;
import V.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import q.k;

/* renamed from: r2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0876a extends b {
    public static final Parcelable.Creator<C0876a> CREATOR = new p(12);

    /* renamed from: l, reason: collision with root package name */
    public final k f9515l;

    public C0876a(Parcelable parcelable) {
        super(parcelable);
        this.f9515l = new k();
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f9515l + "}";
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        k kVar = this.f9515l;
        int i6 = kVar.f9278l;
        parcel.writeInt(i6);
        String[] strArr = new String[i6];
        Bundle[] bundleArr = new Bundle[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            strArr[i7] = (String) kVar.h(i7);
            bundleArr[i7] = (Bundle) kVar.j(i7);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public C0876a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i5 = parcel.readInt();
        String[] strArr = new String[i5];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i5];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f9515l = new k(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            this.f9515l.put(strArr[i6], bundleArr[i6]);
        }
    }
}
