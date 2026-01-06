package S;

import D1.G;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
public final class l extends View.BaseSavedState {
    public static final Parcelable.Creator<l> CREATOR = new G(24);

    /* renamed from: j, reason: collision with root package name */
    public int f2351j;

    public final String toString() {
        StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" scrollPosition=");
        return com.unified.ur1.SatelliteTracker.h.d(sb, this.f2351j, "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f2351j);
    }
}
