package C0;

import androidx.work.impl.workers.DiagnosticsWorker;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final UUID f176a;

    /* renamed from: b, reason: collision with root package name */
    public final L0.o f177b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f178c;

    public v(UUID uuid, L0.o oVar, LinkedHashSet linkedHashSet) {
        F3.i.f(uuid, "id");
        F3.i.f(oVar, "workSpec");
        this.f176a = uuid;
        this.f177b = oVar;
        this.f178c = linkedHashSet;
    }

    public static final v a() {
        UUID uuidRandomUUID = UUID.randomUUID();
        F3.i.e(uuidRandomUUID, "randomUUID()");
        String string = uuidRandomUUID.toString();
        F3.i.e(string, "id.toString()");
        String name = DiagnosticsWorker.class.getName();
        L0.o oVar = new L0.o(string, 0, name, (String) null, (h) null, (h) null, 0L, 0L, 0L, (d) null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, 8388602);
        String[] strArr = {DiagnosticsWorker.class.getName()};
        LinkedHashSet linkedHashSet = new LinkedHashSet(t3.u.w(1));
        linkedHashSet.add(strArr[0]);
        v vVar = new v(uuidRandomUUID, oVar, linkedHashSet);
        d dVar = oVar.f1568j;
        boolean z4 = (dVar.h.isEmpty() ^ true) || dVar.f146d || dVar.f144b || dVar.f145c;
        if (oVar.f1574q) {
            if (!(!z4)) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
            }
            if (oVar.g > 0) {
                throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
            }
        }
        UUID uuidRandomUUID2 = UUID.randomUUID();
        F3.i.e(uuidRandomUUID2, "randomUUID()");
        String string2 = uuidRandomUUID2.toString();
        F3.i.e(string2, "id.toString()");
        new L0.o(string2, oVar.f1562b, name, oVar.f1564d, new h(oVar.f1565e), new h(oVar.f1566f), oVar.g, oVar.h, oVar.f1567i, new d(oVar.f1568j), oVar.f1569k, oVar.f1570l, oVar.f1571m, oVar.n, oVar.f1572o, oVar.f1573p, oVar.f1574q, oVar.f1575r, oVar.f1576s, oVar.f1578u, oVar.f1579v, oVar.f1580w, 524288);
        return vVar;
    }
}
