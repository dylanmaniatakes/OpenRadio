package L0;

import l0.AbstractC0737m;
import l0.AbstractC0740p;
import org.conscrypt.FileClientSessionCache;

/* loaded from: classes.dex */
public final class h extends AbstractC0740p {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1546d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(AbstractC0737m abstractC0737m, int i5) {
        super(abstractC0737m);
        this.f1546d = i5;
    }

    @Override // l0.AbstractC0740p
    public final String l() {
        switch (this.f1546d) {
            case 0:
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            case 1:
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            case 2:
                return "DELETE from WorkProgress where work_spec_id=?";
            case 3:
                return "DELETE FROM WorkProgress";
            case 4:
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            case 5:
                return "UPDATE workspec SET next_schedule_time_override=? WHERE id=?";
            case 6:
                return "UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)";
            case 7:
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            case 8:
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            case 9:
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            case 10:
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            case 11:
                return "UPDATE workspec SET stop_reason=? WHERE id=?";
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return "DELETE FROM workspec WHERE id=?";
            case o1.f.ERROR /* 13 */:
                return "UPDATE workspec SET state=? WHERE id=?";
            case o1.f.INTERRUPTED /* 14 */:
                return "UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?";
            case 15:
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            case 16:
                return "UPDATE workspec SET output=? WHERE id=?";
            case o1.f.API_NOT_CONNECTED /* 17 */:
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            case 18:
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                return "DELETE FROM worktag WHERE work_spec_id=?";
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                return "UPDATE recordings SET durationMs = ? WHERE id = ?";
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                return "DELETE FROM recordings WHERE timestamp < ?";
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                return "DELETE FROM recordings WHERE id IN (SELECT id FROM recordings ORDER BY timestamp ASC LIMIT (SELECT MAX(0, COUNT(*) - 20) FROM recordings))";
            default:
                return "UPDATE recordings SET durationMs = 120000 WHERE durationMs = 0 OR durationMs IS NULL OR durationMs > 300000";
        }
    }
}
