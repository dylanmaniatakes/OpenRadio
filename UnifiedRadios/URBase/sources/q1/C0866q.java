package q1;

import java.util.Arrays;

/* renamed from: q1.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0866q implements o1.b {

    /* renamed from: c, reason: collision with root package name */
    public static final C0866q f9408c = new C0866q(null);

    /* renamed from: b, reason: collision with root package name */
    public final String f9409b;

    public /* synthetic */ C0866q(String str) {
        this.f9409b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0866q) {
            return E.l(this.f9409b, ((C0866q) obj).f9409b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9409b});
    }
}
