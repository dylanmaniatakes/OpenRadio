package g4;

import Y0.j;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import h4.h;
import h4.m;
import h4.n;
import h4.o;
import h4.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import k4.k;

/* loaded from: classes.dex */
public final class e extends d implements k {
    public final HashMap n;

    /* renamed from: o, reason: collision with root package name */
    public j f7057o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f7058p;

    /* renamed from: q, reason: collision with root package name */
    public h4.e f7059q;

    /* renamed from: r, reason: collision with root package name */
    public final n f7060r;

    /* renamed from: s, reason: collision with root package name */
    public final h4.k f7061s;

    /* renamed from: t, reason: collision with root package name */
    public final h f7062t;

    public e(Context context, i4.c cVar) {
        h hVar;
        h4.k kVar;
        j jVar = new j();
        jVar.f2915a = context;
        n nVar = new n(context);
        int i5 = 0;
        super(cVar);
        this.n = new HashMap();
        this.f7057o = jVar;
        ArrayList arrayList = new ArrayList();
        this.f7058p = arrayList;
        Collections.addAll(arrayList, new m[0]);
        this.f7060r = nVar;
        this.f7059q = new o();
        h4.j jVar2 = new h4.j(jVar, context.getAssets(), cVar);
        arrayList.add(jVar2);
        h4.j jVar3 = this.f7059q instanceof q ? new h4.j(jVar, cVar, 2) : new h4.j(jVar, cVar, 3);
        arrayList.add(jVar3);
        h4.j jVar4 = new h4.j(jVar, cVar, 1);
        arrayList.add(jVar4);
        h hVar2 = new h();
        hVar2.j(jVar2);
        hVar2.j(jVar3);
        hVar2.j(jVar4);
        this.f7062t = hVar2;
        arrayList.add(hVar2);
        h4.k kVar2 = new h4.k(cVar, this.f7059q, nVar);
        this.f7061s = kVar2;
        arrayList.add(kVar2);
        this.f7053j.f7042e.add(new k4.h(1));
        this.f7053j.f7042e.add(new k4.h(0));
        b bVar = this.f7053j;
        bVar.f7044i = false;
        bVar.f7045j = false;
        ((ArrayList) bVar.g.f581b).add(jVar2);
        ((ArrayList) this.f7053j.g.f581b).add(jVar3);
        ((ArrayList) this.f7053j.g.f581b).add(jVar4);
        ((ArrayList) this.f7053j.g.f581b).add(kVar2);
        this.f7053j.h.add(this);
        Iterator it = arrayList.iterator();
        int i6 = -1;
        int i7 = -1;
        while (true) {
            boolean zHasNext = it.hasNext();
            hVar = this.f7062t;
            kVar = this.f7061s;
            if (!zHasNext) {
                break;
            }
            m mVar = (m) it.next();
            if (i6 == -1 && mVar == kVar) {
                i6 = i5;
            }
            if (i7 == -1 && mVar == hVar) {
                i7 = i5;
            }
            i5++;
        }
        if (i6 == -1 || i7 == -1 || i7 < i6) {
            return;
        }
        arrayList.set(i6, hVar);
        arrayList.set(i7, kVar);
    }

    @Override // k4.k
    public final boolean a(long j5) {
        boolean zContainsKey;
        synchronized (this.n) {
            zContainsKey = this.n.containsKey(Long.valueOf(j5));
        }
        return zContainsKey;
    }

