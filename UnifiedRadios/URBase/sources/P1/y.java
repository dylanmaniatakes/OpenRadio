package p1;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import n1.C0785b;
import q1.AbstractC0854e;
import q1.C0856g;
import q1.C0862m;
import q1.C0863n;
import q1.C0864o;

/* loaded from: classes.dex */
public final class y implements N1.e {

    /* renamed from: c, reason: collision with root package name */
    public final C0832h f9156c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9157d;

    /* renamed from: e, reason: collision with root package name */
    public final C0826b f9158e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9159f;
    public final long g;

    public y(C0832h c0832h, int i5, C0826b c0826b, long j5, long j6) {
        this.f9156c = c0832h;
        this.f9157d = i5;
        this.f9158e = c0826b;
        this.f9159f = j5;
        this.g = j6;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0032 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static q1.C0856g a(p1.t r4, q1.AbstractC0854e r5, int r6) {
        /*
            q1.L r5 = r5.f9364v
            r0 = 0
            if (r5 != 0) goto L7
            r5 = r0
            goto L9
        L7:
            q1.g r5 = r5.f9323m
        L9:
            if (r5 == 0) goto L36
            boolean r1 = r5.f9369k
            if (r1 == 0) goto L36
            int[] r1 = r5.f9371m
            r2 = 0
            if (r1 != 0) goto L24
            int[] r1 = r5.f9372o
            if (r1 != 0) goto L19
            goto L2b
        L19:
            int r3 = r1.length
            if (r2 >= r3) goto L2b
            r3 = r1[r2]
            if (r3 != r6) goto L21
            goto L36
        L21:
            int r2 = r2 + 1
            goto L19
        L24:
            int r3 = r1.length
            if (r2 >= r3) goto L36
            r3 = r1[r2]
            if (r3 != r6) goto L33
        L2b:
            int r4 = r4.n
            int r6 = r5.n
            if (r4 >= r6) goto L32
            return r5
        L32:
            return r0
        L33:
            int r2 = r2 + 1
            goto L24
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.y.a(p1.t, q1.e, int):q1.g");
    }

    @Override // N1.e
    public final void k(N1.j jVar) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j5;
        int iElapsedRealtime;
        if (this.f9156c.b()) {
            C0864o c0864o = (C0864o) C0863n.e().f9401a;
            if (c0864o == null || c0864o.f9403k) {
                t tVar = (t) this.f9156c.f9123j.get(this.f9158e);
                if (tVar != null) {
                    Object obj = tVar.f9138d;
                    if (obj instanceof AbstractC0854e) {
                        AbstractC0854e abstractC0854e = (AbstractC0854e) obj;
                        long j6 = 0;
                        boolean z4 = this.f9159f > 0;
                        int i11 = abstractC0854e.f9359q;
                        if (c0864o != null) {
                            z4 &= c0864o.f9404l;
                            int i12 = c0864o.f9405m;
                            int i13 = c0864o.n;
                            i5 = c0864o.f9402j;
                            if (abstractC0854e.f9364v != null && !abstractC0854e.g()) {
                                C0856g c0856gA = a(tVar, abstractC0854e, this.f9157d);
                                if (c0856gA == null) {
                                    return;
                                }
                                boolean z5 = c0856gA.f9370l && this.f9159f > 0;
                                i13 = c0856gA.n;
                                z4 = z5;
                            }
                            i7 = i12;
                            i6 = i13;
                        } else {
                            i5 = 0;
                            i6 = 100;
                            i7 = 5000;
                        }
                        C0832h c0832h = this.f9156c;
                        if (jVar.f()) {
                            i9 = 0;
                            i10 = 0;
                        } else {
                            if (((N1.r) jVar).f1807d) {
                                i9 = 100;
                            } else {
                                Exception excC = jVar.c();
                                if (excC instanceof o1.e) {
                                    Status status = ((o1.e) excC).f8898j;
                                    i8 = status.f4639j;
                                    C0785b c0785b = status.f4642m;
                                    if (c0785b != null) {
                                        i10 = c0785b.f8728k;
                                        i9 = i8;
                                    }
                                } else {
                                    i8 = 101;
                                }
                                i9 = i8;
                            }
                            i10 = -1;
                        }
                        if (z4) {
                            long j7 = this.f9159f;
                            long j8 = this.g;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j8);
                            j5 = j7;
                            j6 = jCurrentTimeMillis;
                        } else {
                            j5 = 0;
                            iElapsedRealtime = -1;
                        }
                        c0832h.getClass();
                        z zVar = new z(new C0862m(this.f9157d, i9, i10, j5, j6, null, null, i11, iElapsedRealtime), i5, i7, i6);
                        A1.f fVar = c0832h.n;
                        fVar.sendMessage(fVar.obtainMessage(18, zVar));
                    }
                }
            }
        }
    }
}
