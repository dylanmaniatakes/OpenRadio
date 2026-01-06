package okhttp3;

import E3.a;
import F3.j;
import java.security.cert.Certificate;
import java.util.List;

/* loaded from: classes.dex */
public final class Handshake$Companion$get$1 extends j implements a {
    final /* synthetic */ List<Certificate> $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Handshake$Companion$get$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // E3.a
    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
