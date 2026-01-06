package m4;

import android.graphics.Canvas;
import android.util.Log;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class b extends AbstractList implements f {

    /* renamed from: j, reason: collision with root package name */
    public l f8650j;

    /* renamed from: k, reason: collision with root package name */
    public final CopyOnWriteArrayList f8651k = new CopyOnWriteArrayList();

    public b(l lVar) {
        this.f8650j = lVar;
    }

    public final void a(Canvas canvas, MapView mapView) {
        l4.l projection = mapView.getProjection();
        l lVar = this.f8650j;
        if (lVar != null) {
            lVar.f(projection);
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f8651k;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar != null && (eVar instanceof l)) {
                ((l) eVar).f(projection);
            }
        }
        l lVar2 = this.f8650j;
        if (lVar2 != null) {
            lVar2.a(canvas, mapView.getProjection());
        }
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            e eVar2 = (e) it2.next();
            if (eVar2 != null) {
                eVar2.a(canvas, mapView.getProjection());
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i5, Object obj) {
        e eVar = (e) obj;
        if (eVar == null) {
            Log.e("OsmDroid", "Attempt to add a null overlay to the collection. This is probably a bug and should be reported!", new Exception());
        } else {
            this.f8651k.add(i5, eVar);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i5) {
        return (e) this.f8651k.get(i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i5) {
        return (e) this.f8651k.remove(i5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i5, Object obj) {
        e eVar = (e) obj;
        if (eVar != null) {
            return (e) this.f8651k.set(i5, eVar);
        }
        Log.e("OsmDroid", "Attempt to set a null overlay to the collection. This is probably a bug and should be reported!", new Exception());
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8651k.size();
    }
}
