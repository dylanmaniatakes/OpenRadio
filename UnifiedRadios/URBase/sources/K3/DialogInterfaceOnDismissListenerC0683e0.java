package k3;

import android.content.DialogInterface;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0683e0 implements DialogInterface.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8123c;

    public DialogInterfaceOnDismissListenerC0683e0(LaunchActivity launchActivity) {
        this.f8123c = launchActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f8123c.f5961s1 = null;
    }
}
