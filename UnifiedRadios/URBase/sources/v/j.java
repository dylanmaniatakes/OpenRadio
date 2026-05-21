package v;

import java.util.Iterator;
import u.C0904a;

/* loaded from: classes.dex */
public final class j extends o {
    @Override // v.d
    public final void a(d dVar) {
        C0904a c0904a = (C0904a) this.f10005b;
        int i5 = c0904a.f9716s0;
        f fVar = this.h;
        Iterator it = fVar.f9990l.iterator();
        int i6 = 0;
        int i7 = -1;
        while (it.hasNext()) {
            int i8 = ((f) it.next()).g;
            if (i7 == -1 || i8 < i7) {
                i7 = i8;
            }
            if (i6 < i8) {
                i6 = i8;
            }
        }
        if (i5 == 0 || i5 == 2) {
            fVar.d(i7 + c0904a.f9718u0);
        } else {
            fVar.d(i6 + c0904a.f9718u0);
        }
    }

    @Override // v.o
    public final void d() {
        u.d dVar = this.f10005b;
        if (dVar instanceof C0904a) {
            f fVar = this.h;
            fVar.f9982b = true;
            C0904a c0904a = (C0904a) dVar;
            int i5 = c0904a.f9716s0;
            boolean z4 = c0904a.f9717t0;
            int i6 = 0;
            if (i5 == 0) {
                fVar.f9985e = 4;
                while (i6 < c0904a.f9877r0) {
                    u.d dVar2 = c0904a.f9876q0[i6];
                    if (z4 || dVar2.f9777g0 != 8) {
                        f fVar2 = dVar2.f9771d.h;
                        fVar2.f9989k.add(fVar);
                        fVar.f9990l.add(fVar2);
                    }
                    i6++;
                }
                m(this.f10005b.f9771d.h);
                m(this.f10005b.f9771d.f10010i);
                return;
            }
            if (i5 == 1) {
                fVar.f9985e = 5;
                while (i6 < c0904a.f9877r0) {
                    u.d dVar3 = c0904a.f9876q0[i6];
                    if (z4 || dVar3.f9777g0 != 8) {
                        f fVar3 = dVar3.f9771d.f10010i;
                        fVar3.f9989k.add(fVar);
                        fVar.f9990l.add(fVar3);
                    }
                    i6++;
                }
                m(this.f10005b.f9771d.h);
                m(this.f10005b.f9771d.f10010i);
                return;
            }
            if (i5 == 2) {
                fVar.f9985e = 6;
                while (i6 < c0904a.f9877r0) {
                    u.d dVar4 = c0904a.f9876q0[i6];
                    if (z4 || dVar4.f9777g0 != 8) {
                        f fVar4 = dVar4.f9773e.h;
                        fVar4.f9989k.add(fVar);
                        fVar.f9990l.add(fVar4);
                    }
                    i6++;
                }
                m(this.f10005b.f9773e.h);
                m(this.f10005b.f9773e.f10010i);
                return;
            }
            if (i5 != 3) {
                return;
            }
            fVar.f9985e = 7;
            while (i6 < c0904a.f9877r0) {
                u.d dVar5 = c0904a.f9876q0[i6];
                if (z4 || dVar5.f9777g0 != 8) {
                    f fVar5 = dVar5.f9773e.f10010i;
                    fVar5.f9989k.add(fVar);
                    fVar.f9990l.add(fVar5);
                }
                i6++;
            }
            m(this.f10005b.f9773e.h);
            m(this.f10005b.f9773e.f10010i);
        }
    }

    @Override // v.o
    public final void e() {
        u.d dVar = this.f10005b;
        if (dVar instanceof C0904a) {
            int i5 = ((C0904a) dVar).f9716s0;
            f fVar = this.h;
            if (i5 == 0 || i5 == 1) {
                dVar.f9763Y = fVar.g;
            } else {
                dVar.f9764Z = fVar.g;
            }
        }
    }

    @Override // v.o
    public final void f() {
        this.f10006c = null;
        this.h.c();
    }

    @Override // v.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.h;
        fVar2.f9989k.add(fVar);
        fVar.f9990l.add(fVar2);
    }
}
