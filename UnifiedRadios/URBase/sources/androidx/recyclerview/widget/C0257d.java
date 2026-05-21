package androidx.recyclerview.widget;

/* renamed from: androidx.recyclerview.widget.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0257d implements H {

    /* renamed from: a, reason: collision with root package name */
    public final H f4212a;

    /* renamed from: b, reason: collision with root package name */
    public int f4213b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f4214c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f4215d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f4216e = null;

    public C0257d(C0256c c0256c) {
        this.f4212a = c0256c;
    }

    @Override // androidx.recyclerview.widget.H
    public final void a(int i5, int i6) {
        int i7;
        if (this.f4213b == 2 && (i7 = this.f4214c) >= i5 && i7 <= i5 + i6) {
            this.f4215d += i6;
            this.f4214c = i5;
        } else {
            e();
            this.f4214c = i5;
            this.f4215d = i6;
            this.f4213b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.H
    public final void b(int i5, int i6) {
        e();
        this.f4212a.b(i5, i6);
    }

    @Override // androidx.recyclerview.widget.H
    public final void c(int i5, int i6) {
        int i7;
        if (this.f4213b == 1 && i5 >= (i7 = this.f4214c)) {
            int i8 = this.f4215d;
            if (i5 <= i7 + i8) {
                this.f4215d = i8 + i6;
                this.f4214c = Math.min(i5, i7);
                return;
            }
        }
        e();
        this.f4214c = i5;
        this.f4215d = i6;
        this.f4213b = 1;
    }

    @Override // androidx.recyclerview.widget.H
    public final void d(int i5, int i6, Object obj) {
        int i7;
        if (this.f4213b == 3) {
            int i8 = this.f4214c;
            int i9 = this.f4215d;
            if (i5 <= i8 + i9 && (i7 = i5 + i6) >= i8 && this.f4216e == obj) {
                this.f4214c = Math.min(i5, i8);
                this.f4215d = Math.max(i9 + i8, i7) - this.f4214c;
                return;
            }
        }
        e();
        this.f4214c = i5;
        this.f4215d = i6;
        this.f4216e = obj;
        this.f4213b = 3;
    }

    public final void e() {
        int i5 = this.f4213b;
        if (i5 == 0) {
            return;
        }
        H h = this.f4212a;
        if (i5 == 1) {
            h.c(this.f4214c, this.f4215d);
        } else if (i5 == 2) {
            h.a(this.f4214c, this.f4215d);
        } else if (i5 == 3) {
            h.d(this.f4214c, this.f4215d, this.f4216e);
        }
        this.f4216e = null;
        this.f4213b = 0;
    }
}
