package P3;

import N3.AbstractC0146u;
import N3.C0131e;
import N3.C0137k;
import N3.InterfaceC0130d;
import N3.b0;
import S3.AbstractC0187a;
import S3.w;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final l f2099a = new l(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f2100b = AbstractC0187a.k("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* renamed from: c, reason: collision with root package name */
    public static final int f2101c = AbstractC0187a.k("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);

    /* renamed from: d, reason: collision with root package name */
    public static final w f2102d = new w("BUFFERED", 0);

    /* renamed from: e, reason: collision with root package name */
    public static final w f2103e = new w("SHOULD_BUFFER", 0);

    /* renamed from: f, reason: collision with root package name */
    public static final w f2104f = new w("S_RESUMING_BY_RCV", 0);
    public static final w g = new w("RESUMING_BY_EB", 0);
    public static final w h = new w("POISONED", 0);

    /* renamed from: i, reason: collision with root package name */
    public static final w f2105i = new w("DONE_RCV", 0);

    /* renamed from: j, reason: collision with root package name */
    public static final w f2106j = new w("INTERRUPTED_SEND", 0);

    /* renamed from: k, reason: collision with root package name */
    public static final w f2107k = new w("INTERRUPTED_RCV", 0);

    /* renamed from: l, reason: collision with root package name */
    public static final w f2108l = new w("CHANNEL_CLOSED", 0);

    /* renamed from: m, reason: collision with root package name */
    public static final w f2109m = new w("SUSPEND", 0);
    public static final w n = new w("SUSPEND_NO_WAITER", 0);

    /* renamed from: o, reason: collision with root package name */
    public static final w f2110o = new w("FAILED", 0);

    /* renamed from: p, reason: collision with root package name */
    public static final w f2111p = new w("NO_RECEIVE_RESULT", 0);

    /* renamed from: q, reason: collision with root package name */
    public static final w f2112q = new w("CLOSE_HANDLER_CLOSED", 0);

    /* renamed from: r, reason: collision with root package name */
    public static final w f2113r = new w("CLOSE_HANDLER_INVOKED", 0);

    /* renamed from: s, reason: collision with root package name */
    public static final w f2114s = new w("NO_CLOSE_CAUSE", 0);

    public static final boolean a(InterfaceC0130d interfaceC0130d, Object obj, E3.l lVar) {
        w wVar;
        C0131e c0131e = (C0131e) interfaceC0130d;
        c0131e.getClass();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0131e.f1845p;
            Object obj2 = atomicReferenceFieldUpdater.get(c0131e);
            boolean z4 = obj2 instanceof b0;
            wVar = AbstractC0146u.f1872a;
            if (!z4) {
                boolean z5 = obj2 instanceof C0137k;
                wVar = null;
                break;
            }
            Object objW = C0131e.w((b0) obj2, obj, c0131e.f1810l, lVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(c0131e, obj2, objW)) {
                if (atomicReferenceFieldUpdater.get(c0131e) != obj2) {
                    break;
                }
            }
            if (!c0131e.s()) {
                c0131e.l();
            }
        }
        if (wVar == null) {
            return false;
        }
        c0131e.m(c0131e.f1810l);
        return true;
    }
}
