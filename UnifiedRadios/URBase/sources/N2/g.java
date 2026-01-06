package n2;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import d2.C0428a;

/* loaded from: classes.dex */
public class g extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public m f8787a;

    /* renamed from: b, reason: collision with root package name */
    public C0428a f8788b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f8789c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f8790d;

    /* renamed from: e, reason: collision with root package name */
    public final ColorStateList f8791e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f8792f;
    public PorterDuff.Mode g;
    public Rect h;

    /* renamed from: i, reason: collision with root package name */
    public final float f8793i;

    /* renamed from: j, reason: collision with root package name */
    public float f8794j;

    /* renamed from: k, reason: collision with root package name */
    public float f8795k;

    /* renamed from: l, reason: collision with root package name */
    public int f8796l;

    /* renamed from: m, reason: collision with root package name */
    public float f8797m;
    public float n;

    /* renamed from: o, reason: collision with root package name */
    public final float f8798o;

    /* renamed from: p, reason: collision with root package name */
    public int f8799p;

    /* renamed from: q, reason: collision with root package name */
    public int f8800q;

    /* renamed from: r, reason: collision with root package name */
    public int f8801r;

    /* renamed from: s, reason: collision with root package name */
    public final int f8802s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f8803t;

    /* renamed from: u, reason: collision with root package name */
    public final Paint.Style f8804u;

    public g(m mVar) {
        this.f8789c = null;
        this.f8790d = null;
        this.f8791e = null;
        this.f8792f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.f8793i = 1.0f;
        this.f8794j = 1.0f;
        this.f8796l = 255;
        this.f8797m = BitmapDescriptorFactory.HUE_RED;
        this.n = BitmapDescriptorFactory.HUE_RED;
        this.f8798o = BitmapDescriptorFactory.HUE_RED;
        this.f8799p = 0;
        this.f8800q = 0;
        this.f8801r = 0;
        this.f8802s = 0;
        this.f8803t = false;
        this.f8804u = Paint.Style.FILL_AND_STROKE;
        this.f8787a = mVar;
        this.f8788b = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        h hVar = new h(this);
        hVar.g = true;
        return hVar;
    }

    public g(g gVar) {
        this.f8789c = null;
        this.f8790d = null;
        this.f8791e = null;
        this.f8792f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.f8793i = 1.0f;
        this.f8794j = 1.0f;
        this.f8796l = 255;
        this.f8797m = BitmapDescriptorFactory.HUE_RED;
        this.n = BitmapDescriptorFactory.HUE_RED;
        this.f8798o = BitmapDescriptorFactory.HUE_RED;
        this.f8799p = 0;
        this.f8800q = 0;
        this.f8801r = 0;
        this.f8802s = 0;
        this.f8803t = false;
        this.f8804u = Paint.Style.FILL_AND_STROKE;
        this.f8787a = gVar.f8787a;
        this.f8788b = gVar.f8788b;
        this.f8795k = gVar.f8795k;
        this.f8789c = gVar.f8789c;
        this.f8790d = gVar.f8790d;
        this.g = gVar.g;
        this.f8792f = gVar.f8792f;
        this.f8796l = gVar.f8796l;
        this.f8793i = gVar.f8793i;
        this.f8801r = gVar.f8801r;
        this.f8799p = gVar.f8799p;
        this.f8803t = gVar.f8803t;
        this.f8794j = gVar.f8794j;
        this.f8797m = gVar.f8797m;
        this.n = gVar.n;
        this.f8798o = gVar.f8798o;
        this.f8800q = gVar.f8800q;
        this.f8802s = gVar.f8802s;
        this.f8791e = gVar.f8791e;
        this.f8804u = gVar.f8804u;
        if (gVar.h != null) {
            this.h = new Rect(gVar.h);
        }
    }
}
