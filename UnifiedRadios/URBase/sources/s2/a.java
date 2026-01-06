package S2;

import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f2362a;

    /* renamed from: b, reason: collision with root package name */
    public int f2363b;

    /* renamed from: c, reason: collision with root package name */
    public String f2364c;

    /* renamed from: d, reason: collision with root package name */
    public String f2365d;

    /* renamed from: e, reason: collision with root package name */
    public Long f2366e;

    /* renamed from: f, reason: collision with root package name */
    public Long f2367f;
    public String g;

    public final b a() {
        String strB = this.f2363b == 0 ? " registrationStatus" : "";
        if (this.f2366e == null) {
            strB = strB.concat(" expiresInSecs");
        }
        if (this.f2367f == null) {
            strB = h.b(strB, " tokenCreationEpochInSecs");
        }
        if (strB.isEmpty()) {
            return new b(this.f2362a, this.f2363b, this.f2364c, this.f2365d, this.f2366e.longValue(), this.f2367f.longValue(), this.g);
        }
        throw new IllegalStateException("Missing required properties:".concat(strB));
    }
}
