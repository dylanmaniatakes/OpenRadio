package m2;

import android.graphics.Paint;
import android.graphics.Path;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: m2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0762a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f8548i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f8549j = {BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f8550k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f8551l = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f8552a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8553b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f8554c;

    /* renamed from: d, reason: collision with root package name */
    public int f8555d;

    /* renamed from: e, reason: collision with root package name */
    public int f8556e;

    /* renamed from: f, reason: collision with root package name */
    public int f8557f;
    public final Path g = new Path();
    public final Paint h;

    public C0762a() {
        Paint paint = new Paint();
        this.h = paint;
        this.f8552a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f8553b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f8554c = new Paint(paint2);
    }

    public final void a(int i5) {
        this.f8555d = E.a.d(i5, 68);
        this.f8556e = E.a.d(i5, 20);
        this.f8557f = E.a.d(i5, 0);
        this.f8552a.setColor(this.f8555d);
    }
}
