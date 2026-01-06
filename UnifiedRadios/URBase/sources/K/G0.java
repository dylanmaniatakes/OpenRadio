package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.unified.ur1.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class G0 {
    public static G0 g;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f7649a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakHashMap f7650b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f7651c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7652d;

    /* renamed from: e, reason: collision with root package name */
    public X2.n f7653e;

    /* renamed from: f, reason: collision with root package name */
    public static final PorterDuff.Mode f7648f = PorterDuff.Mode.SRC_IN;
    public static final F0 h = new F0(6);

    public static synchronized G0 c() {
        try {
            if (g == null) {
                g = new G0();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static synchronized PorterDuffColorFilter g(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        F0 f02 = h;
        f02.getClass();
        int i6 = (31 + i5) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) f02.b(Integer.valueOf(mode.hashCode() + i6));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i5, mode);
        }
        return porterDuffColorFilter;
    }

    public final synchronized void a(Context context, long j5, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                q.e eVar = (q.e) this.f7650b.get(context);
                if (eVar == null) {
                    eVar = new q.e();
                    this.f7650b.put(context, eVar);
                }
                eVar.f(j5, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable b(Context context, int i5) throws Resources.NotFoundException {
        if (this.f7651c == null) {
            this.f7651c = new TypedValue();
        }
        TypedValue typedValue = this.f7651c;
        context.getResources().getValue(i5, typedValue, true);
        long j5 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable drawableD = d(context, j5);
        if (drawableD != null) {
            return drawableD;
        }
        LayerDrawable layerDrawableJ = null;
        if (this.f7653e != null) {
            if (i5 == R.drawable.abc_cab_background_top_material) {
                layerDrawableJ = new LayerDrawable(new Drawable[]{e(context, R.drawable.abc_cab_background_internal_bg), e(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i5 == R.drawable.abc_ratingbar_material) {
                layerDrawableJ = X2.n.j(this, context, R.dimen.abc_star_big);
            } else if (i5 == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableJ = X2.n.j(this, context, R.dimen.abc_star_medium);
            } else if (i5 == R.drawable.abc_ratingbar_small_material) {
                layerDrawableJ = X2.n.j(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableJ != null) {
            layerDrawableJ.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j5, layerDrawableJ);
        }
        return layerDrawableJ;
    }

    public final synchronized Drawable d(Context context, long j5) {
        q.e eVar = (q.e) this.f7650b.get(context);
        if (eVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) eVar.d(j5, null);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            eVar.g(j5);
        }
        return null;
    }

    public final synchronized Drawable e(Context context, int i5) {
        return f(context, i5, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9 A[Catch: all -> 0x00d8, TryCatch #0 {, blocks: (B:3:0x0001, B:12:0x0026, B:14:0x002c, B:16:0x0032, B:18:0x0039, B:25:0x0050, B:23:0x004c, B:26:0x0055, B:30:0x006c, B:37:0x00a2, B:38:0x00c9, B:43:0x00d4, B:6:0x0006, B:8:0x0012, B:10:0x0016, B:50:0x00dd, B:51:0x00e6), top: B:54:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized android.graphics.drawable.Drawable f(android.content.Context r9, int r10, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.f7652d     // Catch: java.lang.Throwable -> Ld8
            if (r0 == 0) goto L6
            goto L26
        L6:
            r0 = 1
            r8.f7652d = r0     // Catch: java.lang.Throwable -> Ld8
            r0 = 2131230838(0x7f080076, float:1.807774E38)
            android.graphics.drawable.Drawable r0 = r8.e(r9, r0)     // Catch: java.lang.Throwable -> Ld8
            if (r0 == 0) goto Ldc
            boolean r1 = r0 instanceof x0.C0959o     // Catch: java.lang.Throwable -> Ld8
            if (r1 != 0) goto L26
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r1 = "android.graphics.drawable.VectorDrawable"
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> Ld8
            if (r0 == 0) goto Ldc
        L26:
            android.graphics.drawable.Drawable r0 = r8.b(r9, r10)     // Catch: java.lang.Throwable -> Ld8
            if (r0 != 0) goto L30
            android.graphics.drawable.Drawable r0 = C.c.b(r9, r10)     // Catch: java.lang.Throwable -> Ld8
        L30:
            if (r0 == 0) goto Ld2
            android.content.res.ColorStateList r1 = r8.h(r9, r10)     // Catch: java.lang.Throwable -> Ld8
            r2 = 0
            if (r1 == 0) goto L55
            int[] r9 = k.AbstractC0636i0.f7786a     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r0 = r0.mutate()     // Catch: java.lang.Throwable -> Ld8
            F.b.h(r0, r1)     // Catch: java.lang.Throwable -> Ld8
            X2.n r9 = r8.f7653e     // Catch: java.lang.Throwable -> Ld8
            if (r9 != 0) goto L47
            goto L4e
        L47:
            r9 = 2131230825(0x7f080069, float:1.8077714E38)
            if (r10 != r9) goto L4e
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY     // Catch: java.lang.Throwable -> Ld8
        L4e:
            if (r2 == 0) goto Ld2
            F.b.i(r0, r2)     // Catch: java.lang.Throwable -> Ld8
            goto Ld2
        L55:
            X2.n r1 = r8.f7653e     // Catch: java.lang.Throwable -> Ld8
            if (r1 == 0) goto Lc9
            r1 = 2131230820(0x7f080064, float:1.8077704E38)
            r3 = 16908301(0x102000d, float:2.3877265E-38)
            r4 = 16908303(0x102000f, float:2.387727E-38)
            r5 = 16908288(0x1020000, float:2.387723E-38)
            r6 = 2130968833(0x7f040101, float:1.754633E38)
            r7 = 2130968835(0x7f040103, float:1.7546335E38)
            if (r10 != r1) goto L93
            r10 = r0
            android.graphics.drawable.LayerDrawable r10 = (android.graphics.drawable.LayerDrawable) r10     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r5)     // Catch: java.lang.Throwable -> Ld8
            int r1 = k.U0.c(r9, r7)     // Catch: java.lang.Throwable -> Ld8
            android.graphics.PorterDuff$Mode r2 = k.r.f7853b     // Catch: java.lang.Throwable -> Ld8
            X2.n.p(r11, r1)     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r4)     // Catch: java.lang.Throwable -> Ld8
            int r1 = k.U0.c(r9, r7)     // Catch: java.lang.Throwable -> Ld8
            X2.n.p(r11, r1)     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r10 = r10.findDrawableByLayerId(r3)     // Catch: java.lang.Throwable -> Ld8
            int r9 = k.U0.c(r9, r6)     // Catch: java.lang.Throwable -> Ld8
            X2.n.p(r10, r9)     // Catch: java.lang.Throwable -> Ld8
            goto Ld2
        L93:
            r1 = 2131230811(0x7f08005b, float:1.8077685E38)
            if (r10 == r1) goto La2
            r1 = 2131230810(0x7f08005a, float:1.8077683E38)
            if (r10 == r1) goto La2
            r1 = 2131230812(0x7f08005c, float:1.8077687E38)
            if (r10 != r1) goto Lc9
        La2:
            r10 = r0
            android.graphics.drawable.LayerDrawable r10 = (android.graphics.drawable.LayerDrawable) r10     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r5)     // Catch: java.lang.Throwable -> Ld8
            int r1 = k.U0.b(r9, r7)     // Catch: java.lang.Throwable -> Ld8
            android.graphics.PorterDuff$Mode r2 = k.r.f7853b     // Catch: java.lang.Throwable -> Ld8
            X2.n.p(r11, r1)     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r11 = r10.findDrawableByLayerId(r4)     // Catch: java.lang.Throwable -> Ld8
            int r1 = k.U0.c(r9, r6)     // Catch: java.lang.Throwable -> Ld8
            X2.n.p(r11, r1)     // Catch: java.lang.Throwable -> Ld8
            android.graphics.drawable.Drawable r10 = r10.findDrawableByLayerId(r3)     // Catch: java.lang.Throwable -> Ld8
            int r9 = k.U0.c(r9, r6)     // Catch: java.lang.Throwable -> Ld8
            X2.n.p(r10, r9)     // Catch: java.lang.Throwable -> Ld8
            goto Ld2
        Lc9:
            boolean r9 = r8.i(r9, r10, r0)     // Catch: java.lang.Throwable -> Ld8
            if (r9 != 0) goto Ld2
            if (r11 == 0) goto Ld2
            r0 = r2
        Ld2:
            if (r0 == 0) goto Lda
            k.AbstractC0636i0.a(r0)     // Catch: java.lang.Throwable -> Ld8
            goto Lda
        Ld8:
            r9 = move-exception
            goto Le7
        Lda:
            monitor-exit(r8)
            return r0
        Ldc:
            r9 = 0
            r8.f7652d = r9     // Catch: java.lang.Throwable -> Ld8
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r10 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r9.<init>(r10)     // Catch: java.lang.Throwable -> Ld8
            throw r9     // Catch: java.lang.Throwable -> Ld8
        Le7:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: k.G0.f(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList h(Context context, int i5) {
        ColorStateList colorStateList;
        q.l lVar;
        WeakHashMap weakHashMap = this.f7649a;
        ColorStateList colorStateListK = null;
        colorStateList = (weakHashMap == null || (lVar = (q.l) weakHashMap.get(context)) == null) ? null : (ColorStateList) lVar.c(i5, null);
        if (colorStateList == null) {
            X2.n nVar = this.f7653e;
            if (nVar != null) {
                colorStateListK = nVar.k(context, i5);
            }
            if (colorStateListK != null) {
                if (this.f7649a == null) {
                    this.f7649a = new WeakHashMap();
                }
                q.l lVar2 = (q.l) this.f7649a.get(context);
                if (lVar2 == null) {
                    lVar2 = new q.l();
                    this.f7649a.put(context, lVar2);
                }
                lVar2.a(i5, colorStateListK);
            }
            colorStateList = colorStateListK;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            X2.n r0 = r7.f7653e
            r1 = 0
            if (r0 == 0) goto L6e
            android.graphics.PorterDuff$Mode r2 = k.r.f7853b
            java.lang.Object r3 = r0.f2818a
            int[] r3 = (int[]) r3
            boolean r3 = X2.n.b(r3, r9)
            r4 = 1
            r5 = -1
            if (r3 == 0) goto L19
            r9 = 2130968835(0x7f040103, float:1.7546335E38)
        L16:
            r3 = r4
        L17:
            r0 = r5
            goto L55
        L19:
            java.lang.Object r3 = r0.f2820c
            int[] r3 = (int[]) r3
            boolean r3 = X2.n.b(r3, r9)
            if (r3 == 0) goto L27
            r9 = 2130968833(0x7f040101, float:1.754633E38)
            goto L16
        L27:
            java.lang.Object r0 = r0.f2821d
            int[] r0 = (int[]) r0
            boolean r0 = X2.n.b(r0, r9)
            r3 = 16842801(0x1010031, float:2.3693695E-38)
            if (r0 == 0) goto L38
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.MULTIPLY
        L36:
            r9 = r3
            goto L16
        L38:
            r0 = 2131230797(0x7f08004d, float:1.8077657E38)
            if (r9 != r0) goto L4c
            r9 = 1109603123(0x42233333, float:40.8)
            int r9 = java.lang.Math.round(r9)
            r0 = 16842800(0x1010030, float:2.3693693E-38)
            r3 = r4
            r6 = r0
            r0 = r9
            r9 = r6
            goto L55
        L4c:
            r0 = 2131230779(0x7f08003b, float:1.807762E38)
            if (r9 != r0) goto L52
            goto L36
        L52:
            r9 = r1
            r3 = r9
            goto L17
        L55:
            if (r3 == 0) goto L6e
            int[] r1 = k.AbstractC0636i0.f7786a
            android.graphics.drawable.Drawable r10 = r10.mutate()
            int r8 = k.U0.c(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = k.r.c(r8, r2)
            r10.setColorFilter(r8)
            if (r0 == r5) goto L6d
            r10.setAlpha(r0)
        L6d:
            r1 = r4
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k.G0.i(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
