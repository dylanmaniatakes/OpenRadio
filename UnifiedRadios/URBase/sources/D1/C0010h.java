package D1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: D1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0010h implements p1.o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f391c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PendingIntent f392d;

    public /* synthetic */ C0010h(int i5, PendingIntent pendingIntent) {
        this.f391c = i5;
        this.f392d = pendingIntent;
    }

    @Override // p1.o
    public final void p(Object obj, Object obj2) throws RemoteException {
        N1.k kVar = (N1.k) obj2;
        switch (this.f391c) {
            case 0:
                BinderC0008f binderC0008f = new BinderC0008f(new Z2.c(kVar));
                a0 a0Var = (a0) ((U) obj).t();
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, this.f392d);
                parcelZza.writeStrongBinder(binderC0008f);
                a0Var.zzc(73, parcelZza);
                break;
            default:
                PendingIntent pendingIntent = this.f392d;
                q1.E.j(pendingIntent, "PendingIntent can not be null.");
                ((D) obj).F(new K(null, pendingIntent, ""), kVar);
                break;
        }
    }
}
