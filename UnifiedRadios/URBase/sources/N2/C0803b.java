package n2;

import android.graphics.RectF;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

/* renamed from: n2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0803b implements InterfaceC0804c {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0804c f8778a;

    /* renamed from: b, reason: collision with root package name */
    public final float f8779b;

    public C0803b(float f5, InterfaceC0804c interfaceC0804c) {
        while (interfaceC0804c instanceof C0803b) {
            interfaceC0804c = ((C0803b) interfaceC0804c).f8778a;
            f5 += ((C0803b) interfaceC0804c).f8779b;
        }
        this.f8778a = interfaceC0804c;
        this.f8779b = f5;
    }

    @Override // n2.InterfaceC0804c
    public final float a(RectF rectF) {
        return Math.max(BitmapDescriptorFactory.HUE_RED, this.f8778a.a(rectF) + this.f8779b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0803b)) {
            return false;
        }
        C0803b c0803b = (C0803b) obj;
        return this.f8778a.equals(c0803b.f8778a) && this.f8779b == c0803b.f8779b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8778a, Float.valueOf(this.f8779b)});
    }
}
