package X2;

import a.AbstractC0203a;
import com.google.firebase.messaging.FirebaseMessaging;
import f3.C0519j;
import m1.C0760a;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements N1.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2812c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f2813d;

    public /* synthetic */ l(FirebaseMessaging firebaseMessaging, int i5) {
        this.f2812c = i5;
        this.f2813d = firebaseMessaging;
    }

    @Override // N1.g
    public final void h(Object obj) throws NumberFormatException {
        boolean z4;
        switch (this.f2812c) {
            case 0:
                z zVar = (z) obj;
                if (!this.f2813d.f5547e.e() || zVar.h.a() == null) {
                    return;
                }
                synchronized (zVar) {
                    z4 = zVar.g;
                }
                if (z4) {
                    return;
                }
                zVar.e(0L);
                return;
            default:
                C0760a c0760a = (C0760a) obj;
                C0519j c0519j = FirebaseMessaging.f5540k;
                FirebaseMessaging firebaseMessaging = this.f2813d;
                firebaseMessaging.getClass();
                if (c0760a != null) {
                    AbstractC0203a.i(c0760a.f8510j);
                    firebaseMessaging.e();
                    return;
                }
                return;
        }
    }
}
