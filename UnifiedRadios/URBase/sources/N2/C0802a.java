package n2;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: n2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0802a implements InterfaceC0804c {

    /* renamed from: a, reason: collision with root package name */
    public final float f8777a;

    public C0802a(float f5) {
        this.f8777a = f5;
    }

    @Override // n2.InterfaceC0804c
    public final float a(RectF rectF) {
        return this.f8777a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0802a) && this.f8777a == ((C0802a) obj).f8777a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8777a)});
    }
}
