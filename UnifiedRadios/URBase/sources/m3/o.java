package m3;

import J1.ServiceConnectionC0075i0;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.rfmodule.DmrAudioService;
import com.unified.ur1.rfmodule.ROIP.DMRActivity;
import e0.HandlerC0430a;
import f3.C0519j;
import java.io.File;
import java.io.IOException;
import p3.C0836b;
import s2.C0890c;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8627j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f8628k;

    public /* synthetic */ o(int i5, Object obj) {
        this.f8627j = i5;
        this.f8628k = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f8628k;
        switch (this.f8627j) {
            case 0:
                L0.m mVar = (L0.m) obj;
                p pVar = (p) mVar.f1556d;
                C0764B c0764b = (C0764B) mVar.f1557e;
                try {
                    W3.j jVar = new W3.j(c0764b);
                    W3.k kVar = new W3.k(c0764b);
                    HandlerC0430a handlerC0430a = (HandlerC0430a) mVar.f1558f;
                    Z2.c cVar = new Z2.c(25, false);
                    cVar.f3147d = new s(jVar, kVar, handlerC0430a);
                    boolean zS = cVar.s(new File(Environment.getExternalStorageDirectory() + "/DMR_003.bin"));
                    if (pVar != null) {
                        if (zS) {
                            pVar.b(6);
                        } else {
                            pVar.b(7);
                        }
                    }
                    break;
                } catch (Exception e5) {
                    Log.e("FirmwareUpdateManager", "Update failed", e5);
                    if (pVar != null) {
                        pVar.b(7);
                        return;
                    }
                    return;
                }
            case 1:
                V1.d dVar = (V1.d) obj;
                dVar.f2526c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) dVar.f2528e;
                W.e eVar = sideSheetBehavior.f5394i;
                if (eVar != null && eVar.f()) {
                    dVar.c(dVar.f2525b);
                    break;
                } else if (sideSheetBehavior.h == 2) {
                    sideSheetBehavior.r(dVar.f2525b);
                    break;
                }
                break;
            case 2:
                DMRActivity dMRActivity = (DMRActivity) obj;
                TextView textView = dMRActivity.f6058f;
                if (textView != null) {
                    textView.setVisibility(4);
                    dMRActivity.f6058f.setText("");
                    break;
                }
                break;
            case 3:
                o3.x xVar = (o3.x) obj;
                xVar.f8997p.n(xVar.f8996o, xVar.f8988d, xVar.f8989e, xVar.f8990f);
                xVar.g.dismiss();
                break;
            case 4:
                X2.t tVar = (X2.t) obj;
                tVar.getClass();
                try {
                    C0519j c0519j = (C0519j) tVar.f2836f;
                    if (c0519j != null) {
                        int i5 = DmrAudioService.f6034u;
                        ((DmrAudioService) c0519j.f6730d).getClass();
                        Log.d("DmrAudioService", "Transmission connection state: ".concat("disconnected"));
                        break;
                    }
                } catch (IOException e6) {
                    Log.e("AudioTransmitter", "Error closing connection", e6);
                    return;
                }
                break;
            case 5:
                ((C0836b) ((ServiceConnectionC0075i0) obj).f1257c).a(null);
                break;
            case 6:
                ((C0890c) obj).t(true);
                break;
            case 7:
                s2.h hVar = (s2.h) obj;
                boolean zIsPopupShowing = hVar.h.isPopupShowing();
                hVar.t(zIsPopupShowing);
                hVar.f9599m = zIsPopupShowing;
                break;
            default:
                ((TextInputLayout) obj).f5447f.requestLayout();
                break;
        }
    }
}
