package k;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.unified.ur1.R;
import e.AbstractC0429a;

/* loaded from: classes.dex */
public final class f1 implements InterfaceC0634h0 {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f7769a;

    /* renamed from: b, reason: collision with root package name */
    public int f7770b;

    /* renamed from: c, reason: collision with root package name */
    public final View f7771c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f7772d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f7773e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f7774f;
    public boolean g;
    public CharSequence h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f7775i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f7776j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f7777k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7778l;

    /* renamed from: m, reason: collision with root package name */
    public C0637j f7779m;
    public final int n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f7780o;

    public f1(Toolbar toolbar, boolean z4) {
        Drawable drawable;
        this.n = 0;
        this.f7769a = toolbar;
        this.h = toolbar.getTitle();
        this.f7775i = toolbar.getSubtitle();
        this.g = this.h != null;
        this.f7774f = toolbar.getNavigationIcon();
        L0.m mVarK = L0.m.k(toolbar.getContext(), null, AbstractC0429a.f6115a, R.attr.actionBarStyle, 0);
        int i5 = 15;
        this.f7780o = mVarK.g(15);
        if (z4) {
            TypedArray typedArray = (TypedArray) mVarK.f1557e;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                this.g = true;
                this.h = text;
                if ((this.f7770b & 8) != 0) {
                    Toolbar toolbar2 = this.f7769a;
                    toolbar2.setTitle(text);
                    if (this.g) {
                        O.Y.l(toolbar2.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                this.f7775i = text2;
                if ((this.f7770b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableG = mVarK.g(20);
            if (drawableG != null) {
                this.f7773e = drawableG;
                c();
            }
            Drawable drawableG2 = mVarK.g(17);
            if (drawableG2 != null) {
                this.f7772d = drawableG2;
                c();
            }
            if (this.f7774f == null && (drawable = this.f7780o) != null) {
                this.f7774f = drawable;
                int i6 = this.f7770b & 4;
                Toolbar toolbar3 = this.f7769a;
                if (i6 != 0) {
                    toolbar3.setNavigationIcon(drawable);
                } else {
                    toolbar3.setNavigationIcon((Drawable) null);
                }
            }
            a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f7771c;
                if (view != null && (this.f7770b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f7771c = viewInflate;
                if (viewInflate != null && (this.f7770b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                a(this.f7770b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                toolbar.d();
                toolbar.f3477v.a(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.n = resourceId2;
                Z z5 = toolbar.f3462d;
                if (z5 != null) {
                    z5.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f3470o = resourceId3;
                Z z6 = toolbar.f3463e;
                if (z6 != null) {
                    z6.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f7780o = toolbar.getNavigationIcon();
            } else {
                i5 = 11;
            }
            this.f7770b = i5;
        }
        mVarK.n();
        if (R.string.abc_action_bar_up_description != this.n) {
            this.n = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i7 = this.n;
                this.f7776j = i7 != 0 ? toolbar.getContext().getString(i7) : null;
                b();
            }
        }
        this.f7776j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new e1(this));
    }

    public final void a(int i5) {
        View view;
        int i6 = this.f7770b ^ i5;
        this.f7770b = i5;
        if (i6 != 0) {
            if ((i6 & 4) != 0) {
                if ((i5 & 4) != 0) {
                    b();
                }
                int i7 = this.f7770b & 4;
                Toolbar toolbar = this.f7769a;
                if (i7 != 0) {
                    Drawable drawable = this.f7774f;
                    if (drawable == null) {
                        drawable = this.f7780o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i6 & 3) != 0) {
                c();
            }
            int i8 = i6 & 8;
            Toolbar toolbar2 = this.f7769a;
            if (i8 != 0) {
                if ((i5 & 8) != 0) {
                    toolbar2.setTitle(this.h);
                    toolbar2.setSubtitle(this.f7775i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i6 & 16) == 0 || (view = this.f7771c) == null) {
                return;
            }
            if ((i5 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    public final void b() {
        if ((this.f7770b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f7776j);
            Toolbar toolbar = this.f7769a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.n);
            } else {
                toolbar.setNavigationContentDescription(this.f7776j);
            }
        }
    }

    public final void c() {
        Drawable drawable;
        int i5 = this.f7770b;
        if ((i5 & 2) == 0) {
            drawable = null;
        } else if ((i5 & 1) == 0 || (drawable = this.f7773e) == null) {
            drawable = this.f7772d;
        }
        this.f7769a.setLogo(drawable);
    }
}
