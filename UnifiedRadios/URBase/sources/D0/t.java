package D0;

import android.database.SQLException;
import androidx.work.impl.WorkDatabase_Impl;
import com.unified.ur1.adapters.AppDatabase_Impl;
import com.unified.ur1.rfmodule.DmrDatabase_Impl;
import j1.C0599a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import l0.AbstractC0737m;
import n0.C0779a;
import n0.C0780b;
import n0.C0782d;
import n0.C0783e;
import q0.C0840c;

/* loaded from: classes.dex */
public final class t extends X1.e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f295b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0737m f296c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(AbstractC0737m abstractC0737m, int i5) {
        super(1);
        this.f295b = i5;
        this.f296c = abstractC0737m;
    }

    @Override // X1.e
    public final void a(C0840c c0840c) throws SQLException {
        switch (this.f295b) {
            case 0:
                c0840c.x("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                c0840c.x("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                c0840c.x("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                c0840c.x("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                c0840c.x("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                c0840c.x("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                c0840c.x("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                c0840c.x("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                c0840c.x("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                c0840c.x("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                c0840c.x("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                c0840c.x("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                c0840c.x("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                c0840c.x("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                c0840c.x("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
                break;
            case 1:
                c0840c.x("CREATE TABLE IF NOT EXISTS `app_settings` (`name` TEXT NOT NULL, `value` TEXT, PRIMARY KEY(`name`))");
                c0840c.x("CREATE TABLE IF NOT EXISTS `channel_memories` (`memoryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `frequency` TEXT, `offset` INTEGER NOT NULL, `tone` TEXT, `group` TEXT)");
                c0840c.x("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                c0840c.x("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '862991907bde1659f05d5d9c10a88ff5')");
                break;
            default:
                c0840c.x("CREATE TABLE IF NOT EXISTS `recordings` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `filename` TEXT, `durationMs` INTEGER NOT NULL)");
                c0840c.x("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                c0840c.x("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dc6bd07a0b4e2e6591f4494432739c35')");
                break;
        }
    }

    @Override // X1.e
    public final void b(C0840c c0840c) throws SQLException {
        switch (this.f295b) {
            case 0:
                c0840c.x("DROP TABLE IF EXISTS `Dependency`");
                c0840c.x("DROP TABLE IF EXISTS `WorkSpec`");
                c0840c.x("DROP TABLE IF EXISTS `WorkTag`");
                c0840c.x("DROP TABLE IF EXISTS `SystemIdInfo`");
                c0840c.x("DROP TABLE IF EXISTS `WorkName`");
                c0840c.x("DROP TABLE IF EXISTS `WorkProgress`");
                c0840c.x("DROP TABLE IF EXISTS `Preference`");
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f296c;
                List list = workDatabase_Impl.f8371f;
                if (list != null) {
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((b) workDatabase_Impl.f8371f.get(i5)).getClass();
                    }
                    break;
                }
                break;
            case 1:
                c0840c.x("DROP TABLE IF EXISTS `app_settings`");
                c0840c.x("DROP TABLE IF EXISTS `channel_memories`");
                List list2 = ((AppDatabase_Impl) this.f296c).f8371f;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).getClass();
                    }
                    break;
                }
                break;
            default:
                c0840c.x("DROP TABLE IF EXISTS `recordings`");
                List list3 = ((DmrDatabase_Impl) this.f296c).f8371f;
                if (list3 != null) {
                    Iterator it2 = list3.iterator();
                    while (it2.hasNext()) {
                        ((b) it2.next()).getClass();
                    }
                    break;
                }
                break;
        }
    }

    @Override // X1.e
    public final void h(C0840c c0840c) {
        switch (this.f295b) {
            case 0:
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f296c;
                List list = workDatabase_Impl.f8371f;
                if (list != null) {
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((b) workDatabase_Impl.f8371f.get(i5)).getClass();
                    }
                    break;
                }
                break;
            case 1:
                List list2 = ((AppDatabase_Impl) this.f296c).f8371f;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).getClass();
                    }
                    break;
                }
                break;
            default:
                List list3 = ((DmrDatabase_Impl) this.f296c).f8371f;
                if (list3 != null) {
                    Iterator it2 = list3.iterator();
                    while (it2.hasNext()) {
                        ((b) it2.next()).getClass();
                    }
                    break;
                }
                break;
        }
    }

    @Override // X1.e
    public final void i(C0840c c0840c) throws SQLException {
        switch (this.f295b) {
            case 0:
                ((WorkDatabase_Impl) this.f296c).f8366a = c0840c;
                c0840c.x("PRAGMA foreign_keys = ON");
                ((WorkDatabase_Impl) this.f296c).l(c0840c);
                List list = ((WorkDatabase_Impl) this.f296c).f8371f;
                if (list != null) {
                    int size = list.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((b) ((WorkDatabase_Impl) this.f296c).f8371f.get(i5)).a(c0840c);
                    }
                    break;
                }
                break;
            case 1:
                ((AppDatabase_Impl) this.f296c).f8366a = c0840c;
                ((AppDatabase_Impl) this.f296c).l(c0840c);
                List list2 = ((AppDatabase_Impl) this.f296c).f8371f;
                if (list2 != null) {
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a(c0840c);
                    }
                    break;
                }
                break;
            default:
                ((DmrDatabase_Impl) this.f296c).f8366a = c0840c;
                ((DmrDatabase_Impl) this.f296c).l(c0840c);
                List list3 = ((DmrDatabase_Impl) this.f296c).f8371f;
                if (list3 != null) {
                    Iterator it2 = list3.iterator();
                    while (it2.hasNext()) {
                        ((b) it2.next()).a(c0840c);
                    }
                    break;
                }
                break;
        }
    }

    @Override // X1.e
    public final void j(C0840c c0840c) throws SQLException {
        switch (this.f295b) {
            case 0:
                Z3.i.c(c0840c);
                break;
            case 1:
                Z3.i.c(c0840c);
                break;
            default:
                Z3.i.c(c0840c);
                break;
        }
    }

    @Override // X1.e
    public final C0599a k(C0840c c0840c) {
        switch (this.f295b) {
            case 0:
                HashMap map = new HashMap(2);
                map.put("work_spec_id", new C0779a("work_spec_id", "TEXT", true, 1, null, 1));
                map.put("prerequisite_id", new C0779a("prerequisite_id", "TEXT", true, 2, null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new C0780b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                hashSet.add(new C0780b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new C0782d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                hashSet2.add(new C0782d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
                C0783e c0783e = new C0783e("Dependency", map, hashSet, hashSet2);
                C0783e c0783eA = C0783e.a(c0840c, "Dependency");
                if (!c0783e.equals(c0783eA)) {
                    break;
                } else {
                    HashMap map2 = new HashMap(30);
                    map2.put("id", new C0779a("id", "TEXT", true, 1, null, 1));
                    map2.put("state", new C0779a("state", "INTEGER", true, 0, null, 1));
                    map2.put("worker_class_name", new C0779a("worker_class_name", "TEXT", true, 0, null, 1));
                    map2.put("input_merger_class_name", new C0779a("input_merger_class_name", "TEXT", true, 0, null, 1));
                    map2.put("input", new C0779a("input", "BLOB", true, 0, null, 1));
                    map2.put("output", new C0779a("output", "BLOB", true, 0, null, 1));
                    map2.put("initial_delay", new C0779a("initial_delay", "INTEGER", true, 0, null, 1));
                    map2.put("interval_duration", new C0779a("interval_duration", "INTEGER", true, 0, null, 1));
                    map2.put("flex_duration", new C0779a("flex_duration", "INTEGER", true, 0, null, 1));
                    map2.put("run_attempt_count", new C0779a("run_attempt_count", "INTEGER", true, 0, null, 1));
                    map2.put("backoff_policy", new C0779a("backoff_policy", "INTEGER", true, 0, null, 1));
                    map2.put("backoff_delay_duration", new C0779a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
                    map2.put("last_enqueue_time", new C0779a("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
                    map2.put("minimum_retention_duration", new C0779a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
                    map2.put("schedule_requested_at", new C0779a("schedule_requested_at", "INTEGER", true, 0, null, 1));
                    map2.put("run_in_foreground", new C0779a("run_in_foreground", "INTEGER", true, 0, null, 1));
                    map2.put("out_of_quota_policy", new C0779a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
                    map2.put("period_count", new C0779a("period_count", "INTEGER", true, 0, "0", 1));
                    map2.put("generation", new C0779a("generation", "INTEGER", true, 0, "0", 1));
                    map2.put("next_schedule_time_override", new C0779a("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
                    map2.put("next_schedule_time_override_generation", new C0779a("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
                    map2.put("stop_reason", new C0779a("stop_reason", "INTEGER", true, 0, "-256", 1));
                    map2.put("required_network_type", new C0779a("required_network_type", "INTEGER", true, 0, null, 1));
                    map2.put("requires_charging", new C0779a("requires_charging", "INTEGER", true, 0, null, 1));
                    map2.put("requires_device_idle", new C0779a("requires_device_idle", "INTEGER", true, 0, null, 1));
                    map2.put("requires_battery_not_low", new C0779a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
                    map2.put("requires_storage_not_low", new C0779a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
                    map2.put("trigger_content_update_delay", new C0779a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
                    map2.put("trigger_max_content_delay", new C0779a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
                    map2.put("content_uri_triggers", new C0779a("content_uri_triggers", "BLOB", true, 0, null, 1));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(2);
                    hashSet4.add(new C0782d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
                    hashSet4.add(new C0782d("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
                    C0783e c0783e2 = new C0783e("WorkSpec", map2, hashSet3, hashSet4);
                    C0783e c0783eA2 = C0783e.a(c0840c, "WorkSpec");
                    if (!c0783e2.equals(c0783eA2)) {
                        break;
                    } else {
                        HashMap map3 = new HashMap(2);
                        map3.put("tag", new C0779a("tag", "TEXT", true, 1, null, 1));
                        map3.put("work_spec_id", new C0779a("work_spec_id", "TEXT", true, 2, null, 1));
                        HashSet hashSet5 = new HashSet(1);
                        hashSet5.add(new C0780b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                        HashSet hashSet6 = new HashSet(1);
                        hashSet6.add(new C0782d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                        C0783e c0783e3 = new C0783e("WorkTag", map3, hashSet5, hashSet6);
                        C0783e c0783eA3 = C0783e.a(c0840c, "WorkTag");
                        if (!c0783e3.equals(c0783eA3)) {
                            break;
                        } else {
                            HashMap map4 = new HashMap(3);
                            map4.put("work_spec_id", new C0779a("work_spec_id", "TEXT", true, 1, null, 1));
                            map4.put("generation", new C0779a("generation", "INTEGER", true, 2, "0", 1));
                            map4.put("system_id", new C0779a("system_id", "INTEGER", true, 0, null, 1));
                            HashSet hashSet7 = new HashSet(1);
                            hashSet7.add(new C0780b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                            C0783e c0783e4 = new C0783e("SystemIdInfo", map4, hashSet7, new HashSet(0));
                            C0783e c0783eA4 = C0783e.a(c0840c, "SystemIdInfo");
                            if (!c0783e4.equals(c0783eA4)) {
                                break;
                            } else {
                                HashMap map5 = new HashMap(2);
                                map5.put("name", new C0779a("name", "TEXT", true, 1, null, 1));
                                map5.put("work_spec_id", new C0779a("work_spec_id", "TEXT", true, 2, null, 1));
                                HashSet hashSet8 = new HashSet(1);
                                hashSet8.add(new C0780b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                HashSet hashSet9 = new HashSet(1);
                                hashSet9.add(new C0782d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
                                C0783e c0783e5 = new C0783e("WorkName", map5, hashSet8, hashSet9);
                                C0783e c0783eA5 = C0783e.a(c0840c, "WorkName");
                                if (!c0783e5.equals(c0783eA5)) {
                                    break;
                                } else {
                                    HashMap map6 = new HashMap(2);
                                    map6.put("work_spec_id", new C0779a("work_spec_id", "TEXT", true, 1, null, 1));
                                    map6.put("progress", new C0779a("progress", "BLOB", true, 0, null, 1));
                                    HashSet hashSet10 = new HashSet(1);
                                    hashSet10.add(new C0780b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
                                    C0783e c0783e6 = new C0783e("WorkProgress", map6, hashSet10, new HashSet(0));
                                    C0783e c0783eA6 = C0783e.a(c0840c, "WorkProgress");
                                    if (!c0783e6.equals(c0783eA6)) {
                                        break;
                                    } else {
                                        HashMap map7 = new HashMap(2);
                                        map7.put("key", new C0779a("key", "TEXT", true, 1, null, 1));
                                        map7.put("long_value", new C0779a("long_value", "INTEGER", false, 0, null, 1));
                                        C0783e c0783e7 = new C0783e("Preference", map7, new HashSet(0), new HashSet(0));
                                        C0783e c0783eA7 = C0783e.a(c0840c, "Preference");
                                        if (!c0783e7.equals(c0783eA7)) {
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            case 1:
                HashMap map8 = new HashMap(2);
                map8.put("name", new C0779a("name", "TEXT", true, 1, null, 1));
                map8.put("value", new C0779a("value", "TEXT", false, 0, null, 1));
                C0783e c0783e8 = new C0783e("app_settings", map8, new HashSet(0), new HashSet(0));
                C0783e c0783eA8 = C0783e.a(c0840c, "app_settings");
                if (!c0783e8.equals(c0783eA8)) {
                    break;
                } else {
                    HashMap map9 = new HashMap(6);
                    map9.put("memoryId", new C0779a("memoryId", "INTEGER", true, 1, null, 1));
                    map9.put("name", new C0779a("name", "TEXT", false, 0, null, 1));
                    map9.put("frequency", new C0779a("frequency", "TEXT", false, 0, null, 1));
                    map9.put("offset", new C0779a("offset", "INTEGER", true, 0, null, 1));
                    map9.put("tone", new C0779a("tone", "TEXT", false, 0, null, 1));
                    map9.put("group", new C0779a("group", "TEXT", false, 0, null, 1));
                    C0783e c0783e9 = new C0783e("channel_memories", map9, new HashSet(0), new HashSet(0));
                    C0783e c0783eA9 = C0783e.a(c0840c, "channel_memories");
                    if (!c0783e9.equals(c0783eA9)) {
                        break;
                    } else {
                        break;
                    }
                }
            default:
                HashMap map10 = new HashMap(4);
                map10.put("id", new C0779a("id", "INTEGER", true, 1, null, 1));
                map10.put("timestamp", new C0779a("timestamp", "INTEGER", true, 0, null, 1));
                map10.put("filename", new C0779a("filename", "TEXT", false, 0, null, 1));
                map10.put("durationMs", new C0779a("durationMs", "INTEGER", true, 0, null, 1));
                C0783e c0783e10 = new C0783e("recordings", map10, new HashSet(0), new HashSet(0));
                C0783e c0783eA10 = C0783e.a(c0840c, "recordings");
                if (!c0783e10.equals(c0783eA10)) {
                    break;
                } else {
                    break;
                }
        }
        return new C0599a(null, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(WorkDatabase_Impl workDatabase_Impl) {
        super(20);
        this.f295b = 0;
        this.f296c = workDatabase_Impl;
    }
}
