package s2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class w extends V.b {
    public static final Parcelable.Creator<w> CREATOR = new B0.p(13);

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f9683l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9684m;

    public w(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f9683l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f9684m = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f9683l) + "}";
    }

    @Override // V.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        super.writeToParcel(parcel, i5);
        TextUtils.writeToParcel(this.f9683l, parcel, i5);
        parcel.writeInt(this.f9684m ? 1 : 0);
    }
}
