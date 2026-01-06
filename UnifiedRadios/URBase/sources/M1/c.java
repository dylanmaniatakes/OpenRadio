package m1;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class c implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8519a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f8519a) {
            case 0:
                int iH = y1.f.H(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < iH) {
                    int i5 = parcel.readInt();
                    if (((char) i5) != 1) {
                        y1.f.G(i5, parcel);
                    } else {
                        intent = (Intent) y1.f.i(parcel, i5, Intent.CREATOR);
                    }
                }
                y1.f.n(iH, parcel);
                return new C0760a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i5) {
        switch (this.f8519a) {
            case 0:
                return new C0760a[i5];
            default:
                return new g[i5];
        }
    }
}
