package i;

import O.C0169i0;
import O.InterfaceC0171j0;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f7183c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0171j0 f7184d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7185e;

    /* renamed from: b, reason: collision with root package name */
    public long f7182b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final k f7186f = new k(this);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7181a = new ArrayList();

    public final void a() {
        if (this.f7185e) {
            Iterator it = this.f7181a.iterator();
            while (it.hasNext()) {
                ((C0169i0) it.next()).b();
            }
            this.f7185e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f7185e) {
            return;
        }
        Iterator it = this.f7181a.iterator();
        while (it.hasNext()) {
            C0169i0 c0169i0 = (C0169i0) it.next();
            long j5 = this.f7182b;
            if (j5 >= 0) {
                c0169i0.c(j5);
            }
            Interpolator interpolator = this.f7183c;
            if (interpolator != null && (view = (View) c0169i0.f1934a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f7184d != null) {
                c0169i0.d(this.f7186f);
            }
            View view2 = (View) c0169i0.f1934a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f7185e = true;
    }
}
