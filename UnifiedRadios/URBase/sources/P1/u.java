package p1;

import java.util.Arrays;
import n1.C0787d;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final C0826b f9147a;

    /* renamed from: b, reason: collision with root package name */
    public final C0787d f9148b;

    public /* synthetic */ u(C0826b c0826b, C0787d c0787d) {
        this.f9147a = c0826b;
        this.f9148b = c0787d;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof u)) {
            u uVar = (u) obj;
            if (q1.E.l(this.f9147a, uVar.f9147a) && q1.E.l(this.f9148b, uVar.f9148b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9147a, this.f9148b});
    }

    public final String toString() {
        L0.c cVar = new L0.c(this);
        cVar.b(this.f9147a, "key");
        cVar.b(this.f9148b, "feature");
        return cVar.toString();
    }
}
