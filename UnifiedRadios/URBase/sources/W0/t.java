package w0;

import O.J;
import O.Y;
import android.view.ViewGroup;
import com.unified.ur1.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0927a f10106a = new C0927a();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f10107b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f10108c = new ArrayList();

    public static void a(ViewGroup viewGroup, p pVar) {
        ArrayList arrayList = f10108c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = Y.f1904a;
        if (J.c(viewGroup)) {
            arrayList.add(viewGroup);
            if (pVar == null) {
                pVar = f10106a;
            }
            p pVarClone = pVar.clone();
            ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).u(viewGroup);
                }
            }
            if (pVarClone != null) {
                pVarClone.h(viewGroup, true);
            }
            com.unified.ur1.SatelliteTracker.h.p(viewGroup.getTag(R.id.transition_current_scene));
            viewGroup.setTag(R.id.transition_current_scene, null);
            if (pVarClone != null) {
                s sVar = new s();
                sVar.f10104c = pVarClone;
                sVar.f10105d = viewGroup;
                viewGroup.addOnAttachStateChangeListener(sVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(sVar);
            }
        }
    }

    public static q.b b() {
        q.b bVar;
        ThreadLocal threadLocal = f10107b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (bVar = (q.b) weakReference.get()) != null) {
            return bVar;
        }
        q.b bVar2 = new q.b();
        threadLocal.set(new WeakReference(bVar2));
        return bVar2;
    }
}
