package g4;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashSet;
import k4.m;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: j, reason: collision with root package name */
    public final b f7053j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f7054k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7055l;

    /* renamed from: m, reason: collision with root package name */
    public i4.c f7056m;

    public d(i4.c cVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f7054k = linkedHashSet;
        this.f7055l = true;
        this.f7053j = new b();
        linkedHashSet.add(null);
        this.f7056m = cVar;
    }

    public final void b() {
        m mVar = new m();
        b bVar = this.f7053j;
        bVar.c(mVar);
        for (int i5 = 0; i5 < mVar.f8284k; i5++) {
            bVar.d(mVar.f8283j[i5]);
        }
        bVar.f7038a.clear();
    }

    public abstract void c();

    public abstract Drawable d(long j5);

    public final void e(long j5, Drawable drawable, int i5) {
        if (drawable == null) {
            return;
        }
        b bVar = this.f7053j;
        Drawable drawableB = bVar.b(j5);
        if (drawableB == null || g.b(drawableB) <= i5) {
            int[] iArr = g.f7067d;
            drawable.setState(new int[]{i5});
            synchronized (bVar.f7038a) {
                bVar.f7038a.put(Long.valueOf(j5), drawable);
            }
        }
    }

    public final void f(int i5) {
        for (int i6 = 0; i6 < 3; i6++) {
            for (Handler handler : this.f7054k) {
                try {
                    if (handler != null) {
                        handler.sendEmptyMessage(i5);
                    }
                } catch (ConcurrentModificationException unused) {
                }
            }
            return;
        }
    }

    public abstract void g(i4.c cVar);
}
