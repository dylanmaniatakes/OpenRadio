package i2;

import B0.l;
import L0.m;
import O.G;
import O.Y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.D1;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.unified.ur1.R;
import j.B;
import j.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import n2.C0802a;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public abstract class k extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public final d f7263c;

    /* renamed from: d, reason: collision with root package name */
    public final U1.b f7264d;

    /* renamed from: e, reason: collision with root package name */
    public final g f7265e;

    /* renamed from: f, reason: collision with root package name */
    public i.j f7266f;
    public i g;

    public k(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(u2.a.a(context, attributeSet, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView), attributeSet, R.attr.bottomNavigationStyle);
        g gVar = new g();
        gVar.f7260d = false;
        this.f7265e = gVar;
        Context context2 = getContext();
        m mVarJ = g2.m.j(context2, attributeSet, O1.a.f2019x, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView, 12, 10);
        d dVar = new d(context2, getClass(), getMaxItemCount());
        this.f7263c = dVar;
        U1.b bVar = new U1.b(context2);
        this.f7264d = bVar;
        gVar.f7259c = bVar;
        gVar.f7261e = 1;
        bVar.setPresenter(gVar);
        dVar.b(gVar, dVar.f7454a);
        getContext();
        gVar.f7259c.f7235G = dVar;
        TypedArray typedArray = (TypedArray) mVarJ.f1557e;
        if (typedArray.hasValue(6)) {
            bVar.setIconTintList(mVarJ.f(6));
        } else {
            bVar.setIconTintList(bVar.c());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(12)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(12, 0));
        }
        if (typedArray.hasValue(10)) {
            setItemTextAppearanceActive(typedArray.getResourceId(10, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(11, true));
        if (typedArray.hasValue(13)) {
            setItemTextColor(mVarJ.f(13));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListJ = AbstractC0930a.j(background);
        if (background == null || colorStateListJ != null) {
            n2.h hVar = new n2.h(n2.m.b(context2, attributeSet, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView).a());
            if (colorStateListJ != null) {
                hVar.l(colorStateListJ);
            }
            hVar.j(context2);
            WeakHashMap weakHashMap = Y.f1904a;
            G.q(this, hVar);
        }
        if (typedArray.hasValue(8)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(8, 0));
        }
        if (typedArray.hasValue(7)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(7, 0));
        }
        if (typedArray.hasValue(0)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(0, 0));
        }
        if (typedArray.hasValue(2)) {
            setElevation(typedArray.getDimensionPixelSize(2, 0));
        }
        F.b.h(getBackground().mutate(), AbstractC0409x1.e(context2, mVarJ, 1));
        setLabelVisibilityMode(typedArray.getInteger(14, -1));
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            bVar.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(AbstractC0409x1.e(context2, mVarJ, 9));
        }
        int resourceId2 = typedArray.getResourceId(3, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, O1.a.f2018w);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setItemActiveIndicatorColor(AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, 2));
            setItemActiveIndicatorShapeAppearance(n2.m.a(context2, typedArrayObtainStyledAttributes.getResourceId(4, 0), 0, new C0802a(0)).a());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(15)) {
            int resourceId3 = typedArray.getResourceId(15, 0);
            gVar.f7260d = true;
            getMenuInflater().inflate(resourceId3, dVar);
            gVar.f7260d = false;
            gVar.g(true);
        }
        mVarJ.n();
        addView(bVar);
        dVar.f7458e = new l(16, (BottomNavigationView) this);
    }

    private MenuInflater getMenuInflater() {
        if (this.f7266f == null) {
            this.f7266f = new i.j(getContext());
        }
        return this.f7266f;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f7264d.getActiveIndicatorLabelPadding();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f7264d.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f7264d.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f7264d.getItemActiveIndicatorMarginHorizontal();
    }

    public n2.m getItemActiveIndicatorShapeAppearance() {
        return this.f7264d.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f7264d.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f7264d.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f7264d.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f7264d.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f7264d.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f7264d.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f7264d.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f7264d.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f7264d.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f7264d.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f7264d.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f7264d.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f7263c;
    }

    public B getMenuView() {
        return this.f7264d;
    }

    public g getPresenter() {
        return this.f7265e;
    }

    public int getSelectedItemId() {
        return this.f7264d.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof n2.h) {
            D1.n(this, (n2.h) background);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.f2507j);
        Bundle bundle = jVar.f7262l;
        d dVar = this.f7263c;
        dVar.getClass();
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = dVar.f7471u;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = zVar.getId();
                    if (id > 0 && (parcelable2 = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        zVar.e(parcelable2);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableJ;
        j jVar = new j(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        jVar.f7262l = bundle;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7263c.f7471u;
        if (!copyOnWriteArrayList.isEmpty()) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = zVar.getId();
                    if (id > 0 && (parcelableJ = zVar.j()) != null) {
                        sparseArray.put(id, parcelableJ);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
        return jVar;
    }

    public void setActiveIndicatorLabelPadding(int i5) {
        this.f7264d.setActiveIndicatorLabelPadding(i5);
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        Drawable background = getBackground();
        if (background instanceof n2.h) {
            ((n2.h) background).k(f5);
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f7264d.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z4) {
        this.f7264d.setItemActiveIndicatorEnabled(z4);
    }

    public void setItemActiveIndicatorHeight(int i5) {
        this.f7264d.setItemActiveIndicatorHeight(i5);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i5) {
        this.f7264d.setItemActiveIndicatorMarginHorizontal(i5);
    }

    public void setItemActiveIndicatorShapeAppearance(n2.m mVar) {
        this.f7264d.setItemActiveIndicatorShapeAppearance(mVar);
    }

    public void setItemActiveIndicatorWidth(int i5) {
        this.f7264d.setItemActiveIndicatorWidth(i5);
    }

    public void setItemBackground(Drawable drawable) {
        this.f7264d.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i5) {
        this.f7264d.setItemBackgroundRes(i5);
    }

    public void setItemIconSize(int i5) {
        this.f7264d.setItemIconSize(i5);
    }

    public void setItemIconSizeRes(int i5) {
        setItemIconSize(getResources().getDimensionPixelSize(i5));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f7264d.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i5) {
        this.f7264d.setItemPaddingBottom(i5);
    }

    public void setItemPaddingTop(int i5) {
        this.f7264d.setItemPaddingTop(i5);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f7264d.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i5) throws Resources.NotFoundException {
        this.f7264d.setItemTextAppearanceActive(i5);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) throws Resources.NotFoundException {
        this.f7264d.setItemTextAppearanceActiveBoldEnabled(z4);
    }

    public void setItemTextAppearanceInactive(int i5) throws Resources.NotFoundException {
        this.f7264d.setItemTextAppearanceInactive(i5);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f7264d.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i5) {
        U1.b bVar = this.f7264d;
        if (bVar.getLabelVisibilityMode() != i5) {
            bVar.setLabelVisibilityMode(i5);
            this.f7265e.g(false);
        }
    }

    public void setOnItemReselectedListener(h hVar) {
    }

    public void setOnItemSelectedListener(i iVar) {
        this.g = iVar;
    }

    public void setSelectedItemId(int i5) {
        d dVar = this.f7263c;
        MenuItem menuItemFindItem = dVar.findItem(i5);
        if (menuItemFindItem == null || dVar.q(menuItemFindItem, this.f7265e, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
