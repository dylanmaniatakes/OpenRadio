package n0;

import F3.i;
import M3.m;
import java.util.ArrayList;
import java.util.List;

/* renamed from: n0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0782d {

    /* renamed from: a, reason: collision with root package name */
    public final String f8717a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8718b;

    /* renamed from: c, reason: collision with root package name */
    public final List f8719c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8720d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
    public C0782d(String str, boolean z4, List list, List list2) {
        i.f(list, "columns");
        i.f(list2, "orders");
        this.f8717a = str;
        this.f8718b = z4;
        this.f8719c = list;
        this.f8720d = list2;
        if (list2.isEmpty()) {
            int size = list.size();
            list2 = new ArrayList(size);
            for (int i5 = 0; i5 < size; i5++) {
                list2.add("ASC");
            }
        }
        this.f8720d = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0782d)) {
            return false;
        }
        C0782d c0782d = (C0782d) obj;
        if (this.f8718b != c0782d.f8718b || !i.a(this.f8719c, c0782d.f8719c) || !i.a(this.f8720d, c0782d.f8720d)) {
            return false;
        }
        String str = this.f8717a;
        boolean zX = m.x(str, "index_", false);
        String str2 = c0782d.f8717a;
        return zX ? m.x(str2, "index_", false) : str.equals(str2);
    }

    public final int hashCode() {
        String str = this.f8717a;
        return this.f8720d.hashCode() + ((this.f8719c.hashCode() + ((((m.x(str, "index_", false) ? -1184239155 : str.hashCode()) * 31) + (this.f8718b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Index{name='" + this.f8717a + "', unique=" + this.f8718b + ", columns=" + this.f8719c + ", orders=" + this.f8720d + "'}";
    }
}
