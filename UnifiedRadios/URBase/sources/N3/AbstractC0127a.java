package N3;

import S3.AbstractC0187a;
import a.AbstractC0203a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.lang.reflect.InvocationTargetException;
import s.AbstractC0882e;
import s3.AbstractC0897g;
import s3.C0900j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import x3.EnumC0973a;

/* renamed from: N3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0127a extends Y implements InterfaceC0936d, InterfaceC0144s {

    /* renamed from: l, reason: collision with root package name */
    public final InterfaceC0941i f1840l;

    public AbstractC0127a(InterfaceC0941i interfaceC0941i, boolean z4) {
        super(z4);
        E((P) interfaceC0941i.o(r.f1871k));
        this.f1840l = interfaceC0941i.x(this);
    }

    @Override // N3.Y
    public final void C(F1.b bVar) {
        AbstractC0146u.g(this.f1840l, bVar);
    }

    @Override // N3.Y
    public final void L(Object obj) {
        if (!(obj instanceof C0138l)) {
            S(obj);
            return;
        }
        C0138l c0138l = (C0138l) obj;
        Throwable th = c0138l.f1860a;
        c0138l.getClass();
        R(th, C0138l.f1859b.get(c0138l) != 0);
    }

    public void R(Throwable th, boolean z4) {
    }

    public void S(Object obj) {
    }

    public final void T(int i5, AbstractC0127a abstractC0127a, E3.p pVar) {
        int iC = AbstractC0882e.c(i5);
        C0900j c0900j = C0900j.f9694a;
        if (iC == 0) {
            try {
                AbstractC0187a.i(AbstractC0203a.h(AbstractC0203a.e(pVar, abstractC0127a, this)), c0900j, null);
                return;
            } finally {
                resumeWith(AbstractC0399v1.c(th));
            }
        }
        if (iC != 1) {
            if (iC == 2) {
                AbstractC0203a.h(AbstractC0203a.e(pVar, abstractC0127a, this)).resumeWith(c0900j);
                return;
            }
            if (iC != 3) {
                throw new F1.b();
            }
            try {
                InterfaceC0941i interfaceC0941i = this.f1840l;
                Object objL = AbstractC0187a.l(interfaceC0941i, null);
                try {
                    F3.o.b(2, pVar);
                    Object objC = pVar.c(abstractC0127a, this);
                    if (objC != EnumC0973a.f10448j) {
                        resumeWith(objC);
                    }
                } finally {
                    AbstractC0187a.h(interfaceC0941i, objL);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // N3.InterfaceC0144s
    public final InterfaceC0941i d() {
        return this.f1840l;
    }

    @Override // w3.InterfaceC0936d
    public final InterfaceC0941i getContext() {
        return this.f1840l;
    }

    @Override // N3.Y
    public final String r() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // w3.InterfaceC0936d
    public final void resumeWith(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Throwable thA = AbstractC0897g.a(obj);
        if (thA != null) {
            obj = new C0138l(thA, false);
        }
        Object objH = H(obj);
        if (objH == AbstractC0146u.f1875d) {
            return;
        }
        m(objH);
    }
}
