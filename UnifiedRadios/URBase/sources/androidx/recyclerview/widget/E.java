package androidx.recyclerview.widget;

import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4008a;

    /* renamed from: b, reason: collision with root package name */
    public int f4009b;

    /* renamed from: c, reason: collision with root package name */
    public int f4010c;

    /* renamed from: d, reason: collision with root package name */
    public int f4011d;

    /* renamed from: e, reason: collision with root package name */
    public int f4012e;

    /* renamed from: f, reason: collision with root package name */
    public int f4013f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f4014i;

    /* renamed from: j, reason: collision with root package name */
    public int f4015j;

    /* renamed from: k, reason: collision with root package name */
    public List f4016k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4017l;

    public final void a(View view) {
        int layoutPosition;
        int size = this.f4016k.size();
        View view2 = null;
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < size; i6++) {
            View view3 = ((n0) this.f4016k.get(i6)).itemView;
            Y y4 = (Y) view3.getLayoutParams();
            if (view3 != view && !y4.f4190a.isRemoved() && (layoutPosition = (y4.f4190a.getLayoutPosition() - this.f4011d) * this.f4012e) >= 0 && layoutPosition < i5) {
                view2 = view3;
                if (layoutPosition == 0) {
                    break;
                } else {
                    i5 = layoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f4011d = -1;
        } else {
            this.f4011d = ((Y) view2.getLayoutParams()).f4190a.getLayoutPosition();
        }
    }

    public final View b(d0 d0Var) {
        List list = this.f4016k;
        if (list == null) {
            View view = d0Var.k(this.f4011d, Long.MAX_VALUE).itemView;
            this.f4011d += this.f4012e;
            return view;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = ((n0) this.f4016k.get(i5)).itemView;
            Y y4 = (Y) view2.getLayoutParams();
            if (!y4.f4190a.isRemoved() && this.f4011d == y4.f4190a.getLayoutPosition()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
