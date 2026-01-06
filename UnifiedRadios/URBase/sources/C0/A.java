package C0;

import J1.B1;
import J1.C0063e0;
import J1.V1;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class A implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f127j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f128k;

    public /* synthetic */ A(int i5, Object obj) {
        this.f127j = i5;
        this.f128k = obj;
    }

    private final void a() {
        long jLongValue;
        while (true) {
            F2.t tVar = (F2.t) this.f128k;
            while (true) {
                synchronized (((k4.j) tVar.f582c)) {
                    try {
                        if (!((k4.i) tVar.f583d).hasNext()) {
                            jLongValue = -1;
                            break;
                        } else {
                            jLongValue = ((Long) ((k4.i) tVar.f583d).next()).longValue();
                            if (((g4.b) tVar.f584e).b(jLongValue) == null) {
                                break;
                            }
                        }
                    } finally {
                    }
                }
            }
            if (jLongValue == -1) {
                return;
            }
            F2.t tVar2 = (F2.t) this.f128k;
            Iterator it = ((ArrayList) tVar2.f581b).iterator();
            while (it.hasNext()) {
                h4.m mVar = (h4.m) it.next();
                if (mVar instanceof h4.k) {
                    i4.c cVar = (i4.c) ((h4.k) mVar).f7102f.get();
                    if (!(cVar instanceof i4.d) || (((i4.d) cVar).f7373i.f1975b & 2) == 0) {
                    }
                }
                Drawable drawableC = mVar.f().c(jLongValue);
                if (drawableC != null) {
                    g4.b bVar = (g4.b) tVar2.f584e;
                    synchronized (bVar.f7038a) {
                        bVar.f7038a.put(Long.valueOf(jLongValue), drawableC);
                        break;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:253:0x065b  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.InterruptedException, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 1860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C0.A.run():void");
    }

    public A(C0063e0 c0063e0, boolean z4) {
        this.f127j = 1;
        this.f128k = c0063e0;
    }

    public A(V1 v12, B1 b12) {
        this.f127j = 5;
        this.f128k = v12;
    }
}
