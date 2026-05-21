package P;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f2042a;

    /* renamed from: b, reason: collision with root package name */
    public final j f2043b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2044c;

    public a(int i5, j jVar, int i6) {
        this.f2042a = i5;
        this.f2043b = jVar;
        this.f2044c = i6;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2042a);
        this.f2043b.f2058a.performAction(this.f2044c, bundle);
    }
}
