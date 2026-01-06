package okhttp3;

import F3.f;
import F3.i;
import java.io.IOException;

/* loaded from: classes.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final Companion Companion = new Companion(null);
    private final String protocol;

    public static final class Companion {
        private Companion() {
        }

        public final Protocol get(String str) throws IOException {
            i.f(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!str.equals(protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!str.equals(protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!str.equals(protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!str.equals(protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!str.equals(protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!str.equals(protocol.protocol)) {
                                    throw new IOException("Unexpected protocol: ".concat(str));
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return Companion.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
