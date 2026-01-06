package v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g2.C0546j;
import g2.InterfaceC0545i;
import k2.d;
import n2.f;
import n2.h;
import n2.i;
import n2.l;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0921a extends h implements InterfaceC0545i {

    /* renamed from: A, reason: collision with root package name */
    public final Context f10014A;

    /* renamed from: B, reason: collision with root package name */
    public final Paint.FontMetrics f10015B;

    /* renamed from: C, reason: collision with root package name */
    public final C0546j f10016C;

    /* renamed from: D, reason: collision with root package name */
    public final T1.a f10017D;

    /* renamed from: E, reason: collision with root package name */
    public final Rect f10018E;

    /* renamed from: F, reason: collision with root package name */
    public int f10019F;

    /* renamed from: G, reason: collision with root package name */
    public int f10020G;

    /* renamed from: H, reason: collision with root package name */
    public int f10021H;
    public int I;

    /* renamed from: J, reason: collision with root package name */
    public int f10022J;

    /* renamed from: K, reason: collision with root package name */
    public int f10023K;

    /* renamed from: L, reason: collision with root package name */
    public float f10024L;

    /* renamed from: M, reason: collision with root package name */
    public float f10025M;

    /* renamed from: N, reason: collision with root package name */
    public float f10026N;

    /* renamed from: O, reason: collision with root package name */
    public float f10027O;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f10028z;

    public C0921a(Context context, int i5) {
        super(context, null, 0, i5);
        this.f10015B = new Paint.FontMetrics();
        C0546j c0546j = new C0546j(this);
        this.f10016C = c0546j;
        this.f10017D = new T1.a(3, this);
        this.f10018E = new Rect();
        this.f10024L = 1.0f;
        this.f10025M = 1.0f;
        this.f10026N = 0.5f;
        this.f10027O = 1.0f;
        this.f10014A = context;
        TextPaint textPaint = c0546j.f6940a;
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.save();
        float fR = r();
        float f5 = (float) (-((Math.sqrt(2.0d) * this.f10022J) - this.f10022J));
        canvas.scale(this.f10024L, this.f10025M, (getBounds().width() * 0.5f) + getBounds().left, (getBounds().height() * this.f10026N) + getBounds().top);
        canvas.translate(fR, f5);
        super.draw(canvas);
        if (this.f10028z != null) {
            float fCenterY = getBounds().centerY();
            C0546j c0546j = this.f10016C;
            TextPaint textPaint = c0546j.f6940a;
            Paint.FontMetrics fontMetrics = this.f10015B;
            textPaint.getFontMetrics(fontMetrics);
            int i5 = (int) (fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
            d dVar = c0546j.g;
            TextPaint textPaint2 = c0546j.f6940a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                c0546j.g.e(this.f10014A, textPaint2, c0546j.f6941b);
                textPaint2.setAlpha((int) (this.f10027O * 255.0f));
            }
            CharSequence charSequence = this.f10028z;
            canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), i5, textPaint2);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) Math.max(this.f10016C.f6940a.getTextSize(), this.f10021H);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f5 = this.f10019F * 2;
        CharSequence charSequence = this.f10028z;
        return (int) Math.max(f5 + (charSequence == null ? BitmapDescriptorFactory.HUE_RED : this.f10016C.a(charSequence.toString())), this.f10020G);
    }

    @Override // n2.h, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        l lVarE = this.f8806c.f8787a.e();
        lVarE.f8836k = s();
        setShapeAppearanceModel(lVarE.a());
    }

    public final float r() {
        int i5;
        Rect rect = this.f10018E;
        if (((rect.right - getBounds().right) - this.f10023K) - this.I < 0) {
            i5 = ((rect.right - getBounds().right) - this.f10023K) - this.I;
        } else {
            if (((rect.left - getBounds().left) - this.f10023K) + this.I <= 0) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            i5 = ((rect.left - getBounds().left) - this.f10023K) + this.I;
        }
        return i5;
    }

    public final i s() {
        float f5 = -r();
        float fWidth = ((float) (getBounds().width() - (Math.sqrt(2.0d) * this.f10022J))) / 2.0f;
        return new i(new f(this.f10022J), Math.min(Math.max(f5, -fWidth), fWidth));
    }
}
