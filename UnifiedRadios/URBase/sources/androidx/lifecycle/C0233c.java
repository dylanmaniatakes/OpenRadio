package androidx.lifecycle;

import java.lang.reflect.Method;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0233c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3954a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f3955b;

    public C0233c(Method method, int i5) throws SecurityException {
        this.f3954a = i5;
        this.f3955b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0233c)) {
            return false;
        }
        C0233c c0233c = (C0233c) obj;
        return this.f3954a == c0233c.f3954a && this.f3955b.getName().equals(c0233c.f3955b.getName());
    }

    public final int hashCode() {
        return this.f3955b.getName().hashCode() + (this.f3954a * 31);
    }
}
