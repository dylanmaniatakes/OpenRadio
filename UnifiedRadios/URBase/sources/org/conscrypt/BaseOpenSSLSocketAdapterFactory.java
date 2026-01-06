package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public abstract class BaseOpenSSLSocketAdapterFactory extends SSLSocketFactory {
    private final OpenSSLSocketFactoryImpl delegate;

    public BaseOpenSSLSocketAdapterFactory(OpenSSLSocketFactoryImpl openSSLSocketFactoryImpl) {
        this.delegate = openSSLSocketFactoryImpl;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public abstract Socket wrap(OpenSSLSocketImpl openSSLSocketImpl) throws IOException;

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i5) throws IOException {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(str, i5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i5, InetAddress inetAddress, int i6) throws IOException {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(str, i5, inetAddress, i6));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i5) throws IOException {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(inetAddress, i5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i5, InetAddress inetAddress2, int i6) throws IOException {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(inetAddress, i5, inetAddress2, i6));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i5, boolean z4) throws IOException {
        return wrap((OpenSSLSocketImpl) this.delegate.createSocket(socket, str, i5, z4));
    }
}
