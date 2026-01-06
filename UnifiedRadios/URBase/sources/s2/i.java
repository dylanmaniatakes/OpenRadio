package s2;

import android.text.Editable;

/* loaded from: classes.dex */
public final class i extends g2.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f9604c;

    public i(l lVar) {
        this.f9604c = lVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f9604c.b().a();
    }

    @Override // g2.l, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        this.f9604c.b().b();
    }
}
