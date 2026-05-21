package k;

import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: k.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0621b implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7749j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f7750k;

    public /* synthetic */ RunnableC0621b(ActionBarOverlayLayout actionBarOverlayLayout, int i5) {
        this.f7749j = i5;
        this.f7750k = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7749j) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f7750k;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.f3359y = actionBarOverlayLayout.f3343f.animate().translationY(BitmapDescriptorFactory.HUE_RED).setListener(actionBarOverlayLayout.f3360z);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f7750k;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.f3359y = actionBarOverlayLayout2.f3343f.animate().translationY(-actionBarOverlayLayout2.f3343f.getHeight()).setListener(actionBarOverlayLayout2.f3360z);
                break;
        }
    }
}
