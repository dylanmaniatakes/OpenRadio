package m1;

import N1.r;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k3.RunnableC0691i0;
import m3.C0777m;

/* renamed from: m1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0761b {
    public static int h;

    /* renamed from: i, reason: collision with root package name */
    public static PendingIntent f8511i;

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f8512j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: b, reason: collision with root package name */
    public final Context f8514b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.material.datepicker.m f8515c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f8516d;

    /* renamed from: f, reason: collision with root package name */
    public Messenger f8518f;
    public g g;

    /* renamed from: a, reason: collision with root package name */
    public final q.k f8513a = new q.k();

    /* renamed from: e, reason: collision with root package name */
    public final Messenger f8517e = new Messenger(new e(this, Looper.getMainLooper()));

    public C0761b(Context context) {
        this.f8514b = context;
        this.f8515c = new com.google.android.material.datepicker.m(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f8516d = scheduledThreadPoolExecutor;
    }

    public final r a(Bundle bundle) throws RemoteException {
        String string;
        synchronized (C0761b.class) {
            int i5 = h;
            h = i5 + 1;
            string = Integer.toString(i5);
        }
        N1.k kVar = new N1.k();
        synchronized (this.f8513a) {
            this.f8513a.put(string, kVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f8515c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        Context context = this.f8514b;
        synchronized (C0761b.class) {
            try {
                if (f8511i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    f8511i = PendingIntent.getBroadcast(context, 0, intent2, B1.a.f120a);
                }
                intent.putExtra("app", f8511i);
            } catch (Throwable th) {
                throw th;
            }
        }
        intent.putExtra("kid", "|ID|" + string + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f8517e);
        if (this.f8518f != null || this.g != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f8518f;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    Messenger messenger2 = this.g.f8525j;
                    messenger2.getClass();
                    messenger2.send(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
        } else if (this.f8515c.b() == 2) {
            this.f8514b.sendBroadcast(intent);
        } else {
            this.f8514b.startService(intent);
        }
        kVar.f1789a.h(h.f8527l, new C0777m(this, string, this.f8516d.schedule(new RunnableC0691i0(6, kVar), 30L, TimeUnit.SECONDS)));
        return kVar.f1789a;
    }

    public final void b(Bundle bundle, String str) {
        synchronized (this.f8513a) {
            try {
                N1.k kVar = (N1.k) this.f8513a.remove(str);
                if (kVar != null) {
                    kVar.a(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
