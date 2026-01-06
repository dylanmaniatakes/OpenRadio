package k;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class E0 extends C0667y0 implements InterfaceC0669z0 {

    /* renamed from: F, reason: collision with root package name */
    public static final Method f7644F;

    /* renamed from: E, reason: collision with root package name */
    public InterfaceC0669z0 f7645E;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f7644F = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // k.InterfaceC0669z0
    public final void g(j.m mVar, j.o oVar) {
        InterfaceC0669z0 interfaceC0669z0 = this.f7645E;
        if (interfaceC0669z0 != null) {
            interfaceC0669z0.g(mVar, oVar);
        }
    }

    @Override // k.InterfaceC0669z0
    public final void k(j.m mVar, j.o oVar) {
        InterfaceC0669z0 interfaceC0669z0 = this.f7645E;
        if (interfaceC0669z0 != null) {
            interfaceC0669z0.k(mVar, oVar);
        }
    }

    @Override // k.C0667y0
    public final C0648o0 q(Context context, boolean z4) {
        D0 d02 = new D0(context, z4);
        d02.setHoverListener(this);
        return d02;
    }
}
