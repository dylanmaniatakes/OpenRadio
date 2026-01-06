package B0;

import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.foreground.SystemForegroundService;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0511d;
import java.util.ArrayList;
import java.util.List;
import k3.C0;
import p1.t;

/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f117j;

    /* renamed from: k, reason: collision with root package name */
    public int f118k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f119l;

    public /* synthetic */ r(int i5, int i6, Object obj) {
        this.f117j = i6;
        this.f119l = obj;
        this.f118k = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f117j) {
            case 0:
                ((RecyclerView) this.f119l).j0(this.f118k);
                break;
            case 1:
                ((SystemForegroundService) this.f119l).g.cancel(this.f118k);
                break;
            case 2:
                D.b bVar = (D.b) ((Z2.c) this.f119l).f3147d;
                if (bVar != null) {
                    bVar.g(this.f118k);
                    break;
                }
                break;
            case 3:
                ArrayList arrayList = (ArrayList) this.f119l;
                int size = arrayList.size();
                int i5 = 0;
                if (this.f118k == 1) {
                    while (i5 < size) {
                        ((androidx.emoji2.text.h) arrayList.get(i5)).a();
                        i5++;
                    }
                    break;
                } else {
                    while (i5 < size) {
                        ((androidx.emoji2.text.h) arrayList.get(i5)).getClass();
                        i5++;
                    }
                    break;
                }
            case 4:
                ((com.google.android.material.datepicker.k) this.f119l).f5305j.j0(this.f118k);
                break;
            case 5:
                ((i2.c) this.f119l).j(this.f118k);
                break;
            case 6:
                LaunchActivity launchActivity = (LaunchActivity) this.f119l;
                C0 c02 = launchActivity.f5919d0;
                C0511d c0511dE = C0.g.q().e("lastMemoryId");
                int i6 = this.f118k;
                if (c0511dE == null) {
                    C0511d c0511d = new C0511d("lastMemoryId", "" + i6);
                    C0 c03 = launchActivity.f5919d0;
                    C0.g.q().g(c0511d);
                    break;
                } else {
                    c0511dE.f6684b = "" + i6;
                    C0 c04 = launchActivity.f5919d0;
                    C0.g.q().j(c0511dE);
                    break;
                }
            case 7:
                ((t) this.f119l).i(this.f118k);
                break;
            default:
                ((p2.c) this.f119l).f9204i.x(this.f118k, 4);
                break;
        }
    }

    public r(int i5, RecyclerView recyclerView) {
        this.f117j = 0;
        this.f118k = i5;
        this.f119l = recyclerView;
    }

    public r(List list, int i5, Throwable th) {
        this.f117j = 3;
        h4.f.c(list, "initCallbacks cannot be null");
        this.f119l = new ArrayList(list);
        this.f118k = i5;
    }

    public r(p2.c cVar) {
        this.f117j = 8;
        this.f119l = cVar;
        this.f118k = -1;
    }
}
