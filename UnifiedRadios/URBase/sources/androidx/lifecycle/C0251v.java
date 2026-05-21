package androidx.lifecycle;

import android.os.Looper;
import g0.AbstractC0535a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import l.C0722a;
import m.C0753a;
import m.C0755c;

/* renamed from: androidx.lifecycle.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0251v extends AbstractC0245o {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3969a;

    /* renamed from: b, reason: collision with root package name */
    public C0753a f3970b;

    /* renamed from: c, reason: collision with root package name */
    public EnumC0244n f3971c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f3972d;

    /* renamed from: e, reason: collision with root package name */
    public int f3973e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3974f;
    public boolean g;
    public final ArrayList h;

    public C0251v(InterfaceC0249t interfaceC0249t) {
        F3.i.f(interfaceC0249t, "provider");
        new AtomicReference();
        this.f3969a = true;
        this.f3970b = new C0753a();
        this.f3971c = EnumC0244n.f3962k;
        this.h = new ArrayList();
        this.f3972d = new WeakReference(interfaceC0249t);
    }

    @Override // androidx.lifecycle.AbstractC0245o
    public final void a(InterfaceC0248s interfaceC0248s) {
        r reflectiveGenericLifecycleObserver;
        InterfaceC0249t interfaceC0249t;
        ArrayList arrayList = this.h;
        F3.i.f(interfaceC0248s, "observer");
        d("addObserver");
        EnumC0244n enumC0244n = this.f3971c;
        EnumC0244n enumC0244n2 = EnumC0244n.f3961j;
        if (enumC0244n != enumC0244n2) {
            enumC0244n2 = EnumC0244n.f3962k;
        }
        C0250u c0250u = new C0250u();
        HashMap map = AbstractC0253x.f3976a;
        boolean z4 = interfaceC0248s instanceof r;
        boolean z5 = interfaceC0248s instanceof InterfaceC0235e;
        if (z4 && z5) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((InterfaceC0235e) interfaceC0248s, (r) interfaceC0248s);
        } else if (z5) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((InterfaceC0235e) interfaceC0248s, null);
        } else if (z4) {
            reflectiveGenericLifecycleObserver = (r) interfaceC0248s;
        } else {
            Class<?> cls = interfaceC0248s.getClass();
            if (AbstractC0253x.b(cls) == 2) {
                Object obj = AbstractC0253x.f3977b.get(cls);
                F3.i.c(obj);
                List list = (List) obj;
                if (list.size() == 1) {
                    AbstractC0253x.a((Constructor) list.get(0), interfaceC0248s);
                    throw null;
                }
                int size = list.size();
                InterfaceC0238h[] interfaceC0238hArr = new InterfaceC0238h[size];
                if (size > 0) {
                    AbstractC0253x.a((Constructor) list.get(0), interfaceC0248s);
                    throw null;
                }
                reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(interfaceC0238hArr);
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(interfaceC0248s);
            }
        }
        c0250u.f3968b = reflectiveGenericLifecycleObserver;
        c0250u.f3967a = enumC0244n2;
        if (((C0250u) this.f3970b.d(interfaceC0248s, c0250u)) == null && (interfaceC0249t = (InterfaceC0249t) this.f3972d.get()) != null) {
            boolean z6 = this.f3973e != 0 || this.f3974f;
            EnumC0244n enumC0244nC = c(interfaceC0248s);
            this.f3973e++;
            while (c0250u.f3967a.compareTo(enumC0244nC) < 0 && this.f3970b.n.containsKey(interfaceC0248s)) {
                arrayList.add(c0250u.f3967a);
                C0241k c0241k = EnumC0243m.Companion;
                EnumC0244n enumC0244n3 = c0250u.f3967a;
                c0241k.getClass();
                EnumC0243m enumC0243mB = C0241k.b(enumC0244n3);
                if (enumC0243mB == null) {
                    throw new IllegalStateException("no event up from " + c0250u.f3967a);
                }
                c0250u.a(interfaceC0249t, enumC0243mB);
                arrayList.remove(arrayList.size() - 1);
                enumC0244nC = c(interfaceC0248s);
            }
            if (!z6) {
                h();
            }
            this.f3973e--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0245o
    public final void b(InterfaceC0248s interfaceC0248s) {
        F3.i.f(interfaceC0248s, "observer");
        d("removeObserver");
        this.f3970b.b(interfaceC0248s);
    }

    public final EnumC0244n c(InterfaceC0248s interfaceC0248s) {
        C0250u c0250u;
        HashMap map = this.f3970b.n;
        C0755c c0755c = map.containsKey(interfaceC0248s) ? ((C0755c) map.get(interfaceC0248s)).f8500m : null;
        EnumC0244n enumC0244n = (c0755c == null || (c0250u = (C0250u) c0755c.f8498k) == null) ? null : c0250u.f3967a;
        ArrayList arrayList = this.h;
        EnumC0244n enumC0244n2 = arrayList.isEmpty() ^ true ? (EnumC0244n) arrayList.get(arrayList.size() - 1) : null;
        EnumC0244n enumC0244n3 = this.f3971c;
        F3.i.f(enumC0244n3, "state1");
        if (enumC0244n == null || enumC0244n.compareTo(enumC0244n3) >= 0) {
            enumC0244n = enumC0244n3;
        }
        return (enumC0244n2 == null || enumC0244n2.compareTo(enumC0244n) >= 0) ? enumC0244n : enumC0244n2;
    }

    public final void d(String str) {
        if (this.f3969a) {
            C0722a.o().f8320a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(AbstractC0535a.l("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(EnumC0243m enumC0243m) {
        F3.i.f(enumC0243m, "event");
        d("handleLifecycleEvent");
        f(enumC0243m.a());
    }

    public final void f(EnumC0244n enumC0244n) {
        EnumC0244n enumC0244n2 = this.f3971c;
        if (enumC0244n2 == enumC0244n) {
            return;
        }
        EnumC0244n enumC0244n3 = EnumC0244n.f3962k;
        EnumC0244n enumC0244n4 = EnumC0244n.f3961j;
        if (enumC0244n2 == enumC0244n3 && enumC0244n == enumC0244n4) {
            throw new IllegalStateException(("no event down from " + this.f3971c + " in component " + this.f3972d.get()).toString());
        }
        this.f3971c = enumC0244n;
        if (this.f3974f || this.f3973e != 0) {
            this.g = true;
            return;
        }
        this.f3974f = true;
        h();
        this.f3974f = false;
        if (this.f3971c == enumC0244n4) {
            this.f3970b = new C0753a();
        }
    }

    public final void g() {
        EnumC0244n enumC0244n = EnumC0244n.f3963l;
        d("setCurrentState");
        f(enumC0244n);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r7.g = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0251v.h():void");
    }
}
