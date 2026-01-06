package k3;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0713u implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8218c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8219d;

    public /* synthetic */ ViewOnClickListenerC0713u(LaunchActivity launchActivity, int i5) {
        this.f8218c = i5;
        this.f8219d = launchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LaunchActivity launchActivity = this.f8219d;
        switch (this.f8218c) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.Q0();
                break;
            case 1:
                launchActivity.f5950p.dismiss();
                break;
            case 2:
                launchActivity.f5910Z.setVisibility(0);
                launchActivity.f5910Z.setAlpha(BitmapDescriptorFactory.HUE_RED);
                launchActivity.f5910Z.animate().alpha(1.0f).setDuration(200L).start();
                break;
            case 3:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Overlay clicked - hiding popup");
                launchActivity.X();
                break;
            case 4:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "On the Air menu item clicked");
                launchActivity.X();
                launchActivity.OntheAir(view);
                break;
            case 5:
                Context context4 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Radio Teams menu item clicked");
                launchActivity.X();
                launchActivity.radioTeams(view);
                break;
            default:
                Context context5 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Messages menu item clicked");
                launchActivity.X();
                launchActivity.messageClicked(view);
                break;
        }
    }
}
