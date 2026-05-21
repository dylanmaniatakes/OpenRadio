package L0;

import android.os.Build;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.internal.measurement.D1;
import f3.C0511d;
import f3.C0518i;
import g0.AbstractC0535a;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import l0.AbstractC0728d;
import l0.AbstractC0737m;
import m3.C0776l;
import q0.C0847j;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class b extends AbstractC0728d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1534d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AbstractC0737m abstractC0737m, int i5) {
        super(abstractC0737m);
        this.f1534d = i5;
        F3.i.f(abstractC0737m, "database");
    }

    @Override // l0.AbstractC0740p
    public final String l() {
        switch (this.f1534d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 5:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            case 6:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            case 7:
                return "INSERT OR ABORT INTO `app_settings` (`name`,`value`) VALUES (?,?)";
            case 8:
                return "INSERT OR ABORT INTO `channel_memories` (`memoryId`,`name`,`frequency`,`offset`,`tone`,`group`) VALUES (nullif(?, 0),?,?,?,?,?)";
            default:
                return "INSERT OR ABORT INTO `recordings` (`id`,`timestamp`,`filename`,`durationMs`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    @Override // l0.AbstractC0728d
    public final void q(C0847j c0847j, Object obj) throws Throwable {
        int i5;
        int i6;
        byte[] byteArray;
        switch (this.f1534d) {
            case 0:
                a aVar = (a) obj;
                String str = aVar.f1532a;
                if (str == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str);
                }
                String str2 = aVar.f1533b;
                if (str2 == null) {
                    c0847j.t(2);
                    return;
                } else {
                    c0847j.h(2, str2);
                    return;
                }
            case 1:
                d dVar = (d) obj;
                String str3 = dVar.f1538a;
                if (str3 == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str3);
                }
                Long l5 = dVar.f1539b;
                if (l5 == null) {
                    c0847j.t(2);
                    return;
                } else {
                    c0847j.I(2, l5.longValue());
                    return;
                }
            case 2:
                String str4 = ((g) obj).f1543a;
                if (str4 == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str4);
                }
                c0847j.I(2, r13.f1544b);
                c0847j.I(3, r13.f1545c);
                return;
            case 3:
                throw null;
            case 4:
                com.unified.ur1.SatelliteTracker.h.p(obj);
                throw null;
            case 5:
                o oVar = (o) obj;
                String str5 = oVar.f1561a;
                int i7 = 1;
                if (str5 == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str5);
                }
                c0847j.I(2, D1.p(oVar.f1562b));
                String str6 = oVar.f1563c;
                if (str6 == null) {
                    c0847j.t(3);
                } else {
                    c0847j.h(3, str6);
                }
                String str7 = oVar.f1564d;
                if (str7 == null) {
                    c0847j.t(4);
                } else {
                    c0847j.h(4, str7);
                }
                byte[] bArrB = C0.h.b(oVar.f1565e);
                if (bArrB == null) {
                    c0847j.t(5);
                } else {
                    c0847j.M(5, bArrB);
                }
                byte[] bArrB2 = C0.h.b(oVar.f1566f);
                if (bArrB2 == null) {
                    c0847j.t(6);
                } else {
                    c0847j.M(6, bArrB2);
                }
                c0847j.I(7, oVar.g);
                c0847j.I(8, oVar.h);
                c0847j.I(9, oVar.f1567i);
                c0847j.I(10, oVar.f1569k);
                int i8 = oVar.f1570l;
                AbstractC0535a.p(i8, "backoffPolicy");
                int iC = AbstractC0882e.c(i8);
                if (iC == 0) {
                    i5 = 0;
                } else {
                    if (iC != 1) {
                        throw new F1.b();
                    }
                    i5 = 1;
                }
                c0847j.I(11, i5);
                c0847j.I(12, oVar.f1571m);
                c0847j.I(13, oVar.n);
                c0847j.I(14, oVar.f1572o);
                c0847j.I(15, oVar.f1573p);
                c0847j.I(16, oVar.f1574q ? 1L : 0L);
                int i9 = oVar.f1575r;
                AbstractC0535a.p(i9, "policy");
                int iC2 = AbstractC0882e.c(i9);
                if (iC2 == 0) {
                    i7 = 0;
                } else if (iC2 != 1) {
                    throw new F1.b();
                }
                c0847j.I(17, i7);
                c0847j.I(18, oVar.f1576s);
                c0847j.I(19, oVar.f1577t);
                c0847j.I(20, oVar.f1578u);
                c0847j.I(21, oVar.f1579v);
                c0847j.I(22, oVar.f1580w);
                C0.d dVar2 = oVar.f1568j;
                if (dVar2 == null) {
                    c0847j.t(23);
                    c0847j.t(24);
                    c0847j.t(25);
                    c0847j.t(26);
                    c0847j.t(27);
                    c0847j.t(28);
                    c0847j.t(29);
                    c0847j.t(30);
                    return;
                }
                int i10 = dVar2.f143a;
                AbstractC0535a.p(i10, "networkType");
                int iC3 = AbstractC0882e.c(i10);
                if (iC3 != 0) {
                    i6 = 1;
                    if (iC3 != 1) {
                        i6 = 2;
                        if (iC3 != 2) {
                            i6 = 3;
                            if (iC3 != 3) {
                                i6 = 4;
                                if (iC3 != 4) {
                                    if (Build.VERSION.SDK_INT < 30 || i10 != 6) {
                                        throw new IllegalArgumentException("Could not convert " + AbstractC0535a.x(i10) + " to int");
                                    }
                                    i6 = 5;
                                }
                            }
                        }
                    }
                } else {
                    i6 = 0;
                }
                c0847j.I(23, i6);
                c0847j.I(24, dVar2.f144b ? 1L : 0L);
                c0847j.I(25, dVar2.f145c ? 1L : 0L);
                c0847j.I(26, dVar2.f146d ? 1L : 0L);
                c0847j.I(27, dVar2.f147e ? 1L : 0L);
                c0847j.I(28, dVar2.f148f);
                c0847j.I(29, dVar2.g);
                Set<C0.c> set = dVar2.h;
                F3.i.f(set, "triggers");
                if (set.isEmpty()) {
                    byteArray = new byte[0];
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeInt(set.size());
                            for (C0.c cVar : set) {
                                objectOutputStream.writeUTF(cVar.f140a.toString());
                                objectOutputStream.writeBoolean(cVar.f141b);
                            }
                            AbstractC0399v1.b(objectOutputStream, null);
                            AbstractC0399v1.b(byteArrayOutputStream, null);
                            byteArray = byteArrayOutputStream.toByteArray();
                            F3.i.e(byteArray, "outputStream.toByteArray()");
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            AbstractC0399v1.b(byteArrayOutputStream, th);
                            throw th2;
                        }
                    }
                }
                c0847j.M(30, byteArray);
                return;
            case 6:
                r rVar = (r) obj;
                String str8 = rVar.f1593a;
                if (str8 == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str8);
                }
                String str9 = rVar.f1594b;
                if (str9 == null) {
                    c0847j.t(2);
                    return;
                } else {
                    c0847j.h(2, str9);
                    return;
                }
            case 7:
                C0511d c0511d = (C0511d) obj;
                String str10 = c0511d.f6683a;
                if (str10 == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str10);
                }
                String str11 = c0511d.f6684b;
                if (str11 == null) {
                    c0847j.t(2);
                    return;
                } else {
                    c0847j.h(2, str11);
                    return;
                }
            case 8:
                C0518i c0518i = (C0518i) obj;
                c0847j.I(1, c0518i.f6721a);
                String str12 = c0518i.f6722b;
                if (str12 == null) {
                    c0847j.t(2);
                } else {
                    c0847j.h(2, str12);
                }
                String str13 = c0518i.f6723c;
                if (str13 == null) {
                    c0847j.t(3);
                } else {
                    c0847j.h(3, str13);
                }
                c0847j.I(4, c0518i.f6724d);
                String str14 = c0518i.f6725e;
                if (str14 == null) {
                    c0847j.t(5);
                } else {
                    c0847j.h(5, str14);
                }
                String str15 = c0518i.f6726f;
                if (str15 == null) {
                    c0847j.t(6);
                    return;
                } else {
                    c0847j.h(6, str15);
                    return;
                }
            default:
                C0776l c0776l = (C0776l) obj;
                c0847j.I(1, c0776l.f8616a);
                c0847j.I(2, c0776l.f8617b);
                String str16 = c0776l.f8618c;
                if (str16 == null) {
                    c0847j.t(3);
                } else {
                    c0847j.h(3, str16);
                }
                c0847j.I(4, c0776l.f8619d);
                return;
        }
    }
}
