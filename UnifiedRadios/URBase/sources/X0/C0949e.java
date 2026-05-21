package x0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import f2.C0477a;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: x0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0949e extends AbstractC0950f implements Animatable {

    /* renamed from: e, reason: collision with root package name */
    public final Context f10367e;

    /* renamed from: f, reason: collision with root package name */
    public S1.a f10368f = null;
    public ArrayList g = null;
    public final C0947c h = new C0947c(this);

    /* renamed from: d, reason: collision with root package name */
    public final C0948d f10366d = new C0948d();

    public C0949e(Context context) {
        this.f10367e = context;
    }

    @Override // x0.AbstractC0950f, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            return F.b.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        C0948d c0948d = this.f10366d;
        c0948d.f10362a.draw(canvas);
        if (c0948d.f10363b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f10369c;
        return drawable != null ? F.a.a(drawable) : this.f10366d.f10362a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f10366d.getClass();
        return changingConfigurations | 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f10369c;
        return drawable != null ? F.b.c(drawable) : this.f10366d.f10362a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f10369c != null) {
            return new C0477a(this.f10369c.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f10366d.f10362a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f10366d.f10362a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.getOpacity() : this.f10366d.f10362a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        if (r3.f10363b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        r3.f10363b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d3, code lost:
    
        r3.f10363b.playTogether(r3.f10364c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r10, org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.content.res.Resources.Theme r13) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            r9 = this;
            android.graphics.drawable.Drawable r0 = r9.f10369c
            if (r0 == 0) goto L8
            F.b.d(r0, r10, r11, r12, r13)
            return
        L8:
            int r0 = r11.getEventType()
            int r1 = r11.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            x0.d r3 = r9.f10366d
            if (r0 == r2) goto Lc8
            int r4 = r11.getDepth()
            if (r4 >= r1) goto L1f
            r4 = 3
            if (r0 == r4) goto Lc8
        L1f:
            r4 = 2
            if (r0 != r4) goto Lc2
            java.lang.String r0 = r11.getName()
            java.lang.String r4 = "animated-vector"
            boolean r4 = r4.equals(r0)
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L68
            int[] r0 = x0.AbstractC0945a.f10358e
            android.content.res.TypedArray r0 = D.b.f(r10, r13, r12, r0)
            int r4 = r0.getResourceId(r6, r6)
            if (r4 == 0) goto L64
            x0.o r7 = new x0.o
            r7.<init>()
            java.lang.ThreadLocal r8 = D.p.f225a
            android.graphics.drawable.Drawable r4 = D.i.a(r10, r4, r13)
            r7.f10369c = r4
            x0.n r4 = new x0.n
            android.graphics.drawable.Drawable r8 = r7.f10369c
            android.graphics.drawable.Drawable$ConstantState r8 = r8.getConstantState()
            r4.<init>(r8)
            r7.h = r6
            x0.c r4 = r9.h
            r7.setCallback(r4)
            x0.o r4 = r3.f10362a
            if (r4 == 0) goto L62
            r4.setCallback(r5)
        L62:
            r3.f10362a = r7
        L64:
            r0.recycle()
            goto Lc2
        L68:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lc2
            int[] r0 = x0.AbstractC0945a.f10359f
            android.content.res.TypedArray r0 = r10.obtainAttributes(r12, r0)
            java.lang.String r4 = r0.getString(r6)
            int r6 = r0.getResourceId(r2, r6)
            if (r6 == 0) goto Lbf
            android.content.Context r7 = r9.f10367e
            if (r7 == 0) goto Lb4
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r7, r6)
            x0.o r7 = r3.f10362a
            x0.m r7 = r7.f10417d
            x0.l r7 = r7.f10406b
            q.b r7 = r7.f10404o
            java.lang.Object r5 = r7.getOrDefault(r4, r5)
            r6.setTarget(r5)
            java.util.ArrayList r5 = r3.f10364c
            if (r5 != 0) goto La9
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3.f10364c = r5
            q.b r5 = new q.b
            r5.<init>()
            r3.f10365d = r5
        La9:
            java.util.ArrayList r5 = r3.f10364c
            r5.add(r6)
            q.b r3 = r3.f10365d
            r3.put(r6, r4)
            goto Lbf
        Lb4:
            r0.recycle()
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Context can't be null when inflating animators"
            r10.<init>(r11)
            throw r10
        Lbf:
            r0.recycle()
        Lc2:
            int r0 = r11.next()
            goto L12
        Lc8:
            android.animation.AnimatorSet r10 = r3.f10363b
            if (r10 != 0) goto Ld3
            android.animation.AnimatorSet r10 = new android.animation.AnimatorSet
            r10.<init>()
            r3.f10363b = r10
        Ld3:
            android.animation.AnimatorSet r10 = r3.f10363b
            java.util.ArrayList r11 = r3.f10364c
            r10.playTogether(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.C0949e.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f10369c;
        return drawable != null ? F.a.d(drawable) : this.f10366d.f10362a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f10369c;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f10366d.f10363b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.isStateful() : this.f10366d.f10362a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f10366d.f10362a.setBounds(rect);
        }
    }

    @Override // x0.AbstractC0950f, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i5) {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.setLevel(i5) : this.f10366d.f10362a.setLevel(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f10369c;
        return drawable != null ? drawable.setState(iArr) : this.f10366d.f10362a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else {
            this.f10366d.f10362a.setAlpha(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.a.e(drawable, z4);
        } else {
            this.f10366d.f10362a.setAutoMirrored(z4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f10366d.f10362a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i5) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            A2.b.x(drawable, i5);
        } else {
            this.f10366d.f10362a.setTint(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.b.h(drawable, colorStateList);
        } else {
            this.f10366d.f10362a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            F.b.i(drawable, mode);
        } else {
            this.f10366d.f10362a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            return drawable.setVisible(z4, z5);
        }
        this.f10366d.f10362a.setVisible(z4, z5);
        return super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        C0948d c0948d = this.f10366d;
        if (c0948d.f10363b.isStarted()) {
            return;
        }
        c0948d.f10363b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f10369c;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f10366d.f10363b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
