package M0;

import androidx.work.impl.WorkDatabase;

/* loaded from: classes.dex */
public final class r implements C0.j {

    /* renamed from: a, reason: collision with root package name */
    public final L0.i f1700a;

    /* renamed from: b, reason: collision with root package name */
    public final K0.a f1701b;

    /* renamed from: c, reason: collision with root package name */
    public final L0.q f1702c;

    static {
        C0.t.f("WMFgUpdater");
    }

    public r(WorkDatabase workDatabase, K0.a aVar, L0.i iVar) {
        this.f1701b = aVar;
        this.f1700a = iVar;
        this.f1702c = workDatabase.v();
    }
}
