package F2;

import java.util.Set;

/* loaded from: classes.dex */
public final class o implements Q2.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile Set f572a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Set f573b;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        throw r0;
     */
    @Override // Q2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get() {
        /*
            r3 = this;
            java.util.Set r0 = r3.f573b
            if (r0 != 0) goto L40
            monitor-enter(r3)
            java.util.Set r0 = r3.f573b     // Catch: java.lang.Throwable -> L3a
            if (r0 != 0) goto L3c
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L3a
            r0.<init>()     // Catch: java.lang.Throwable -> L3a
            java.util.Set r0 = java.util.Collections.newSetFromMap(r0)     // Catch: java.lang.Throwable -> L3a
            r3.f573b = r0     // Catch: java.lang.Throwable -> L3a
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L3a
            java.util.Set r0 = r3.f572a     // Catch: java.lang.Throwable -> L31
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L31
        L1b:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L33
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L31
            Q2.a r1 = (Q2.a) r1     // Catch: java.lang.Throwable -> L31
            java.util.Set r2 = r3.f573b     // Catch: java.lang.Throwable -> L31
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> L31
            r2.add(r1)     // Catch: java.lang.Throwable -> L31
            goto L1b
        L31:
            r0 = move-exception
            goto L38
        L33:
            r0 = 0
            r3.f572a = r0     // Catch: java.lang.Throwable -> L31
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3a
            goto L3c
        L38:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3a
            throw r0     // Catch: java.lang.Throwable -> L3a
        L3a:
            r0 = move-exception
            goto L3e
        L3c:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3a
            goto L40
        L3e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3a
            throw r0
        L40:
            java.util.Set r0 = r3.f573b
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F2.o.get():java.lang.Object");
    }
}
