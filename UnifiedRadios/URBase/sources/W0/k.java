package w0;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f10067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10068b;

    public k(View view, ArrayList arrayList) {
        this.f10067a = view;
        this.f10068b = arrayList;
    }

    @Override // w0.o
    public final void a() {
    }

    @Override // w0.o
    public final void b() {
    }

    @Override // w0.o
    public final void c() {
    }

    @Override // w0.o
    public final void d() {
    }

    @Override // w0.o
    public final void e(p pVar) {
        pVar.v(this);
        this.f10067a.setVisibility(8);
        ArrayList arrayList = this.f10068b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((View) arrayList.get(i5)).setVisibility(0);
        }
    }
}
