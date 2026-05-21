package androidx.work.impl.workers;

import C0.d;
import C0.h;
import C0.r;
import C0.t;
import D0.v;
import F3.i;
import L0.f;
import L0.l;
import L0.o;
import L0.q;
import L0.s;
import P0.b;
import android.content.Context;
import android.database.Cursor;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.internal.measurement.D1;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import l0.AbstractC0737m;
import l0.C0738n;

/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        i.f(context, "context");
        i.f(workerParameters, "parameters");
    }

    @Override // androidx.work.Worker
    public final r f() throws Throwable {
        C0738n c0738n;
        L0.i iVar;
        l lVar;
        s sVar;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        int i9;
        boolean z8;
        v vVarY = v.y(this.f168c);
        WorkDatabase workDatabase = vVarY.f302c;
        i.e(workDatabase, "workManager.workDatabase");
        q qVarV = workDatabase.v();
        l lVarT = workDatabase.t();
        s sVarW = workDatabase.w();
        L0.i iVarS = workDatabase.s();
        vVarY.f301b.f132c.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        qVarV.getClass();
        C0738n c0738nO = C0738n.o(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        c0738nO.I(1, jCurrentTimeMillis);
        AbstractC0737m abstractC0737m = qVarV.f1582a;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            int iH = f.h(cursorM, "id");
            int iH2 = f.h(cursorM, "state");
            int iH3 = f.h(cursorM, "worker_class_name");
            int iH4 = f.h(cursorM, "input_merger_class_name");
            int iH5 = f.h(cursorM, "input");
            int iH6 = f.h(cursorM, "output");
            int iH7 = f.h(cursorM, "initial_delay");
            int iH8 = f.h(cursorM, "interval_duration");
            int iH9 = f.h(cursorM, "flex_duration");
            int iH10 = f.h(cursorM, "run_attempt_count");
            int iH11 = f.h(cursorM, "backoff_policy");
            int iH12 = f.h(cursorM, "backoff_delay_duration");
            int iH13 = f.h(cursorM, "last_enqueue_time");
            int iH14 = f.h(cursorM, "minimum_retention_duration");
            c0738n = c0738nO;
            try {
                int iH15 = f.h(cursorM, "schedule_requested_at");
                int iH16 = f.h(cursorM, "run_in_foreground");
                int iH17 = f.h(cursorM, "out_of_quota_policy");
                int iH18 = f.h(cursorM, "period_count");
                int iH19 = f.h(cursorM, "generation");
                int iH20 = f.h(cursorM, "next_schedule_time_override");
                int iH21 = f.h(cursorM, "next_schedule_time_override_generation");
                int iH22 = f.h(cursorM, "stop_reason");
                int iH23 = f.h(cursorM, "required_network_type");
                int iH24 = f.h(cursorM, "requires_charging");
                int iH25 = f.h(cursorM, "requires_device_idle");
                int iH26 = f.h(cursorM, "requires_battery_not_low");
                int iH27 = f.h(cursorM, "requires_storage_not_low");
                int iH28 = f.h(cursorM, "trigger_content_update_delay");
                int iH29 = f.h(cursorM, "trigger_max_content_delay");
                int iH30 = f.h(cursorM, "content_uri_triggers");
                int i10 = iH14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.isNull(iH) ? null : cursorM.getString(iH);
                    int iK = D1.k(cursorM.getInt(iH2));
                    String string2 = cursorM.isNull(iH3) ? null : cursorM.getString(iH3);
                    String string3 = cursorM.isNull(iH4) ? null : cursorM.getString(iH4);
                    h hVarA = h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                    h hVarA2 = h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
                    long j5 = cursorM.getLong(iH7);
                    long j6 = cursorM.getLong(iH8);
                    long j7 = cursorM.getLong(iH9);
                    int i11 = cursorM.getInt(iH10);
                    int iH31 = D1.h(cursorM.getInt(iH11));
                    long j8 = cursorM.getLong(iH12);
                    long j9 = cursorM.getLong(iH13);
                    int i12 = i10;
                    long j10 = cursorM.getLong(i12);
                    int i13 = iH;
                    int i14 = iH15;
                    long j11 = cursorM.getLong(i14);
                    iH15 = i14;
                    int i15 = iH16;
                    if (cursorM.getInt(i15) != 0) {
                        iH16 = i15;
                        i5 = iH17;
                        z4 = true;
                    } else {
                        iH16 = i15;
                        i5 = iH17;
                        z4 = false;
                    }
                    int iJ = D1.j(cursorM.getInt(i5));
                    iH17 = i5;
                    int i16 = iH18;
                    int i17 = cursorM.getInt(i16);
                    iH18 = i16;
                    int i18 = iH19;
                    int i19 = cursorM.getInt(i18);
                    iH19 = i18;
                    int i20 = iH20;
                    long j12 = cursorM.getLong(i20);
                    iH20 = i20;
                    int i21 = iH21;
                    int i22 = cursorM.getInt(i21);
                    iH21 = i21;
                    int i23 = iH22;
                    int i24 = cursorM.getInt(i23);
                    iH22 = i23;
                    int i25 = iH23;
                    int i26 = D1.i(cursorM.getInt(i25));
                    iH23 = i25;
                    int i27 = iH24;
                    if (cursorM.getInt(i27) != 0) {
                        iH24 = i27;
                        i6 = iH25;
                        z5 = true;
                    } else {
                        iH24 = i27;
                        i6 = iH25;
                        z5 = false;
                    }
                    if (cursorM.getInt(i6) != 0) {
                        iH25 = i6;
                        i7 = iH26;
                        z6 = true;
                    } else {
                        iH25 = i6;
                        i7 = iH26;
                        z6 = false;
                    }
                    if (cursorM.getInt(i7) != 0) {
                        iH26 = i7;
                        i8 = iH27;
                        z7 = true;
                    } else {
                        iH26 = i7;
                        i8 = iH27;
                        z7 = false;
                    }
                    if (cursorM.getInt(i8) != 0) {
                        iH27 = i8;
                        i9 = iH28;
                        z8 = true;
                    } else {
                        iH27 = i8;
                        i9 = iH28;
                        z8 = false;
                    }
                    long j13 = cursorM.getLong(i9);
                    iH28 = i9;
                    int i28 = iH29;
                    long j14 = cursorM.getLong(i28);
                    iH29 = i28;
                    int i29 = iH30;
                    iH30 = i29;
                    arrayList.add(new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new d(i26, z5, z6, z7, z8, j13, j14, D1.a(cursorM.isNull(i29) ? null : cursorM.getBlob(i29))), i11, iH31, j8, j9, j10, j11, z4, iJ, i17, i19, j12, i22, i24));
                    iH = i13;
                    i10 = i12;
                }
                cursorM.close();
                c0738n.s();
                ArrayList arrayListD = qVarV.d();
                ArrayList arrayListA = qVarV.a();
                if (!arrayList.isEmpty()) {
                    t tVarD = t.d();
                    String str = b.f2063a;
                    tVarD.e(str, "Recently completed work:\n\n");
                    iVar = iVarS;
                    lVar = lVarT;
                    sVar = sVarW;
                    t.d().e(str, b.a(lVar, sVar, iVar, arrayList));
                } else {
                    iVar = iVarS;
                    lVar = lVarT;
                    sVar = sVarW;
                }
                if (!arrayListD.isEmpty()) {
                    t tVarD2 = t.d();
                    String str2 = b.f2063a;
                    tVarD2.e(str2, "Running work:\n\n");
                    t.d().e(str2, b.a(lVar, sVar, iVar, arrayListD));
                }
                if (!arrayListA.isEmpty()) {
                    t tVarD3 = t.d();
                    String str3 = b.f2063a;
                    tVarD3.e(str3, "Enqueued work:\n\n");
                    t.d().e(str3, b.a(lVar, sVar, iVar, arrayListA));
                }
                return new C0.q(h.f157c);
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                c0738n.s();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            c0738n = c0738nO;
        }
    }
}
