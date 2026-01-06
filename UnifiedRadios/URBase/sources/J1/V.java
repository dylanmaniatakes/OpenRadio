package J1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: A, reason: collision with root package name */
    public Long f961A;

    /* renamed from: B, reason: collision with root package name */
    public Long f962B;

    /* renamed from: C, reason: collision with root package name */
    public long f963C;

    /* renamed from: D, reason: collision with root package name */
    public String f964D;

    /* renamed from: E, reason: collision with root package name */
    public int f965E;

    /* renamed from: F, reason: collision with root package name */
    public int f966F;

    /* renamed from: G, reason: collision with root package name */
    public long f967G;

    /* renamed from: H, reason: collision with root package name */
    public String f968H;
    public byte[] I;

    /* renamed from: J, reason: collision with root package name */
    public int f969J;

    /* renamed from: K, reason: collision with root package name */
    public long f970K;

    /* renamed from: L, reason: collision with root package name */
    public long f971L;

    /* renamed from: M, reason: collision with root package name */
    public long f972M;

    /* renamed from: N, reason: collision with root package name */
    public long f973N;

    /* renamed from: O, reason: collision with root package name */
    public long f974O;

    /* renamed from: P, reason: collision with root package name */
    public long f975P;

    /* renamed from: Q, reason: collision with root package name */
    public String f976Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f977R;

    /* renamed from: S, reason: collision with root package name */
    public long f978S;

    /* renamed from: T, reason: collision with root package name */
    public long f979T;

    /* renamed from: a, reason: collision with root package name */
    public final C0113v0 f980a;

    /* renamed from: b, reason: collision with root package name */
    public final String f981b;

    /* renamed from: c, reason: collision with root package name */
    public String f982c;

    /* renamed from: d, reason: collision with root package name */
    public String f983d;

    /* renamed from: e, reason: collision with root package name */
    public String f984e;

    /* renamed from: f, reason: collision with root package name */
    public String f985f;
    public long g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public long f986i;

    /* renamed from: j, reason: collision with root package name */
    public String f987j;

    /* renamed from: k, reason: collision with root package name */
    public long f988k;

    /* renamed from: l, reason: collision with root package name */
    public String f989l;

    /* renamed from: m, reason: collision with root package name */
    public long f990m;
    public long n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f991o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f992p;

    /* renamed from: q, reason: collision with root package name */
    public String f993q;

    /* renamed from: r, reason: collision with root package name */
    public Boolean f994r;

    /* renamed from: s, reason: collision with root package name */
    public long f995s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f996t;

    /* renamed from: u, reason: collision with root package name */
    public String f997u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f998v;

    /* renamed from: w, reason: collision with root package name */
    public long f999w;

    /* renamed from: x, reason: collision with root package name */
    public long f1000x;

    /* renamed from: y, reason: collision with root package name */
    public int f1001y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1002z;

    public V(C0113v0 c0113v0, String str) {
        q1.E.i(c0113v0);
        q1.E.f(str);
        this.f980a = c0113v0;
        this.f981b = str;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
    }

    public final void A(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f975P != j5;
        this.f975P = j5;
    }

    public final void B(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f970K != j5;
        this.f970K = j5;
    }

    public final void C(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.n != j5;
        this.n = j5;
    }

    public final void D(int i5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f965E != i5;
        this.f965E = i5;
    }

    public final void E(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f995s != j5;
        this.f995s = j5;
    }

    public final void F(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f979T != j5;
        this.f979T = j5;
    }

    public final void G(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= !Objects.equals(this.f985f, str);
        this.f985f = str;
    }

    public final void H(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f977R |= true ^ Objects.equals(this.f983d, str);
        this.f983d = str;
    }

    public final void I(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f990m != j5;
        this.f990m = j5;
    }

    public final void J(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= !Objects.equals(this.f976Q, str);
        this.f976Q = str;
    }

    public final void K(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f967G != j5;
        this.f967G = j5;
    }

    public final void L(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f986i != j5;
        this.f986i = j5;
    }

    public final void M(long j5) {
        q1.E.a(j5 >= 0);
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.g != j5;
        this.g = j5;
    }

    public final void N(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.h != j5;
        this.h = j5;
    }

    public final void O(boolean z4) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f991o != z4;
        this.f991o = z4;
    }

    public final void P(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= !Objects.equals(this.f984e, str);
        this.f984e = str;
    }

    public final void Q(List list) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        if (Objects.equals(this.f996t, list)) {
            return;
        }
        this.f977R = true;
        this.f996t = list != null ? new ArrayList(list) : null;
    }

    public final int R() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f969J;
    }

    public final long S() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f988k;
    }

    public final long T() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f995s;
    }

    public final Boolean U() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f994r;
    }

    public final String a() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f993q;
    }

    public final String b() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        String str = this.f976Q;
        J(null);
        return str;
    }

    public final String c() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f981b;
    }

    public final String d() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f982c;
    }

    public final String e() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f987j;
    }

    public final String f() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f985f;
    }

    public final String g() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f983d;
    }

    public final String h() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f968H;
    }

    public final String i() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f964D;
    }

    public final void j(long j5) {
        C0113v0 c0113v0 = this.f980a;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        long j6 = this.g + j5;
        String str = this.f981b;
        Z z4 = c0113v0.f1417k;
        if (j6 > 2147483647L) {
            C0113v0.k(z4);
            z4.f1080k.b(Z.q(str), "Bundle index overflow. appId");
            j6 = (-1) + j5;
        }
        long j7 = this.f967G + 1;
        if (j7 > 2147483647L) {
            C0113v0.k(z4);
            z4.f1080k.b(Z.q(str), "Delivery index overflow. appId");
            j7 = 0;
        }
        this.f977R = true;
        this.g = j6;
        this.f967G = j7;
    }

    public final void k(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f977R |= true ^ Objects.equals(this.f993q, str);
        this.f993q = str;
    }

    public final void l(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= !Objects.equals(this.f982c, str);
        this.f982c = str;
    }

    public final void m(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= !Objects.equals(this.f989l, str);
        this.f989l = str;
    }

    public final void n(String str) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= !Objects.equals(this.f987j, str);
        this.f987j = str;
    }

    public final void o(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f988k != j5;
        this.f988k = j5;
    }

    public final void p(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f963C != j5;
        this.f963C = j5;
    }

    public final void q(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f1000x != j5;
        this.f1000x = j5;
    }

    public final void r(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f999w != j5;
        this.f999w = j5;
    }

    public final boolean s() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f977R;
    }

    public final boolean t() {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        return this.f998v;
    }

    public final void u(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f978S != j5;
        this.f978S = j5;
    }

    public final void v(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f973N != j5;
        this.f973N = j5;
    }

    public final void w(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f974O != j5;
        this.f974O = j5;
    }

    public final void x(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f972M != j5;
        this.f972M = j5;
    }

    public final void y(long j5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f971L != j5;
        this.f971L = j5;
    }

    public final void z(int i5) {
        C0104s0 c0104s0 = this.f980a.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        this.f977R |= this.f966F != i5;
        this.f966F = i5;
    }
}
