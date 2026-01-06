package j;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class o implements G.a {

    /* renamed from: A, reason: collision with root package name */
    public p f7478A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem.OnActionExpandListener f7479B;

    /* renamed from: a, reason: collision with root package name */
    public final int f7481a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7482b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7483c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7484d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f7485e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f7486f;
    public Intent g;
    public char h;

    /* renamed from: j, reason: collision with root package name */
    public char f7488j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f7490l;
    public final m n;

    /* renamed from: o, reason: collision with root package name */
    public F f7492o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f7493p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f7494q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f7495r;

    /* renamed from: y, reason: collision with root package name */
    public int f7502y;

    /* renamed from: z, reason: collision with root package name */
    public View f7503z;

    /* renamed from: i, reason: collision with root package name */
    public int f7487i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f7489k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f7491m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f7496s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f7497t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7498u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7499v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7500w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f7501x = 16;

    /* renamed from: C, reason: collision with root package name */
    public boolean f7480C = false;

    public o(m mVar, int i5, int i6, int i7, int i8, CharSequence charSequence, int i9) {
        this.n = mVar;
        this.f7481a = i6;
        this.f7482b = i5;
        this.f7483c = i7;
        this.f7484d = i8;
        this.f7485e = charSequence;
        this.f7502y = i9;
    }

    public static void c(int i5, int i6, String str, StringBuilder sb) {
        if ((i5 & i6) == i6) {
            sb.append(str);
        }
    }

    @Override // G.a
    public final G.a a(p pVar) {
        p pVar2 = this.f7478A;
        if (pVar2 != null) {
            pVar2.getClass();
        }
        this.f7503z = null;
        this.f7478A = pVar;
        this.n.p(true);
        p pVar3 = this.f7478A;
        if (pVar3 != null) {
            pVar3.d(new B0.l(19, this));
        }
        return this;
    }

    @Override // G.a
    public final p b() {
        return this.f7478A;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f7502y & 8) == 0) {
            return false;
        }
        if (this.f7503z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f7479B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f7500w && (this.f7498u || this.f7499v)) {
            drawable = drawable.mutate();
            if (this.f7498u) {
                F.b.h(drawable, this.f7496s);
            }
            if (this.f7499v) {
                F.b.i(drawable, this.f7497t);
            }
            this.f7500w = false;
        }
        return drawable;
    }

    public final boolean e() {
        p pVar;
        if ((this.f7502y & 8) == 0) {
            return false;
        }
        if (this.f7503z == null && (pVar = this.f7478A) != null) {
            this.f7503z = pVar.b(this);
        }
        return this.f7503z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f7479B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.f(this);
        }
        return false;
    }

    public final boolean f() {
        return (this.f7501x & 32) == 32;
    }

    public final void g(boolean z4) {
        this.f7501x = (z4 ? 4 : 0) | (this.f7501x & (-5));
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f7503z;
        if (view != null) {
            return view;
        }
        p pVar = this.f7478A;
        if (pVar == null) {
            return null;
        }
        View viewB = pVar.b(this);
        this.f7503z = viewB;
        return viewB;
    }

    @Override // G.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f7489k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f7488j;
    }

    @Override // G.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f7494q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f7482b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f7490l;
        if (drawable != null) {
            return d(drawable);
        }
        int i5 = this.f7491m;
        if (i5 == 0) {
            return null;
        }
        Drawable drawableK = AbstractC0930a.k(this.n.f7454a, i5);
        this.f7491m = 0;
        this.f7490l = drawableK;
        return d(drawableK);
    }

    @Override // G.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f7496s;
    }

    @Override // G.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f7497t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f7481a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // G.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f7487i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f7483c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f7492o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f7485e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f7486f;
        return charSequence != null ? charSequence : this.f7485e;
    }

    @Override // G.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f7495r;
    }

    public final void h(boolean z4) {
        if (z4) {
            this.f7501x |= 32;
        } else {
            this.f7501x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f7492o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f7480C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f7501x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f7501x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f7501x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        p pVar = this.f7478A;
        return (pVar == null || !pVar.c()) ? (this.f7501x & 8) == 0 : (this.f7501x & 8) == 0 && this.f7478A.a();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i5;
        this.f7503z = view;
        this.f7478A = null;
        if (view != null && view.getId() == -1 && (i5 = this.f7481a) > 0) {
            view.setId(i5);
        }
        m mVar = this.n;
        mVar.f7462k = true;
        mVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.f7488j == c2) {
            return this;
        }
        this.f7488j = Character.toLowerCase(c2);
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z4) {
        int i5 = this.f7501x;
        int i6 = (z4 ? 1 : 0) | (i5 & (-2));
        this.f7501x = i6;
        if (i5 != i6) {
            this.n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z4) {
        int i5 = this.f7501x;
        if ((i5 & 4) != 0) {
            m mVar = this.n;
            mVar.getClass();
            ArrayList arrayList = mVar.f7459f;
            int size = arrayList.size();
            mVar.w();
            for (int i6 = 0; i6 < size; i6++) {
                o oVar = (o) arrayList.get(i6);
                if (oVar.f7482b == this.f7482b && (oVar.f7501x & 4) != 0 && oVar.isCheckable()) {
                    boolean z5 = oVar == this;
                    int i7 = oVar.f7501x;
                    int i8 = (z5 ? 2 : 0) | (i7 & (-3));
                    oVar.f7501x = i8;
                    if (i7 != i8) {
                        oVar.n.p(false);
                    }
                }
            }
            mVar.v();
        } else {
            int i9 = (i5 & (-3)) | (z4 ? 2 : 0);
            this.f7501x = i9;
            if (i5 != i9) {
                this.n.p(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z4) {
        if (z4) {
            this.f7501x |= 16;
        } else {
            this.f7501x &= -17;
        }
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f7491m = 0;
        this.f7490l = drawable;
        this.f7500w = true;
        this.n.p(false);
        return this;
    }

    @Override // G.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f7496s = colorStateList;
        this.f7498u = true;
        this.f7500w = true;
        this.n.p(false);
        return this;
    }

    @Override // G.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f7497t = mode;
        this.f7499v = true;
        this.f7500w = true;
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        if (this.h == c2) {
            return this;
        }
        this.h = c2;
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f7479B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f7493p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c5) {
        this.h = c2;
        this.f7488j = Character.toLowerCase(c5);
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i5) {
        int i6 = i5 & 3;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f7502y = i5;
        m mVar = this.n;
        mVar.f7462k = true;
        mVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i5) {
        setShowAsAction(i5);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f7485e = charSequence;
        this.n.p(false);
        F f5 = this.f7492o;
        if (f5 != null) {
            f5.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f7486f = charSequence;
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z4) {
        int i5 = this.f7501x;
        int i6 = (z4 ? 0 : 8) | (i5 & (-9));
        this.f7501x = i6;
        if (i5 != i6) {
            m mVar = this.n;
            mVar.h = true;
            mVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f7485e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // G.a, android.view.MenuItem
    public final G.a setContentDescription(CharSequence charSequence) {
        this.f7494q = charSequence;
        this.n.p(false);
        return this;
    }

    @Override // G.a, android.view.MenuItem
    public final G.a setTooltipText(CharSequence charSequence) {
        this.f7495r = charSequence;
        this.n.p(false);
        return this;
    }

    @Override // G.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i5) {
        if (this.f7488j == c2 && this.f7489k == i5) {
            return this;
        }
        this.f7488j = Character.toLowerCase(c2);
        this.f7489k = KeyEvent.normalizeMetaState(i5);
        this.n.p(false);
        return this;
    }

    @Override // G.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i5) {
        if (this.h == c2 && this.f7487i == i5) {
            return this;
        }
        this.h = c2;
        this.f7487i = KeyEvent.normalizeMetaState(i5);
        this.n.p(false);
        return this;
    }

    @Override // G.a, android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c5, int i5, int i6) {
        this.h = c2;
        this.f7487i = KeyEvent.normalizeMetaState(i5);
        this.f7488j = Character.toLowerCase(c5);
        this.f7489k = KeyEvent.normalizeMetaState(i6);
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i5) {
        this.f7490l = null;
        this.f7491m = i5;
        this.f7500w = true;
        this.n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i5) {
        setTitle(this.n.f7454a.getString(i5));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i5) {
        int i6;
        Context context = this.n.f7454a;
        View viewInflate = LayoutInflater.from(context).inflate(i5, (ViewGroup) new LinearLayout(context), false);
        this.f7503z = viewInflate;
        this.f7478A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i6 = this.f7481a) > 0) {
            viewInflate.setId(i6);
        }
        m mVar = this.n;
        mVar.f7462k = true;
        mVar.p(true);
        return this;
    }
}
