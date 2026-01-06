package s2;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f9605a;

    public j(l lVar) {
        this.f9605a = lVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        l lVar = this.f9605a;
        if (lVar.f9625u == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = lVar.f9625u;
        i iVar = lVar.f9628x;
        if (editText != null) {
            editText.removeTextChangedListener(iVar);
            if (lVar.f9625u.getOnFocusChangeListener() == lVar.b().e()) {
                lVar.f9625u.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        lVar.f9625u = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(iVar);
        }
        lVar.b().m(lVar.f9625u);
        lVar.j(lVar.b());
    }
}
