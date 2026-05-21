package P3;

import N3.i0;
import S3.AbstractC0187a;
import g0.AbstractC0535a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import s3.C0900j;

/* loaded from: classes.dex */
public final class n extends d {

    /* renamed from: u, reason: collision with root package name */
    public final int f2122u;

    public n(int i5, int i6, E3.l lVar) {
        String str;
        super(i5, lVar);
        this.f2122u = i6;
        if (i6 != 1) {
            if (i5 < 1) {
                throw new IllegalArgumentException(AbstractC0535a.j("Buffered channel capacity must be at least 1, but ", i5, " was specified").toString());
            }
            return;
        }
        StringBuilder sb = new StringBuilder("This implementation does not support suspension for senders, use ");
        F3.m.f603a.getClass();
        new F3.e(d.class);
        String simpleName = null;
        if (!d.class.isAnonymousClass()) {
            if (d.class.isLocalClass()) {
                String simpleName2 = d.class.getSimpleName();
                Method enclosingMethod = d.class.getEnclosingMethod();
                if (enclosingMethod == null) {
                    Constructor<?> enclosingConstructor = d.class.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        int iC = M3.e.C(simpleName2, '$', 0, false, 6);
                        if (iC != -1) {
                            simpleName2 = simpleName2.substring(iC + 1, simpleName2.length());
                            F3.i.e(simpleName2, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                        simpleName = simpleName2;
                    } else {
                        simpleName = M3.e.M(simpleName2, enclosingConstructor.getName() + '$');
                    }
                } else {
                    simpleName = M3.e.M(simpleName2, enclosingMethod.getName() + '$');
                }
            } else {
                boolean zIsArray = d.class.isArray();
                LinkedHashMap linkedHashMap = F3.e.f596c;
                if (zIsArray) {
                    Class<?> componentType = d.class.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                        simpleName = str.concat("Array");
                    }
                    if (simpleName == null) {
                        simpleName = "Array";
                    }
                } else {
                    simpleName = (String) linkedHashMap.get(d.class.getName());
                    if (simpleName == null) {
                        simpleName = d.class.getSimpleName();
                    }
                }
            }
        }
        throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.e(sb, simpleName, " instead").toString());
    }

    public final Object I(Object obj, boolean z4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        l lVar;
        E3.l lVar2;
        F1.b bVarB;
        C0900j c0900j = C0900j.f9694a;
        if (this.f2122u == 3) {
            Object objI = super.i(obj);
            if ((!(objI instanceof j)) || (objI instanceof i)) {
                return objI;
            }
            if (!z4 || (lVar2 = this.f2097k) == null || (bVarB = AbstractC0187a.b(lVar2, obj, null)) == null) {
                return c0900j;
            }
            throw bVarB;
        }
        p0.e eVar = f.f2102d;
        l lVar3 = (l) d.f2091p.get(this);
        while (true) {
            long andIncrement = d.f2088l.getAndIncrement(this);
            long j5 = andIncrement & 1152921504606846975L;
            boolean zV = v(andIncrement, false);
            int i5 = f.f2100b;
            long j6 = i5;
            long j7 = j5 / j6;
            int i6 = (int) (j5 % j6);
            if (lVar3.f2419l != j7) {
                l lVarA = d.a(this, j7, lVar3);
                if (lVarA != null) {
                    lVar = lVarA;
                } else if (zV) {
                    return new i(s());
                }
            } else {
                lVar = lVar3;
            }
            int iK = d.k(this, lVar, i6, obj, j5, eVar, zV);
            if (iK == 0) {
                lVar.a();
                return c0900j;
            }
            if (iK == 1) {
                return c0900j;
            }
            if (iK == 2) {
                if (zV) {
                    lVar.h();
                    return new i(s());
                }
                i0 i0Var = eVar instanceof i0 ? (i0) eVar : null;
                if (i0Var != null) {
                    i0Var.a(lVar, i6 + i5);
                }
                o((lVar.f2419l * j6) + i6);
                return c0900j;
            }
            if (iK == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iK == 4) {
                if (j5 < d.f2089m.get(this)) {
                    lVar.a();
                }
                return new i(s());
            }
            if (iK == 5) {
                lVar.a();
            }
            lVar3 = lVar;
        }
    }

    @Override // P3.d, P3.t
    public final Object e(t3.t tVar, R3.c cVar) throws Throwable {
        F1.b bVarB;
        if (!(I(tVar, true) instanceof i)) {
            return C0900j.f9694a;
        }
        E3.l lVar = this.f2097k;
        if (lVar == null || (bVarB = AbstractC0187a.b(lVar, tVar, null)) == null) {
            throw s();
        }
        android.support.v4.media.session.b.b(bVarB, s());
        throw bVarB;
    }

    @Override // P3.d, P3.t
    public final Object i(Object obj) {
        return I(obj, false);
    }

    @Override // P3.d
    public final boolean w() {
        return this.f2122u == 2;
    }
}
