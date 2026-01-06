package q1;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class v extends AbstractC0873a {
    public static final Parcelable.Creator<v> CREATOR = new android.support.v4.media.c(29);

    /* renamed from: j, reason: collision with root package name */
    public final int f9417j;

    /* renamed from: k, reason: collision with root package name */
    public final Account f9418k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9419l;

    /* renamed from: m, reason: collision with root package name */
    public final GoogleSignInAccount f9420m;

    public v(int i5, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.f9417j = i5;
        this.f9418k = account;
        this.f9419l = i6;
        this.f9420m = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f9417j);
        A2.b.D(parcel, 2, this.f9418k, i5);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(this.f9419l);
        A2.b.D(parcel, 4, this.f9420m, i5);
        A2.b.K(I, parcel);
    }
}
