package p2;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b extends View.BaseSavedState {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.c(25);

    /* renamed from: j, reason: collision with root package name */
    public float f9166j;

    /* renamed from: k, reason: collision with root package name */
    public float f9167k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f9168l;

    /* renamed from: m, reason: collision with root package name */
    public float f9169m;
    public boolean n;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeFloat(this.f9166j);
        parcel.writeFloat(this.f9167k);
        parcel.writeList(this.f9168l);
        parcel.writeFloat(this.f9169m);
        parcel.writeBooleanArray(new boolean[]{this.n});
    }
}
