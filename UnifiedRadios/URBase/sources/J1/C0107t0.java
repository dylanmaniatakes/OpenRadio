package J1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: J1.t0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0107t0 implements InterfaceC0064e1 {

    /* renamed from: c, reason: collision with root package name */
    public final C0113v0 f1391c;

    public /* synthetic */ C0107t0(C0113v0 c0113v0) {
        this.f1391c = c0113v0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // J1.InterfaceC0064e1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r19, java.io.IOException r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0107t0.a(int, java.io.IOException, byte[]):void");
    }

    public void b(Bundle bundle, String str) {
        String string;
        C0113v0 c0113v0 = this.f1391c;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        if (c0113v0.b()) {
            return;
        }
        if (bundle.isEmpty()) {
            string = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        c0072h0.f1252z.h(string);
        c0113v0.f1421p.getClass();
        c0072h0.f1232A.b(System.currentTimeMillis());
    }

    public boolean c() {
        C0072h0 c0072h0 = this.f1391c.f1416j;
        C0113v0.i(c0072h0);
        return c0072h0.f1232A.a() > 0;
    }

    public boolean d() {
        if (!c()) {
            return false;
        }
        C0113v0 c0113v0 = this.f1391c;
        c0113v0.f1421p.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        return jCurrentTimeMillis - c0072h0.f1232A.a() > c0113v0.f1415i.r(null, H.f818i0);
    }
}
