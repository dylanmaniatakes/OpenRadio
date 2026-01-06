package k3;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageButton;
import com.unified.ur1.R;

/* renamed from: k3.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0687g0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8131j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ B0.l f8132k;

    public /* synthetic */ RunnableC0687g0(B0.l lVar, int i5) {
        this.f8131j = i5;
        this.f8132k = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zG;
        switch (this.f8131j) {
            case 0:
                try {
                    if (!((Y) this.f8132k.f110d).f8098b.isFinishing() && !((Y) this.f8132k.f110d).f8098b.isDestroyed()) {
                        q2.k kVar = ((Y) this.f8132k.f110d).f8098b.f5890O;
                        if (kVar != null) {
                            X2.t tVarD = X2.t.d();
                            q2.e eVar = kVar.f9474v;
                            synchronized (tVarD.f2833c) {
                                zG = tVarD.g(eVar);
                            }
                            if (zG) {
                                ((Y) this.f8132k.f110d).f8098b.f5890O.a(3);
                                ((Y) this.f8132k.f110d).f8098b.f5890O = null;
                            }
                        }
                        ImageButton imageButton = (ImageButton) ((Y) this.f8132k.f110d).f8098b.findViewById(R.id.pttButton);
                        if (imageButton == null) {
                            Log.e("Unified - Main Activity", "PTT Button not found in layout");
                            return;
                        }
                        imageButton.post(new RunnableC0685f0(imageButton, 0));
                        if (((Y) this.f8132k.f110d).f8098b.isFinishing()) {
                            return;
                        }
                        new Handler(Looper.getMainLooper()).post(new C0.A(29, this));
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Error in radioInitialized: "), "Unified - Main Activity");
                    return;
                }
            default:
                try {
                    ImageButton imageButton2 = (ImageButton) ((Y) this.f8132k.f110d).f8098b.findViewById(R.id.pttButton);
                    if (imageButton2 != null) {
                        imageButton2.post(new RunnableC0685f0(imageButton2, 1));
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    com.unified.ur1.SatelliteTracker.h.o(e6, new StringBuilder("Error in radioMissing: "), "Unified - Main Activity");
                    return;
                }
        }
    }
}
