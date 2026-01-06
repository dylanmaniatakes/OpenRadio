package Y1;

import D1.G;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public final class b extends View.BaseSavedState {
    public static final Parcelable.Creator<b> CREATOR = new G(26);

    /* renamed from: j, reason: collision with root package name */
    public int f2939j;

    public final String toString() {
        StringBuilder sb = new StringBuilder("MaterialCheckBox.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" CheckedState=");
        int i5 = this.f2939j;
        return h.e(sb, i5 != 1 ? i5 != 2 ? "unchecked" : "indeterminate" : "checked", "}");
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeValue(Integer.valueOf(this.f2939j));
    }
}
