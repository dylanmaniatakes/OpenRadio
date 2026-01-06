package i;

import O.AbstractC0178q;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import g0.AbstractC0535a;
import j.p;
import j.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f7143A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f7144B;

    /* renamed from: E, reason: collision with root package name */
    public final /* synthetic */ j f7147E;

    /* renamed from: a, reason: collision with root package name */
    public final Menu f7148a;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public int f7154i;

    /* renamed from: j, reason: collision with root package name */
    public int f7155j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f7156k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f7157l;

    /* renamed from: m, reason: collision with root package name */
    public int f7158m;
    public char n;

    /* renamed from: o, reason: collision with root package name */
    public int f7159o;

    /* renamed from: p, reason: collision with root package name */
    public char f7160p;

    /* renamed from: q, reason: collision with root package name */
    public int f7161q;

    /* renamed from: r, reason: collision with root package name */
    public int f7162r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7163s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7164t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7165u;

    /* renamed from: v, reason: collision with root package name */
    public int f7166v;

    /* renamed from: w, reason: collision with root package name */
    public int f7167w;

    /* renamed from: x, reason: collision with root package name */
    public String f7168x;

    /* renamed from: y, reason: collision with root package name */
    public String f7169y;

    /* renamed from: z, reason: collision with root package name */
    public p f7170z;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f7145C = null;

    /* renamed from: D, reason: collision with root package name */
    public PorterDuff.Mode f7146D = null;

    /* renamed from: b, reason: collision with root package name */
    public int f7149b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f7150c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f7151d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f7152e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7153f = true;
    public boolean g = true;

    public i(j jVar, Menu menu) {
        this.f7147E = jVar;
        this.f7148a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f7147E.f7175c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e5) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e5);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z4 = false;
        menuItem.setChecked(this.f7163s).setVisible(this.f7164t).setEnabled(this.f7165u).setCheckable(this.f7162r >= 1).setTitleCondensed(this.f7157l).setIcon(this.f7158m);
        int i5 = this.f7166v;
        if (i5 >= 0) {
            menuItem.setShowAsAction(i5);
        }
        String str = this.f7169y;
        j jVar = this.f7147E;
        if (str != null) {
            if (jVar.f7175c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (jVar.f7176d == null) {
                jVar.f7176d = j.a(jVar.f7175c);
            }
            Object obj = jVar.f7176d;
            String str2 = this.f7169y;
            h hVar = new h();
            hVar.f7141a = obj;
            Class<?> cls = obj.getClass();
            try {
                hVar.f7142b = cls.getMethod(str2, h.f7140c);
                menuItem.setOnMenuItemClickListener(hVar);
            } catch (Exception e5) {
                StringBuilder sbM = AbstractC0535a.m("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbM.append(cls.getName());
                InflateException inflateException = new InflateException(sbM.toString());
                inflateException.initCause(e5);
                throw inflateException;
            }
        }
        if (this.f7162r >= 2) {
            if (menuItem instanceof j.o) {
                ((j.o) menuItem).g(true);
            } else if (menuItem instanceof t) {
                t tVar = (t) menuItem;
                try {
                    Method method = tVar.f7513d;
                    G.a aVar = tVar.f7512c;
                    if (method == null) {
                        tVar.f7513d = aVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    tVar.f7513d.invoke(aVar, Boolean.TRUE);
                } catch (Exception e6) {
                    Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e6);
                }
            }
        }
        String str3 = this.f7168x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, j.f7171e, jVar.f7173a));
            z4 = true;
        }
        int i6 = this.f7167w;
        if (i6 > 0) {
            if (z4) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i6);
            }
        }
        p pVar = this.f7170z;
        if (pVar != null) {
            if (menuItem instanceof G.a) {
                ((G.a) menuItem).a(pVar);
            } else {
                Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            }
        }
        CharSequence charSequence = this.f7143A;
        boolean z5 = menuItem instanceof G.a;
        if (z5) {
            ((G.a) menuItem).setContentDescription(charSequence);
        } else {
            AbstractC0178q.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f7144B;
        if (z5) {
            ((G.a) menuItem).setTooltipText(charSequence2);
        } else {
            AbstractC0178q.m(menuItem, charSequence2);
        }
        char c2 = this.n;
        int i7 = this.f7159o;
        if (z5) {
            ((G.a) menuItem).setAlphabeticShortcut(c2, i7);
        } else {
            AbstractC0178q.g(menuItem, c2, i7);
        }
        char c5 = this.f7160p;
        int i8 = this.f7161q;
        if (z5) {
            ((G.a) menuItem).setNumericShortcut(c5, i8);
        } else {
            AbstractC0178q.k(menuItem, c5, i8);
        }
        PorterDuff.Mode mode = this.f7146D;
        if (mode != null) {
            if (z5) {
                ((G.a) menuItem).setIconTintMode(mode);
            } else {
                AbstractC0178q.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f7145C;
        if (colorStateList != null) {
            if (z5) {
                ((G.a) menuItem).setIconTintList(colorStateList);
            } else {
                AbstractC0178q.i(menuItem, colorStateList);
            }
        }
    }
}
