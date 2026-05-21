package s2;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class e extends n2.g {

    /* renamed from: v, reason: collision with root package name */
    public final RectF f9589v;

    public e(n2.m mVar, RectF rectF) {
        super(mVar);
        this.f9589v = rectF;
    }

    @Override // n2.g, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        f fVar = new f(this);
        fVar.invalidateSelf();
        return fVar;
    }

    public e(e eVar) {
        super(eVar);
        this.f9589v = eVar.f9589v;
    }
}
