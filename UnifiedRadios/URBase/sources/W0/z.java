package w0;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.unified.ur1.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class z extends q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f10120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f10121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f10122c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f10123d;

    public z(i iVar, ViewGroup viewGroup, View view, View view2) {
        this.f10123d = iVar;
        this.f10120a = viewGroup;
        this.f10121b = view;
        this.f10122c = view2;
    }

    @Override // w0.q, w0.o
    public final void b() {
        this.f10120a.getOverlay().remove(this.f10121b);
    }

    @Override // w0.q, w0.o
    public final void c() {
        View view = this.f10121b;
        if (view.getParent() == null) {
            this.f10120a.getOverlay().add(view);
            return;
        }
        i iVar = this.f10123d;
        ArrayList arrayList = iVar.f10097v;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = iVar.f10101z;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) iVar.f10101z.clone();
        int size2 = arrayList3.size();
        for (int i5 = 0; i5 < size2; i5++) {
            ((o) arrayList3.get(i5)).d();
        }
    }

    @Override // w0.o
    public final void e(p pVar) {
        this.f10122c.setTag(R.id.save_overlay_view, null);
        this.f10120a.getOverlay().remove(this.f10121b);
        pVar.v(this);
    }
}
