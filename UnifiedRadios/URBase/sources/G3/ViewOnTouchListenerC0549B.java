package g3;

import android.graphics.Matrix;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.measurement.C1;
import com.unified.ur1.chat.SimpleImageViewerActivity;
import com.unified.ur1.primary.DTMFKeypad;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.RadioAudioService;
import k.C0666y;
import k.C0667y0;

/* renamed from: g3.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnTouchListenerC0549B implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6956c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6957d;

    public /* synthetic */ ViewOnTouchListenerC0549B(int i5, Object obj) {
        this.f6956c = i5;
        this.f6957d = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C0666y c0666y;
        switch (this.f6956c) {
            case 0:
                SimpleImageViewerActivity simpleImageViewerActivity = (SimpleImageViewerActivity) this.f6957d;
                simpleImageViewerActivity.f5775e.onTouchEvent(motionEvent);
                if (!simpleImageViewerActivity.f5778j) {
                    simpleImageViewerActivity.getClass();
                    int action = motionEvent.getAction() & 255;
                    if (action == 0) {
                        float x4 = motionEvent.getX();
                        float y4 = motionEvent.getY();
                        simpleImageViewerActivity.f5779k = x4;
                        simpleImageViewerActivity.f5780l = y4;
                        simpleImageViewerActivity.f5781m = motionEvent.getPointerId(0);
                        break;
                    } else if (action == 1) {
                        simpleImageViewerActivity.f5781m = -1;
                        break;
                    } else if (action == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(simpleImageViewerActivity.f5781m);
                        float x5 = motionEvent.getX(iFindPointerIndex);
                        float y5 = motionEvent.getY(iFindPointerIndex);
                        if (!simpleImageViewerActivity.f5778j) {
                            float f5 = x5 - simpleImageViewerActivity.f5779k;
                            float f6 = y5 - simpleImageViewerActivity.f5780l;
                            Matrix matrix = simpleImageViewerActivity.f5776f;
                            matrix.postTranslate(f5, f6);
                            simpleImageViewerActivity.f5773c.setImageMatrix(matrix);
                        }
                        simpleImageViewerActivity.f5779k = x5;
                        simpleImageViewerActivity.f5780l = y5;
                        break;
                    } else if (action == 3) {
                        simpleImageViewerActivity.f5781m = -1;
                        break;
                    } else if (action == 6) {
                        int action2 = (motionEvent.getAction() & 65280) >> 8;
                        if (motionEvent.getPointerId(action2) == simpleImageViewerActivity.f5781m) {
                            int i5 = action2 == 0 ? 1 : 0;
                            simpleImageViewerActivity.f5779k = motionEvent.getX(i5);
                            simpleImageViewerActivity.f5780l = motionEvent.getY(i5);
                            simpleImageViewerActivity.f5781m = motionEvent.getPointerId(i5);
                            break;
                        }
                    }
                }
                break;
            case 1:
                int action3 = motionEvent.getAction();
                int x6 = (int) motionEvent.getX();
                int y6 = (int) motionEvent.getY();
                C0667y0 c0667y0 = (C0667y0) this.f6957d;
                if (action3 == 0 && (c0666y = c0667y0.f7888B) != null && c0666y.isShowing() && x6 >= 0 && x6 < c0667y0.f7888B.getWidth() && y6 >= 0 && y6 < c0667y0.f7888B.getHeight()) {
                    c0667y0.f7907x.postDelayed(c0667y0.f7903t, 250L);
                    break;
                } else if (action3 == 1) {
                    c0667y0.f7907x.removeCallbacks(c0667y0.f7903t);
                    break;
                }
                break;
            case 2:
                int action4 = motionEvent.getAction();
                DTMFKeypad dTMFKeypad = (DTMFKeypad) this.f6957d;
                if (action4 == 0) {
                    dTMFKeypad.e();
                    view.setPressed(true);
                    break;
                } else if (action4 != 1 && action4 != 3) {
                    break;
                } else {
                    dTMFKeypad.f();
                    view.setPressed(false);
                    break;
                }
                break;
            case 3:
                LaunchActivity launchActivity = (LaunchActivity) this.f6957d;
                RadioAudioService radioAudioService = launchActivity.f5965u;
                if (radioAudioService != null) {
                    radioAudioService.b(false);
                }
                launchActivity.p0();
                int action5 = motionEvent.getAction();
                if (action5 == 0) {
                    launchActivity.f5972w1 = true;
                    launchActivity.f5913a1.acquire();
                    new C1(launchActivity, h4.c.E(launchActivity)).d(launchActivity, launchActivity.f5965u);
                    ((Vibrator) launchActivity.getSystemService("vibrator")).vibrate(100L);
                    break;
                } else if (action5 == 1) {
                    launchActivity.f5965u.a();
                    launchActivity.N0();
                    launchActivity.f5972w1 = false;
                    if (launchActivity.f5913a1.isHeld()) {
                        launchActivity.f5913a1.release();
                        break;
                    }
                }
                break;
            default:
                if (motionEvent.getAction() == 1) {
                    ((o4.a) this.f6957d).a();
                    break;
                }
                break;
        }
        return true;
    }
}
