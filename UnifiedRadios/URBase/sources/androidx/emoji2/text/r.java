package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r extends SpannableStringBuilder {

    /* renamed from: j, reason: collision with root package name */
    public final Class f3637j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f3638k;

    public r(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f3638k = new ArrayList();
        h4.f.c(cls, "watcherClass cannot be null");
        this.f3637j = cls;
    }

    public final void a() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f3638k;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((q) arrayList.get(i5)).f3636d.incrementAndGet();
            i5++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    public final void b() {
        e();
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f3638k;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((q) arrayList.get(i5)).onTextChanged(this, 0, length(), length());
            i5++;
        }
    }

    public final q c(Object obj) {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f3638k;
            if (i5 >= arrayList.size()) {
                return null;
            }
            q qVar = (q) arrayList.get(i5);
            if (qVar.f3635c == obj) {
                return qVar;
            }
            i5++;
        }
    }

    public final boolean d(Object obj) {
        if (obj != null) {
            if (this.f3637j == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    public final void e() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f3638k;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((q) arrayList.get(i5)).f3636d.decrementAndGet();
            i5++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        q qVarC;
        if (d(obj) && (qVarC = c(obj)) != null) {
            obj = qVarC;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        q qVarC;
        if (d(obj) && (qVarC = c(obj)) != null) {
            obj = qVarC;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        q qVarC;
        if (d(obj) && (qVarC = c(obj)) != null) {
            obj = qVarC;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i5, int i6, Class cls) {
        if (this.f3637j != cls) {
            return super.getSpans(i5, i6, cls);
        }
        q[] qVarArr = (q[]) super.getSpans(i5, i6, q.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, qVarArr.length);
        for (int i7 = 0; i7 < qVarArr.length; i7++) {
            objArr[i7] = qVarArr[i7].f3635c;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i5, int i6, Class cls) {
        if (cls == null || this.f3637j == cls) {
            cls = q.class;
        }
        return super.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        q qVarC;
        if (d(obj)) {
            qVarC = c(obj);
            if (qVarC != null) {
                obj = qVarC;
            }
        } else {
            qVarC = null;
        }
        super.removeSpan(obj);
        if (qVarC != null) {
            this.f3638k.remove(qVarC);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i5, int i6, CharSequence charSequence) {
        replace(i5, i6, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i5, int i6, int i7) {
        if (d(obj)) {
            q qVar = new q(obj);
            this.f3638k.add(qVar);
            obj = qVar;
        }
        super.setSpan(obj, i5, i6, i7);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i5, int i6) {
        return new r(this.f3637j, this, i5, i6);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        replace(i5, i6, charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence) {
        a();
        super.replace(i5, i6, charSequence);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    public r(Class cls, CharSequence charSequence, int i5, int i6) {
        super(charSequence, i5, i6);
        this.f3638k = new ArrayList();
        h4.f.c(cls, "watcherClass cannot be null");
        this.f3637j = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        a();
        super.replace(i5, i6, charSequence, i7, i8);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i5) {
        super.append(charSequence, obj, i5);
        return this;
    }
}
