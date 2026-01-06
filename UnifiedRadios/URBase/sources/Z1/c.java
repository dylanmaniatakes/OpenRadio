package Z1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
public final class c extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f3079a;

    public c(Chip chip) {
        this.f3079a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        f fVar = this.f3079a.g;
        if (fVar != null) {
            fVar.getOutline(outline);
        } else {
            outline.setAlpha(BitmapDescriptorFactory.HUE_RED);
        }
    }
}
