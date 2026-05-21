package m4;

import android.graphics.Paint;

/* loaded from: classes.dex */
public final class i extends h {
    public i() {
        super(true, true);
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(0);
        this.h.setStyle(Paint.Style.FILL);
        this.g.setColor(-16777216);
        this.g.setStrokeWidth(10.0f);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setAntiAlias(true);
    }

    @Override // m4.h
    public final void e(k4.d dVar) {
        this.f8682k = dVar;
        o4.a aVar = this.f8677d;
        if (aVar != null) {
            aVar.f(this, dVar, 0, 0);
        }
    }
}
