package x0;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;

/* renamed from: x0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0948d extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public C0959o f10362a;

    /* renamed from: b, reason: collision with root package name */
    public AnimatorSet f10363b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f10364c;

    /* renamed from: d, reason: collision with root package name */
    public q.b f10365d;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}
