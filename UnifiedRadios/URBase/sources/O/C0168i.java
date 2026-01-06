package O;

import android.view.DisplayCutout;

/* renamed from: O.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0168i {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f1933a;

    public C0168i(DisplayCutout displayCutout) {
        this.f1933a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0168i.class != obj.getClass()) {
            return false;
        }
        return N.b.a(this.f1933a, ((C0168i) obj).f1933a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f1933a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f1933a + "}";
    }
}
