package v;

import s.AbstractC0882e;

/* loaded from: classes.dex */
public abstract class o implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f10004a;

    /* renamed from: b, reason: collision with root package name */
    public u.d f10005b;

    /* renamed from: c, reason: collision with root package name */
    public l f10006c;

    /* renamed from: d, reason: collision with root package name */
    public int f10007d;

    /* renamed from: e, reason: collision with root package name */
    public final g f10008e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f10009f = 0;
    public boolean g = false;
    public final f h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public final f f10010i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    public int f10011j = 1;

    public o(u.d dVar) {
        this.f10005b = dVar;
    }

    public static void b(f fVar, f fVar2, int i5) {
        fVar.f9990l.add(fVar2);
        fVar.f9986f = i5;
        fVar2.f9989k.add(fVar);
    }

    public static f h(u.c cVar) {
        u.c cVar2 = cVar.f9738f;
        if (cVar2 == null) {
            return null;
        }
        int iC = AbstractC0882e.c(cVar2.f9737e);
        u.d dVar = cVar2.f9736d;
        if (iC == 1) {
            return dVar.f9771d.h;
        }
        if (iC == 2) {
            return dVar.f9773e.h;
        }
        if (iC == 3) {
            return dVar.f9771d.f10010i;
        }
        if (iC == 4) {
            return dVar.f9773e.f10010i;
        }
        if (iC != 5) {
            return null;
        }
        return dVar.f9773e.f9996k;
    }

    public static f i(u.c cVar, int i5) {
        u.c cVar2 = cVar.f9738f;
        if (cVar2 == null) {
            return null;
        }
        u.d dVar = cVar2.f9736d;
        o oVar = i5 == 0 ? dVar.f9771d : dVar.f9773e;
        int iC = AbstractC0882e.c(cVar2.f9737e);
        if (iC == 1 || iC == 2) {
            return oVar.h;
        }
        if (iC == 3 || iC == 4) {
            return oVar.f10010i;
        }
        return null;
    }

    public final void c(f fVar, f fVar2, int i5, g gVar) {
        fVar.f9990l.add(fVar2);
        fVar.f9990l.add(this.f10008e);
        fVar.h = i5;
        fVar.f9987i = gVar;
        fVar2.f9989k.add(fVar);
        gVar.f9989k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i5, int i6) {
        int iMax;
        if (i6 == 0) {
            u.d dVar = this.f10005b;
            int i7 = dVar.f9799v;
            iMax = Math.max(dVar.f9798u, i5);
            if (i7 > 0) {
                iMax = Math.min(i7, i5);
            }
            if (iMax == i5) {
                return i5;
            }
        } else {
            u.d dVar2 = this.f10005b;
            int i8 = dVar2.f9802y;
            iMax = Math.max(dVar2.f9801x, i5);
            if (i8 > 0) {
                iMax = Math.min(i8, i5);
            }
            if (iMax == i5) {
                return i5;
            }
        }
        return iMax;
    }

    public long j() {
        if (this.f10008e.f9988j) {
            return r0.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(u.c r12, u.c r13, int r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.o.l(u.c, u.c, int):void");
    }
}
