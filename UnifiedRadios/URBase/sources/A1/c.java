package A1;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10a = 0;

    static {
        c.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void b(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(h.a(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }
}
