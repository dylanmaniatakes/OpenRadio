package q2;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g2.m;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9436j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f9437k;

    public /* synthetic */ d(i iVar, int i5) {
        this.f9436j = i5;
        this.f9437k = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Rect rect;
        i iVar = this.f9437k;
        int i5 = 1;
        byte b5 = 0;
        switch (this.f9436j) {
            case 0:
                if (iVar.f9462i != null && (context = iVar.h) != null) {
                    int i6 = m.f6949d;
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (Build.VERSION.SDK_INT >= 30) {
                        rect = windowManager.getCurrentWindowMetrics().getBounds();
                    } else {
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getRealSize(point);
                        rect = new Rect();
                        rect.right = point.x;
                        rect.bottom = point.y;
                    }
                    int iHeight = rect.height();
                    int[] iArr = new int[2];
                    h hVar = iVar.f9462i;
                    hVar.getLocationInWindow(iArr);
                    int height = (iHeight - (hVar.getHeight() + iArr[1])) + ((int) iVar.f9462i.getTranslationY());
                    int i7 = iVar.f9470r;
                    if (height < i7) {
                        ViewGroup.LayoutParams layoutParams = iVar.f9462i.getLayoutParams();
                        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                            Log.w(i.f9451B, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                            break;
                        } else {
                            int i8 = iVar.f9470r;
                            iVar.f9471s = i8;
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.bottomMargin = (i8 - height) + marginLayoutParams.bottomMargin;
                            iVar.f9462i.requestLayout();
                            break;
                        }
                    } else {
                        iVar.f9471s = i7;
                        break;
                    }
                }
                break;
            case 1:
                iVar.c();
                break;
            default:
                h hVar2 = iVar.f9462i;
                if (hVar2 != null) {
                    ViewParent parent = hVar2.getParent();
                    h hVar3 = iVar.f9462i;
                    if (parent != null) {
                        hVar3.setVisibility(0);
                    }
                    if (hVar3.getAnimationMode() != 1) {
                        int height2 = hVar3.getHeight();
                        ViewGroup.LayoutParams layoutParams2 = hVar3.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            height2 += ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        }
                        hVar3.setTranslationY(height2);
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(height2, 0);
                        valueAnimator.setInterpolator(iVar.f9460e);
                        valueAnimator.setDuration(iVar.f9458c);
                        valueAnimator.addListener(new C0868a(iVar, i5));
                        valueAnimator.addUpdateListener(new b(iVar, height2));
                        valueAnimator.start();
                        break;
                    } else {
                        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
                        valueAnimatorOfFloat.setInterpolator(iVar.f9459d);
                        valueAnimatorOfFloat.addUpdateListener(new b(iVar, b5, b5));
                        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
                        valueAnimatorOfFloat2.setInterpolator(iVar.f9461f);
                        valueAnimatorOfFloat2.addUpdateListener(new b(iVar, i5, b5));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
                        animatorSet.setDuration(iVar.f9456a);
                        animatorSet.addListener(new C0868a(iVar, 3));
                        animatorSet.start();
                        break;
                    }
                }
                break;
        }
    }
}
