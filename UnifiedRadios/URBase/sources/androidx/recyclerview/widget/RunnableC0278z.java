package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.recyclerview.widget.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0278z implements Runnable {
    public static final ThreadLocal n = new ThreadLocal();

    /* renamed from: o, reason: collision with root package name */
    public static final B0.a f4397o = new B0.a(4);

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f4398j;

    /* renamed from: k, reason: collision with root package name */
    public long f4399k;

    /* renamed from: l, reason: collision with root package name */
    public long f4400l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f4401m;

    public static n0 c(RecyclerView recyclerView, int i5, long j5) {
        int iL = recyclerView.h.l();
        for (int i6 = 0; i6 < iL; i6++) {
            n0 n0VarM = RecyclerView.M(recyclerView.h.k(i6));
            if (n0VarM.mPosition == i5 && !n0VarM.isInvalid()) {
                return null;
            }
        }
        d0 d0Var = recyclerView.f4106e;
        try {
            recyclerView.T();
            n0 n0VarK = d0Var.k(i5, j5);
            if (n0VarK != null) {
                if (!n0VarK.isBound() || n0VarK.isInvalid()) {
                    d0Var.a(n0VarK, false);
                } else {
                    d0Var.h(n0VarK.itemView);
                }
            }
            recyclerView.U(false);
            return n0VarK;
        } catch (Throwable th) {
            recyclerView.U(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i5, int i6) {
        if (recyclerView.f4135u) {
            if (RecyclerView.f4066C0 && !this.f4398j.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            }
            if (this.f4399k == 0) {
                this.f4399k = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        Q1.b bVar = recyclerView.f4113i0;
        bVar.f2168a = i5;
        bVar.f2169b = i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r17) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RunnableC0278z.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i5 = K.l.f1491a;
            K.k.a("RV Prefetch");
            ArrayList arrayList = this.f4398j;
            if (arrayList.isEmpty()) {
                this.f4399k = 0L;
                K.k.b();
                return;
            }
            int size = arrayList.size();
            long jMax = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i6);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.f4399k = 0L;
                K.k.b();
            } else {
                b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f4400l);
                this.f4399k = 0L;
                K.k.b();
            }
        } catch (Throwable th) {
            this.f4399k = 0L;
            int i7 = K.l.f1491a;
            K.k.b();
            throw th;
        }
    }
}
