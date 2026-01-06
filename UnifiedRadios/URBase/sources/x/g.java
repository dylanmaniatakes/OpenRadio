package x;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final float f10229a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10230b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10231c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10232d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10233e;

    public g(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f10229a = Float.NaN;
        this.f10230b = Float.NaN;
        this.f10231c = Float.NaN;
        this.f10232d = Float.NaN;
        this.f10233e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f10351j);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i5);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f10233e);
                this.f10233e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f10232d = typedArrayObtainStyledAttributes.getDimension(index, this.f10232d);
            } else if (index == 2) {
                this.f10230b = typedArrayObtainStyledAttributes.getDimension(index, this.f10230b);
            } else if (index == 3) {
                this.f10231c = typedArrayObtainStyledAttributes.getDimension(index, this.f10231c);
            } else if (index == 4) {
                this.f10229a = typedArrayObtainStyledAttributes.getDimension(index, this.f10229a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
