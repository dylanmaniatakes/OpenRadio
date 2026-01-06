package Z1;

import P.h;
import P.j;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.unified.ur1.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends W.b {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Chip f3080q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Chip chip, Chip chip2) {
        super(chip2);
        this.f3080q = chip;
    }

    @Override // W.b
    public final int n(float f5, float f6) {
        Rect rect = Chip.f5258y;
        Chip chip = this.f3080q;
        return (chip.d() && chip.getCloseIconTouchBounds().contains(f5, f6)) ? 1 : 0;
    }

    @Override // W.b
    public final void o(ArrayList arrayList) {
        boolean z4 = false;
        arrayList.add(0);
        Rect rect = Chip.f5258y;
        Chip chip = this.f3080q;
        if (chip.d()) {
            f fVar = chip.g;
            if (fVar != null && fVar.f3102M) {
                z4 = true;
            }
            if (!z4 || chip.f5261j == null) {
                return;
            }
            arrayList.add(1);
        }
    }

    @Override // W.b
    public final boolean s(int i5, int i6, Bundle bundle) {
        boolean z4 = false;
        if (i6 == 16) {
            Chip chip = this.f3080q;
            if (i5 == 0) {
                return chip.performClick();
            }
            if (i5 == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.f5261j;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z4 = true;
                }
                if (chip.f5271u) {
                    chip.f5270t.x(1, 1);
                }
            }
        }
        return z4;
    }

    @Override // W.b
    public final void t(j jVar) {
        Chip chip = this.f3080q;
        boolean zE = chip.e();
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        accessibilityNodeInfo.setCheckable(zE);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        jVar.f(chip.getAccessibilityClassName());
        accessibilityNodeInfo.setText(chip.getText());
    }

    @Override // W.b
    public final void u(int i5, j jVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        if (i5 != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.f5258y);
            return;
        }
        Chip chip = this.f3080q;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfo.setContentDescription(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        jVar.b(h.f2046e);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }

    @Override // W.b
    public final void v(int i5, boolean z4) {
        if (i5 == 1) {
            Chip chip = this.f3080q;
            chip.f5265o = z4;
            chip.refreshDrawableState();
        }
    }
}
