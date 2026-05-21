package D0;

import q0.C0840c;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final C0.u f238a;

    public b(C0.u uVar) {
        F3.i.f(uVar, "clock");
        this.f238a = uVar;
    }

    public final void a(C0840c c0840c) {
        c0840c.a();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < ");
            this.f238a.getClass();
            sb.append(System.currentTimeMillis() - q.f290a);
            sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            c0840c.x(sb.toString());
            c0840c.a0();
        } finally {
            c0840c.s();
        }
    }
}
