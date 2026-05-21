package C0;

import android.net.Uri;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f140a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f141b;

    public c(Uri uri, boolean z4) {
        this.f140a = uri;
        this.f141b = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        F3.i.d(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
        c cVar = (c) obj;
        return F3.i.a(this.f140a, cVar.f140a) && this.f141b == cVar.f141b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f141b) + (this.f140a.hashCode() * 31);
    }
}
