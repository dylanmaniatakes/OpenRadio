package S;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f2328a;

    /* renamed from: b, reason: collision with root package name */
    public int f2329b;

    /* renamed from: c, reason: collision with root package name */
    public float f2330c;

    /* renamed from: d, reason: collision with root package name */
    public float f2331d;

    /* renamed from: e, reason: collision with root package name */
    public long f2332e;

    /* renamed from: f, reason: collision with root package name */
    public long f2333f;
    public long g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public int f2334i;

    public final float a(long j5) {
        if (j5 < this.f2332e) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        long j6 = this.g;
        if (j6 < 0 || j5 < j6) {
            return g.b((j5 - r0) / this.f2328a, BitmapDescriptorFactory.HUE_RED, 1.0f) * 0.5f;
        }
        float f5 = this.h;
        return (g.b((j5 - j6) / this.f2334i, BitmapDescriptorFactory.HUE_RED, 1.0f) * f5) + (1.0f - f5);
    }
}
