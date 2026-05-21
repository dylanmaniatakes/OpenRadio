package androidx.recyclerview.widget;

/* renamed from: androidx.recyclerview.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0254a {

    /* renamed from: a, reason: collision with root package name */
    public int f4194a;

    /* renamed from: b, reason: collision with root package name */
    public int f4195b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4196c;

    /* renamed from: d, reason: collision with root package name */
    public int f4197d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0254a)) {
            return false;
        }
        C0254a c0254a = (C0254a) obj;
        int i5 = this.f4194a;
        if (i5 != c0254a.f4194a) {
            return false;
        }
        if (i5 == 8 && Math.abs(this.f4197d - this.f4195b) == 1 && this.f4197d == c0254a.f4195b && this.f4195b == c0254a.f4197d) {
            return true;
        }
        if (this.f4197d != c0254a.f4197d || this.f4195b != c0254a.f4195b) {
            return false;
        }
        Object obj2 = this.f4196c;
        if (obj2 != null) {
            if (!obj2.equals(c0254a.f4196c)) {
                return false;
            }
        } else if (c0254a.f4196c != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f4194a * 31) + this.f4195b) * 31) + this.f4197d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i5 = this.f4194a;
        sb.append(i5 != 1 ? i5 != 2 ? i5 != 4 ? i5 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.f4195b);
        sb.append("c:");
        sb.append(this.f4197d);
        sb.append(",p:");
        sb.append(this.f4196c);
        sb.append("]");
        return sb.toString();
    }
}
