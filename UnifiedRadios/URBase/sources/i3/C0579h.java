package i3;

import android.os.Bundle;
import androidx.fragment.app.Y;

/* renamed from: i3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0579h implements Y, u0.j {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f7305c;

    @Override // androidx.fragment.app.Y
    public void a(Bundle bundle, String str) {
        m mVar = this.f7305c;
        mVar.getClass();
        if (bundle.getBoolean("should_refresh", false)) {
            mVar.i();
        }
    }

    @Override // u0.j
    public void g() {
        this.f7305c.i();
    }
}
