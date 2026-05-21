package p1;

import java.util.Arrays;

/* renamed from: p1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0826b {

    /* renamed from: a, reason: collision with root package name */
    public final int f9104a;

    /* renamed from: b, reason: collision with root package name */
    public final o1.d f9105b;

    /* renamed from: c, reason: collision with root package name */
    public final o1.b f9106c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9107d;

    public C0826b(o1.d dVar, o1.b bVar, String str) {
        this.f9105b = dVar;
        this.f9106c = bVar;
        this.f9107d = str;
        this.f9104a = Arrays.hashCode(new Object[]{dVar, bVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0826b)) {
            return false;
        }
        C0826b c0826b = (C0826b) obj;
        return q1.E.l(this.f9105b, c0826b.f9105b) && q1.E.l(this.f9106c, c0826b.f9106c) && q1.E.l(this.f9107d, c0826b.f9107d);
    }

    public final int hashCode() {
        return this.f9104a;
    }
}
