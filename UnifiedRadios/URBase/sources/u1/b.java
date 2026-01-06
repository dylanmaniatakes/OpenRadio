package U1;

import O.H;
import O.Y;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.unified.ur1.R;
import i2.e;
import j.m;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: J, reason: collision with root package name */
    public final int f2461J;

    /* renamed from: K, reason: collision with root package name */
    public final int f2462K;

    /* renamed from: L, reason: collision with root package name */
    public final int f2463L;

    /* renamed from: M, reason: collision with root package name */
    public final int f2464M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f2465N;

    /* renamed from: O, reason: collision with root package name */
    public final ArrayList f2466O;

    public b(Context context) {
        super(context);
        this.f2466O = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f2461J = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f2462K = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f2463L = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f2464M = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        int measuredWidth = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                WeakHashMap weakHashMap = Y.f1904a;
                if (H.d(this) == 1) {
                    int i12 = i9 - measuredWidth;
                    childAt.layout(i12 - childAt.getMeasuredWidth(), 0, i12, i10);
                } else {
                    childAt.layout(measuredWidth, 0, childAt.getMeasuredWidth() + measuredWidth, i10);
                }
                measuredWidth += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        m menu = getMenu();
        int size = View.MeasureSpec.getSize(i5);
        int size2 = menu.l().size();
        int childCount = getChildCount();
        ArrayList arrayList = this.f2466O;
        arrayList.clear();
        int size3 = View.MeasureSpec.getSize(i6);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int labelVisibilityMode = getLabelVisibilityMode();
        boolean z4 = labelVisibilityMode != -1 ? labelVisibilityMode == 0 : size2 > 3;
        int i9 = this.f2463L;
        if (z4 && this.f2465N) {
            View childAt = getChildAt(getSelectedItemPosition());
            int visibility = childAt.getVisibility();
            int iMax = this.f2464M;
            if (visibility != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE), iMakeMeasureSpec);
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
            int i10 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int iMin = Math.min(size - (this.f2462K * i10), Math.min(iMax, i9));
            int i11 = size - iMin;
            int iMin2 = Math.min(i11 / (i10 != 0 ? i10 : 1), this.f2461J);
            int i12 = i11 - (i10 * iMin2);
            int i13 = 0;
            while (i13 < childCount) {
                if (getChildAt(i13).getVisibility() != 8) {
                    i8 = i13 == getSelectedItemPosition() ? iMin : iMin2;
                    if (i12 > 0) {
                        i8++;
                        i12--;
                    }
                } else {
                    i8 = 0;
                }
                arrayList.add(Integer.valueOf(i8));
                i13++;
            }
        } else {
            int iMin3 = Math.min(size / (size2 != 0 ? size2 : 1), i9);
            int i14 = size - (size2 * iMin3);
            for (int i15 = 0; i15 < childCount; i15++) {
                if (getChildAt(i15).getVisibility() == 8) {
                    i7 = 0;
                } else if (i14 > 0) {
                    i7 = iMin3 + 1;
                    i14--;
                } else {
                    i7 = iMin3;
                }
                arrayList.add(Integer.valueOf(i7));
            }
        }
        int measuredWidth = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(((Integer) arrayList.get(i16)).intValue(), 1073741824), iMakeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                measuredWidth = childAt2.getMeasuredWidth() + measuredWidth;
            }
        }
        setMeasuredDimension(measuredWidth, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z4) {
        this.f2465N = z4;
    }
}
