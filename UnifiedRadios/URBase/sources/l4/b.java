package l4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.Thread;
import org.osmdroid.views.MapView;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public final MapView f8430b;

    /* renamed from: c, reason: collision with root package name */
    public final ValueAnimator f8431c;

    /* renamed from: d, reason: collision with root package name */
    public final c f8432d;

    /* renamed from: e, reason: collision with root package name */
    public j f8433e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8434f;
    public boolean g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8435i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8437k;

    /* renamed from: l, reason: collision with root package name */
    public long f8438l;

    /* renamed from: m, reason: collision with root package name */
    public Thread f8439m;
    public final a n;

    /* renamed from: a, reason: collision with root package name */
    public final Object f8429a = new Object();

    /* renamed from: j, reason: collision with root package name */
    public int f8436j = 2;

    public b(MapView mapView) {
        this.f8430b = mapView;
        this.f8432d = new c(mapView);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        this.f8431c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.setDuration(500);
        valueAnimatorOfFloat.addUpdateListener(new V1.a(2, this));
        this.n = new a(this, 0);
    }

    public final void a() {
        if (!this.f8435i && this.f8436j == 3) {
            float f5 = this.h;
            if (this.f8437k) {
                this.f8437k = false;
            } else {
                this.f8437k = f5 == BitmapDescriptorFactory.HUE_RED;
            }
            this.f8431c.cancel();
            this.h = 1.0f;
            this.f8438l = System.currentTimeMillis();
            if (!this.f8435i) {
                this.f8430b.postInvalidate();
            }
            Thread thread = this.f8439m;
            if (thread == null || thread.getState() == Thread.State.TERMINATED) {
                synchronized (this.f8429a) {
                    try {
                        Thread thread2 = this.f8439m;
                        if (thread2 == null || thread2.getState() == Thread.State.TERMINATED) {
                            Thread thread3 = new Thread(this.n);
                            this.f8439m = thread3;
                            thread3.setName(b.class.getName().concat("#active"));
                            this.f8439m.start();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public final void b(Canvas canvas) {
        Paint paint;
        float f5 = this.h;
        boolean z4 = this.f8434f;
        boolean z5 = this.g;
        c cVar = this.f8432d;
        if (f5 == BitmapDescriptorFactory.HUE_RED) {
            cVar.getClass();
            return;
        }
        if (f5 == 1.0f) {
            paint = null;
        } else {
            if (cVar.f8445f == null) {
                cVar.f8445f = new Paint();
            }
            cVar.f8445f.setAlpha((int) (f5 * 255.0f));
            paint = cVar.f8445f;
        }
        canvas.drawBitmap(cVar.a(true, z4), cVar.b(true, true), cVar.b(true, false), paint);
        canvas.drawBitmap(cVar.a(false, z5), cVar.b(false, true), cVar.b(false, false), paint);
    }

    public final void c(int i5) {
        this.f8436j = i5;
        int iC = AbstractC0882e.c(i5);
        if (iC == 0) {
            this.h = 1.0f;
        } else if (iC == 1 || iC == 2) {
            this.h = BitmapDescriptorFactory.HUE_RED;
        }
    }
}
