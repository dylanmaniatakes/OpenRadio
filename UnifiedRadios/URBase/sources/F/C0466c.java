package f;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* renamed from: f.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0466c implements AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0468e f6287c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0467d f6288d;

    public C0466c(C0467d c0467d, C0468e c0468e) {
        this.f6288d = c0467d;
        this.f6287c = c0468e;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        C0467d c0467d = this.f6288d;
        DialogInterface.OnClickListener onClickListener = c0467d.f6303r;
        C0468e c0468e = this.f6287c;
        onClickListener.onClick(c0468e.f6319b, i5);
        if (c0467d.f6305t) {
            return;
        }
        c0468e.f6319b.dismiss();
    }
}
