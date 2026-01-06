package Y0;

import android.content.Context;
import d1.InterfaceC0427b;
import e1.C0442j;
import e1.C0444l;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: e, reason: collision with root package name */
    public static volatile k f2928e;

    /* renamed from: a, reason: collision with root package name */
    public final h1.d f2929a;

    /* renamed from: b, reason: collision with root package name */
    public final h1.d f2930b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0427b f2931c;

    /* renamed from: d, reason: collision with root package name */
    public final C0442j f2932d;

    public q(h1.d dVar, h1.d dVar2, InterfaceC0427b interfaceC0427b, C0442j c0442j, C0444l c0444l) {
        this.f2929a = dVar;
        this.f2930b = dVar2;
        this.f2931c = interfaceC0427b;
        this.f2932d = c0442j;
        c0444l.getClass();
        c0444l.f6190a.execute(new C0.e(13, c0444l));
    }

    public static q a() {
        k kVar = f2928e;
        if (kVar != null) {
            return (q) kVar.f2920o.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f2928e == null) {
            synchronized (q.class) {
                try {
                    if (f2928e == null) {
                        j jVar = new j();
                        context.getClass();
                        jVar.f2915a = context;
                        f2928e = jVar.a();
                    }
                } finally {
                }
            }
        }
    }

    public final p c(l lVar) {
        Set setSingleton;
        byte[] bytes;
        if (lVar instanceof l) {
            ((W0.a) lVar).getClass();
            setSingleton = Collections.unmodifiableSet(W0.a.f2573d);
        } else {
            setSingleton = Collections.singleton(new V0.c("proto"));
        }
        L0.m mVarA = i.a();
        lVar.getClass();
        mVarA.f1556d = "cct";
        W0.a aVar = (W0.a) lVar;
        String str = aVar.f2576a;
        String str2 = aVar.f2577b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName("UTF-8"));
        }
        mVarA.f1557e = bytes;
        return new p(setSingleton, mVarA.d(), this);
    }
}
