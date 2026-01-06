package g2;

import android.widget.ImageButton;

/* loaded from: classes.dex */
public abstract class p extends ImageButton {

    /* renamed from: c, reason: collision with root package name */
    public int f6954c;

    public final void a(int i5, boolean z4) {
        super.setVisibility(i5);
        if (z4) {
            this.f6954c = i5;
        }
    }

    public final int getUserSetVisibility() {
        return this.f6954c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i5) {
        a(i5, true);
    }
}
