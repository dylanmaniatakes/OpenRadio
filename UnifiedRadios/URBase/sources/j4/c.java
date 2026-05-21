package j4;

import Z3.i;
import android.os.StatFs;
import java.io.File;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f7624a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7625b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7626c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7627d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7628e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7629f;

    public c(String str, boolean z4, boolean z5, int i5) {
        this.f7628e = 0L;
        this.f7624a = str;
        this.f7625b = z4;
        this.f7627d = i5;
        this.f7628e = new StatFs(str).getAvailableBytes();
        if (!z5) {
            this.f7626c = !i.h(new File(str));
        }
        StringBuilder sb = new StringBuilder();
        if (z4) {
            sb.append("Internal SD card");
        } else if (i5 > 1) {
            sb.append("SD card ");
            sb.append(i5);
        } else {
            sb.append("SD card");
        }
        if (z5) {
            sb.append(" (Read only)");
        }
        this.f7629f = sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f7625b != cVar.f7625b || this.f7626c != cVar.f7626c || this.f7627d != cVar.f7627d || this.f7628e != cVar.f7628e) {
            return false;
        }
        String str = cVar.f7624a;
        String str2 = this.f7624a;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        String str3 = cVar.f7629f;
        String str4 = this.f7629f;
        return str4 != null ? str4.equals(str3) : str3 == null;
    }

    public final int hashCode() {
        String str = this.f7624a;
        int iHashCode = (((((((str != null ? str.hashCode() : 0) * 31) + (this.f7625b ? 1 : 0)) * 31) + (this.f7626c ? 1 : 0)) * 31) + this.f7627d) * 31;
        long j5 = this.f7628e;
        int i5 = (iHashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        String str2 = this.f7629f;
        return i5 + (str2 != null ? str2.hashCode() : 0);
    }
}
