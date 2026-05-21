package E;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f418e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f419a;

    /* renamed from: b, reason: collision with root package name */
    public final int f420b;

    /* renamed from: c, reason: collision with root package name */
    public final int f421c;

    /* renamed from: d, reason: collision with root package name */
    public final int f422d;

    public c(int i5, int i6, int i7, int i8) {
        this.f419a = i5;
        this.f420b = i6;
        this.f421c = i7;
        this.f422d = i8;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f419a, cVar2.f419a), Math.max(cVar.f420b, cVar2.f420b), Math.max(cVar.f421c, cVar2.f421c), Math.max(cVar.f422d, cVar2.f422d));
    }

    public static c b(int i5, int i6, int i7, int i8) {
        return (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) ? f418e : new c(i5, i6, i7, i8);
    }

    public static c c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return b.a(this.f419a, this.f420b, this.f421c, this.f422d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f422d == cVar.f422d && this.f419a == cVar.f419a && this.f421c == cVar.f421c && this.f420b == cVar.f420b;
    }

    public final int hashCode() {
        return (((((this.f419a * 31) + this.f420b) * 31) + this.f421c) * 31) + this.f422d;
    }

    public final String toString() {
        return "Insets{left=" + this.f419a + ", top=" + this.f420b + ", right=" + this.f421c + ", bottom=" + this.f422d + '}';
    }
}
