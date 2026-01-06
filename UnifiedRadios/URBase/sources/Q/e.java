package q;

/* loaded from: classes.dex */
public final class e implements Cloneable {
    public static final Object n = new Object();

    /* renamed from: j, reason: collision with root package name */
    public boolean f9253j = false;

    /* renamed from: k, reason: collision with root package name */
    public long[] f9254k;

    /* renamed from: l, reason: collision with root package name */
    public Object[] f9255l;

    /* renamed from: m, reason: collision with root package name */
    public int f9256m;

    public e() {
        int i5;
        int i6 = 4;
        while (true) {
            i5 = 80;
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (80 <= i7) {
                i5 = i7;
                break;
            }
            i6++;
        }
        int i8 = i5 / 8;
        this.f9254k = new long[i8];
        this.f9255l = new Object[i8];
    }

    public final void a() {
        int i5 = this.f9256m;
        Object[] objArr = this.f9255l;
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = null;
        }
        this.f9256m = 0;
        this.f9253j = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final e clone() {
        try {
            e eVar = (e) super.clone();
            eVar.f9254k = (long[]) this.f9254k.clone();
            eVar.f9255l = (Object[]) this.f9255l.clone();
            return eVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public final void c() {
        int i5 = this.f9256m;
        long[] jArr = this.f9254k;
        Object[] objArr = this.f9255l;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != n) {
                if (i7 != i6) {
                    jArr[i6] = jArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        this.f9253j = false;
        this.f9256m = i6;
    }

    public final Object d(long j5, Long l5) {
        Object obj;
        int iB = d.b(this.f9254k, this.f9256m, j5);
        return (iB < 0 || (obj = this.f9255l[iB]) == n) ? l5 : obj;
    }

    public final long e(int i5) {
        if (this.f9253j) {
            c();
        }
        return this.f9254k[i5];
    }

    public final void f(long j5, Object obj) {
        int iB = d.b(this.f9254k, this.f9256m, j5);
        if (iB >= 0) {
            this.f9255l[iB] = obj;
            return;
        }
        int i5 = ~iB;
        int i6 = this.f9256m;
        if (i5 < i6) {
            Object[] objArr = this.f9255l;
            if (objArr[i5] == n) {
                this.f9254k[i5] = j5;
                objArr[i5] = obj;
                return;
            }
        }
        if (this.f9253j && i6 >= this.f9254k.length) {
            c();
            i5 = ~d.b(this.f9254k, this.f9256m, j5);
        }
        int i7 = this.f9256m;
        if (i7 >= this.f9254k.length) {
            int i8 = (i7 + 1) * 8;
            int i9 = 4;
            while (true) {
                if (i9 >= 32) {
                    break;
                }
                int i10 = (1 << i9) - 12;
                if (i8 <= i10) {
                    i8 = i10;
                    break;
                }
                i9++;
            }
            int i11 = i8 / 8;
            long[] jArr = new long[i11];
            Object[] objArr2 = new Object[i11];
            long[] jArr2 = this.f9254k;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f9255l;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f9254k = jArr;
            this.f9255l = objArr2;
        }
        int i12 = this.f9256m - i5;
        if (i12 != 0) {
            long[] jArr3 = this.f9254k;
            int i13 = i5 + 1;
            System.arraycopy(jArr3, i5, jArr3, i13, i12);
            Object[] objArr4 = this.f9255l;
            System.arraycopy(objArr4, i5, objArr4, i13, this.f9256m - i5);
        }
        this.f9254k[i5] = j5;
        this.f9255l[i5] = obj;
        this.f9256m++;
    }

    public final void g(long j5) {
        int iB = d.b(this.f9254k, this.f9256m, j5);
        if (iB >= 0) {
            Object[] objArr = this.f9255l;
            Object obj = objArr[iB];
            Object obj2 = n;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f9253j = true;
            }
        }
    }

    public final int h() {
        if (this.f9253j) {
            c();
        }
        return this.f9256m;
    }

    public final Object i(int i5) {
        if (this.f9253j) {
            c();
        }
        return this.f9255l[i5];
    }

    public final String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f9256m * 28);
        sb.append('{');
        for (int i5 = 0; i5 < this.f9256m; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(e(i5));
            sb.append('=');
            Object objI = i(i5);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
