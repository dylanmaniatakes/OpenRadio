package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
final class Java8FileDescriptorSocket extends ConscryptFileDescriptorSocket {
    private BiFunction<SSLSocket, List<String>, String> selector;

    public Java8FileDescriptorSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        super(sSLParametersImpl);
    }

    private static ApplicationProtocolSelector toApplicationProtocolSelector(final BiFunction<SSLSocket, List<String>, String> biFunction) {
        if (biFunction == null) {
            return null;
        }
        return new ApplicationProtocolSelector() { // from class: org.conscrypt.Java8FileDescriptorSocket.1
            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLEngine sSLEngine, List<String> list) {
                throw new UnsupportedOperationException();
            }

            @Override // org.conscrypt.ApplicationProtocolSelector
            public String selectApplicationProtocol(SSLSocket sSLSocket, List<String> list) {
                return (String) biFunction.apply(sSLSocket, list);
            }
        };
    }

    @Override // javax.net.ssl.SSLSocket
    public BiFunction<SSLSocket, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return this.selector;
    }

    @Override // javax.net.ssl.SSLSocket
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLSocket, List<String>, String> biFunction) {
        this.selector = biFunction;
        setApplicationProtocolSelector(toApplicationProtocolSelector(biFunction));
    }

    public Java8FileDescriptorSocket(String str, int i5, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i5, sSLParametersImpl);
    }

    public Java8FileDescriptorSocket(InetAddress inetAddress, int i5, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i5, sSLParametersImpl);
    }

    public Java8FileDescriptorSocket(String str, int i5, InetAddress inetAddress, int i6, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(str, i5, inetAddress, i6, sSLParametersImpl);
    }

    public Java8FileDescriptorSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(inetAddress, i5, inetAddress2, i6, sSLParametersImpl);
    }

    public Java8FileDescriptorSocket(Socket socket, String str, int i5, boolean z4, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(socket, str, i5, z4, sSLParametersImpl);
    }
}
