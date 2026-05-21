package okhttp3;

import W3.o;

/* loaded from: classes.dex */
public interface WebSocket {

    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i5, String str);

    long queueSize();

    Request request();

    boolean send(o oVar);

    boolean send(String str);
}
