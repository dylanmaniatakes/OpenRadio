package v;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d, reason: collision with root package name */
    public final o f9984d;

    /* renamed from: f, reason: collision with root package name */
    public int f9986f;
    public int g;

    /* renamed from: a, reason: collision with root package name */
    public o f9981a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9982b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9983c = false;

    /* renamed from: e, reason: collision with root package name */
    public int f9985e = 1;
    public int h = 1;

    /* renamed from: i, reason: collision with root package name */
    public g f9987i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9988j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f9989k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9990l = new ArrayList();

    public f(o oVar) {
        this.f9984d = oVar;
    }

    @Override // v.d
    public final void a(d dVar) {
        ArrayList arrayList = this.f9990l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f9988j) {
                return;
            }
        }
        this.f9983c = true;
        o oVar = this.f9981a;
        if (oVar != null) {
            oVar.a(this);
        }
        if (this.f9982b) {
            this.f9984d.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        f fVar = null;
        int i5 = 0;
        while (it2.hasNext()) {
            f fVar2 = (f) it2.next();
            if (!(fVar2 instanceof g)) {
                i5++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i5 == 1 && fVar.f9988j) {
            g gVar = this.f9987i;
            if (gVar != null) {
                if (!gVar.f9988j) {
                    return;
                } else {
                    this.f9986f = this.h * gVar.g;
                }
            }
            d(fVar.g + this.f9986f);
        }
        o oVar2 = this.f9981a;
        if (oVar2 != null) {
            oVar2.a(this);
        }
    }

    public final void b(d dVar) {
        this.f9989k.add(dVar);
        if (this.f9988j) {
            dVar.a(dVar);
        }
    }

    public final void c() {
        this.f9990l.clear();
        this.f9989k.clear();
        this.f9988j = false;
        this.g = 0;
        this.f9983c = false;
        this.f9982b = false;
    }

    public void d(int i5) {
        if (this.f9988j) {
            return;
        }
        this.f9988j = true;
        this.g = i5;
        Iterator it = this.f9989k.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            dVar.a(dVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9984d.f10005b.f9778h0);
        sb.append(":");
        switch (this.f9985e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f9988j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f9990l.size());
        sb.append(":d=");
        sb.append(this.f9989k.size());
        sb.append(">");
        return sb.toString();
    }
}
