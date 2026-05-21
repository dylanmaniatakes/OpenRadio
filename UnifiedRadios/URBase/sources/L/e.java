package L;

import L0.s;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e implements N.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1513a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1514b;

    public /* synthetic */ e(int i5, Object obj) {
        this.f1513a = i5;
        this.f1514b = obj;
    }

    @Override // N.a
    public final void a(Object obj) {
        switch (this.f1513a) {
            case 0:
                f fVar = (f) obj;
                if (fVar == null) {
                    fVar = new f(-3);
                }
                ((s) this.f1514b).t(fVar);
                return;
            default:
                f fVar2 = (f) obj;
                synchronized (g.f1519c) {
                    try {
                        q.k kVar = g.f1520d;
                        ArrayList arrayList = (ArrayList) kVar.getOrDefault((String) this.f1514b, null);
                        if (arrayList == null) {
                            return;
                        }
                        kVar.remove((String) this.f1514b);
                        for (int i5 = 0; i5 < arrayList.size(); i5++) {
                            ((N.a) arrayList.get(i5)).a(fVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
