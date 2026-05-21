package V1;

import B0.p;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes.dex */
public final class c extends V.b {
    public static final Parcelable.Creator<c> CREATOR = new p(2);

    /* renamed from: l, reason: collision with root package name */
    public final int f2520l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2521m;
    public final boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f2522o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f2523p;

    public c(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2520l = parcel.readInt();
        this.f2521m = parcel.readInt();
        this.n = parcel.readInt() == 1;
        this.f2522o = parcel.readInt() == 1;
        this.f2523p = parcel.readInt() == 1;
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        parcel.writeInt(this.f2520l);
        parcel.writeInt(this.f2521m);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeInt(this.f2522o ? 1 : 0);
        parcel.writeInt(this.f2523p ? 1 : 0);
    }

    public c(AbsSavedState absSavedState, BottomSheetBehavior bottomSheetBehavior) {
        super(absSavedState);
        this.f2520l = bottomSheetBehavior.f5191L;
        this.f2521m = bottomSheetBehavior.f5214e;
        this.n = bottomSheetBehavior.f5208b;
        this.f2522o = bottomSheetBehavior.I;
        this.f2523p = bottomSheetBehavior.f5189J;
    }
}
