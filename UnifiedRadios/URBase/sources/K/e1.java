package k;

import android.view.View;
import android.view.Window;
import j.C0582a;

/* loaded from: classes.dex */
public final class e1 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final C0582a f7766c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f1 f7767d;

    public e1(f1 f1Var) {
        this.f7767d = f1Var;
        this.f7766c = new C0582a(f1Var.f7769a.getContext(), f1Var.h);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        f1 f1Var = this.f7767d;
        Window.Callback callback = f1Var.f7777k;
        if (callback == null || !f1Var.f7778l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f7766c);
    }
}
