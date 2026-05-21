package n1;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.fragment.app.AbstractActivityC0230z;
import androidx.fragment.app.C0206a;
import androidx.fragment.app.T;
import g0.AbstractC0535a;
import q1.C0867s;
import q1.E;
import q1.u;
import u1.AbstractC0907b;

/* renamed from: n1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0788e extends C0789f {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f8737c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final C0788e f8738d = new C0788e();

    public static AlertDialog e(Context context, int i5, u uVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i5 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(q1.r.c(context, i5));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = q1.r.b(context, i5);
        if (strB != null) {
            builder.setPositiveButton(strB, uVar);
        }
        String strD = q1.r.d(context, i5);
        if (strD != null) {
            builder.setTitle(strD);
        }
        Log.w("GoogleApiAvailability", com.unified.ur1.SatelliteTracker.h.a(i5, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void f(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AbstractActivityC0230z) {
                T supportFragmentManager = ((AbstractActivityC0230z) activity).getSupportFragmentManager();
                C0793j c0793j = new C0793j();
                E.j(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                c0793j.f8750s = alertDialog;
                if (onCancelListener != null) {
                    c0793j.f8751t = onCancelListener;
                }
                c0793j.f3847p = false;
                c0793j.f3848q = true;
                supportFragmentManager.getClass();
                C0206a c0206a = new C0206a(supportFragmentManager);
                c0206a.e(0, c0793j, str, 1);
                c0206a.d(false);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        DialogFragmentC0786c dialogFragmentC0786c = new DialogFragmentC0786c();
        E.j(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        dialogFragmentC0786c.f8731c = alertDialog;
        if (onCancelListener != null) {
            dialogFragmentC0786c.f8732d = onCancelListener;
        }
        dialogFragmentC0786c.show(fragmentManager, str);
    }

    public final void d(Activity activity, int i5, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogE = e(activity, i5, new C0867s(activity, super.a(i5, activity, "d")), onCancelListener);
        if (alertDialogE == null) {
            return;
        }
        f(activity, alertDialogE, "GooglePlayServicesErrorDialog", onCancelListener);
    }

    public final void g(Context context, int i5, PendingIntent pendingIntent) throws Resources.NotFoundException {
        int i6;
        Log.w("GoogleApiAvailability", AbstractC0535a.j("GMS core API Availability. ConnectionResult=", i5, ", tag=null"), new IllegalArgumentException());
        if (i5 == 18) {
            new HandlerC0794k(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i5 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strF = i5 == 6 ? q1.r.f(context, "common_google_play_services_resolution_required_title") : q1.r.d(context, i5);
        if (strF == null) {
            strF = context.getResources().getString(com.unified.ur1.R.string.common_google_play_services_notification_ticker);
        }
        String strE = (i5 == 6 || i5 == 19) ? q1.r.e(context, "common_google_play_services_resolution_required_text", q1.r.a(context)) : q1.r.c(context, i5);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        E.i(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        B.t tVar = new B.t(context, null);
        tVar.f74m = true;
        tVar.c(16, true);
        tVar.f68e = B.t.b(strF);
        B.s sVar = new B.s();
        sVar.f63d = B.t.b(strE);
        tVar.d(sVar);
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC0907b.f9921c == null) {
            AbstractC0907b.f9921c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (AbstractC0907b.f9921c.booleanValue()) {
            tVar.f82v.icon = context.getApplicationInfo().icon;
            tVar.f71j = 2;
            if (AbstractC0907b.b(context)) {
                tVar.f65b.add(new B.n(com.unified.ur1.R.drawable.common_full_open_on_phone, resources.getString(com.unified.ur1.R.string.common_open_on_phone), pendingIntent));
            } else {
                tVar.g = pendingIntent;
            }
        } else {
            tVar.f82v.icon = R.drawable.stat_sys_warning;
            tVar.f82v.tickerText = B.t.b(resources.getString(com.unified.ur1.R.string.common_google_play_services_notification_ticker));
            tVar.f82v.when = System.currentTimeMillis();
            tVar.g = pendingIntent;
            tVar.f69f = B.t.b(strE);
        }
        synchronized (f8737c) {
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String string = context.getResources().getString(com.unified.ur1.R.string.common_google_play_services_notification_channel_name);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        tVar.f78r = "com.google.android.gms.availability";
        Notification notificationA = tVar.a();
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            AbstractC0791h.f8742a.set(false);
            i6 = 10436;
        } else {
            i6 = 39789;
        }
        notificationManager.notify(i6, notificationA);
    }

    public final void h(Activity activity, p1.k kVar, int i5, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogE = e(activity, i5, new q1.t(super.a(i5, activity, "d"), kVar), onCancelListener);
        if (alertDialogE == null) {
            return;
        }
        f(activity, alertDialogE, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
