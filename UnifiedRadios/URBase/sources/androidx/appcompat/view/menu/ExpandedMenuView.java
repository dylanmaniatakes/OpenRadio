package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import j.B;
import j.l;
import j.m;
import j.o;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements l, B, AdapterView.OnItemClickListener {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3296d = {R.attr.background, R.attr.divider};

    /* renamed from: c, reason: collision with root package name */
    public m f3297c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        L0.m mVarK = L0.m.k(context, attributeSet, f3296d, R.attr.listViewStyle, 0);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(mVarK.g(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(mVarK.g(1));
        }
        mVarK.n();
    }

    @Override // j.B
    public final void a(m mVar) {
        this.f3297c = mVar;
    }

    @Override // j.l
    public final boolean d(o oVar) {
        return this.f3297c.q(oVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        d((o) getAdapter().getItem(i5));
    }
}
