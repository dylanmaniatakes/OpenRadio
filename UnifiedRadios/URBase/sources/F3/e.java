package F3;

import E3.p;
import E3.q;
import E3.r;
import E3.s;
import E3.t;
import E3.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q0.C0839b;
import s3.C0895e;

/* loaded from: classes.dex */
public final class e implements K3.b, d {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f595b;

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f596c;

    /* renamed from: a, reason: collision with root package name */
    public final Class f597a;

    static {
        List listY = t3.j.y(E3.a.class, E3.l.class, p.class, H0.h.class, C0839b.class, q.class, r.class, s.class, t.class, u.class, E3.b.class, E3.c.class, E3.d.class, E3.e.class, E3.f.class, E3.g.class, E3.h.class, E3.i.class, E3.j.class, E3.k.class, E3.m.class, E3.n.class, E3.o.class);
        ArrayList arrayList = new ArrayList(t3.k.A(listY));
        int i5 = 0;
        for (Object obj : listY) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                t3.j.z();
                throw null;
            }
            arrayList.add(new C0895e((Class) obj, Integer.valueOf(i5)));
            i5 = i6;
        }
        f595b = t3.u.x(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        i.e(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            i.e(str, "kotlinName");
            sb.append(M3.e.N(str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f595b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(t3.u.w(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), M3.e.N((String) entry2.getValue()));
        }
        f596c = linkedHashMap;
    }

    public e(Class cls) {
        i.f(cls, "jClass");
        this.f597a = cls;
    }

    @Override // F3.d
    public final Class a() {
        return this.f597a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && h4.c.p(this).equals(h4.c.p((K3.b) obj));
    }

    public final int hashCode() {
        return h4.c.p(this).hashCode();
    }

    public final String toString() {
        return this.f597a.toString() + " (Kotlin reflection is not available)";
    }
}
