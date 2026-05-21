package l4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import org.osmdroid.views.MapView;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final MapView f8440a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f8441b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f8442c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f8443d;

    /* renamed from: e, reason: collision with root package name */
    public Bitmap f8444e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f8445f;
    public int g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8446i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8447j;

    /* renamed from: k, reason: collision with root package name */
    public final float f8448k;

    /* renamed from: l, reason: collision with root package name */
    public final float f8449l;

    /* renamed from: m, reason: collision with root package name */
    public float f8450m;
    public float n;

    /* renamed from: o, reason: collision with root package name */
    public float f8451o;

    /* renamed from: p, reason: collision with root package name */
    public float f8452p;

    public c(MapView mapView) {
        new Point();
        this.f8440a = mapView;
        this.f8447j = true;
        this.h = 2;
        this.f8446i = 3;
        this.f8448k = 0.5f;
        this.f8449l = 0.5f;
        e();
    }

    public final Bitmap a(boolean z4, boolean z5) {
        if (this.f8441b == null) {
            Bitmap bitmapC = c(true, true);
            Bitmap bitmapC2 = c(true, false);
            Bitmap bitmapC3 = c(false, true);
            Bitmap bitmapC4 = c(false, false);
            this.f8441b = bitmapC;
            this.f8443d = bitmapC2;
            this.f8442c = bitmapC3;
            this.f8444e = bitmapC4;
            this.g = bitmapC.getWidth();
            e();
        }
        return z4 ? z5 ? this.f8441b : this.f8443d : z5 ? this.f8442c : this.f8444e;
    }

    public final float b(boolean z4, boolean z5) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12 = BitmapDescriptorFactory.HUE_RED;
        MapView mapView = this.f8440a;
        if (z5) {
            int width = mapView.getWidth();
            int iC = AbstractC0882e.c(this.h);
            if (iC != 0) {
                if (iC == 1) {
                    f11 = width / 2.0f;
                    if (this.f8447j) {
                        float f13 = this.f8449l;
                        float f14 = this.g;
                        f12 = ((f13 * f14) / 2.0f) + f14;
                    } else {
                        f12 = this.g / 2.0f;
                    }
                } else {
                    if (iC != 2) {
                        throw new IllegalArgumentException();
                    }
                    float f15 = width - this.f8451o;
                    float f16 = this.g;
                    f11 = f15 - f16;
                    if (this.f8447j) {
                        f12 = (this.f8449l * f16) + f16;
                    }
                }
                f10 = f11 - f12;
            } else {
                f10 = this.f8450m;
            }
            if (!this.f8447j || !z4) {
                return f10;
            }
            f6 = this.g;
            f7 = f10 + f6;
            f8 = this.f8449l;
        } else {
            int height = mapView.getHeight();
            int iC2 = AbstractC0882e.c(this.f8446i);
            if (iC2 != 0) {
                if (iC2 == 1) {
                    f9 = height / 2.0f;
                    if (this.f8447j) {
                        f12 = this.g / 2.0f;
                    } else {
                        float f17 = this.f8449l;
                        float f18 = this.g;
                        f12 = ((f17 * f18) / 2.0f) + f18;
                    }
                } else {
                    if (iC2 != 2) {
                        throw new IllegalArgumentException();
                    }
                    float f19 = height - this.f8452p;
                    float f20 = this.g;
                    f9 = f19 - f20;
                    if (!this.f8447j) {
                        f12 = (this.f8449l * f20) + f20;
                    }
                }
                f5 = f9 - f12;
            } else {
                f5 = this.n;
            }
            if (this.f8447j || z4) {
                return f5;
            }
            f6 = this.g;
            f7 = f5 + f6;
            f8 = this.f8449l;
        }
        return (f8 * f6) + f7;
    }

    public final Bitmap c(boolean z4, boolean z5) {
        Bitmap bitmap = ((BitmapDrawable) this.f8440a.getResources().getDrawable(z4 ? R.drawable.sharp_add_black_36 : R.drawable.sharp_remove_black_36)).getBitmap();
        this.g = bitmap.getWidth();
        e();
        int i5 = this.g;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(z5 ? -1 : -3355444);
        paint.setStyle(Paint.Style.FILL);
        float f5 = this.g - 1;
        canvas.drawRect(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f5, f5, paint);
        canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
        return bitmapCreateBitmap;
    }

    public final boolean d(MotionEvent motionEvent, boolean z4) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        int x4 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        float f5 = x4;
        float fB = b(z4, true);
        if (f5 < fB || f5 > fB + this.g) {
            return false;
        }
        float f6 = y4;
        float fB2 = b(z4, false);
        return f6 >= fB2 && f6 <= fB2 + ((float) this.g);
    }

    public final void e() {
        float f5 = (this.f8448k * this.g) + BitmapDescriptorFactory.HUE_RED;
        this.f8450m = f5;
        this.n = f5;
        this.f8451o = f5;
        this.f8452p = f5;
    }
}
