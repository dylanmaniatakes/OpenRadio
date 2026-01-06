package Q1;

import O.Y;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.X;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f2168a;

    /* renamed from: b, reason: collision with root package name */
    public int f2169b;

    /* renamed from: c, reason: collision with root package name */
    public int f2170c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2171d;

    public void a(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i7 = this.f2170c;
        int i8 = i7 * 2;
        int[] iArr = (int[]) this.f2171d;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f2171d = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i8 >= iArr.length) {
            int[] iArr3 = new int[i7 * 4];
            this.f2171d = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.f2171d;
        iArr4[i8] = i5;
        iArr4[i8 + 1] = i6;
        this.f2170c++;
    }

    public void b() {
        int i5 = this.f2170c;
        View view = (View) this.f2171d;
        int top = i5 - (view.getTop() - this.f2168a);
        WeakHashMap weakHashMap = Y.f1904a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f2169b));
    }

    public void c(RecyclerView recyclerView, boolean z4) {
        this.f2170c = 0;
        int[] iArr = (int[]) this.f2171d;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        X x4 = recyclerView.f4125p;
        if (recyclerView.f4123o == null || x4 == null || !x4.f4184i) {
            return;
        }
        if (z4) {
            if (!recyclerView.g.j()) {
                x4.i(recyclerView.f4123o.getItemCount(), this);
            }
        } else if (!recyclerView.O()) {
            x4.h(this.f2168a, this.f2169b, recyclerView.f4115j0, this);
        }
        int i5 = this.f2170c;
        if (i5 > x4.f4185j) {
            x4.f4185j = i5;
            x4.f4186k = z4;
            recyclerView.f4106e.m();
        }
    }
}
