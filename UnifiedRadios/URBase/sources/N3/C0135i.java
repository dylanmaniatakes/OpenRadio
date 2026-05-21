package N3;

import java.lang.reflect.InvocationTargetException;
import s3.C0900j;

/* renamed from: N3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0135i extends S implements InterfaceC0134h {
    public final InterfaceC0136j n;

    public C0135i(Y y4) {
        this.n = y4;
    }

    @Override // N3.InterfaceC0134h
    public final boolean d(Throwable th) {
        return k().s(th);
    }

    @Override // E3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        l((Throwable) obj);
        return C0900j.f9694a;
    }

    @Override // N3.U
    public final void l(Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ((Y) this.n).n(k());
    }
}
