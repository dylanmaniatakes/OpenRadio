package s2;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class s extends m {

    /* renamed from: e, reason: collision with root package name */
    public final int f9672e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f9673f;
    public final com.google.android.material.datepicker.l g;

    public s(l lVar, int i5) {
        super(lVar);
        this.f9672e = R.drawable.design_password_eye;
        this.g = new com.google.android.material.datepicker.l(11, this);
        if (i5 != 0) {
            this.f9672e = i5;
        }
    }

    @Override // s2.m
    public final void b() {
        q();
    }

    @Override // s2.m
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // s2.m
    public final int d() {
        return this.f9672e;
    }

    @Override // s2.m
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // s2.m
    public final boolean k() {
        return true;
    }

    @Override // s2.m
    public final boolean l() {
        EditText editText = this.f9673f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // s2.m
    public final void m(EditText editText) {
        this.f9673f = editText;
        q();
    }

    @Override // s2.m
    public final void r() {
        EditText editText = this.f9673f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f9673f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // s2.m
    public final void s() {
        EditText editText = this.f9673f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
