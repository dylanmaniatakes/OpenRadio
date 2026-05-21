package F2;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import g0.AbstractC0535a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Q2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f549a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f550b;

    public /* synthetic */ d(int i5, Object obj) {
        this.f549a = i5;
        this.f550b = obj;
    }

    @Override // Q2.a
    public final Object get() throws ClassNotFoundException {
        switch (this.f549a) {
            case 0:
                String str = (String) this.f550b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new m("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e5) {
                    throw new m(AbstractC0535a.l("Could not instantiate ", str, "."), e5);
                } catch (InstantiationException e6) {
                    throw new m(AbstractC0535a.l("Could not instantiate ", str, "."), e6);
                } catch (NoSuchMethodException e7) {
                    throw new m(com.unified.ur1.SatelliteTracker.h.s("Could not instantiate ", str), e7);
                } catch (InvocationTargetException e8) {
                    throw new m(com.unified.ur1.SatelliteTracker.h.s("Could not instantiate ", str), e8);
                }
            case 1:
                return (ComponentRegistrar) this.f550b;
            default:
                return new S2.c((A2.g) this.f550b);
        }
    }
}
