package m;

import java.util.Map;

/* renamed from: m.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0755c implements Map.Entry {

    /* renamed from: j, reason: collision with root package name */
    public final Object f8497j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f8498k;

    /* renamed from: l, reason: collision with root package name */
    public C0755c f8499l;

    /* renamed from: m, reason: collision with root package name */
    public C0755c f8500m;

    public C0755c(Object obj, Object obj2) {
        this.f8497j = obj;
        this.f8498k = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0755c)) {
            return false;
        }
        C0755c c0755c = (C0755c) obj;
        return this.f8497j.equals(c0755c.f8497j) && this.f8498k.equals(c0755c.f8498k);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8497j;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8498k;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f8497j.hashCode() ^ this.f8498k.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f8497j + "=" + this.f8498k;
    }
}
