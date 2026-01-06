package x0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* renamed from: x0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0957m extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f10405a;

    /* renamed from: b, reason: collision with root package name */
    public C0956l f10406b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f10407c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f10408d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10409e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f10410f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    /* renamed from: i, reason: collision with root package name */
    public int f10411i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10412j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10413k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f10414l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f10405a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new C0959o(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new C0959o(this);
    }
}
