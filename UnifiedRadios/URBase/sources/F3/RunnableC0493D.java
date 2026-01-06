package f3;

import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.adapters.MemoryChannelActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: f3.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0493D implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6553j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ MemoryChannelActivity f6554k;

    public /* synthetic */ RunnableC0493D(MemoryChannelActivity memoryChannelActivity, int i5) {
        this.f6553j = i5;
        this.f6554k = memoryChannelActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = 1;
        MemoryChannelActivity memoryChannelActivity = this.f6554k;
        switch (this.f6553j) {
            case 0:
                HashSet hashSet = memoryChannelActivity.f5687j;
                ArrayList arrayList = memoryChannelActivity.f5685f;
                try {
                    try {
                        String strH = h4.c.h(memoryChannelActivity);
                        if (strH != null && !strH.isEmpty()) {
                            memoryChannelActivity.j(strH);
                        }
                        h4.f.l(memoryChannelActivity, arrayList);
                    } catch (Exception e5) {
                        Log.e("Unified - MemoryChannel", "Error fetching from server", e5);
                        ArrayList arrayListH = h4.f.h(memoryChannelActivity);
                        if (arrayListH.isEmpty()) {
                            memoryChannelActivity.runOnUiThread(new RunnableC0493D(memoryChannelActivity, 2));
                        } else {
                            arrayList.addAll(arrayListH);
                            Iterator it = arrayListH.iterator();
                            while (it.hasNext()) {
                                hashSet.add(((C0532x) it.next()).f6829b);
                            }
                            memoryChannelActivity.runOnUiThread(new RunnableC0493D(memoryChannelActivity, i5));
                        }
                    }
                    memoryChannelActivity.n(hashSet);
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - MemoryChannel", "Error in fetchMemoryChannels", e6);
                    memoryChannelActivity.runOnUiThread(new D.m(memoryChannelActivity, 23, e6));
                    return;
                }
                break;
            case 1:
                int i6 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                Toast.makeText(memoryChannelActivity, "Using cached channels from " + new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date(memoryChannelActivity.getSharedPreferences("memory_channel_cache", 0).getLong("last_update_time", 0L))), 1).show();
                break;
            default:
                int i7 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                Toast.makeText(memoryChannelActivity, "No internet connection and no cached channels available", 1).show();
                break;
        }
    }
}
