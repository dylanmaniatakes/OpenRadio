package okhttp3.internal.http;

import okhttp3.Interceptor;

/* loaded from: classes.dex */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z4) {
        this.forWebSocket = z4;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i5) {
        if (i5 == 100) {
            return true;
        }
        return 102 <= i5 && i5 < 200;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6 A[Catch: IOException -> 0x00b9, TryCatch #0 {IOException -> 0x00b9, blocks: (B:39:0x00ab, B:41:0x00b4, B:44:0x00bc, B:46:0x00e6, B:48:0x00ef, B:49:0x00f2, B:50:0x0116, B:54:0x0121, B:56:0x0140, B:58:0x014e, B:65:0x0164, B:67:0x016a, B:71:0x0177, B:73:0x018c, B:74:0x0194, B:75:0x019e, B:60:0x0159, B:55:0x0130), top: B:83:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130 A[Catch: IOException -> 0x00b9, TryCatch #0 {IOException -> 0x00b9, blocks: (B:39:0x00ab, B:41:0x00b4, B:44:0x00bc, B:46:0x00e6, B:48:0x00ef, B:49:0x00f2, B:50:0x0116, B:54:0x0121, B:56:0x0140, B:58:0x014e, B:65:0x0164, B:67:0x016a, B:71:0x0177, B:73:0x018c, B:74:0x0194, B:75:0x019e, B:60:0x0159, B:55:0x0130), top: B:83:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0159 A[Catch: IOException -> 0x00b9, TryCatch #0 {IOException -> 0x00b9, blocks: (B:39:0x00ab, B:41:0x00b4, B:44:0x00bc, B:46:0x00e6, B:48:0x00ef, B:49:0x00f2, B:50:0x0116, B:54:0x0121, B:56:0x0140, B:58:0x014e, B:65:0x0164, B:67:0x016a, B:71:0x0177, B:73:0x018c, B:74:0x0194, B:75:0x019e, B:60:0x0159, B:55:0x0130), top: B:83:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0164 A[Catch: IOException -> 0x00b9, TryCatch #0 {IOException -> 0x00b9, blocks: (B:39:0x00ab, B:41:0x00b4, B:44:0x00bc, B:46:0x00e6, B:48:0x00ef, B:49:0x00f2, B:50:0x0116, B:54:0x0121, B:56:0x0140, B:58:0x014e, B:65:0x0164, B:67:0x016a, B:71:0x0177, B:73:0x018c, B:74:0x0194, B:75:0x019e, B:60:0x0159, B:55:0x0130), top: B:83:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016a A[Catch: IOException -> 0x00b9, TryCatch #0 {IOException -> 0x00b9, blocks: (B:39:0x00ab, B:41:0x00b4, B:44:0x00bc, B:46:0x00e6, B:48:0x00ef, B:49:0x00f2, B:50:0x0116, B:54:0x0121, B:56:0x0140, B:58:0x014e, B:65:0x0164, B:67:0x016a, B:71:0x0177, B:73:0x018c, B:74:0x0194, B:75:0x019e, B:60:0x0159, B:55:0x0130), top: B:83:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0177 A[Catch: IOException -> 0x00b9, TryCatch #0 {IOException -> 0x00b9, blocks: (B:39:0x00ab, B:41:0x00b4, B:44:0x00bc, B:46:0x00e6, B:48:0x00ef, B:49:0x00f2, B:50:0x0116, B:54:0x0121, B:56:0x0140, B:58:0x014e, B:65:0x0164, B:67:0x016a, B:71:0x0177, B:73:0x018c, B:74:0x0194, B:75:0x019e, B:60:0x0159, B:55:0x0130), top: B:83:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
