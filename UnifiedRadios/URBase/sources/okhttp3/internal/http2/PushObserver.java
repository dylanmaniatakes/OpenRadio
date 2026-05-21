package okhttp3.internal.http2;

import F3.i;
import W3.n;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public interface PushObserver {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static final class PushObserverCancel implements PushObserver {
            @Override // okhttp3.internal.http2.PushObserver
            public boolean onData(int i5, n nVar, int i6, boolean z4) throws IOException {
                i.f(nVar, "source");
                nVar.i(i6);
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onHeaders(int i5, List<Header> list, boolean z4) {
                i.f(list, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public boolean onRequest(int i5, List<Header> list) {
                i.f(list, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.PushObserver
            public void onReset(int i5, ErrorCode errorCode) {
                i.f(errorCode, "errorCode");
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i5, n nVar, int i6, boolean z4) throws IOException;

    boolean onHeaders(int i5, List<Header> list, boolean z4);

    boolean onRequest(int i5, List<Header> list);

    void onReset(int i5, ErrorCode errorCode);
}
