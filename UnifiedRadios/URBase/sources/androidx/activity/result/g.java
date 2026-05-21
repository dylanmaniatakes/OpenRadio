package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.r;
import d.AbstractC0422a;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3265a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3266b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3267c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f3268d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient HashMap f3269e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f3270f = new HashMap();
    public final Bundle g = new Bundle();

    public final boolean a(int i5, int i6, Intent intent) {
        b bVar;
        String str = (String) this.f3265a.get(Integer.valueOf(i5));
        if (str == null) {
            return false;
        }
        e eVar = (e) this.f3269e.get(str);
        if (eVar == null || (bVar = eVar.f3261a) == null || !this.f3268d.contains(str)) {
            this.f3270f.remove(str);
            this.g.putParcelable(str, new a(intent, i6));
            return true;
        }
        bVar.e(eVar.f3262b.c(intent, i6));
        this.f3268d.remove(str);
        return true;
    }

    public abstract void b(int i5, AbstractC0422a abstractC0422a, Object obj);

    public final d c(final String str, InterfaceC0249t interfaceC0249t, final AbstractC0422a abstractC0422a, final b bVar) {
        AbstractC0245o lifecycle = interfaceC0249t.getLifecycle();
        C0251v c0251v = (C0251v) lifecycle;
        if (c0251v.f3971c.compareTo(EnumC0244n.f3964m) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + interfaceC0249t + " is attempting to register while current state is " + c0251v.f3971c + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap map = this.f3267c;
        f fVar = (f) map.get(str);
        if (fVar == null) {
            fVar = new f(lifecycle);
        }
        r rVar = new r() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t2, EnumC0243m enumC0243m) {
                boolean zEquals = EnumC0243m.ON_START.equals(enumC0243m);
                String str2 = str;
                g gVar = this.f3254m;
                if (!zEquals) {
                    if (EnumC0243m.ON_STOP.equals(enumC0243m)) {
                        gVar.f3269e.remove(str2);
                        return;
                    } else {
                        if (EnumC0243m.ON_DESTROY.equals(enumC0243m)) {
                            gVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap map2 = gVar.f3269e;
                b bVar2 = bVar;
                AbstractC0422a abstractC0422a2 = abstractC0422a;
                map2.put(str2, new e(abstractC0422a2, bVar2));
                HashMap map3 = gVar.f3270f;
                if (map3.containsKey(str2)) {
                    Object obj = map3.get(str2);
                    map3.remove(str2);
                    bVar2.e(obj);
                }
                Bundle bundle = gVar.g;
                a aVar = (a) bundle.getParcelable(str2);
                if (aVar != null) {
                    bundle.remove(str2);
                    bVar2.e(abstractC0422a2.c(aVar.f3256k, aVar.f3255j));
                }
            }
        };
        fVar.f3263a.a(rVar);
        fVar.f3264b.add(rVar);
        map.put(str, fVar);
        return new d(this, str, abstractC0422a, 0);
    }

    public final d d(String str, AbstractC0422a abstractC0422a, b bVar) {
        e(str);
        this.f3269e.put(str, new e(abstractC0422a, bVar));
        HashMap map = this.f3270f;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            bVar.e(obj);
        }
        Bundle bundle = this.g;
        a aVar = (a) bundle.getParcelable(str);
        if (aVar != null) {
            bundle.remove(str);
            bVar.e(abstractC0422a.c(aVar.f3256k, aVar.f3255j));
        }
        return new d(this, str, abstractC0422a, 1);
    }

    public final void e(String str) {
        HashMap map = this.f3266b;
        if (((Integer) map.get(str)) != null) {
            return;
        }
        H3.e.f666j.getClass();
        int iNextInt = H3.e.f667k.a().nextInt(2147418112);
        while (true) {
            int i5 = iNextInt + 65536;
            HashMap map2 = this.f3265a;
            if (!map2.containsKey(Integer.valueOf(i5))) {
                map2.put(Integer.valueOf(i5), str);
                map.put(str, Integer.valueOf(i5));
                return;
            } else {
                H3.e.f666j.getClass();
                iNextInt = H3.e.f667k.a().nextInt(2147418112);
            }
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f3268d.contains(str) && (num = (Integer) this.f3266b.remove(str)) != null) {
            this.f3265a.remove(num);
        }
        this.f3269e.remove(str);
        HashMap map = this.f3270f;
        if (map.containsKey(str)) {
            StringBuilder sbM = AbstractC0535a.m("Dropping pending result for request ", str, ": ");
            sbM.append(map.get(str));
            Log.w("ActivityResultRegistry", sbM.toString());
            map.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            StringBuilder sbM2 = AbstractC0535a.m("Dropping pending result for request ", str, ": ");
            sbM2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", sbM2.toString());
            bundle.remove(str);
        }
        HashMap map2 = this.f3267c;
        f fVar = (f) map2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f3264b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                fVar.f3263a.b((r) it.next());
            }
            arrayList.clear();
            map2.remove(str);
        }
    }
}
