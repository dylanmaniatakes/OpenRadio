package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4356a;

    /* renamed from: b, reason: collision with root package name */
    public int f4357b;

    /* renamed from: c, reason: collision with root package name */
    public int f4358c;

    /* renamed from: d, reason: collision with root package name */
    public int f4359d;

    /* renamed from: e, reason: collision with root package name */
    public int f4360e;

    public final boolean a() {
        int i5 = this.f4356a;
        int i6 = 2;
        if ((i5 & 7) != 0) {
            int i7 = this.f4359d;
            int i8 = this.f4357b;
            if (((i7 > i8 ? 1 : i7 == i8 ? 2 : 4) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 112) != 0) {
            int i9 = this.f4359d;
            int i10 = this.f4358c;
            if ((((i9 > i10 ? 1 : i9 == i10 ? 2 : 4) << 4) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 1792) != 0) {
            int i11 = this.f4360e;
            int i12 = this.f4357b;
            if ((((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) << 8) & i5) == 0) {
                return false;
            }
        }
        if ((i5 & 28672) != 0) {
            int i13 = this.f4360e;
            int i14 = this.f4358c;
            if (i13 > i14) {
                i6 = 1;
            } else if (i13 != i14) {
                i6 = 4;
            }
            if ((i5 & (i6 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
