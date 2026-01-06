package l0;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.room.MultiInstanceInvalidationService;

/* renamed from: l0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RemoteCallbackListC0735k extends RemoteCallbackList {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f8351a;

    public RemoteCallbackListC0735k(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f8351a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object obj) {
        F3.i.f((InterfaceC0730f) iInterface, "callback");
        F3.i.f(obj, "cookie");
        this.f8351a.f4403d.remove((Integer) obj);
    }
}
