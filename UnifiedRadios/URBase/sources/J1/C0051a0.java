package J1;

import android.os.Bundle;

/* renamed from: J1.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0051a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1099a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f1100b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1101c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1102d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1103e;

    public C0051a0(long j5, Bundle bundle, String str, String str2) {
        this.f1101c = str;
        this.f1102d = str2;
        this.f1103e = bundle;
        this.f1100b = j5;
    }

    public static C0051a0 c(C0112v c0112v) {
        Bundle bundleA = c0112v.f1399k.a();
        return new C0051a0(c0112v.f1401m, bundleA, c0112v.f1398j, c0112v.f1400l);
    }

    public C0112v a() {
        C0109u c0109u = new C0109u(new Bundle((Bundle) this.f1103e));
        return new C0112v((String) this.f1101c, c0109u, (String) this.f1102d, this.f1100b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cd  */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.measurement.X0 b(com.google.android.gms.internal.measurement.X0 r20, java.lang.String r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0051a0.b(com.google.android.gms.internal.measurement.X0, java.lang.String):com.google.android.gms.internal.measurement.X0");
    }

    public String toString() {
        switch (this.f1099a) {
            case 0:
                return "origin=" + ((String) this.f1102d) + ",name=" + ((String) this.f1101c) + ",params=" + ((Bundle) this.f1103e).toString();
            default:
                return super.toString();
        }
    }
}
