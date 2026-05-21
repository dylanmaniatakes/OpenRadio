package W;

import J1.C;
import P.j;
import android.graphics.Rect;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2548a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f2549b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2550c;

    /* renamed from: d, reason: collision with root package name */
    public final C f2551d;

    public c(boolean z4, C c2) {
        this.f2550c = z4;
        this.f2551d = c2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f2551d.getClass();
        Rect rect = this.f2548a;
        ((j) obj).d(rect);
        Rect rect2 = this.f2549b;
        ((j) obj2).d(rect2);
        int i5 = rect.top;
        int i6 = rect2.top;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.left;
        int i8 = rect2.left;
        boolean z4 = this.f2550c;
        if (i7 < i8) {
            return z4 ? 1 : -1;
        }
        if (i7 > i8) {
            return z4 ? -1 : 1;
        }
        int i9 = rect.bottom;
        int i10 = rect2.bottom;
        if (i9 < i10) {
            return -1;
        }
        if (i9 > i10) {
            return 1;
        }
        int i11 = rect.right;
        int i12 = rect2.right;
        if (i11 < i12) {
            return z4 ? 1 : -1;
        }
        if (i11 > i12) {
            return z4 ? -1 : 1;
        }
        return 0;
    }
}
