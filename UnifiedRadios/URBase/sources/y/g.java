package Y;

import android.text.InputFilter;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.AbstractC0409x1;

/* loaded from: classes.dex */
public final class g extends AbstractC0409x1 {

    /* renamed from: c, reason: collision with root package name */
    public final f f2879c;

    public g(TextView textView) {
        this.f2879c = new f(textView);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final InputFilter[] i(InputFilter[] inputFilterArr) {
        return (androidx.emoji2.text.j.f3607j != null) ^ true ? inputFilterArr : this.f2879c.i(inputFilterArr);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final void l(boolean z4) {
        if (!(androidx.emoji2.text.j.f3607j != null)) {
            return;
        }
        this.f2879c.l(z4);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final void m(boolean z4) {
        boolean z5 = !(androidx.emoji2.text.j.f3607j != null);
        f fVar = this.f2879c;
        if (z5) {
            fVar.f2878e = z4;
        } else {
            fVar.m(z4);
        }
    }
}
