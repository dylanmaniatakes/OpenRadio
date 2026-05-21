package J3;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: m, reason: collision with root package name */
    public static final c f1482m = new c(1, 0, 1);

    public final boolean a(int i5) {
        return this.f1475j <= i5 && i5 <= this.f1476k;
    }

    @Override // J3.a
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f1475j == cVar.f1475j) {
                    if (this.f1476k == cVar.f1476k) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // J3.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f1475j * 31) + this.f1476k;
    }

    @Override // J3.a
    public final boolean isEmpty() {
        return this.f1475j > this.f1476k;
    }

    @Override // J3.a
    public final String toString() {
        return this.f1475j + ".." + this.f1476k;
    }
}
