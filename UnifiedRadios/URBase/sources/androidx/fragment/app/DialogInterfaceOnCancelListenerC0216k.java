package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnCancelListenerC0216k implements DialogInterface.OnCancelListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DialogInterfaceOnCancelListenerC0219n f3825c;

    public DialogInterfaceOnCancelListenerC0216k(DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n) {
        this.f3825c = dialogInterfaceOnCancelListenerC0219n;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterfaceOnCancelListenerC0219n dialogInterfaceOnCancelListenerC0219n = this.f3825c;
        Dialog dialog = dialogInterfaceOnCancelListenerC0219n.n;
        if (dialog != null) {
            dialogInterfaceOnCancelListenerC0219n.onCancel(dialog);
        }
    }
}
