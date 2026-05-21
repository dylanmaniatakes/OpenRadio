package androidx.activity;

import android.window.OnBackInvokedCallback;
import f.x;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3243a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3244b;

    public /* synthetic */ o(int i5, Object obj) {
        this.f3243a = i5;
        this.f3244b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f3243a) {
            case 0:
                E3.a aVar = (E3.a) this.f3244b;
                F3.i.f(aVar, "$onBackInvoked");
                aVar.invoke();
                break;
            case 1:
                ((x) this.f3244b).E();
                break;
            default:
                ((Runnable) this.f3244b).run();
                break;
        }
    }
}
