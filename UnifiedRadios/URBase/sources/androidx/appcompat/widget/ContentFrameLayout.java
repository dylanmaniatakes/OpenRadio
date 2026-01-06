package androidx.appcompat.widget;

import L0.l;
import O.C0169i0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import f.x;
import j.m;
import k.C0627e;
import k.C0637j;
import k.InterfaceC0630f0;
import k.InterfaceC0632g0;
import k.f1;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f3380c;

    /* renamed from: d, reason: collision with root package name */
    public TypedValue f3381d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f3382e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f3383f;
    public TypedValue g;
    public TypedValue h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f3384i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0630f0 f3385j;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3384i = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.g == null) {
            this.g = new TypedValue();
        }
        return this.g;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.h == null) {
            this.h = new TypedValue();
        }
        return this.h;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f3382e == null) {
            this.f3382e = new TypedValue();
        }
        return this.f3382e;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f3383f == null) {
            this.f3383f = new TypedValue();
        }
        return this.f3383f;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f3380c == null) {
            this.f3380c = new TypedValue();
        }
        return this.f3380c;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f3381d == null) {
            this.f3381d = new TypedValue();
        }
        return this.f3381d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0630f0 interfaceC0630f0 = this.f3385j;
        if (interfaceC0630f0 != null) {
            interfaceC0630f0.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C0637j c0637j;
        super.onDetachedFromWindow();
        InterfaceC0630f0 interfaceC0630f0 = this.f3385j;
        if (interfaceC0630f0 != null) {
            x xVar = (x) ((l) interfaceC0630f0).f1554d;
            InterfaceC0632g0 interfaceC0632g0 = xVar.f6429t;
            if (interfaceC0632g0 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0632g0;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((f1) actionBarOverlayLayout.g).f7769a.f3461c;
                if (actionMenuView != null && (c0637j = actionMenuView.f3368v) != null) {
                    c0637j.c();
                    C0627e c0627e = c0637j.f7806w;
                    if (c0627e != null && c0627e.b()) {
                        c0627e.f7523j.dismiss();
                    }
                }
            }
            if (xVar.f6434y != null) {
                xVar.n.getDecorView().removeCallbacks(xVar.f6435z);
                if (xVar.f6434y.isShowing()) {
                    try {
                        xVar.f6434y.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                xVar.f6434y = null;
            }
            C0169i0 c0169i0 = xVar.f6388A;
            if (c0169i0 != null) {
                c0169i0.b();
            }
            m mVar = xVar.A(0).h;
            if (mVar != null) {
                mVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC0630f0 interfaceC0630f0) {
        this.f3385j = interfaceC0630f0;
    }
}
