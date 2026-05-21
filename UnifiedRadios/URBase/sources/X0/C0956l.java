package x0;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: x0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0956l {

    /* renamed from: p, reason: collision with root package name */
    public static final Matrix f10392p = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final Path f10393a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f10394b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f10395c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f10396d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f10397e;

    /* renamed from: f, reason: collision with root package name */
    public PathMeasure f10398f;
    public final C0953i g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f10399i;

    /* renamed from: j, reason: collision with root package name */
    public float f10400j;

    /* renamed from: k, reason: collision with root package name */
    public float f10401k;

    /* renamed from: l, reason: collision with root package name */
    public int f10402l;

    /* renamed from: m, reason: collision with root package name */
    public String f10403m;
    public Boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final q.b f10404o;

    public C0956l() {
        this.f10395c = new Matrix();
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.f10399i = BitmapDescriptorFactory.HUE_RED;
        this.f10400j = BitmapDescriptorFactory.HUE_RED;
        this.f10401k = BitmapDescriptorFactory.HUE_RED;
        this.f10402l = 255;
        this.f10403m = null;
        this.n = null;
        this.f10404o = new q.b();
        this.g = new C0953i();
        this.f10393a = new Path();
        this.f10394b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e6  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(x0.C0953i r19, android.graphics.Matrix r20, android.graphics.Canvas r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.C0956l.a(x0.i, android.graphics.Matrix, android.graphics.Canvas, int, int):void");
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f10402l;
    }

    public void setAlpha(float f5) {
        setRootAlpha((int) (f5 * 255.0f));
    }

    public void setRootAlpha(int i5) {
        this.f10402l = i5;
    }

    public C0956l(C0956l c0956l) {
        this.f10395c = new Matrix();
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.f10399i = BitmapDescriptorFactory.HUE_RED;
        this.f10400j = BitmapDescriptorFactory.HUE_RED;
        this.f10401k = BitmapDescriptorFactory.HUE_RED;
        this.f10402l = 255;
        this.f10403m = null;
        this.n = null;
        q.b bVar = new q.b();
        this.f10404o = bVar;
        this.g = new C0953i(c0956l.g, bVar);
        this.f10393a = new Path(c0956l.f10393a);
        this.f10394b = new Path(c0956l.f10394b);
        this.h = c0956l.h;
        this.f10399i = c0956l.f10399i;
        this.f10400j = c0956l.f10400j;
        this.f10401k = c0956l.f10401k;
        this.f10402l = c0956l.f10402l;
        this.f10403m = c0956l.f10403m;
        String str = c0956l.f10403m;
        if (str != null) {
            bVar.put(str, this);
        }
        this.n = c0956l.n;
    }
}
