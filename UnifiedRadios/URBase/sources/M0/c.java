package M0;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ D0.v f1666l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f1667m = null;
    public final /* synthetic */ boolean n = false;

    public c(D0.v vVar) {
        this.f1666l = vVar;
    }

    @Override // M0.d
    public final void d() {
        D0.v vVar = this.f1666l;
        WorkDatabase workDatabase = vVar.f302c;
        workDatabase.c();
        try {
            Iterator it = workDatabase.v().g(this.f1667m).iterator();
            while (it.hasNext()) {
                d.a(vVar, (String) it.next());
            }
            workDatabase.o();
            workDatabase.k();
            if (this.n) {
                D0.m.b(vVar.f301b, vVar.f302c, vVar.f304e);
            }
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }
}
