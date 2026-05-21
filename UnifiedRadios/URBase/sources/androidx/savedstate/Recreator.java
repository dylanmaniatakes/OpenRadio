package androidx.savedstate;

import F3.i;
import android.os.Bundle;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.M;
import androidx.lifecycle.S;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import androidx.lifecycle.r;
import com.unified.ur1.SatelliteTracker.h;
import g0.AbstractC0535a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import o0.a;
import o0.c;
import o0.e;

/* loaded from: classes.dex */
public final class Recreator implements r {

    /* renamed from: j, reason: collision with root package name */
    public final e f4406j;

    public Recreator(e eVar) {
        i.f(eVar, "owner");
        this.f4406j = eVar;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (enumC0243m != EnumC0243m.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0249t.getLifecycle().b(this);
        e eVar = this.f4406j;
        Bundle bundleA = eVar.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (bundleA == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.class);
                i.e(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        i.e(objNewInstance, "{\n                constr…wInstance()\n            }");
                        if (!(eVar instanceof X)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
                        }
                        W viewModelStore = ((X) eVar).getViewModelStore();
                        c savedStateRegistry = eVar.getSavedStateRegistry();
                        viewModelStore.getClass();
                        LinkedHashMap linkedHashMap = viewModelStore.f3951a;
                        Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            i.f(str2, "key");
                            S s4 = (S) linkedHashMap.get(str2);
                            i.c(s4);
                            M.a(s4, savedStateRegistry, eVar.getLifecycle());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            savedStateRegistry.d();
                        }
                    } catch (Exception e5) {
                        throw new RuntimeException(h.s("Failed to instantiate ", str), e5);
                    }
                } catch (NoSuchMethodException e6) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e6);
                }
            } catch (ClassNotFoundException e7) {
                throw new RuntimeException(AbstractC0535a.l("Class ", str, " wasn't found"), e7);
            }
        }
    }
}
