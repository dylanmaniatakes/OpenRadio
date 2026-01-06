package S;

import C0.A;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class g implements View.OnTouchListener {

    /* renamed from: t, reason: collision with root package name */
    public static final int f2335t = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    public final a f2336c;

    /* renamed from: d, reason: collision with root package name */
    public final AccelerateInterpolator f2337d;

    /* renamed from: e, reason: collision with root package name */
    public final View f2338e;

    /* renamed from: f, reason: collision with root package name */
    public A f2339f;
    public final float[] g;
    public final float[] h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2340i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2341j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f2342k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f2343l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f2344m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2345o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2346p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2347q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2348r;

    /* renamed from: s, reason: collision with root package name */
    public final ListView f2349s;

    public g(ListView listView) {
        a aVar = new a();
        aVar.f2332e = Long.MIN_VALUE;
        aVar.g = -1L;
        aVar.f2333f = 0L;
        this.f2336c = aVar;
        this.f2337d = new AccelerateInterpolator();
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        this.g = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.h = fArr2;
        float[] fArr3 = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        this.f2342k = fArr3;
        float[] fArr4 = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        this.f2343l = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2344m = fArr5;
        this.f2338e = listView;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = ((int) ((1575.0f * f5) + 0.5f)) / 1000.0f;
        fArr5[0] = f6;
        fArr5[1] = f6;
        float f7 = ((int) ((f5 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f7;
        fArr4[1] = f7;
        this.f2340i = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f2341j = f2335t;
        aVar.f2328a = 500;
        aVar.f2329b = 500;
        this.f2349s = listView;
    }

    public static float b(float f5, float f6, float f7) {
        return f5 > f7 ? f7 : f5 < f6 ? f6 : f5;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.g
            r0 = r0[r7]
            float[] r1 = r3.h
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f2337d
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f2342k
            r0 = r0[r7]
            float[] r1 = r3.f2343l
            r1 = r1[r7]
            float[] r2 = r3.f2344m
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: S.g.a(float, float, float, int):float");
    }

    public final float c(float f5, float f6) {
        if (f6 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        int i5 = this.f2340i;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                if (f5 >= BitmapDescriptorFactory.HUE_RED) {
                    return 1.0f - (f5 / f6);
                }
                if (this.f2347q && i5 == 1) {
                    return 1.0f;
                }
            }
        } else if (i5 == 2 && f5 < BitmapDescriptorFactory.HUE_RED) {
            return f5 / (-f6);
        }
        return BitmapDescriptorFactory.HUE_RED;
    }

    public final void d() {
        int i5 = 0;
        if (this.f2345o) {
            this.f2347q = false;
            return;
        }
        a aVar = this.f2336c;
        aVar.getClass();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i6 = (int) (jCurrentAnimationTimeMillis - aVar.f2332e);
        int i7 = aVar.f2329b;
        if (i6 > i7) {
            i5 = i7;
        } else if (i6 >= 0) {
            i5 = i6;
        }
        aVar.f2334i = i5;
        aVar.h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        ListView listView;
        int count;
        a aVar = this.f2336c;
        float f5 = aVar.f2331d;
        int iAbs = (int) (f5 / Math.abs(f5));
        Math.abs(aVar.f2330c);
        if (iAbs == 0 || (count = (listView = this.f2349s).getCount()) == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i5 = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i5 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) throws java.lang.InterruptedException, android.database.SQLException {
        /*
            r7 = this;
            boolean r0 = r7.f2348r
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7d
        L16:
            r7.d()
            goto L7d
        L1a:
            r7.f2346p = r2
            r7.n = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.f2338e
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            S.a r9 = r7.f2336c
            r9.f2330c = r0
            r9.f2331d = r8
            boolean r8 = r7.f2347q
            if (r8 != 0) goto L7d
            boolean r8 = r7.e()
            if (r8 == 0) goto L7d
            C0.A r8 = r7.f2339f
            if (r8 != 0) goto L61
            C0.A r8 = new C0.A
            r9 = 10
            r8.<init>(r9, r7)
            r7.f2339f = r8
        L61:
            r7.f2347q = r2
            r7.f2345o = r2
            boolean r8 = r7.n
            if (r8 != 0) goto L76
            int r8 = r7.f2341j
            if (r8 <= 0) goto L76
            C0.A r9 = r7.f2339f
            long r5 = (long) r8
            java.util.WeakHashMap r8 = O.Y.f1904a
            O.G.n(r4, r9, r5)
            goto L7b
        L76:
            C0.A r8 = r7.f2339f
            r8.run()
        L7b:
            r7.n = r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
