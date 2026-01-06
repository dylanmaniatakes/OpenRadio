package M0;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class f implements Runnable {
    public static final String n = C0.t.f("ForceStopRunnable");

    /* renamed from: o, reason: collision with root package name */
    public static final long f1673o = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: j, reason: collision with root package name */
    public final Context f1674j;

    /* renamed from: k, reason: collision with root package name */
    public final D0.v f1675k;

    /* renamed from: l, reason: collision with root package name */
    public final Z2.c f1676l;

    /* renamed from: m, reason: collision with root package name */
    public int f1677m = 0;

    public f(Context context, D0.v vVar) {
        this.f1674j = context.getApplicationContext();
        this.f1675k = vVar;
        this.f1676l = vVar.g;
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i5 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i5);
        long jCurrentTimeMillis = System.currentTimeMillis() + f1673o;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M0.f.a():void");
    }

    public final boolean b() {
        this.f1675k.f301b.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = n;
        if (zIsEmpty) {
            C0.t.d().a(str, "The default process name was not specified.");
            return true;
        }
        int i5 = l.f1682a;
        Context context = this.f1674j;
        F3.i.f(context, "context");
        boolean zA = F3.i.a(a.f1663a.a(), context.getApplicationInfo().processName);
        C0.t.d().a(str, "Is default app process = " + zA);
        return zA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f1674j;
        String str = n;
        D0.v vVar = this.f1675k;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    AbstractC0409x1.k(context);
                    C0.t.d().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e5) {
                        int i5 = this.f1677m + 1;
                        this.f1677m = i5;
                        if (i5 >= 3) {
                            String str2 = K.m.a(context) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            C0.t.d().c(str, str2, e5);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e5);
                            vVar.f301b.getClass();
                            throw illegalStateException;
                        }
                        long j5 = i5 * 300;
                        String str3 = "Retrying after " + j5;
                        if (C0.t.d().f174a <= 3) {
                            Log.d(str, str3, e5);
                        }
                        try {
                            Thread.sleep(this.f1677m * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e6) {
                    C0.t.d().b(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e6);
                    vVar.f301b.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            vVar.z();
        }
    }
}
