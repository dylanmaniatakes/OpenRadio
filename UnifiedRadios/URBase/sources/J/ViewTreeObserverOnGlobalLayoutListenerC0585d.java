package j;

import O.J;
import O.Y;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k.AbstractC0612G;
import k.AbstractC0613H;
import k.N;
import k.Q;

/* renamed from: j.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0585d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7413c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7414d;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0585d(int i5, Object obj) {
        this.f7413c = i5;
        this.f7414d = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Object obj = this.f7414d;
        switch (this.f7413c) {
            case 0:
                g gVar = (g) obj;
                if (gVar.b()) {
                    ArrayList arrayList = gVar.f7428k;
                    if (arrayList.size() > 0 && !((C0587f) arrayList.get(0)).f7417a.f7887A) {
                        View view = gVar.f7434r;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((C0587f) it.next()).f7417a.c();
                            }
                            break;
                        } else {
                            gVar.dismiss();
                            break;
                        }
                    }
                }
                break;
            case 1:
                E e5 = (E) obj;
                if (e5.b() && !e5.f7384k.f7887A) {
                    View view2 = e5.f7388p;
                    if (view2 != null && view2.isShown()) {
                        e5.f7384k.c();
                        break;
                    } else {
                        e5.dismiss();
                        break;
                    }
                }
                break;
            case 2:
                Q q4 = (Q) obj;
                if (!q4.getInternalPopup().b()) {
                    q4.h.m(AbstractC0613H.b(q4), AbstractC0613H.a(q4));
                }
                ViewTreeObserver viewTreeObserver = q4.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    AbstractC0612G.a(viewTreeObserver, this);
                    break;
                }
                break;
            default:
                N n = (N) obj;
                Q q5 = n.I;
                n.getClass();
                WeakHashMap weakHashMap = Y.f1904a;
                if (!J.b(q5) || !q5.getGlobalVisibleRect(n.f7676G)) {
                    n.dismiss();
                    break;
                } else {
                    n.s();
                    n.c();
                    break;
                }
                break;
        }
    }
}
