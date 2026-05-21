package O;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class A0 extends z0 {
    public A0(F0 f02, WindowInsets windowInsets) {
        super(f02, windowInsets);
    }

    @Override // O.D0
    public F0 a() {
        return F0.g(null, this.f1983c.consumeDisplayCutout());
    }

    @Override // O.D0
    public C0168i e() {
        DisplayCutout displayCutout = this.f1983c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0168i(displayCutout);
    }

    @Override // O.D0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A0)) {
            return false;
        }
        A0 a02 = (A0) obj;
        return Objects.equals(this.f1983c, a02.f1983c) && Objects.equals(this.g, a02.g);
    }

    @Override // O.D0
    public int hashCode() {
        return this.f1983c.hashCode();
    }
}
