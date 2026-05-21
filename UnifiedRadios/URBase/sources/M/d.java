package M;

import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f1651a;

    /* renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f1652b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1653c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1654d;

    public d(PrecomputedText.Params params) {
        this.f1651a = params.getTextPaint();
        this.f1652b = params.getTextDirection();
        this.f1653c = params.getBreakStrategy();
        this.f1654d = params.getHyphenationFrequency();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f1653c == dVar.f1653c && this.f1654d == dVar.f1654d) {
            TextPaint textPaint = this.f1651a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = dVar.f1651a;
            return textSize == textPaint2.getTextSize() && textPaint.getTextScaleX() == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales()) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null) && this.f1652b == dVar.f1652b;
        }
        return false;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f1651a;
        return N.b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f1652b, Integer.valueOf(this.f1653c), Integer.valueOf(this.f1654d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f1651a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        sb.append(", textDir=" + this.f1652b);
        sb.append(", breakStrategy=" + this.f1653c);
        sb.append(", hyphenationFrequency=" + this.f1654d);
        sb.append("}");
        return sb.toString();
    }
}
