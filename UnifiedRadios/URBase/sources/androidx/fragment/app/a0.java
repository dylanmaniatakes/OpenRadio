package androidx.fragment.app;

import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a0 implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f3757c;

    public a0(View view) {
        this.f3757c = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        View view2 = this.f3757c;
        view2.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = O.Y.f1904a;
        O.K.c(view2);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
