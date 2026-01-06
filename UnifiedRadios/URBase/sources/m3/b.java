package M3;

import g0.AbstractC0535a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public int f1743j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f1744k;

    /* renamed from: l, reason: collision with root package name */
    public int f1745l;

    /* renamed from: m, reason: collision with root package name */
    public J3.c f1746m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f1747o;

    public b(c cVar) {
        this.f1747o = cVar;
        int i5 = cVar.f1749b;
        int length = cVar.f1748a.length();
        if (length < 0) {
            throw new IllegalArgumentException(AbstractC0535a.j("Cannot coerce value to an empty range: maximum ", length, " is less than minimum 0."));
        }
        if (i5 < 0) {
            i5 = 0;
        } else if (i5 > length) {
            i5 = length;
        }
        this.f1744k = i5;
        this.f1745l = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            int r0 = r7.f1745l
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f1743j = r1
            r0 = 0
            r7.f1746m = r0
            goto L7b
        Lb:
            M3.c r2 = r7.f1747o
            int r3 = r2.f1750c
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.n
            int r6 = r6 + r5
            r7.n = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f1748a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            J3.c r0 = new J3.c
            int r1 = r7.f1744k
            java.lang.CharSequence r2 = r2.f1748a
            int r2 = M3.e.A(r2)
            r0.<init>(r1, r2, r5)
            r7.f1746m = r0
            r7.f1745l = r4
            goto L79
        L34:
            E3.p r0 = r2.f1751d
            java.lang.CharSequence r3 = r2.f1748a
            int r6 = r7.f1745l
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.c(r3, r6)
            s3.e r0 = (s3.C0895e) r0
            if (r0 != 0) goto L58
            J3.c r0 = new J3.c
            int r1 = r7.f1744k
            java.lang.CharSequence r2 = r2.f1748a
            int r2 = M3.e.A(r2)
            r0.<init>(r1, r2, r5)
            r7.f1746m = r0
            r7.f1745l = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f9687j
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f9688k
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f1744k
            J3.c r3 = android.support.v4.media.session.b.j(r3, r2)
            r7.f1746m = r3
            int r2 = r2 + r0
            r7.f1744k = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.f1745l = r2
        L79:
            r7.f1743j = r5
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M3.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1743j == -1) {
            a();
        }
        return this.f1743j == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f1743j == -1) {
            a();
        }
        if (this.f1743j == 0) {
            throw new NoSuchElementException();
        }
        J3.c cVar = this.f1746m;
        F3.i.d(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.f1746m = null;
        this.f1743j = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
