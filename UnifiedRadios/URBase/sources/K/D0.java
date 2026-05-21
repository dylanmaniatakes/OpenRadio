package k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public final class D0 extends C0648o0 {

    /* renamed from: o, reason: collision with root package name */
    public final int f7636o;

    /* renamed from: p, reason: collision with root package name */
    public final int f7637p;

    /* renamed from: q, reason: collision with root package name */
    public InterfaceC0669z0 f7638q;

    /* renamed from: r, reason: collision with root package name */
    public j.o f7639r;

    public D0(Context context, boolean z4) {
        super(context, z4);
        if (1 == C0.a(context.getResources().getConfiguration())) {
            this.f7636o = 21;
            this.f7637p = 22;
        } else {
            this.f7636o = 22;
            this.f7637p = 21;
        }
    }

    @Override // k.C0648o0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        j.j jVar;
        int headersCount;
        int iPointToPosition;
        int i5;
        if (this.f7638q != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                jVar = (j.j) headerViewListAdapter.getWrappedAdapter();
            } else {
                jVar = (j.j) adapter;
                headersCount = 0;
            }
            j.o oVarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i5 = iPointToPosition - headersCount) < 0 || i5 >= jVar.getCount()) ? null : jVar.getItem(i5);
            j.o oVar = this.f7639r;
            if (oVar != oVarB) {
                j.m mVar = jVar.f7449c;
                if (oVar != null) {
                    this.f7638q.g(mVar, oVar);
                }
                this.f7639r = oVarB;
                if (oVarB != null) {
                    this.f7638q.k(mVar, oVarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i5 == this.f7636o) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i5 != this.f7637p) {
            return super.onKeyDown(i5, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (j.j) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (j.j) adapter).f7449c.c(false);
        return true;
    }

    public void setHoverListener(InterfaceC0669z0 interfaceC0669z0) {
        this.f7638q = interfaceC0669z0;
    }

    @Override // k.C0648o0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
