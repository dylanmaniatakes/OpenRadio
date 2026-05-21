package B;

import android.app.Notification;

/* loaded from: classes.dex */
public final class s extends u {

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f63d;

    @Override // B.u
    public final void h(L0.i iVar) {
        new Notification.BigTextStyle((Notification.Builder) iVar.f1548d).setBigContentTitle(null).bigText(this.f63d);
    }

    @Override // B.u
    public final String i() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
