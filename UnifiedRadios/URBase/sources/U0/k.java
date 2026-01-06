package u0;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import q1.x;

/* loaded from: classes.dex */
public final class k extends View.BaseSavedState {
    public static final Parcelable.Creator<k> CREATOR = new x(5);

    /* renamed from: j, reason: collision with root package name */
    public final boolean f9917j;

    public k(Parcelable parcelable, boolean z4) {
        super(parcelable);
        this.f9917j = z4;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeByte(this.f9917j ? (byte) 1 : (byte) 0);
    }

    public k(Parcel parcel) {
        super(parcel);
        this.f9917j = parcel.readByte() != 0;
    }
}
