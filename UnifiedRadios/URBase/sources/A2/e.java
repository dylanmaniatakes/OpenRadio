package A2;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import p1.InterfaceC0827c;

/* loaded from: classes.dex */
public final class e implements InterfaceC0827c {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f21a = new AtomicReference();

    @Override // p1.InterfaceC0827c
    public final void a(boolean z4) {
        synchronized (g.f24j) {
            try {
                Iterator it = new ArrayList(g.f25k.values()).iterator();
                while (it.hasNext()) {
                    g gVar = (g) it.next();
                    if (gVar.f30e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it2 = gVar.f32i.iterator();
                        while (it2.hasNext()) {
                            g gVar2 = ((d) it2.next()).f20a;
                            if (z4) {
                                gVar2.getClass();
                            } else {
                                ((O2.d) gVar2.h.get()).b();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
