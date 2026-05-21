package E1;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: E1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0031d extends AbstractBinderC0048v implements InterfaceC0032e {
    public static InterfaceC0032e a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        return iInterfaceQueryLocalInterface instanceof InterfaceC0032e ? (InterfaceC0032e) iInterfaceQueryLocalInterface : new C0030c(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }
}
