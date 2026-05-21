package F0;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import k3.O;

/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f523j;

    /* renamed from: k, reason: collision with root package name */
    public final int f524k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f525l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f526m;

    public /* synthetic */ j(Object obj, int i5, Object obj2, int i6) {
        this.f523j = i6;
        this.f526m = obj;
        this.f524k = i5;
        this.f525l = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        androidx.activity.result.b bVar;
        switch (this.f523j) {
            case 0:
                ((l) this.f525l).a((Intent) this.f526m, this.f524k);
                return;
            case 1:
                ((SystemForegroundService) this.f526m).g.notify(this.f524k, (Notification) this.f525l);
                return;
            case 2:
                ((BottomSheetBehavior) this.f526m).E((View) this.f525l, this.f524k, false);
                return;
            case 3:
                Object obj = ((P.i) this.f525l).f2057a;
                androidx.activity.g gVar = (androidx.activity.g) this.f526m;
                String str = (String) gVar.f3265a.get(Integer.valueOf(this.f524k));
                if (str == null) {
                    return;
                }
                androidx.activity.result.e eVar = (androidx.activity.result.e) gVar.f3269e.get(str);
                if (eVar == null || (bVar = eVar.f3261a) == null) {
                    gVar.g.remove(str);
                    gVar.f3270f.put(str, obj);
                    return;
                } else {
                    if (gVar.f3268d.remove(str)) {
                        bVar.e(obj);
                        return;
                    }
                    return;
                }
            case 4:
                ((androidx.activity.g) this.f526m).a(this.f524k, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f525l));
                return;
            case 5:
                ((TextView) this.f525l).setTypeface((Typeface) this.f526m, this.f524k);
                return;
            default:
                Log.d("UR Broadcast", "ROIP PTT sound completed - checking transmission state");
                synchronized (((O) this.f526m).f8001b) {
                    if (!((O) this.f526m).f8001b.O0 && ((O) this.f526m).f8001b.f5885L0 && ((O) this.f526m).f8001b.f5972w1) {
                        Log.d("UR Broadcast", "Starting DMR transmission after ROIP PTT sound");
                        try {
                            ((DMRBridge) this.f525l).A(this.f524k);
                            ((O) this.f526m).f8001b.f5889N0 = true;
                            Log.d("UR Broadcast", "DMR transmission actually started");
                        } catch (Exception e5) {
                            Log.e("UR Broadcast", "Error starting DMR transmission", e5);
                            ((O) this.f526m).f8001b.f5889N0 = false;
                        }
                    } else {
                        Log.w("UR Broadcast", "Transmission was cancelled during audio playback - cancelled: " + ((O) this.f526m).f8001b.O0 + ", inProgress: " + ((O) this.f526m).f8001b.f5885L0 + ", pttPressed: " + ((O) this.f526m).f8001b.f5972w1);
                        ((O) this.f526m).f8001b.f5889N0 = false;
                    }
                }
                return;
        }
    }

    public /* synthetic */ j(Object obj, Object obj2, int i5, int i6) {
        this.f523j = i6;
        this.f525l = obj;
        this.f526m = obj2;
        this.f524k = i5;
    }

    public /* synthetic */ j(Object obj, Object obj2, int i5, int i6, boolean z4) {
        this.f523j = i6;
        this.f526m = obj;
        this.f525l = obj2;
        this.f524k = i5;
    }
}
