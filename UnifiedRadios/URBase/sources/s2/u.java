package s2;

import O.C0156c;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import k.Z;

/* loaded from: classes.dex */
public final class u extends C0156c {

    /* renamed from: d, reason: collision with root package name */
    public final TextInputLayout f9682d;

    public u(TextInputLayout textInputLayout) {
        this.f9682d = textInputLayout;
    }

    @Override // O.C0156c
    public final void d(View view, P.j jVar) {
        View.AccessibilityDelegate accessibilityDelegate = this.f1912a;
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f9682d;
        EditText editText = textInputLayout.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean z4 = !zIsEmpty;
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(hint);
        boolean z7 = !textInputLayout.v0;
        boolean z8 = !TextUtils.isEmpty(error);
        if (!z8 && TextUtils.isEmpty(counterOverflowDescription)) {
            z5 = false;
        }
        String string = z6 ? hint.toString() : "";
        t tVar = textInputLayout.f5443d;
        Z z9 = tVar.f9675d;
        if (z9.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(z9);
            accessibilityNodeInfo.setTraversalAfter(z9);
        } else {
            accessibilityNodeInfo.setTraversalAfter(tVar.f9677f);
        }
        if (z4) {
            accessibilityNodeInfo.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setText(string);
            if (z7 && placeholderText != null) {
                accessibilityNodeInfo.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfo.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setHintText(string);
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z5) {
            if (!z8) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        Z z10 = textInputLayout.f5457l.f9662y;
        if (z10 != null) {
            accessibilityNodeInfo.setLabelFor(z10);
        }
        textInputLayout.f5445e.b().n(jVar);
    }

    @Override // O.C0156c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f9682d.f5445e.b().o(accessibilityEvent);
    }
}
