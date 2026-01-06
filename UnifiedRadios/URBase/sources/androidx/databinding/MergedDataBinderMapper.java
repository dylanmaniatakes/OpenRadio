package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MergedDataBinderMapper extends a {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f3576a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f3577b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f3578c = new CopyOnWriteArrayList();

    @Override // androidx.databinding.a
    public final e b(View view) {
        Iterator it = this.f3577b.iterator();
        while (it.hasNext()) {
            e eVarB = ((a) it.next()).b(view);
            if (eVarB != null) {
                return eVarB;
            }
        }
        if (e()) {
            return b(view);
        }
        return null;
    }

    @Override // androidx.databinding.a
    public final e c(View[] viewArr) {
        Iterator it = this.f3577b.iterator();
        while (it.hasNext()) {
            e eVarC = ((a) it.next()).c(viewArr);
            if (eVarC != null) {
                return eVarC;
            }
        }
        if (e()) {
            return c(viewArr);
        }
        return null;
    }

    public final void d(a aVar) {
        if (this.f3576a.add(aVar.getClass())) {
            this.f3577b.add(aVar);
            Iterator it = aVar.a().iterator();
            while (it.hasNext()) {
                d((a) it.next());
            }
        }
    }

    public final boolean e() throws ClassNotFoundException {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f3578c;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                Class<?> cls = Class.forName(str);
                if (a.class.isAssignableFrom(cls)) {
                    d((a) cls.newInstance());
                    copyOnWriteArrayList.remove(str);
                    z4 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e5) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e5);
            } catch (InstantiationException e6) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + str, e6);
            }
        }
        return z4;
    }
}
