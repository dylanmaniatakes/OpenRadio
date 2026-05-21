package T1;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.bottomappbar.BottomAppBar$Behavior;
import com.unified.ur1.R;
import i2.c;
import k.j1;
import v2.C0921a;

/* loaded from: classes.dex */
public final class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2439a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2440b;

    public /* synthetic */ a(int i5, Object obj) {
        this.f2439a = i5;
        this.f2440b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        R1.a aVar;
        switch (this.f2439a) {
            case 0:
                ((BottomAppBar$Behavior) this.f2440b).getClass();
                throw null;
            case 1:
                c cVar = (c) this.f2440b;
                if (cVar.f7215p.getVisibility() != 0 || (aVar = cVar.f7204H) == null) {
                    return;
                }
                Rect rect = new Rect();
                ImageView imageView = cVar.f7215p;
                imageView.getDrawingRect(rect);
                aVar.setBounds(rect);
                aVar.h(imageView, null);
                return;
            case 2:
                SearchView searchView = (SearchView) this.f2440b;
                View view2 = searchView.f3437z;
                if (view2.getWidth() > 1) {
                    Resources resources = searchView.getContext().getResources();
                    int paddingLeft = searchView.f3431t.getPaddingLeft();
                    Rect rect2 = new Rect();
                    boolean zA = j1.a(searchView);
                    int dimensionPixelSize = searchView.f3412O ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) : 0;
                    SearchView.SearchAutoComplete searchAutoComplete = searchView.f3429r;
                    searchAutoComplete.getDropDownBackground().getPadding(rect2);
                    searchAutoComplete.setDropDownHorizontalOffset(zA ? -rect2.left : paddingLeft - (rect2.left + dimensionPixelSize));
                    searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect2.left) + rect2.right) + dimensionPixelSize) - paddingLeft);
                    return;
                }
                return;
            default:
                C0921a c0921a = (C0921a) this.f2440b;
                c0921a.getClass();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                c0921a.f10023K = iArr[0];
                view.getWindowVisibleDisplayFrame(c0921a.f10018E);
                return;
        }
    }
}
