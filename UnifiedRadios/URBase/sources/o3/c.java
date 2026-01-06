package O3;

import F3.i;
import N3.AbstractC0143q;
import N3.AbstractC0146u;
import N3.B;
import N3.InterfaceC0151z;
import S3.o;
import android.os.Handler;
import android.os.Looper;
import com.unified.ur1.SatelliteTracker.h;
import java.util.concurrent.CancellationException;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class c extends AbstractC0143q implements InterfaceC0151z {
    private volatile c _immediate;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f2039l;

    /* renamed from: m, reason: collision with root package name */
    public final String f2040m;
    public final boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final c f2041o;

    public c(Handler handler, String str, boolean z4) {
        this.f2039l = handler;
        this.f2040m = str;
        this.n = z4;
        this._immediate = z4 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.f2041o = cVar;
    }

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        if (this.f2039l.post(runnable)) {
            return;
        }
        AbstractC0146u.d(interfaceC0941i, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        B.f1812b.W(interfaceC0941i, runnable);
    }

    @Override // N3.AbstractC0143q
    public final boolean Y() {
        return (this.n && i.a(Looper.myLooper(), this.f2039l.getLooper())) ? false : true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f2039l == this.f2039l;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f2039l);
    }

    @Override // N3.AbstractC0143q
    public final String toString() {
        c cVar;
        String str;
        U3.d dVar = B.f1811a;
        c cVar2 = o.f2412a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f2041o;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f2040m;
        if (string == null) {
            string = this.f2039l.toString();
        }
        return this.n ? h.b(string, ".immediate") : string;
    }

    public c(Handler handler) {
        this(handler, null, false);
    }
}
