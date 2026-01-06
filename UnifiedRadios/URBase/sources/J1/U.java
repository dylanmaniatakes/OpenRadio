package J1;

import f3.C0513e;
import java.util.concurrent.atomic.AtomicLong;
import u1.C0906a;

/* loaded from: classes.dex */
public final /* synthetic */ class U implements N1.f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f953c;

    /* renamed from: d, reason: collision with root package name */
    public long f954d;

    /* renamed from: e, reason: collision with root package name */
    public Object f955e;

    public /* synthetic */ U(C0513e c0513e, long j5) {
        this.f953c = 0;
        this.f955e = c0513e;
        this.f954d = j5;
    }

    public void a(int i5) {
        if (i5 < 64) {
            this.f954d &= ~(1 << i5);
            return;
        }
        U u4 = (U) this.f955e;
        if (u4 != null) {
            u4.a(i5 - 64);
        }
    }

    public int b(int i5) {
        U u4 = (U) this.f955e;
        if (u4 == null) {
            return i5 >= 64 ? Long.bitCount(this.f954d) : Long.bitCount(this.f954d & ((1 << i5) - 1));
        }
        if (i5 < 64) {
            return Long.bitCount(this.f954d & ((1 << i5) - 1));
        }
        return Long.bitCount(this.f954d) + u4.b(i5 - 64);
    }

    public void c() {
        if (((U) this.f955e) == null) {
            this.f955e = new U();
        }
    }

    @Override // N1.f
    public void d(Exception exc) {
        ((AtomicLong) ((C0513e) this.f955e).f6688e).set(this.f954d);
    }

    public boolean e(int i5) {
        if (i5 < 64) {
            return (this.f954d & (1 << i5)) != 0;
        }
        c();
        return ((U) this.f955e).e(i5 - 64);
    }

    public void f(int i5, boolean z4) {
        if (i5 >= 64) {
            c();
            ((U) this.f955e).f(i5 - 64, z4);
            return;
        }
        long j5 = this.f954d;
        boolean z5 = (Long.MIN_VALUE & j5) != 0;
        long j6 = (1 << i5) - 1;
        this.f954d = ((j5 & (~j6)) << 1) | (j5 & j6);
        if (z4) {
            i(i5);
        } else {
            a(i5);
        }
        if (z5 || ((U) this.f955e) != null) {
            c();
            ((U) this.f955e).f(0, z5);
        }
    }

    public boolean g(int i5) {
        if (i5 >= 64) {
            c();
            return ((U) this.f955e).g(i5 - 64);
        }
        long j5 = 1 << i5;
        long j6 = this.f954d;
        boolean z4 = (j6 & j5) != 0;
        long j7 = j6 & (~j5);
        this.f954d = j7;
        long j8 = j5 - 1;
        this.f954d = (j7 & j8) | Long.rotateRight((~j8) & j7, 1);
        U u4 = (U) this.f955e;
        if (u4 != null) {
            if (u4.e(0)) {
                i(63);
            }
            ((U) this.f955e).g(0);
        }
        return z4;
    }

    public void h() {
        this.f954d = 0L;
        U u4 = (U) this.f955e;
        if (u4 != null) {
            u4.h();
        }
    }

    public void i(int i5) {
        if (i5 < 64) {
            this.f954d |= 1 << i5;
        } else {
            c();
            ((U) this.f955e).i(i5 - 64);
        }
    }

    public String toString() {
        switch (this.f953c) {
            case 2:
                if (((U) this.f955e) == null) {
                    return Long.toBinaryString(this.f954d);
                }
                return ((U) this.f955e).toString() + "xx" + Long.toBinaryString(this.f954d);
            default:
                return super.toString();
        }
    }

    public U(C0906a c0906a) {
        this.f953c = 1;
        q1.E.i(c0906a);
        this.f955e = c0906a;
    }

    public U() {
        this.f953c = 2;
        this.f954d = 0L;
    }
}
