package k3;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final class Z implements U1.d, m3.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8099c;

    public /* synthetic */ Z(LaunchActivity launchActivity) {
        this.f8099c = launchActivity;
    }

    @Override // m3.p
    public void b(int i5) {
        LaunchActivity launchActivity = this.f8099c;
        if (launchActivity.f5977y0 != null) {
            launchActivity.runOnUiThread(new D.n(i5, 5, this));
        }
    }

    @Override // i2.i
    public boolean d(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        LaunchActivity launchActivity = this.f8099c;
        if (itemId == R.id.voice_mode) {
            LaunchActivity.B(launchActivity);
        } else if (itemId == R.id.text_chat_mode) {
            Toast.makeText(launchActivity, "Data Transmissions Coming Soon!", 1).show();
            LaunchActivity.B(launchActivity);
        } else if (itemId == R.id.text_memories) {
            Context context = LaunchActivity.f5853D1;
            launchActivity.w0();
        }
        return true;
    }
}
