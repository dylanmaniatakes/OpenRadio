package v;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public o f9994a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f9995b;

    public static long a(f fVar, long j5) {
        o oVar = fVar.f9984d;
        if (oVar instanceof j) {
            return j5;
        }
        ArrayList arrayList = fVar.f9989k;
        int size = arrayList.size();
        long jMin = j5;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) arrayList.get(i5);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f9984d != oVar) {
                    jMin = Math.min(jMin, a(fVar2, fVar2.f9986f + j5));
                }
            }
        }
        if (fVar != oVar.f10010i) {
            return jMin;
        }
        long j6 = oVar.j();
        long j7 = j5 - j6;
        return Math.min(Math.min(jMin, a(oVar.h, j7)), j7 - r9.f9986f);
    }

    public static long b(f fVar, long j5) {
        o oVar = fVar.f9984d;
        if (oVar instanceof j) {
            return j5;
        }
        ArrayList arrayList = fVar.f9989k;
        int size = arrayList.size();
        long jMax = j5;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) arrayList.get(i5);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f9984d != oVar) {
                    jMax = Math.max(jMax, b(fVar2, fVar2.f9986f + j5));
                }
            }
        }
        if (fVar != oVar.h) {
            return jMax;
        }
        long j6 = oVar.j();
        long j7 = j5 + j6;
        return Math.max(Math.max(jMax, b(oVar.f10010i, j7)), j7 - r9.f9986f);
    }
}
