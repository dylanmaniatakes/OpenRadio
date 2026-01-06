package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: classes.dex */
public final class f0 extends Transition.EpicenterCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3801a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f3802b;

    public /* synthetic */ f0(int i5, Rect rect) {
        this.f3801a = i5;
        this.f3802b = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        switch (this.f3801a) {
            case 0:
                return this.f3802b;
            default:
                Rect rect = this.f3802b;
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
