package k;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public final class O extends View.BaseSavedState {
    public static final Parcelable.Creator<O> CREATOR = new android.support.v4.media.c(16);

    /* renamed from: j, reason: collision with root package name */
    public boolean f7678j;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeByte(this.f7678j ? (byte) 1 : (byte) 0);
    }
}
