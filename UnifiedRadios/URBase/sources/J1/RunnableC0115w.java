package J1;

import android.util.Log;
import f3.C0511d;

/* renamed from: J1.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0115w implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1435j;

    public /* synthetic */ RunnableC0115w(int i5) {
        this.f1435j = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1435j) {
            case 0:
                com.google.android.gms.internal.measurement.J1.f4703i.incrementAndGet();
                return;
            case 1:
                try {
                    int i5 = K.l.f1491a;
                    K.k.a("EmojiCompat.EmojiCompatInitializer.run");
                    if (androidx.emoji2.text.j.f3607j != null) {
                        androidx.emoji2.text.j.a().c();
                    }
                    K.k.b();
                    return;
                } catch (Throwable th) {
                    int i6 = K.l.f1491a;
                    K.k.b();
                    throw th;
                }
            default:
                try {
                    C0511d c0511dE = k3.C0.g.q().e("hidePTT");
                    if (c0511dE == null) {
                        k3.C0.g.q().g(new C0511d("hidePTT", "true"));
                    } else {
                        c0511dE.f6684b = "true";
                        k3.C0.g.q().j(c0511dE);
                    }
                    return;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error updating hidePTT setting", e5);
                    return;
                }
        }
    }
}
