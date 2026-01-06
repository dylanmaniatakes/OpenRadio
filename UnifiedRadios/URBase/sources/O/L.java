package O;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class L implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public F0 f1900a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1901b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0183w f1902c;

    public L(View view, InterfaceC0183w interfaceC0183w) {
        this.f1901b = view;
        this.f1902c = interfaceC0183w;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        F0 f0G = F0.g(view, windowInsets);
        int i5 = Build.VERSION.SDK_INT;
        InterfaceC0183w interfaceC0183w = this.f1902c;
        if (i5 < 30) {
            M.a(windowInsets, this.f1901b);
            if (f0G.equals(this.f1900a)) {
                return interfaceC0183w.e(view, f0G).f();
            }
        }
        this.f1900a = f0G;
        F0 f0E = interfaceC0183w.e(view, f0G);
        if (i5 >= 30) {
            return f0E.f();
        }
        WeakHashMap weakHashMap = Y.f1904a;
        K.c(view);
        return f0E.f();
    }
}
