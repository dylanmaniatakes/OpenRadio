package g4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class g extends BitmapDrawable {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f7067d = {-2, -3, -4};

    /* renamed from: a, reason: collision with root package name */
    public int[] f7068a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7069b;

    /* renamed from: c, reason: collision with root package name */
    public int f7070c;

    public g(Bitmap bitmap) {
        super(bitmap);
        this.f7068a = new int[0];
        this.f7069b = false;
        this.f7070c = 0;
    }

    public static int b(Drawable drawable) {
        for (int i5 : drawable.getState()) {
            int[] iArr = f7067d;
            for (int i6 = 0; i6 < 3; i6++) {
                if (i5 == iArr[i6]) {
                    return i5;
                }
            }
        }
        return -1;
    }

    public final void a() {
        synchronized (this) {
            try {
                int i5 = this.f7070c - 1;
                this.f7070c = i5;
                if (i5 < 0) {
                    throw new IllegalStateException("Unbalanced endUsingDrawable() called.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f7068a;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f7068a.length > 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        this.f7068a = iArr;
        return true;
    }
}
