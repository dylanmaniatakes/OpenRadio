package u;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import s.AbstractC0882e;
import s.C0883f;
import v.n;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public int f9734b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9735c;

    /* renamed from: d, reason: collision with root package name */
    public final d f9736d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9737e;

    /* renamed from: f, reason: collision with root package name */
    public c f9738f;

    /* renamed from: i, reason: collision with root package name */
    public C0883f f9739i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f9733a = null;
    public int g = 0;
    public int h = Integer.MIN_VALUE;

    public c(d dVar, int i5) {
        this.f9736d = dVar;
        this.f9737e = i5;
    }

    public final void a(c cVar, int i5) {
        b(cVar, i5, Integer.MIN_VALUE, false);
    }

    public final boolean b(c cVar, int i5, int i6, boolean z4) {
        if (cVar == null) {
            j();
            return true;
        }
        if (!z4 && !i(cVar)) {
            return false;
        }
        this.f9738f = cVar;
        if (cVar.f9733a == null) {
            cVar.f9733a = new HashSet();
        }
        HashSet hashSet = this.f9738f.f9733a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i5;
        this.h = i6;
        return true;
    }

    public final void c(int i5, ArrayList arrayList, n nVar) {
        HashSet hashSet = this.f9733a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                v.h.b(((c) it.next()).f9736d, i5, arrayList, nVar);
            }
        }
    }

    public final int d() {
        if (this.f9735c) {
            return this.f9734b;
        }
        return 0;
    }

    public final int e() {
        c cVar;
        if (this.f9736d.f9777g0 == 8) {
            return 0;
        }
        int i5 = this.h;
        return (i5 == Integer.MIN_VALUE || (cVar = this.f9738f) == null || cVar.f9736d.f9777g0 != 8) ? this.g : i5;
    }

    public final c f() {
        int i5 = this.f9737e;
        int iC = AbstractC0882e.c(i5);
        d dVar = this.f9736d;
        switch (iC) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return dVar.f9749K;
            case 2:
                return dVar.f9750L;
            case 3:
                return dVar.I;
            case 4:
                return dVar.f9748J;
            default:
                throw new AssertionError(com.unified.ur1.SatelliteTracker.h.t(i5));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f9733a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f9738f != null;
    }

    public final boolean i(c cVar) {
        if (cVar == null) {
            return false;
        }
        int i5 = this.f9737e;
        d dVar = cVar.f9736d;
        int i6 = cVar.f9737e;
        if (i6 == i5) {
            return i5 != 6 || (dVar.f9744E && this.f9736d.f9744E);
        }
        switch (AbstractC0882e.c(i5)) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z4 = i6 == 2 || i6 == 4;
                if (dVar instanceof h) {
                    return z4 || i6 == 8;
                }
                return z4;
            case 2:
            case 4:
                boolean z5 = i6 == 3 || i6 == 5;
                if (dVar instanceof h) {
                    return z5 || i6 == 9;
                }
                return z5;
            case 5:
                return (i6 == 2 || i6 == 4) ? false : true;
            case 6:
                return (i6 == 6 || i6 == 8 || i6 == 9) ? false : true;
            default:
                throw new AssertionError(com.unified.ur1.SatelliteTracker.h.t(i5));
        }
    }

    public final void j() {
        HashSet hashSet;
        c cVar = this.f9738f;
        if (cVar != null && (hashSet = cVar.f9733a) != null) {
            hashSet.remove(this);
            if (this.f9738f.f9733a.size() == 0) {
                this.f9738f.f9733a = null;
            }
        }
        this.f9733a = null;
        this.f9738f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.f9735c = false;
        this.f9734b = 0;
    }

    public final void k() {
        C0883f c0883f = this.f9739i;
        if (c0883f == null) {
            this.f9739i = new C0883f(1);
        } else {
            c0883f.c();
        }
    }

    public final void l(int i5) {
        this.f9734b = i5;
        this.f9735c = true;
    }

    public final String toString() {
        return this.f9736d.f9778h0 + ":" + com.unified.ur1.SatelliteTracker.h.t(this.f9737e);
    }
}
