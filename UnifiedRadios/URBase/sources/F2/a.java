package F2;

import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f537a = null;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f538b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f539c;

    /* renamed from: d, reason: collision with root package name */
    public int f540d;

    /* renamed from: e, reason: collision with root package name */
    public int f541e;

    /* renamed from: f, reason: collision with root package name */
    public e f542f;
    public final HashSet g;

    public a(Class cls, Class[] clsArr) {
        HashSet hashSet = new HashSet();
        this.f538b = hashSet;
        this.f539c = new HashSet();
        this.f540d = 0;
        this.f541e = 0;
        this.g = new HashSet();
        hashSet.add(r.a(cls));
        for (Class cls2 : clsArr) {
            Z3.i.a(cls2, "Null interface");
            this.f538b.add(r.a(cls2));
        }
    }

    public final void a(j jVar) {
        if (!(!this.f538b.contains(jVar.f563a))) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        this.f539c.add(jVar);
    }

    public final b b() {
        if (this.f542f != null) {
            return new b(this.f537a, new HashSet(this.f538b), new HashSet(this.f539c), this.f540d, this.f541e, this.f542f, this.g);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public a(r rVar, r[] rVarArr) {
        HashSet hashSet = new HashSet();
        this.f538b = hashSet;
        this.f539c = new HashSet();
        this.f540d = 0;
        this.f541e = 0;
        this.g = new HashSet();
        hashSet.add(rVar);
        for (r rVar2 : rVarArr) {
            Z3.i.a(rVar2, "Null interface");
        }
        Collections.addAll(this.f538b, rVarArr);
    }
}
