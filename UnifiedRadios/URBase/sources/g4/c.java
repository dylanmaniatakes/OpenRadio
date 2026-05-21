package g4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import h4.h;
import java.util.HashMap;
import k4.l;
import k4.s;

/* loaded from: classes.dex */
public final class c extends s {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f7046e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public int f7047f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f7048i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f7049j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7050k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f7051l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f7052m;
    public final /* synthetic */ d n;

    public c(d dVar, int i5) {
        this.f7052m = i5;
        this.n = dVar;
        this.f7051l = dVar;
    }

    @Override // k4.s
    public final void a() {
        while (true) {
            HashMap map = this.f7046e;
            if (map.isEmpty()) {
                return;
            }
            Long l5 = (Long) map.keySet().iterator().next();
            this.f7051l.e(l5.longValue(), new g((Bitmap) map.remove(l5)), -3);
            e4.a.g().getClass();
        }
    }

    @Override // k4.s
    public final void b(int i5, int i6, long j5) {
        if (this.f7050k && this.f7051l.d(j5) == null) {
            try {
                e(j5);
            } catch (OutOfMemoryError unused) {
                Log.e("OsmDroid", "OutOfMemoryError rescaling cache");
            }
        }
    }

    @Override // k4.s
    public final void c() {
        int iAbs = Math.abs(this.f8311b - this.f7047f);
        this.h = iAbs;
        this.f7048i = this.g >> iAbs;
        this.f7050k = iAbs != 0;
    }

    public final void e(long j5) {
        Bitmap bitmapK;
        Bitmap bitmap;
        switch (this.f7052m) {
            case 0:
                Drawable drawableB = this.n.f7053j.b(l.f(this.f7047f, l.g(j5) >> this.h, l.h(j5) >> this.h));
                if ((drawableB instanceof BitmapDrawable) && (bitmapK = h.k((BitmapDrawable) drawableB, j5, this.h)) != null) {
                    this.f7046e.put(Long.valueOf(j5), bitmapK);
                    break;
                }
                break;
            default:
                if (this.h < 4) {
                    int iG = l.g(j5) << this.h;
                    int iH = l.h(j5);
                    int i5 = this.h;
                    int i6 = iH << i5;
                    boolean z4 = true;
                    int i7 = 1 << i5;
                    int i8 = 0;
                    Bitmap bitmapCreateBitmap = null;
                    Canvas canvas = null;
                    while (i8 < i7) {
                        int i9 = 0;
                        while (i9 < i7) {
                            Drawable drawableB2 = this.n.f7053j.b(l.f(this.f7047f, iG + i8, i6 + i9));
                            if ((drawableB2 instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawableB2).getBitmap()) != null) {
                                if (bitmapCreateBitmap == null) {
                                    int i10 = this.g;
                                    Bitmap bitmapB = a.f7035c.b(i10, i10);
                                    if (bitmapB != null) {
                                        bitmapB.setHasAlpha(z4);
                                        bitmapB.eraseColor(0);
                                        bitmapCreateBitmap = bitmapB;
                                    } else {
                                        bitmapCreateBitmap = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
                                    }
                                    canvas = new Canvas(bitmapCreateBitmap);
                                    canvas.drawColor(-3355444);
                                }
                                Rect rect = this.f7049j;
                                int i11 = this.f7048i;
                                rect.set(i8 * i11, i9 * i11, (i8 + 1) * i11, i11 * (i9 + 1));
                                canvas.drawBitmap(bitmap, (Rect) null, this.f7049j, (Paint) null);
                            }
                            i9++;
                            z4 = true;
                        }
                        i8++;
                        z4 = true;
                    }
                    if (bitmapCreateBitmap != null) {
                        this.f7046e.put(Long.valueOf(j5), bitmapCreateBitmap);
                        break;
                    }
                }
                break;
        }
    }
}
