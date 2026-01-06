package B2;

import J1.InterfaceC0061d1;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0294a0;
import com.google.android.gms.internal.measurement.C0304c0;
import com.google.android.gms.internal.measurement.C0319f0;
import com.google.android.gms.internal.measurement.C0329h0;
import com.google.android.gms.internal.measurement.C0334i0;
import com.google.android.gms.internal.measurement.C0354m0;
import com.google.android.gms.internal.measurement.H;
import com.google.android.gms.internal.measurement.Y;
import com.google.android.gms.internal.measurement.Z;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public final class a implements InterfaceC0061d1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0354m0 f121a;

    public a(C0354m0 c0354m0) {
        this.f121a = c0354m0;
    }

    @Override // J1.InterfaceC0061d1
    public final String a() {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0319f0(c0354m0, h, 1));
        return (String) H.c(h.b(50L), String.class);
    }

    @Override // J1.InterfaceC0061d1
    public final String b() {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0319f0(c0354m0, h, 4));
        return (String) H.c(h.b(500L), String.class);
    }

    @Override // J1.InterfaceC0061d1
    public final void c(String str) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        c0354m0.b(new C0304c0(c0354m0, str, 0));
    }

    @Override // J1.InterfaceC0061d1
    public final void d(String str, String str2, Bundle bundle) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        c0354m0.b(new C0294a0(c0354m0, str, str2, bundle, 0));
    }

    @Override // J1.InterfaceC0061d1
    public final List e(String str, String str2) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0294a0(c0354m0, str, str2, h, 1));
        List list = (List) H.c(h.b(DeviceOrientationRequest.OUTPUT_PERIOD_FAST), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // J1.InterfaceC0061d1
    public final Map f(String str, String str2, boolean z4) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new Y(c0354m0, str, str2, z4, h));
        Bundle bundleB = h.b(DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
        if (bundleB == null || bundleB.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleB.size());
        for (String str3 : bundleB.keySet()) {
            Object obj = bundleB.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    @Override // J1.InterfaceC0061d1
    public final void g(String str) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        c0354m0.b(new C0304c0(c0354m0, str, 1));
    }

    @Override // J1.InterfaceC0061d1
    public final int h(String str) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0329h0(c0354m0, str, h));
        Integer num = (Integer) H.c(h.b(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // J1.InterfaceC0061d1
    public final void i(Bundle bundle) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        c0354m0.b(new Z(c0354m0, bundle, 0));
    }

    @Override // J1.InterfaceC0061d1
    public final void j(String str, String str2, Bundle bundle) {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        c0354m0.b(new C0334i0(c0354m0, str, str2, bundle));
    }

    @Override // J1.InterfaceC0061d1
    public final String k() {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0319f0(c0354m0, h, 0));
        return (String) H.c(h.b(500L), String.class);
    }

    @Override // J1.InterfaceC0061d1
    public final long zzb() {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0319f0(c0354m0, h, 2));
        Long l5 = (Long) H.c(h.b(500L), Long.class);
        if (l5 != null) {
            return l5.longValue();
        }
        long jNanoTime = System.nanoTime();
        c0354m0.f4981b.getClass();
        long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
        int i5 = c0354m0.f4984e + 1;
        c0354m0.f4984e = i5;
        return jNextLong + i5;
    }

    @Override // J1.InterfaceC0061d1
    public final String zzj() {
        C0354m0 c0354m0 = this.f121a;
        c0354m0.getClass();
        H h = new H();
        c0354m0.b(new C0319f0(c0354m0, h, 3));
        return (String) H.c(h.b(500L), String.class);
    }
}
