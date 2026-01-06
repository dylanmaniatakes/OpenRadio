package F2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f543a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f544b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f545c;

    /* renamed from: d, reason: collision with root package name */
    public final int f546d;

    /* renamed from: e, reason: collision with root package name */
    public final int f547e;

    /* renamed from: f, reason: collision with root package name */
    public final e f548f;
    public final Set g;

    public b(String str, Set set, Set set2, int i5, int i6, e eVar, Set set3) {
        this.f543a = str;
        this.f544b = Collections.unmodifiableSet(set);
        this.f545c = Collections.unmodifiableSet(set2);
        this.f546d = i5;
        this.f547e = i6;
        this.f548f = eVar;
        this.g = Collections.unmodifiableSet(set3);
    }

    public static a a(r rVar) {
        return new a(rVar, new r[0]);
    }

    public static a b(Class cls) {
        return new a(cls, new Class[0]);
    }

    public static b c(Object obj, Class cls, Class... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(r.a(cls));
        for (Class cls2 : clsArr) {
            Z3.i.a(cls2, "Null interface");
            hashSet.add(r.a(cls2));
        }
        return new b(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new D0.p(1, obj), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f544b.toArray()) + ">{" + this.f546d + ", type=" + this.f547e + ", deps=" + Arrays.toString(this.f545c.toArray()) + "}";
    }
}
