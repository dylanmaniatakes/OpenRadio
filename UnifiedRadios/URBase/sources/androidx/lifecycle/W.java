package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class W {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3951a = new LinkedHashMap();

    public final void a() {
        for (S s4 : this.f3951a.values()) {
            s4.f3942c = true;
            HashMap map = s4.f3940a;
            if (map != null) {
                synchronized (map) {
                    try {
                        Iterator it = s4.f3940a.values().iterator();
                        while (it.hasNext()) {
                            S.a(it.next());
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = s4.f3941b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        Iterator it2 = s4.f3941b.iterator();
                        while (it2.hasNext()) {
                            S.a((Closeable) it2.next());
                        }
                    } finally {
                    }
                }
            }
            s4.b();
        }
        this.f3951a.clear();
    }
}
