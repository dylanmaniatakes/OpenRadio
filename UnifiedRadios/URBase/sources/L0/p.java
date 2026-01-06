package L0;

import f3.C0511d;
import l0.AbstractC0728d;
import l0.AbstractC0737m;
import m3.C0776l;
import q0.C0847j;

/* loaded from: classes.dex */
public final class p extends AbstractC0728d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1581d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(AbstractC0737m abstractC0737m, int i5) {
        super(abstractC0737m);
        this.f1581d = i5;
    }

    @Override // l0.AbstractC0740p
    public final String l() {
        switch (this.f1581d) {
            case 0:
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            case 1:
                return "DELETE FROM `app_settings` WHERE `name` = ?";
            case 2:
                return "UPDATE OR ABORT `app_settings` SET `name` = ?,`value` = ? WHERE `name` = ?";
            case 3:
                return "DELETE FROM `channel_memories` WHERE `memoryId` = ?";
            case 4:
                return "UPDATE OR ABORT `channel_memories` SET `memoryId` = ?,`name` = ?,`frequency` = ?,`offset` = ?,`tone` = ?,`group` = ? WHERE `memoryId` = ?";
            default:
                return "DELETE FROM `recordings` WHERE `id` = ?";
        }
    }

    @Override // l0.AbstractC0728d
    public void q(C0847j c0847j, Object obj) {
        switch (this.f1581d) {
            case 2:
                C0511d c0511d = (C0511d) obj;
                String str = c0511d.f6683a;
                if (str == null) {
                    c0847j.t(1);
                } else {
                    c0847j.h(1, str);
                }
                String str2 = c0511d.f6684b;
                if (str2 == null) {
                    c0847j.t(2);
                } else {
                    c0847j.h(2, str2);
                }
                String str3 = c0511d.f6683a;
                if (str3 != null) {
                    c0847j.h(3, str3);
                    break;
                } else {
                    c0847j.t(3);
                    break;
                }
            default:
                c0847j.I(1, ((C0776l) obj).f8616a);
                break;
        }
    }
}
