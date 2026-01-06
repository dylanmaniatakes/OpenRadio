package x2;

import com.google.android.gms.internal.measurement.H1;
import java.io.Serializable;

/* renamed from: x2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0970e implements InterfaceC0969d, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0969d f10441j;

    /* renamed from: k, reason: collision with root package name */
    public volatile transient boolean f10442k;

    /* renamed from: l, reason: collision with root package name */
    public transient Object f10443l;

    public C0970e(H1 h12) {
        this.f10441j = h12;
    }

    @Override // x2.InterfaceC0969d
    public final Object get() {
        if (!this.f10442k) {
            synchronized (this) {
                try {
                    if (!this.f10442k) {
                        Object obj = this.f10441j.get();
                        this.f10443l = obj;
                        this.f10442k = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f10443l;
    }

    public final String toString() {
        Object string;
        if (this.f10442k) {
            String strValueOf = String.valueOf(this.f10443l);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.f10441j;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
