package P3;

import N3.C0131e;
import N3.InterfaceC0130d;
import N3.i0;
import S3.AbstractC0187a;
import S3.w;
import a.AbstractC0203a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import g0.AbstractC0535a;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public class d implements h {

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2088l = AtomicLongFieldUpdater.newUpdater(d.class, "sendersAndCloseStatus");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2089m = AtomicLongFieldUpdater.newUpdater(d.class, "receivers");
    public static final AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(d.class, "bufferEnd");

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2090o = AtomicLongFieldUpdater.newUpdater(d.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2091p = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "sendSegment");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2092q = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "receiveSegment");

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2093r = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "bufferEndSegment");

    /* renamed from: s, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2094s = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_closeCause");

    /* renamed from: t, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2095t = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "closeHandler");
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    /* renamed from: j, reason: collision with root package name */
    public final int f2096j;

    /* renamed from: k, reason: collision with root package name */
    public final E3.l f2097k;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public d(int i5, E3.l lVar) {
        this.f2096j = i5;
        this.f2097k = lVar;
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.j("Invalid channel capacity: ", i5, ", should be >=0").toString());
        }
        l lVar2 = f.f2099a;
        this.bufferEnd = i5 != 0 ? i5 != Integer.MAX_VALUE ? i5 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag = n.get(this);
        l lVar3 = new l(0L, null, this, 3);
        this.sendSegment = lVar3;
        this.receiveSegment = lVar3;
        if (x()) {
            lVar3 = f.f2099a;
            F3.i.d(lVar3, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = lVar3;
        this._closeCause = f.f2114s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object A(P3.d r13, w3.InterfaceC0936d r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof P3.b
            if (r0 == 0) goto L14
            r0 = r14
            P3.b r0 = (P3.b) r0
            int r1 = r0.f2084l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f2084l = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            P3.b r0 = new P3.b
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f2082j
            x3.a r0 = x3.EnumC0973a.f10448j
            int r1 = r6.f2084l
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r14)
            P3.k r14 = (P3.k) r14
            java.lang.Object r13 = r14.f2120a
            goto La2
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = P3.d.f2092q
            java.lang.Object r14 = r14.get(r13)
            P3.l r14 = (P3.l) r14
        L41:
            r13.getClass()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = P3.d.f2088l
            long r3 = r1.get(r13)
            boolean r1 = r13.v(r3, r2)
            if (r1 == 0) goto L5a
            java.lang.Throwable r13 = r13.r()
            P3.i r14 = new P3.i
            r14.<init>(r13)
            goto La8
        L5a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = P3.d.f2089m
            long r4 = r1.getAndIncrement(r13)
            int r1 = P3.f.f2100b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.f2419l
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L76
            P3.l r1 = r13.q(r9, r14)
            if (r1 != 0) goto L75
            goto L41
        L75:
            r14 = r1
        L76:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = r7.F(r8, r9, r10, r12)
            S3.w r7 = P3.f.f2109m
            if (r1 == r7) goto La9
            S3.w r7 = P3.f.f2110o
            if (r1 != r7) goto L93
            long r7 = r13.t()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L41
            r14.a()
            goto L41
        L93:
            S3.w r7 = P3.f.n
            if (r1 != r7) goto La4
            r6.f2084l = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.B(r2, r3, r4, r6)
            if (r13 != r0) goto La2
            return r0
        La2:
            r14 = r13
            goto La8
        La4:
            r14.a()
            r14 = r1
        La8:
            return r14
        La9:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.A(P3.d, w3.d):java.lang.Object");
    }

    public static boolean E(Object obj) {
        if (obj instanceof InterfaceC0130d) {
            F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return f.a((InterfaceC0130d) obj, C0900j.f9694a, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public static final l a(d dVar, long j5, l lVar) {
        Object objC;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        long j7;
        dVar.getClass();
        l lVar2 = f.f2099a;
        e eVar = e.f2098r;
        loop0: while (true) {
            objC = AbstractC0187a.c(lVar, j5);
            if (!AbstractC0187a.f(objC)) {
                S3.u uVarD = AbstractC0187a.d(objC);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2091p;
                    S3.u uVar = (S3.u) atomicReferenceFieldUpdater.get(dVar);
                    if (uVar.f2419l >= uVarD.f2419l) {
                        break loop0;
                    }
                    if (!uVarD.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(dVar, uVar, uVarD)) {
                        if (atomicReferenceFieldUpdater.get(dVar) != uVar) {
                            if (uVarD.e()) {
                                uVarD.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zF = AbstractC0187a.f(objC);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2089m;
        if (zF) {
            dVar.j();
            if (lVar.f2419l * f.f2100b >= atomicLongFieldUpdater2.get(dVar)) {
                return null;
            }
            lVar.a();
            return null;
        }
        l lVar3 = (l) AbstractC0187a.d(objC);
        long j8 = lVar3.f2419l;
        if (j8 <= j5) {
            return lVar3;
        }
        long j9 = f.f2100b * j8;
        do {
            atomicLongFieldUpdater = f2088l;
            j6 = atomicLongFieldUpdater.get(dVar);
            j7 = 1152921504606846975L & j6;
            if (j7 >= j9) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(dVar, j6, j7 + (((int) (j6 >> 60)) << 60)));
        if (j8 * f.f2100b >= atomicLongFieldUpdater2.get(dVar)) {
            return null;
        }
        lVar3.a();
        return null;
    }

    public static final void d(d dVar, t3.t tVar, C0131e c0131e) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        E3.l lVar = dVar.f2097k;
        if (lVar != null) {
            AbstractC0187a.a(lVar, tVar, c0131e.n);
        }
        c0131e.resumeWith(AbstractC0399v1.c(dVar.s()));
    }

    public static final int k(d dVar, l lVar, int i5, Object obj, long j5, Object obj2, boolean z4) {
        dVar.getClass();
        lVar.m(i5, obj);
        if (z4) {
            return dVar.G(lVar, i5, obj, j5, obj2, z4);
        }
        Object objK = lVar.k(i5);
        if (objK == null) {
            if (dVar.l(j5)) {
                if (lVar.j(null, i5, f.f2102d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (lVar.j(null, i5, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof i0) {
            lVar.m(i5, null);
            if (dVar.D(objK, obj)) {
                lVar.n(i5, f.f2105i);
                return 0;
            }
            w wVar = f.f2107k;
            if (lVar.f2121o.getAndSet((i5 * 2) + 1, wVar) != wVar) {
                lVar.l(i5, true);
            }
            return 5;
        }
        return dVar.G(lVar, i5, obj, j5, obj2, z4);
    }

    public static void u(d dVar) {
        dVar.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2090o;
        if ((atomicLongFieldUpdater.addAndGet(dVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(dVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(P3.l r17, int r18, long r19, w3.InterfaceC0936d r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.B(P3.l, int, long, w3.d):java.lang.Object");
    }

    public final void C(i0 i0Var, boolean z4) {
        Throwable thS;
        if (i0Var instanceof InterfaceC0130d) {
            InterfaceC0936d interfaceC0936d = (InterfaceC0936d) i0Var;
            if (z4) {
                thS = r();
                if (thS == null) {
                    thS = new m("Channel was closed");
                }
            } else {
                thS = s();
            }
            interfaceC0936d.resumeWith(AbstractC0399v1.c(thS));
            return;
        }
        if (i0Var instanceof r) {
            ((r) i0Var).f2127j.resumeWith(new k(new i(r())));
            return;
        }
        if (!(i0Var instanceof a)) {
            throw new IllegalStateException(("Unexpected waiter: " + i0Var).toString());
        }
        a aVar = (a) i0Var;
        C0131e c0131e = aVar.f2080k;
        F3.i.c(c0131e);
        aVar.f2080k = null;
        aVar.f2079j = f.f2108l;
        Throwable thR = aVar.f2081l.r();
        if (thR == null) {
            c0131e.resumeWith(Boolean.FALSE);
        } else {
            c0131e.resumeWith(AbstractC0399v1.c(thR));
        }
    }

    public final boolean D(Object obj, Object obj2) {
        boolean z4 = obj instanceof r;
        E3.l lVar = this.f2097k;
        if (z4) {
            F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            C0131e c0131e = ((r) obj).f2127j;
            return f.a(c0131e, new k(obj2), lVar != null ? new S3.p(lVar, obj2, c0131e.n) : null);
        }
        if (!(obj instanceof a)) {
            if (obj instanceof InterfaceC0130d) {
                F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                InterfaceC0130d interfaceC0130d = (InterfaceC0130d) obj;
                return f.a(interfaceC0130d, obj2, lVar != null ? new S3.p(lVar, obj2, ((C0131e) interfaceC0130d).n) : null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        a aVar = (a) obj;
        C0131e c0131e2 = aVar.f2080k;
        F3.i.c(c0131e2);
        aVar.f2080k = null;
        aVar.f2079j = obj2;
        Boolean bool = Boolean.TRUE;
        E3.l lVar2 = aVar.f2081l.f2097k;
        return f.a(c0131e2, bool, lVar2 != null ? new S3.p(lVar2, obj2, c0131e2.n) : null);
    }

    public final Object F(l lVar, int i5, long j5, Object obj) {
        Object objK = lVar.k(i5);
        AtomicReferenceArray atomicReferenceArray = lVar.f2121o;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2088l;
        if (objK == null) {
            if (j5 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return f.n;
                }
                if (lVar.j(objK, i5, obj)) {
                    p();
                    return f.f2109m;
                }
            }
        } else if (objK == f.f2102d && lVar.j(objK, i5, f.f2105i)) {
            p();
            Object obj2 = atomicReferenceArray.get(i5 * 2);
            lVar.m(i5, null);
            return obj2;
        }
        while (true) {
            Object objK2 = lVar.k(i5);
            if (objK2 == null || objK2 == f.f2103e) {
                if (j5 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (lVar.j(objK2, i5, f.h)) {
                        p();
                        return f.f2110o;
                    }
                } else {
                    if (obj == null) {
                        return f.n;
                    }
                    if (lVar.j(objK2, i5, obj)) {
                        p();
                        return f.f2109m;
                    }
                }
            } else {
                if (objK2 != f.f2102d) {
                    w wVar = f.f2106j;
                    if (objK2 != wVar && objK2 != f.h) {
                        if (objK2 == f.f2108l) {
                            p();
                            return f.f2110o;
                        }
                        if (objK2 != f.g && lVar.j(objK2, i5, f.f2104f)) {
                            boolean z4 = objK2 instanceof u;
                            if (z4) {
                                objK2 = ((u) objK2).f2128a;
                            }
                            if (E(objK2)) {
                                lVar.n(i5, f.f2105i);
                                p();
                                Object obj3 = atomicReferenceArray.get(i5 * 2);
                                lVar.m(i5, null);
                                return obj3;
                            }
                            lVar.n(i5, wVar);
                            lVar.h();
                            if (z4) {
                                p();
                            }
                            return f.f2110o;
                        }
                    }
                    return f.f2110o;
                }
                if (lVar.j(objK2, i5, f.f2105i)) {
                    p();
                    Object obj4 = atomicReferenceArray.get(i5 * 2);
                    lVar.m(i5, null);
                    return obj4;
                }
            }
        }
    }

    public final int G(l lVar, int i5, Object obj, long j5, Object obj2, boolean z4) {
        while (true) {
            Object objK = lVar.k(i5);
            if (objK == null) {
                if (!l(j5) || z4) {
                    if (z4) {
                        if (lVar.j(null, i5, f.f2106j)) {
                            lVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (lVar.j(null, i5, obj2)) {
                            return 2;
                        }
                    }
                } else if (lVar.j(null, i5, f.f2102d)) {
                    return 1;
                }
            } else {
                if (objK != f.f2103e) {
                    w wVar = f.f2107k;
                    if (objK == wVar) {
                        lVar.m(i5, null);
                        return 5;
                    }
                    if (objK == f.h) {
                        lVar.m(i5, null);
                        return 5;
                    }
                    if (objK == f.f2108l) {
                        lVar.m(i5, null);
                        j();
                        return 4;
                    }
                    lVar.m(i5, null);
                    if (objK instanceof u) {
                        objK = ((u) objK).f2128a;
                    }
                    if (D(objK, obj)) {
                        lVar.n(i5, f.f2105i);
                        return 0;
                    }
                    if (lVar.f2121o.getAndSet((i5 * 2) + 1, wVar) == wVar) {
                        return 5;
                    }
                    lVar.l(i5, true);
                    return 5;
                }
                if (lVar.j(objK, i5, f.f2102d)) {
                    return 1;
                }
            }
        }
    }

    public final void H(long j5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        long j7;
        if (x()) {
            return;
        }
        do {
            atomicLongFieldUpdater = n;
        } while (atomicLongFieldUpdater.get(this) <= j5);
        int i5 = f.f2101c;
        int i6 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2090o;
            if (i6 >= i5) {
                do {
                    j6 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j6, 4611686018427387904L + (j6 & 4611686018427387903L)));
                while (true) {
                    long j8 = atomicLongFieldUpdater.get(this);
                    long j9 = atomicLongFieldUpdater2.get(this);
                    long j10 = j9 & 4611686018427387903L;
                    boolean z4 = (j9 & 4611686018427387904L) != 0;
                    if (j8 == j10 && j8 == atomicLongFieldUpdater.get(this)) {
                        break;
                    } else if (!z4) {
                        atomicLongFieldUpdater2.compareAndSet(this, j9, j10 + 4611686018427387904L);
                    }
                }
                do {
                    j7 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j7, j7 & 4611686018427387903L));
                return;
            }
            long j11 = atomicLongFieldUpdater.get(this);
            if (j11 == (atomicLongFieldUpdater2.get(this) & 4611686018427387903L) && j11 == atomicLongFieldUpdater.get(this)) {
                return;
            } else {
                i6++;
            }
        }
    }

    @Override // P3.t
    public final boolean b(Throwable th) {
        return m(th, false);
    }

    @Override // P3.s
    public final void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        m(cancellationException, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01d1, code lost:
    
        r2.u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01d4, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ee, code lost:
    
        r5 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f2, code lost:
    
        d(r26, r27, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f5, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f6, code lost:
    
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fa, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fb, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x014c, code lost:
    
        if (r24 >= r5.get(r26)) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x014e, code lost:
    
        r19.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0151, code lost:
    
        r1 = r27;
        r2 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0155, code lost:
    
        d(r26, r1, r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    @Override // P3.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(t3.t r27, R3.c r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.e(t3.t, R3.c):java.lang.Object");
    }

    @Override // P3.s
    public final Object f(InterfaceC0936d interfaceC0936d) {
        return A(this, interfaceC0936d);
    }

    @Override // P3.t
    public final void g(C0.m mVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f2095t;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, mVar)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            w wVar = f.f2112q;
            if (obj != wVar) {
                if (obj == f.f2113r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            w wVar2 = f.f2113r;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, wVar, wVar2)) {
                if (atomicReferenceFieldUpdater.get(this) != wVar) {
                    break;
                }
            }
            mVar.invoke(r());
            return;
        }
    }

    @Override // P3.s
    public final Object h() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2089m;
        long j5 = atomicLongFieldUpdater.get(this);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2088l;
        long j6 = atomicLongFieldUpdater2.get(this);
        if (v(j6, true)) {
            return new i(r());
        }
        long j7 = j6 & 1152921504606846975L;
        Object obj = k.f2119b;
        if (j5 >= j7) {
            return obj;
        }
        Object obj2 = f.f2107k;
        l lVar = (l) f2092q.get(this);
        while (!v(atomicLongFieldUpdater2.get(this), true)) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j8 = f.f2100b;
            long j9 = andIncrement / j8;
            int i5 = (int) (andIncrement % j8);
            if (lVar.f2419l != j9) {
                l lVarQ = q(j9, lVar);
                if (lVarQ == null) {
                    continue;
                } else {
                    lVar = lVarQ;
                }
            }
            Object objF = F(lVar, i5, andIncrement, obj2);
            if (objF == f.f2109m) {
                i0 i0Var = obj2 instanceof i0 ? (i0) obj2 : null;
                if (i0Var != null) {
                    i0Var.a(lVar, i5);
                }
                H(andIncrement);
                lVar.h();
            } else if (objF == f.f2110o) {
                if (andIncrement < t()) {
                    lVar.a();
                }
            } else {
                if (objF == f.n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                lVar.a();
                obj = objF;
            }
            return obj;
        }
        return new i(r());
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return r1;
     */
    @Override // P3.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(java.lang.Object r23) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.i(java.lang.Object):java.lang.Object");
    }

    @Override // P3.s
    public final a iterator() {
        return new a(this);
    }

    @Override // P3.t
    public final boolean j() {
        return v(f2088l.get(this), false);
    }

    public final boolean l(long j5) {
        return j5 < n.get(this) || j5 < f2089m.get(this) + ((long) this.f2096j);
    }

    public final boolean m(Throwable th, boolean z4) {
        boolean z5;
        long j5;
        long j6;
        long j7;
        Object obj;
        long j8;
        long j9;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2088l;
        if (z4) {
            do {
                j9 = atomicLongFieldUpdater.get(this);
                if (((int) (j9 >> 60)) != 0) {
                    break;
                }
                l lVar = f.f2099a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j9, (1 << 60) + (j9 & 1152921504606846975L)));
        }
        w wVar = f.f2114s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2094s;
            if (atomicReferenceFieldUpdater.compareAndSet(this, wVar, th)) {
                z5 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != wVar) {
                z5 = false;
                break;
            }
        }
        if (z4) {
            do {
                j8 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j8, (3 << 60) + (j8 & 1152921504606846975L)));
        } else {
            do {
                j5 = atomicLongFieldUpdater.get(this);
                int i5 = (int) (j5 >> 60);
                if (i5 == 0) {
                    j6 = j5 & 1152921504606846975L;
                    j7 = 2;
                } else {
                    if (i5 != 1) {
                        break;
                    }
                    j6 = j5 & 1152921504606846975L;
                    j7 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j5, (j7 << 60) + j6));
        }
        j();
        if (z5) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2095t;
                obj = atomicReferenceFieldUpdater2.get(this);
                w wVar2 = obj == null ? f.f2112q : f.f2113r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, wVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                F3.o.b(1, obj);
                ((E3.l) obj).invoke(r());
            }
        }
        return z5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        r1 = (P3.l) ((S3.d) S3.d.f2388k.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final P3.l n(long r13) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.n(long):P3.l");
    }

    public final void o(long j5) {
        F1.b bVarB;
        l lVar = (l) f2092q.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2089m;
            long j6 = atomicLongFieldUpdater.get(this);
            if (j5 < Math.max(this.f2096j + j6, n.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j6, j6 + 1)) {
                long j7 = f.f2100b;
                long j8 = j6 / j7;
                int i5 = (int) (j6 % j7);
                if (lVar.f2419l != j8) {
                    l lVarQ = q(j8, lVar);
                    if (lVarQ == null) {
                        continue;
                    } else {
                        lVar = lVarQ;
                    }
                }
                Object objF = F(lVar, i5, j6, null);
                if (objF != f.f2110o) {
                    lVar.a();
                    E3.l lVar2 = this.f2097k;
                    if (lVar2 != null && (bVarB = AbstractC0187a.b(lVar2, objF, null)) != null) {
                        throw bVarB;
                    }
                } else if (j6 < t()) {
                    lVar.a();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0195, code lost:
    
        u(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0198, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.p():void");
    }

    public final l q(long j5, l lVar) {
        Object objC;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j6;
        l lVar2 = f.f2099a;
        e eVar = e.f2098r;
        loop0: while (true) {
            objC = AbstractC0187a.c(lVar, j5);
            if (!AbstractC0187a.f(objC)) {
                S3.u uVarD = AbstractC0187a.d(objC);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2092q;
                    S3.u uVar = (S3.u) atomicReferenceFieldUpdater.get(this);
                    if (uVar.f2419l >= uVarD.f2419l) {
                        break loop0;
                    }
                    if (!uVarD.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, uVarD)) {
                        if (atomicReferenceFieldUpdater.get(this) != uVar) {
                            if (uVarD.e()) {
                                uVarD.d();
                            }
                        }
                    }
                    if (uVar.e()) {
                        uVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (AbstractC0187a.f(objC)) {
            j();
            if (lVar.f2419l * f.f2100b >= t()) {
                return null;
            }
            lVar.a();
            return null;
        }
        l lVar3 = (l) AbstractC0187a.d(objC);
        boolean zX = x();
        long j7 = lVar3.f2419l;
        if (!zX && j5 <= n.get(this) / f.f2100b) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f2093r;
                S3.u uVar2 = (S3.u) atomicReferenceFieldUpdater2.get(this);
                if (uVar2.f2419l >= j7 || !lVar3.i()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, uVar2, lVar3)) {
                    if (atomicReferenceFieldUpdater2.get(this) != uVar2) {
                        if (lVar3.e()) {
                            lVar3.d();
                        }
                    }
                }
                if (uVar2.e()) {
                    uVar2.d();
                }
            }
        }
        if (j7 <= j5) {
            return lVar3;
        }
        long j8 = f.f2100b * j7;
        do {
            atomicLongFieldUpdater = f2089m;
            j6 = atomicLongFieldUpdater.get(this);
            if (j6 >= j8) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j6, j8));
        if (j7 * f.f2100b >= t()) {
            return null;
        }
        lVar3.a();
        return null;
    }

    public final Throwable r() {
        return (Throwable) f2094s.get(this);
    }

    public final Throwable s() {
        Throwable thR = r();
        return thR == null ? new N1.c("Channel was closed") : thR;
    }

    public final long t() {
        return f2088l.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a2, code lost:
    
        r3 = (P3.l) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a9, code lost:
    
        if (r3 != null) goto L89;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c6, code lost:
    
        r0 = (P3.l) ((S3.d) S3.d.f2388k.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(long r19, boolean r21) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.v(long, boolean):boolean");
    }

    public boolean w() {
        return false;
    }

    public final boolean x() {
        long j5 = n.get(this);
        return j5 == 0 || j5 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(long r5, P3.l r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f2419l
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            S3.d r0 = r7.b()
            P3.l r0 = (P3.l) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            S3.d r5 = r7.b()
            P3.l r5 = (P3.l) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = P3.d.f2093r
            java.lang.Object r6 = r5.get(r4)
            S3.u r6 = (S3.u) r6
            long r0 = r6.f2419l
            long r2 = r7.f2419l
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.d.y(long, P3.l):void");
    }

    public final Object z(t3.t tVar, R3.c cVar) throws Throwable {
        F1.b bVarB;
        C0131e c0131e = new C0131e(1, AbstractC0203a.h(cVar));
        c0131e.o();
        E3.l lVar = this.f2097k;
        if (lVar == null || (bVarB = AbstractC0187a.b(lVar, tVar, null)) == null) {
            c0131e.resumeWith(AbstractC0399v1.c(s()));
        } else {
            android.support.v4.media.session.b.b(bVarB, s());
            c0131e.resumeWith(AbstractC0399v1.c(bVarB));
        }
        Object objN = c0131e.n();
        return objN == EnumC0973a.f10448j ? objN : C0900j.f9694a;
    }
}
