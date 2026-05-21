package u3;

import F3.i;
import java.util.Map;

/* renamed from: u3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0913d implements Map.Entry, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final C0914e f9946j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9947k;

    public C0913d(C0914e c0914e, int i5) {
        i.f(c0914e, "map");
        this.f9946j = c0914e;
        this.f9947k = i5;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (i.a(entry.getKey(), getKey()) && i.a(entry.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f9946j.f9949j[this.f9947k];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object[] objArr = this.f9946j.f9950k;
        i.c(objArr);
        return objArr[this.f9947k];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        C0914e c0914e = this.f9946j;
        c0914e.c();
        Object[] objArr = c0914e.f9950k;
        if (objArr == null) {
            int length = c0914e.f9949j.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.".toString());
            }
            objArr = new Object[length];
            c0914e.f9950k = objArr;
        }
        int i5 = this.f9947k;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
