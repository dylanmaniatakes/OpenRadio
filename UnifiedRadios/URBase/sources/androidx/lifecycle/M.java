package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import c0.C0289a;
import c0.C0291c;
import c0.C0292d;
import f3.C0513e;
import f3.C0519j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class M {

    /* renamed from: a, reason: collision with root package name */
    public static final T f3924a = new T();

    /* renamed from: b, reason: collision with root package name */
    public static final T f3925b = new T();

    /* renamed from: c, reason: collision with root package name */
    public static final T f3926c = new T();

    public static final void a(S s4, o0.c cVar, AbstractC0245o abstractC0245o) {
        Object obj;
        F3.i.f(cVar, "registry");
        F3.i.f(abstractC0245o, "lifecycle");
        HashMap map = s4.f3940a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = s4.f3940a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.f3946l) {
            return;
        }
        savedStateHandleController.b(abstractC0245o, cVar);
        EnumC0244n enumC0244n = ((C0251v) abstractC0245o).f3971c;
        if (enumC0244n == EnumC0244n.f3962k || enumC0244n.compareTo(EnumC0244n.f3964m) >= 0) {
            cVar.d();
        } else {
            abstractC0245o.a(new LegacySavedStateHandleController$tryToAddRecreator$1(abstractC0245o, cVar));
        }
    }

    public static K b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new K();
            }
            HashMap map = new HashMap();
            for (String str : bundle2.keySet()) {
                F3.i.e(str, "key");
                map.put(str, bundle2.get(str));
            }
            return new K(map);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = parcelableArrayList.get(i5);
            F3.i.d(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i5));
        }
        return new K(linkedHashMap);
    }

    public static final K c(C0291c c0291c) {
        T t4 = f3924a;
        LinkedHashMap linkedHashMap = c0291c.f4544a;
        o0.e eVar = (o0.e) linkedHashMap.get(t4);
        if (eVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        X x4 = (X) linkedHashMap.get(f3925b);
        if (x4 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f3926c);
        String str = (String) linkedHashMap.get(T.f3948d);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        o0.b bVarB = eVar.getSavedStateRegistry().b();
        N n = bVarB instanceof N ? (N) bVarB : null;
        if (n == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = e(x4).f3931d;
        K k5 = (K) linkedHashMap2.get(str);
        if (k5 != null) {
            return k5;
        }
        Class[] clsArr = K.f3915f;
        if (!n.f3928b) {
            n.f3929c = n.f3927a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            n.f3928b = true;
        }
        Bundle bundle2 = n.f3929c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = n.f3929c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = n.f3929c;
        if (bundle5 != null && bundle5.isEmpty()) {
            n.f3929c = null;
        }
        K kB = b(bundle3, bundle);
        linkedHashMap2.put(str, kB);
        return kB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Activity activity, EnumC0243m enumC0243m) {
        F3.i.f(activity, "activity");
        F3.i.f(enumC0243m, "event");
        if (activity instanceof InterfaceC0249t) {
            AbstractC0245o lifecycle = ((InterfaceC0249t) activity).getLifecycle();
            if (lifecycle instanceof C0251v) {
                ((C0251v) lifecycle).e(enumC0243m);
            }
        }
    }

    public static final O e(X x4) {
        ArrayList arrayList = new ArrayList();
        F3.m.f603a.getClass();
        Class clsA = new F3.e(O.class).a();
        F3.i.d(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new C0292d(clsA));
        C0292d[] c0292dArr = (C0292d[]) arrayList.toArray(new C0292d[0]);
        return (O) new C0513e(x4.getViewModelStore(), (V) new C0519j((C0292d[]) Arrays.copyOf(c0292dArr, c0292dArr.length)), x4 instanceof InterfaceC0239i ? ((InterfaceC0239i) x4).getDefaultViewModelCreationExtras() : C0289a.f4543b).d("androidx.lifecycle.internal.SavedStateHandlesVM", O.class);
    }

    public static void f(Activity activity) {
        F3.i.f(activity, "activity");
        if (Build.VERSION.SDK_INT >= 29) {
            I.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new I());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new J(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
