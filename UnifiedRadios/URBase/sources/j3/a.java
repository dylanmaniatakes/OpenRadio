package J3;

import java.util.Iterator;

/* loaded from: classes.dex */
public class a implements Iterable, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final int f1475j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1476k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1477l;

    public a(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f1475j = i5;
        this.f1476k = h4.c.w(i5, i6, i7);
        this.f1477l = i7;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f1475j != aVar.f1475j || this.f1476k != aVar.f1476k || this.f1477l != aVar.f1477l) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f1475j * 31) + this.f1476k) * 31) + this.f1477l;
    }

    public boolean isEmpty() {
        int i5 = this.f1477l;
        int i6 = this.f1476k;
        int i7 = this.f1475j;
        if (i5 > 0) {
            if (i7 <= i6) {
                return false;
            }
        } else if (i7 >= i6) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f1475j, this.f1476k, this.f1477l);
    }

    public String toString() {
        StringBuilder sb;
        int i5 = this.f1476k;
        int i6 = this.f1475j;
        int i7 = this.f1477l;
        if (i7 > 0) {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append("..");
            sb.append(i5);
            sb.append(" step ");
            sb.append(i7);
        } else {
            sb = new StringBuilder();
            sb.append(i6);
            sb.append(" downTo ");
            sb.append(i5);
            sb.append(" step ");
            sb.append(-i7);
        }
        return sb.toString();
    }
}
