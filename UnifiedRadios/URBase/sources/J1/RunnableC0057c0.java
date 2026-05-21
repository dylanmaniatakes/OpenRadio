package J1;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* renamed from: J1.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0057c0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1157j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final URL f1158k;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f1159l;

    /* renamed from: m, reason: collision with root package name */
    public final String f1160m;
    public final Map n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f1161o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ B.u f1162p;

    public RunnableC0057c0(C0060d0 c0060d0, String str, URL url, byte[] bArr, Map map, InterfaceC0054b0 interfaceC0054b0) {
        this.f1162p = c0060d0;
        q1.E.f(str);
        q1.E.i(url);
        this.f1158k = url;
        this.f1159l = bArr;
        this.f1161o = interfaceC0054b0;
        this.f1160m = str;
        this.n = map;
    }

    public void a(int i5, IOException iOException, byte[] bArr, Map map) {
        C0104s0 c0104s0 = ((C0113v0) ((C0070g1) this.f1162p).f84c).f1418l;
        C0113v0.k(c0104s0);
        c0104s0.t(new RunnableC0067f1(this, i5, iOException, bArr, map));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x027e: MOVE (r11 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:139:0x027d */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x0281: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:140:0x0280 */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0249 A[Catch: all -> 0x024d, LOOP:3: B:121:0x0243->B:123:0x0249, LOOP_END, TryCatch #17 {all -> 0x024d, blocks: (B:120:0x0241, B:121:0x0243, B:123:0x0249, B:126:0x024f), top: B:185:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x024f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0170  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v27, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r7v22, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r7v25, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.RunnableC0057c0.run():void");
    }

    public RunnableC0057c0(C0070g1 c0070g1, String str, URL url, byte[] bArr, HashMap map, InterfaceC0064e1 interfaceC0064e1) {
        this.f1162p = c0070g1;
        q1.E.f(str);
        this.f1158k = url;
        this.f1159l = bArr;
        this.f1161o = interfaceC0064e1;
        this.f1160m = str;
        this.n = map;
    }
}
