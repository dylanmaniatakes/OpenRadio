package j;

import O.H;
import O.Y;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.unified.ur1.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7516a;

    /* renamed from: b, reason: collision with root package name */
    public final m f7517b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7518c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7519d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7520e;

    /* renamed from: f, reason: collision with root package name */
    public View f7521f;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public y f7522i;

    /* renamed from: j, reason: collision with root package name */
    public u f7523j;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f7524k;
    public int g = 8388611;

    /* renamed from: l, reason: collision with root package name */
    public final v f7525l = new v(this);

    public x(int i5, int i6, Context context, View view, m mVar, boolean z4) {
        this.f7516a = context;
        this.f7517b = mVar;
        this.f7521f = view;
        this.f7518c = z4;
        this.f7519d = i5;
        this.f7520e = i6;
    }

    public final u a() {
        u e5;
        if (this.f7523j == null) {
            Context context = this.f7516a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            w.a(defaultDisplay, point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                e5 = new g(this.f7516a, this.f7521f, this.f7519d, this.f7520e, this.f7518c);
            } else {
                View view = this.f7521f;
                int i5 = this.f7520e;
                boolean z4 = this.f7518c;
                e5 = new E(this.f7519d, i5, this.f7516a, view, this.f7517b, z4);
            }
            e5.n(this.f7517b);
            e5.t(this.f7525l);
            e5.p(this.f7521f);
            e5.l(this.f7522i);
            e5.q(this.h);
            e5.r(this.g);
            this.f7523j = e5;
        }
        return this.f7523j;
    }

    public final boolean b() {
        u uVar = this.f7523j;
        return uVar != null && uVar.b();
    }

    public void c() {
        this.f7523j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f7524k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i5, int i6, boolean z4, boolean z5) {
        u uVarA = a();
        uVarA.u(z5);
        if (z4) {
            int i7 = this.g;
            View view = this.f7521f;
            WeakHashMap weakHashMap = Y.f1904a;
            if ((Gravity.getAbsoluteGravity(i7, H.d(view)) & 7) == 5) {
                i5 -= this.f7521f.getWidth();
            }
            uVarA.s(i5);
            uVarA.v(i6);
            int i8 = (int) ((this.f7516a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            uVarA.f7514c = new Rect(i5 - i8, i6 - i8, i5 + i8, i6 + i8);
        }
        uVarA.c();
    }
}
