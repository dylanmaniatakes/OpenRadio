package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import c0.C0291c;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class P implements V {

    /* renamed from: c, reason: collision with root package name */
    public final Application f3932c;

    /* renamed from: d, reason: collision with root package name */
    public final U f3933d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f3934e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0245o f3935f;
    public final o0.c g;

    public P(Application application, o0.e eVar, Bundle bundle) {
        U u4;
        F3.i.f(eVar, "owner");
        this.g = eVar.getSavedStateRegistry();
        this.f3935f = eVar.getLifecycle();
        this.f3934e = bundle;
        this.f3932c = application;
        if (application != null) {
            if (U.g == null) {
                U.g = new U(application);
            }
            u4 = U.g;
            F3.i.c(u4);
        } else {
            u4 = new U(null);
        }
        this.f3933d = u4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final S a(String str, Class cls) throws NoSuchMethodException, IOException, SecurityException {
        Object obj;
        Application application;
        AbstractC0245o abstractC0245o = this.f3935f;
        if (abstractC0245o == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = AbstractC0231a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.f3932c == null) ? Q.a(Q.f3937b, cls) : Q.a(Q.f3936a, cls);
        if (constructorA == null) {
            if (this.f3932c != null) {
                return this.f3933d.b(cls);
            }
            if (T.f3949e == null) {
                T.f3949e = new T();
            }
            T t4 = T.f3949e;
            F3.i.c(t4);
            return t4.b(cls);
        }
        o0.c cVar = this.g;
        F3.i.c(cVar);
        Bundle bundle = this.f3934e;
        Bundle bundleA = cVar.a(str);
        Class[] clsArr = K.f3915f;
        K kB = M.b(bundleA, bundle);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, kB);
        savedStateHandleController.b(abstractC0245o, cVar);
        EnumC0244n enumC0244n = ((C0251v) abstractC0245o).f3971c;
        if (enumC0244n == EnumC0244n.f3962k || enumC0244n.compareTo(EnumC0244n.f3964m) >= 0) {
            cVar.d();
        } else {
            abstractC0245o.a(new LegacySavedStateHandleController$tryToAddRecreator$1(abstractC0245o, cVar));
        }
        S sB = (!zIsAssignableFrom || (application = this.f3932c) == null) ? Q.b(cls, constructorA, kB) : Q.b(cls, constructorA, application, kB);
        synchronized (sB.f3940a) {
            try {
                obj = sB.f3940a.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == 0) {
                    sB.f3940a.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != 0) {
            savedStateHandleController = obj;
        }
        if (sB.f3942c) {
            S.a(savedStateHandleController);
        }
        return sB;
    }

    @Override // androidx.lifecycle.V
    public final S b(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.V
    public final S f(Class cls, C0291c c0291c) {
        T t4 = T.f3948d;
        LinkedHashMap linkedHashMap = c0291c.f4544a;
        String str = (String) linkedHashMap.get(t4);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(M.f3924a) == null || linkedHashMap.get(M.f3925b) == null) {
            if (this.f3935f != null) {
                return a(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(T.f3947c);
        boolean zIsAssignableFrom = AbstractC0231a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? Q.a(Q.f3937b, cls) : Q.a(Q.f3936a, cls);
        return constructorA == null ? this.f3933d.f(cls, c0291c) : (!zIsAssignableFrom || application == null) ? Q.b(cls, constructorA, M.c(c0291c)) : Q.b(cls, constructorA, application, M.c(c0291c));
    }
}
