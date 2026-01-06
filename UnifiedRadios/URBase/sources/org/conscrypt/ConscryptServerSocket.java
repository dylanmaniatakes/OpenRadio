package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

/* loaded from: classes.dex */
final class ConscryptServerSocket extends SSLServerSocket {
    private boolean channelIdEnabled;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    public ConscryptServerSocket(SSLParametersImpl sSLParametersImpl) throws IOException {
        this.sslParameters = sSLParametersImpl;
    }

    @Override // java.net.ServerSocket
    public Socket accept() throws IOException {
        AbstractConscryptSocket abstractConscryptSocketCreateEngineSocket = this.useEngineSocket ? Platform.createEngineSocket(this.sslParameters) : Platform.createFileDescriptorSocket(this.sslParameters);
        abstractConscryptSocketCreateEngineSocket.setChannelIdEnabled(this.channelIdEnabled);
        implAccept(abstractConscryptSocketCreateEngineSocket);
        return abstractConscryptSocketCreateEngineSocket;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    public boolean isChannelIdEnabled() {
        return this.channelIdEnabled;
    }

    public void setChannelIdEnabled(boolean z4) {
        this.channelIdEnabled = z4;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setEnableSessionCreation(boolean z4) {
        this.sslParameters.setEnableSessionCreation(z4);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setNeedClientAuth(boolean z4) {
        this.sslParameters.setNeedClientAuth(z4);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setUseClientMode(boolean z4) {
        this.sslParameters.setUseClientMode(z4);
    }

    public ConscryptServerSocket setUseEngineSocket(boolean z4) {
        this.useEngineSocket = z4;
        return this;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public void setWantClientAuth(boolean z4) {
        this.sslParameters.setWantClientAuth(z4);
    }

    public ConscryptServerSocket(int i5, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(i5);
        this.sslParameters = sSLParametersImpl;
    }

    public ConscryptServerSocket(int i5, int i6, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(i5, i6);
        this.sslParameters = sSLParametersImpl;
    }

    public ConscryptServerSocket(int i5, int i6, InetAddress inetAddress, SSLParametersImpl sSLParametersImpl) throws IOException {
        super(i5, i6, inetAddress);
        this.sslParameters = sSLParametersImpl;
    }
}
