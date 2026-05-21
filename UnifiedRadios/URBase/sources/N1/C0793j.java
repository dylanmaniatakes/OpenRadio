package n1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0219n;
import q1.E;

/* renamed from: n1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0793j extends DialogInterfaceOnCancelListenerC0219n {

    /* renamed from: s, reason: collision with root package name */
    public Dialog f8750s;

    /* renamed from: t, reason: collision with root package name */
    public DialogInterface.OnCancelListener f8751t;

    /* renamed from: u, reason: collision with root package name */
    public AlertDialog f8752u;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0219n
    public final Dialog h() {
        Dialog dialog = this.f8750s;
        if (dialog != null) {
            return dialog;
        }
        this.f3842j = false;
        if (this.f8752u == null) {
            Context context = getContext();
            E.i(context);
            this.f8752u = new AlertDialog.Builder(context).create();
        }
        return this.f8752u;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0219n, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f8751t;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
