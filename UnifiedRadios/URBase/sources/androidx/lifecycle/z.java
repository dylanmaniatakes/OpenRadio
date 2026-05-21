package androidx.lifecycle;

import androidx.fragment.app.C0222q;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: j, reason: collision with root package name */
    public final C0222q f3978j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3979k;

    /* renamed from: l, reason: collision with root package name */
    public int f3980l = -1;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ A f3981m;

    public z(A a2, C0222q c0222q) {
        this.f3981m = a2;
        this.f3978j = c0222q;
    }

    public final void b(boolean z4) {
        if (z4 == this.f3979k) {
            return;
        }
        this.f3979k = z4;
        int i5 = z4 ? 1 : -1;
        A a2 = this.f3981m;
        int i6 = a2.f3897c;
        a2.f3897c = i5 + i6;
        if (!a2.f3898d) {
            a2.f3898d = true;
            while (true) {
                try {
                    int i7 = a2.f3897c;
                    if (i6 == i7) {
                        break;
                    } else {
                        i6 = i7;
                    }
                } finally {
                    a2.f3898d = false;
                }
            }
        }
        if (this.f3979k) {
            a2.c(this);
        }
    }

    public void c() {
    }

    public abstract boolean d();
}
