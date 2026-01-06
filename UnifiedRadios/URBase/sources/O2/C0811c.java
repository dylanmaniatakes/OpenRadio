package o2;

import B0.p;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: o2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0811c extends V.b {
    public static final Parcelable.Creator<C0811c> CREATOR = new p(11);

    /* renamed from: l, reason: collision with root package name */
    public final int f8912l;

    public C0811c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f8912l = parcel.readInt();
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f8912l);
    }

    public C0811c(AbsSavedState absSavedState, SideSheetBehavior sideSheetBehavior) {
        super(absSavedState);
        this.f8912l = sideSheetBehavior.h;
    }
}
