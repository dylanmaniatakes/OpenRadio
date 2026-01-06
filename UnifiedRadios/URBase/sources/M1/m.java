package m1;

import N1.r;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import i3.C0573b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import p1.o;
import q1.E;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import v1.ThreadFactoryC0920a;

/* loaded from: classes.dex */
public final class m implements Callback {
    public static m g;

    /* renamed from: c, reason: collision with root package name */
    public int f8544c;

    /* renamed from: d, reason: collision with root package name */
    public Object f8545d;

    /* renamed from: e, reason: collision with root package name */
    public Object f8546e;

    /* renamed from: f, reason: collision with root package name */
    public Object f8547f;

    public static synchronized m b(Context context) {
        try {
            if (g == null) {
                ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new ThreadFactoryC0920a("MessengerIpcClient")));
                m mVar = new m();
                mVar.f8547f = new k(mVar);
                mVar.f8544c = 1;
                mVar.f8546e = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                mVar.f8545d = context.getApplicationContext();
                g = mVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public L0.e a() {
        E.b(((o) this.f8545d) != null, "Must set register function");
        E.b(((o) this.f8546e) != null, "Must set unregister function");
        E.b(((androidx.emoji2.text.e) this.f8547f) != null, "Must set holder");
        p1.l lVar = (p1.l) ((androidx.emoji2.text.e) this.f8547f).f3602c;
        E.j(lVar, "Key must not be null");
        androidx.emoji2.text.e eVar = (androidx.emoji2.text.e) this.f8547f;
        int i5 = this.f8544c;
        C0573b c0573b = new C0573b();
        c0573b.f7297e = this;
        c0573b.f7296d = eVar;
        c0573b.f7295c = i5;
        return new L0.e(c0573b, 21, new L0.e(22, this, lVar, false));
    }

    public synchronized r c(l lVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(lVar.toString()));
            }
            if (!((k) this.f8547f).d(lVar)) {
                k kVar = new k(this);
                this.f8547f = kVar;
                kVar.d(lVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return lVar.f8540b.f1789a;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f8547f;
        unifiedInboxActivity.f5831c.setVisibility(8);
        Toast.makeText(unifiedInboxActivity, "Network error deleting messages", 0).show();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        boolean zIsSuccessful = response.isSuccessful();
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f8547f;
        if (!zIsSuccessful) {
            unifiedInboxActivity.f5831c.setVisibility(8);
            Toast.makeText(unifiedInboxActivity, "Failed to delete some messages", 0).show();
        } else {
            unifiedInboxActivity.f5835i.remove((Message) this.f8545d);
            unifiedInboxActivity.j((ArrayList) ((List) this.f8546e), this.f8544c + 1);
        }
    }
}
