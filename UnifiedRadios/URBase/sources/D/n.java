package D;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import k3.U;
import k3.Z;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f222j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f223k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f224l;

    public /* synthetic */ n(int i5, int i6, Object obj) {
        this.f222j = i6;
        this.f224l = obj;
        this.f223k = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f223k;
        Object obj = this.f224l;
        switch (this.f222j) {
            case 0:
                ((b) obj).g(i5);
                break;
            case 1:
                ((SatelliteTrackerActivity) obj).lambda$updateSatelliteCalculations$9(i5);
                break;
            case 2:
                int i6 = UnifiedInboxActivity.f5830m;
                ((UnifiedInboxActivity) obj).q(i5 + 1);
                break;
            case 3:
                X2.n nVar = (X2.n) obj;
                if (((U) nVar.f2818a) != null) {
                    Log.d("Unified - DMR-CallerID", "Notifying listener of transmitter ID: " + i5);
                    U u4 = (U) nVar.f2818a;
                    u4.getClass();
                    Context context = LaunchActivity.f5853D1;
                    u4.f8056c.runOnUiThread(new n(i5, 4, u4));
                    break;
                }
                break;
            case 4:
                LaunchActivity launchActivity = ((U) obj).f8056c;
                TextView textView = (TextView) launchActivity.findViewById(R.id.CallerID);
                launchActivity.f5973x = textView;
                if (textView != null) {
                    textView.setText("ID = " + i5);
                }
                launchActivity.R(i5);
                break;
            case 5:
                ((Z) obj).f8099c.f5977y0.setProgress(i5);
                break;
            case 6:
                LaunchActivity launchActivity2 = (LaunchActivity) ((B0.l) obj).f110d;
                ProgressDialog progressDialog = launchActivity2.f5977y0;
                if (progressDialog != null && progressDialog.isShowing()) {
                    launchActivity2.f5977y0.setProgress(i5);
                    break;
                }
                break;
            case 7:
                ((m3.p) ((L0.m) obj).f1556d).b(i5);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.f5400p.get();
                if (view != null) {
                    sideSheetBehavior.t(view, i5, false);
                    break;
                }
                break;
        }
    }
}
