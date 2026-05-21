package J1;

import java.util.HashSet;

/* renamed from: J1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0056c extends Q1 {

    /* renamed from: f, reason: collision with root package name */
    public String f1154f;
    public HashSet g;
    public q.b h;

    /* renamed from: i, reason: collision with root package name */
    public Long f1155i;

    /* renamed from: j, reason: collision with root package name */
    public Long f1156j;

    @Override // J1.Q1
    public final void m() {
    }

    public final c2 n(Integer num) {
        if (this.h.containsKey(num)) {
            return (c2) this.h.getOrDefault(num, null);
        }
        c2 c2Var = new c2(this, this.f1154f);
        this.h.put(num, c2Var);
        return c2Var;
    }
}
