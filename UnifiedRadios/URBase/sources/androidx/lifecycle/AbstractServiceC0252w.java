package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* renamed from: androidx.lifecycle.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractServiceC0252w extends Service implements InterfaceC0249t {

    /* renamed from: c, reason: collision with root package name */
    public final L0.m f3975c = new L0.m((InterfaceC0249t) this);

    @Override // androidx.lifecycle.InterfaceC0249t
    public final AbstractC0245o getLifecycle() {
        return (C0251v) this.f3975c.f1556d;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        F3.i.f(intent, "intent");
        this.f3975c.l(EnumC0243m.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f3975c.l(EnumC0243m.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        EnumC0243m enumC0243m = EnumC0243m.ON_STOP;
        L0.m mVar = this.f3975c;
        mVar.l(enumC0243m);
        mVar.l(EnumC0243m.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i5) {
        this.f3975c.l(EnumC0243m.ON_START);
        super.onStart(intent, i5);
    }
}
