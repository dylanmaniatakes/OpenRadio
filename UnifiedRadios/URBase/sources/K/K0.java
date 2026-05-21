package k;

import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class K0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7666j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SearchView f7667k;

    public /* synthetic */ K0(SearchView searchView, int i5) {
        this.f7666j = i5;
        this.f7667k = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7666j) {
            case 0:
                this.f7667k.u();
                break;
            default:
                T.c cVar = this.f7667k.f3414Q;
                if (cVar instanceof T0) {
                    cVar.b(null);
                    break;
                }
                break;
        }
    }
}
