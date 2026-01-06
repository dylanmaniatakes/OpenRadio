package org.conscrypt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ClientSessionContext extends AbstractSessionContext {
    private SSLClientSessionCache persistentCache;
    private final Map<HostAndPort, List<NativeSslSession>> sessionsByHostAndPort;

    public static final class HostAndPort {
        final String host;
        final int port;

        public HostAndPort(String str, int i5) {
            this.host = str;
            this.port = i5;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof HostAndPort)) {
                return false;
            }
            HostAndPort hostAndPort = (HostAndPort) obj;
            return this.host.equals(hostAndPort.host) && this.port == hostAndPort.port;
        }

        public int hashCode() {
            return (this.host.hashCode() * 31) + this.port;
        }
    }

    public ClientSessionContext() {
        super(10);
        this.sessionsByHostAndPort = new HashMap();
    }

    private NativeSslSession getSession(String str, int i5) {
        NativeSslSession nativeSslSession;
        byte[] sessionData;
        NativeSslSession nativeSslSessionNewInstance;
        if (str == null) {
            return null;
        }
        HostAndPort hostAndPort = new HostAndPort(str, i5);
        synchronized (this.sessionsByHostAndPort) {
            try {
                List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
                nativeSslSession = (list == null || list.size() <= 0) ? null : list.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (nativeSslSession != null && nativeSslSession.isValid()) {
            return nativeSslSession;
        }
        SSLClientSessionCache sSLClientSessionCache = this.persistentCache;
        if (sSLClientSessionCache == null || (sessionData = sSLClientSessionCache.getSessionData(str, i5)) == null || (nativeSslSessionNewInstance = NativeSslSession.newInstance(this, sessionData, str, i5)) == null || !nativeSslSessionNewInstance.isValid()) {
            return null;
        }
        putSession(hostAndPort, nativeSslSessionNewInstance);
        return nativeSslSessionNewInstance;
    }

    private void putSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            try {
                List<NativeSslSession> arrayList = this.sessionsByHostAndPort.get(hostAndPort);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.sessionsByHostAndPort.put(hostAndPort, arrayList);
                }
                if (arrayList.size() > 0 && arrayList.get(0).isSingleUse() != nativeSslSession.isSingleUse()) {
                    while (!arrayList.isEmpty()) {
                        removeSession(arrayList.get(0));
                    }
                    this.sessionsByHostAndPort.put(hostAndPort, arrayList);
                }
                arrayList.add(nativeSslSession);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void removeSession(HostAndPort hostAndPort, NativeSslSession nativeSslSession) {
        synchronized (this.sessionsByHostAndPort) {
            try {
                List<NativeSslSession> list = this.sessionsByHostAndPort.get(hostAndPort);
                if (list != null) {
                    list.remove(nativeSslSession);
                    if (list.isEmpty()) {
                        this.sessionsByHostAndPort.remove(hostAndPort);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized NativeSslSession getCachedSession(String str, int i5, SSLParametersImpl sSLParametersImpl) {
        if (str == null) {
            return null;
        }
        NativeSslSession session = getSession(str, i5);
        if (session == null) {
            return null;
        }
        String protocol = session.getProtocol();
        for (String str2 : sSLParametersImpl.enabledProtocols) {
            if (protocol.equals(str2)) {
                String cipherSuite = session.getCipherSuite();
                for (String str3 : sSLParametersImpl.getEnabledCipherSuites()) {
                    if (cipherSuite.equals(str3)) {
                        if (session.isSingleUse()) {
                            removeSession(session);
                        }
                        return session;
                    }
                }
                return null;
            }
        }
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    public NativeSslSession getSessionFromPersistentCache(byte[] bArr) {
        return null;
    }

    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeAddSession(NativeSslSession nativeSslSession) {
        byte[] bytes;
        String peerHost = nativeSslSession.getPeerHost();
        int peerPort = nativeSslSession.getPeerPort();
        if (peerHost == null) {
            return;
        }
        putSession(new HostAndPort(peerHost, peerPort), nativeSslSession);
        if (this.persistentCache == null || nativeSslSession.isSingleUse() || (bytes = nativeSslSession.toBytes()) == null) {
            return;
        }
        this.persistentCache.putSessionData(nativeSslSession.toSSLSession(), bytes);
    }

    @Override // org.conscrypt.AbstractSessionContext
    public void onBeforeRemoveSession(NativeSslSession nativeSslSession) {
        String peerHost = nativeSslSession.getPeerHost();
        if (peerHost == null) {
            return;
        }
        removeSession(new HostAndPort(peerHost, nativeSslSession.getPeerPort()), nativeSslSession);
    }

    public void setPersistentCache(SSLClientSessionCache sSLClientSessionCache) {
        this.persistentCache = sSLClientSessionCache;
    }

    public int size() {
        int size;
        synchronized (this.sessionsByHostAndPort) {
            try {
                Iterator<List<NativeSslSession>> it = this.sessionsByHostAndPort.values().iterator();
                size = 0;
                while (it.hasNext()) {
                    size += it.next().size();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }
}
