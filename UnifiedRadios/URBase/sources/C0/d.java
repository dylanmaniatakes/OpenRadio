package C0;

import g0.AbstractC0535a;
import java.util.Set;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: i, reason: collision with root package name */
    public static final d f142i = new d(1, false, false, false, false, -1, -1, t3.s.f9713j);

    /* renamed from: a, reason: collision with root package name */
    public final int f143a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f144b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f145c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f146d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f147e;

    /* renamed from: f, reason: collision with root package name */
    public final long f148f;
    public final long g;
    public final Set h;

    public d(int i5, boolean z4, boolean z5, boolean z6, boolean z7, long j5, long j6, Set set) {
        AbstractC0535a.p(i5, "requiredNetworkType");
        F3.i.f(set, "contentUriTriggers");
        this.f143a = i5;
        this.f144b = z4;
        this.f145c = z5;
        this.f146d = z6;
        this.f147e = z7;
        this.f148f = j5;
        this.g = j6;
        this.h = set;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !d.class.equals(obj.getClass())) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f144b == dVar.f144b && this.f145c == dVar.f145c && this.f146d == dVar.f146d && this.f147e == dVar.f147e && this.f148f == dVar.f148f && this.g == dVar.g && this.f143a == dVar.f143a) {
            return F3.i.a(this.h, dVar.h);
        }
        return false;
    }

    public final int hashCode() {
        int iC = ((((((((AbstractC0882e.c(this.f143a) * 31) + (this.f144b ? 1 : 0)) * 31) + (this.f145c ? 1 : 0)) * 31) + (this.f146d ? 1 : 0)) * 31) + (this.f147e ? 1 : 0)) * 31;
        long j5 = this.f148f;
        int i5 = (iC + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.g;
        return this.h.hashCode() + ((i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + AbstractC0535a.x(this.f143a) + ", requiresCharging=" + this.f144b + ", requiresDeviceIdle=" + this.f145c + ", requiresBatteryNotLow=" + this.f146d + ", requiresStorageNotLow=" + this.f147e + ", contentTriggerUpdateDelayMillis=" + this.f148f + ", contentTriggerMaxDelayMillis=" + this.g + ", contentUriTriggers=" + this.h + ", }";
    }

    public d(d dVar) {
        F3.i.f(dVar, "other");
        this.f144b = dVar.f144b;
        this.f145c = dVar.f145c;
        this.f143a = dVar.f143a;
        this.f146d = dVar.f146d;
        this.f147e = dVar.f147e;
        this.h = dVar.h;
        this.f148f = dVar.f148f;
        this.g = dVar.g;
    }
}
