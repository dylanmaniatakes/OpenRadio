package Q0;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f2161c = o.f2164a;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2162a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f2163b = false;

    public final synchronized void a(long j5, String str) {
        if (this.f2163b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f2162a.add(new m(str, j5, SystemClock.elapsedRealtime()));
    }

    public final synchronized void b(String str) {
        long j5;
        this.f2163b = true;
        ArrayList arrayList = this.f2162a;
        if (arrayList.size() == 0) {
            j5 = 0;
        } else {
            j5 = ((m) arrayList.get(arrayList.size() - 1)).f2160c - ((m) arrayList.get(0)).f2160c;
        }
        if (j5 <= 0) {
            return;
        }
        long j6 = ((m) this.f2162a.get(0)).f2160c;
        o.b("(%-4d ms) %s", Long.valueOf(j5), str);
        Iterator it = this.f2162a.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long j7 = mVar.f2160c;
            o.b("(+%-4d) [%2d] %s", Long.valueOf(j7 - j6), Long.valueOf(mVar.f2159b), mVar.f2158a);
            j6 = j7;
        }
    }

    public final void finalize() {
        if (this.f2163b) {
            return;
        }
        b("Request on the loose");
        o.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}
