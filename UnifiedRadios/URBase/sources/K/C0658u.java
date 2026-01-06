package k;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import e.AbstractC0429a;

/* renamed from: k.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0658u {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7870a;

    /* renamed from: b, reason: collision with root package name */
    public final Z2.c f7871b;

    public C0658u(TextView textView) {
        this.f7870a = textView;
        this.f7871b = new Z2.c(textView);
    }

    public final void a(AttributeSet attributeSet, int i5) {
        TypedArray typedArrayObtainStyledAttributes = this.f7870a.getContext().obtainStyledAttributes(attributeSet, AbstractC0429a.f6121i, i5, 0);
        try {
            boolean z4 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            c(z4);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b(boolean z4) {
        ((AbstractC0409x1) this.f7871b.f3147d).l(z4);
    }

    public final void c(boolean z4) {
        ((AbstractC0409x1) this.f7871b.f3147d).m(z4);
    }
}
