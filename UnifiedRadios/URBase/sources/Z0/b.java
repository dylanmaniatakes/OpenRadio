package Z0;

import android.content.Context;
import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3065a;

    /* renamed from: b, reason: collision with root package name */
    public final h1.d f3066b;

    /* renamed from: c, reason: collision with root package name */
    public final h1.d f3067c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3068d;

    public b(Context context, h1.d dVar, h1.d dVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f3065a = context;
        if (dVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f3066b = dVar;
        if (dVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f3067c = dVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f3068d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f3065a.equals(((b) cVar).f3065a)) {
            b bVar = (b) cVar;
            if (this.f3066b.equals(bVar.f3066b) && this.f3067c.equals(bVar.f3067c) && this.f3068d.equals(bVar.f3068d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f3065a.hashCode() ^ 1000003) * 1000003) ^ this.f3066b.hashCode()) * 1000003) ^ this.f3067c.hashCode()) * 1000003) ^ this.f3068d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f3065a);
        sb.append(", wallClock=");
        sb.append(this.f3066b);
        sb.append(", monotonicClock=");
        sb.append(this.f3067c);
        sb.append(", backendName=");
        return h.e(sb, this.f3068d, "}");
    }
}
