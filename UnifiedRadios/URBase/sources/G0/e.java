package G0;

import android.app.job.JobParameters;
import androidx.work.impl.background.systemjob.SystemJobService;
import o1.f;
import org.conscrypt.FileClientSessionCache;

/* loaded from: classes.dex */
public abstract class e {
    public static int a(JobParameters jobParameters) {
        int stopReason = jobParameters.getStopReason();
        String str = SystemJobService.g;
        switch (stopReason) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case FileClientSessionCache.MAX_SIZE /* 12 */:
            case f.ERROR /* 13 */:
            case f.INTERRUPTED /* 14 */:
            case 15:
                return stopReason;
            default:
                return -512;
        }
    }
}
