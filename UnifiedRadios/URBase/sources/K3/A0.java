package k3;

import android.content.Intent;
import android.view.View;
import com.unified.ur1.adapters.LastHeardActivity;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class A0 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public long f7936c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f7937d;

    public A0(LaunchActivity launchActivity) {
        this.f7937d = launchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f7936c < 300) {
            LaunchActivity launchActivity = this.f7937d;
            launchActivity.startActivity(new Intent(launchActivity, (Class<?>) LastHeardActivity.class));
        }
        this.f7936c = jCurrentTimeMillis;
    }
}
