package okhttp3.internal.ws;

import J1.C;
import W3.o;

/* loaded from: classes.dex */
public final class MessageDeflaterKt {
    private static final o EMPTY_DEFLATE_BLOCK;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        o oVar = o.f2649m;
        EMPTY_DEFLATE_BLOCK = C.h("000000ffff");
    }
}
