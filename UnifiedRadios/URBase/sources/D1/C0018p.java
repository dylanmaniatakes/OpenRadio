package D1;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.location.LocationListener;

/* renamed from: D1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0018p implements p1.o, p1.m {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Location f401c;

    public /* synthetic */ C0018p(Location location) {
        this.f401c = location;
    }

    @Override // p1.m
    public /* bridge */ /* synthetic */ void j(Object obj) {
        ((LocationListener) obj).onLocationChanged(this.f401c);
    }

    @Override // p1.o
    public /* synthetic */ void p(Object obj, Object obj2) throws RemoteException {
        ((D) obj).B(this.f401c, (N1.k) obj2);
    }
}
