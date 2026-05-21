package M0;

import C0.w;
import C0.z;
import D0.x;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import l0.AbstractC0737m;
import q0.C0847j;

/* loaded from: classes.dex */
public abstract class d implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1668j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1669k;

    public d() {
        this.f1668j = 0;
        this.f1669k = new L0.s(1);
    }

    public static void a(D0.v vVar, String str) {
        x xVarB;
        WorkDatabase workDatabase = vVar.f302c;
        L0.q qVarV = workDatabase.v();
        L0.c cVarQ = workDatabase.q();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            int iF = qVarV.f(str2);
            if (iF != 3 && iF != 4) {
                AbstractC0737m abstractC0737m = qVarV.f1582a;
                abstractC0737m.b();
                L0.h hVar = qVarV.f1586e;
                C0847j c0847jA = hVar.a();
                if (str2 == null) {
                    c0847jA.t(1);
                } else {
                    c0847jA.h(1, str2);
                }
                abstractC0737m.c();
                try {
                    c0847jA.c();
                    abstractC0737m.o();
                } finally {
                    abstractC0737m.k();
                    hVar.n(c0847jA);
                }
            }
            linkedList.addAll(cVarQ.g(str2));
        }
        D0.h hVar2 = vVar.f305f;
        synchronized (hVar2.f269k) {
            C0.t.d().a(D0.h.f260l, "Processor cancelling " + str);
            hVar2.f267i.add(str);
            xVarB = hVar2.b(str);
        }
        D0.h.d(str, xVarB, 1);
        Iterator it = vVar.f304e.iterator();
        while (it.hasNext()) {
            ((D0.j) it.next()).a(str);
        }
    }

    public abstract Drawable b(long j5);

    public Drawable c(long j5) {
        int i5 = (int) (j5 >> 58);
        h4.m mVar = (h4.m) this.f1669k;
        if (i5 < mVar.d() || i5 > mVar.c()) {
            return null;
        }
        return b(j5);
    }

    public abstract void d();

    public void e(g4.f fVar, Drawable drawable) {
        e4.a.g().getClass();
        h4.m mVar = (h4.m) this.f1669k;
        long j5 = fVar.f7064b;
        mVar.h(j5);
        int[] iArr = g4.g.f7067d;
        drawable.setState(new int[]{-1});
        g4.e eVar = (g4.e) fVar.f7065c;
        eVar.getClass();
        eVar.e(j5, drawable, -1);
        eVar.f(0);
        e4.a.g().getClass();
        eVar.j(j5);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Drawable drawableC;
        g4.f fVar;
        switch (this.f1668j) {
            case 0:
                L0.s sVar = (L0.s) this.f1669k;
                try {
                    d();
                    sVar.o(z.f180a);
                    return;
                } catch (Throwable th) {
                    sVar.o(new w(th));
                    return;
                }
        }
        while (true) {
            synchronized (((h4.m) this.f1669k).f7108b) {
                try {
                    drawableC = null;
                    Long l5 = null;
                    for (Long l6 : ((h4.m) this.f1669k).f7110d.keySet()) {
                        if (!((h4.m) this.f1669k).f7109c.containsKey(l6)) {
                            e4.a.g().getClass();
                            l5 = l6;
                        }
                    }
                    if (l5 != null) {
                        e4.a.g().getClass();
                        h4.m mVar = (h4.m) this.f1669k;
                        mVar.f7109c.put(l5, (g4.f) mVar.f7110d.get(l5));
                    }
                    fVar = l5 != null ? (g4.f) ((h4.m) this.f1669k).f7110d.get(l5) : null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (fVar == null) {
                return;
            }
            e4.a.g().getClass();
            try {
                drawableC = c(fVar.f7064b);
            } catch (h4.b e5) {
                Log.i("OsmDroid", "Tile loader can't continue: " + k4.l.k(fVar.f7064b), e5);
                ((h4.m) this.f1669k).a();
            } catch (Throwable th3) {
                Log.i("OsmDroid", "Error downloading tile: " + k4.l.k(fVar.f7064b), th3);
            }
            if (drawableC == null) {
                e4.a.g().getClass();
                ((h4.m) this.f1669k).h(fVar.f7064b);
                ((g4.e) fVar.f7065c).k(fVar);
            } else if (g4.g.b(drawableC) == -2) {
                e4.a.g().getClass();
                ((h4.m) this.f1669k).h(fVar.f7064b);
                drawableC.setState(new int[]{-2});
                ((g4.e) fVar.f7065c).h(fVar, drawableC);
            } else if (g4.g.b(drawableC) == -3) {
                e4.a.g().getClass();
                ((h4.m) this.f1669k).h(fVar.f7064b);
                drawableC.setState(new int[]{-3});
                ((g4.e) fVar.f7065c).h(fVar, drawableC);
            } else {
                e(fVar, drawableC);
            }
        }
    }

    public d(h4.m mVar) {
        this.f1668j = 1;
        this.f1669k = mVar;
    }
}
