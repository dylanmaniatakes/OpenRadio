package s1;

import A1.d;
import D0.w;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import n1.C0787d;
import o1.i;
import o1.j;
import q1.AbstractC0858i;
import q1.C0866q;

/* renamed from: s1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0887c extends AbstractC0858i {

    /* renamed from: A, reason: collision with root package name */
    public final C0866q f9576A;

    public C0887c(Context context, Looper looper, w wVar, C0866q c0866q, i iVar, j jVar) {
        super(context, looper, 270, wVar, iVar, jVar);
        this.f9576A = c0866q;
    }

    @Override // q1.AbstractC0854e, o1.c
    public final int f() {
        return 203400000;
    }

    @Override // q1.AbstractC0854e
    public final IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof C0885a ? (C0885a) iInterfaceQueryLocalInterface : new C0885a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // q1.AbstractC0854e
    public final C0787d[] q() {
        return d.f12b;
    }

    @Override // q1.AbstractC0854e
    public final Bundle r() {
        C0866q c0866q = this.f9576A;
        c0866q.getClass();
        Bundle bundle = new Bundle();
        String str = c0866q.f9409b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // q1.AbstractC0854e
    public final String u() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // q1.AbstractC0854e
    public final String v() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // q1.AbstractC0854e
    public final boolean w() {
        return true;
    }
}
