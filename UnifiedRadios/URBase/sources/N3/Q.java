package N3;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class Q extends CancellationException {

    /* renamed from: j, reason: collision with root package name */
    public final transient P f1824j;

    public Q(String str, Throwable th, P p4) {
        super(str);
        this.f1824j = p4;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Q) {
                Q q4 = (Q) obj;
                if (!F3.i.a(q4.getMessage(), getMessage()) || !F3.i.a(q4.f1824j, this.f1824j) || !F3.i.a(q4.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        F3.i.c(message);
        int iHashCode = (this.f1824j.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f1824j;
    }
}
