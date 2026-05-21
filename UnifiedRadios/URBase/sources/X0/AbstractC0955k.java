package x0;

/* renamed from: x0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0955k extends AbstractC0954j {

    /* renamed from: a, reason: collision with root package name */
    public E.f[] f10388a;

    /* renamed from: b, reason: collision with root package name */
    public String f10389b;

    /* renamed from: c, reason: collision with root package name */
    public int f10390c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10391d;

    public AbstractC0955k() {
        this.f10388a = null;
        this.f10390c = 0;
    }

    public E.f[] getPathData() {
        return this.f10388a;
    }

    public String getPathName() {
        return this.f10389b;
    }

    public void setPathData(E.f[] fVarArr) {
        E.f[] fVarArr2 = this.f10388a;
        boolean z4 = false;
        if (fVarArr2 != null && fVarArr != null && fVarArr2.length == fVarArr.length) {
            int i5 = 0;
            while (true) {
                if (i5 >= fVarArr2.length) {
                    z4 = true;
                    break;
                }
                E.f fVar = fVarArr2[i5];
                char c2 = fVar.f424a;
                E.f fVar2 = fVarArr[i5];
                if (c2 != fVar2.f424a || fVar.f425b.length != fVar2.f425b.length) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        if (!z4) {
            this.f10388a = h4.d.g(fVarArr);
            return;
        }
        E.f[] fVarArr3 = this.f10388a;
        for (int i6 = 0; i6 < fVarArr.length; i6++) {
            fVarArr3[i6].f424a = fVarArr[i6].f424a;
            int i7 = 0;
            while (true) {
                float[] fArr = fVarArr[i6].f425b;
                if (i7 < fArr.length) {
                    fVarArr3[i6].f425b[i7] = fArr[i7];
                    i7++;
                }
            }
        }
    }

    public AbstractC0955k(AbstractC0955k abstractC0955k) {
        this.f10388a = null;
        this.f10390c = 0;
        this.f10389b = abstractC0955k.f10389b;
        this.f10391d = abstractC0955k.f10391d;
        this.f10388a = h4.d.g(abstractC0955k.f10388a);
    }
}
