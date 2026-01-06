package org.conscrypt;

import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public interface SSLClientSessionCache {
    byte[] getSessionData(String str, int i5);

    void putSessionData(SSLSession sSLSession, byte[] bArr);
}
