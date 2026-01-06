package g2;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: g2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0544h {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f6930a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f6931b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6932c;

    /* renamed from: d, reason: collision with root package name */
    public int f6933d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6938k;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f6934e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f6935f = Integer.MAX_VALUE;
    public float g = BitmapDescriptorFactory.HUE_RED;
    public float h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f6936i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6937j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f6939l = null;

    public C0544h(CharSequence charSequence, TextPaint textPaint, int i5) {
        this.f6930a = charSequence;
        this.f6931b = textPaint;
        this.f6932c = i5;
        this.f6933d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f6930a == null) {
            this.f6930a = "";
        }
        int iMax = Math.max(0, this.f6932c);
        CharSequence charSequenceEllipsize = this.f6930a;
        int i5 = this.f6935f;
        TextPaint textPaint = this.f6931b;
        if (i5 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.f6939l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f6933d);
        this.f6933d = iMin;
        if (this.f6938k && this.f6935f == 1) {
            this.f6934e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.f6934e);
        builderObtain.setIncludePad(this.f6937j);
        builderObtain.setTextDirection(this.f6938k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f6939l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f6935f);
        float f5 = this.g;
        if (f5 != BitmapDescriptorFactory.HUE_RED || this.h != 1.0f) {
            builderObtain.setLineSpacing(f5, this.h);
        }
        if (this.f6935f > 1) {
            builderObtain.setHyphenationFrequency(this.f6936i);
        }
        return builderObtain.build();
    }
}
