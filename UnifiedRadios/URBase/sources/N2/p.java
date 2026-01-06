package n2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m2.C0762a;

/* loaded from: classes.dex */
public final class p extends v {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f8860c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f8861d;

    public p(ArrayList arrayList, Matrix matrix) {
        this.f8860c = arrayList;
        this.f8861d = matrix;
    }

    @Override // n2.v
    public final void a(Matrix matrix, C0762a c0762a, int i5, Canvas canvas) {
        Iterator it = this.f8860c.iterator();
        while (it.hasNext()) {
            ((v) it.next()).a(this.f8861d, c0762a, i5, canvas);
        }
    }
}
