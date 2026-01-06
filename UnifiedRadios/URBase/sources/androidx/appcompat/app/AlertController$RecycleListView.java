package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import e.AbstractC0429a;

/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: c, reason: collision with root package name */
    public final int f3284c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3285d;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6131t);
        this.f3285d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f3284c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
