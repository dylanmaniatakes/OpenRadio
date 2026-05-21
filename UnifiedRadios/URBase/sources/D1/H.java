package D1;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.location.LocationRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import q1.C0855f;
import r1.AbstractC0873a;
import u1.AbstractC0909d;

/* loaded from: classes.dex */
public final class H extends AbstractC0873a {
    public static final Parcelable.Creator<H> CREATOR = new G(1);

    /* renamed from: j, reason: collision with root package name */
    public final LocationRequest f346j;

    public H(LocationRequest locationRequest, ArrayList arrayList, boolean z4, boolean z5, boolean z6, boolean z7, long j5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0855f c0855f = (C0855f) it.next();
                    AbstractC0909d.a(workSource, c0855f.f9366j, c0855f.f9367k);
                }
            }
            builder.zzc(workSource);
        }
        if (z4) {
            builder.setGranularity(1);
        }
        if (z5) {
            builder.zza(2);
        }
        if (z6) {
            builder.zzb(true);
        }
        if (z7) {
            builder.setWaitForAccurateLocation(true);
        }
        if (j5 != Long.MAX_VALUE) {
            builder.setMaxUpdateAgeMillis(j5);
        }
        this.f346j = builder.build();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof H) {
            return q1.E.l(this.f346j, ((H) obj).f346j);
        }
        return false;
    }

    public final int hashCode() {
        return this.f346j.hashCode();
    }

    public final String toString() {
        return this.f346j.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.D(parcel, 1, this.f346j, i5);
        A2.b.K(I, parcel);
    }
}
