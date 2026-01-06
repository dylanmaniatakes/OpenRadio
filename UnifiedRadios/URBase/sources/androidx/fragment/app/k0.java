package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class k0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3826j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3827k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3828l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3829m;
    public final /* synthetic */ ArrayList n;

    public k0(int i5, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f3826j = i5;
        this.f3827k = arrayList;
        this.f3828l = arrayList2;
        this.f3829m = arrayList3;
        this.n = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i5 = 0; i5 < this.f3826j; i5++) {
            View view = (View) this.f3827k.get(i5);
            String str = (String) this.f3828l.get(i5);
            WeakHashMap weakHashMap = O.Y.f1904a;
            O.M.v(view, str);
            O.M.v((View) this.f3829m.get(i5), (String) this.n.get(i5));
        }
    }
}
