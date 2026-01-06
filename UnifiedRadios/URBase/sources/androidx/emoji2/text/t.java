package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class t implements Spannable {

    /* renamed from: j, reason: collision with root package name */
    public boolean f3642j = false;

    /* renamed from: k, reason: collision with root package name */
    public Spannable f3643k;

    public t(Spannable spannable) {
        this.f3643k = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i5) {
        return this.f3643k.charAt(i5);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f3643k.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f3643k.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f3643k.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f3643k.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f3643k.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i5, int i6, Class cls) {
        return this.f3643k.getSpans(i5, i6, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f3643k.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i5, int i6, Class cls) {
        return this.f3643k.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f3643k;
        if (!this.f3642j && (spannable instanceof PrecomputedText)) {
            this.f3643k = new SpannableString(spannable);
        }
        this.f3642j = true;
        this.f3643k.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i5, int i6, int i7) {
        Spannable spannable = this.f3643k;
        if (!this.f3642j && (spannable instanceof PrecomputedText)) {
            this.f3643k = new SpannableString(spannable);
        }
        this.f3642j = true;
        this.f3643k.setSpan(obj, i5, i6, i7);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i5, int i6) {
        return this.f3643k.subSequence(i5, i6);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f3643k.toString();
    }

    public t(CharSequence charSequence) {
        this.f3643k = new SpannableString(charSequence);
    }
}
