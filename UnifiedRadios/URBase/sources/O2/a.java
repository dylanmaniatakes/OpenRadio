package O2;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f2022a;

    /* renamed from: b, reason: collision with root package name */
    public final List f2023b;

    public a(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f2022a = str;
        this.f2023b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2022a.equals(aVar.f2022a) && this.f2023b.equals(aVar.f2023b);
    }

    public final int hashCode() {
        return ((this.f2022a.hashCode() ^ 1000003) * 1000003) ^ this.f2023b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f2022a + ", usedDates=" + this.f2023b + "}";
    }
}
