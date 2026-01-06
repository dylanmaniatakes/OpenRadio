package m;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: m.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0758f implements Iterable {

    /* renamed from: j, reason: collision with root package name */
    public C0755c f8504j;

    /* renamed from: k, reason: collision with root package name */
    public C0755c f8505k;

    /* renamed from: l, reason: collision with root package name */
    public final WeakHashMap f8506l = new WeakHashMap();

    /* renamed from: m, reason: collision with root package name */
    public int f8507m = 0;

    public C0755c a(Object obj) {
        C0755c c0755c = this.f8504j;
        while (c0755c != null && !c0755c.f8497j.equals(obj)) {
            c0755c = c0755c.f8499l;
        }
        return c0755c;
    }

    public Object b(Object obj) {
        C0755c c0755cA = a(obj);
        if (c0755cA == null) {
            return null;
        }
        this.f8507m--;
        WeakHashMap weakHashMap = this.f8506l;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((AbstractC0757e) it.next()).a(c0755cA);
            }
        }
        C0755c c0755c = c0755cA.f8500m;
        if (c0755c != null) {
            c0755c.f8499l = c0755cA.f8499l;
        } else {
            this.f8504j = c0755cA.f8499l;
        }
        C0755c c0755c2 = c0755cA.f8499l;
        if (c0755c2 != null) {
            c0755c2.f8500m = c0755c;
        } else {
            this.f8505k = c0755c;
        }
        c0755cA.f8499l = null;
        c0755cA.f8500m = null;
        return c0755cA.f8498k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((m.C0754b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof m.C0758f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            m.f r7 = (m.C0758f) r7
            int r1 = r6.f8507m
            int r3 = r7.f8507m
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            m.b r3 = (m.C0754b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            m.b r4 = (m.C0754b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            m.b r7 = (m.C0754b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.C0758f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            C0754b c0754b = (C0754b) it;
            if (!c0754b.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) c0754b.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C0754b c0754b = new C0754b(this.f8504j, this.f8505k, 0);
        this.f8506l.put(c0754b, Boolean.FALSE);
        return c0754b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C0754b c0754b = (C0754b) it;
            if (!c0754b.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) c0754b.next()).toString());
            if (c0754b.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
