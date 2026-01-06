package n0;

import F3.i;
import java.util.List;

/* renamed from: n0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0780b {

    /* renamed from: a, reason: collision with root package name */
    public final String f8708a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8709b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8710c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8711d;

    /* renamed from: e, reason: collision with root package name */
    public final List f8712e;

    public C0780b(String str, String str2, String str3, List list, List list2) {
        i.f(list, "columnNames");
        i.f(list2, "referenceColumnNames");
        this.f8708a = str;
        this.f8709b = str2;
        this.f8710c = str3;
        this.f8711d = list;
        this.f8712e = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0780b)) {
            return false;
        }
        C0780b c0780b = (C0780b) obj;
        if (i.a(this.f8708a, c0780b.f8708a) && i.a(this.f8709b, c0780b.f8709b) && i.a(this.f8710c, c0780b.f8710c) && i.a(this.f8711d, c0780b.f8711d)) {
            return i.a(this.f8712e, c0780b.f8712e);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8712e.hashCode() + ((this.f8711d.hashCode() + ((this.f8710c.hashCode() + ((this.f8709b.hashCode() + (this.f8708a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ForeignKey{referenceTable='" + this.f8708a + "', onDelete='" + this.f8709b + " +', onUpdate='" + this.f8710c + "', columnNames=" + this.f8711d + ", referenceColumnNames=" + this.f8712e + '}';
    }
}
