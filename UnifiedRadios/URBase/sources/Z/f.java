package z;

import B0.p;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* loaded from: classes.dex */
public final class f extends V.b {
    public static final Parcelable.Creator<f> CREATOR = new p(14);

    /* renamed from: l, reason: collision with root package name */
    public SparseArray f10543l;

    public f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i5 = parcel.readInt();
        int[] iArr = new int[i5];
        parcel.readIntArray(iArr);
        Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
        this.f10543l = new SparseArray(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            this.f10543l.append(iArr[i6], parcelableArray[i6]);
        }
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        SparseArray sparseArray = this.f10543l;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = this.f10543l.keyAt(i6);
            parcelableArr[i6] = (Parcelable) this.f10543l.valueAt(i6);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i5);
    }
}
