package s2;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f9629a;

    /* renamed from: b, reason: collision with root package name */
    public final l f9630b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f9631c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f9632d;

    public m(l lVar) {
        this.f9629a = lVar.f9610c;
        this.f9630b = lVar;
        this.f9631c = lVar.getContext();
        this.f9632d = lVar.f9614i;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public P.d h() {
        return null;
    }

    public boolean i(int i5) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof h;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void n(P.j jVar) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z4) {
    }

    public final void q() {
        this.f9630b.f(false);
    }

    public void r() {
    }

    public void s() {
    }
}
