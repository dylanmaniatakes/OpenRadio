package J1;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class O extends E {

    /* renamed from: e, reason: collision with root package name */
    public String f909e;

    /* renamed from: f, reason: collision with root package name */
    public String f910f;
    public int g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f911i;

    /* renamed from: j, reason: collision with root package name */
    public long f912j;

    /* renamed from: k, reason: collision with root package name */
    public final long f913k;

    /* renamed from: l, reason: collision with root package name */
    public final long f914l;

    /* renamed from: m, reason: collision with root package name */
    public List f915m;
    public String n;

    /* renamed from: o, reason: collision with root package name */
    public int f916o;

    /* renamed from: p, reason: collision with root package name */
    public String f917p;

    /* renamed from: q, reason: collision with root package name */
    public String f918q;

    /* renamed from: r, reason: collision with root package name */
    public String f919r;

    /* renamed from: s, reason: collision with root package name */
    public long f920s;

    /* renamed from: t, reason: collision with root package name */
    public String f921t;

    public O(C0113v0 c0113v0, long j5, long j6) {
        super(c0113v0);
        this.f920s = 0L;
        this.f921t = null;
        this.f913k = j5;
        this.f914l = j6;
    }

    @Override // J1.E
    public final boolean m() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|2|(1:4)(24:135|6|(1:10)(2:11|(1:13))|125|14|(4:16|(1:18)(1:20)|127|21)|26|(1:37)(4:30|(1:32)(1:33)|34|(1:36)(0))|38|(1:(2:41|(2:43|(2:45|(2:47|(2:49|(1:51)(1:52))(1:53))(1:54))(1:55))(1:56))(1:57))(1:58)|59|(1:61)|131|62|(1:64)(1:65)|66|(10:70|(1:72)(1:73)|74|(2:79|80)(3:133|77|80)|91|(1:93)(5:95|(0)(1:98)|(3:129|100|(1:102)(1:103))|(2:109|(1:111)(4:112|(3:115|(1:138)(1:139)|113)|137|118))(1:118)|(2:120|121)(2:122|123))|94|(0)|(0)(0)|(0)(0))|(3:84|(1:86)(1:87)|88)|91|(0)(0)|94|(0)|(0)(0)|(0)(0))|5|26|(2:28|37)(0)|38|(0)(0)|59|(0)|131|62|(0)(0)|66|(11:68|70|(0)(0)|74|(0)(0)|91|(0)(0)|94|(0)|(0)(0)|(0)(0))|(0)|91|(0)(0)|94|(0)|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0196, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b4, code lost:
    
        J1.C0113v0.k(r4);
        r4.h.c(J1.Z.q(r2), r5, "Fetching Google App Id failed with exception. appId");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d A[Catch: IllegalStateException -> 0x0196, TryCatch #3 {IllegalStateException -> 0x0196, blocks: (B:62:0x0159, B:66:0x0165, B:68:0x016d, B:70:0x0173, B:74:0x0182, B:77:0x018d, B:80:0x0193, B:73:0x017e, B:84:0x019a, B:86:0x01ab, B:88:0x01b0, B:87:0x01ae), top: B:131:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017e A[Catch: IllegalStateException -> 0x0196, TryCatch #3 {IllegalStateException -> 0x0196, blocks: (B:62:0x0159, B:66:0x0165, B:68:0x016d, B:70:0x0173, B:74:0x0182, B:77:0x018d, B:80:0x0193, B:73:0x017e, B:84:0x019a, B:86:0x01ab, B:88:0x01b0, B:87:0x01ae), top: B:131:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019a A[Catch: IllegalStateException -> 0x0196, TryCatch #3 {IllegalStateException -> 0x0196, blocks: (B:62:0x0159, B:66:0x0165, B:68:0x016d, B:70:0x0173, B:74:0x0182, B:77:0x018d, B:80:0x0193, B:73:0x017e, B:84:0x019a, B:86:0x01ab, B:88:0x01b0, B:87:0x01ae), top: B:131:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.O.n():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0285  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final J1.b2 o(java.lang.String r54) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.O.o(java.lang.String):J1.b2");
    }

    public final String p() {
        k();
        if (((C0113v0) this.f84c).f1415i.w(null, H.f838p1)) {
            return null;
        }
        return this.f918q;
    }

    public final String q() {
        k();
        q1.E.i(this.f909e);
        return this.f909e;
    }

    public final String r() {
        j();
        k();
        q1.E.i(this.f917p);
        return this.f917p;
    }

    public final void s() {
        String str;
        j();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        boolean zK = c0072h0.r().k(J0.ANALYTICS_STORAGE);
        Z z4 = c0113v0.f1417k;
        if (zK) {
            byte[] bArr = new byte[16];
            a2 a2Var = c0113v0.n;
            C0113v0.i(a2Var);
            a2Var.v().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            C0113v0.k(z4);
            z4.f1083o.a("Analytics Storage consent is not granted");
            str = null;
        }
        C0113v0.k(z4);
        z4.f1083o.a("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.f919r = str;
        c0113v0.f1421p.getClass();
        this.f920s = System.currentTimeMillis();
    }
}
