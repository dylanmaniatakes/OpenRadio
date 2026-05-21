package X2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import i0.ExecutorC0566c;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f2806c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static F f2807d;

    /* renamed from: a, reason: collision with root package name */
    public final Object f2808a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2809b;

    public j(ExecutorService executorService) {
        this.f2809b = new q.b();
        this.f2808a = executorService;
    }

    public static N1.r a(Context context, Intent intent, boolean z4) {
        F f5;
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        synchronized (f2806c) {
            try {
                if (f2807d == null) {
                    f2807d = new F(context);
                }
                f5 = f2807d;
            } finally {
            }
        }
        if (!z4) {
            return f5.b(intent).i(new ExecutorC0566c(0), new A2.i(13));
        }
        if (t.c().f(context)) {
            synchronized (C.f2765b) {
                try {
                    C.a(context);
                    boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                    intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
                    if (!booleanExtra) {
                        C.f2766c.a(C.f2764a);
                    }
                    f5.b(intent).g(new D0.p(5, intent));
                } finally {
                }
            }
        } else {
            f5.b(intent);
        }
        return AbstractC0930a.i(-1);
    }

    public N1.r b(final Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        final Context context = (Context) this.f2808a;
        boolean z4 = context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z5 = (intent.getFlags() & 268435456) != 0;
        if (z4 && !z5) {
            return a(context, intent, z5);
        }
        Callable callable = new Callable() { // from class: X2.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                ServiceInfo serviceInfo;
                String str2;
                int i5;
                ComponentName componentNameStartService;
                Context context2 = context;
                Intent intent2 = intent;
                t tVarC = t.c();
                tVarC.getClass();
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Starting service");
                }
                ((ArrayDeque) tVarC.f2836f).offer(intent2);
                Intent intent3 = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent3.setPackage(context2.getPackageName());
                synchronized (tVarC) {
                    try {
                        str = (String) tVarC.f2833c;
                        if (str == null) {
                            ResolveInfo resolveInfoResolveService = context2.getPackageManager().resolveService(intent3, 0);
                            if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                                Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                            } else {
                                if (context2.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                                    if (str2.startsWith(".")) {
                                        tVarC.f2833c = context2.getPackageName() + serviceInfo.name;
                                    } else {
                                        tVarC.f2833c = serviceInfo.name;
                                    }
                                    str = (String) tVarC.f2833c;
                                }
                                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                            }
                            str = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (str != null) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Restricting intent to a specific service: ".concat(str));
                    }
                    intent3.setClassName(context2.getPackageName(), str);
                }
                try {
                    if (tVarC.f(context2)) {
                        componentNameStartService = C.c(context2, intent3);
                    } else {
                        componentNameStartService = context2.startService(intent3);
                        Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
                    }
                    if (componentNameStartService == null) {
                        Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                        i5 = 404;
                    } else {
                        i5 = -1;
                    }
                } catch (IllegalStateException e5) {
                    Log.e("FirebaseMessaging", "Failed to start service while in background: " + e5);
                    i5 = 402;
                } catch (SecurityException e6) {
                    Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e6);
                    i5 = 401;
                }
                return Integer.valueOf(i5);
            }
        };
        ExecutorC0566c executorC0566c = (ExecutorC0566c) this.f2809b;
        return AbstractC0930a.c(executorC0566c, callable).j(executorC0566c, new N1.b() { // from class: X2.i
            @Override // N1.b
            public final Object c(N1.j jVar) {
                if (((Integer) jVar.d()).intValue() != 402) {
                    return jVar;
                }
                return j.a(context, intent, z5).i(new ExecutorC0566c(0), new A2.i(12));
            }
        });
    }

    public j(Context context) {
        this.f2808a = context;
        this.f2809b = new ExecutorC0566c(0);
    }

    public j(B0.l lVar) throws JSONException {
        this.f2808a = lVar.r("gcm.n.title");
        lVar.n("gcm.n.title");
        Object[] objArrM = lVar.m("gcm.n.title");
        if (objArrM != null) {
            String[] strArr = new String[objArrM.length];
            for (int i5 = 0; i5 < objArrM.length; i5++) {
                strArr[i5] = String.valueOf(objArrM[i5]);
            }
        }
        this.f2809b = lVar.r("gcm.n.body");
        lVar.n("gcm.n.body");
        Object[] objArrM2 = lVar.m("gcm.n.body");
        if (objArrM2 != null) {
            String[] strArr2 = new String[objArrM2.length];
            for (int i6 = 0; i6 < objArrM2.length; i6++) {
                strArr2[i6] = String.valueOf(objArrM2[i6]);
            }
        }
        lVar.r("gcm.n.icon");
        if (TextUtils.isEmpty(lVar.r("gcm.n.sound2"))) {
            lVar.r("gcm.n.sound");
        }
        lVar.r("gcm.n.tag");
        lVar.r("gcm.n.color");
        lVar.r("gcm.n.click_action");
        lVar.r("gcm.n.android_channel_id");
        String strR = lVar.r("gcm.n.link_android");
        strR = TextUtils.isEmpty(strR) ? lVar.r("gcm.n.link") : strR;
        if (!TextUtils.isEmpty(strR)) {
            Uri.parse(strR);
        }
        lVar.r("gcm.n.image");
        lVar.r("gcm.n.ticker");
        lVar.h("gcm.n.notification_priority");
        lVar.h("gcm.n.visibility");
        lVar.h("gcm.n.notification_count");
        lVar.f("gcm.n.sticky");
        lVar.f("gcm.n.local_only");
        lVar.f("gcm.n.default_sound");
        lVar.f("gcm.n.default_vibrate_timings");
        lVar.f("gcm.n.default_light_settings");
        lVar.o();
        lVar.l();
        lVar.s();
    }
}
