package F0;

import C0.t;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f492a = t.f("Alarms");

    public static void a(Context context, L0.j jVar, int i5) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = c.h;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        c.c(intent, jVar);
        PendingIntent service = PendingIntent.getService(context, i5, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        t.d().a(f492a, "Cancelling existing alarm with (workSpecId, systemId) (" + jVar + ", " + i5 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, L0.j jVar, long j5) {
        L0.i iVarS = workDatabase.s();
        L0.g gVarG = iVarS.g(jVar);
        if (gVarG != null) {
            int i5 = gVarG.f1545c;
            a(context, jVar, i5);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = c.h;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            c.c(intent, jVar);
            PendingIntent service = PendingIntent.getService(context, i5, intent, 201326592);
            if (alarmManager != null) {
                a.a(alarmManager, 0, j5, service);
                return;
            }
            return;
        }
        Object objN = workDatabase.n(new O2.c(2, new L0.l(workDatabase)));
        F3.i.e(objN, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        int iIntValue = ((Number) objN).intValue();
        iVarS.h(new L0.g(jVar.f1551a, jVar.f1552b, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = c.h;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        c.c(intent2, jVar);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            a.a(alarmManager2, 0, j5, service2);
        }
    }
}
