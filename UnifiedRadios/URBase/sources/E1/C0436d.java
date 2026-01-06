package e1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import h4.r;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

/* renamed from: e1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0436d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6156a;

    /* renamed from: b, reason: collision with root package name */
    public final f1.d f6157b;

    /* renamed from: c, reason: collision with root package name */
    public final C0434b f6158c;

    public C0436d(Context context, f1.d dVar, C0434b c0434b) {
        this.f6156a = context;
        this.f6157b = dVar;
        this.f6158c = c0434b;
    }

    public final void a(Y0.i iVar, int i5, boolean z4) {
        Context context = this.f6156a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(iVar.f2912a.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        V0.d dVar = iVar.f2914c;
        adler32.update(byteBufferAllocate.putInt(i1.a.a(dVar)).array());
        byte[] bArr = iVar.f2913b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z4) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i6 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i6 >= i5) {
                        r.g("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", iVar);
                        return;
                    }
                }
            }
        }
        SQLiteDatabase sQLiteDatabaseA = ((f1.j) this.f6157b).a();
        String strValueOf = String.valueOf(i1.a.a(dVar));
        String str = iVar.f2912a;
        Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str, strValueOf});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            C0434b c0434b = this.f6158c;
            builder.setMinimumLatency(c0434b.a(dVar, jLongValue, i5));
            Set set = ((C0435c) c0434b.f6152b.get(dVar)).f6155c;
            if (set.contains(EnumC0437e.f6159j)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(EnumC0437e.f6161l)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(EnumC0437e.f6160k)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i5);
            persistableBundle.putString("backendName", str);
            persistableBundle.putInt("priority", i1.a.a(dVar));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {iVar, Integer.valueOf(value), Long.valueOf(c0434b.a(dVar, jLongValue, i5)), lValueOf, Integer.valueOf(i5)};
            String strConcat = "TRuntime.".concat("JobInfoScheduler");
            if (Log.isLoggable(strConcat, 3)) {
                Log.d(strConcat, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }
}
