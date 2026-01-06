package X2;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: i, reason: collision with root package name */
    public static final long f2855i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f2856j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2857a;

    /* renamed from: b, reason: collision with root package name */
    public final V1.e f2858b;

    /* renamed from: c, reason: collision with root package name */
    public final n f2859c;

    /* renamed from: d, reason: collision with root package name */
    public final FirebaseMessaging f2860d;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f2862f;
    public final x h;

    /* renamed from: e, reason: collision with root package name */
    public final q.b f2861e = new q.b();
    public boolean g = false;

    public z(FirebaseMessaging firebaseMessaging, V1.e eVar, x xVar, n nVar, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f2860d = firebaseMessaging;
        this.f2858b = eVar;
        this.h = xVar;
        this.f2859c = nVar;
        this.f2857a = context;
        this.f2862f = scheduledThreadPoolExecutor;
    }

    public static void a(N1.r rVar) throws IOException {
        try {
            AbstractC0930a.b(rVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e5) {
            e = e5;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e6);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e7) {
            e = e7;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    public final void b(String str) throws IOException {
        String strA = this.f2860d.a();
        n nVar = this.f2859c;
        nVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        a(nVar.g(nVar.q(strA, "/topics/" + str, bundle)));
    }

    public final void c(String str) throws IOException {
        String strA = this.f2860d.a();
        n nVar = this.f2859c;
        nVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", "/topics/" + str);
        bundle.putString("delete", "1");
        a(nVar.g(nVar.q(strA, "/topics/" + str, bundle)));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.z.d():boolean");
    }

    public final void e(long j5) {
        this.f2862f.schedule(new B(this, this.f2857a, this.f2858b, Math.min(Math.max(30L, 2 * j5), f2855i)), j5, TimeUnit.SECONDS);
        synchronized (this) {
            this.g = true;
        }
    }
}
