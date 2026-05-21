package p1;

import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* renamed from: p1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0831g extends A1.f {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i5 = message.what;
        if (i5 != 1) {
            if (i5 != 2) {
                Log.wtf("BasePendingResult", com.unified.ur1.SatelliteTracker.h.a(i5, "Don't know how to handle message: "), new Exception());
                return;
            } else {
                ((BasePendingResult) message.obj).b(Status.f4637o);
                return;
            }
        }
        Pair pair = (Pair) message.obj;
        com.unified.ur1.SatelliteTracker.h.p(pair.first);
        try {
            throw null;
        } catch (RuntimeException e5) {
            int i6 = BasePendingResult.g;
            throw e5;
        }
    }
}
