package okhttp3;

import F3.i;
import W3.o;

/* loaded from: classes.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i5, String str) {
        i.f(webSocket, "webSocket");
        i.f(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i5, String str) {
        i.f(webSocket, "webSocket");
        i.f(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        i.f(webSocket, "webSocket");
        i.f(th, "t");
    }

    public void onMessage(WebSocket webSocket, o oVar) {
        i.f(webSocket, "webSocket");
        i.f(oVar, "bytes");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        i.f(webSocket, "webSocket");
        i.f(response, "response");
    }

    public void onMessage(WebSocket webSocket, String str) {
        i.f(webSocket, "webSocket");
        i.f(str, "text");
    }
}
