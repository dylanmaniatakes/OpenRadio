package k3;

import android.view.KeyEvent;
import android.view.View;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0699m0 implements View.OnKeyListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8168c;

    public ViewOnKeyListenerC0699m0(LaunchActivity launchActivity) {
        this.f8168c = launchActivity;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
        LaunchActivity launchActivity = this.f8168c;
        if (i5 == 140) {
            launchActivity.f5888N.f(1);
            return true;
        }
        if (i5 != 142) {
            return false;
        }
        launchActivity.f5888N.f(-1);
        return true;
    }
}
