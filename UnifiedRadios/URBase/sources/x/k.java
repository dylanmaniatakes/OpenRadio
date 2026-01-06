package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import t.AbstractC0901a;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f10314j;

    /* renamed from: a, reason: collision with root package name */
    public int f10315a;

    /* renamed from: b, reason: collision with root package name */
    public int f10316b;

    /* renamed from: c, reason: collision with root package name */
    public int f10317c;

    /* renamed from: d, reason: collision with root package name */
    public float f10318d;

    /* renamed from: e, reason: collision with root package name */
    public float f10319e;

    /* renamed from: f, reason: collision with root package name */
    public float f10320f;
    public int g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public int f10321i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10314j = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f10349f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i5);
            switch (f10314j.get(index)) {
                case 1:
                    this.f10319e = typedArrayObtainStyledAttributes.getFloat(index, this.f10319e);
                    break;
                case 2:
                    this.f10317c = typedArrayObtainStyledAttributes.getInt(index, this.f10317c);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = AbstractC0901a.f9695a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f10315a = n.f(typedArrayObtainStyledAttributes, index, this.f10315a);
                    break;
                case 6:
                    this.f10316b = typedArrayObtainStyledAttributes.getInteger(index, this.f10316b);
                    break;
                case 7:
                    this.f10318d = typedArrayObtainStyledAttributes.getFloat(index, this.f10318d);
                    break;
                case 8:
                    this.g = typedArrayObtainStyledAttributes.getInteger(index, this.g);
                    break;
                case 9:
                    this.f10320f = typedArrayObtainStyledAttributes.getFloat(index, this.f10320f);
                    break;
                case 10:
                    int i6 = typedArrayObtainStyledAttributes.peekValue(index).type;
                    if (i6 == 1) {
                        this.f10321i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        break;
                    } else if (i6 == 3) {
                        String string = typedArrayObtainStyledAttributes.getString(index);
                        this.h = string;
                        if (string.indexOf("/") > 0) {
                            this.f10321i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        typedArrayObtainStyledAttributes.getInteger(index, this.f10321i);
                        break;
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
