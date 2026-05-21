package g2;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* renamed from: g2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0542f extends SparseArray implements Parcelable {
    public static final Parcelable.Creator<C0542f> CREATOR = new B0.p(7);

    public C0542f(Parcel parcel, ClassLoader classLoader) {
        int i5 = parcel.readInt();
        int[] iArr = new int[i5];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        for (int i6 = 0; i6 < i5; i6++) {
            put(iArr[i6], parcelableArray[i6]);
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int size = size();
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = keyAt(i6);
            parcelableArr[i6] = (Parcelable) valueAt(i6);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i5);
    }
}
