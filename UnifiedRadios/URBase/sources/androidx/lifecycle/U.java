package androidx.lifecycle;

import android.app.Application;
import c0.C0291c;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class U extends T {
    public static U g;

    /* renamed from: f, reason: collision with root package name */
    public final Application f3950f;

    public U(Application application) {
        this.f3950f = application;
    }

    public final S a(Class cls, Application application) {
        if (!AbstractC0231a.class.isAssignableFrom(cls)) {
            return super.b(cls);
        }
        try {
            S s4 = (S) cls.getConstructor(Application.class).newInstance(application);
            F3.i.e(s4, "{\n                try {\n…          }\n            }");
            return s4;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException("Cannot create an instance of " + cls, e8);
        }
    }

    @Override // androidx.lifecycle.T, androidx.lifecycle.V
    public final S b(Class cls) {
        Application application = this.f3950f;
        if (application != null) {
            return a(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.V
    public final S f(Class cls, C0291c c0291c) {
        if (this.f3950f != null) {
            return b(cls);
        }
        Application application = (Application) c0291c.f4544a.get(T.f3947c);
        if (application != null) {
            return a(cls, application);
        }
        if (AbstractC0231a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.b(cls);
    }
}
