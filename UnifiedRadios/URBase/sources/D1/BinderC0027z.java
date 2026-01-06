package D1;

import com.google.android.gms.location.DeviceOrientation;
import com.google.android.gms.location.zzs;

/* renamed from: D1.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0027z extends zzs {

    /* renamed from: c, reason: collision with root package name */
    public androidx.emoji2.text.e f413c;

    @Override // com.google.android.gms.location.zzt
    public final void zzd(DeviceOrientation deviceOrientation) {
        androidx.emoji2.text.e eVar;
        synchronized (this) {
            eVar = this.f413c;
        }
        eVar.b(new B0.l(3, deviceOrientation));
    }
}
