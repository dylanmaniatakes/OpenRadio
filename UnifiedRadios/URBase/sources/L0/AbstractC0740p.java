package l0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import q0.C0847j;
import s3.C0898h;

/* renamed from: l0.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0740p {

    /* renamed from: a, reason: collision with root package name */
    public Object f8382a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8383b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8384c;

    public AbstractC0740p(AbstractC0737m abstractC0737m) {
        F3.i.f(abstractC0737m, "database");
        this.f8382a = abstractC0737m;
        this.f8383b = new AtomicBoolean(false);
        this.f8384c = new C0898h(new H0.g(2, this));
    }

    public static boolean m(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public C0847j a() {
        ((AbstractC0737m) this.f8382a).a();
        return ((AtomicBoolean) this.f8383b).compareAndSet(false, true) ? (C0847j) ((C0898h) this.f8384c).a() : k();
    }

    public abstract void b();

    public abstract Object c(int i5, int i6);

    public abstract Map d();

    public abstract int e();

    public abstract int f(Object obj);

    public abstract int g(Object obj);

    public abstract void h(Object obj, Object obj2);

    public abstract void i(int i5);

    public abstract Object j(int i5, Object obj);

    public C0847j k() {
        String strL = l();
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f8382a;
        abstractC0737m.getClass();
        abstractC0737m.a();
        abstractC0737m.b();
        return abstractC0737m.h().Q().o(strL);
    }

    public abstract String l();

    public void n(C0847j c0847j) {
        F3.i.f(c0847j, "statement");
        if (c0847j == ((C0847j) ((C0898h) this.f8384c).a())) {
            ((AtomicBoolean) this.f8383b).set(false);
        }
    }

    public Object[] p(int i5, Object[] objArr) {
        int iE = e();
        if (objArr.length < iE) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iE);
        }
        for (int i6 = 0; i6 < iE; i6++) {
            objArr[i6] = c(i6, i5);
        }
        if (objArr.length > iE) {
            objArr[iE] = null;
        }
        return objArr;
    }
}
