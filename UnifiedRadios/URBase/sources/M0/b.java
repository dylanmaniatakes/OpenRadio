package M0;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ D0.v f1664l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ UUID f1665m;

    public b(D0.v vVar, UUID uuid) {
        this.f1664l = vVar;
        this.f1665m = uuid;
    }

    @Override // M0.d
    public final void d() {
        D0.v vVar = this.f1664l;
        WorkDatabase workDatabase = vVar.f302c;
        workDatabase.c();
        try {
            d.a(vVar, this.f1665m.toString());
            workDatabase.o();
            workDatabase.k();
            D0.m.b(vVar.f301b, vVar.f302c, vVar.f304e);
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }
}
