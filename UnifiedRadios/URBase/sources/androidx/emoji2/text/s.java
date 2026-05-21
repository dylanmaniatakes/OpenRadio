package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class s extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final l f3640b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f3639a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public float f3641c = 1.0f;

    public s(l lVar) {
        h4.f.c(lVar, "metadata cannot be null");
        this.f3640b = lVar;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
        j.a().getClass();
        l lVar = this.f3640b;
        L0.i iVar = lVar.f3618b;
        Typeface typeface = (Typeface) iVar.f1550f;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) iVar.f1548d, lVar.f3617a * 2, 2, f5, i8, paint);
        paint.setTypeface(typeface2);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f3639a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        l lVar = this.f3640b;
        this.f3641c = fAbs / (lVar.c().a(14) != 0 ? ((ByteBuffer) r8.f1892d).getShort(r1 + r8.f1889a) : (short) 0);
        X.a aVarC = lVar.c();
        int iA = aVarC.a(14);
        if (iA != 0) {
            ((ByteBuffer) aVarC.f1892d).getShort(iA + aVarC.f1889a);
        }
        short s4 = (short) ((lVar.c().a(12) != 0 ? ((ByteBuffer) r5.f1892d).getShort(r7 + r5.f1889a) : (short) 0) * this.f3641c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s4;
    }
}
