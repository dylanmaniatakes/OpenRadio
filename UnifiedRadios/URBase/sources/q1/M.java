package q1;

import android.net.Uri;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class M {

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f9324d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f9325a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9326b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9327c;

    public M(String str, boolean z4) {
        E.f(str);
        this.f9325a = str;
        E.f("com.google.android.gms");
        this.f9326b = "com.google.android.gms";
        this.f9327c = z4;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.Intent a(android.content.Context r6) throws android.os.RemoteException, q1.F {
        /*
            r5 = this;
            java.lang.String r0 = "ConnectionStatusConfig"
            r1 = 0
            java.lang.String r2 = r5.f9325a
            if (r2 == 0) goto La6
            boolean r3 = r5.f9327c
            if (r3 == 0) goto L98
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            java.lang.String r4 = "serviceActionBundleKey"
            r3.putString(r4, r2)
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            android.net.Uri r4 = q1.M.f9324d     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            android.content.ContentProviderClient r6 = r6.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            if (r6 == 0) goto L38
            java.lang.String r4 = "serviceIntentCall"
            android.os.Bundle r3 = r6.call(r4, r1, r3)     // Catch: java.lang.Throwable -> L2f
            r6.release()     // Catch: java.lang.IllegalArgumentException -> L2b android.os.RemoteException -> L2d
            goto L4e
        L2b:
            r6 = move-exception
            goto L41
        L2d:
            r6 = move-exception
            goto L41
        L2f:
            r3 = move-exception
            r6.release()     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            throw r3     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
        L34:
            r6 = move-exception
            goto L40
        L36:
            r6 = move-exception
            goto L40
        L38:
            android.os.RemoteException r6 = new android.os.RemoteException     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            java.lang.String r3 = "Failed to acquire ContentProviderClient"
            r6.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
            throw r6     // Catch: java.lang.IllegalArgumentException -> L34 android.os.RemoteException -> L36
        L40:
            r3 = r1
        L41:
            java.lang.String r4 = "Dynamic intent resolution failed: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = r4.concat(r6)
            android.util.Log.w(r0, r6)
        L4e:
            if (r3 == 0) goto L89
            java.lang.String r6 = "serviceResponseIntentKey"
            android.os.Parcelable r6 = r3.getParcelable(r6)
            r1 = r6
            android.content.Intent r1 = (android.content.Intent) r1
            if (r1 != 0) goto L89
            java.lang.String r6 = "serviceMissingResolutionIntentKey"
            android.os.Parcelable r6 = r3.getParcelable(r6)
            android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            if (r6 != 0) goto L66
            goto L89
        L66:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Dynamic lookup for intent failed for action "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = " but has possible resolution"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            q1.F r0 = new q1.F
            n1.b r1 = new n1.b
            r2 = 25
            r1.<init>(r2, r6)
            r0.<init>(r1)
            throw r0
        L89:
            if (r1 != 0) goto L98
            java.lang.String r6 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Dynamic lookup for intent failed for action: "
            java.lang.String r6 = r3.concat(r6)
            android.util.Log.w(r0, r6)
        L98:
            if (r1 != 0) goto Laf
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r2)
            java.lang.String r0 = r5.f9326b
            android.content.Intent r6 = r6.setPackage(r0)
            return r6
        La6:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.Intent r1 = r6.setComponent(r1)
        Laf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.M.a(android.content.Context):android.content.Intent");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m5 = (M) obj;
        return E.l(this.f9325a, m5.f9325a) && E.l(this.f9326b, m5.f9326b) && E.l(null, null) && this.f9327c == m5.f9327c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9325a, this.f9326b, null, 4225, Boolean.valueOf(this.f9327c)});
    }

    public final String toString() {
        String str = this.f9325a;
        if (str != null) {
            return str;
        }
        E.i(null);
        throw null;
    }
}
