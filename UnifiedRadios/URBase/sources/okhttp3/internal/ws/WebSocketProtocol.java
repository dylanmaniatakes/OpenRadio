package okhttp3.internal.ws;

import F3.i;
import J1.C;
import W3.C0196i;
import W3.l;
import W3.o;
import com.unified.ur1.SatelliteTracker.h;
import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String str) {
        i.f(str, "key");
        o oVar = o.f2649m;
        return C.i(str.concat(ACCEPT_MAGIC)).b("SHA-1").a();
    }

    public final String closeCodeExceptionMessage(int i5) {
        if (i5 < 1000 || i5 >= 5000) {
            return h.a(i5, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i5 || i5 >= 1007) && (1015 > i5 || i5 >= 3000)) {
            return null;
        }
        return AbstractC0535a.j("Code ", i5, " is reserved and may not be used.");
    }

    public final void toggleMask(C0196i c0196i, byte[] bArr) {
        long j5;
        i.f(c0196i, "cursor");
        i.f(bArr, "key");
        int length = bArr.length;
        int i5 = 0;
        do {
            byte[] bArr2 = c0196i.n;
            int i6 = c0196i.f2641o;
            int i7 = c0196i.f2642p;
            if (bArr2 != null) {
                while (i6 < i7) {
                    int i8 = i5 % length;
                    bArr2[i6] = (byte) (bArr2[i6] ^ bArr[i8]);
                    i6++;
                    i5 = i8 + 1;
                }
            }
            long j6 = c0196i.f2640m;
            l lVar = c0196i.f2637j;
            i.c(lVar);
            if (j6 == lVar.f2648k) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j5 = c0196i.f2640m;
        } while (c0196i.c(j5 == -1 ? 0L : j5 + (c0196i.f2642p - c0196i.f2641o)) != -1);
    }

    public final void validateCloseCode(int i5) {
        String strCloseCodeExceptionMessage = closeCodeExceptionMessage(i5);
        if (strCloseCodeExceptionMessage == null) {
            return;
        }
        i.c(strCloseCodeExceptionMessage);
        throw new IllegalArgumentException(strCloseCodeExceptionMessage.toString());
    }
}
