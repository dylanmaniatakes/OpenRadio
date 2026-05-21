package g3;

import android.view.ScaleGestureDetector;
import com.unified.ur1.chat.SimpleImageViewerActivity;

/* loaded from: classes.dex */
public final class C extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleImageViewerActivity f6958a;

    public C(SimpleImageViewerActivity simpleImageViewerActivity) {
        this.f6958a = simpleImageViewerActivity;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        SimpleImageViewerActivity simpleImageViewerActivity = this.f6958a;
        simpleImageViewerActivity.g *= scaleFactor;
        simpleImageViewerActivity.g = Math.max(0.1f, Math.min(simpleImageViewerActivity.g, 10.0f));
        simpleImageViewerActivity.h = scaleGestureDetector.getFocusX();
        simpleImageViewerActivity.f5777i = scaleGestureDetector.getFocusY();
        simpleImageViewerActivity.f5776f.postScale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getScaleFactor(), simpleImageViewerActivity.h, simpleImageViewerActivity.f5777i);
        simpleImageViewerActivity.f5773c.setImageMatrix(simpleImageViewerActivity.f5776f);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f6958a.f5778j = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f6958a.f5778j = false;
    }
}
