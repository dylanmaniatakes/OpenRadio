package q;

/* loaded from: classes.dex */
public final class l implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f9279m = new Object();

    /* renamed from: j, reason: collision with root package name */
    public int[] f9280j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f9281k;

    /* renamed from: l, reason: collision with root package name */
    public int f9282l;

    public l() {
        int i5;
        int i6 = 4;
        while (true) {
            i5 = 40;
            if (i6 >= 32) {
                break;
            }
            int i7 = (1 << i6) - 12;
            if (40 <= i7) {
                i5 = i7;
                break;
            }
            i6++;
        }
        int i8 = i5 / 4;
        this.f9280j = new int[i8];
        this.f9281k = new Object[i8];
    }

    public final void a(int i5, Object obj) {
        int i6 = this.f9282l;
        if (i6 != 0 && i5 <= this.f9280j[i6 - 1]) {
            d(i5, obj);
            return;
        }
        if (i6 >= this.f9280j.length) {
            int i7 = (i6 + 1) * 4;
            int i8 = 4;
            while (true) {
                if (i8 >= 32) {
                    break;
                }
                int i9 = (1 << i8) - 12;
                if (i7 <= i9) {
                    i7 = i9;
                    break;
                }
                i8++;
            }
            int i10 = i7 / 4;
            int[] iArr = new int[i10];
            Object[] objArr = new Object[i10];
            int[] iArr2 = this.f9280j;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f9281k;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f9280j = iArr;
            this.f9281k = objArr;
        }
        this.f9280j[i6] = i5;
        this.f9281k[i6] = obj;
        this.f9282l = i6 + 1;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final l clone() {
        try {
            l lVar = (l) super.clone();
            lVar.f9280j = (int[]) this.f9280j.clone();
            lVar.f9281k = (Object[]) this.f9281k.clone();
            return lVar;
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public final Object c(int i5, Integer num) {
        Object obj;
        int iA = d.a(this.f9282l, i5, this.f9280j);
        return (iA < 0 || (obj = this.f9281k[iA]) == f9279m) ? num : obj;
    }

    public final void d(int i5, Object obj) {
        int iA = d.a(this.f9282l, i5, this.f9280j);
        if (iA >= 0) {
            this.f9281k[iA] = obj;
            return;
        }
        int i6 = ~iA;
        int i7 = this.f9282l;
        if (i6 < i7) {
            Object[] objArr = this.f9281k;
            if (objArr[i6] == f9279m) {
                this.f9280j[i6] = i5;
                objArr[i6] = obj;
                return;
            }
        }
        if (i7 >= this.f9280j.length) {
            int i8 = (i7 + 1) * 4;
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
            int i11 = i8 / 4;
            int[] iArr = new int[i11];
            Object[] objArr2 = new Object[i11];
            int[] iArr2 = this.f9280j;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f9281k;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f9280j = iArr;
            this.f9281k = objArr2;
        }
        int i12 = this.f9282l - i6;
        if (i12 != 0) {
            int[] iArr3 = this.f9280j;
            int i13 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i13, i12);
            Object[] objArr4 = this.f9281k;
            System.arraycopy(objArr4, i6, objArr4, i13, this.f9282l - i6);
        }
        this.f9280j[i6] = i5;
        this.f9281k[i6] = obj;
        this.f9282l++;
    }

    public final String toString() {
        int i5 = this.f9282l;
        if (i5 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i5 * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f9282l; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(this.f9280j[i6]);
            sb.append('=');
            Object obj = this.f9281k[i6];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
