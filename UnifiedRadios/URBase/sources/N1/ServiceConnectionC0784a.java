package n1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import q1.E;

/* renamed from: n1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ServiceConnectionC0784a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8725a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f8726b = new LinkedBlockingQueue();

    public final IBinder a(TimeUnit timeUnit) throws TimeoutException {
        E.h("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f8725a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f8725a = true;
        IBinder iBinder = (IBinder) this.f8726b.poll(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f8726b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
