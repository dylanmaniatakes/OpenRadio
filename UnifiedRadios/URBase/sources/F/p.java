package f;

import O.K;
import O.Y;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p extends A2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6359a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6360b;

    public /* synthetic */ p(int i5, Object obj) {
        this.f6359a = i5;
        this.f6360b = obj;
    }

    @Override // O.InterfaceC0171j0
    public final void a() {
        Object obj = this.f6360b;
        switch (this.f6359a) {
            case 0:
                o oVar = (o) obj;
                oVar.f6358k.f6433x.setAlpha(1.0f);
                x xVar = oVar.f6358k;
                xVar.f6388A.d(null);
                xVar.f6388A = null;
                break;
            case 1:
                x xVar2 = (x) obj;
                xVar2.f6433x.setAlpha(1.0f);
                xVar2.f6388A.d(null);
                xVar2.f6388A = null;
                break;
            default:
                L0.e eVar = (L0.e) obj;
                ((x) eVar.f1542e).f6433x.setVisibility(8);
                x xVar3 = (x) eVar.f1542e;
                PopupWindow popupWindow = xVar3.f6434y;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (xVar3.f6433x.getParent() instanceof View) {
                    View view = (View) xVar3.f6433x.getParent();
                    WeakHashMap weakHashMap = Y.f1904a;
                    K.c(view);
                }
                xVar3.f6433x.e();
                xVar3.f6388A.d(null);
                xVar3.f6388A = null;
                ViewGroup viewGroup = xVar3.f6390C;
                WeakHashMap weakHashMap2 = Y.f1904a;
                K.c(viewGroup);
                break;
        }
    }

    @Override // A2.b, O.InterfaceC0171j0
    public void c() {
        Object obj = this.f6360b;
        switch (this.f6359a) {
            case 0:
                ((o) obj).f6358k.f6433x.setVisibility(0);
                break;
            case 1:
                x xVar = (x) obj;
                xVar.f6433x.setVisibility(0);
                if (xVar.f6433x.getParent() instanceof View) {
                    View view = (View) xVar.f6433x.getParent();
                    WeakHashMap weakHashMap = Y.f1904a;
                    K.c(view);
                    break;
                }
                break;
        }
    }
}
