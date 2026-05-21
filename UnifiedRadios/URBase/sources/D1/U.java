package D1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.location.zzo;
import n1.C0787d;
import q1.AbstractC0858i;

/* loaded from: classes.dex */
public final class U extends AbstractC0858i {
    @Override // q1.AbstractC0854e, o1.c
    public final int f() {
        return 11717000;
    }

    @Override // q1.AbstractC0854e
    public final /* synthetic */ IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof a0 ? (a0) iInterfaceQueryLocalInterface : new a0(iBinder);
    }

    @Override // q1.AbstractC0854e
    public final C0787d[] q() {
        return zzo.zzp;
    }

    @Override // q1.AbstractC0854e
    public final Bundle r() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", "activity_recognition");
        return bundle;
    }

    @Override // q1.AbstractC0854e
    public final String u() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // q1.AbstractC0854e
    public final String v() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // q1.AbstractC0854e
    public final boolean y() {
        return true;
    }
}
