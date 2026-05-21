package C0;

import android.app.Notification;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f160b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f161c;

    public i(int i5, Notification notification, int i6) {
        this.f159a = i5;
        this.f161c = notification;
        this.f160b = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f159a == iVar.f159a && this.f160b == iVar.f160b) {
            return this.f161c.equals(iVar.f161c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f161c.hashCode() + (((this.f159a * 31) + this.f160b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f159a + ", mForegroundServiceType=" + this.f160b + ", mNotification=" + this.f161c + '}';
    }
}
