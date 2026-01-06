package v;

/* loaded from: classes.dex */
public final class i extends o {
    @Override // v.d
    public final void a(d dVar) {
        f fVar = this.h;
        if (fVar.f9983c && !fVar.f9988j) {
            fVar.d((int) ((((f) fVar.f9990l.get(0)).g * ((u.h) this.f10005b).f9871q0) + 0.5f));
        }
    }

    @Override // v.o
    public final void d() {
        u.d dVar = this.f10005b;
        u.h hVar = (u.h) dVar;
        int i5 = hVar.f9872r0;
        int i6 = hVar.f9873s0;
        int i7 = hVar.f9875u0;
        f fVar = this.h;
        if (i7 == 1) {
            if (i5 != -1) {
                fVar.f9990l.add(dVar.f9758T.f9771d.h);
                this.f10005b.f9758T.f9771d.h.f9989k.add(fVar);
                fVar.f9986f = i5;
            } else if (i6 != -1) {
                fVar.f9990l.add(dVar.f9758T.f9771d.f10010i);
                this.f10005b.f9758T.f9771d.f10010i.f9989k.add(fVar);
                fVar.f9986f = -i6;
            } else {
                fVar.f9982b = true;
                fVar.f9990l.add(dVar.f9758T.f9771d.f10010i);
                this.f10005b.f9758T.f9771d.f10010i.f9989k.add(fVar);
            }
            m(this.f10005b.f9771d.h);
            m(this.f10005b.f9771d.f10010i);
            return;
        }
        if (i5 != -1) {
            fVar.f9990l.add(dVar.f9758T.f9773e.h);
            this.f10005b.f9758T.f9773e.h.f9989k.add(fVar);
            fVar.f9986f = i5;
        } else if (i6 != -1) {
            fVar.f9990l.add(dVar.f9758T.f9773e.f10010i);
            this.f10005b.f9758T.f9773e.f10010i.f9989k.add(fVar);
            fVar.f9986f = -i6;
        } else {
            fVar.f9982b = true;
            fVar.f9990l.add(dVar.f9758T.f9773e.f10010i);
            this.f10005b.f9758T.f9773e.f10010i.f9989k.add(fVar);
        }
        m(this.f10005b.f9773e.h);
        m(this.f10005b.f9773e.f10010i);
    }

    @Override // v.o
    public final void e() {
        u.d dVar = this.f10005b;
        int i5 = ((u.h) dVar).f9875u0;
        f fVar = this.h;
        if (i5 == 1) {
            dVar.f9763Y = fVar.g;
        } else {
            dVar.f9764Z = fVar.g;
        }
    }

    @Override // v.o
    public final void f() {
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
