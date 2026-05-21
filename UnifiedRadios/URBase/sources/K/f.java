package K;

import N3.C0131e;
import android.os.OutcomeReceiver;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.concurrent.atomic.AtomicBoolean;
import w3.InterfaceC0936d;

/* loaded from: classes.dex */
public final class f extends AtomicBoolean implements OutcomeReceiver {

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0936d f1486j;

    public f(C0131e c0131e) {
        super(false);
        this.f1486j = c0131e;
    }

    public final void onError(Throwable th) {
        F3.i.f(th, "error");
        if (compareAndSet(false, true)) {
            this.f1486j.resumeWith(AbstractC0399v1.c(th));
        }
    }

    public final void onResult(Object obj) {
        if (compareAndSet(false, true)) {
            this.f1486j.resumeWith(obj);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
