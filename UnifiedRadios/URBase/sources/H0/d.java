package H0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f646a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f647b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f648c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f649d;

    public d(boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f646a = z4;
        this.f647b = z5;
        this.f648c = z6;
        this.f649d = z7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f646a == dVar.f646a && this.f647b == dVar.f647b && this.f648c == dVar.f648c && this.f649d == dVar.f649d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z4 = this.f646a;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = i5 * 31;
        boolean z5 = this.f647b;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z6 = this.f648c;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z7 = this.f649d;
        return i10 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f646a + ", isValidated=" + this.f647b + ", isMetered=" + this.f648c + ", isNotRoaming=" + this.f649d + ')';
    }
}
