package x0;

import android.graphics.drawable.Drawable;

/* renamed from: x0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0947c implements Drawable.Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0949e f10361c;

    public C0947c(C0949e c0949e) {
        this.f10361c = c0949e;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        this.f10361c.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        this.f10361c.scheduleSelf(runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f10361c.unscheduleSelf(runnable);
    }
}
