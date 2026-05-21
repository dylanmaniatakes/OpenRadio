package x0;

import android.graphics.Paint;
import i3.C0573b;

/* renamed from: x0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0952h extends AbstractC0955k {

    /* renamed from: e, reason: collision with root package name */
    public C0573b f10370e;

    /* renamed from: f, reason: collision with root package name */
    public float f10371f;
    public C0573b g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f10372i;

    /* renamed from: j, reason: collision with root package name */
    public float f10373j;

    /* renamed from: k, reason: collision with root package name */
    public float f10374k;

    /* renamed from: l, reason: collision with root package name */
    public float f10375l;

    /* renamed from: m, reason: collision with root package name */
    public Paint.Cap f10376m;
    public Paint.Join n;

    /* renamed from: o, reason: collision with root package name */
    public float f10377o;

    @Override // x0.AbstractC0954j
    public final boolean a() {
        return this.g.h() || this.f10370e.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // x0.AbstractC0954j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r7) {
        /*
            r6 = this;
            i3.b r0 = r6.g
            boolean r1 = r0.h()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f7297e
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f7295c
            if (r1 == r4) goto L1e
            r0.f7295c = r1
            r0 = r3
            goto L1f
        L1e:
            r0 = r2
        L1f:
            i3.b r1 = r6.f10370e
            boolean r4 = r1.h()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f7297e
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f7295c
            if (r7 == r4) goto L3a
            r1.f7295c = r7
            r2 = r3
        L3a:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.C0952h.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f10372i;
    }

    public int getFillColor() {
        return this.g.f7295c;
    }

    public float getStrokeAlpha() {
        return this.h;
    }

    public int getStrokeColor() {
        return this.f10370e.f7295c;
    }

    public float getStrokeWidth() {
        return this.f10371f;
    }

    public float getTrimPathEnd() {
        return this.f10374k;
    }

    public float getTrimPathOffset() {
        return this.f10375l;
    }

    public float getTrimPathStart() {
        return this.f10373j;
    }

    public void setFillAlpha(float f5) {
        this.f10372i = f5;
    }

    public void setFillColor(int i5) {
        this.g.f7295c = i5;
    }

    public void setStrokeAlpha(float f5) {
        this.h = f5;
    }

    public void setStrokeColor(int i5) {
        this.f10370e.f7295c = i5;
    }

    public void setStrokeWidth(float f5) {
        this.f10371f = f5;
    }

    public void setTrimPathEnd(float f5) {
        this.f10374k = f5;
    }

    public void setTrimPathOffset(float f5) {
        this.f10375l = f5;
    }

    public void setTrimPathStart(float f5) {
        this.f10373j = f5;
    }
}
