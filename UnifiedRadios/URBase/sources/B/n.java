package B;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f54a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f55b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f57d;

    /* renamed from: e, reason: collision with root package name */
    public final int f58e;

    /* renamed from: f, reason: collision with root package name */
    public final CharSequence f59f;
    public final PendingIntent g;

    public n(int i5, String str, PendingIntent pendingIntent) {
        IconCompat iconCompatA = i5 == 0 ? null : IconCompat.a(i5);
        Bundle bundle = new Bundle();
        this.f57d = true;
        this.f55b = iconCompatA;
        if (iconCompatA != null) {
            int i6 = iconCompatA.f3542a;
            if ((i6 == -1 ? F.f.c(iconCompatA.f3543b) : i6) == 2) {
                this.f58e = iconCompatA.b();
            }
        }
        this.f59f = t.b(str);
        this.g = pendingIntent;
        this.f54a = bundle;
        this.f56c = true;
        this.f57d = true;
    }
}
