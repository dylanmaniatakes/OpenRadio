package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import org.conscrypt.FileClientSessionCache;

/* loaded from: classes.dex */
public final class m {
    public static final SparseIntArray n;

    /* renamed from: a, reason: collision with root package name */
    public float f10326a;

    /* renamed from: b, reason: collision with root package name */
    public float f10327b;

    /* renamed from: c, reason: collision with root package name */
    public float f10328c;

    /* renamed from: d, reason: collision with root package name */
    public float f10329d;

    /* renamed from: e, reason: collision with root package name */
    public float f10330e;

    /* renamed from: f, reason: collision with root package name */
    public float f10331f;
    public float g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public float f10332i;

    /* renamed from: j, reason: collision with root package name */
    public float f10333j;

    /* renamed from: k, reason: collision with root package name */
    public float f10334k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10335l;

    /* renamed from: m, reason: collision with root package name */
    public float f10336m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
        sparseIntArray.append(11, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f10350i);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i5);
            switch (n.get(index)) {
                case 1:
                    this.f10326a = typedArrayObtainStyledAttributes.getFloat(index, this.f10326a);
                    break;
                case 2:
                    this.f10327b = typedArrayObtainStyledAttributes.getFloat(index, this.f10327b);
                    break;
                case 3:
                    this.f10328c = typedArrayObtainStyledAttributes.getFloat(index, this.f10328c);
                    break;
                case 4:
                    this.f10329d = typedArrayObtainStyledAttributes.getFloat(index, this.f10329d);
                    break;
                case 5:
                    this.f10330e = typedArrayObtainStyledAttributes.getFloat(index, this.f10330e);
                    break;
                case 6:
                    this.f10331f = typedArrayObtainStyledAttributes.getDimension(index, this.f10331f);
                    break;
                case 7:
                    this.g = typedArrayObtainStyledAttributes.getDimension(index, this.g);
                    break;
                case 8:
                    this.f10332i = typedArrayObtainStyledAttributes.getDimension(index, this.f10332i);
                    break;
                case 9:
                    this.f10333j = typedArrayObtainStyledAttributes.getDimension(index, this.f10333j);
                    break;
                case 10:
                    this.f10334k = typedArrayObtainStyledAttributes.getDimension(index, this.f10334k);
                    break;
                case 11:
                    this.f10335l = true;
                    this.f10336m = typedArrayObtainStyledAttributes.getDimension(index, this.f10336m);
                    break;
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    this.h = n.f(typedArrayObtainStyledAttributes, index, this.h);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
