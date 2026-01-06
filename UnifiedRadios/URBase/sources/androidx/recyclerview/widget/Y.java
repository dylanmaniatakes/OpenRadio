package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class Y extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public n0 f4190a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f4191b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4192c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4193d;

    public Y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4191b = new Rect();
        this.f4192c = true;
        this.f4193d = false;
    }

    public Y(int i5, int i6) {
        super(i5, i6);
        this.f4191b = new Rect();
        this.f4192c = true;
        this.f4193d = false;
    }

    public Y(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f4191b = new Rect();
        this.f4192c = true;
        this.f4193d = false;
    }

    public Y(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f4191b = new Rect();
        this.f4192c = true;
        this.f4193d = false;
    }

    public Y(Y y4) {
        super((ViewGroup.LayoutParams) y4);
        this.f4191b = new Rect();
        this.f4192c = true;
        this.f4193d = false;
    }
}
