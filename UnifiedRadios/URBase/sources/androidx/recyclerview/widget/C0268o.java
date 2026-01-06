package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0268o {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4298a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f4299b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC0266m f4300c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4301d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4302e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4303f;

    public C0268o(AbstractC0266m abstractC0266m, ArrayList arrayList, int[] iArr, int[] iArr2) {
        int[] iArr3;
        int[] iArr4;
        AbstractC0266m abstractC0266m2;
        int i5;
        C0267n c0267n;
        int i6;
        this.f4298a = iArr;
        this.f4299b = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.f4300c = abstractC0266m;
        int oldListSize = abstractC0266m.getOldListSize();
        this.f4301d = oldListSize;
        int newListSize = abstractC0266m.getNewListSize();
        this.f4302e = newListSize;
        this.f4303f = true;
        C0267n c0267n2 = arrayList.isEmpty() ? null : (C0267n) arrayList.get(0);
        if (c0267n2 == null || c0267n2.f4295a != 0 || c0267n2.f4296b != 0) {
            arrayList.add(0, new C0267n(0, 0, 0));
        }
        arrayList.add(new C0267n(oldListSize, newListSize, 0));
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            iArr3 = this.f4299b;
            iArr4 = this.f4298a;
            abstractC0266m2 = this.f4300c;
            if (!zHasNext) {
                break;
            }
            C0267n c0267n3 = (C0267n) it.next();
            for (int i7 = 0; i7 < c0267n3.f4297c; i7++) {
                int i8 = c0267n3.f4295a + i7;
                int i9 = c0267n3.f4296b + i7;
                int i10 = abstractC0266m2.areContentsTheSame(i8, i9) ? 1 : 2;
                iArr4[i8] = (i9 << 4) | i10;
                iArr3[i9] = (i8 << 4) | i10;
            }
        }
        if (this.f4303f) {
            Iterator it2 = arrayList.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                C0267n c0267n4 = (C0267n) it2.next();
                while (true) {
                    i5 = c0267n4.f4295a;
                    if (i11 < i5) {
                        if (iArr4[i11] == 0) {
                            int size = arrayList.size();
                            int i12 = 0;
                            int i13 = 0;
                            while (true) {
                                if (i12 < size) {
                                    c0267n = (C0267n) arrayList.get(i12);
                                    while (true) {
                                        i6 = c0267n.f4296b;
                                        if (i13 < i6) {
                                            if (iArr3[i13] == 0 && abstractC0266m2.areItemsTheSame(i11, i13)) {
                                                int i14 = abstractC0266m2.areContentsTheSame(i11, i13) ? 8 : 4;
                                                iArr4[i11] = (i13 << 4) | i14;
                                                iArr3[i13] = i14 | (i11 << 4);
                                            } else {
                                                i13++;
                                            }
                                        }
                                    }
                                }
                                i13 = c0267n.f4297c + i6;
                                i12++;
                            }
                        }
                        i11++;
                    }
                }
                i11 = c0267n4.f4297c + i5;
            }
        }
    }

    public static C0269p a(ArrayDeque arrayDeque, int i5, boolean z4) {
        C0269p c0269p;
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                c0269p = null;
                break;
            }
            c0269p = (C0269p) it.next();
            if (c0269p.f4306a == i5 && c0269p.f4308c == z4) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            C0269p c0269p2 = (C0269p) it.next();
            if (z4) {
                c0269p2.f4307b--;
            } else {
                c0269p2.f4307b++;
            }
        }
        return c0269p;
    }
}
