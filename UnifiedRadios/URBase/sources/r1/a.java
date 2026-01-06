package R1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.unified.ur1.R;
import g2.C0546j;
import g2.InterfaceC0545i;
import g2.m;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import k2.d;
import n2.C0802a;
import n2.h;

/* loaded from: classes.dex */
public final class a extends Drawable implements InterfaceC0545i {

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f2229c;

    /* renamed from: d, reason: collision with root package name */
    public final h f2230d;

    /* renamed from: e, reason: collision with root package name */
    public final C0546j f2231e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f2232f;
    public final c g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f2233i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2234j;

    /* renamed from: k, reason: collision with root package name */
    public float f2235k;

    /* renamed from: l, reason: collision with root package name */
    public float f2236l;

    /* renamed from: m, reason: collision with root package name */
    public float f2237m;
    public WeakReference n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference f2238o;

    public a(Context context, b bVar) {
        d dVar;
        WeakReference weakReference = new WeakReference(context);
        this.f2229c = weakReference;
        m.c(context, m.f6947b, "Theme.MaterialComponents");
        this.f2232f = new Rect();
        C0546j c0546j = new C0546j(this);
        this.f2231e = c0546j;
        TextPaint textPaint = c0546j.f6940a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        c cVar = new c(context, bVar);
        this.g = cVar;
        boolean zE = e();
        b bVar2 = cVar.f2268b;
        h hVar = new h(n2.m.a(context, zE ? bVar2.f2256p.intValue() : bVar2.n.intValue(), e() ? bVar2.f2257q.intValue() : bVar2.f2255o.intValue(), new C0802a(0)).a());
        this.f2230d = hVar;
        g();
        Context context2 = (Context) weakReference.get();
        if (context2 != null && c0546j.g != (dVar = new d(context2, bVar2.f2254m.intValue()))) {
            c0546j.c(dVar, context2);
            textPaint.setColor(bVar2.f2253l.intValue());
            invalidateSelf();
            i();
            invalidateSelf();
        }
        int i5 = bVar2.f2261u;
        if (i5 != -2) {
            this.f2234j = ((int) Math.pow(10.0d, i5 - 1.0d)) - 1;
        } else {
            this.f2234j = bVar2.f2262v;
        }
        c0546j.f6944e = true;
        i();
        invalidateSelf();
        c0546j.f6944e = true;
        g();
        i();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(bVar2.f2252k.intValue());
        if (hVar.f8806c.f8789c != colorStateListValueOf) {
            hVar.l(colorStateListValueOf);
            invalidateSelf();
        }
        textPaint.setColor(bVar2.f2253l.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.n;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = (View) this.n.get();
            WeakReference weakReference3 = this.f2238o;
            h(view, weakReference3 != null ? (FrameLayout) weakReference3.get() : null);
        }
        i();
        setVisible(bVar2.f2241C.booleanValue(), false);
    }

    @Override // g2.InterfaceC0545i
    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        c cVar = this.g;
        b bVar = cVar.f2268b;
        String str = bVar.f2259s;
        boolean z4 = str != null;
        WeakReference weakReference = this.f2229c;
        if (z4) {
            int i5 = bVar.f2261u;
            if (i5 == -2 || str == null || str.length() <= i5) {
                return str;
            }
            Context context = (Context) weakReference.get();
            if (context == null) {
                return "";
            }
            return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), str.substring(0, i5 - 1), "…");
        }
        if (!f()) {
            return null;
        }
        int i6 = this.f2234j;
        b bVar2 = cVar.f2268b;
        if (i6 == -2 || d() <= this.f2234j) {
            return NumberFormat.getInstance(bVar2.f2263w).format(d());
        }
        Context context2 = (Context) weakReference.get();
        return context2 == null ? "" : String.format(bVar2.f2263w, context2.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f2234j), "+");
    }

    public final FrameLayout c() {
        WeakReference weakReference = this.f2238o;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public final int d() {
        int i5 = this.g.f2268b.f2260t;
        if (i5 != -1) {
            return i5;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        String strB;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f2230d.draw(canvas);
        if (!e() || (strB = b()) == null) {
            return;
        }
        Rect rect = new Rect();
        C0546j c0546j = this.f2231e;
        c0546j.f6940a.getTextBounds(strB, 0, strB.length(), rect);
        float fExactCenterY = this.f2233i - rect.exactCenterY();
        canvas.drawText(strB, this.h, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), c0546j.f6940a);
    }

    public final boolean e() {
        return this.g.f2268b.f2259s != null || f();
    }

    public final boolean f() {
        b bVar = this.g.f2268b;
        return bVar.f2259s == null && bVar.f2260t != -1;
    }

    public final void g() {
        Context context = (Context) this.f2229c.get();
        if (context == null) {
            return;
        }
        boolean zE = e();
        c cVar = this.g;
        this.f2230d.setShapeAppearanceModel(n2.m.a(context, zE ? cVar.f2268b.f2256p.intValue() : cVar.f2268b.n.intValue(), e() ? cVar.f2268b.f2257q.intValue() : cVar.f2268b.f2255o.intValue(), new C0802a(0)).a());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.g.f2268b.f2258r;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f2232f.height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f2232f.width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void h(View view, FrameLayout frameLayout) {
        this.n = new WeakReference(view);
        this.f2238o = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        i();
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: R1.a.i():void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, g2.InterfaceC0545i
    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        c cVar = this.g;
        cVar.f2267a.f2258r = i5;
        cVar.f2268b.f2258r = i5;
        this.f2231e.f6940a.setAlpha(getAlpha());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
