package k;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import f.C0467d;
import f.DialogC0469f;

/* renamed from: k.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0615J implements P, DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public DialogC0469f f7660c;

    /* renamed from: d, reason: collision with root package name */
    public ListAdapter f7661d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f7662e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Q f7663f;

    public DialogInterfaceOnClickListenerC0615J(Q q4) {
        this.f7663f = q4;
    }

    @Override // k.P
    public final int a() {
        return 0;
    }

    @Override // k.P
    public final boolean b() {
        DialogC0469f dialogC0469f = this.f7660c;
        if (dialogC0469f != null) {
            return dialogC0469f.isShowing();
        }
        return false;
    }

    @Override // k.P
    public final Drawable d() {
        return null;
    }

    @Override // k.P
    public final void dismiss() {
        DialogC0469f dialogC0469f = this.f7660c;
        if (dialogC0469f != null) {
            dialogC0469f.dismiss();
            this.f7660c = null;
        }
    }

    @Override // k.P
    public final void e(CharSequence charSequence) {
        this.f7662e = charSequence;
    }

    @Override // k.P
    public final void h(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // k.P
    public final void i(int i5) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // k.P
    public final void j(int i5) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // k.P
    public final void l(int i5) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // k.P
    public final void m(int i5, int i6) {
        if (this.f7661d == null) {
            return;
        }
        Q q4 = this.f7663f;
        L.h hVar = new L.h(q4.getPopupContext());
        CharSequence charSequence = this.f7662e;
        C0467d c0467d = (C0467d) hVar.f1522d;
        if (charSequence != null) {
            c0467d.f6292d = charSequence;
        }
        ListAdapter listAdapter = this.f7661d;
        int selectedItemPosition = q4.getSelectedItemPosition();
        c0467d.f6302q = listAdapter;
        c0467d.f6303r = this;
        c0467d.f6306u = selectedItemPosition;
        c0467d.f6305t = true;
        DialogC0469f dialogC0469fB = hVar.b();
        this.f7660c = dialogC0469fB;
        AlertController$RecycleListView alertController$RecycleListView = dialogC0469fB.h.g;
        AbstractC0613H.d(alertController$RecycleListView, i5);
        AbstractC0613H.c(alertController$RecycleListView, i6);
        this.f7660c.show();
    }

    @Override // k.P
    public final int n() {
        return 0;
    }

    @Override // k.P
    public final CharSequence o() {
        return this.f7662e;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        Q q4 = this.f7663f;
        q4.setSelection(i5);
        if (q4.getOnItemClickListener() != null) {
            q4.performItemClick(null, i5, this.f7661d.getItemId(i5));
        }
        dismiss();
    }

    @Override // k.P
    public final void p(ListAdapter listAdapter) {
        this.f7661d = listAdapter;
    }
}
