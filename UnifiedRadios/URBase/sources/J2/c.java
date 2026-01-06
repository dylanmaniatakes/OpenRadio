package J2;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f1473a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1474b;

    public c(String str, Map map) {
        this.f1473a = str;
        this.f1474b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.emptyMap());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f1473a.equals(cVar.f1473a) && this.f1474b.equals(cVar.f1474b);
    }

    public final int hashCode() {
        return this.f1474b.hashCode() + (this.f1473a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f1473a + ", properties=" + this.f1474b.values() + "}";
    }
}
