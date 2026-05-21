package O;

import android.R;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class G0 extends L0.f {

    /* renamed from: a, reason: collision with root package name */
    public final Window f1895a;

    /* renamed from: b, reason: collision with root package name */
    public final View f1896b;

    public G0(Window window, View view) {
        this.f1895a = window;
        this.f1896b = view;
    }

    @Override // L0.f
    public final void k(boolean z4) {
        if (!z4) {
            p(16);
            return;
        }
        Window window = this.f1895a;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
    }

    @Override // L0.f
    public final void l(boolean z4) {
        if (!z4) {
            p(8192);
            return;
        }
        Window window = this.f1895a;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
    }

    @Override // L0.f
    public final void m() {
        for (int i5 = 1; i5 <= 256; i5 <<= 1) {
            if ((8 & i5) != 0) {
                Window window = this.f1895a;
                if (i5 == 1) {
                    p(4);
                    window.clearFlags(1024);
                } else if (i5 == 2) {
                    p(2);
                } else if (i5 == 8) {
                    View viewFindViewById = this.f1896b;
                    if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                        viewFindViewById.requestFocus();
                    } else {
                        viewFindViewById = window.getCurrentFocus();
                    }
                    if (viewFindViewById == null) {
                        viewFindViewById = window.findViewById(R.id.content);
                    }
                    if (viewFindViewById != null && viewFindViewById.hasWindowFocus()) {
                        viewFindViewById.post(new C0.e(1, viewFindViewById));
                    }
                }
            }
        }
    }

    public final void p(int i5) {
        View decorView = this.f1895a.getDecorView();
        decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
    }
}
