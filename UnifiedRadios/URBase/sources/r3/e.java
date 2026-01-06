package R3;

import E3.p;
import N3.InterfaceC0144s;
import P3.h;
import s3.C0900j;
import w3.InterfaceC0936d;
import y3.i;

/* loaded from: classes.dex */
public final class e extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public h f2317k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f2318l;

    /* renamed from: m, reason: collision with root package name */
    public int f2319m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f2320o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f2321p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Q3.e[] f2322q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ E3.a f2323r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ H0.h f2324s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Q3.f f2325t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Q3.e[] eVarArr, H0.g gVar, H0.h hVar, Q3.f fVar, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f2322q = eVarArr;
        this.f2323r = gVar;
        this.f2324s = hVar;
        this.f2325t = fVar;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((e) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        e eVar = new e(this.f2322q, (H0.g) this.f2323r, this.f2324s, this.f2325t, interfaceC0936d);
        eVar.f2321p = obj;
        return eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e0, code lost:
    
        if (r9 != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
    
        r12 = (java.lang.Object[]) r20.f2323r.invoke();
        r13 = r20.f2325t;
        r14 = r20.f2324s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ee, code lost:
    
        if (r12 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f0, code lost:
    
        r20.f2321p = r10;
        r20.f2317k = r11;
        r20.f2318l = r2;
        r20.f2319m = r9;
        r20.n = r7;
        r20.f2320o = 2;
        r14.getClass();
        r12 = new H0.h(3, r20);
        r12.f654l = r13;
        r12.f655m = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010c, code lost:
    
        if (r12.invokeSuspend(r4) != r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010f, code lost:
    
        t3.h.s(0, 0, r10.length, r10, r12);
        r20.f2321p = r10;
        r20.f2317k = r11;
        r20.f2318l = r2;
        r20.f2319m = r9;
        r20.n = r7;
        r20.f2320o = 3;
        r14.getClass();
        r14 = new H0.h(3, r20);
        r14.f654l = r13;
        r14.f655m = r12;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0130, code lost:
    
        if (r14.invokeSuspend(r4) != r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0132, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        if (r9 != 0) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:40:0x00e0, B:34:0x00ce], limit reached: 52 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be A[LOOP:0: B:29:0x00be->B:52:?, LOOP_START, PHI: r9 r13
      0x00be: PHI (r9v3 int) = (r9v2 int), (r9v4 int) binds: [B:27:0x00bb, B:52:?] A[DONT_GENERATE, DONT_INLINE]
      0x00be: PHI (r13v5 t3.t) = (r13v4 t3.t), (r13v11 t3.t) binds: [B:27:0x00bb, B:52:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r11v1, types: [P3.d] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2, types: [P3.h, P3.s] */
    /* JADX WARN: Type inference failed for: r11v3, types: [P3.h, P3.s] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6, types: [P3.h] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x010c -> B:19:0x009d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0130 -> B:49:0x0133). Please report as a decompilation issue!!! */
    @Override // y3.AbstractC0987a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R3.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
