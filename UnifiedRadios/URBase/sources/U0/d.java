package u0;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f9885a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f9886b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f9887c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f9888d;

    /* renamed from: e, reason: collision with root package name */
    public float f9889e;

    /* renamed from: f, reason: collision with root package name */
    public float f9890f;
    public float g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f9891i;

    /* renamed from: j, reason: collision with root package name */
    public int f9892j;

    /* renamed from: k, reason: collision with root package name */
    public float f9893k;

    /* renamed from: l, reason: collision with root package name */
    public float f9894l;

    /* renamed from: m, reason: collision with root package name */
    public float f9895m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public Path f9896o;

    /* renamed from: p, reason: collision with root package name */
    public float f9897p;

    /* renamed from: q, reason: collision with root package name */
    public float f9898q;

    /* renamed from: r, reason: collision with root package name */
    public int f9899r;

    /* renamed from: s, reason: collision with root package name */
    public int f9900s;

    /* renamed from: t, reason: collision with root package name */
    public int f9901t;

    /* renamed from: u, reason: collision with root package name */
    public int f9902u;

    public d() {
        Paint paint = new Paint();
        this.f9886b = paint;
        Paint paint2 = new Paint();
        this.f9887c = paint2;
        Paint paint3 = new Paint();
        this.f9888d = paint3;
        this.f9889e = BitmapDescriptorFactory.HUE_RED;
        this.f9890f = BitmapDescriptorFactory.HUE_RED;
        this.g = BitmapDescriptorFactory.HUE_RED;
        this.h = 5.0f;
        this.f9897p = 1.0f;
        this.f9901t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i5) {
        this.f9892j = i5;
        this.f9902u = this.f9891i[i5];
    }
}
