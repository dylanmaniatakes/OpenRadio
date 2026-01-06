package k;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: k.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0626d0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7753a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7754b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f7755c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f7756d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f7757e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f7758f = new int[0];
    public boolean g = false;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f7759i;

    static {
        new RectF();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public C0626d0(TextView textView) {
        this.h = textView;
        this.f7759i = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            new C0622b0();
        } else {
            new C0620a0();
        }
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (i5 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i5)) < 0) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr2;
    }

    public final boolean b() {
        if (d() && this.f7753a == 1) {
            if (!this.g || this.f7758f.length == 0) {
                int iFloor = ((int) Math.floor((this.f7757e - this.f7756d) / this.f7755c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i5 = 0; i5 < iFloor; i5++) {
                    iArr[i5] = Math.round((i5 * this.f7755c) + this.f7756d);
                }
                this.f7758f = a(iArr);
            }
            this.f7754b = true;
        } else {
            this.f7754b = false;
        }
        return this.f7754b;
    }

    public final boolean c() {
        boolean z4 = this.f7758f.length > 0;
        this.g = z4;
        if (z4) {
            this.f7753a = 1;
            this.f7756d = r0[0];
            this.f7757e = r0[r1 - 1];
            this.f7755c = -1.0f;
        }
        return z4;
    }

    public final boolean d() {
        return !(this.h instanceof C0656t);
    }

    public final void e(float f5, float f6, float f7) {
        if (f5 <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f5 + "px) is less or equal to (0px)");
        }
        if (f6 <= f5) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f5 + "px)");
        }
        if (f7 <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f7 + "px) is less or equal to (0px)");
        }
        this.f7753a = 1;
        this.f7756d = f5;
        this.f7757e = f6;
        this.f7755c = f7;
        this.g = false;
    }
}
