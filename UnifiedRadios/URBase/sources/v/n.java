package v;

import h1.C0559c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import s.C0880c;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    public static int f9998f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f9999a;

    /* renamed from: b, reason: collision with root package name */
    public int f10000b;

    /* renamed from: c, reason: collision with root package name */
    public int f10001c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f10002d;

    /* renamed from: e, reason: collision with root package name */
    public int f10003e;

    public final void a(ArrayList arrayList) {
        int size = this.f9999a.size();
        if (this.f10003e != -1 && size > 0) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                n nVar = (n) arrayList.get(i5);
                if (this.f10003e == nVar.f10000b) {
                    c(this.f10001c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(C0880c c0880c, int i5) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f9999a;
        if (arrayList.size() == 0) {
            return 0;
        }
        u.e eVar = (u.e) ((u.d) arrayList.get(0)).f9758T;
        c0880c.t();
        eVar.b(c0880c, false);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ((u.d) arrayList.get(i6)).b(c0880c, false);
        }
        if (i5 == 0 && eVar.z0 > 0) {
            u.j.a(eVar, c0880c, arrayList, 0);
        }
        if (i5 == 1 && eVar.f9804A0 > 0) {
            u.j.a(eVar, c0880c, arrayList, 1);
        }
        try {
            c0880c.p();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.f10002d = new ArrayList();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            u.d dVar = (u.d) arrayList.get(i7);
            C0559c c0559c = new C0559c();
            new WeakReference(dVar);
            C0880c.n(dVar.I);
            C0880c.n(dVar.f9748J);
            C0880c.n(dVar.f9749K);
            C0880c.n(dVar.f9750L);
            C0880c.n(dVar.f9751M);
            this.f10002d.add(c0559c);
        }
        if (i5 == 0) {
            iN = C0880c.n(eVar.I);
            iN2 = C0880c.n(eVar.f9749K);
            c0880c.t();
        } else {
            iN = C0880c.n(eVar.f9748J);
            iN2 = C0880c.n(eVar.f9750L);
            c0880c.t();
        }
        return iN2 - iN;
    }

    public final void c(int i5, n nVar) {
        Iterator it = this.f9999a.iterator();
        while (it.hasNext()) {
            u.d dVar = (u.d) it.next();
            ArrayList arrayList = nVar.f9999a;
            if (!arrayList.contains(dVar)) {
                arrayList.add(dVar);
            }
            int i6 = nVar.f10000b;
            if (i5 == 0) {
                dVar.f9789n0 = i6;
            } else {
                dVar.f9791o0 = i6;
            }
        }
        this.f10003e = nVar.f10000b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i5 = this.f10001c;
        sb.append(i5 == 0 ? "Horizontal" : i5 == 1 ? "Vertical" : i5 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strD = com.unified.ur1.SatelliteTracker.h.d(sb, this.f10000b, "] <");
        Iterator it = this.f9999a.iterator();
        while (it.hasNext()) {
            strD = strD + " " + ((u.d) it.next()).f9778h0;
        }
        return com.unified.ur1.SatelliteTracker.h.b(strD, " >");
    }
}
