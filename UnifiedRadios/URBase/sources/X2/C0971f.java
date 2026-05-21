package x2;

import java.util.Objects;

/* renamed from: x2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0971f implements InterfaceC0969d {

    /* renamed from: j, reason: collision with root package name */
    public volatile InterfaceC0969d f10444j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f10445k;

    /* renamed from: l, reason: collision with root package name */
    public Object f10446l;

    @Override // x2.InterfaceC0969d
    public final Object get() {
        if (!this.f10445k) {
            synchronized (this) {
                try {
                    if (!this.f10445k) {
                        InterfaceC0969d interfaceC0969d = this.f10444j;
                        Objects.requireNonNull(interfaceC0969d);
                        Object obj = interfaceC0969d.get();
                        this.f10446l = obj;
                        this.f10445k = true;
                        this.f10444j = null;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f10446l;
    }

    public final String toString() {
        Object string = this.f10444j;
        if (string == null) {
            String strValueOf = String.valueOf(this.f10446l);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
