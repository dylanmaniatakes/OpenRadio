package C2;

import L0.l;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0334i0;
import com.google.android.gms.internal.measurement.C0354m0;
import java.util.concurrent.ConcurrentHashMap;
import q1.E;
import y2.h;

/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f183b;

    /* renamed from: a, reason: collision with root package name */
    public final l f184a;

    public b(l lVar) {
        E.i(lVar);
        this.f184a = lVar;
        new ConcurrentHashMap();
    }

    public final void a(Bundle bundle, String str) {
        if ((!D2.a.f415b.contains("fcm")) && !D2.a.f414a.contains(str)) {
            h hVar = D2.a.f416c;
            int i5 = hVar.f10502m;
            int i6 = 0;
            int i7 = 0;
            while (i7 < i5) {
                boolean zContainsKey = bundle.containsKey((String) hVar.get(i7));
                i7++;
                if (zContainsKey) {
                    return;
                }
            }
            if ("_cmp".equals(str)) {
                if (!(!D2.a.f415b.contains("fcm"))) {
                    return;
                }
                h hVar2 = D2.a.f416c;
                int i8 = hVar2.f10502m;
                while (i6 < i8) {
                    boolean zContainsKey2 = bundle.containsKey((String) hVar2.get(i6));
                    i6++;
                    if (zContainsKey2) {
                        return;
                    }
                }
                bundle.putString("_cis", "fcm_integration");
            }
            C0354m0 c0354m0 = (C0354m0) this.f184a.f1554d;
            c0354m0.getClass();
            c0354m0.b(new C0334i0(c0354m0, "fcm", str, bundle));
        }
    }
}
