package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public int f10322a;

    /* renamed from: b, reason: collision with root package name */
    public int f10323b;

    /* renamed from: c, reason: collision with root package name */
    public float f10324c;

    /* renamed from: d, reason: collision with root package name */
    public float f10325d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.g);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i5);
            if (index == 1) {
                this.f10324c = typedArrayObtainStyledAttributes.getFloat(index, this.f10324c);
            } else if (index == 0) {
                int i6 = typedArrayObtainStyledAttributes.getInt(index, this.f10322a);
                this.f10322a = i6;
                this.f10322a = n.f10337d[i6];
            } else if (index == 4) {
                this.f10323b = typedArrayObtainStyledAttributes.getInt(index, this.f10323b);
            } else if (index == 3) {
                this.f10325d = typedArrayObtainStyledAttributes.getFloat(index, this.f10325d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
