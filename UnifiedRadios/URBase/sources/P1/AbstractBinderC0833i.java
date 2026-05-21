package p1;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* renamed from: p1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0833i extends A1.b implements j {
    public AbstractBinderC0833i() {
        super("com.google.android.gms.common.api.internal.IStatusCallback", 0);
    }

    @Override // A1.b
    public final boolean H(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 != 1) {
            return false;
        }
        Status status = (Status) A1.c.a(parcel, Status.CREATOR);
        A1.c.b(parcel);
        p(status);
        return true;
    }
}
