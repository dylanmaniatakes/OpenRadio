package k3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.RadioAudioService;
import f3.C0511d;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: k3.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0697l0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ C0511d f8154j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0511d f8155k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0511d f8156l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0511d f8157m;
    public final /* synthetic */ C0511d n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0511d f8158o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ C0511d f8159p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ C0511d f8160q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ C0511d f8161r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ C0511d f8162s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ T f8163t;

    public RunnableC0697l0(T t4, C0511d c0511d, C0511d c0511d2, C0511d c0511d3, C0511d c0511d4, C0511d c0511d5, C0511d c0511d6, C0511d c0511d7, C0511d c0511d8, C0511d c0511d9, C0511d c0511d10) {
        this.f8163t = t4;
        this.f8154j = c0511d;
        this.f8155k = c0511d2;
        this.f8156l = c0511d3;
        this.f8157m = c0511d4;
        this.n = c0511d5;
        this.f8158o = c0511d6;
        this.f8159p = c0511d7;
        this.f8160q = c0511d8;
        this.f8161r = c0511d9;
        this.f8162s = c0511d10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        T t4 = this.f8163t;
        C0511d c0511d = this.f8154j;
        if (c0511d != null) {
            LaunchActivity launchActivity = t4.f8021k;
            String str = c0511d.f6684b;
            launchActivity.f5900U = str;
            int length = str.length();
            LaunchActivity launchActivity2 = t4.f8021k;
            if (length == 0) {
                launchActivity2.findViewById(R.id.sendButton).setEnabled(false);
                launchActivity2.findViewById(R.id.sendButtonOverlay).setVisibility(0);
            } else {
                launchActivity2.findViewById(R.id.sendButton).setEnabled(true);
                launchActivity2.findViewById(R.id.sendButtonOverlay).setVisibility(8);
            }
            RadioAudioService radioAudioService = launchActivity2.f5965u;
        }
        C0511d c0511d2 = this.f8155k;
        if (c0511d2 != null && !c0511d2.f6684b.equals("")) {
            LaunchActivity launchActivity3 = t4.f8021k;
            Context context = LaunchActivity.f5853D1;
            launchActivity3.getClass();
        }
        C0511d c0511d3 = this.f8156l;
        if (c0511d3 == null || c0511d3.f6684b.equals("-1")) {
            LaunchActivity launchActivity4 = t4.f8021k;
            launchActivity4.f5925f0 = -1;
            C0511d c0511d4 = this.f8157m;
            if (c0511d4 != null) {
                launchActivity4.f5897S = c0511d4.f6684b;
            } else {
                launchActivity4.f5897S = "440.00000";
            }
            RadioAudioService radioAudioService2 = launchActivity4.f5965u;
            if (radioAudioService2 != null) {
                radioAudioService2.f6089k = -1;
                radioAudioService2.e(radioAudioService2.f6088j, radioAudioService2.f6087i, false);
                LaunchActivity launchActivity5 = t4.f8021k;
                RadioAudioService radioAudioService3 = launchActivity5.f5965u;
                String str2 = launchActivity5.f5897S;
                radioAudioService3.f6087i = str2;
                int i5 = radioAudioService3.f6089k;
                if (i5 > -1) {
                    radioAudioService3.f(i5, radioAudioService3.f6088j, false);
                } else {
                    radioAudioService3.e(radioAudioService3.f6088j, str2, false);
                }
            }
        } else {
            t4.f8021k.f5925f0 = Integer.parseInt(c0511d3.f6684b);
            LaunchActivity launchActivity6 = t4.f8021k;
            RadioAudioService radioAudioService4 = launchActivity6.f5965u;
            if (radioAudioService4 != null) {
                int i6 = launchActivity6.f5925f0;
                radioAudioService4.f6089k = i6;
                if (i6 > -1) {
                    radioAudioService4.f(i6, radioAudioService4.f6088j, false);
                } else {
                    radioAudioService4.e(radioAudioService4.f6088j, radioAudioService4.f6087i, false);
                }
            }
        }
        C0511d c0511d5 = this.n;
        if (c0511d5 != null) {
            t4.f8021k.f5899T = Integer.parseInt(c0511d5.f6684b);
        }
        LaunchActivity launchActivity7 = t4.f8021k;
        int i7 = launchActivity7.f5925f0;
        LaunchActivity launchActivity8 = t4.f8021k;
        if (i7 > -1) {
            RadioAudioService radioAudioService5 = launchActivity7.f5965u;
            if (radioAudioService5 != null) {
                radioAudioService5.f(i7, launchActivity7.f5899T, radioAudioService5.f6086f == 0);
                launchActivity8.I0(launchActivity8.f5925f0);
            }
        } else {
            RadioAudioService radioAudioService6 = launchActivity7.f5965u;
            if (radioAudioService6 != null) {
                radioAudioService6.e(launchActivity7.f5899T, launchActivity7.f5897S, radioAudioService6.f6086f == 0);
                launchActivity8.H0(launchActivity8.f5897S);
            }
        }
        RadioAudioService radioAudioService7 = launchActivity8.f5965u;
        C0511d c0511d6 = this.f8158o;
        boolean z4 = c0511d6 != null ? Boolean.parseBoolean(c0511d6.f6684b) : true;
        C0511d c0511d7 = this.f8159p;
        boolean z5 = c0511d7 != null ? Boolean.parseBoolean(c0511d7.f6684b) : true;
        C0511d c0511d8 = this.f8160q;
        boolean z6 = c0511d8 != null ? Boolean.parseBoolean(c0511d8.f6684b) : true;
        ThreadPoolExecutor threadPoolExecutor = launchActivity8.f5922e0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new RunnableC0695k0(this, z4, z5, z6));
        }
        C0511d c0511d9 = this.f8161r;
        if (c0511d9 != null) {
            launchActivity8.f5902V = Boolean.parseBoolean(c0511d9.f6684b);
        }
        C0511d c0511d10 = this.f8162s;
        if (c0511d10 != null) {
            launchActivity8.f5904W = Boolean.parseBoolean(c0511d10.f6684b);
            if (launchActivity8.f5904W) {
                ImageView imageView = (ImageView) launchActivity8.findViewById(R.id.rxAudioCircle);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.width = 0;
                marginLayoutParams.height = 0;
                imageView.setLayoutParams(marginLayoutParams);
                if (launchActivity8.f5904W) {
                    return;
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0693j0(launchActivity8), 100);
            }
        }
    }
}
