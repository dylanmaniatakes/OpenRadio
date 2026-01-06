package x1;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import q1.E;

/* renamed from: x1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0963d extends A1.b implements InterfaceC0961b {

    /* renamed from: d, reason: collision with root package name */
    public final Object f10423d;

    public BinderC0963d(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper", 1);
        this.f10423d = obj;
    }

    public static InterfaceC0961b J(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof InterfaceC0961b ? (InterfaceC0961b) iInterfaceQueryLocalInterface : new l(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 1);
    }

    public static Object K(InterfaceC0961b interfaceC0961b) throws SecurityException {
        if (interfaceC0961b instanceof BinderC0963d) {
            return ((BinderC0963d) interfaceC0961b).f10423d;
        }
        IBinder iBinderAsBinder = interfaceC0961b.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i5 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i5++;
                field = field2;
            }
        }
        if (i5 != 1) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
        }
        E.i(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e5) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e5);
        } catch (NullPointerException e6) {
            throw new IllegalArgumentException("Binder object is null.", e6);
        }
    }
}
