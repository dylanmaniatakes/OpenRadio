package Q3;

import E3.p;
import S3.t;
import h4.r;
import java.util.ArrayList;
import s3.C0900j;
import w3.C0942j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0941i f2176a = C0942j.f10143j;

    /* renamed from: b, reason: collision with root package name */
    public final int f2177b = -2;

    /* renamed from: c, reason: collision with root package name */
    public final int f2178c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final p f2179d;

    public b(I0.d dVar) {
        this.f2179d = dVar;
    }

    @Override // Q3.e
    public final Object a(f fVar, InterfaceC0936d interfaceC0936d) throws Throwable {
        R3.a aVar = new R3.a(fVar, this, null);
        t tVar = new t(interfaceC0936d, interfaceC0936d.getContext());
        Object objP = r.p(tVar, tVar, aVar);
        return objP == EnumC0973a.f10448j ? objP : C0900j.f9694a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(P3.q r6, w3.InterfaceC0936d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof Q3.a
            if (r0 == 0) goto L13
            r0 = r7
            Q3.a r0 = (Q3.a) r0
            int r1 = r0.f2175m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2175m = r1
            goto L18
        L13:
            Q3.a r0 = new Q3.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f2173k
            x3.a r1 = x3.EnumC0973a.f10448j
            int r2 = r0.f2175m
            s3.j r3 = s3.C0900j.f9694a
            r4 = 1
            if (r2 == 0) goto L33
            if (r2 != r4) goto L2b
            P3.q r6 = r0.f2172j
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r7)
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r7)
            r0.f2172j = r6
            r0.f2175m = r4
            E3.p r7 = r5.f2179d
            java.lang.Object r7 = r7.c(r6, r0)
            if (r7 != r1) goto L43
            goto L44
        L43:
            r7 = r3
        L44:
            if (r7 != r1) goto L47
            return r1
        L47:
            P3.p r6 = (P3.p) r6
            P3.h r6 = r6.f2126m
            boolean r6 = r6.j()
            if (r6 == 0) goto L52
            return r3
        L52:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.b.b(P3.q, w3.d):java.lang.Object");
    }

    public final String c() {
        ArrayList arrayList = new ArrayList(4);
        C0942j c0942j = C0942j.f10143j;
        InterfaceC0941i interfaceC0941i = this.f2176a;
        if (interfaceC0941i != c0942j) {
            arrayList.add("context=" + interfaceC0941i);
        }
        int i5 = this.f2177b;
        if (i5 != -3) {
            arrayList.add("capacity=" + i5);
        }
        int i6 = this.f2178c;
        if (i6 != 1) {
            arrayList.add("onBufferOverflow=".concat(i6 != 1 ? i6 != 2 ? i6 != 3 ? "null" : "DROP_LATEST" : "DROP_OLDEST" : "SUSPEND"));
        }
        return getClass().getSimpleName() + '[' + t3.i.E(arrayList, ", ", null, null, null, 62) + ']';
    }

    public final String toString() {
        return "block[" + this.f2179d + "] -> " + c();
    }
}
