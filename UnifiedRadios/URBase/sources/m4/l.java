package m4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.recyclerview.widget.h0;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import k4.p;
import org.conscrypt.PSKKeyManager;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class l extends e {

    /* renamed from: b, reason: collision with root package name */
    public final g4.d f8694b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f8695c;

    /* renamed from: d, reason: collision with root package name */
    public final p f8696d;

    /* renamed from: e, reason: collision with root package name */
    public l4.l f8697e;

    /* renamed from: f, reason: collision with root package name */
    public BitmapDrawable f8698f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f8699i;

    /* renamed from: j, reason: collision with root package name */
    public final h0 f8700j;

    /* renamed from: k, reason: collision with root package name */
    public final k f8701k;

    static {
        AtomicInteger atomicInteger = e.f8674a;
        atomicInteger.getAndIncrement();
        atomicInteger.getAndAdd(i4.f.f7377c.size());
        atomicInteger.getAndIncrement();
        atomicInteger.getAndIncrement();
        atomicInteger.getAndIncrement();
        new ColorMatrixColorFilter(new float[]{-1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, 255.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED});
    }

    public l(g4.d dVar, boolean z4, boolean z5) {
        new Paint();
        this.f8695c = new Rect();
        this.f8696d = new p();
        this.f8698f = null;
        this.g = Color.rgb(216, 208, 208);
        this.h = Color.rgb(200, 192, 192);
        this.f8699i = new Rect();
        h0 h0Var = new h0(1);
        h0Var.h = new LinkedHashSet();
        this.f8700j = h0Var;
        k kVar = new k(this);
        this.f8701k = kVar;
        new Rect();
        if (dVar == null) {
            throw new IllegalArgumentException("You must pass a valid tile provider to the tiles overlay.");
        }
        this.f8694b = dVar;
        kVar.f8312c = z4;
        kVar.f8313d = z5;
    }

    public static Drawable e(l lVar) {
        lVar.getClass();
        if (lVar.f8698f == null && lVar.g != 0) {
            try {
                i4.c cVar = lVar.f8694b.f7056m;
                int i5 = cVar != null ? ((i4.d) cVar).f7372f : PSKKeyManager.MAX_KEY_LENGTH_BYTES;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint();
                canvas.drawColor(lVar.g);
                paint.setColor(lVar.h);
                paint.setStrokeWidth(BitmapDescriptorFactory.HUE_RED);
                int i6 = i5 / 16;
                for (int i7 = 0; i7 < i5; i7 += i6) {
                    float f5 = i7;
                    float f6 = i5;
                    canvas.drawLine(BitmapDescriptorFactory.HUE_RED, f5, f6, f5, paint);
                    canvas.drawLine(f5, BitmapDescriptorFactory.HUE_RED, f5, f6, paint);
                }
                lVar.f8698f = new BitmapDrawable(bitmapCreateBitmap);
            } catch (NullPointerException unused) {
                Log.e("OsmDroid", "NullPointerException getting loading tile");
                System.gc();
            } catch (OutOfMemoryError unused2) {
                Log.e("OsmDroid", "OutOfMemoryError getting loading tile");
                System.gc();
            }
        }
        return lVar.f8698f;
    }

    @Override // m4.e
    public final void a(Canvas canvas, l4.l lVar) {
        e4.a.g().getClass();
        g(lVar);
        l4.l lVar2 = this.f8697e;
        double d5 = lVar2.f8483i;
        this.f8697e = lVar2;
        k kVar = this.f8701k;
        kVar.f8692e = canvas;
        kVar.d(d5, this.f8696d);
    }

    @Override // m4.e
    public final void b(MapView mapView) {
        this.f8694b.c();
        g4.a.f7035c.a(this.f8698f);
        this.f8698f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4 A[PHI: r1
      0x00d4: PHI (r1v17 int) = (r1v16 int), (r1v16 int), (r1v16 int), (r1v22 int) binds: [B:20:0x00a3, B:26:0x00c7, B:28:0x00cb, B:30:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(l4.l r14) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.l.f(l4.l):void");
    }

    public final void g(l4.l lVar) {
        this.f8697e = lVar;
        lVar.getClass();
        p pVar = this.f8696d;
        if (pVar == null) {
            pVar = new p();
        }
        Rect rect = lVar.f8485k;
        float f5 = rect.left;
        float f6 = rect.right;
        float f7 = rect.top;
        float f8 = rect.bottom;
        if (lVar.f8489p != BitmapDescriptorFactory.HUE_RED) {
            float[] fArr = {f5, f7, f6, f8, f5, f8, f6, f7};
            lVar.f8482f.mapPoints(fArr);
            for (int i5 = 0; i5 < 8; i5 += 2) {
                float f9 = fArr[i5];
                if (f5 > f9) {
                    f5 = f9;
                }
                if (f6 < f9) {
                    f6 = f9;
                }
                float f10 = fArr[i5 + 1];
                if (f7 > f10) {
                    f7 = f10;
                }
                if (f8 < f10) {
                    f8 = f10;
                }
            }
        }
        long j5 = lVar.f8477a;
        pVar.f8287a = ((int) f5) - j5;
        long j6 = (int) f7;
        long j7 = lVar.f8478b;
        pVar.f8288b = j6 - j7;
        pVar.f8289c = ((int) f6) - j5;
        pVar.f8290d = ((int) f8) - j7;
    }
}
