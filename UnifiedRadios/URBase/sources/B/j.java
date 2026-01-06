package B;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.AsyncTask;
import android.util.Log;
import com.unified.ur1.primary.OptionsActivity;
import java.lang.ref.WeakReference;
import k3.E0;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class j extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47a;

    /* renamed from: b, reason: collision with root package name */
    public Object f48b;

    public /* synthetic */ j() {
        this.f47a = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0219 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r25) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B.j.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onCancelled(Object obj) {
        switch (this.f47a) {
            case 0:
                ((l) this.f48b).getClass();
                break;
            default:
                super.onCancelled(obj);
                break;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        switch (this.f47a) {
            case 0:
                ((l) this.f48b).getClass();
                break;
            case 1:
                String str = (String) obj;
                Activity activity = (Activity) ((WeakReference) this.f48b).get();
                if (activity != null && !activity.isFinishing()) {
                    activity.runOnUiThread(new D.m(activity, 16, str));
                    break;
                }
                break;
            default:
                String str2 = (String) obj;
                OptionsActivity optionsActivity = (OptionsActivity) this.f48b;
                if (!optionsActivity.isFinishing()) {
                    if (str2 == null || str2.isEmpty()) {
                        Log.w("Unified - Settings", "Failed to get server settings, using local values");
                        int i5 = OptionsActivity.f5981H;
                        optionsActivity.K();
                        optionsActivity.v();
                        optionsActivity.j();
                    } else {
                        Log.d("Unified - Settings", "Server settings response: ".concat(str2));
                        int i6 = OptionsActivity.f5981H;
                        try {
                            Log.d("Unified - Settings", "Parsing server response: ".concat(str2));
                            if (str2.trim().startsWith("{")) {
                                optionsActivity.t(new JSONObject(str2));
                            } else {
                                optionsActivity.u(str2);
                            }
                        } catch (Exception e5) {
                            Log.e("Unified - Settings", "Error parsing server settings: " + e5.getMessage());
                            Log.e("Unified - Settings", "Raw response: ".concat(str2));
                            optionsActivity.runOnUiThread(new E0(optionsActivity, 0));
                            optionsActivity.K();
                            optionsActivity.v();
                            optionsActivity.j();
                        }
                    }
                    int i7 = OptionsActivity.f5981H;
                    optionsActivity.O();
                    if (optionsActivity.s()) {
                        optionsActivity.M();
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ j(ContextWrapper contextWrapper, int i5) {
        this.f47a = i5;
        this.f48b = contextWrapper;
    }
}
