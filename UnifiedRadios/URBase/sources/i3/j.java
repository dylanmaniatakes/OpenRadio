package i3;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0524o;

/* loaded from: classes.dex */
public final class j implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7309c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7310d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f7311e;

    public /* synthetic */ j(int i5, int i6, Object obj) {
        this.f7309c = i6;
        this.f7311e = obj;
        this.f7310d = i5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) throws Throwable {
        switch (this.f7309c) {
            case 0:
                ((m) this.f7311e).g.notifyItemChanged(this.f7310d);
                dialogInterface.dismiss();
                return;
            case 1:
                C0524o c0524o = ((UnifiedInboxActivity) this.f7311e).g;
                if (c0524o != null) {
                    c0524o.notifyItemChanged(this.f7310d);
                }
                dialogInterface.dismiss();
                return;
            default:
                int i6 = this.f7310d;
                String strValueOf = String.valueOf(i6);
                LaunchActivity launchActivity = (LaunchActivity) this.f7311e;
                h4.c.f0(launchActivity, false);
                if (strValueOf.isEmpty()) {
                    return;
                }
                TextView textView = (TextView) launchActivity.findViewById(R.id.activeFrequency);
                TextView textView2 = (TextView) launchActivity.findViewById(R.id.activeMemoryName);
                TextView textView3 = (TextView) launchActivity.findViewById(R.id.network);
                try {
                    h4.c.U(launchActivity, i6);
                    String strY = h4.c.y(LaunchActivity.f5853D1);
                    ProgressDialog progressDialog = new ProgressDialog(launchActivity);
                    launchActivity.f5977y0 = progressDialog;
                    progressDialog.setTitle("🔄 Establishing Connection");
                    launchActivity.f5977y0.setMessage("Please wait while we establish the link.");
                    launchActivity.f5977y0.setProgressStyle(0);
                    launchActivity.f5977y0.setCancelable(false);
                    launchActivity.f5977y0.show();
                    if (strY == null || !strY.toLowerCase().contains("brandmeister")) {
                        launchActivity.f5915b1.f();
                        launchActivity.m0();
                        final int i7 = 1;
                        new Handler().postDelayed(new Runnable(this) { // from class: k3.P

                            /* renamed from: k, reason: collision with root package name */
                            public final /* synthetic */ i3.j f8006k;

                            {
                                this.f8006k = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i7) {
                                    case 0:
                                        LaunchActivity launchActivity2 = (LaunchActivity) this.f8006k.f7311e;
                                        ProgressDialog progressDialog2 = launchActivity2.f5977y0;
                                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                                            h4.c.f0(launchActivity2, false);
                                            LaunchActivity.f5854E1 = false;
                                            launchActivity2.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                    default:
                                        LaunchActivity launchActivity3 = (LaunchActivity) this.f8006k.f7311e;
                                        ProgressDialog progressDialog3 = launchActivity3.f5977y0;
                                        if (progressDialog3 != null && progressDialog3.isShowing()) {
                                            launchActivity3.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                }
                            }
                        }, 2000L);
                    } else {
                        launchActivity.f5915b1.subscribeTalkgroup(i6);
                        launchActivity.q0(i6);
                        final int i8 = 0;
                        new Handler().postDelayed(new Runnable(this) { // from class: k3.P

                            /* renamed from: k, reason: collision with root package name */
                            public final /* synthetic */ i3.j f8006k;

                            {
                                this.f8006k = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i8) {
                                    case 0:
                                        LaunchActivity launchActivity2 = (LaunchActivity) this.f8006k.f7311e;
                                        ProgressDialog progressDialog2 = launchActivity2.f5977y0;
                                        if (progressDialog2 != null && progressDialog2.isShowing()) {
                                            h4.c.f0(launchActivity2, false);
                                            LaunchActivity.f5854E1 = false;
                                            launchActivity2.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                    default:
                                        LaunchActivity launchActivity3 = (LaunchActivity) this.f8006k.f7311e;
                                        ProgressDialog progressDialog3 = launchActivity3.f5977y0;
                                        if (progressDialog3 != null && progressDialog3.isShowing()) {
                                            launchActivity3.f5977y0.dismiss();
                                            break;
                                        }
                                        break;
                                }
                            }
                        }, 1500L);
                    }
                    String str = "TG: " + i6;
                    textView.setText(str);
                    if (str.length() > 8) {
                        textView.setTextSize(1, Math.max(Math.max(0.5f, 8.0f / str.length()) * 60.0f, 24.0f));
                    } else {
                        textView.setTextSize(1, 60.0f);
                    }
                    textView2.setText("Manual Entry");
                    h4.c.b0(launchActivity, "Manual Entry");
                    h4.c.a0(launchActivity, str);
                    textView3.setText(h4.c.y(launchActivity) + " - " + h4.c.z(launchActivity));
                    StringBuilder sb = new StringBuilder("✅ Connecting to TG ");
                    sb.append(i6);
                    q2.k kVarG = q2.k.g(null, launchActivity.findViewById(android.R.id.content), sb.toString(), -1);
                    kVarG.h(C.d.a(launchActivity, R.color.accent_green));
                    kVarG.i(-1);
                    kVarG.j();
                    return;
                } catch (Exception e5) {
                    throw new RuntimeException(e5);
                }
        }
    }
}
