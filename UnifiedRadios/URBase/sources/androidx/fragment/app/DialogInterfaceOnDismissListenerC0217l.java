package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnDismissListenerC0217l implements DialogInterface.OnDismissListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0219n f3830c;

    public DialogInterfaceOnDismissListenerC0217l(DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n) {
        this.f3830c = dialogInterfaceOnCancelListenerC0219n;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n = this.f3830c;
        Dialog dialog = dialogInterfaceOnCancelListenerC0219n.n;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0219n.onDismiss(dialog);
        }
    }
}
