package l0;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: l0.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0738n implements p0.e, p0.d {

    /* renamed from: r, reason: collision with root package name */
    public static final TreeMap f8374r = new TreeMap();

    /* renamed from: j, reason: collision with root package name */
    public final int f8375j;

    /* renamed from: k, reason: collision with root package name */
    public volatile String f8376k;

    /* renamed from: l, reason: collision with root package name */
    public final long[] f8377l;

    /* renamed from: m, reason: collision with root package name */
    public final double[] f8378m;
    public final String[] n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[][] f8379o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f8380p;

    /* renamed from: q, reason: collision with root package name */
    public int f8381q;

    public C0738n(int i5) {
        this.f8375j = i5;
        int i6 = i5 + 1;
        this.f8380p = new int[i6];
        this.f8377l = new long[i6];
        this.f8378m = new double[i6];
        this.n = new String[i6];
        this.f8379o = new byte[i6][];
    }

    public static final C0738n o(int i5, String str) {
        TreeMap treeMap = f8374r;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i5));
            if (entryCeilingEntry == null) {
                C0738n c0738n = new C0738n(i5);
                c0738n.f8376k = str;
                c0738n.f8381q = i5;
                return c0738n;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            C0738n c0738n2 = (C0738n) entryCeilingEntry.getValue();
            c0738n2.f8376k = str;
            c0738n2.f8381q = i5;
            return c0738n2;
        }
    }

    @Override // p0.d
    public final void I(int i5, long j5) {
        this.f8380p[i5] = 2;
        this.f8377l[i5] = j5;
    }

    @Override // p0.d
    public final void M(int i5, byte[] bArr) {
        this.f8380p[i5] = 5;
        this.f8379o[i5] = bArr;
    }

    @Override // p0.e
    public final String a() {
        String str = this.f8376k;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // p0.e
    public final void c(p0.d dVar) {
        int i5 = this.f8381q;
        if (1 > i5) {
            return;
        }
        int i6 = 1;
        while (true) {
            int i7 = this.f8380p[i6];
            if (i7 == 1) {
                dVar.t(i6);
            } else if (i7 == 2) {
                dVar.I(i6, this.f8377l[i6]);
            } else if (i7 == 3) {
                dVar.v(i6, this.f8378m[i6]);
            } else if (i7 == 4) {
                String str = this.n[i6];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                dVar.h(i6, str);
            } else if (i7 == 5) {
                byte[] bArr = this.f8379o[i6];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                dVar.M(i6, bArr);
            }
            if (i6 == i5) {
                return;
            } else {
                i6++;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // p0.d
    public final void h(int i5, String str) {
        F3.i.f(str, "value");
        this.f8380p[i5] = 4;
        this.n[i5] = str;
    }

    public final void s() {
        TreeMap treeMap = f8374r;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f8375j), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                F3.i.e(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i5 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i5;
                }
            }
        }
    }

    @Override // p0.d
    public final void t(int i5) {
        this.f8380p[i5] = 1;
    }

    @Override // p0.d
    public final void v(int i5, double d5) {
        this.f8380p[i5] = 3;
        this.f8378m[i5] = d5;
    }
}
