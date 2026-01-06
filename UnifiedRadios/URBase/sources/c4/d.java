package c4;

import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: A, reason: collision with root package name */
    public static final Method f4587A;

    /* renamed from: B, reason: collision with root package name */
    public static final Method f4588B;

    /* renamed from: C, reason: collision with root package name */
    public static final Method f4589C;

    /* renamed from: D, reason: collision with root package name */
    public static final int f4590D;

    /* renamed from: E, reason: collision with root package name */
    public static final int f4591E;

    /* renamed from: F, reason: collision with root package name */
    public static final float[] f4592F;

    /* renamed from: G, reason: collision with root package name */
    public static final float[] f4593G;

    /* renamed from: H, reason: collision with root package name */
    public static final float[] f4594H;
    public static final int[] I;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f4595u;

    /* renamed from: v, reason: collision with root package name */
    public static final Method f4596v;

    /* renamed from: w, reason: collision with root package name */
    public static final Method f4597w;

    /* renamed from: x, reason: collision with root package name */
    public static final Method f4598x;

    /* renamed from: y, reason: collision with root package name */
    public static final Method f4599y;

    /* renamed from: z, reason: collision with root package name */
    public static final Method f4600z;

    /* renamed from: a, reason: collision with root package name */
    public a f4601a;

    /* renamed from: b, reason: collision with root package name */
    public b f4602b;

    /* renamed from: c, reason: collision with root package name */
    public b f4603c;

    /* renamed from: d, reason: collision with root package name */
    public float f4604d;

    /* renamed from: e, reason: collision with root package name */
    public float f4605e;

    /* renamed from: f, reason: collision with root package name */
    public float f4606f;
    public float g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f4607i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4608j;

    /* renamed from: k, reason: collision with root package name */
    public MapView f4609k;

    /* renamed from: l, reason: collision with root package name */
    public c f4610l;

    /* renamed from: m, reason: collision with root package name */
    public long f4611m;
    public float n;

    /* renamed from: o, reason: collision with root package name */
    public float f4612o;

    /* renamed from: p, reason: collision with root package name */
    public float f4613p;

    /* renamed from: q, reason: collision with root package name */
    public float f4614q;

    /* renamed from: r, reason: collision with root package name */
    public float f4615r;

    /* renamed from: s, reason: collision with root package name */
    public float f4616s;

    /* renamed from: t, reason: collision with root package name */
    public int f4617t;

    static {
        boolean z4;
        try {
            f4596v = MotionEvent.class.getMethod("getPointerCount", null);
            Class cls = Integer.TYPE;
            f4597w = MotionEvent.class.getMethod("getPointerId", cls);
            f4598x = MotionEvent.class.getMethod("getPressure", cls);
            f4599y = MotionEvent.class.getMethod("getHistoricalX", cls, cls);
            f4600z = MotionEvent.class.getMethod("getHistoricalY", cls, cls);
            f4587A = MotionEvent.class.getMethod("getHistoricalPressure", cls, cls);
            f4588B = MotionEvent.class.getMethod("getX", cls);
            f4589C = MotionEvent.class.getMethod("getY", cls);
            z4 = true;
        } catch (Exception e5) {
            Log.e("MultiTouchController", "static initializer failed", e5);
            z4 = false;
        }
        f4595u = z4;
        if (z4) {
            try {
                f4590D = MotionEvent.class.getField("ACTION_POINTER_UP").getInt(null);
                f4591E = MotionEvent.class.getField("ACTION_POINTER_INDEX_SHIFT").getInt(null);
            } catch (Exception unused) {
            }
        }
        f4592F = new float[20];
        f4593G = new float[20];
        f4594H = new float[20];
        I = new int[20];
    }

    public final void a() {
        if (this.f4609k == null) {
            return;
        }
        MapView mapView = (MapView) this.f4601a;
        mapView.f9036O = mapView.getZoomLevelDouble();
        PointF pointF = mapView.f9054q;
        float f5 = pointF.x;
        float f6 = pointF.y;
        c cVar = this.f4610l;
        cVar.f4580a = f5;
        cVar.f4581b = f6;
        cVar.g = true;
        cVar.f4582c = 1.0f;
        cVar.h = false;
        cVar.f4583d = 1.0f;
        cVar.f4584e = 1.0f;
        cVar.f4586i = false;
        cVar.f4585f = BitmapDescriptorFactory.HUE_RED;
        float f7 = 1.0f / 1.0f;
        c();
        this.n = (this.f4604d - cVar.f4580a) * f7;
        this.f4612o = (this.f4605e - cVar.f4581b) * f7;
        this.f4613p = cVar.f4582c / this.f4606f;
        this.f4615r = cVar.f4583d / this.g;
        this.f4616s = cVar.f4584e / this.h;
        this.f4614q = cVar.f4585f - this.f4607i;
    }

    public final void b(int i5, float[] fArr, float[] fArr2, float[] fArr3, int[] iArr, boolean z4, long j5) {
        b bVar = this.f4603c;
        this.f4603c = this.f4602b;
        this.f4602b = bVar;
        bVar.f4579q = j5;
        for (int i6 = 0; i6 < i5; i6++) {
            bVar.f4566a[i6] = fArr[i6];
            bVar.f4567b[i6] = fArr2[i6];
            bVar.f4568c[i6] = fArr3[i6];
            bVar.f4569d[i6] = iArr[i6];
        }
        bVar.f4575l = z4;
        boolean z5 = i5 >= 2;
        bVar.f4576m = z5;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        if (z5) {
            float f6 = fArr[0];
            float f7 = fArr[1];
            bVar.f4570e = (f6 + f7) * 0.5f;
            bVar.f4571f = (fArr2[0] + fArr2[1]) * 0.5f;
            float f8 = fArr3[0];
            float f9 = fArr3[1];
            bVar.g = Math.abs(f7 - f6);
            bVar.h = Math.abs(fArr2[1] - fArr2[0]);
        } else {
            bVar.f4570e = fArr[0];
            bVar.f4571f = fArr2[0];
            float f10 = fArr3[0];
            bVar.h = BitmapDescriptorFactory.HUE_RED;
            bVar.g = BitmapDescriptorFactory.HUE_RED;
        }
        bVar.f4578p = false;
        bVar.f4577o = false;
        bVar.n = false;
        int i7 = this.f4617t;
        a aVar = this.f4601a;
        MapView mapView = null;
        if (i7 == 0) {
            b bVar2 = this.f4602b;
            if (bVar2.f4575l) {
                MapView mapView2 = (MapView) aVar;
                if (!mapView2.f9049k.get()) {
                    mapView2.f(bVar2.f4570e, bVar2.f4571f);
                    mapView = mapView2;
                }
                this.f4609k = mapView;
                if (mapView != null) {
                    this.f4617t = 1;
                    mapView2.e();
                    a();
                    this.f4611m = this.f4602b.f4579q;
                    return;
                }
                return;
            }
            return;
        }
        if (i7 == 1) {
            b bVar3 = this.f4602b;
            if (!bVar3.f4575l) {
                this.f4617t = 0;
                this.f4609k = null;
                ((MapView) aVar).e();
                return;
            } else if (bVar3.f4576m) {
                this.f4617t = 2;
                a();
                this.f4611m = this.f4602b.f4579q + 20;
                return;
            } else if (bVar3.f4579q < this.f4611m) {
                a();
                return;
            } else {
                e();
                return;
            }
        }
        if (i7 != 2) {
            return;
        }
        b bVar4 = this.f4602b;
        if (!bVar4.f4576m || !bVar4.f4575l) {
            if (bVar4.f4575l) {
                this.f4617t = 1;
                a();
                this.f4611m = this.f4602b.f4579q + 20;
                return;
            } else {
                this.f4617t = 0;
                this.f4609k = null;
                ((MapView) aVar).e();
                return;
            }
        }
        if (Math.abs(bVar4.f4570e - this.f4603c.f4570e) <= 30.0f && Math.abs(this.f4602b.f4571f - this.f4603c.f4571f) <= 30.0f) {
            b bVar5 = this.f4602b;
            float f11 = bVar5.f4576m ? bVar5.g : 0.0f;
            b bVar6 = this.f4603c;
            if (Math.abs(f11 - (bVar6.f4576m ? bVar6.g : 0.0f)) * 0.5f <= 40.0f) {
                b bVar7 = this.f4602b;
                float f12 = bVar7.f4576m ? bVar7.h : 0.0f;
                b bVar8 = this.f4603c;
                if (bVar8.f4576m) {
                    f5 = bVar8.h;
                }
                if (Math.abs(f12 - f5) * 0.5f <= 40.0f) {
                    if (this.f4602b.f4579q < this.f4611m) {
                        a();
                        return;
                    } else {
                        e();
                        return;
                    }
                }
            }
        }
        a();
        this.f4611m = this.f4602b.f4579q + 20;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.d.c():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean d(MotionEvent motionEvent) {
        int iIntValue;
        int i5 = 1;
        int i6 = 0;
        boolean z4 = f4595u;
        if (z4) {
            try {
                iIntValue = ((Integer) f4596v.invoke(motionEvent, null)).intValue();
            } catch (Exception e5) {
                Log.e("MultiTouchController", "onTouchEvent() failed", e5);
                return false;
            }
        } else {
            iIntValue = 1;
        }
        if (this.f4617t == 0 && !this.f4608j && iIntValue == 1) {
            return false;
        }
        int action = motionEvent.getAction();
        int historySize = motionEvent.getHistorySize() / iIntValue;
        int i7 = 0;
        while (i7 <= historySize) {
            int i8 = i7 < historySize ? i5 : i6;
            float[] fArr = f4594H;
            float[] fArr2 = f4593G;
            float[] fArr3 = f4592F;
            if (!z4 || iIntValue == i5) {
                fArr3[0] = i8 != 0 ? motionEvent.getHistoricalX(i7) : motionEvent.getX();
                fArr2[0] = i8 != 0 ? motionEvent.getHistoricalY(i7) : motionEvent.getY();
                fArr[0] = i8 != 0 ? motionEvent.getHistoricalPressure(i7) : motionEvent.getPressure();
            } else {
                int iMin = Math.min(iIntValue, 20);
                for (int i9 = i6; i9 < iMin; i9++) {
                    I[i9] = ((Integer) f4597w.invoke(motionEvent, Integer.valueOf(i9))).intValue();
                    fArr3[i9] = ((Float) (i8 != 0 ? f4599y.invoke(motionEvent, Integer.valueOf(i9), Integer.valueOf(i7)) : f4588B.invoke(motionEvent, Integer.valueOf(i9)))).floatValue();
                    fArr2[i9] = ((Float) (i8 != 0 ? f4600z.invoke(motionEvent, Integer.valueOf(i9), Integer.valueOf(i7)) : f4589C.invoke(motionEvent, Integer.valueOf(i9)))).floatValue();
                    fArr[i9] = ((Float) (i8 != 0 ? f4587A.invoke(motionEvent, Integer.valueOf(i9), Integer.valueOf(i7)) : f4598x.invoke(motionEvent, Integer.valueOf(i9)))).floatValue();
                }
            }
            int i10 = historySize;
            int i11 = i7;
            b(iIntValue, f4592F, f4593G, f4594H, I, (i8 == 0 && (action == 1 || (action & ((1 << f4591E) - 1)) == f4590D || action == 3)) ? false : true, i8 != 0 ? motionEvent.getHistoricalEventTime(i7) : motionEvent.getEventTime());
            i7 = i11 + 1;
            historySize = i10;
            i5 = 1;
            i6 = 0;
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r10 = this;
            org.osmdroid.views.MapView r0 = r10.f4609k
            if (r0 != 0) goto L5
            return
        L5:
            c4.c r0 = r10.f4610l
            boolean r1 = r0.g
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r1 != 0) goto L10
        Le:
            r1 = r3
            goto L17
        L10:
            float r1 = r0.f4582c
            int r4 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r4 != 0) goto L17
            goto Le
        L17:
            r10.c()
            float r4 = r10.f4604d
            float r5 = r10.n
            float r5 = r5 * r1
            float r4 = r4 - r5
            float r5 = r10.f4605e
            float r6 = r10.f4612o
            float r6 = r6 * r1
            float r5 = r5 - r6
            float r1 = r10.f4613p
            float r6 = r10.f4606f
            float r1 = r1 * r6
            float r6 = r10.f4615r
            float r7 = r10.g
            float r6 = r6 * r7
            float r7 = r10.f4616s
            float r8 = r10.h
            float r7 = r7 * r8
            float r8 = r10.f4614q
            float r9 = r10.f4607i
            float r8 = r8 + r9
            r0.f4580a = r4
            r0.f4581b = r5
            int r4 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r4 != 0) goto L43
            r1 = r3
        L43:
            r0.f4582c = r1
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L4a
            r6 = r3
        L4a:
            r0.f4583d = r6
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 != 0) goto L51
            r7 = r3
        L51:
            r0.f4584e = r7
            r0.f4585f = r8
            c4.a r1 = r10.f4601a
            org.osmdroid.views.MapView r1 = (org.osmdroid.views.MapView) r1
            r1.getClass()
            float r2 = r0.f4580a
            float r4 = r0.f4581b
            android.graphics.PointF r5 = new android.graphics.PointF
            r5.<init>(r2, r4)
            r1.f9056s = r5
            boolean r2 = r0.g
            if (r2 != 0) goto L6c
            goto L6e
        L6c:
            float r3 = r0.f4582c
        L6e:
            r1.setMultiTouchScale(r3)
            r1.requestLayout()
            r1.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.d.e():void");
    }
}
