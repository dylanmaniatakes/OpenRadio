package J1;

import android.text.TextUtils;
import android.util.Log;
import w1.C0931b;

/* renamed from: J1.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0078j0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1269a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final C0113v0 f1270b;

    public C0078j0(C0113v0 c0113v0) {
        this.f1270b = c0113v0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        switch (this.f1269a) {
            case 0:
                C0113v0 c0113v0 = this.f1270b;
                boolean z4 = false;
                try {
                    B1 b1A = C0931b.a(c0113v0.f1411c);
                    if (b1A == null) {
                        Z z5 = c0113v0.f1417k;
                        C0113v0.k(z5);
                        z5.f1084p.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                        c0113v0 = c0113v0;
                    } else {
                        int i5 = b1A.b(128, "com.android.vending").versionCode;
                        c0113v0 = i5;
                        if (i5 >= 80837300) {
                            z4 = true;
                            c0113v0 = i5;
                        }
                    }
                } catch (Exception e5) {
                    Z z6 = c0113v0.f1417k;
                    C0113v0.k(z6);
                    z6.f1084p.b(e5, "Failed to retrieve Play Store version for Install Referrer");
                }
                return z4;
            default:
                C0113v0 c0113v02 = this.f1270b;
                if (TextUtils.isEmpty(c0113v02.f1412d)) {
                    Z z7 = c0113v02.f1417k;
                    C0113v0.k(z7);
                    if (Log.isLoggable(z7.t(), 3)) {
                        return true;
                    }
                }
                return false;
        }
    }

    public C0078j0(V1 v12) {
        this.f1270b = v12.n;
    }
}
