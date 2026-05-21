package j;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public final class q extends FrameLayout implements i.c {

    /* renamed from: c, reason: collision with root package name */
    public final CollapsibleActionView f7507c;

    /* JADX WARN: Multi-variable type inference failed */
    public q(View view) {
        super(view.getContext());
        this.f7507c = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // i.c
    public final void b() {
        this.f7507c.onActionViewExpanded();
    }

    @Override // i.c
    public final void e() {
        this.f7507c.onActionViewCollapsed();
    }
}
