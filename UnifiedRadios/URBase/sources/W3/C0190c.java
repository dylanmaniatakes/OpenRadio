package W3;

import java.util.concurrent.TimeUnit;

/* renamed from: W3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0190c {
    public static C0194g a() throws InterruptedException {
        C0194g c0194g = C0194g.head;
        F3.i.c(c0194g);
        C0194g c0194g2 = c0194g.next;
        if (c0194g2 == null) {
            long jNanoTime = System.nanoTime();
            C0194g.condition.await(C0194g.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            C0194g c0194g3 = C0194g.head;
            F3.i.c(c0194g3);
            if (c0194g3.next != null || System.nanoTime() - jNanoTime < C0194g.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return C0194g.head;
        }
        long jAccess$remainingNanos = C0194g.access$remainingNanos(c0194g2, System.nanoTime());
        if (jAccess$remainingNanos > 0) {
            C0194g.condition.await(jAccess$remainingNanos, TimeUnit.NANOSECONDS);
            return null;
        }
        C0194g c0194g4 = C0194g.head;
        F3.i.c(c0194g4);
        c0194g4.next = c0194g2.next;
        c0194g2.next = null;
        return c0194g2;
    }
}
