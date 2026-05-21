package f;

import O.K;
import O.Y;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.WeakHashMap;

/* renamed from: f.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0461G extends A2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6258a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0463I f6259b;

    public /* synthetic */ C0461G(C0463I c0463i, int i5) {
        this.f6258a = i5;
        this.f6259b = c0463i;
    }

    @Override // O.InterfaceC0171j0
    public final void a() {
        View view;
        C0463I c0463i = this.f6259b;
        switch (this.f6258a) {
            case 0:
                if (c0463i.f6276o && (view = c0463i.g) != null) {
                    view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                    c0463i.f6268d.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                }
                c0463i.f6268d.setVisibility(8);
                c0463i.f6268d.setTransitioning(false);
                c0463i.f6281t = null;
                i.a aVar = c0463i.f6273k;
                if (aVar != null) {
                    aVar.b(c0463i.f6272j);
                    c0463i.f6272j = null;
                    c0463i.f6273k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = c0463i.f6267c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = Y.f1904a;
                    K.c(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                c0463i.f6281t = null;
                c0463i.f6268d.requestLayout();
                break;
        }
    }
}
