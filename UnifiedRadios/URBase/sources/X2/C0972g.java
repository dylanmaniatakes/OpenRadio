package x2;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: x2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0972g implements InterfaceC0969d, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public final Object f10447j;

    public C0972g(Object obj) {
        this.f10447j = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0972g)) {
            return false;
        }
        Object obj2 = ((C0972g) obj).f10447j;
        Object obj3 = this.f10447j;
        return obj3 == obj2 || (obj3 != null && obj3.equals(obj2));
    }

    @Override // x2.InterfaceC0969d
    public final Object get() {
        return this.f10447j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10447j});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f10447j);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
