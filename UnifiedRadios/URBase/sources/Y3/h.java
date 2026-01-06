package y3;

import F3.m;
import F3.n;
import w3.InterfaceC0936d;

/* loaded from: classes.dex */
public abstract class h extends AbstractC0993g implements F3.g {

    /* renamed from: j, reason: collision with root package name */
    public final int f10526j;

    public h(InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f10526j = 2;
    }

    @Override // F3.g
    public final int getArity() {
        return this.f10526j;
    }

    @Override // y3.AbstractC0987a
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        m.f603a.getClass();
        String strA = n.a(this);
        F3.i.e(strA, "renderLambdaToString(this)");
        return strA;
    }
}
