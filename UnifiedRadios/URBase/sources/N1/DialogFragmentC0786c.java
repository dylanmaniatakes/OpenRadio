package n1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import q1.E;

/* renamed from: n1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogFragmentC0786c extends DialogFragment {

    /* renamed from: c, reason: collision with root package name */
    public Dialog f8731c;

    /* renamed from: d, reason: collision with root package name */
    public DialogInterface.OnCancelListener f8732d;

    /* renamed from: e, reason: collision with root package name */
    public AlertDialog f8733e;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f8732d;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f8731c;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f8733e == null) {
            Activity activity = getActivity();
            E.i(activity);
            this.f8733e = new AlertDialog.Builder(activity).create();
        }
        return this.f8733e;
    }
}
