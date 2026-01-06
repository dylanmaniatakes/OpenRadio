package F3;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class c implements K3.a, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public transient K3.a f590j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f591k;

    /* renamed from: l, reason: collision with root package name */
    public final Class f592l;

    /* renamed from: m, reason: collision with root package name */
    public final String f593m;
    public final String n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f594o;

    public c(Object obj, Class cls, String str, String str2, boolean z4) {
        this.f591k = obj;
        this.f592l = cls;
        this.f593m = str;
        this.n = str2;
        this.f594o = z4;
    }

    public final d a() {
        d eVar;
        Class cls = this.f592l;
        if (cls == null) {
            return null;
        }
        if (this.f594o) {
            m.f603a.getClass();
            eVar = new k(cls);
        } else {
            m.f603a.getClass();
            eVar = new e(cls);
        }
        return eVar;
    }
}
