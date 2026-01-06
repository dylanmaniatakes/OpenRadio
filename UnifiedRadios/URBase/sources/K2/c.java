package k2;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.gms.internal.measurement.D1;

/* loaded from: classes.dex */
public final class c extends D1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7919b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextPaint f7920c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ D1 f7921d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f7922e;

    public c(d dVar, Context context, TextPaint textPaint, D1 d12) {
        this.f7922e = dVar;
        this.f7919b = context;
        this.f7920c = textPaint;
        this.f7921d = d12;
    }

    @Override // com.google.android.gms.internal.measurement.D1
    public final void l(int i5) {
        this.f7921d.l(i5);
    }

    @Override // com.google.android.gms.internal.measurement.D1
    public final void m(Typeface typeface, boolean z4) {
        this.f7922e.g(this.f7919b, this.f7920c, typeface);
        this.f7921d.m(typeface, z4);
    }
}
