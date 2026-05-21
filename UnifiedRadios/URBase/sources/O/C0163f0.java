package O;

import android.animation.ValueAnimator;
import android.view.View;
import com.unified.ur1.chat.TypingBubbleView;
import f.C0463I;

/* renamed from: O.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0163f0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1927a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1928b;

    public /* synthetic */ C0163f0(int i5, Object obj) {
        this.f1927a = i5;
        this.f1928b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f1928b;
        switch (this.f1927a) {
            case 0:
                ((View) ((C0463I) ((B0.l) obj).f110d).f6268d.getParent()).invalidate();
                break;
            case 1:
                int i5 = TypingBubbleView.f5782l;
                TypingBubbleView typingBubbleView = (TypingBubbleView) obj;
                typingBubbleView.getClass();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                for (int i6 = 0; i6 < 3; i6++) {
                    typingBubbleView.f5786f[i6] = (((((float) Math.sin((((i6 * 0.15f) + animatedFraction) % 1.0f) * 3.141592653589793d * 2.0d)) * 0.5f) + 0.5f) * 0.8f) + 0.6f;
                }
                typingBubbleView.invalidate();
                break;
            default:
                s2.h hVar = (s2.h) obj;
                hVar.getClass();
                hVar.f9632d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }

    public /* synthetic */ C0163f0(B0.l lVar, View view) {
        this.f1927a = 0;
        this.f1928b = lVar;
    }
}
