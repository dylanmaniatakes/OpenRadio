package androidx.viewpager2.widget;

import A0.a;
import B0.c;
import B0.d;
import B0.e;
import B0.f;
import B0.g;
import B0.h;
import B0.i;
import B0.j;
import B0.k;
import B0.m;
import B0.n;
import B0.o;
import B0.q;
import B0.r;
import L0.l;
import O.H;
import O.Y;
import X2.t;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.T;
import androidx.recyclerview.widget.X;
import androidx.viewpager2.adapter.b;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f4460c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f4461d;

    /* renamed from: e, reason: collision with root package name */
    public final c f4462e;

    /* renamed from: f, reason: collision with root package name */
    public int f4463f;
    public boolean g;
    public final g h;

    /* renamed from: i, reason: collision with root package name */
    public final j f4464i;

    /* renamed from: j, reason: collision with root package name */
    public int f4465j;

    /* renamed from: k, reason: collision with root package name */
    public Parcelable f4466k;

    /* renamed from: l, reason: collision with root package name */
    public final o f4467l;

    /* renamed from: m, reason: collision with root package name */
    public final n f4468m;
    public final f n;

    /* renamed from: o, reason: collision with root package name */
    public final c f4469o;

    /* renamed from: p, reason: collision with root package name */
    public final l f4470p;

    /* renamed from: q, reason: collision with root package name */
    public final d f4471q;

    /* renamed from: r, reason: collision with root package name */
    public T f4472r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4473s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4474t;

    /* renamed from: u, reason: collision with root package name */
    public int f4475u;

    /* renamed from: v, reason: collision with root package name */
    public final t f4476v;

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4460c = new Rect();
        this.f4461d = new Rect();
        c cVar = new c();
        this.f4462e = cVar;
        int i5 = 0;
        this.g = false;
        this.h = new g(i5, this);
        this.f4465j = -1;
        this.f4472r = null;
        this.f4473s = false;
        int i6 = 1;
        this.f4474t = true;
        this.f4475u = -1;
        t tVar = new t();
        tVar.f2836f = this;
        tVar.f2833c = new Z2.c(i6, tVar);
        tVar.f2834d = new B0.l(i5, tVar);
        this.f4476v = tVar;
        o oVar = new o(this, context);
        this.f4467l = oVar;
        WeakHashMap weakHashMap = Y.f1904a;
        oVar.setId(H.a());
        this.f4467l.setDescendantFocusability(131072);
        j jVar = new j(this);
        this.f4464i = jVar;
        this.f4467l.setLayoutManager(jVar);
        this.f4467l.setScrollingTouchSlop(1);
        int[] iArr = a.f5a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Y.j(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
            this.f4467l.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            o oVar2 = this.f4467l;
            i iVar = new i();
            if (oVar2.f4082E == null) {
                oVar2.f4082E = new ArrayList();
            }
            oVar2.f4082E.add(iVar);
            f fVar = new f(this);
            this.n = fVar;
            this.f4470p = new l(i6, fVar);
            n nVar = new n(this);
            this.f4468m = nVar;
            nVar.a(this.f4467l);
            this.f4467l.j(this.n);
            c cVar2 = new c();
            this.f4469o = cVar2;
            this.n.f93a = cVar2;
            h hVar = new h(this, i5);
            h hVar2 = new h(this, i6);
            ((ArrayList) cVar2.f89b).add(hVar);
            ((ArrayList) this.f4469o.f89b).add(hVar2);
            this.f4476v.i(this.f4467l);
            ((ArrayList) this.f4469o.f89b).add(cVar);
            d dVar = new d();
            this.f4471q = dVar;
            ((ArrayList) this.f4469o.f89b).add(dVar);
            o oVar3 = this.f4467l;
            attachViewToParent(oVar3, 0, oVar3.getLayoutParams());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void a() {
        N adapter;
        if (this.f4465j == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.f4466k;
        if (parcelable != null) {
            if (adapter instanceof b) {
                ((b) adapter).g(parcelable);
            }
            this.f4466k = null;
        }
        int iMax = Math.max(0, Math.min(this.f4465j, adapter.getItemCount() - 1));
        this.f4463f = iMax;
        this.f4465j = -1;
        this.f4467l.g0(iMax);
        this.f4476v.o();
    }

    public final void b(int i5, boolean z4) {
        if (((f) this.f4470p.f1554d).f103m) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        c(i5, z4);
    }

    public final void c(int i5, boolean z4) {
        k kVar;
        N adapter = getAdapter();
        if (adapter == null) {
            if (this.f4465j != -1) {
                this.f4465j = Math.max(i5, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i5, 0), adapter.getItemCount() - 1);
        int i6 = this.f4463f;
        if (iMin == i6 && this.n.f98f == 0) {
            return;
        }
        if (iMin == i6 && z4) {
            return;
        }
        double d5 = i6;
        this.f4463f = iMin;
        this.f4476v.o();
        f fVar = this.n;
        if (fVar.f98f != 0) {
            fVar.e();
            e eVar = fVar.g;
            d5 = eVar.f90a + eVar.f91b;
        }
        f fVar2 = this.n;
        fVar2.getClass();
        fVar2.f97e = z4 ? 2 : 3;
        fVar2.f103m = false;
        boolean z5 = fVar2.f99i != iMin;
        fVar2.f99i = iMin;
        fVar2.c(2);
        if (z5 && (kVar = fVar2.f93a) != null) {
            kVar.c(iMin);
        }
        if (!z4) {
            this.f4467l.g0(iMin);
            return;
        }
        double d6 = iMin;
        if (Math.abs(d6 - d5) <= 3.0d) {
            this.f4467l.j0(iMin);
            return;
        }
        this.f4467l.g0(d6 > d5 ? iMin - 3 : iMin + 3);
        o oVar = this.f4467l;
        oVar.post(new r(iMin, oVar));
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i5) {
        return this.f4467l.canScrollHorizontally(i5);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i5) {
        return this.f4467l.canScrollVertically(i5);
    }

    public final void d() {
        n nVar = this.f4468m;
        if (nVar == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewE = nVar.e(this.f4464i);
        if (viewE == null) {
            return;
        }
        this.f4464i.getClass();
        int iF = X.F(viewE);
        if (iF != this.f4463f && getScrollState() == 0) {
            this.f4469o.c(iF);
        }
        this.g = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof q) {
            int i5 = ((q) parcelable).f114j;
            sparseArray.put(this.f4467l.getId(), (Parcelable) sparseArray.get(i5));
            sparseArray.remove(i5);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.f4476v.getClass();
        this.f4476v.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public N getAdapter() {
        return this.f4467l.getAdapter();
    }

    public int getCurrentItem() {
        return this.f4463f;
    }

    public int getItemDecorationCount() {
        return this.f4467l.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f4475u;
    }

    public int getOrientation() {
        return this.f4464i.f4053p == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        o oVar = this.f4467l;
        if (getOrientation() == 0) {
            height = oVar.getWidth() - oVar.getPaddingLeft();
            paddingBottom = oVar.getPaddingRight();
        } else {
            height = oVar.getHeight() - oVar.getPaddingTop();
            paddingBottom = oVar.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.n.f98f;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int itemCount;
        int itemCount2;
        int itemCount3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = (ViewPager2) this.f4476v.f2836f;
        if (viewPager2.getAdapter() == null) {
            itemCount = 0;
            itemCount2 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            itemCount = viewPager2.getAdapter().getItemCount();
            itemCount2 = 1;
        } else {
            itemCount2 = viewPager2.getAdapter().getItemCount();
            itemCount = 1;
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(itemCount, itemCount2, false, 0));
        N adapter = viewPager2.getAdapter();
        if (adapter == null || (itemCount3 = adapter.getItemCount()) == 0 || !viewPager2.f4474t) {
            return;
        }
        if (viewPager2.f4463f > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        if (viewPager2.f4463f < itemCount3 - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int measuredWidth = this.f4467l.getMeasuredWidth();
        int measuredHeight = this.f4467l.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f4460c;
        rect.left = paddingLeft;
        rect.right = (i7 - i5) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i8 - i6) - getPaddingBottom();
        Rect rect2 = this.f4461d;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f4467l.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.g) {
            d();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        measureChild(this.f4467l, i5, i6);
        int measuredWidth = this.f4467l.getMeasuredWidth();
        int measuredHeight = this.f4467l.getMeasuredHeight();
        int measuredState = this.f4467l.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i5, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i6, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof q)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        q qVar = (q) parcelable;
        super.onRestoreInstanceState(qVar.getSuperState());
        this.f4465j = qVar.f115k;
        this.f4466k = qVar.f116l;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        q qVar = new q(super.onSaveInstanceState());
        qVar.f114j = this.f4467l.getId();
        int i5 = this.f4465j;
        if (i5 == -1) {
            i5 = this.f4463f;
        }
        qVar.f115k = i5;
        Parcelable parcelable = this.f4466k;
        if (parcelable != null) {
            qVar.f116l = parcelable;
        } else {
            N adapter = this.f4467l.getAdapter();
            if (adapter instanceof b) {
                b bVar = (b) adapter;
                bVar.getClass();
                q.e eVar = bVar.f4454c;
                int iH = eVar.h();
                q.e eVar2 = bVar.f4455d;
                Bundle bundle = new Bundle(eVar2.h() + iH);
                for (int i6 = 0; i6 < eVar.h(); i6++) {
                    long jE = eVar.e(i6);
                    Fragment fragment = (Fragment) eVar.d(jE, null);
                    if (fragment != null && fragment.isAdded()) {
                        bVar.f4453b.J(bundle, AbstractC0535a.h(jE, "f#"), fragment);
                    }
                }
                for (int i7 = 0; i7 < eVar2.h(); i7++) {
                    long jE2 = eVar2.e(i7);
                    if (b.b(jE2)) {
                        bundle.putParcelable(AbstractC0535a.h(jE2, "s#"), (Parcelable) eVar2.d(jE2, null));
                    }
                }
                qVar.f116l = bundle;
            }
        }
        return qVar;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i5, Bundle bundle) {
        this.f4476v.getClass();
        if (i5 != 8192 && i5 != 4096) {
            return super.performAccessibilityAction(i5, bundle);
        }
        t tVar = this.f4476v;
        tVar.getClass();
        if (i5 != 8192 && i5 != 4096) {
            throw new IllegalStateException();
        }
        ViewPager2 viewPager2 = (ViewPager2) tVar.f2836f;
        int currentItem = i5 == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
        if (viewPager2.f4474t) {
            viewPager2.c(currentItem, true);
        }
        return true;
    }

    public void setAdapter(N n) {
        N adapter = this.f4467l.getAdapter();
        t tVar = this.f4476v;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver((g) tVar.f2835e);
        } else {
            tVar.getClass();
        }
        g gVar = this.h;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(gVar);
        }
        this.f4467l.setAdapter(n);
        this.f4463f = 0;
        a();
        t tVar2 = this.f4476v;
        tVar2.o();
        if (n != null) {
            n.registerAdapterDataObserver((g) tVar2.f2835e);
        }
        if (n != null) {
            n.registerAdapterDataObserver(gVar);
        }
    }

    public void setCurrentItem(int i5) {
        b(i5, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i5) {
        super.setLayoutDirection(i5);
        this.f4476v.o();
    }

    public void setOffscreenPageLimit(int i5) {
        if (i5 < 1 && i5 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f4475u = i5;
        this.f4467l.requestLayout();
    }

    public void setOrientation(int i5) {
        this.f4464i.c1(i5);
        this.f4476v.o();
    }

    public void setPageTransformer(m mVar) {
        if (mVar != null) {
            if (!this.f4473s) {
                this.f4472r = this.f4467l.getItemAnimator();
                this.f4473s = true;
            }
            this.f4467l.setItemAnimator(null);
        } else if (this.f4473s) {
            this.f4467l.setItemAnimator(this.f4472r);
            this.f4472r = null;
            this.f4473s = false;
        }
        this.f4471q.getClass();
        if (mVar == null) {
            return;
        }
        this.f4471q.getClass();
        this.f4471q.getClass();
    }

    public void setUserInputEnabled(boolean z4) {
        this.f4474t = z4;
        this.f4476v.o();
    }
}
