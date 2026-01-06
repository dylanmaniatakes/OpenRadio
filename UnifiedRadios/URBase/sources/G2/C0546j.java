package g2;

import android.content.Context;
import android.text.TextPaint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* renamed from: g2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0546j {

    /* renamed from: c, reason: collision with root package name */
    public float f6942c;

    /* renamed from: d, reason: collision with root package name */
    public float f6943d;

    /* renamed from: f, reason: collision with root package name */
    public final WeakReference f6945f;
    public k2.d g;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f6940a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final Z1.b f6941b = new Z1.b(1, this);

    /* renamed from: e, reason: collision with root package name */
    public boolean f6944e = true;

    public C0546j(InterfaceC0545i interfaceC0545i) {
        this.f6945f = new WeakReference(null);
        this.f6945f = new WeakReference(interfaceC0545i);
    }

    public final float a(String str) {
        if (!this.f6944e) {
            return this.f6942c;
        }
        b(str);
        return this.f6942c;
    }

    public final void b(String str) {
        TextPaint textPaint = this.f6940a;
        float fAbs = BitmapDescriptorFactory.HUE_RED;
        this.f6942c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            fAbs = Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f6943d = fAbs;
        this.f6944e = false;
    }

    public final void c(k2.d dVar, Context context) {
        if (this.g != dVar) {
            this.g = dVar;
            if (dVar != null) {
                TextPaint textPaint = this.f6940a;
                Z1.b bVar = this.f6941b;
                dVar.f(context, textPaint, bVar);
                InterfaceC0545i interfaceC0545i = (InterfaceC0545i) this.f6945f.get();
                if (interfaceC0545i != null) {
                    textPaint.drawableState = interfaceC0545i.getState();
                }
                dVar.e(context, textPaint, bVar);
                this.f6944e = true;
            }
            InterfaceC0545i interfaceC0545i2 = (InterfaceC0545i) this.f6945f.get();
            if (interfaceC0545i2 != null) {
                interfaceC0545i2.a();
                interfaceC0545i2.onStateChange(interfaceC0545i2.getState());
            }
        }
    }
}
