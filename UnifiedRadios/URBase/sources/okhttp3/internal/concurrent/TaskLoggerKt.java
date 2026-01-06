package okhttp3.internal.concurrent;

import E3.a;
import F3.i;
import java.util.Arrays;
import java.util.logging.Level;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public final class TaskLoggerKt {
    public static final String formatDuration(long j5) {
        String str;
        if (j5 <= -999500000) {
            str = ((j5 - 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        } else if (j5 <= -999500) {
            str = ((j5 - 500000) / 1000000) + " ms";
        } else if (j5 <= 0) {
            str = ((j5 - 500) / 1000) + " µs";
        } else if (j5 < 999500) {
            str = ((j5 + 500) / 1000) + " µs";
        } else if (j5 < 999500000) {
            str = ((j5 + 500000) / 1000000) + " ms";
        } else {
            str = ((j5 + 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        }
        return String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        TaskRunner.Companion.getLogger().fine(taskQueue.getName$okhttp() + ' ' + String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1)) + ": " + task.getName());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, a aVar) {
        long jNanoTime;
        i.f(task, "task");
        i.f(taskQueue, "queue");
        i.f(aVar, "block");
        boolean zIsLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jNanoTime = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            jNanoTime = -1;
        }
        try {
            T t4 = (T) aVar.invoke();
            if (zIsLoggable) {
                log(task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime));
            }
            return t4;
        } catch (Throwable th) {
            if (zIsLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - jNanoTime));
            }
            throw th;
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, a aVar) {
        i.f(task, "task");
        i.f(taskQueue, "queue");
        i.f(aVar, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, (String) aVar.invoke());
        }
    }
}
