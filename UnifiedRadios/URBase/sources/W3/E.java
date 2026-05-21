package W3;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: classes.dex */
public final class E extends C0194g {

    /* renamed from: a, reason: collision with root package name */
    public final Socket f2627a;

    public E(Socket socket) {
        F3.i.f(socket, "socket");
        this.f2627a = socket;
    }

    @Override // W3.C0194g
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // W3.C0194g
    public final void timedOut() throws IOException {
        Socket socket = this.f2627a;
        try {
            socket.close();
        } catch (AssertionError e5) {
            if (!AbstractC0189b.f(e5)) {
                throw e5;
            }
            v.f2665a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e5);
        } catch (Exception e6) {
            v.f2665a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e6);
        }
    }
}
