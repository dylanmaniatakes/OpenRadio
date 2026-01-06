package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class I extends androidx.emoji2.text.f {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4041d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ I(X x4, int i5) {
        super(x4);
        this.f4041d = i5;
    }

    @Override // androidx.emoji2.text.f
    public final int b(View view) {
        switch (this.f4041d) {
            case 0:
                Y y4 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                return view.getRight() + ((Y) view.getLayoutParams()).f4191b.right + ((ViewGroup.MarginLayoutParams) y4).rightMargin;
            default:
                Y y5 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                return view.getBottom() + ((Y) view.getLayoutParams()).f4191b.bottom + ((ViewGroup.MarginLayoutParams) y5).bottomMargin;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int c(View view) {
        switch (this.f4041d) {
            case 0:
                Y y4 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                Rect rect = ((Y) view.getLayoutParams()).f4191b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) y4).leftMargin + ((ViewGroup.MarginLayoutParams) y4).rightMargin;
            default:
                Y y5 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                Rect rect2 = ((Y) view.getLayoutParams()).f4191b;
                return view.getMeasuredHeight() + rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) y5).topMargin + ((ViewGroup.MarginLayoutParams) y5).bottomMargin;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int d(View view) {
        switch (this.f4041d) {
            case 0:
                Y y4 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                Rect rect = ((Y) view.getLayoutParams()).f4191b;
                return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) y4).topMargin + ((ViewGroup.MarginLayoutParams) y4).bottomMargin;
            default:
                Y y5 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                Rect rect2 = ((Y) view.getLayoutParams()).f4191b;
                return view.getMeasuredWidth() + rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) y5).leftMargin + ((ViewGroup.MarginLayoutParams) y5).rightMargin;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int e(View view) {
        switch (this.f4041d) {
            case 0:
                Y y4 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                return (view.getLeft() - ((Y) view.getLayoutParams()).f4191b.left) - ((ViewGroup.MarginLayoutParams) y4).leftMargin;
            default:
                Y y5 = (Y) view.getLayoutParams();
                ((X) this.f3604b).getClass();
                return (view.getTop() - ((Y) view.getLayoutParams()).f4191b.top) - ((ViewGroup.MarginLayoutParams) y5).topMargin;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int f() {
        switch (this.f4041d) {
            case 0:
                return ((X) this.f3604b).n;
            default:
                return ((X) this.f3604b).f4189o;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int g() {
        switch (this.f4041d) {
            case 0:
                X x4 = (X) this.f3604b;
                return x4.n - x4.D();
            default:
                X x5 = (X) this.f3604b;
                return x5.f4189o - x5.B();
        }
    }

    @Override // androidx.emoji2.text.f
    public final int h() {
        switch (this.f4041d) {
            case 0:
                return ((X) this.f3604b).D();
            default:
                return ((X) this.f3604b).B();
        }
    }

    @Override // androidx.emoji2.text.f
    public final int i() {
        switch (this.f4041d) {
            case 0:
                return ((X) this.f3604b).f4187l;
            default:
                return ((X) this.f3604b).f4188m;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int j() {
        switch (this.f4041d) {
            case 0:
                return ((X) this.f3604b).f4188m;
            default:
                return ((X) this.f3604b).f4187l;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int k() {
        switch (this.f4041d) {
            case 0:
                return ((X) this.f3604b).C();
            default:
                return ((X) this.f3604b).E();
        }
    }

    @Override // androidx.emoji2.text.f
    public final int l() {
        switch (this.f4041d) {
            case 0:
                X x4 = (X) this.f3604b;
                return (x4.n - x4.C()) - x4.D();
            default:
                X x5 = (X) this.f3604b;
                return (x5.f4189o - x5.E()) - x5.B();
        }
    }

    @Override // androidx.emoji2.text.f
    public final int n(View view) {
        switch (this.f4041d) {
            case 0:
                X x4 = (X) this.f3604b;
                Rect rect = (Rect) this.f3605c;
                x4.I(view, rect);
                return rect.right;
            default:
                X x5 = (X) this.f3604b;
                Rect rect2 = (Rect) this.f3605c;
                x5.I(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.f
    public final int o(View view) {
        switch (this.f4041d) {
            case 0:
                X x4 = (X) this.f3604b;
                Rect rect = (Rect) this.f3605c;
                x4.I(view, rect);
                return rect.left;
            default:
                X x5 = (X) this.f3604b;
                Rect rect2 = (Rect) this.f3605c;
                x5.I(view, rect2);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.f
    public final void p(int i5) {
        switch (this.f4041d) {
            case 0:
                ((X) this.f3604b).M(i5);
                break;
            default:
                ((X) this.f3604b).N(i5);
                break;
        }
    }
}
