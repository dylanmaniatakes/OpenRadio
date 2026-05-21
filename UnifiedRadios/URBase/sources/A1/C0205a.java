package a1;

import r3.InterfaceC0877a;

/* renamed from: a1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0205a implements InterfaceC0877a {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f3171e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public volatile InterfaceC0877a f3172c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Object f3173d;

    public static InterfaceC0877a a(InterfaceC0877a interfaceC0877a) {
        if (interfaceC0877a instanceof C0205a) {
            return interfaceC0877a;
        }
        C0205a c0205a = new C0205a();
        c0205a.f3173d = f3171e;
        c0205a.f3172c = interfaceC0877a;
        return c0205a;
    }

    @Override // r3.InterfaceC0877a
    public final Object get() {
        Object obj = this.f3173d;
        Object obj2 = f3171e;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f3173d;
                    if (obj == obj2) {
                        obj = this.f3172c.get();
                        Object obj3 = this.f3173d;
                        if (obj3 != obj2 && obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                        this.f3173d = obj;
                        this.f3172c = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
