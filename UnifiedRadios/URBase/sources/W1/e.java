package W1;

import O.C0156c;
import P.i;
import P.j;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.datepicker.k;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class e extends C0156c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f2606d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2607e;

    public /* synthetic */ e(int i5, Object obj) {
        this.f2606d = i5;
        this.f2607e = obj;
    }

    @Override // O.C0156c
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f2606d) {
            case 2:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.f2607e).f5375f);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // O.C0156c
    public final void d(View view, j jVar) {
        Object obj = this.f2607e;
        View.AccessibilityDelegate accessibilityDelegate = this.f1912a;
        switch (this.f2606d) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, jVar.f2058a);
                int i5 = MaterialButtonToggleGroup.f5246m;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                materialButtonToggleGroup.getClass();
                int i6 = -1;
                if (view instanceof MaterialButton) {
                    int i7 = 0;
                    int i8 = 0;
                    while (true) {
                        if (i7 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i7) == view) {
                                i6 = i8;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i7) instanceof MaterialButton) && materialButtonToggleGroup.c(i7)) {
                                    i8++;
                                }
                                i7++;
                            }
                        }
                    }
                }
                jVar.g(i.a(0, 1, i6, 1, ((MaterialButton) view).f5243q));
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                k kVar = (k) obj;
                accessibilityNodeInfo.setHintText(kVar.n.getVisibility() == 0 ? kVar.getString(R.string.mtrl_picker_toggle_to_year_selection) : kVar.getString(R.string.mtrl_picker_toggle_to_day_selection));
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = jVar.f2058a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.g);
                accessibilityNodeInfo2.setChecked(checkableImageButton.f5375f);
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo3 = jVar.f2058a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCheckable(((NavigationMenuItemView) obj).f5386z);
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo4 = jVar.f2058a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                jVar.a(1048576);
                accessibilityNodeInfo4.setDismissable(true);
                break;
        }
    }

    @Override // O.C0156c
    public boolean g(View view, int i5, Bundle bundle) {
        switch (this.f2606d) {
            case 4:
                if (i5 != 1048576) {
                    break;
                } else {
                    ((q2.k) ((q2.i) this.f2607e)).a(3);
                    break;
                }
        }
        return super.g(view, i5, bundle);
    }
}
