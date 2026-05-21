package L1;

import D1.G;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.List;
import o1.o;
import r1.AbstractC0873a;

/* loaded from: classes.dex */
public final class f extends AbstractC0873a implements o {
    public static final Parcelable.Creator<f> CREATOR = new G(21);

    /* renamed from: j, reason: collision with root package name */
    public final List f1606j;

    /* renamed from: k, reason: collision with root package name */
    public final String f1607k;

    public f(String str, ArrayList arrayList) {
        this.f1606j = arrayList;
        this.f1607k = str;
    }

    @Override // o1.o
    public final Status getStatus() {
        return this.f1607k != null ? Status.n : Status.f4638p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.F(parcel, 1, this.f1606j);
        A2.b.E(parcel, 2, this.f1607k);
        A2.b.K(I, parcel);
    }
}
