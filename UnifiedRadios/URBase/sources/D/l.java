package D;

import android.content.res.Resources;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f217a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f218b;

    public l(Resources resources, Resources.Theme theme) {
        this.f217a = resources;
        this.f218b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f217a.equals(lVar.f217a) && N.b.a(this.f218b, lVar.f218b);
    }

    public final int hashCode() {
        return N.b.b(this.f217a, this.f218b);
    }
}
