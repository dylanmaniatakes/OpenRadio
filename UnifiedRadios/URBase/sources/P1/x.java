package p1;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import n1.C0787d;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f9155a;

    public x(int i5) {
        this.f9155a = i5;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(t tVar);

    public abstract C0787d[] b(t tVar);

    public abstract void c(Status status);

    public abstract void d(RuntimeException runtimeException);

    public abstract void e(t tVar);

    public abstract void f(L0.c cVar, boolean z4);
}
