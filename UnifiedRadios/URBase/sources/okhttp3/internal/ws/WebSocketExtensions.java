package okhttp3.internal.ws;

import F3.f;
import F3.i;

/* loaded from: classes.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00c4 A[PHI: r7 r9
          0x00c4: PHI (r7v6 java.lang.Integer) = (r7v4 java.lang.Integer), (r7v4 java.lang.Integer), (r7v8 java.lang.Integer) binds: [B:52:0x00f6, B:49:0x00ed, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]
          0x00c4: PHI (r9v9 java.lang.Integer) = (r9v4 java.lang.Integer), (r9v6 java.lang.Integer), (r9v4 java.lang.Integer) binds: [B:52:0x00f6, B:49:0x00ed, B:32:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.internal.ws.WebSocketExtensions parse(okhttp3.Headers r21) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 275
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.Companion.parse(okhttp3.Headers):okhttp3.internal.ws.WebSocketExtensions");
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z4, Integer num, boolean z5, Integer num2, boolean z6, boolean z7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = webSocketExtensions.perMessageDeflate;
        }
        if ((i5 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i5 & 4) != 0) {
            z5 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z8 = z5;
        if ((i5 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i5 & 16) != 0) {
            z6 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z9 = z6;
        if ((i5 & 32) != 0) {
            z7 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z4, num3, z8, num4, z9, z7);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z4, Integer num, boolean z5, Integer num2, boolean z6, boolean z7) {
        return new WebSocketExtensions(z4, num, z5, num2, z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && i.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && i.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z4 = this.perMessageDeflate;
        ?? r02 = z4;
        if (z4) {
            r02 = 1;
        }
        int i5 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i5 + (num == null ? 0 : num.hashCode())) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i6 = r22;
        if (r22 != 0) {
            i6 = 1;
        }
        int i7 = (iHashCode + i6) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i8 = r23;
        if (r23 != 0) {
            i8 = 1;
        }
        int i9 = (iHashCode2 + i8) * 31;
        boolean z5 = this.unknownValues;
        return i9 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean z4) {
        return z4 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z4, Integer num, boolean z5, Integer num2, boolean z6, boolean z7) {
        this.perMessageDeflate = z4;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z5;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z6;
        this.unknownValues = z7;
    }

    public /* synthetic */ WebSocketExtensions(boolean z4, Integer num, boolean z5, Integer num2, boolean z6, boolean z7, int i5, f fVar) {
        this((i5 & 1) != 0 ? false : z4, (i5 & 2) != 0 ? null : num, (i5 & 4) != 0 ? false : z5, (i5 & 8) == 0 ? num2 : null, (i5 & 16) != 0 ? false : z6, (i5 & 32) != 0 ? false : z7);
    }
}
