package R2;

import B.t;
import O.J0;
import O.U;
import O.Y;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import f3.f0;
import java.io.IOException;
import java.util.Iterator;
import java.util.WeakHashMap;
import k3.O;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2281j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f2282k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2283l;

    public /* synthetic */ c(int i5, Object obj) {
        this.f2281j = i5;
        this.f2283l = obj;
        this.f2282k = false;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        S2.b bVarW;
        S2.b bVarB;
        J0 j02 = null;
        switch (this.f2281j) {
            case 0:
                d dVar = (d) this.f2283l;
                boolean z4 = this.f2282k;
                dVar.getClass();
                Object obj = d.f2284m;
                synchronized (obj) {
                    try {
                        A2.g gVar = dVar.f2285a;
                        gVar.a();
                        L0.e eVarG = L0.e.g(gVar.f26a);
                        try {
                            bVarW = dVar.f2287c.w();
                            if (eVarG != null) {
                                eVarG.r();
                            }
                        } catch (Throwable th) {
                            if (eVarG != null) {
                                eVarG.r();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    int i5 = bVarW.f2369b;
                    if (i5 == 5 || i5 == 3) {
                        bVarB = dVar.g(bVarW);
                    } else if (!z4 && !dVar.f2288d.a(bVarW)) {
                        return;
                    } else {
                        bVarB = dVar.b(bVarW);
                    }
                    synchronized (obj) {
                        try {
                            A2.g gVar2 = dVar.f2285a;
                            gVar2.a();
                            L0.e eVarG2 = L0.e.g(gVar2.f26a);
                            try {
                                dVar.f2287c.j(bVarB);
                                if (eVarG2 != null) {
                                    eVarG2.r();
                                }
                            } catch (Throwable th2) {
                                if (eVarG2 != null) {
                                    eVarG2.r();
                                }
                                throw th2;
                            }
                        } finally {
                        }
                    }
                    synchronized (dVar) {
                        if (dVar.f2293k.size() != 0 && !TextUtils.equals(bVarW.f2368a, bVarB.f2368a)) {
                            Iterator it = dVar.f2293k.iterator();
                            if (it.hasNext()) {
                                com.unified.ur1.SatelliteTracker.h.p(it.next());
                                throw null;
                            }
                        }
                    }
                    if (bVarB.f2369b == 4) {
                        String str = bVarB.f2368a;
                        synchronized (dVar) {
                            dVar.f2292j = str;
                        }
                    }
                    int i6 = bVarB.f2369b;
                    if (i6 == 5) {
                        dVar.h(new f());
                        return;
                    } else if (i6 == 2 || i6 == 1) {
                        dVar.h(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        dVar.i(bVarB);
                        return;
                    }
                } catch (f e5) {
                    dVar.h(e5);
                    return;
                }
            case 1:
                f0 f0Var = (f0) this.f2283l;
                f0Var.notifyDataSetChanged();
                Toast.makeText(f0Var.f6710b, "Repeater marked as ".concat(this.f2282k ? "offline" : "online"), 0).show();
                return;
            case 2:
                boolean z5 = this.f2282k;
                View view = (View) this.f2283l;
                if (z5) {
                    WeakHashMap weakHashMap = Y.f1904a;
                    if (Build.VERSION.SDK_INT >= 30) {
                        j02 = U.b(view);
                    } else {
                        Context context = view.getContext();
                        while (true) {
                            if (context instanceof ContextWrapper) {
                                if (context instanceof Activity) {
                                    Window window = ((Activity) context).getWindow();
                                    if (window != null) {
                                        j02 = new J0(window, view);
                                    }
                                } else {
                                    context = ((ContextWrapper) context).getBaseContext();
                                }
                            }
                        }
                    }
                    if (j02 != null) {
                        j02.f1899a.m();
                        return;
                    }
                }
                ((InputMethodManager) C.d.b(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
                return;
            case 3:
                Context context2 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = (LaunchActivity) this.f2283l;
                launchActivity.f5929h0 = (TextView) launchActivity.findViewById(R.id.IP);
                ImageView imageView = (ImageView) launchActivity.findViewById(R.id.ip_image1);
                ImageView imageView2 = (ImageView) launchActivity.findViewById(R.id.ip_image2);
                ImageView imageView3 = (ImageView) launchActivity.findViewById(R.id.ip_image3);
                if (this.f2282k) {
                    launchActivity.f5929h0.setTextColor(Color.parseColor("#008f00"));
                    imageView.setVisibility(0);
                    imageView2.setVisibility(8);
                    imageView3.setVisibility(8);
                    launchActivity.f5860A = 1;
                    return;
                }
                launchActivity.f5929h0.setTextColor(-65536);
                imageView3.setVisibility(0);
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
                launchActivity.f5860A = 0;
                return;
            case 4:
                LaunchActivity launchActivity2 = ((O) this.f2283l).f8001b;
                if (this.f2282k) {
                    launchActivity2.f5915b1.setMyTalkerAlias("Joe N4KYS (CJ-1)");
                    Log.i("MainActivity", "Updating UI - ROIP is CONNECTED");
                    launchActivity2.l0();
                    return;
                } else {
                    Context context3 = LaunchActivity.f5853D1;
                    launchActivity2.getClass();
                    Log.i("MainActivity", "Updating UI - ROIP is DISCONNECTED");
                    return;
                }
            default:
                int i7 = DmrAudioService.f6034u;
                DmrAudioService dmrAudioService = (DmrAudioService) this.f2283l;
                dmrAudioService.getClass();
                String str2 = this.f2282k ? "Recording in progress" : "Radio service standby";
                PendingIntent activity = PendingIntent.getActivity(dmrAudioService, 0, new Intent(dmrAudioService, (Class<?>) LaunchActivity.class), 67108864);
                t tVar = new t(dmrAudioService, "DmrAudioService");
                tVar.f68e = t.b("ComJoT/Unified Radios");
                tVar.f82v.icon = android.R.drawable.ic_lock_silent_mode_off;
                tVar.f71j = 1;
                tVar.n = "service";
                tVar.f80t = 1;
                tVar.c(2, true);
                tVar.f69f = t.b(str2);
                tVar.g = activity;
                try {
                    if (Build.VERSION.SDK_INT >= 29) {
                        dmrAudioService.startForeground(1, tVar.a(), 130);
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    Log.e("DmrAudioService", "Error starting foreground service", e6);
                    return;
                }
        }
    }

    public /* synthetic */ c(Object obj, boolean z4, int i5) {
        this.f2281j = i5;
        this.f2283l = obj;
        this.f2282k = z4;
    }
}
