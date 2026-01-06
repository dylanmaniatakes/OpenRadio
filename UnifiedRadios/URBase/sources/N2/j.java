package n2;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class j implements InterfaceC0804c {

    /* renamed from: a, reason: collision with root package name */
    public final float f8827a;

    public j(float f5) {
        this.f8827a = f5;
    }

    @Override // n2.InterfaceC0804c
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f8827a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f8827a == ((j) obj).f8827a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8827a)});
    }
}
