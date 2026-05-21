package O;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class D0 {

    /* renamed from: b, reason: collision with root package name */
    public static final F0 f1887b;

    /* renamed from: a, reason: collision with root package name */
    public final F0 f1888a;

    static {
        int i5 = Build.VERSION.SDK_INT;
        f1887b = (i5 >= 30 ? new w0() : i5 >= 29 ? new v0() : new u0()).b().f1894a.a().f1894a.b().f1894a.c();
    }

    public D0(F0 f02) {
        this.f1888a = f02;
    }

    public F0 a() {
        return this.f1888a;
    }

    public F0 b() {
        return this.f1888a;
    }

    public F0 c() {
        return this.f1888a;
    }

    public void d(View view) {
    }

    public C0168i e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D0)) {
            return false;
        }
        D0 d02 = (D0) obj;
        return n() == d02.n() && m() == d02.m() && N.b.a(j(), d02.j()) && N.b.a(h(), d02.h()) && N.b.a(e(), d02.e());
    }

    public E.c f(int i5) {
        return E.c.f418e;
    }

    public E.c g() {
        return j();
    }

    public E.c h() {
        return E.c.f418e;
    }

    public int hashCode() {
        return N.b.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public E.c i() {
        return j();
    }

    public E.c j() {
        return E.c.f418e;
    }

    public E.c k() {
        return j();
    }

    public F0 l(int i5, int i6, int i7, int i8) {
        return f1887b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void o(E.c[] cVarArr) {
    }

    public void p(F0 f02) {
    }

    public void q(E.c cVar) {
    }
}
