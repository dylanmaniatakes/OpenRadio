package m4;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.h0;
import java.util.LinkedHashSet;
import k4.s;
import k4.t;

/* loaded from: classes.dex */
public final class k extends s {

    /* renamed from: e, reason: collision with root package name */
    public Canvas f8692e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ l f8693f;

    public k(l lVar) {
        this.f8693f = lVar;
    }

    @Override // k4.s
    public final void a() {
        h0 h0Var = this.f8693f.f8700j;
        h0Var.f4247b = true;
        for (Runnable runnable : (LinkedHashSet) h0Var.h) {
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // k4.s
    public final void b(int i5, int i6, long j5) {
        int iB;
        boolean z4;
        l lVar = this.f8693f;
        Drawable drawableD = lVar.f8694b.d(j5);
        h0 h0Var = lVar.f8700j;
        h0Var.f4248c++;
        if (drawableD == null || (iB = g4.g.b(drawableD)) == -4) {
            h0Var.g++;
        } else if (iB == -3) {
            h0Var.f4251f++;
        } else if (iB == -2) {
            h0Var.f4250e++;
        } else {
            if (iB != -1) {
                throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(iB, "Unknown state: "));
            }
            h0Var.f4249d++;
        }
        if (this.f8692e == null) {
            return;
        }
        boolean z5 = drawableD instanceof g4.g;
        g4.g gVar = z5 ? (g4.g) drawableD : null;
        if (drawableD == null) {
            drawableD = l.e(lVar);
        }
        if (drawableD != null) {
            l4.l lVar2 = lVar.f8697e;
            Rect rect = lVar.f8695c;
            if (rect == null) {
                lVar2.getClass();
                rect = new Rect();
            }
            double d5 = lVar2.f8488o;
            rect.left = t.j(lVar2.g(Math.round(i5 * d5), false));
            rect.top = t.j(lVar2.h(Math.round(i6 * d5), false));
            rect.right = t.j(lVar2.g(Math.round((i5 + 1) * d5), false));
            rect.bottom = t.j(lVar2.h(Math.round((i6 + 1) * d5), false));
            if (z5) {
                synchronized (gVar) {
                    gVar.f7070c++;
                }
            }
            if (z5) {
                try {
                    synchronized (gVar) {
                        z4 = !gVar.f7069b;
                    }
                    if (!z4) {
                        drawableD = l.e(lVar);
                        z5 = false;
                    }
                } finally {
                    if (z5) {
                        gVar.a();
                    }
                }
            }
            Canvas canvas = this.f8692e;
            Rect rect2 = lVar.f8695c;
            drawableD.setColorFilter(null);
            drawableD.setBounds(rect2.left, rect2.top, rect2.right, rect2.bottom);
            drawableD.draw(canvas);
        }
        e4.a.g().getClass();
    }

    @Override // k4.s
    public final void c() {
        Rect rect = this.f8310a;
        int i5 = ((rect.bottom - rect.top) + 1) * ((rect.right - rect.left) + 1);
        l lVar = this.f8693f;
        g4.d dVar = lVar.f8694b;
        e4.a.g().getClass();
        dVar.f7053j.a(i5);
        h0 h0Var = lVar.f8700j;
        h0Var.f4247b = false;
        h0Var.f4248c = 0;
        h0Var.f4249d = 0;
        h0Var.f4250e = 0;
        h0Var.f4251f = 0;
        h0Var.g = 0;
    }
}
