package x0;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* renamed from: x0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0946b extends Animatable2.AnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Y1.a f10360a;

    public C0946b(Y1.a aVar) {
        this.f10360a = aVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.f10360a.f2938b.f2951q;
        if (colorStateList != null) {
            F.b.h(drawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        Y1.c cVar = this.f10360a.f2938b;
        ColorStateList colorStateList = cVar.f2951q;
        if (colorStateList != null) {
            F.b.g(drawable, colorStateList.getColorForState(cVar.f2955u, colorStateList.getDefaultColor()));
        }
    }
}
