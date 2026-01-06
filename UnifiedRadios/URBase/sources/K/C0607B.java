package k;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.unified.ur1.R;

/* renamed from: k.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0607B extends RatingBar {

    /* renamed from: c, reason: collision with root package name */
    public final C0668z f7634c;

    public C0607B(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        U0.a(this, getContext());
        C0668z c0668z = new C0668z(this);
        this.f7634c = c0668z;
        c0668z.d(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        Bitmap bitmap = (Bitmap) this.f7634c.f7913c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i5, 0), getMeasuredHeight());
        }
    }
}
