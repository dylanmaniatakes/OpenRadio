package B0;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public final class q extends View.BaseSavedState {
    public static final Parcelable.Creator<q> CREATOR = new p(0);

    /* renamed from: j, reason: collision with root package name */
    public int f114j;

    /* renamed from: k, reason: collision with root package name */
    public int f115k;

    /* renamed from: l, reason: collision with root package name */
    public Parcelable f116l;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f114j);
        parcel.writeInt(this.f115k);
        parcel.writeParcelable(this.f116l, i5);
    }
}
