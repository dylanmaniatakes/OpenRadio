package L0;

import C0.t;
import androidx.work.OverwritingInputMerger;
import g0.AbstractC0535a;
import okhttp3.internal.http2.Http2;
import org.conscrypt.PSKKeyManager;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f1561a;

    /* renamed from: b, reason: collision with root package name */
    public int f1562b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1563c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1564d;

    /* renamed from: e, reason: collision with root package name */
    public final C0.h f1565e;

    /* renamed from: f, reason: collision with root package name */
    public final C0.h f1566f;
    public final long g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final long f1567i;

    /* renamed from: j, reason: collision with root package name */
    public final C0.d f1568j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1569k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1570l;

    /* renamed from: m, reason: collision with root package name */
    public final long f1571m;
    public long n;

    /* renamed from: o, reason: collision with root package name */
    public final long f1572o;

    /* renamed from: p, reason: collision with root package name */
    public final long f1573p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1574q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1575r;

    /* renamed from: s, reason: collision with root package name */
    public final int f1576s;

    /* renamed from: t, reason: collision with root package name */
    public final int f1577t;

    /* renamed from: u, reason: collision with root package name */
    public final long f1578u;

    /* renamed from: v, reason: collision with root package name */
    public final int f1579v;

    /* renamed from: w, reason: collision with root package name */
    public final int f1580w;

    static {
        F3.i.e(t.f("WorkSpec"), "tagWithPrefix(\"WorkSpec\")");
    }

    public o(String str, int i5, String str2, String str3, C0.h hVar, C0.h hVar2, long j5, long j6, long j7, C0.d dVar, int i6, int i7, long j8, long j9, long j10, long j11, boolean z4, int i8, int i9, int i10, long j12, int i11, int i12) {
        F3.i.f(str, "id");
        AbstractC0535a.p(i5, "state");
        F3.i.f(str2, "workerClassName");
        F3.i.f(str3, "inputMergerClassName");
        F3.i.f(hVar, "input");
        F3.i.f(hVar2, "output");
        F3.i.f(dVar, "constraints");
        AbstractC0535a.p(i7, "backoffPolicy");
        AbstractC0535a.p(i8, "outOfQuotaPolicy");
        this.f1561a = str;
        this.f1562b = i5;
        this.f1563c = str2;
        this.f1564d = str3;
        this.f1565e = hVar;
        this.f1566f = hVar2;
        this.g = j5;
        this.h = j6;
        this.f1567i = j7;
        this.f1568j = dVar;
        this.f1569k = i6;
        this.f1570l = i7;
        this.f1571m = j8;
        this.n = j9;
        this.f1572o = j10;
        this.f1573p = j11;
        this.f1574q = z4;
        this.f1575r = i8;
        this.f1576s = i9;
        this.f1577t = i10;
        this.f1578u = j12;
        this.f1579v = i11;
        this.f1580w = i12;
    }

    public final long a() {
        boolean z4 = this.f1562b == 1 && this.f1569k > 0;
        long j5 = this.n;
        boolean zC = c();
        int i5 = this.f1570l;
        AbstractC0535a.p(i5, "backoffPolicy");
        long j6 = this.f1578u;
        long j7 = Long.MAX_VALUE;
        int i6 = this.f1576s;
        if (j6 != Long.MAX_VALUE && zC) {
            if (i6 == 0) {
                return j6;
            }
            long j8 = j5 + 900000;
            return j6 < j8 ? j8 : j6;
        }
        if (z4) {
            int i7 = this.f1569k;
            long j9 = this.f1571m;
            long jScalb = i5 == 2 ? j9 * i7 : (long) Math.scalb(j9, i7 - 1);
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            j7 = jScalb + j5;
        } else {
            long j10 = this.g;
            if (zC) {
                long j11 = this.h;
                long j12 = i6 == 0 ? j5 + j10 : j5 + j11;
                long j13 = this.f1567i;
                j7 = (j13 == j11 || i6 != 0) ? j12 : (j11 - j13) + j12;
            } else if (j5 != -1) {
                j7 = j5 + j10;
            }
        }
        return j7;
    }

    public final boolean b() {
        return !F3.i.a(C0.d.f142i, this.f1568j);
    }

    public final boolean c() {
        return this.h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return F3.i.a(this.f1561a, oVar.f1561a) && this.f1562b == oVar.f1562b && F3.i.a(this.f1563c, oVar.f1563c) && F3.i.a(this.f1564d, oVar.f1564d) && F3.i.a(this.f1565e, oVar.f1565e) && F3.i.a(this.f1566f, oVar.f1566f) && this.g == oVar.g && this.h == oVar.h && this.f1567i == oVar.f1567i && F3.i.a(this.f1568j, oVar.f1568j) && this.f1569k == oVar.f1569k && this.f1570l == oVar.f1570l && this.f1571m == oVar.f1571m && this.n == oVar.n && this.f1572o == oVar.f1572o && this.f1573p == oVar.f1573p && this.f1574q == oVar.f1574q && this.f1575r == oVar.f1575r && this.f1576s == oVar.f1576s && this.f1577t == oVar.f1577t && this.f1578u == oVar.f1578u && this.f1579v == oVar.f1579v && this.f1580w == oVar.f1580w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = (Long.hashCode(this.f1573p) + ((Long.hashCode(this.f1572o) + ((Long.hashCode(this.n) + ((Long.hashCode(this.f1571m) + ((AbstractC0882e.c(this.f1570l) + ((Integer.hashCode(this.f1569k) + ((this.f1568j.hashCode() + ((Long.hashCode(this.f1567i) + ((Long.hashCode(this.h) + ((Long.hashCode(this.g) + ((this.f1566f.hashCode() + ((this.f1565e.hashCode() + ((this.f1564d.hashCode() + ((this.f1563c.hashCode() + ((AbstractC0882e.c(this.f1562b) + (this.f1561a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z4 = this.f1574q;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        return Integer.hashCode(this.f1580w) + ((Integer.hashCode(this.f1579v) + ((Long.hashCode(this.f1578u) + ((Integer.hashCode(this.f1577t) + ((Integer.hashCode(this.f1576s) + ((AbstractC0882e.c(this.f1575r) + ((iHashCode + i5) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "{WorkSpec: " + this.f1561a + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ o(String str, int i5, String str2, String str3, C0.h hVar, C0.h hVar2, long j5, long j6, long j7, C0.d dVar, int i6, int i7, long j8, long j9, long j10, long j11, boolean z4, int i8, int i9, long j12, int i10, int i11, int i12) {
        C0.h hVar3;
        C0.h hVar4;
        int i13 = (i12 & 2) != 0 ? 1 : i5;
        String name = (i12 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3;
        if ((i12 & 16) != 0) {
            C0.h hVar5 = C0.h.f157c;
            F3.i.e(hVar5, "EMPTY");
            hVar3 = hVar5;
        } else {
            hVar3 = hVar;
        }
        if ((i12 & 32) != 0) {
            C0.h hVar6 = C0.h.f157c;
            F3.i.e(hVar6, "EMPTY");
            hVar4 = hVar6;
        } else {
            hVar4 = hVar2;
        }
        this(str, i13, str2, name, hVar3, hVar4, (i12 & 64) != 0 ? 0L : j5, (i12 & 128) != 0 ? 0L : j6, (i12 & PSKKeyManager.MAX_KEY_LENGTH_BYTES) != 0 ? 0L : j7, (i12 & 512) != 0 ? C0.d.f142i : dVar, (i12 & 1024) != 0 ? 0 : i6, (i12 & 2048) != 0 ? 1 : i7, (i12 & 4096) != 0 ? 30000L : j8, (i12 & 8192) != 0 ? -1L : j9, (i12 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? 0L : j10, (32768 & i12) != 0 ? -1L : j11, (65536 & i12) != 0 ? false : z4, (131072 & i12) == 0 ? i8 : 1, (262144 & i12) != 0 ? 0 : i9, 0, (1048576 & i12) != 0 ? Long.MAX_VALUE : j12, (2097152 & i12) != 0 ? 0 : i10, (i12 & 4194304) != 0 ? -256 : i11);
    }
}
