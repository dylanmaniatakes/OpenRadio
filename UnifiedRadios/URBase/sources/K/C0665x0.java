package k;

import android.os.Handler;
import android.widget.AbsListView;

/* renamed from: k.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0665x0 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0667y0 f7884a;

    public C0665x0(C0667y0 c0667y0) {
        this.f7884a = c0667y0;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i5, int i6, int i7) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i5) {
        if (i5 == 1) {
            C0667y0 c0667y0 = this.f7884a;
            if (c0667y0.f7888B.getInputMethodMode() == 2 || c0667y0.f7888B.getContentView() == null) {
                return;
            }
            Handler handler = c0667y0.f7907x;
            RunnableC0663w0 runnableC0663w0 = c0667y0.f7903t;
            handler.removeCallbacks(runnableC0663w0);
            runnableC0663w0.run();
        }
    }
}
