package D0;

import C0.C0001a;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String f280a = C0.t.f("Schedulers");

    public static void a(L0.q qVar, C0.u uVar, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            uVar.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                qVar.i(jCurrentTimeMillis, ((L0.o) it.next()).f1561a);
            }
        }
    }

    public static void b(C0001a c0001a, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        L0.q qVarV = workDatabase.v();
        workDatabase.c();
        try {
            ArrayList arrayListC = qVarV.c();
            a(qVarV, c0001a.f132c, arrayListC);
            ArrayList arrayListB = qVarV.b(c0001a.f137j);
            a(qVarV, c0001a.f132c, arrayListB);
            arrayListB.addAll(arrayListC);
            ArrayList arrayListA = qVarV.a();
            workDatabase.o();
            workDatabase.k();
            if (arrayListB.size() > 0) {
                L0.o[] oVarArr = (L0.o[]) arrayListB.toArray(new L0.o[arrayListB.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    if (jVar.b()) {
                        jVar.d(oVarArr);
                    }
                }
            }
            if (arrayListA.size() > 0) {
                L0.o[] oVarArr2 = (L0.o[]) arrayListA.toArray(new L0.o[arrayListA.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    j jVar2 = (j) it2.next();
                    if (!jVar2.b()) {
                        jVar2.d(oVarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }
}
