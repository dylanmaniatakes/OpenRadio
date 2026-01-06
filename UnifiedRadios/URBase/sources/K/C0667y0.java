package k;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import e.AbstractC0429a;
import g3.ViewOnTouchListenerC0549B;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import w1.AbstractC0930a;

/* renamed from: k.y0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0667y0 implements j.D {

    /* renamed from: C, reason: collision with root package name */
    public static final Method f7885C;

    /* renamed from: D, reason: collision with root package name */
    public static final Method f7886D;

    /* renamed from: A, reason: collision with root package name */
    public boolean f7887A;

    /* renamed from: B, reason: collision with root package name */
    public final C0666y f7888B;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7889c;

    /* renamed from: d, reason: collision with root package name */
    public ListAdapter f7890d;

    /* renamed from: e, reason: collision with root package name */
    public C0648o0 f7891e;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f7893i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7895k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7896l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7897m;

    /* renamed from: p, reason: collision with root package name */
    public T.b f7899p;

    /* renamed from: q, reason: collision with root package name */
    public View f7900q;

    /* renamed from: r, reason: collision with root package name */
    public AdapterView.OnItemClickListener f7901r;

    /* renamed from: s, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f7902s;

    /* renamed from: t, reason: collision with root package name */
    public final RunnableC0663w0 f7903t;

    /* renamed from: u, reason: collision with root package name */
    public final ViewOnTouchListenerC0549B f7904u;

    /* renamed from: x, reason: collision with root package name */
    public final Handler f7907x;

    /* renamed from: z, reason: collision with root package name */
    public Rect f7909z;

    /* renamed from: f, reason: collision with root package name */
    public final int f7892f = -2;
    public int g = -2;

    /* renamed from: j, reason: collision with root package name */
    public final int f7894j = 1002;
    public int n = 0;

    /* renamed from: o, reason: collision with root package name */
    public final int f7898o = Integer.MAX_VALUE;

    /* renamed from: v, reason: collision with root package name */
    public final C0665x0 f7905v = new C0665x0(this);

    /* renamed from: w, reason: collision with root package name */
    public final RunnableC0663w0 f7906w = new RunnableC0663w0(this, 0);

    /* renamed from: y, reason: collision with root package name */
    public final Rect f7908y = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f7885C = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f7886D = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public C0667y0(Context context, AttributeSet attributeSet, int i5, int i6) {
        int resourceId;
        int i7 = 1;
        this.f7903t = new RunnableC0663w0(this, i7);
        this.f7904u = new ViewOnTouchListenerC0549B(i7, this);
        this.f7889c = context;
        this.f7907x = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6126o, i5, i6);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f7893i = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f7895k = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C0666y c0666y = new C0666y(context, attributeSet, i5, i6);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6130s, i5, i6);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            S.n.c(c0666y, typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        c0666y.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : AbstractC0930a.k(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f7888B = c0666y;
        c0666y.setInputMethodMode(1);
    }

    public final int a() {
        return this.h;
    }

    @Override // j.D
    public final boolean b() {
        return this.f7888B.isShowing();
    }

    @Override // j.D
    public final void c() {
        int i5;
        int paddingBottom;
        C0648o0 c0648o0;
        C0648o0 c0648o02 = this.f7891e;
        C0666y c0666y = this.f7888B;
        Context context = this.f7889c;
        if (c0648o02 == null) {
            C0648o0 c0648o0Q = q(context, !this.f7887A);
            this.f7891e = c0648o0Q;
            c0648o0Q.setAdapter(this.f7890d);
            this.f7891e.setOnItemClickListener(this.f7901r);
            this.f7891e.setFocusable(true);
            this.f7891e.setFocusableInTouchMode(true);
            this.f7891e.setOnItemSelectedListener(new C0657t0(i, this));
            this.f7891e.setOnScrollListener(this.f7905v);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f7902s;
            if (onItemSelectedListener != null) {
                this.f7891e.setOnItemSelectedListener(onItemSelectedListener);
            }
            c0666y.setContentView(this.f7891e);
        }
        Drawable background = c0666y.getBackground();
        Rect rect = this.f7908y;
        if (background != null) {
            background.getPadding(rect);
            int i6 = rect.top;
            i5 = rect.bottom + i6;
            if (!this.f7895k) {
                this.f7893i = -i6;
            }
        } else {
            rect.setEmpty();
            i5 = 0;
        }
        int iA = AbstractC0659u0.a(c0666y, this.f7900q, this.f7893i, c0666y.getInputMethodMode() == 2);
        int i7 = this.f7892f;
        if (i7 == -1) {
            paddingBottom = iA + i5;
        } else {
            int i8 = this.g;
            int iA2 = this.f7891e.a(i8 != -2 ? i8 != -1 ? View.MeasureSpec.makeMeasureSpec(i8, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f7891e.getPaddingBottom() + this.f7891e.getPaddingTop() + i5 : 0);
        }
        boolean z4 = this.f7888B.getInputMethodMode() == 2;
        S.n.d(c0666y, this.f7894j);
        if (c0666y.isShowing()) {
            View view = this.f7900q;
            WeakHashMap weakHashMap = O.Y.f1904a;
            if (O.J.b(view)) {
                int width = this.g;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f7900q.getWidth();
                }
                if (i7 == -1) {
                    i7 = z4 ? paddingBottom : -1;
                    if (z4) {
                        c0666y.setWidth(this.g == -1 ? -1 : 0);
                        c0666y.setHeight(0);
                    } else {
                        c0666y.setWidth(this.g == -1 ? -1 : 0);
                        c0666y.setHeight(-1);
                    }
                } else if (i7 == -2) {
                    i7 = paddingBottom;
                }
                c0666y.setOutsideTouchable(true);
                c0666y.update(this.f7900q, this.h, this.f7893i, width < 0 ? -1 : width, i7 < 0 ? -1 : i7);
                return;
            }
            return;
        }
        int width2 = this.g;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f7900q.getWidth();
        }
        if (i7 == -1) {
            i7 = -1;
        } else if (i7 == -2) {
            i7 = paddingBottom;
        }
        c0666y.setWidth(width2);
        c0666y.setHeight(i7);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f7885C;
            if (method != null) {
                try {
                    method.invoke(c0666y, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            AbstractC0661v0.b(c0666y, true);
        }
        c0666y.setOutsideTouchable(true);
        c0666y.setTouchInterceptor(this.f7904u);
        if (this.f7897m) {
            S.n.c(c0666y, this.f7896l);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f7886D;
            if (method2 != null) {
                try {
                    method2.invoke(c0666y, this.f7909z);
                } catch (Exception e5) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e5);
                }
            }
        } else {
            AbstractC0661v0.a(c0666y, this.f7909z);
        }
        S.m.a(c0666y, this.f7900q, this.h, this.f7893i, this.n);
        this.f7891e.setSelection(-1);
        if ((!this.f7887A || this.f7891e.isInTouchMode()) && (c0648o0 = this.f7891e) != null) {
            c0648o0.setListSelectionHidden(true);
            c0648o0.requestLayout();
        }
        if (this.f7887A) {
            return;
        }
        this.f7907x.post(this.f7906w);
    }

    public final Drawable d() {
        return this.f7888B.getBackground();
    }

    @Override // j.D
    public final void dismiss() {
        C0666y c0666y = this.f7888B;
        c0666y.dismiss();
        c0666y.setContentView(null);
        this.f7891e = null;
        this.f7907x.removeCallbacks(this.f7903t);
    }

    @Override // j.D
    public final C0648o0 f() {
        return this.f7891e;
    }

    public final void h(Drawable drawable) {
        this.f7888B.setBackgroundDrawable(drawable);
    }

    public final void i(int i5) {
        this.f7893i = i5;
        this.f7895k = true;
    }

    public final void l(int i5) {
        this.h = i5;
    }

    public final int n() {
        if (this.f7895k) {
            return this.f7893i;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        T.b bVar = this.f7899p;
        if (bVar == null) {
            this.f7899p = new T.b(1, this);
        } else {
            ListAdapter listAdapter2 = this.f7890d;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bVar);
            }
        }
        this.f7890d = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f7899p);
        }
        C0648o0 c0648o0 = this.f7891e;
        if (c0648o0 != null) {
            c0648o0.setAdapter(this.f7890d);
        }
    }

    public C0648o0 q(Context context, boolean z4) {
        return new C0648o0(context, z4);
    }

    public final void r(int i5) {
        Drawable background = this.f7888B.getBackground();
        if (background == null) {
            this.g = i5;
            return;
        }
        Rect rect = this.f7908y;
        background.getPadding(rect);
        this.g = rect.left + rect.right + i5;
    }
}
