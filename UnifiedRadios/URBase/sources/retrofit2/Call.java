package retrofit2;

import W3.I;
import java.io.IOException;
import okhttp3.Request;

/* loaded from: classes.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    I timeout();
}