    @Override // g4.d
    public final void c() {
        h4.e eVar = this.f7059q;
        if (eVar != null) {
            eVar.b();
        }
        this.f7059q = null;
        synchronized (this.f7058p) {
            try {
                Iterator it = this.f7058p.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.n) {
            this.n.clear();
        }
        j jVar = this.f7057o;
        if (jVar != null) {
            jVar.f2915a = null;
            this.f7057o = null;
        }
        b();
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        if (r1 <= r4) goto L34;
     */
    @Override // g4.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable d(long r8) {
        /*
            r7 = this;
            g4.b r0 = r7.f7053j
            android.graphics.drawable.Drawable r0 = r0.b(r8)
            if (r0 == 0) goto L5b
            int r1 = g4.g.b(r0)
            r2 = -1
            if (r1 != r2) goto L10
            return r0
        L10:
            h4.n r1 = r7.f7060r
            if (r1 == 0) goto L1a
            boolean r1 = r1.a()
            if (r1 == 0) goto L5a
        L1a:
            boolean r1 = r7.f7055l
            if (r1 != 0) goto L1f
            goto L5a
        L1f:
            java.util.ArrayList r1 = r7.f7058p
            java.util.Iterator r1 = r1.iterator()
            r3 = r2
            r4 = r3
        L27:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L4c
            java.lang.Object r5 = r1.next()
            h4.m r5 = (h4.m) r5
            boolean r6 = r5.g()
            if (r6 == 0) goto L27
            int r6 = r5.d()
            if (r3 == r2) goto L41
            if (r3 <= r6) goto L42
        L41:
            r3 = r6
        L42:
            int r5 = r5.c()
            if (r4 == r2) goto L4a
            if (r4 >= r5) goto L27
        L4a:
            r4 = r5
            goto L27
        L4c:
            if (r3 == r2) goto L5a
            if (r4 != r2) goto L51
            goto L5a
        L51:
            r1 = 58
            long r1 = r8 >> r1
            int r1 = (int) r1
            if (r1 < r3) goto L5a
            if (r1 <= r4) goto L5b
        L5a:
            return r0
        L5b:
            java.util.HashMap r1 = r7.n
            monitor-enter(r1)
            java.util.HashMap r2 = r7.n     // Catch: java.lang.Throwable -> L6c
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L6c
            boolean r2 = r2.containsKey(r3)     // Catch: java.lang.Throwable -> L6c
            if (r2 == 0) goto L6e
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6c
            return r0
        L6c:
            r8 = move-exception
            goto L88
        L6e:
            java.util.HashMap r2 = r7.n     // Catch: java.lang.Throwable -> L6c
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L6c
            r4 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L6c
            r2.put(r3, r4)     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6c
            g4.f r1 = new g4.f
            java.util.ArrayList r2 = r7.f7058p
            r1.<init>(r8, r2, r7)
            r7.k(r1)
            return r0
        L88:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L6c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.e.d(long):android.graphics.drawable.Drawable");
    }

    @Override // g4.d
    public final void g(i4.c cVar) {
        this.f7056m = cVar;
        b();
        synchronized (this.f7058p) {
            try {
                Iterator it = this.f7058p.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).i(cVar);
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(f fVar, Drawable drawable) {
        e(fVar.f7064b, drawable, g.b(drawable));
        f(0);
        e4.a.g().getClass();
        synchronized (this.n) {
            this.n.put(Long.valueOf(fVar.f7064b), 1);
        }
        k(fVar);
    }

    public final void i(f fVar) {
        f(1);
        e4.a.g().getClass();
        j(fVar.f7064b);
    }

    public final void j(long j5) {
        synchronized (this.n) {
            this.n.remove(Long.valueOf(j5));
        }
    }

    public final void k(f fVar) {
        m mVar;
        Integer num;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            List list = fVar.f7063a;
            if (list == null || fVar.f7066d >= list.size()) {
                mVar = null;
            } else {
                int i5 = fVar.f7066d;
                fVar.f7066d = i5 + 1;
                mVar = (m) list.get(i5);
            }
            if (mVar != null) {
                z4 = !this.f7058p.contains(mVar);
                z5 = !this.f7055l && mVar.g();
                int i6 = (int) (fVar.f7064b >> 58);
                z6 = i6 > mVar.c() || i6 < mVar.d();
            }
            if (mVar == null || (!z4 && !z5 && !z6)) {
                break;
            }
        }
        if (mVar == null) {
            synchronized (this.n) {
                num = (Integer) this.n.get(Long.valueOf(fVar.f7064b));
            }
            if (num != null && num.intValue() == 0) {
                f(1);
                e4.a.g().getClass();
            }
            j(fVar.f7064b);
            return;
        }
        if (mVar.f7107a.isShutdown()) {
            return;
        }
        synchronized (mVar.f7108b) {
            e4.a.g().getClass();
            mVar.f7110d.put(Long.valueOf(fVar.f7064b), fVar);
        }
        try {
            mVar.f7107a.execute(mVar.f());
        } catch (RejectedExecutionException e5) {
            Log.w("OsmDroid", "RejectedExecutionException", e5);
        }
    }
}
