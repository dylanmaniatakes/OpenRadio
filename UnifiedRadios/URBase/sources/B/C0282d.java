package b;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: b.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0282d implements Parcelable {
    public static final Parcelable.Creator<C0282d> CREATOR = new android.support.v4.media.c(10);

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0280b f4510j;

    public void a(int i5, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        synchronized (this) {
            try {
                if (this.f4510j == null) {
                    this.f4510j = new BinderC0281c(this);
                }
                parcel.writeStrongBinder(this.f4510j.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
