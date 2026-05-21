package x;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* loaded from: classes.dex */
public final class p extends View {

    /* renamed from: c, reason: collision with root package name */
    public boolean f10343c;

    public p(Context context) {
        super(context);
        this.f10343c = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z4) {
        this.f10343c = z4;
    }

    public void setGuidelineBegin(int i5) {
        e eVar = (e) getLayoutParams();
        if (this.f10343c && eVar.f10184a == i5) {
            return;
        }
        eVar.f10184a = i5;
        setLayoutParams(eVar);
    }

    public void setGuidelineEnd(int i5) {
        e eVar = (e) getLayoutParams();
        if (this.f10343c && eVar.f10186b == i5) {
            return;
        }
        eVar.f10186b = i5;
        setLayoutParams(eVar);
    }

    public void setGuidelinePercent(float f5) {
        e eVar = (e) getLayoutParams();
        if (this.f10343c && eVar.f10188c == f5) {
            return;
        }
        eVar.f10188c = f5;
        setLayoutParams(eVar);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
    }
}
