package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new android.support.v4.media.c(2);

    /* renamed from: j, reason: collision with root package name */
    public final IntentSender f3271j;

    /* renamed from: k, reason: collision with root package name */
    public final Intent f3272k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3273l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3274m;

    public i(IntentSender intentSender, Intent intent, int i5, int i6) {
        F3.i.f(intentSender, "intentSender");
        this.f3271j = intentSender;
        this.f3272k = intent;
        this.f3273l = i5;
        this.f3274m = i6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        F3.i.f(parcel, "dest");
        parcel.writeParcelable(this.f3271j, i5);
        parcel.writeParcelable(this.f3272k, i5);
        parcel.writeInt(this.f3273l);
        parcel.writeInt(this.f3274m);
    }
}
