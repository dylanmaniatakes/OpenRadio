package L3;

import C0.m;
import E3.l;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public final c f1638a;

    /* renamed from: b, reason: collision with root package name */
    public final l f1639b;

    public j(M3.c cVar, m mVar) {
        this.f1638a = cVar;
        this.f1639b = mVar;
    }

    @Override // L3.c
    public final Iterator iterator() {
        return new i(this);
    }
}
