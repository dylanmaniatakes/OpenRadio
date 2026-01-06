package k;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* renamed from: k.L, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0617L implements AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7668c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7669d;

    public /* synthetic */ C0617L(int i5, Object obj) {
        this.f7668c = i5;
        this.f7669d = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        Object item;
        switch (this.f7668c) {
            case 0:
                N n = (N) this.f7669d;
                n.I.setSelection(i5);
                if (n.I.getOnItemClickListener() != null) {
                    n.I.performItemClick(view, i5, n.f7675F.getItemId(i5));
                }
                n.dismiss();
                break;
            case 1:
                ((SearchView) this.f7669d).p(i5);
                break;
            default:
                s2.r rVar = (s2.r) this.f7669d;
                if (i5 < 0) {
                    C0667y0 c0667y0 = rVar.g;
                    item = !c0667y0.f7888B.isShowing() ? null : c0667y0.f7891e.getSelectedItem();
                } else {
                    item = rVar.getAdapter().getItem(i5);
                }
                s2.r.a(rVar, item);
                AdapterView.OnItemClickListener onItemClickListener = rVar.getOnItemClickListener();
                C0667y0 c0667y02 = rVar.g;
                if (onItemClickListener != null) {
                    if (view == null || i5 < 0) {
                        view = c0667y02.f7888B.isShowing() ? c0667y02.f7891e.getSelectedView() : null;
                        i5 = !c0667y02.f7888B.isShowing() ? -1 : c0667y02.f7891e.getSelectedItemPosition();
                        j5 = !c0667y02.f7888B.isShowing() ? Long.MIN_VALUE : c0667y02.f7891e.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(c0667y02.f7891e, view, i5, j5);
                }
                c0667y02.dismiss();
                break;
        }
    }
}
