package J1;

import android.os.IBinder;
import android.os.IInterface;
import q1.AbstractC0854e;

/* loaded from: classes.dex */
public final class T extends AbstractC0854e {
    @Override // q1.AbstractC0854e, o1.c
    public final int f() {
        return 12451000;
    }

    @Override // q1.AbstractC0854e
    public final /* synthetic */ IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof J ? (J) iInterfaceQueryLocalInterface : new I(iBinder);
    }

    @Override // q1.AbstractC0854e
    public final String u() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // q1.AbstractC0854e
    public final String v() {
        return "com.google.android.gms.measurement.START";
    }
}
