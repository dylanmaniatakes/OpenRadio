package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import q1.x;
import y0.C0977b;
import y0.InterfaceC0978c;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new x(6);

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0978c f4440j;

    public ParcelImpl(Parcel parcel) {
        this.f4440j = new C0977b(parcel).h();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        new C0977b(parcel).l(this.f4440j);
    }
}
