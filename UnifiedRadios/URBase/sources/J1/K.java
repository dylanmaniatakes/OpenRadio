package J1;

import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public final class K extends A1.a implements L {
    @Override // J1.L
    public final void u(List list) {
        Parcel parcelB = b();
        parcelB.writeTypedList(list);
        I(parcelB);
    }
}
