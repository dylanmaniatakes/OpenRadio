package org.conscrypt;

import javax.crypto.ShortBufferException;

/* loaded from: classes.dex */
final class ShortBufferWithoutStackTraceException extends ShortBufferException {
    private static final long serialVersionUID = 676150236007842683L;

    public ShortBufferWithoutStackTraceException() {
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public ShortBufferWithoutStackTraceException(String str) {
        super(str);
    }
}
