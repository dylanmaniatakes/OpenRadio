package w2;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;
import e2.InterfaceC0445a;

/* renamed from: w2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0932a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f10129c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10130d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0445a f10131e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ExpandableBehavior f10132f;

    public ViewTreeObserverOnPreDrawListenerC0932a(ExpandableBehavior expandableBehavior, View view, int i5, InterfaceC0445a interfaceC0445a) {
        this.f10132f = expandableBehavior;
        this.f10129c = view;
        this.f10130d = i5;
        this.f10131e = interfaceC0445a;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.f10129c;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f10132f;
        if (expandableBehavior.f5522a == this.f10130d) {
            Object obj = this.f10131e;
            expandableBehavior.r((View) obj, view, ((FloatingActionButton) obj).f5370q.f6194a, false);
        }
        return false;
    }
}
