package D1;

import android.location.Location;
import com.google.android.gms.location.zzy;
import f3.C0519j;

/* loaded from: classes.dex */
public final class C extends zzy {

    /* renamed from: c, reason: collision with root package name */
    public final A f332c;

    public C(A a2) {
        this.f332c = a2;
    }

    @Override // com.google.android.gms.location.zzz
    public final void zzd(Location location) {
        this.f332c.a().b(new C0018p(location));
    }

    @Override // com.google.android.gms.location.zzz
    public final void zze() {
        this.f332c.a().b(new C0519j(4, this));
    }
}
