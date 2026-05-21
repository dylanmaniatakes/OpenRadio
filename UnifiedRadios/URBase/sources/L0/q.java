package L0;

import android.database.Cursor;
import com.google.android.gms.internal.measurement.D1;
import java.util.ArrayList;
import l0.AbstractC0737m;
import l0.C0738n;
import q0.C0847j;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0737m f1582a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1583b;

    /* renamed from: c, reason: collision with root package name */
    public final h f1584c;

    /* renamed from: d, reason: collision with root package name */
    public final h f1585d;

    /* renamed from: e, reason: collision with root package name */
    public final h f1586e;

    /* renamed from: f, reason: collision with root package name */
    public final h f1587f;
    public final h g;
    public final h h;

    /* renamed from: i, reason: collision with root package name */
    public final h f1588i;

    /* renamed from: j, reason: collision with root package name */
    public final h f1589j;

    /* renamed from: k, reason: collision with root package name */
    public final h f1590k;

    /* renamed from: l, reason: collision with root package name */
    public final h f1591l;

    /* renamed from: m, reason: collision with root package name */
    public final h f1592m;
    public final h n;

    public q(AbstractC0737m abstractC0737m) {
        this.f1582a = abstractC0737m;
        this.f1583b = new b(abstractC0737m, 5);
        new p(abstractC0737m, 0);
        this.f1584c = new h(abstractC0737m, 12);
        this.f1585d = new h(abstractC0737m, 13);
        this.f1586e = new h(abstractC0737m, 14);
        this.f1587f = new h(abstractC0737m, 15);
        this.g = new h(abstractC0737m, 16);
        this.h = new h(abstractC0737m, 17);
        this.f1588i = new h(abstractC0737m, 18);
        this.f1589j = new h(abstractC0737m, 4);
        new h(abstractC0737m, 5);
        this.f1590k = new h(abstractC0737m, 6);
        this.f1591l = new h(abstractC0737m, 7);
        this.f1592m = new h(abstractC0737m, 8);
        new h(abstractC0737m, 9);
        new h(abstractC0737m, 10);
        this.n = new h(abstractC0737m, 11);
    }

    public final ArrayList a() throws Throwable {
        C0738n c0738n;
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
        C0738n c0738nO = C0738n.o(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        c0738nO.I(1, 200);
        AbstractC0737m abstractC0737m = this.f1582a;
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
                    C0.h hVarA = C0.h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                    C0.h hVarA2 = C0.h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
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
                    arrayList.add(new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new C0.d(i26, z5, z6, z7, z8, j13, j14, D1.a(cursorM.isNull(i29) ? null : cursorM.getBlob(i29))), i11, iH31, j8, j9, j10, j11, z4, iJ, i17, i19, j12, i22, i24));
                    iH = i13;
                    i10 = i12;
                }
                cursorM.close();
                c0738n.s();
                return arrayList;
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

    public final ArrayList b(int i5) throws Throwable {
        C0738n c0738n;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        int i9;
        boolean z7;
        int i10;
        boolean z8;
        C0738n c0738nO = C0738n.o(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        c0738nO.I(1, i5);
        AbstractC0737m abstractC0737m = this.f1582a;
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
                int i11 = iH14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.isNull(iH) ? null : cursorM.getString(iH);
                    int iK = D1.k(cursorM.getInt(iH2));
                    String string2 = cursorM.isNull(iH3) ? null : cursorM.getString(iH3);
                    String string3 = cursorM.isNull(iH4) ? null : cursorM.getString(iH4);
                    C0.h hVarA = C0.h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                    C0.h hVarA2 = C0.h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
                    long j5 = cursorM.getLong(iH7);
                    long j6 = cursorM.getLong(iH8);
                    long j7 = cursorM.getLong(iH9);
                    int i12 = cursorM.getInt(iH10);
                    int iH31 = D1.h(cursorM.getInt(iH11));
                    long j8 = cursorM.getLong(iH12);
                    long j9 = cursorM.getLong(iH13);
                    int i13 = i11;
                    long j10 = cursorM.getLong(i13);
                    int i14 = iH;
                    int i15 = iH15;
                    long j11 = cursorM.getLong(i15);
                    iH15 = i15;
                    int i16 = iH16;
                    if (cursorM.getInt(i16) != 0) {
                        iH16 = i16;
                        i6 = iH17;
                        z4 = true;
                    } else {
                        iH16 = i16;
                        i6 = iH17;
                        z4 = false;
                    }
                    int iJ = D1.j(cursorM.getInt(i6));
                    iH17 = i6;
                    int i17 = iH18;
                    int i18 = cursorM.getInt(i17);
                    iH18 = i17;
                    int i19 = iH19;
                    int i20 = cursorM.getInt(i19);
                    iH19 = i19;
                    int i21 = iH20;
                    long j12 = cursorM.getLong(i21);
                    iH20 = i21;
                    int i22 = iH21;
                    int i23 = cursorM.getInt(i22);
                    iH21 = i22;
                    int i24 = iH22;
                    int i25 = cursorM.getInt(i24);
                    iH22 = i24;
                    int i26 = iH23;
                    int i27 = D1.i(cursorM.getInt(i26));
                    iH23 = i26;
                    int i28 = iH24;
                    if (cursorM.getInt(i28) != 0) {
                        iH24 = i28;
                        i7 = iH25;
                        z5 = true;
                    } else {
                        iH24 = i28;
                        i7 = iH25;
                        z5 = false;
                    }
                    if (cursorM.getInt(i7) != 0) {
                        iH25 = i7;
                        i8 = iH26;
                        z6 = true;
                    } else {
                        iH25 = i7;
                        i8 = iH26;
                        z6 = false;
                    }
                    if (cursorM.getInt(i8) != 0) {
                        iH26 = i8;
                        i9 = iH27;
                        z7 = true;
                    } else {
                        iH26 = i8;
                        i9 = iH27;
                        z7 = false;
                    }
                    if (cursorM.getInt(i9) != 0) {
                        iH27 = i9;
                        i10 = iH28;
                        z8 = true;
                    } else {
                        iH27 = i9;
                        i10 = iH28;
                        z8 = false;
                    }
                    long j13 = cursorM.getLong(i10);
                    iH28 = i10;
                    int i29 = iH29;
                    long j14 = cursorM.getLong(i29);
                    iH29 = i29;
                    int i30 = iH30;
                    iH30 = i30;
                    arrayList.add(new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new C0.d(i27, z5, z6, z7, z8, j13, j14, D1.a(cursorM.isNull(i30) ? null : cursorM.getBlob(i30))), i12, iH31, j8, j9, j10, j11, z4, iJ, i18, i20, j12, i23, i25));
                    iH = i14;
                    i11 = i13;
                }
                cursorM.close();
                c0738n.s();
                return arrayList;
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

    public final ArrayList c() throws Throwable {
        C0738n c0738n;
        int iH;
        int iH2;
        int iH3;
        int iH4;
        int iH5;
        int iH6;
        int iH7;
        int iH8;
        int iH9;
        int iH10;
        int iH11;
        int iH12;
        int iH13;
        int iH14;
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
        C0738n c0738nO = C0738n.o(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            iH = f.h(cursorM, "id");
            iH2 = f.h(cursorM, "state");
            iH3 = f.h(cursorM, "worker_class_name");
            iH4 = f.h(cursorM, "input_merger_class_name");
            iH5 = f.h(cursorM, "input");
            iH6 = f.h(cursorM, "output");
            iH7 = f.h(cursorM, "initial_delay");
            iH8 = f.h(cursorM, "interval_duration");
            iH9 = f.h(cursorM, "flex_duration");
            iH10 = f.h(cursorM, "run_attempt_count");
            iH11 = f.h(cursorM, "backoff_policy");
            iH12 = f.h(cursorM, "backoff_delay_duration");
            iH13 = f.h(cursorM, "last_enqueue_time");
            iH14 = f.h(cursorM, "minimum_retention_duration");
            c0738n = c0738nO;
        } catch (Throwable th) {
            th = th;
            c0738n = c0738nO;
        }
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
                C0.h hVarA = C0.h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                C0.h hVarA2 = C0.h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
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
                arrayList.add(new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new C0.d(i26, z5, z6, z7, z8, j13, j14, D1.a(cursorM.isNull(i29) ? null : cursorM.getBlob(i29))), i11, iH31, j8, j9, j10, j11, z4, iJ, i17, i19, j12, i22, i24));
                iH = i13;
                i10 = i12;
            }
            cursorM.close();
            c0738n.s();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorM.close();
            c0738n.s();
            throw th;
        }
    }

    public final ArrayList d() throws Throwable {
        C0738n c0738n;
        int iH;
        int iH2;
        int iH3;
        int iH4;
        int iH5;
        int iH6;
        int iH7;
        int iH8;
        int iH9;
        int iH10;
        int iH11;
        int iH12;
        int iH13;
        int iH14;
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
        C0738n c0738nO = C0738n.o(0, "SELECT * FROM workspec WHERE state=1");
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            iH = f.h(cursorM, "id");
            iH2 = f.h(cursorM, "state");
            iH3 = f.h(cursorM, "worker_class_name");
            iH4 = f.h(cursorM, "input_merger_class_name");
            iH5 = f.h(cursorM, "input");
            iH6 = f.h(cursorM, "output");
            iH7 = f.h(cursorM, "initial_delay");
            iH8 = f.h(cursorM, "interval_duration");
            iH9 = f.h(cursorM, "flex_duration");
            iH10 = f.h(cursorM, "run_attempt_count");
            iH11 = f.h(cursorM, "backoff_policy");
            iH12 = f.h(cursorM, "backoff_delay_duration");
            iH13 = f.h(cursorM, "last_enqueue_time");
            iH14 = f.h(cursorM, "minimum_retention_duration");
            c0738n = c0738nO;
        } catch (Throwable th) {
            th = th;
            c0738n = c0738nO;
        }
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
                C0.h hVarA = C0.h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                C0.h hVarA2 = C0.h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
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
                arrayList.add(new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new C0.d(i26, z5, z6, z7, z8, j13, j14, D1.a(cursorM.isNull(i29) ? null : cursorM.getBlob(i29))), i11, iH31, j8, j9, j10, j11, z4, iJ, i17, i19, j12, i22, i24));
                iH = i13;
                i10 = i12;
            }
            cursorM.close();
            c0738n.s();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorM.close();
            c0738n.s();
            throw th;
        }
    }

    public final ArrayList e() {
        C0738n c0738n;
        int iH;
        int iH2;
        int iH3;
        int iH4;
        int iH5;
        int iH6;
        int iH7;
        int iH8;
        int iH9;
        int iH10;
        int iH11;
        int iH12;
        int iH13;
        int iH14;
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
        C0738n c0738nO = C0738n.o(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            iH = f.h(cursorM, "id");
            iH2 = f.h(cursorM, "state");
            iH3 = f.h(cursorM, "worker_class_name");
            iH4 = f.h(cursorM, "input_merger_class_name");
            iH5 = f.h(cursorM, "input");
            iH6 = f.h(cursorM, "output");
            iH7 = f.h(cursorM, "initial_delay");
            iH8 = f.h(cursorM, "interval_duration");
            iH9 = f.h(cursorM, "flex_duration");
            iH10 = f.h(cursorM, "run_attempt_count");
            iH11 = f.h(cursorM, "backoff_policy");
            iH12 = f.h(cursorM, "backoff_delay_duration");
            iH13 = f.h(cursorM, "last_enqueue_time");
            iH14 = f.h(cursorM, "minimum_retention_duration");
            c0738n = c0738nO;
        } catch (Throwable th) {
            th = th;
            c0738n = c0738nO;
        }
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
                C0.h hVarA = C0.h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                C0.h hVarA2 = C0.h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
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
                arrayList.add(new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new C0.d(i26, z5, z6, z7, z8, j13, j14, D1.a(cursorM.isNull(i29) ? null : cursorM.getBlob(i29))), i11, iH31, j8, j9, j10, j11, z4, iJ, i17, i19, j12, i22, i24));
                iH = i13;
                i10 = i12;
            }
            cursorM.close();
            c0738n.s();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorM.close();
            c0738n.s();
            throw th;
        }
    }

    public final int f(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        Integer numValueOf = null;
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            int iK = 0;
            if (cursorM.moveToFirst()) {
                if (!cursorM.isNull(0)) {
                    numValueOf = Integer.valueOf(cursorM.getInt(0));
                }
                if (numValueOf != null) {
                    iK = D1.k(numValueOf.intValue());
                }
            }
            return iK;
        } finally {
            cursorM.close();
            c0738nO.s();
        }
    }

    public final ArrayList g(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.isNull(0) ? null : cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            c0738nO.s();
        }
    }

    public final o h(String str) {
        C0738n c0738n;
        o oVar;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        int i7;
        boolean z7;
        int i8;
        boolean z8;
        int i9;
        C0738n c0738nO = C0738n.o(1, "SELECT * FROM workspec WHERE id=?");
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        AbstractC0737m abstractC0737m = this.f1582a;
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
                if (cursorM.moveToFirst()) {
                    String string = cursorM.isNull(iH) ? null : cursorM.getString(iH);
                    int iK = D1.k(cursorM.getInt(iH2));
                    String string2 = cursorM.isNull(iH3) ? null : cursorM.getString(iH3);
                    String string3 = cursorM.isNull(iH4) ? null : cursorM.getString(iH4);
                    C0.h hVarA = C0.h.a(cursorM.isNull(iH5) ? null : cursorM.getBlob(iH5));
                    C0.h hVarA2 = C0.h.a(cursorM.isNull(iH6) ? null : cursorM.getBlob(iH6));
                    long j5 = cursorM.getLong(iH7);
                    long j6 = cursorM.getLong(iH8);
                    long j7 = cursorM.getLong(iH9);
                    int i10 = cursorM.getInt(iH10);
                    int iH31 = D1.h(cursorM.getInt(iH11));
                    long j8 = cursorM.getLong(iH12);
                    long j9 = cursorM.getLong(iH13);
                    long j10 = cursorM.getLong(iH14);
                    long j11 = cursorM.getLong(iH15);
                    if (cursorM.getInt(iH16) != 0) {
                        i5 = iH17;
                        z4 = true;
                    } else {
                        z4 = false;
                        i5 = iH17;
                    }
                    int iJ = D1.j(cursorM.getInt(i5));
                    int i11 = cursorM.getInt(iH18);
                    int i12 = cursorM.getInt(iH19);
                    long j12 = cursorM.getLong(iH20);
                    int i13 = cursorM.getInt(iH21);
                    int i14 = cursorM.getInt(iH22);
                    int i15 = D1.i(cursorM.getInt(iH23));
                    if (cursorM.getInt(iH24) != 0) {
                        i6 = iH25;
                        z5 = true;
                    } else {
                        z5 = false;
                        i6 = iH25;
                    }
                    if (cursorM.getInt(i6) != 0) {
                        i7 = iH26;
                        z6 = true;
                    } else {
                        z6 = false;
                        i7 = iH26;
                    }
                    if (cursorM.getInt(i7) != 0) {
                        i8 = iH27;
                        z7 = true;
                    } else {
                        z7 = false;
                        i8 = iH27;
                    }
                    if (cursorM.getInt(i8) != 0) {
                        i9 = iH28;
                        z8 = true;
                    } else {
                        z8 = false;
                        i9 = iH28;
                    }
                    oVar = new o(string, iK, string2, string3, hVarA, hVarA2, j5, j6, j7, new C0.d(i15, z5, z6, z7, z8, cursorM.getLong(i9), cursorM.getLong(iH29), D1.a(cursorM.isNull(iH30) ? null : cursorM.getBlob(iH30))), i10, iH31, j8, j9, j10, j11, z4, iJ, i11, i12, j12, i13, i14);
                } else {
                    oVar = null;
                }
                cursorM.close();
                c0738n.s();
                return oVar;
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

    public final void i(long j5, String str) {
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        h hVar = this.f1591l;
        C0847j c0847jA = hVar.a();
        c0847jA.I(1, j5);
        if (str == null) {
            c0847jA.t(2);
        } else {
            c0847jA.h(2, str);
        }
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar.n(c0847jA);
        }
    }

    public final void j(int i5, String str) {
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        h hVar = this.f1590k;
        C0847j c0847jA = hVar.a();
        if (str == null) {
            c0847jA.t(1);
        } else {
            c0847jA.h(1, str);
        }
        c0847jA.I(2, i5);
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar.n(c0847jA);
        }
    }

    public final void k(long j5, String str) {
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        h hVar = this.h;
        C0847j c0847jA = hVar.a();
        c0847jA.I(1, j5);
        if (str == null) {
            c0847jA.t(2);
        } else {
            c0847jA.h(2, str);
        }
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar.n(c0847jA);
        }
    }

    public final void l(String str, C0.h hVar) throws Throwable {
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        h hVar2 = this.g;
        C0847j c0847jA = hVar2.a();
        byte[] bArrB = C0.h.b(hVar);
        if (bArrB == null) {
            c0847jA.t(1);
        } else {
            c0847jA.M(1, bArrB);
        }
        if (str == null) {
            c0847jA.t(2);
        } else {
            c0847jA.h(2, str);
        }
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar2.n(c0847jA);
        }
    }

    public final void m(int i5, String str) {
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        h hVar = this.f1585d;
        C0847j c0847jA = hVar.a();
        c0847jA.I(1, D1.p(i5));
        if (str == null) {
            c0847jA.t(2);
        } else {
            c0847jA.h(2, str);
        }
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar.n(c0847jA);
        }
    }

    public final void n(int i5, String str) {
        AbstractC0737m abstractC0737m = this.f1582a;
        abstractC0737m.b();
        h hVar = this.n;
        C0847j c0847jA = hVar.a();
        c0847jA.I(1, i5);
        if (str == null) {
            c0847jA.t(2);
        } else {
            c0847jA.h(2, str);
        }
        abstractC0737m.c();
        try {
            c0847jA.c();
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
            hVar.n(c0847jA);
        }
    }
}
