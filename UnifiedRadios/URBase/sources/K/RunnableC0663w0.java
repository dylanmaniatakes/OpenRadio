package k;

import java.util.WeakHashMap;

/* renamed from: k.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0663w0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7878j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0667y0 f7879k;

    public /* synthetic */ RunnableC0663w0(C0667y0 c0667y0, int i5) {
        this.f7878j = i5;
        this.f7879k = c0667y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0667y0 c0667y0 = this.f7879k;
        switch (this.f7878j) {
            case 0:
                C0648o0 c0648o0 = c0667y0.f7891e;
                if (c0648o0 != null) {
                    c0648o0.setListSelectionHidden(true);
                    c0648o0.requestLayout();
                    break;
                }
                break;
            default:
                C0648o0 c0648o02 = c0667y0.f7891e;
                if (c0648o02 != null) {
                    WeakHashMap weakHashMap = O.Y.f1904a;
                    if (O.J.b(c0648o02) && c0667y0.f7891e.getCount() > c0667y0.f7891e.getChildCount() && c0667y0.f7891e.getChildCount() <= c0667y0.f7898o) {
                        c0667y0.f7888B.setInputMethodMode(2);
                        c0667y0.c();
                        break;
                    }
                }
                break;
        }
    }
}
