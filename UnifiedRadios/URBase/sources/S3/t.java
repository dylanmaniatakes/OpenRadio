package S3;

import N3.AbstractC0127a;
import N3.C0138l;
import a.AbstractC0203a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import y3.InterfaceC0990d;

/* loaded from: classes.dex */
public class t extends AbstractC0127a implements InterfaceC0990d {

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0936d f2417m;

    public t(InterfaceC0936d interfaceC0936d, InterfaceC0941i interfaceC0941i) {
        super(interfaceC0941i, true);
        this.f2417m = interfaceC0936d;
    }

    @Override // N3.Y
    public final boolean G() {
        return true;
    }

    @Override // y3.InterfaceC0990d
    public final InterfaceC0990d getCallerFrame() {
        InterfaceC0936d interfaceC0936d = this.f2417m;
        if (interfaceC0936d instanceof InterfaceC0990d) {
            return (InterfaceC0990d) interfaceC0936d;
        }
        return null;
    }

    @Override // N3.Y
    public final void l(Object obj) {
        InterfaceC0936d interfaceC0936dH = AbstractC0203a.h(this.f2417m);
        if (obj instanceof C0138l) {
            obj = AbstractC0399v1.c(((C0138l) obj).f1860a);
        }
        AbstractC0187a.i(interfaceC0936dH, obj, null);
    }

    @Override // N3.Y
    public final void m(Object obj) {
        if (obj instanceof C0138l) {
            obj = AbstractC0399v1.c(((C0138l) obj).f1860a);
        }
        this.f2417m.resumeWith(obj);
    }
}
