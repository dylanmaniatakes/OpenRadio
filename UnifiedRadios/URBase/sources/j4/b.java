package j4;

import android.os.Handler;
import android.os.Message;
import android.view.View;

/* loaded from: classes.dex */
public final class b extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public View f7623a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        View view;
        if (message.what == 0 && (view = this.f7623a) != null) {
            view.invalidate();
        }
    }
}
