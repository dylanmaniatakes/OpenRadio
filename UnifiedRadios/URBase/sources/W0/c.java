package W0;

import X0.h;
import Z0.f;
import android.content.Context;
import android.net.ConnectivityManager;
import f3.C0519j;
import h1.d;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final C0519j f2581a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f2582b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f2583c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f2584d;

    /* renamed from: e, reason: collision with root package name */
    public final d f2585e;

    /* renamed from: f, reason: collision with root package name */
    public final d f2586f;
    public final int g;

    public c(Context context, d dVar, d dVar2) {
        L2.d dVar3 = new L2.d();
        h.f2710a.a(dVar3);
        dVar3.f1619d = true;
        this.f2581a = new C0519j(7, dVar3);
        this.f2583c = context;
        this.f2582b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f2584d = b(a.f2572c);
        this.f2585e = dVar2;
        this.f2586f = dVar;
        this.g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e5) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.s("Invalid url: ", str), e5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final Y0.h a(Y0.h r7) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.c.a(Y0.h):Y0.h");
    }
}
