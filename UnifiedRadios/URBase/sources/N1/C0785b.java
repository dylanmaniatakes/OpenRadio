package n1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import g0.AbstractC0535a;
import java.util.Arrays;
import q1.E;
import r1.AbstractC0873a;

/* renamed from: n1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0785b extends AbstractC0873a {

    /* renamed from: j, reason: collision with root package name */
    public final int f8727j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8728k;

    /* renamed from: l, reason: collision with root package name */
    public final PendingIntent f8729l;

    /* renamed from: m, reason: collision with root package name */
    public final String f8730m;
    public static final C0785b n = new C0785b(0);
    public static final Parcelable.Creator<C0785b> CREATOR = new android.support.v4.media.c(20);

    public C0785b(int i5, int i6, PendingIntent pendingIntent, String str) {
        this.f8727j = i5;
        this.f8728k = i6;
        this.f8729l = pendingIntent;
        this.f8730m = str;
    }

    public static String a(int i5) {
        if (i5 == 99) {
            return "UNFINISHED";
        }
        if (i5 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i5) {
            case o1.f.SUCCESS_CACHE /* -1 */:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i5) {
                    case o1.f.ERROR /* 13 */:
                        return "CANCELED";
                    case o1.f.INTERRUPTED /* 14 */:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case o1.f.API_NOT_CONNECTED /* 17 */:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case o1.f.REMOTE_EXCEPTION /* 19 */:
                        return "SERVICE_MISSING_PERMISSION";
                    case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                        return "RESTRICTED_PROFILE";
                    case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        return AbstractC0535a.j("UNKNOWN_ERROR_CODE(", i5, ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0785b)) {
            return false;
        }
        C0785b c0785b = (C0785b) obj;
        return this.f8728k == c0785b.f8728k && E.l(this.f8729l, c0785b.f8729l) && E.l(this.f8730m, c0785b.f8730m);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f8728k), this.f8729l, this.f8730m});
    }

    public final String toString() {
        L0.c cVar = new L0.c(this);
        cVar.b(a(this.f8728k), "statusCode");
        cVar.b(this.f8729l, "resolution");
        cVar.b(this.f8730m, "message");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(this.f8727j);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(this.f8728k);
        A2.b.D(parcel, 3, this.f8729l, i5);
        A2.b.E(parcel, 4, this.f8730m);
        A2.b.K(I, parcel);
    }

    public C0785b(int i5) {
        this(1, i5, null, null);
    }

    public C0785b(int i5, PendingIntent pendingIntent) {
        this(1, i5, pendingIntent, null);
    }
}
