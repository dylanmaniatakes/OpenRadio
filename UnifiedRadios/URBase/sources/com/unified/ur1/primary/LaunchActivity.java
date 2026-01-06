package com.unified.ur1.primary;

import A2.i;
import B0.r;
import C.d;
import C0.e;
import D0.f;
import J1.R0;
import J1.V0;
import L.h;
import L0.m;
import N1.l;
import N1.p;
import O.J;
import X2.n;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.lifecycle.A;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.gson.Gson;
import com.hebs.dmrserial.jni.SerialPort;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.R;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import com.unified.ur1.rfmodule.RadioAudioService;
import com.unified.ur1.rfmodule.RecordingsActivity;
import e0.C0432c;
import f.AbstractActivityC0472i;
import f.C0467d;
import f.DialogC0469f;
import f3.C0513e;
import f3.C0515f;
import f3.C0518i;
import f3.C0525p;
import f3.DialogInterfaceOnClickListenerC0516g;
import f3.E0;
import f3.o0;
import g0.AbstractC0535a;
import g3.ViewOnTouchListenerC0549B;
import h1.C0559c;
import h4.c;
import i3.C0573b;
import i3.DialogInterfaceOnClickListenerC0580i;
import i3.InterfaceC0572a;
import i3.j;
import i3.u;
import j0.RunnableC0588a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k3.B0;
import k3.C0;
import k3.C0679c0;
import k3.C0714u0;
import k3.DialogInterfaceOnClickListenerC0681d0;
import k3.DialogInterfaceOnClickListenerC0711t;
import k3.DialogInterfaceOnDismissListenerC0683e0;
import k3.F;
import k3.G;
import k3.O;
import k3.Q;
import k3.RunnableC0672A;
import k3.RunnableC0691i0;
import k3.RunnableC0696l;
import k3.RunnableC0701n0;
import k3.RunnableC0702o;
import k3.RunnableC0704p;
import k3.RunnableC0709s;
import k3.RunnableC0712t0;
import k3.S;
import k3.T;
import k3.V;
import k3.ViewOnClickListenerC0713u;
import k3.ViewOnKeyListenerC0699m0;
import k3.W;
import k3.Y;
import k3.x0;
import k3.y0;
import k3.z0;
import m3.C0768d;
import m3.C0774j;
import m3.HandlerThreadC0778n;
import o3.k;
import o3.s;
import o3.v;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* loaded from: classes.dex */
public class LaunchActivity extends AbstractActivityC0472i implements InterfaceC0572a, k {

    /* renamed from: D1, reason: collision with root package name */
    public static Context f5853D1 = null;

    /* renamed from: E1, reason: collision with root package name */
    public static boolean f5854E1 = false;

    /* renamed from: F1, reason: collision with root package name */
    public static boolean f5855F1 = false;
    public static final int G1;

    /* renamed from: H1, reason: collision with root package name */
    public static final int f5856H1;
    public static String I1;

    /* renamed from: J1, reason: collision with root package name */
    public static final int f5857J1;

    /* renamed from: K1, reason: collision with root package name */
    public static final int f5858K1;

    /* renamed from: L1, reason: collision with root package name */
    public static final int f5859L1;

    /* renamed from: A0, reason: collision with root package name */
    public final O f5861A0;

    /* renamed from: A1, reason: collision with root package name */
    public final String f5862A1;

    /* renamed from: B0, reason: collision with root package name */
    public final O f5864B0;

    /* renamed from: B1, reason: collision with root package name */
    public final x0 f5865B1;

    /* renamed from: C0, reason: collision with root package name */
    public final HashMap f5867C0;

    /* renamed from: C1, reason: collision with root package name */
    public final y0 f5868C1;

    /* renamed from: D0, reason: collision with root package name */
    public final HashMap f5870D0;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f5872E0;

    /* renamed from: F0, reason: collision with root package name */
    public CardView f5874F0;

    /* renamed from: G0, reason: collision with root package name */
    public TextView f5876G0;

    /* renamed from: H0, reason: collision with root package name */
    public int f5878H0;

    /* renamed from: I0, reason: collision with root package name */
    public final Handler f5879I0;

    /* renamed from: J0, reason: collision with root package name */
    public RunnableC0696l f5881J0;

    /* renamed from: K0, reason: collision with root package name */
    public final O f5883K0;

    /* renamed from: L0, reason: collision with root package name */
    public volatile boolean f5885L0;

    /* renamed from: M0, reason: collision with root package name */
    public F f5887M0;

    /* renamed from: N, reason: collision with root package name */
    public C0513e f5888N;

    /* renamed from: N0, reason: collision with root package name */
    public volatile boolean f5889N0;
    public volatile boolean O0;

    /* renamed from: P0, reason: collision with root package name */
    public MediaPlayer f5892P0;

    /* renamed from: Q, reason: collision with root package name */
    public DTMFKeypad f5893Q;

    /* renamed from: Q0, reason: collision with root package name */
    public O f5894Q0;

    /* renamed from: R0, reason: collision with root package name */
    public boolean f5896R0;

    /* renamed from: S0, reason: collision with root package name */
    public long f5898S0;
    public long T0;

    /* renamed from: U0, reason: collision with root package name */
    public volatile boolean f5901U0;

    /* renamed from: V0, reason: collision with root package name */
    public final Object f5903V0;

    /* renamed from: W0, reason: collision with root package name */
    public Thread f5905W0;

    /* renamed from: X0, reason: collision with root package name */
    public m f5907X0;

    /* renamed from: Y, reason: collision with root package name */
    public RelativeLayout f5908Y;

    /* renamed from: Y0, reason: collision with root package name */
    public Gson f5909Y0;

    /* renamed from: Z, reason: collision with root package name */
    public View f5910Z;

    /* renamed from: Z0, reason: collision with root package name */
    public View f5911Z0;

    /* renamed from: a0, reason: collision with root package name */
    public LinearLayout f5912a0;

    /* renamed from: a1, reason: collision with root package name */
    public PowerManager.WakeLock f5913a1;

    /* renamed from: b0, reason: collision with root package name */
    public LinearLayout f5914b0;

    /* renamed from: b1, reason: collision with root package name */
    public DMRBridge f5915b1;

    /* renamed from: c, reason: collision with root package name */
    public C0774j f5916c;

    /* renamed from: c0, reason: collision with root package name */
    public LinearLayout f5917c0;
    public final Handler c1;

    /* renamed from: d, reason: collision with root package name */
    public HandlerThreadC0778n f5918d;

    /* renamed from: d0, reason: collision with root package name */
    public C0 f5919d0;

    /* renamed from: d1, reason: collision with root package name */
    public T f5920d1;

    /* renamed from: e1, reason: collision with root package name */
    public final Handler f5923e1;

    /* renamed from: f1, reason: collision with root package name */
    public T f5926f1;

    /* renamed from: g1, reason: collision with root package name */
    public boolean f5928g1;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f5929h0;

    /* renamed from: h1, reason: collision with root package name */
    public DmrAudioService f5930h1;

    /* renamed from: i0, reason: collision with root package name */
    public ObjectAnimator f5932i0;

    /* renamed from: i1, reason: collision with root package name */
    public final Y f5933i1;

    /* renamed from: j0, reason: collision with root package name */
    public ScaleAnimation f5935j0;

    /* renamed from: j1, reason: collision with root package name */
    public final Y f5936j1;

    /* renamed from: k0, reason: collision with root package name */
    public TextView f5938k0;
    public final ExecutorService k1;

    /* renamed from: l0, reason: collision with root package name */
    public TextView f5940l0;

    /* renamed from: l1, reason: collision with root package name */
    public ScheduledExecutorService f5941l1;

    /* renamed from: m0, reason: collision with root package name */
    public FusedLocationProviderClient f5943m0;

    /* renamed from: m1, reason: collision with root package name */
    public O f5944m1;

    /* renamed from: n0, reason: collision with root package name */
    public float f5945n0;

    /* renamed from: n1, reason: collision with root package name */
    public Handler f5946n1;

    /* renamed from: o0, reason: collision with root package name */
    public float f5948o0;

    /* renamed from: o1, reason: collision with root package name */
    public int f5949o1;

    /* renamed from: p, reason: collision with root package name */
    public Dialog f5950p;

    /* renamed from: p0, reason: collision with root package name */
    public List f5951p0;

    /* renamed from: p1, reason: collision with root package name */
    public boolean f5952p1;

    /* renamed from: q0, reason: collision with root package name */
    public long f5954q0;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f5955q1;

    /* renamed from: r, reason: collision with root package name */
    public TextView f5956r;

    /* renamed from: r0, reason: collision with root package name */
    public String f5957r0;

    /* renamed from: r1, reason: collision with root package name */
    public final T f5958r1;

    /* renamed from: s, reason: collision with root package name */
    public C0573b f5959s;

    /* renamed from: s0, reason: collision with root package name */
    public O f5960s0;

    /* renamed from: s1, reason: collision with root package name */
    public DialogC0469f f5961s1;

    /* renamed from: t, reason: collision with root package name */
    public BroadcastReceiver f5962t;

    /* renamed from: t0, reason: collision with root package name */
    public O f5963t0;

    /* renamed from: t1, reason: collision with root package name */
    public DialogC0469f f5964t1;

    /* renamed from: u, reason: collision with root package name */
    public RadioAudioService f5965u;

    /* renamed from: u0, reason: collision with root package name */
    public O f5966u0;

    /* renamed from: u1, reason: collision with root package name */
    public String f5967u1;

    /* renamed from: v, reason: collision with root package name */
    public C0768d f5968v;
    public O v0;

    /* renamed from: v1, reason: collision with root package name */
    public final Y f5969v1;

    /* renamed from: w0, reason: collision with root package name */
    public C0432c f5971w0;

    /* renamed from: w1, reason: collision with root package name */
    public boolean f5972w1;

    /* renamed from: x, reason: collision with root package name */
    public TextView f5973x;

    /* renamed from: x0, reason: collision with root package name */
    public O f5974x0;

    /* renamed from: x1, reason: collision with root package name */
    public final HashMap f5975x1;

    /* renamed from: y, reason: collision with root package name */
    public ImageView f5976y;

    /* renamed from: y0, reason: collision with root package name */
    public ProgressDialog f5977y0;

    /* renamed from: y1, reason: collision with root package name */
    public final double[] f5978y1;

    /* renamed from: z, reason: collision with root package name */
    public n f5979z;
    public final O z0;

    /* renamed from: z1, reason: collision with root package name */
    public final int[] f5980z1;

    /* renamed from: e, reason: collision with root package name */
    public int f5921e = 1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5924f = false;
    public boolean g = true;
    public String h = "";

    /* renamed from: i, reason: collision with root package name */
    public String f5931i = "off";

    /* renamed from: j, reason: collision with root package name */
    public String f5934j = "no";

    /* renamed from: k, reason: collision with root package name */
    public String f5937k = "off";

    /* renamed from: l, reason: collision with root package name */
    public final String f5939l = "off";

    /* renamed from: m, reason: collision with root package name */
    public String f5942m = "";
    public String n = "";

    /* renamed from: o, reason: collision with root package name */
    public int f5947o = 1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5953q = false;

    /* renamed from: w, reason: collision with root package name */
    public String f5970w = "";

    /* renamed from: A, reason: collision with root package name */
    public int f5860A = 1;

    /* renamed from: B, reason: collision with root package name */
    public int f5863B = 0;

    /* renamed from: C, reason: collision with root package name */
    public boolean f5866C = false;

    /* renamed from: D, reason: collision with root package name */
    public boolean f5869D = true;

    /* renamed from: E, reason: collision with root package name */
    public int f5871E = 0;

    /* renamed from: F, reason: collision with root package name */
    public long f5873F = 0;

    /* renamed from: G, reason: collision with root package name */
    public int f5875G = 0;

    /* renamed from: H, reason: collision with root package name */
    public int f5877H = 0;
    public int I = 0;

    /* renamed from: J, reason: collision with root package name */
    public int f5880J = 0;

    /* renamed from: K, reason: collision with root package name */
    public int f5882K = 0;

    /* renamed from: L, reason: collision with root package name */
    public int f5884L = 0;

    /* renamed from: M, reason: collision with root package name */
    public int f5886M = 0;

    /* renamed from: O, reason: collision with root package name */
    public q2.k f5890O = null;

    /* renamed from: P, reason: collision with root package name */
    public q2.k f5891P = null;

    /* renamed from: R, reason: collision with root package name */
    public boolean f5895R = false;

    /* renamed from: S, reason: collision with root package name */
    public String f5897S = "144.00000";

    /* renamed from: T, reason: collision with root package name */
    public int f5899T = 0;

    /* renamed from: U, reason: collision with root package name */
    public String f5900U = null;

    /* renamed from: V, reason: collision with root package name */
    public boolean f5902V = false;

    /* renamed from: W, reason: collision with root package name */
    public boolean f5904W = false;

    /* renamed from: X, reason: collision with root package name */
    public boolean f5906X = false;

    /* renamed from: e0, reason: collision with root package name */
    public ThreadPoolExecutor f5922e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    public int f5925f0 = -1;

    /* renamed from: g0, reason: collision with root package name */
    public int f5927g0 = 0;

    public interface a {
        @GET("messages/{callsign}")
        Call<Object> getMessages(@Path("callsign") String str, @Query("offset") int i5, @Query("limit") int i6);
    }

    static {
        Visualizer.getMaxCaptureRate();
        G1 = 500;
        f5856H1 = 200;
        I1 = "";
        f5857J1 = Color.parseColor("#A8F4A8");
        f5858K1 = Color.parseColor("#FFF4A3");
        f5859L1 = Color.parseColor("#FFB3B3");
    }

    public LaunchActivity() {
        int i5 = 0;
        new Handler();
        this.f5945n0 = BitmapDescriptorFactory.HUE_RED;
        this.f5948o0 = BitmapDescriptorFactory.HUE_RED;
        this.f5951p0 = new ArrayList();
        this.f5954q0 = 0L;
        this.f5957r0 = "";
        this.z0 = new O(this, 7);
        this.f5861A0 = new O(this, 10);
        this.f5864B0 = new O(this, 11);
        this.f5867C0 = new HashMap();
        this.f5870D0 = new HashMap();
        this.f5872E0 = false;
        this.f5878H0 = 0;
        this.f5879I0 = new Handler(Looper.getMainLooper());
        this.f5883K0 = new O(this, 14);
        this.f5885L0 = false;
        this.f5887M0 = new F();
        this.f5889N0 = false;
        this.O0 = false;
        this.f5892P0 = null;
        new Handler();
        this.f5894Q0 = new O(this, i5);
        this.f5896R0 = false;
        this.f5898S0 = 0L;
        this.T0 = 0L;
        this.f5901U0 = false;
        this.f5903V0 = new Object();
        this.f5905W0 = null;
        this.c1 = new Handler();
        this.f5923e1 = new Handler();
        this.f5928g1 = false;
        this.f5933i1 = new Y(this, i5);
        this.f5936j1 = new Y(this, 1);
        this.k1 = Executors.newSingleThreadExecutor();
        this.f5944m1 = new O(this, 9);
        this.f5946n1 = new Handler();
        this.f5949o1 = 0;
        this.f5952p1 = false;
        this.f5955q1 = false;
        this.f5958r1 = new T(this, 4);
        this.f5961s1 = null;
        this.f5964t1 = null;
        this.f5967u1 = null;
        this.f5969v1 = new Y(this, 2);
        this.f5972w1 = false;
        this.f5975x1 = new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        this.f5978y1 = new double[]{67.0d, 71.9d, 74.4d, 77.0d, 79.7d, 82.5d, 85.4d, 88.5d, 91.5d, 94.8d, 97.4d, 100.0d, 103.5d, 107.2d, 110.9d, 114.8d, 118.8d, 123.0d, 127.3d, 131.8d, 136.5d, 141.3d, 146.2d, 151.4d, 156.7d, 162.2d, 167.9d, 173.8d, 179.9d, 186.2d, 192.8d, 203.5d, 210.7d, 218.1d, 225.7d, 233.6d, 241.8d, 250.3d};
        this.f5980z1 = new int[]{23, 25, 26, 31, 32, 36, 43, 47, 51, 53, 54, 65, 71, 72, 73, 74, 114, 115, 116, 122, 125, 131, 132, 134, 143, 145, 152, 155, 156, 162, 165, 172, 174, 205, 212, 223, 225, 226, 243, 244, 245, 246, 251, 252, 255, 261, 263, 265, 266, 271, 274, 306, 311, 315, 325, 331, 332, 343, 346, 351, 356, 364, 365, 371, 411, 412, 413, 423, 431, 432, 445, 446, 452, 454, 455, 462, 464, 465, 466, 503, 506, 516, 523, 526, 532, 546, 565, 606, 612, 624, 627, 631, 632, 654, 662, 664, 703, 712, 723, 731, 732, 734, 743, 754};
        this.f5862A1 = "DMR";
        this.f5865B1 = new x0(this);
        this.f5868C1 = new y0(this);
        new O(this, 12);
        new O(this, 13);
    }

    public static void A(LaunchActivity launchActivity, v vVar, String str, s sVar) throws Throwable {
        launchActivity.getClass();
        c.p0(launchActivity, "ROIP");
        c.M(launchActivity, 2);
        c.r0(launchActivity, str);
        c.W(launchActivity, str);
        c.s0(launchActivity, sVar.f8951b);
        c.Q(launchActivity, sVar.f8952c);
        c.U(launchActivity, Integer.parseInt(vVar.f8968c));
        String str2 = vVar.f8968c;
        c.w0(launchActivity, Integer.parseInt(str2));
        String str3 = vVar.f8969d;
        c.C(launchActivity).edit().putString("contact_description", str3).apply();
        c.C(launchActivity).edit().putString("dmr_contact_type", "Group").apply();
        c.b0(launchActivity, str3);
        ((TextView) launchActivity.findViewById(R.id.activeMemoryName)).setText(str3);
        Log.d("ROIP", String.format("Selected - TG: %s (%s), Server: %s (%s:%d), Network: %s", vVar.f8968c, vVar.f8969d, sVar.f8951b, sVar.f8952c, Integer.valueOf(sVar.f8953d), str));
        q2.k kVarG = q2.k.g(null, launchActivity.findViewById(android.R.id.content), "ROIP Activated: TG " + str2 + " on " + sVar.f8951b, -1);
        kVarG.h(d.a(launchActivity, R.color.accent_green));
        kVarG.i(-1);
        kVarG.j();
        launchActivity.m0();
    }

    public static void B(LaunchActivity launchActivity) {
        launchActivity.findViewById(R.id.voiceModeLineHolder).setVisibility(0);
        launchActivity.findViewById(R.id.voiceModeBottomControls).setVisibility(0);
        launchActivity.findViewById(R.id.textModeContainer).setVisibility(8);
        q2.k kVar = launchActivity.f5891P;
        if (kVar != null) {
            kVar.a(3);
        }
    }

    public static void C(LaunchActivity launchActivity) {
        boolean z4 = !launchActivity.f5872E0;
        launchActivity.f5872E0 = z4;
        if (!z4) {
            launchActivity.J0();
            return;
        }
        View view = launchActivity.f5911Z0;
        if (view != null) {
            view.setVisibility(0);
            ((ImageView) launchActivity.findViewById(R.id.lock_icon)).setVisibility(0);
            launchActivity.f5911Z0.setAlpha(BitmapDescriptorFactory.HUE_RED);
            launchActivity.f5911Z0.animate().alpha(0.6f).setDuration(300L).start();
            launchActivity.f5911Z0.setClickable(true);
            launchActivity.f5911Z0.setFocusable(true);
        }
    }

    public static void D(LaunchActivity launchActivity) {
        launchActivity.getClass();
        String.valueOf(c.E(launchActivity));
        String str = String.format("%.5f", Double.valueOf(c.E(launchActivity) / 1000000.0d));
        Log.e("Unified - Main Activity", "UpdateTXFreq = ".concat(str));
        launchActivity.runOnUiThread(new RunnableC0701n0(launchActivity, str, 2));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e A[Catch: NumberFormatException -> 0x005c, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x005c, blocks: (B:4:0x000a, B:6:0x0012, B:9:0x0019, B:12:0x005e), top: B:17:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String F(com.unified.ur1.primary.LaunchActivity r18, java.lang.String r19) {
        /*
            r1 = r19
            r18.getClass()
            r2 = 0
            java.lang.String r3 = "Unified - Main Activity"
            if (r1 == 0) goto L5e
            java.lang.String r0 = "null"
            boolean r0 = r1.equals(r0)     // Catch: java.lang.NumberFormatException -> L5c
            if (r0 != 0) goto L5e
            boolean r0 = r19.isEmpty()     // Catch: java.lang.NumberFormatException -> L5c
            if (r0 == 0) goto L19
            goto L5e
        L19:
            double r4 = java.lang.Double.parseDouble(r19)     // Catch: java.lang.NumberFormatException -> L5c
            r6 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r8 = r4 % r6
            double r8 = r8 + r6
            double r8 = r8 % r6
            java.lang.String r16 = "West"
            java.lang.String r17 = "Northwest"
            java.lang.String r10 = "North"
            java.lang.String r11 = "Northeast"
            java.lang.String r12 = "East"
            java.lang.String r13 = "Southeast"
            java.lang.String r14 = "South"
            java.lang.String r15 = "Southwest"
            java.lang.String[] r0 = new java.lang.String[]{r10, r11, r12, r13, r14, r15, r16, r17}     // Catch: java.lang.NumberFormatException -> L5c
            r6 = 4631530004285489152(0x4046800000000000, double:45.0)
            double r8 = r8 / r6
            long r6 = java.lang.Math.round(r8)     // Catch: java.lang.NumberFormatException -> L5c
            int r6 = (int) r6     // Catch: java.lang.NumberFormatException -> L5c
            int r6 = r6 % 8
            r0 = r0[r6]     // Catch: java.lang.NumberFormatException -> L5c
            java.lang.String r6 = "Bearing from API: %.2f degrees = %s"
            java.lang.Double r4 = java.lang.Double.valueOf(r4)     // Catch: java.lang.NumberFormatException -> L5c
            java.lang.Object[] r4 = new java.lang.Object[]{r4, r0}     // Catch: java.lang.NumberFormatException -> L5c
            java.lang.String r4 = java.lang.String.format(r6, r4)     // Catch: java.lang.NumberFormatException -> L5c
            android.util.Log.d(r3, r4)     // Catch: java.lang.NumberFormatException -> L5c
            r2 = r0
            goto L75
        L5c:
            r0 = move-exception
            goto L64
        L5e:
            java.lang.String r0 = "No bearing available"
            android.util.Log.d(r3, r0)     // Catch: java.lang.NumberFormatException -> L5c
            goto L75
        L64:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Error parsing bearing: "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r3, r1, r0)
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.primary.LaunchActivity.F(com.unified.ur1.primary.LaunchActivity, java.lang.String):java.lang.String");
    }

    public static void G(LaunchActivity launchActivity) throws IllegalStateException {
        MediaPlayer mediaPlayerCreate;
        DialogC0469f dialogC0469f = launchActivity.f5961s1;
        if (dialogC0469f == null || !dialogC0469f.isShowing()) {
            try {
                mediaPlayerCreate = MediaPlayer.create(launchActivity, R.raw.soft_alert);
                if (mediaPlayerCreate != null) {
                    try {
                        mediaPlayerCreate.setOnCompletionListener(new C0679c0());
                        mediaPlayerCreate.start();
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        if (mediaPlayerCreate != null) {
                            mediaPlayerCreate.release();
                        }
                        h hVar = new h(launchActivity, R.style.Base_Theme_Material3_Dark_Dialog);
                        C0467d c0467d = (C0467d) hVar.f1522d;
                        c0467d.f6292d = "New Release Available";
                        c0467d.f6294f = com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("Version "), launchActivity.f5931i, " is available now.\n\n");
                        hVar.e("Download", new DialogInterfaceOnClickListenerC0681d0(0, launchActivity));
                        hVar.c("Not Now", new DialogInterfaceOnClickListenerC0681d0(1, launchActivity));
                        DialogC0469f dialogC0469fB = hVar.b();
                        launchActivity.f5961s1 = dialogC0469fB;
                        dialogC0469fB.setOnDismissListener(new DialogInterfaceOnDismissListenerC0683e0(launchActivity));
                        launchActivity.f5961s1.show();
                    }
                }
            } catch (Exception e6) {
                e = e6;
                mediaPlayerCreate = null;
            }
            h hVar2 = new h(launchActivity, R.style.Base_Theme_Material3_Dark_Dialog);
            C0467d c0467d2 = (C0467d) hVar2.f1522d;
            c0467d2.f6292d = "New Release Available";
            c0467d2.f6294f = com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("Version "), launchActivity.f5931i, " is available now.\n\n");
            hVar2.e("Download", new DialogInterfaceOnClickListenerC0681d0(0, launchActivity));
            hVar2.c("Not Now", new DialogInterfaceOnClickListenerC0681d0(1, launchActivity));
            DialogC0469f dialogC0469fB2 = hVar2.b();
            launchActivity.f5961s1 = dialogC0469fB2;
            dialogC0469fB2.setOnDismissListener(new DialogInterfaceOnDismissListenerC0683e0(launchActivity));
            launchActivity.f5961s1.show();
        }
    }

    public static void R0(int i5, int i6) {
        if (i5 < 1 || i5 > 16776415) {
            throw new IllegalArgumentException("Local ID must be between 1-16776415");
        }
        if (i6 < 1 || i6 > 16777215) {
            throw new IllegalArgumentException("TX Contact must be between 1-16776415");
        }
    }

    public static String S(long j5) {
        if (j5 >= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            return j5 < 1048576 ? String.format("%.1f KB", Double.valueOf(j5 / 1024.0d)) : j5 < 1073741824 ? String.format("%.1f MB", Double.valueOf(j5 / 1048576.0d)) : String.format("%.1f GB", Double.valueOf(j5 / 1.073741824E9d));
        }
        return j5 + " B";
    }

    public static long T(String str) {
        try {
            String strTrim = str.replace(".", "").trim();
            while (strTrim.length() < 9) {
                strTrim = strTrim + "0";
            }
            if (strTrim.length() > 9) {
                strTrim = strTrim.substring(0, 9);
            }
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused) {
            Log.e("Unified - Main Activity", "Error formatting frequency: " + str);
            return 440000000L;
        }
    }

    public static String U() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i5 = 0; i5 < 8; i5++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(36)));
        }
        return sb.toString();
    }

    public static void d0() {
        Log.d("Unified - Main Activity", "╔══════════════════════════════════════╗");
        Log.d("Unified - Main Activity", "║         DEVICE INFORMATION           ║");
        Log.d("Unified - Main Activity", "╠══════════════════════════════════════╣");
        Log.d("Unified - Main Activity", "║ DEVICE IDENTIFIERS:");
        StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("║ • Device: "), Build.DEVICE, "Unified - Main Activity", "║ • Model: "), Build.MODEL, "Unified - Main Activity", "║ • Manufacturer: "), Build.MANUFACTURER, "Unified - Main Activity", "║ • Brand: "), Build.BRAND, "Unified - Main Activity", "║ • Product: ");
        sbI.append(Build.PRODUCT);
        Log.d("Unified - Main Activity", sbI.toString());
        Log.d("Unified - Main Activity", "╠══════════════════════════════════════╣");
        StringBuilder sbI2 = com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.h("Unified - Main Activity", "║ HARDWARE INFO:", "║ • Board: "), Build.BOARD, "Unified - Main Activity", "║ • Hardware: "), Build.HARDWARE, "Unified - Main Activity", "║ • ABIs: ");
        sbI2.append(String.join(", ", Build.SUPPORTED_ABIS));
        Log.d("Unified - Main Activity", sbI2.toString());
        Log.d("Unified - Main Activity", "╠══════════════════════════════════════╣");
        StringBuilder sbI3 = com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.h("Unified - Main Activity", "║ ANDROID VERSION:", "║ • Release: "), Build.VERSION.RELEASE, "Unified - Main Activity", "║ • SDK: ");
        sbI3.append(Build.VERSION.SDK_INT);
        Log.d("Unified - Main Activity", sbI3.toString());
        StringBuilder sbI4 = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("║ • Codename: "), Build.VERSION.CODENAME, "Unified - Main Activity", "║ • Incremental: ");
        sbI4.append(Build.VERSION.INCREMENTAL);
        Log.d("Unified - Main Activity", sbI4.toString());
        String radioVersion = Build.getRadioVersion();
        if (radioVersion == null) {
            radioVersion = "N/A";
        }
        Log.d("Unified - Main Activity", "║ • Baseband: ".concat(radioVersion));
        Log.d("Unified - Main Activity", "╠══════════════════════════════════════╣");
        StringBuilder sbI5 = com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.i(com.unified.ur1.SatelliteTracker.h.h("Unified - Main Activity", "║ BUILD INFO:", "║ • ID: "), Build.ID, "Unified - Main Activity", "║ • Display: "), Build.DISPLAY, "Unified - Main Activity", "║ • Type: "), Build.TYPE, "Unified - Main Activity", "║ • Tags: "), Build.TAGS, "Unified - Main Activity", "║ • Host: "), Build.HOST, "Unified - Main Activity", "║ • User: ");
        sbI5.append(Build.USER);
        Log.d("Unified - Main Activity", sbI5.toString());
        Log.d("Unified - Main Activity", "║ • Build Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(Build.TIME)));
        Log.d("Unified - Main Activity", "╠══════════════════════════════════════╣");
        Log.d("Unified - Main Activity", "║ • Fingerprint: " + Build.FINGERPRINT);
        Log.d("Unified - Main Activity", "╚══════════════════════════════════════╝");
    }

    public static void j(LaunchActivity launchActivity, Spinner spinner, final int i5) {
        HashMap map = launchActivity.f5975x1;
        map.clear();
        if (i5 == 0) {
            map.put("None", 0);
        } else if (i5 == 1) {
            map.put("None", 0);
            map.put("67.0", 1);
            com.unified.ur1.SatelliteTracker.h.n(2, map, "69.3", 3, "71.9");
            com.unified.ur1.SatelliteTracker.h.n(4, map, "74.4", 5, "77.0");
            com.unified.ur1.SatelliteTracker.h.n(6, map, "79.7", 7, "82.5");
            com.unified.ur1.SatelliteTracker.h.n(8, map, "85.4", 9, "88.5");
            com.unified.ur1.SatelliteTracker.h.n(10, map, "91.5", 11, "94.8");
            com.unified.ur1.SatelliteTracker.h.n(12, map, "97.4", 13, "100.0");
            com.unified.ur1.SatelliteTracker.h.n(14, map, "103.5", 15, "107.2");
            com.unified.ur1.SatelliteTracker.h.n(16, map, "110.9", 17, "114.8");
            com.unified.ur1.SatelliteTracker.h.n(18, map, "118.8", 19, "123.0");
            com.unified.ur1.SatelliteTracker.h.n(20, map, "127.3", 21, "131.8");
            com.unified.ur1.SatelliteTracker.h.n(22, map, "136.5", 23, "141.3");
            com.unified.ur1.SatelliteTracker.h.n(24, map, "146.2", 25, "151.4");
            com.unified.ur1.SatelliteTracker.h.n(26, map, "156.7", 27, "159.8");
            com.unified.ur1.SatelliteTracker.h.n(28, map, "162.2", 29, "165.5");
            com.unified.ur1.SatelliteTracker.h.n(30, map, "167.9", 31, "171.3");
            com.unified.ur1.SatelliteTracker.h.n(32, map, "173.8", 33, "177.3");
            com.unified.ur1.SatelliteTracker.h.n(34, map, "179.9", 35, "183.5");
            com.unified.ur1.SatelliteTracker.h.n(36, map, "186.2", 37, "189.9");
            com.unified.ur1.SatelliteTracker.h.n(38, map, "192.8", 39, "196.6");
            com.unified.ur1.SatelliteTracker.h.n(40, map, "199.5", 41, "203.5");
            com.unified.ur1.SatelliteTracker.h.n(42, map, "206.5", 43, "210.7");
            com.unified.ur1.SatelliteTracker.h.n(44, map, "218.1", 45, "225.7");
            com.unified.ur1.SatelliteTracker.h.n(46, map, "229.1", 47, "233.6");
            com.unified.ur1.SatelliteTracker.h.n(48, map, "241.8", 49, "250.3");
            map.put("254.1", 50);
        } else {
            map.put("023", 0);
            map.put("025", 1);
            com.unified.ur1.SatelliteTracker.h.n(2, map, "026", 3, "031");
            com.unified.ur1.SatelliteTracker.h.n(4, map, "032", 5, "043");
            com.unified.ur1.SatelliteTracker.h.n(6, map, "047", 7, "051");
            com.unified.ur1.SatelliteTracker.h.n(8, map, "054", 9, "065");
            com.unified.ur1.SatelliteTracker.h.n(10, map, "071", 11, "072");
            com.unified.ur1.SatelliteTracker.h.n(12, map, "073", 13, "074");
            com.unified.ur1.SatelliteTracker.h.n(14, map, "114", 15, "115");
            com.unified.ur1.SatelliteTracker.h.n(16, map, "116", 17, "125");
            com.unified.ur1.SatelliteTracker.h.n(18, map, "131", 19, "132");
            com.unified.ur1.SatelliteTracker.h.n(20, map, "134", 21, "143");
            com.unified.ur1.SatelliteTracker.h.n(22, map, "152", 23, "155");
            com.unified.ur1.SatelliteTracker.h.n(24, map, "156", 25, "162");
            com.unified.ur1.SatelliteTracker.h.n(26, map, "165", 27, "172");
            com.unified.ur1.SatelliteTracker.h.n(28, map, "174", 29, "205");
            com.unified.ur1.SatelliteTracker.h.n(30, map, "223", 31, "226");
            com.unified.ur1.SatelliteTracker.h.n(32, map, "243", 33, "244");
            com.unified.ur1.SatelliteTracker.h.n(34, map, "245", 35, "251");
            com.unified.ur1.SatelliteTracker.h.n(36, map, "261", 37, "263");
            com.unified.ur1.SatelliteTracker.h.n(38, map, "265", 39, "271");
            com.unified.ur1.SatelliteTracker.h.n(40, map, "306", 41, "311");
            com.unified.ur1.SatelliteTracker.h.n(42, map, "315", 43, "331");
            com.unified.ur1.SatelliteTracker.h.n(44, map, "343", 45, "346");
            com.unified.ur1.SatelliteTracker.h.n(46, map, "351", 47, "364");
            com.unified.ur1.SatelliteTracker.h.n(48, map, "365", 49, "371");
            com.unified.ur1.SatelliteTracker.h.n(50, map, "411", 51, "412");
            com.unified.ur1.SatelliteTracker.h.n(52, map, "413", 53, "423");
            com.unified.ur1.SatelliteTracker.h.n(54, map, "431", 55, "432");
            com.unified.ur1.SatelliteTracker.h.n(56, map, "445", 57, "464");
            com.unified.ur1.SatelliteTracker.h.n(58, map, "465", 59, "466");
            com.unified.ur1.SatelliteTracker.h.n(60, map, "503", 61, "506");
            com.unified.ur1.SatelliteTracker.h.n(62, map, "516", 63, "532");
            com.unified.ur1.SatelliteTracker.h.n(64, map, "546", 65, "565");
            com.unified.ur1.SatelliteTracker.h.n(66, map, "606", 67, "612");
            com.unified.ur1.SatelliteTracker.h.n(68, map, "624", 69, "627");
            com.unified.ur1.SatelliteTracker.h.n(70, map, "631", 71, "632");
            com.unified.ur1.SatelliteTracker.h.n(72, map, "654", 73, "662");
            com.unified.ur1.SatelliteTracker.h.n(74, map, "664", 75, "703");
            com.unified.ur1.SatelliteTracker.h.n(76, map, "712", 77, "723");
            com.unified.ur1.SatelliteTracker.h.n(78, map, "731", 79, "732");
            com.unified.ur1.SatelliteTracker.h.n(80, map, "734", 81, "743");
            map.put("754", 82);
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr, new Comparator() { // from class: k3.E
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                Context context = LaunchActivity.f5853D1;
                if (str.equals("None")) {
                    return -1;
                }
                if (!str2.equals("None")) {
                    if (i5 != 1) {
                        return str.compareTo(str2);
                    }
                    if (Float.parseFloat(str) < Float.parseFloat(str2)) {
                        return -1;
                    }
                }
                return 1;
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(launchActivity, android.R.layout.simple_spinner_item, strArr);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    public static void k(LaunchActivity launchActivity, int i5, int i6) {
        launchActivity.getClass();
        if (i5 != 0) {
            if (i5 == 1) {
                if (i6 >= 0) {
                    double[] dArr = launchActivity.f5978y1;
                    if (i6 < dArr.length) {
                        String.format("%.1f", Double.valueOf(dArr[i6]));
                        return;
                    }
                    return;
                }
                return;
            }
            if ((i5 == 2 || i5 == 3) && i6 >= 0) {
                int[] iArr = launchActivity.f5980z1;
                if (i6 < iArr.length) {
                    String.format("%03d", Integer.valueOf(iArr[i6]));
                }
            }
        }
    }

    public static void l(LaunchActivity launchActivity) {
        if (!launchActivity.f5869D || "0.0.8-beta.13" == launchActivity.f5939l) {
            return;
        }
        String str = launchActivity.f5931i;
        if (str == null || "null".equalsIgnoreCase(str)) {
            Log.w("VersionChecker", "Cannot check version: update is null or 'null'");
            return;
        }
        Log.d("VersionChecker", "New version " + launchActivity.f5931i + " available");
        launchActivity.runOnUiThread(new T(launchActivity, 5));
    }

    public static void q(LaunchActivity launchActivity) {
        View view = launchActivity.f5911Z0;
        if (view != null) {
            view.setVisibility(0);
            ((ImageView) launchActivity.findViewById(R.id.tx_icon)).setVisibility(0);
            launchActivity.f5911Z0.setAlpha(BitmapDescriptorFactory.HUE_RED);
            launchActivity.f5911Z0.animate().alpha(0.9f).setDuration(300L).start();
            launchActivity.f5911Z0.setClickable(true);
            launchActivity.f5911Z0.setFocusable(true);
        }
    }

    public static void s(LaunchActivity launchActivity) {
        int i5 = launchActivity.f5947o;
        ((Vibrator) launchActivity.getSystemService("vibrator")).vibrate(100L);
        h hVar = new h(launchActivity, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "📡 Multi-RX Mode Active";
        c0467d.f6294f = AbstractC0535a.j("You are connected to Multi-RX. In order to transmit you must be on a single Talkgroup.\n\nWould you like to switch to: ", i5, "?");
        hVar.e("Yes", new j(i5, 2, launchActivity));
        hVar.c("Cancel", new G(1));
        hVar.b().show();
    }

    public static void t(LaunchActivity launchActivity, Context context, Runnable runnable) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayer mediaPlayerCreate;
        launchActivity.getClass();
        if (!c.u(context)) {
            Log.d("UR Broadcast", "PTT sounds disabled - executing callback immediately");
            runnable.run();
            return;
        }
        String strX = c.x(context);
        if (strX == null) {
            strX = "default";
        }
        String strTrim = strX.trim();
        Log.d("UR Broadcast", "=== ROIP PTT SOUND DEBUG ===");
        Log.d("UR Broadcast", "Retrieved mode: '" + strTrim + "' (length: " + strTrim.length() + ")");
        Log.d("UR Broadcast", "PTT_MODE_NONE constant: 'none'");
        Log.d("UR Broadcast", "PTT_MODE_DEFAULT constant: 'default'");
        Log.d("UR Broadcast", "PTT_MODE_CUSTOM constant: 'custom'");
        Log.d("UR Broadcast", "Mode equals NONE? " + "none".equals(strTrim));
        Log.d("UR Broadcast", "Mode equals 'none'? " + "none".equals(strTrim));
        Log.d("UR Broadcast", "=== END DEBUG ===");
        if ("none".equals(strTrim) || "none".equals(strTrim) || "None".equals(strTrim)) {
            Log.d("UR Broadcast", "ROIP PTT sound set to NONE - executing callback immediately");
            runnable.run();
            return;
        }
        try {
            if ("custom".equals(strTrim) || "custom".equals(strTrim) || "Custom".equals(strTrim)) {
                String string = context.getApplicationContext().getSharedPreferences("AppSettings", 0).getString("roip_ptt_sound_path", null);
                if (string == null || !new File(string).exists()) {
                    Log.w("UR Broadcast", "Custom ROIP PTT sound selected but no valid file found - executing callback immediately");
                    runnable.run();
                    return;
                } else {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(string);
                    mediaPlayer.prepare();
                    Log.d("UR Broadcast", "Using custom ROIP PTT sound: ".concat(string));
                    mediaPlayerCreate = mediaPlayer;
                }
            } else {
                if (!"default".equals(strTrim) && !"default".equals(strTrim) && !"Default".equals(strTrim)) {
                    Log.w("UR Broadcast", "Unknown ROIP PTT sound mode: '" + strTrim + "' - executing callback immediately");
                    runnable.run();
                    return;
                }
                mediaPlayerCreate = MediaPlayer.create(context, R.raw.trbo);
                Log.d("UR Broadcast", "Using default ROIP PTT sound (R.raw.trbo)");
            }
            if (mediaPlayerCreate == null) {
                Log.w("UR Broadcast", "Failed to create MediaPlayer for ROIP PTT sound");
                runnable.run();
                return;
            }
            launchActivity.f5892P0 = mediaPlayerCreate;
            mediaPlayerCreate.setOnCompletionListener(new Q(launchActivity, runnable));
            mediaPlayerCreate.setOnErrorListener(new S(launchActivity, runnable));
            Log.d("UR Broadcast", "Starting ROIP PTT sound playback");
            synchronized (launchActivity) {
                try {
                    if (!launchActivity.O0 && launchActivity.f5885L0 && launchActivity.f5972w1) {
                        mediaPlayerCreate.start();
                    } else {
                        Log.w("UR Broadcast", "Transmission cancelled before ROIP PTT sound start");
                        mediaPlayerCreate.release();
                        launchActivity.f5892P0 = null;
                    }
                } finally {
                }
            }
        } catch (Exception e5) {
            Log.e("UR Broadcast", "Exception playing ROIP PTT sound", e5);
            runnable.run();
        }
    }

    public static void y(LaunchActivity launchActivity) {
        launchActivity.f5885L0 = false;
        launchActivity.f5889N0 = false;
        launchActivity.O0 = true;
        if (launchActivity.f5972w1) {
            launchActivity.f5972w1 = false;
        }
        PowerManager.WakeLock wakeLock = launchActivity.f5913a1;
        if (wakeLock != null && wakeLock.isHeld()) {
            try {
                launchActivity.f5913a1.release();
            } catch (Exception e5) {
                Log.e("UR Broadcast", "Error releasing wake lock in reset", e5);
            }
        }
        launchActivity.K0();
        Log.d("UR Broadcast", "Transmission state reset");
    }

    public static void z(LaunchActivity launchActivity) {
        DTMFKeypad dTMFKeypad = launchActivity.f5893Q;
        if (dTMFKeypad != null) {
            boolean z4 = !launchActivity.f5895R;
            launchActivity.f5895R = z4;
            if (z4) {
                dTMFKeypad.setVisibility(8);
                launchActivity.f5893Q.setAlpha(BitmapDescriptorFactory.HUE_RED);
                launchActivity.f5893Q.animate().alpha(1.0f).setDuration(300L).start();
            } else {
                dTMFKeypad.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(300L).withEndAction(new RunnableC0696l(launchActivity, 18)).start();
            }
            if (launchActivity.f5893Q == null || !launchActivity.f5970w.equals("FM")) {
                return;
            }
            launchActivity.f5893Q.setVisibility(8);
            launchActivity.f5893Q.setEnabled(true);
        }
    }

    public final void A0() {
        String strH = c.h(f5853D1);
        if (strH == null || strH.isEmpty()) {
            Toast.makeText(this, "Please register your device first", 1).show();
            return;
        }
        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Save Memory";
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_memory_save, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.memory_name);
        c0467d.f6304s = viewInflate;
        hVar.e("SAVE", new f3.S(this, editText, strH, 3));
        hVar.c("CANCEL", new DialogInterfaceOnClickListenerC0516g(7));
        hVar.b().show();
    }

    public final void B0() {
        DialogC0469f dialogC0469f = this.f5964t1;
        if (dialogC0469f == null || !dialogC0469f.isShowing()) {
            this.f5869D = false;
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_progress, (ViewGroup) null);
            ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
            TextView textView = (TextView) viewInflate.findViewById(R.id.messageText);
            progressBar.setMax(100);
            progressBar.setProgress(0);
            textView.setText("Preparing download...");
            h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
            C0467d c0467d = (C0467d) hVar.f1522d;
            c0467d.f6292d = "Downloading Update";
            c0467d.f6304s = viewInflate;
            c0467d.f6299m = true;
            hVar.c("Cancel", new DialogInterfaceOnClickListenerC0681d0(2, this));
            DialogC0469f dialogC0469fB = hVar.b();
            this.f5964t1 = dialogC0469fB;
            dialogC0469fB.show();
        }
    }

    public final void C0(String str) {
        Dialog dialog = new Dialog(this, R.style.Base_Theme_Material3_Dark_Dialog);
        dialog.setContentView(R.layout.dialog_success);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.black);
            dialog.getWindow().setLayout(-1, -2);
        }
        TextView textView = (TextView) dialog.findViewById(R.id.success_message);
        Button button = (Button) dialog.findViewById(R.id.success_ok_button);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.success_icon);
        if (textView != null) {
            textView.setText(str);
        }
        if (imageView != null) {
            imageView.setScaleX(BitmapDescriptorFactory.HUE_RED);
            imageView.setScaleY(BitmapDescriptorFactory.HUE_RED);
            imageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new OvershootInterpolator()).start();
        }
        if (button != null) {
            button.setOnClickListener(new u(dialog, 1));
        }
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(new e(21, dialog), 3000L);
    }

    public void CloseROIPButtonClicked(View view) throws InterruptedException {
        N();
        n0();
    }

    public final void D0(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public final void E0() {
        T t4;
        Handler handler = this.c1;
        if (handler == null || (t4 = this.f5920d1) == null) {
            return;
        }
        handler.removeCallbacks(t4);
    }

    public final void F0() {
        T t4;
        Handler handler = this.f5923e1;
        if (handler == null || (t4 = this.f5926f1) == null) {
            return;
        }
        handler.removeCallbacks(t4);
    }

    public final void G0() {
        this.f5952p1 = false;
        this.f5949o1 = 0;
        this.f5946n1.removeCallbacks(this.f5958r1);
    }

    public final void H(final int i5) {
        int color;
        CardView cardView = this.f5874F0;
        if (cardView == null) {
            return;
        }
        try {
            Drawable background = cardView.getBackground();
            if (background instanceof ColorDrawable) {
                color = ((ColorDrawable) background).getColor();
            } else {
                CardView cardView2 = this.f5874F0;
                int i6 = f5857J1;
                cardView2.setCardBackgroundColor(i6);
                color = i6;
            }
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(color), Integer.valueOf(i5));
            valueAnimatorOfObject.setDuration(300L);
            valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: k3.v
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Context context = LaunchActivity.f5853D1;
                    LaunchActivity launchActivity = this.f8222a;
                    launchActivity.getClass();
                    try {
                        launchActivity.f5874F0.setCardBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    } catch (Exception e5) {
                        Log.e("Unified - Main Activity", "Error in color animation update", e5);
                        launchActivity.f5874F0.setCardBackgroundColor(i5);
                    }
                }
            });
            try {
                valueAnimatorOfObject.start();
            } catch (Exception e5) {
                Log.e("Unified - Main Activity", "Error starting color animation", e5);
                this.f5874F0.setCardBackgroundColor(i5);
            }
        } catch (Exception e6) {
            Log.e("Unified - Main Activity", "Error animating color change", e6);
            try {
                this.f5874F0.setCardBackgroundColor(i5);
            } catch (Exception e7) {
                Log.e("Unified - Main Activity", "Fallback color change also failed", e7);
            }
        }
    }

    public final void H0(String str) {
        this.f5925f0 = -1;
        ThreadPoolExecutor threadPoolExecutor = this.f5922e0;
        if (threadPoolExecutor == null) {
            return;
        }
        threadPoolExecutor.execute(new RunnableC0701n0(this, str, 0));
        y0();
        this.f5919d0.c();
    }

    public final void I() {
        this.f5913a1 = ((PowerManager) getSystemService("power")).newWakeLock(1, "MyApp::PTTWakeLock");
        registerReceiver(this.f5894Q0, new IntentFilter("dmr.play.DMR_REVC_END"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("dmr.play.DMR_REVC_START"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("dmr.play.SEND_START"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("dmr.play.SEND_END"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("dmr.knob.TIMER"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("com.android.knobkey.channel"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("android.intent.action.ACTION_VIDEO_DOWN"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("android.intent.action.ACTION_VIDEO_UP"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("android.intent.action.PTT.down"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("android.intent.action.PTT.up"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("com.android.ptt.key.up"), 4);
        registerReceiver(this.f5894Q0, new IntentFilter("com.android.ptt.key.down"), 4);
        ((ImageButton) findViewById(R.id.pttButton)).setOnTouchListener(new ViewOnTouchListenerC0549B(3, this));
        this.f5888N = new C0513e((Context) this);
        View viewFindViewById = findViewById(android.R.id.content);
        viewFindViewById.setOnKeyListener(new ViewOnKeyListenerC0699m0(this));
        viewFindViewById.setFocusableInTouchMode(true);
        viewFindViewById.requestFocus();
    }

    public final void I0(int i5) {
        Object obj = this.f5919d0.f7948e.f3899e;
        if (obj == A.f3894k) {
            obj = null;
        }
        List list = (List) obj;
        if (list == null) {
            return;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (((C0518i) list.get(i6)).f6721a == i5) {
                this.f5897S = this.f5965u.h(((C0518i) list.get(i6)).f6723c);
                this.f5925f0 = i5;
                runOnUiThread(new RunnableC0701n0(this, ((C0518i) list.get(i6)).f6722b, 1));
                y0();
                ThreadPoolExecutor threadPoolExecutor = this.f5922e0;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.execute(new r(i5, 6, this));
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final boolean J(int i5, String str) throws IOException {
        HttpURLConnection httpURLConnection;
        int responseCode;
        BufferedReader bufferedReader;
        try {
            Log.i("Unified - Main Activity", "Calling upon Brandmeiester gods to allow access to their divine network via talkgroup=" + i5);
            httpURLConnection = (HttpURLConnection) new URL("https://ur1.unifiedradios.com/bm_tg.php?cloud_auth=" + str + "&tg=" + i5 + "&_t=" + System.currentTimeMillis()).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestProperty("User-Agent", "DMRBridge/1.0");
            httpURLConnection.setRequestProperty("Accept", "application/json, text/plain, */*");
            responseCode = httpURLConnection.getResponseCode();
            Log.d("Unified - Main Activity", "UR1 API response code: " + responseCode);
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Exception calling UR1 talkgroup API", e5);
        }
        if (responseCode != 200) {
            Log.e("Unified - Main Activity", "UR1 API call failed with response code: " + responseCode);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), "utf-8"));
            } catch (Exception e6) {
                Log.e("Unified - Main Activity", "Failed to read error response", e6);
                D0("Failed to set TG " + i5 + " (HTTP " + responseCode + ")");
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                String string = sb.toString();
                Log.e("Unified - Main Activity", "UR1 API error response: " + string);
                h0(i5, string, false);
                bufferedReader.close();
                httpURLConnection.disconnect();
                return false;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    String string2 = sb2.toString();
                    Log.i("Unified - Main Activity", "UR1 API response: " + string2);
                    h0(i5, string2, true);
                    Log.i("Unified - Main Activity", "Successfully called UR1 talkgroup API for TG " + i5);
                    bufferedReader2.close();
                    return true;
                }
                sb2.append(line2.trim());
            }
        } catch (Throwable th3) {
            try {
                bufferedReader2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
        Log.e("Unified - Main Activity", "Exception calling UR1 talkgroup API", e5);
        return false;
    }

    public final void J0() {
        if (this.f5911Z0 != null) {
            ((ImageView) findViewById(R.id.lock_icon)).setVisibility(8);
            this.f5911Z0.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(300L).withEndAction(new RunnableC0696l(this, 22)).start();
        }
    }

    public final void K() {
        String[] strArr = {"android.permission.READ_PHONE_STATE", "android.permission.RECORD_AUDIO", "android.permission.POST_NOTIFICATIONS", "android.permission.WAKE_LOCK"};
        ArrayList arrayList = new ArrayList();
        boolean z4 = false;
        for (int i5 = 0; i5 < 4; i5++) {
            String str = strArr[i5];
            if (C.h.a(this, str) != 0) {
                arrayList.add(str);
                if (B.e.e(this, str)) {
                    z4 = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (!z4) {
            B.e.d(this, (String[]) arrayList.toArray(new String[0]), 123);
            return;
        }
        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Permissions needed";
        c0467d.f6294f = "This app needs these permissions to work properly.";
        hVar.e("OK", new DialogInterfaceOnClickListenerC0580i(this, 5, arrayList));
        hVar.b().show();
    }

    public final void K0() {
        if (this.f5911Z0 != null) {
            ((ImageView) findViewById(R.id.tx_icon)).setVisibility(8);
            this.f5911Z0.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(300L).withEndAction(new RunnableC0696l(this, 2)).start();
        }
    }

    public final void L() {
        getSharedPreferences("app_updates", 0).edit().remove("current_download_id").apply();
    }

    public final void L0(int i5) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new RunnableC0709s(this, i5, 5));
            return;
        }
        try {
            if (!isFinishing() && !isDestroyed()) {
                if (this.f5874F0 == null) {
                    Log.w("Unified - Main Activity", "roipBannerCard is null, cannot update buffer status");
                    return;
                }
                int i6 = f5857J1;
                if (i5 != 0) {
                    if (i5 == 1) {
                        i6 = f5858K1;
                    } else if (i5 == 2) {
                        i6 = f5859L1;
                    }
                }
                try {
                    H(i6);
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Color animation failed, using direct color change", e5);
                    try {
                        this.f5874F0.setCardBackgroundColor(i6);
                    } catch (Exception e6) {
                        Log.e("Unified - Main Activity", "Direct color change also failed", e6);
                    }
                }
                Log.d("Unified - Main Activity", "Updated buffer status to level: " + i5);
                return;
            }
            Log.d("Unified - Main Activity", "Activity is finishing/destroyed, skipping buffer status update");
        } catch (Exception e7) {
            Log.e("Unified - Main Activity", "Error updating buffer status UI", e7);
        }
    }

    public final void M() {
        try {
            HandlerThreadC0778n handlerThreadC0778n = this.f5918d;
            if (handlerThreadC0778n != null) {
                SerialPort serialPort = handlerThreadC0778n.f8624j;
                if (serialPort != null && serialPort.f5554b != null && serialPort.f5553a != null) {
                    handlerThreadC0778n.a();
                }
                this.f5918d = null;
            }
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error closing serial port", e5);
        }
    }

    public final void M0(long j5) {
        Log.e("Unified - Main Activity", "activeFrequencyField 1");
        TextView textView = (TextView) findViewById(R.id.activeFrequency);
        String str = String.format("%.5f", Double.valueOf(j5 / 1000000.0d));
        textView.setText(str);
        Log.d("Unified - Main Activity", "Programming - Setting Text to ".concat(str));
        H0(str);
    }

    public final void N() throws InterruptedException {
        Log.d("MainActivity", "Starting DMR disconnection process");
        DMRBridge dMRBridgeJ = DMRBridge.j(this);
        if (dMRBridgeJ.isSocketConnected()) {
            dMRBridgeJ.stopTransmission();
            Log.d("MainActivity", "Stopped active transmission");
        }
        String strJ = c.j(this);
        if (strJ != null && strJ.toLowerCase().contains("brandmeister")) {
            dMRBridgeJ.e(c.C(this).getInt("dmr_id", 1));
            Log.d("MainActivity", "Disconnected from Brandmeister talkgroups");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e5) {
                e5.printStackTrace();
            }
        }
        dMRBridgeJ.disconnectSockets();
        Log.d("MainActivity", "Socket connection closed");
        dMRBridgeJ.c();
        Log.d("MainActivity", "DMR Bridge cleaned up");
        dMRBridgeJ.v(null);
        Log.d("MainActivity", "Callbacks cleared");
        runOnUiThread(new RunnableC0696l(this, 8));
    }

    public final void N0() {
        TextView textView = (TextView) findViewById(R.id.activeFrequency);
        TextView textView2 = (TextView) findViewById(R.id.activeMemoryName);
        String string = c.C(this).getString("channel_name", "");
        String string2 = c.C(this).getString("channel_freq", "");
        if (textView != null && string2 != null && !string2.isEmpty()) {
            runOnUiThread(new F0.e(this, string2, textView2, string));
            return;
        }
        Log.e("Unified - Main Activity", "Failed to update frequency display - View or frequency is null");
        if (textView == null) {
            Log.e("Unified - Main Activity", "activeFrequencyField is null");
        }
        if (string2 == null) {
            Log.e("Unified - Main Activity", "lastFreq is null");
        }
    }

    public final void O(C0515f c0515f) {
        TextView textView = (TextView) findViewById(R.id.activeFrequency);
        String str = c0515f.f6699c;
        if (str != null && !str.isEmpty()) {
            String str2 = c0515f.f6699c;
            if (!str2.equals("null")) {
                this.f5957r0 = str2;
            }
        }
        runOnUiThread(new p(this, 6, c0515f));
        runOnUiThread(new f(this, textView, c0515f, 12));
    }

    public final void O0(int i5) {
        Log.d("Unified - Main Activity", "updateMessageBadge called with count: " + i5);
        runOnUiThread(new RunnableC0709s(this, i5, 2));
    }

    public void OntheAir(View view) {
        String strH = c.h(f5853D1);
        Intent intent = new Intent(this, (Class<?>) UnifiedOnTheAirActivity.class);
        intent.putExtra("callsign", strH);
        startActivity(intent);
    }

    public final void P(String str) {
        try {
            DownloadManager downloadManager = (DownloadManager) getSystemService("download");
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "app_update_v" + this.f5931i + ".apk");
            request.setNotificationVisibility(1);
            request.setTitle("Version " + this.f5931i);
            request.setDescription("Downloading app update");
            request.setAllowedNetworkTypes(3);
            request.setMimeType("application/vnd.android.package-archive");
            long jEnqueue = downloadManager.enqueue(request);
            getSharedPreferences("app_updates", 0).edit().putLong("current_download_id", jEnqueue).apply();
            Toast.makeText(this, "Download started", 0).show();
            B0();
            Handler handler = new Handler();
            handler.post(new R0(this, jEnqueue, handler));
        } catch (Exception e5) {
            e5.printStackTrace();
            Toast.makeText(this, "Download failed: " + e5.getMessage(), 1).show();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    public final void P0(String str, String str2) {
        this.k1.execute(new f(this, str, str2, 10));
    }

    public final void Q() {
        ((ImageButton) findViewById(R.id.pttButton)).setBackground(getDrawable(R.drawable.ptt_button));
    }

    public final void Q0() {
        double latitude;
        double longitude;
        Log.i("Unified - Main Activity", "Device validation started for " + this.f5900U);
        Location lastKnownLocation = null;
        String string = getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
        I1 = string;
        if (string == null || string.isEmpty()) {
            x0("Authorization code not found");
            return;
        }
        if (C.h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            Log.w("Unified - Main Activity", "Location permission not granted, requesting...");
            B.e.d(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
            return;
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        this.f5942m = Build.DEVICE;
        String str3 = Build.VERSION.RELEASE;
        String string2 = Settings.Secure.getString(getContentResolver(), "android_id");
        Log.d("Unified - Main Activity", "Device Info - Manufacturer: " + str + ", Model: " + str2 + ", OS: " + str3);
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (locationManager.isProviderEnabled("network") && (lastKnownLocation = locationManager.getLastKnownLocation("network")) != null) {
            Log.d("Unified - Main Activity", "Location obtained from network provider");
        }
        if (lastKnownLocation == null && locationManager.isProviderEnabled("gps") && (lastKnownLocation = locationManager.getLastKnownLocation("gps")) != null) {
            Log.d("Unified - Main Activity", "Location obtained from GPS provider");
        }
        if (lastKnownLocation == null) {
            Log.w("Unified - Main Activity", "Unable to retrieve location from any provider, using default coordinates (0, 0)");
            latitude = 0.0d;
            longitude = 0.0d;
        } else {
            latitude = lastKnownLocation.getLatitude();
            longitude = lastKnownLocation.getLongitude();
            Log.i("Unified - Main Activity", String.format("Location acquired: %.6f, %.6f", Double.valueOf(latitude), Double.valueOf(longitude)));
        }
        Uri.Builder builderBuildUpon = Uri.parse("https://ur1.unifiedradios.com/telemetry.php").buildUpon();
        double d5 = longitude;
        double d6 = latitude;
        if (f5855F1 || this.f5942m.contains("Ulefone")) {
            Log.d("Unified - Main Activity", "Using CJ_26 device profile");
            builderBuildUpon.appendQueryParameter("cloud_auth", I1).appendQueryParameter("device_manufacturer", "ComJoTRadios").appendQueryParameter("device_model", "CJ_26").appendQueryParameter("os_version", str3).appendQueryParameter("os_uid", string2).appendQueryParameter("app_version", "0.0.8-beta.13").appendQueryParameter("lat", String.valueOf(d6)).appendQueryParameter("lng", String.valueOf(d5));
        } else {
            Log.d("Unified - Main Activity", "Using standard device profile");
            builderBuildUpon.appendQueryParameter("cloud_auth", I1).appendQueryParameter("device_manufacturer", str).appendQueryParameter("device_model", str2).appendQueryParameter("os_version", str3).appendQueryParameter("os_uid", string2).appendQueryParameter("app_version", "0.0.8-beta.13").appendQueryParameter("lat", String.valueOf(d6)).appendQueryParameter("lng", String.valueOf(d5));
        }
        String string3 = builderBuildUpon.build().toString();
        Log.i("Unified - Main Activity", "Validation URL constructed: " + string3);
        new Thread(new k3.r(this, string3, 1)).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0220  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R(int r18) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.primary.LaunchActivity.R(int):void");
    }

    public final void V() {
        if (C.h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0 || C.h.a(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            B.e.d(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 123);
            return;
        }
        if (((LocationManager) getSystemService("location")).isProviderEnabled("gps")) {
            N1.j lastLocation = LocationServices.getFusedLocationProviderClient((Activity) this).getLastLocation();
            D0.p pVar = new D0.p(17, this);
            N1.r rVar = (N1.r) lastLocation;
            rVar.getClass();
            V0 v0 = l.f1790a;
            rVar.b(v0, pVar);
            rVar.a(v0, new i(19));
            return;
        }
        h hVar = new h(this);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Location Required";
        c0467d.f6294f = "Please enable location services";
        hVar.e("Settings", new DialogInterfaceOnClickListenerC0711t(this, 1));
        hVar.c("Cancel", null);
        hVar.f();
    }

    public final String W(String str) throws NumberFormatException {
        if ("None".equals(str) || str == null) {
            return "None";
        }
        try {
            int i5 = Integer.parseInt(str);
            HashMap map = new HashMap();
            for (Map.Entry entry : this.f5975x1.entrySet()) {
                map.put((Integer) entry.getValue(), (String) entry.getKey());
            }
            return (String) map.getOrDefault(Integer.valueOf(i5), "None");
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public final void X() {
        this.f5910Z.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(200L).withEndAction(new RunnableC0672A(this, 7)).start();
    }

    public final void Y() {
        try {
            ProgressDialog progressDialog = this.f5977y0;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.f5977y0.dismiss();
            this.f5977y0 = null;
            Log.d("Progress", "Progress dialog dismissed");
        } catch (Exception e5) {
            Log.e("Progress", "Error dismissing progress dialog", e5);
        }
    }

    public final void Z() {
        runOnUiThread(new RunnableC0696l(this, 19));
        J0();
        new Thread(new RunnableC0696l(this, 0), "RadioInitThread").start();
    }

    @Override // o3.k
    public final void a(int i5, int i6, int i7) {
    }

    public final void a0(String str) throws IOException {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "app_update_v" + this.f5931i + ".apk");
            if (!file.exists()) {
                Toast.makeText(this, "APK file not found in Downloads folder", 1).show();
                return;
            }
            if (!getPackageManager().canRequestPackageInstalls()) {
                this.f5967u1 = str;
                z0();
                return;
            }
            File file2 = new File(getFilesDir(), "apk");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, "update.apk");
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            byte[] bArr = new byte[1024];
            while (true) {
                int i5 = fileInputStream.read(bArr);
                if (i5 <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    Uri uriB = FileProvider.b(this, getApplicationContext().getPackageName() + ".fileprovider", file3);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(uriB, "application/vnd.android.package-archive");
                    intent.addFlags(1);
                    intent.addFlags(268435456);
                    startActivity(intent);
                    return;
                }
                fileOutputStream.write(bArr, 0, i5);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            Toast.makeText(this, "Failed to install APK: " + e5.getMessage(), 1).show();
        }
    }

    @Override // o3.k
    public final void b(int i5) {
        String str;
        String str2;
        String str3;
        HashMap map;
        String str4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map2 = this.f5867C0;
        Long l5 = (Long) map2.get(Integer.valueOf(i5));
        AbstractC0535a.u("DMR Call ended from ID: ", i5, "LaunchActivity");
        this.f5953q = false;
        if (l5 != null && jCurrentTimeMillis - l5.longValue() < 1000) {
            Log.d("LaunchActivity", "Ignoring call from ID: " + i5 + " (too soon)");
            return;
        }
        AbstractC0535a.u("DMR Call ended from ID: ", i5, "LaunchActivity");
        C0515f c0515fE = this.f5907X0.e(i5);
        if (c0515fE != null) {
            str = c0515fE.f6701e;
            str2 = c0515fE.f6697a;
            if (str == null || str.equals("null")) {
                str = "";
            } else {
                String str5 = c0515fE.f6702f;
                if (str5 != null && !str5.equals("null")) {
                    str = str + ", " + str5;
                }
            }
        } else {
            str = "";
            str2 = str;
        }
        String str6 = this.f5957r0;
        if (str6 == null || str6.isEmpty()) {
            B0 b02 = (B0) this.f5870D0.get(Integer.valueOf(i5));
            if (b02 == null || (str3 = b02.f7942a) == null || str3.isEmpty()) {
                AbstractC0535a.u("No callsign available, will use ID:", i5, "Unified - Main Activity");
            } else {
                Log.d("Unified - Main Activity", "Using callsign from activeCallsInfo: '" + str3 + "'");
                str6 = str3;
            }
        }
        Log.d("Unified - Main Activity", "Final callsign to save: '" + str6 + "'");
        int i6 = this.f5947o;
        long j5 = this.f5954q0;
        try {
            map = map2;
        } catch (Exception e5) {
            e = e5;
            map = map2;
        }
        try {
            String str7 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j5));
            int i7 = (int) ((jCurrentTimeMillis - j5) / 1000);
            if (str6 == null) {
                str6 = "ID:" + i5;
            }
            if (str2 == null) {
                str2 = "Unknown";
            }
            if (str == null) {
                str = "Unknown";
            }
            int iMax = Math.max(i7, 1);
            C0525p c0525p = new C0525p();
            c0525p.f6774a = str6;
            c0525p.f6775b = str2;
            c0525p.f6776c = str;
            c0525p.f6777d = i6;
            c0525p.f6778e = str7;
            c0525p.f6779f = iMax;
            c0525p.g = "✓ Complete";
            c0525p.h = j5;
            this.f5951p0.add(0, c0525p);
            if (this.f5951p0.size() > 50) {
                this.f5951p0 = this.f5951p0.subList(0, 50);
            }
            o0();
        } catch (Exception e6) {
            e = e6;
            Log.e("Unified - Main Activity", "Error saving last heard item", e);
            this.f5954q0 = 0L;
            this.f5957r0 = "";
            G0();
            map.put(Integer.valueOf(i5), Long.valueOf(jCurrentTimeMillis));
            int iL = c.l(this);
            TextView textView = (TextView) findViewById(R.id.activeFrequency);
            textView.clearAnimation();
            runOnUiThread(new RunnableC0588a(this, textView, iL, 1));
            str4 = I1;
            if (str4 != null) {
            }
            Log.w("Unified - Main Activity", "Cannot call rx_stop API - authCode is null or empty");
            return;
        }
        this.f5954q0 = 0L;
        this.f5957r0 = "";
        G0();
        map.put(Integer.valueOf(i5), Long.valueOf(jCurrentTimeMillis));
        int iL2 = c.l(this);
        TextView textView2 = (TextView) findViewById(R.id.activeFrequency);
        textView2.clearAnimation();
        runOnUiThread(new RunnableC0588a(this, textView2, iL2, 1));
        str4 = I1;
        if (str4 != null || str4.isEmpty()) {
            Log.w("Unified - Main Activity", "Cannot call rx_stop API - authCode is null or empty");
            return;
        }
        String str8 = "https://ur1.unifiedradios.com/rx_stop.php?cloud_auth=" + I1;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(2L, timeUnit).readTimeout(1L, timeUnit).build().newCall(new Request.Builder().url(str8).addHeader("Cache-Control", "no-cache, no-store, must-revalidate").addHeader("Pragma", "no-cache").addHeader("Expires", "0").build()).enqueue(new C0559c());
    }

    public final void b0() {
        this.f5907X0 = new m((Context) this);
        this.f5909Y0 = new Gson();
        K();
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f5941l1 = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new RunnableC0696l(this, 16), 0L, 10L, TimeUnit.SECONDS);
        Switch r02 = (Switch) findViewById(R.id.HidePTTSwitch);
        ImageButton imageButton = (ImageButton) findViewById(R.id.pttButton);
        if (r02 == null || imageButton == null) {
            StringBuilder sb = new StringBuilder("Switch or Button is null. Switch: ");
            sb.append(r02 == null);
            sb.append(", Button: ");
            sb.append(imageButton == null);
            Log.e("PTTDebug", sb.toString());
        } else {
            Log.d("PTTDebug", "Initial Switch state: " + r02.isChecked());
            Log.d("PTTDebug", "Initial Button visibility: " + imageButton.getVisibility());
            r02.setOnCheckedChangeListener(new Z1.a(4, imageButton));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.unified.ur1.F1_KEY_DOWN");
        intentFilter.addAction("com.unified.ur1.F1_KEY_UP");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f5944m1, intentFilter, 4);
        } else {
            registerReceiver(this.f5944m1, intentFilter);
        }
    }

    @Override // o3.k
    public final void c(int i5, String str, int i6) {
        Log.d("ROIP", "=== LaunchActivity.onCallStarted CALLED ===");
        Log.d("ROIP", "LaunchActivity received srcId: " + i5);
        AbstractC0535a.v("LaunchActivity received callsign: ", str, "ROIP");
        this.f5953q = true;
        this.f5947o = i6;
        TextView textView = (TextView) findViewById(R.id.CallerID);
        this.f5973x = textView;
        textView.setVisibility(0);
        runOnUiThread(new RunnableC0709s(this, i5, 1));
        this.f5954q0 = System.currentTimeMillis();
        this.f5957r0 = str;
        Log.d("LastHeard", "Set currentCallerCallsign to: '" + this.f5957r0 + "'");
        HashMap map = this.f5870D0;
        Integer numValueOf = Integer.valueOf(i5);
        B0 b02 = new B0();
        b02.f7942a = str;
        map.put(numValueOf, b02);
    }

    public final void c0() {
        try {
            String string = getSharedPreferences("last_heard_prefs", 0).getString("last_heard_data", "");
            if (string.isEmpty()) {
                return;
            }
            List list = (List) this.f5909Y0.fromJson(string, new z0().getType());
            if (list != null) {
                this.f5951p0 = list;
            }
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error loading from preferences", e5);
            this.f5951p0 = new ArrayList();
        }
    }

    @Override // o3.k
    public final void d(boolean z4) {
        Log.d("LaunchActivity", "DMR Connection status changed: " + z4);
        TextView textView = (TextView) findViewById(R.id.locView);
        TextView textView2 = (TextView) findViewById(R.id.sourceView);
        l0();
        f5854E1 = getSharedPreferences("app_settings", 0).getBoolean("multi_rx_enabled", false);
        runOnUiThread(new RunnableC0702o(this, z4, textView, textView2, 1));
    }

    @Override // o3.k
    public final void e(boolean z4) {
    }

    public final void e0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        this.f5942m = Build.DEVICE;
        String strH = c.h(this);
        int iQ = c.q(this);
        Log.i("Unified - DeviceInfo", "Manufacturer: " + str);
        Log.i("Unified - DeviceInfo", "Model: " + str2);
        Log.i("Unified - DeviceInfo", "Android Version: " + str3);
        Log.i("Unified - DeviceInfo", "Device Name: " + this.f5942m);
        Log.i("Unified - DeviceInfo", "Callsign: " + strH);
        Log.i("Unified - DeviceInfo", "DMR ID: " + iQ);
        d0();
    }

    public final void f0(String str) {
        byte[] bArr;
        if (this.f5863B != 1) {
            return;
        }
        synchronized (this.f5903V0) {
            try {
                this.f5898S0 = System.currentTimeMillis();
                if (!this.f5901U0) {
                    this.f5901U0 = true;
                    Thread thread = this.f5905W0;
                    if (thread == null || !thread.isAlive()) {
                        Thread thread2 = new Thread(new RunnableC0672A(this, 1));
                        this.f5905W0 = thread2;
                        thread2.start();
                    }
                }
            } finally {
            }
        }
        if (this.f5863B == 1) {
            C0768d c0768d = this.f5968v;
            if (c0768d != null) {
                if (!c0768d.h.get() || c0768d.f8598i.get() || c0768d.f8599j.get()) {
                    Log.d("DMR_RX", "Not handling voice data - state check failed");
                    c0768d.n();
                    c0768d.m();
                } else {
                    try {
                        byte[] bArrI = C0768d.i(str);
                        if (c0768d.f8595d > 0) {
                            bArrI = c0768d.g(bArrI);
                        }
                        c0768d.k(bArrI);
                        c0768d.f8600k = 0;
                    } catch (Exception e5) {
                        Log.e("DMR_RX", "Error handling voice data", e5);
                        c0768d.h();
                    }
                }
            }
            synchronized (this.f5903V0) {
                try {
                } catch (Exception unused) {
                    bArr = new byte[0];
                } finally {
                }
                if (this.f5866C) {
                    if (!this.f5952p1) {
                        this.f5952p1 = true;
                        this.f5946n1.post(this.f5958r1);
                    }
                    this.f5866C = false;
                    if (this.f5979z != null && (this.f5970w.equals("DMR") || this.f5970w.equals("ROIP"))) {
                        this.f5979z.m();
                        this.f5896R0 = true;
                    } else if (this.f5970w.equals("DMR") || this.f5970w.equals("ROIP")) {
                        new Thread(new RunnableC0672A(this, 2)).start();
                    }
                } else if (this.f5896R0) {
                    if (str.length() % 2 != 0) {
                        bArr = new byte[0];
                    } else {
                        int length = str.length();
                        byte[] bArr2 = new byte[length / 2];
                        for (int i5 = 0; i5 < length; i5 += 2) {
                            bArr2[i5 / 2] = (byte) ((Character.digit(str.charAt(i5), 16) << 4) + Character.digit(str.charAt(i5 + 1), 16));
                        }
                        bArr = bArr2;
                    }
                    if (bArr.length >= 9 && bArr[0] == 104 && bArr[1] == 54 && bArr[8] == 2) {
                        this.f5896R0 = false;
                        runOnUiThread(new RunnableC0672A(this, 3));
                    }
                }
            }
        }
    }

    public void firmwareUpdateClicked(View view) {
        if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 123);
            return;
        }
        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Firmware Update";
        c0467d.f6294f = "Are you sure you want to update the device firmware? Do not power off during update.";
        hVar.e("Update", new DialogInterfaceOnClickListenerC0711t(this, 0));
        hVar.c("Cancel", null);
        hVar.f();
    }

    public final void g0(String str, ArrayList arrayList, boolean z4) {
        try {
            runOnUiThread(new RunnableC0702o(this, z4, new JSONObject(str), arrayList, 0));
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error in parseAndDisplayUR1MultiRXResponse", e5);
            runOnUiThread(new RunnableC0704p(this, arrayList, 0));
        }
    }

    public void groupSelectorClicked(View view) {
    }

    public final void h0(final int i5, final String str, final boolean z4) throws JSONException {
        Log.d("Unified - Main Activity", "parseAndDisplayUR1Response called with: " + str);
        Log.d("Unified - Main Activity", "Talkgroup: " + i5 + ", isSuccess: " + z4);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("success") || !jSONObject.getBoolean("success")) {
                String strOptString = jSONObject.optString("error", "Unknown error");
                Log.d("Unified - Main Activity", "Showing error toast: " + strOptString);
                runOnUiThread(new k3.r(this, strOptString, 4));
                q0(4000);
                n0();
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                Log.d("Unified - Main Activity", "Showing fallback success toast");
                runOnUiThread(new RunnableC0709s(this, i5, 6));
                return;
            }
            final String strOptString2 = jSONObjectOptJSONObject.optString("callsign", "");
            jSONObjectOptJSONObject.optString("device_id", "");
            if ("disconnect".equals(jSONObjectOptJSONObject.optString("operation", ""))) {
                Log.d("Unified - Main Activity", "Showing disconnect toast");
                runOnUiThread(new k3.r(this, strOptString2, 3));
                return;
            }
            if (!jSONObjectOptJSONObject.has("talkgroups_configured")) {
                Log.d("Unified - Main Activity", "Showing default success toast");
                final int i6 = 1;
                runOnUiThread(new Runnable(this) { // from class: k3.B

                    /* renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ LaunchActivity f7939k;

                    {
                        this.f7939k = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2 = strOptString2;
                        int i7 = i5;
                        LaunchActivity launchActivity = this.f7939k;
                        switch (i6) {
                            case 0:
                                Context context = LaunchActivity.f5853D1;
                                launchActivity.getClass();
                                launchActivity.D0("✓ TG " + i7 + " configured (" + str2 + ")");
                                break;
                            default:
                                Context context2 = LaunchActivity.f5853D1;
                                launchActivity.getClass();
                                launchActivity.D0("✓ TG " + i7 + " configured (" + str2 + ")");
                                break;
                        }
                    }
                });
                return;
            }
            JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("talkgroups_configured");
            if (jSONArray.length() <= 0) {
                Log.d("Unified - Main Activity", "Showing single TG success toast");
                final int i7 = 0;
                runOnUiThread(new Runnable(this) { // from class: k3.B

                    /* renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ LaunchActivity f7939k;

                    {
                        this.f7939k = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2 = strOptString2;
                        int i72 = i5;
                        LaunchActivity launchActivity = this.f7939k;
                        switch (i7) {
                            case 0:
                                Context context = LaunchActivity.f5853D1;
                                launchActivity.getClass();
                                launchActivity.D0("✓ TG " + i72 + " configured (" + str2 + ")");
                                break;
                            default:
                                Context context2 = LaunchActivity.f5853D1;
                                launchActivity.getClass();
                                launchActivity.D0("✓ TG " + i72 + " configured (" + str2 + ")");
                                break;
                        }
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i8 = 0; i8 < jSONArray.length(); i8++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i8);
                if (i8 > 0) {
                    sb.append(", ");
                }
                sb.append(jSONObject2.optString("talkgroup", ""));
            }
            Log.d("Unified - Main Activity", "Showing multiple TG success toast");
            runOnUiThread(new f(this, sb, strOptString2, 11));
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Failed to parse UR1 API response", e5);
            if (str.length() < 100) {
                Log.d("Unified - Main Activity", "Showing raw response toast");
                runOnUiThread(new Runnable() { // from class: k3.C
                    @Override // java.lang.Runnable
                    public final void run() {
                        String strD;
                        Context context = LaunchActivity.f5853D1;
                        LaunchActivity launchActivity = this.f7943j;
                        launchActivity.getClass();
                        if (z4) {
                            strD = com.unified.ur1.SatelliteTracker.h.d(new StringBuilder("✓ TG "), i5, " set");
                        } else {
                            strD = "✗ " + str;
                        }
                        launchActivity.D0(strD);
                    }
                });
            } else {
                Log.d("Unified - Main Activity", "Showing generic error toast");
                runOnUiThread(new Runnable() { // from class: k3.D
                    @Override // java.lang.Runnable
                    public final void run() {
                        String strD;
                        Context context = LaunchActivity.f5853D1;
                        boolean z5 = z4;
                        LaunchActivity launchActivity = this.f7950j;
                        if (z5) {
                            launchActivity.getClass();
                            strD = com.unified.ur1.SatelliteTracker.h.d(new StringBuilder("✓ TG "), i5, " configured");
                        } else {
                            strD = "✗ Server error occurred";
                        }
                        launchActivity.D0(strD);
                    }
                });
            }
        }
    }

    public final void hideProgressDialog() {
        DialogC0469f dialogC0469f = this.f5964t1;
        if (dialogC0469f == null || !dialogC0469f.isShowing()) {
            return;
        }
        this.f5964t1.dismiss();
        this.f5964t1 = null;
    }

    public final void i0() {
        this.f5960s0 = new O(this, 8);
        IntentFilter intentFilter = new IntentFilter("com.unified.ur1.ROIP_CONNECT");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f5960s0, intentFilter, 4);
        } else {
            registerReceiver(this.f5960s0, intentFilter);
        }
    }

    public final void j0() {
        String[] strArr = {"android.permission.RECORD_AUDIO", "android.permission.POST_NOTIFICATIONS"};
        for (int i5 = 0; i5 < 2; i5++) {
            if (C.h.a(this, strArr[i5]) != 0) {
                for (int i6 = 0; i6 < 2; i6++) {
                    if (B.e.e(this, strArr[i6])) {
                        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
                        C0467d c0467d = (C0467d) hVar.f1522d;
                        c0467d.f6292d = "Permissions needed";
                        c0467d.f6294f = "This app needs audio recording and notification permissions to function properly";
                        hVar.e("OK", new DialogInterfaceOnClickListenerC0580i(this, 6, strArr));
                        hVar.b().show();
                        return;
                    }
                }
                B.e.d(this, strArr, 123);
                return;
            }
        }
    }

    public final void k0() throws Throwable {
        y1.f.f();
        try {
            this.f5874F0 = (CardView) findViewById(R.id.roip_banner_card);
            this.f5876G0 = (TextView) findViewById(R.id.ROIP_Connection);
            CardView cardView = this.f5874F0;
            if (cardView != null) {
                cardView.setCardBackgroundColor(f5857J1);
                this.f5874F0.setVisibility(8);
                L0(0);
                this.f5874F0.setOnLongClickListener(new W(this, 2));
                Log.d("Unified - Main Activity", "ROIP banner initialized successfully");
            } else {
                Log.e("Unified - Main Activity", "Failed to find roip_banner_card view");
            }
            TextView textView = this.f5876G0;
            if (textView != null) {
                textView.setText("Radio Over IP");
            } else {
                Log.e("Unified - Main Activity", "Failed to find ROIP_Connection text view");
            }
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error initializing ROIP banner", e5);
        }
        Toast.makeText(this, "ROIP Connected", 0).show();
        G0();
        Z();
        try {
            C0432c.a(this).b(this.f5883K0, new IntentFilter("com.unified.ur1.DMR_BUFFERUNDERRUN"));
            Log.d("Unified - Main Activity", "Buffer underrun receiver registered");
        } catch (Exception e6) {
            Log.e("Unified - Main Activity", "Error registering buffer receiver", e6);
        }
        int iL = c.l(this);
        this.f5921e = iL;
        this.f5915b1.subscribeTalkgroup(iL);
        l0();
    }

    public final void l0() {
        this.f5970w = "ROIP";
        this.f5886M = 1;
        TextView textView = (TextView) findViewById(R.id.network);
        TextView textView2 = (TextView) findViewById(R.id.CallerID);
        TextView textView3 = (TextView) findViewById(R.id.activeFrequency);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.status);
        TextView textView4 = (TextView) findViewById(R.id.locView);
        TextView textView5 = (TextView) findViewById(R.id.sourceView);
        textView2.setVisibility(0);
        textView.setVisibility(0);
        linearLayout.setVisibility(8);
        textView.setText(c.y(this) + " - " + c.z(this));
        textView3.setTextColor(Color.parseColor("#000000"));
        textView3.clearAnimation();
        c.q0(this, 1);
        CardView cardView = (CardView) findViewById(R.id.roip_disconnect);
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        CardView cardView2 = this.f5874F0;
        if (cardView2 != null) {
            cardView2.setVisibility(0);
            this.f5874F0.setAlpha(1.0f);
            TextView textView6 = (TextView) this.f5874F0.findViewById(R.id.ROIP_Connection);
            if (textView6 != null) {
                textView6.setText("ROIP Connected");
                textView6.setVisibility(0);
            }
        }
        textView4.setVisibility(0);
        textView5.setVisibility(0);
        String str = "TG: " + this.f5921e;
        textView3.setText(str);
        if (str.length() > 8) {
            textView3.setTextSize(1, Math.max((8.0f / str.length()) * 60.0f, 30.0f));
        } else {
            textView3.setTextSize(1, 60.0f);
        }
    }

    public final void m0() throws Throwable {
        DMRBridge dMRBridge = this.f5915b1;
        if (dMRBridge == null || !dMRBridge.d()) {
            return;
        }
        this.g = true;
        E0.g(R.raw.connected, this, "connected_sound");
        k0();
    }

    public void messageClicked(View view) {
        String str = this.f5900U;
        if (str == null || str.isEmpty() || this.f5900U.equals("NOCALL") || this.f5900U.equals("null")) {
            Toast.makeText(this, "Resyncing ROIP stream...", 0).show();
        } else {
            startActivity(new Intent(this, (Class<?>) UnifiedInboxActivity.class));
        }
    }

    public final void n0() {
        this.f5886M = 0;
        try {
            C0432c.a(this).d(this.f5883K0);
            Log.d("Unified - Main Activity", "Buffer underrun receiver unregistered");
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error unregistering buffer receiver", e5);
        }
        c.q0(this, 0);
        CardView cardView = this.f5874F0;
        if (cardView != null) {
            cardView.setVisibility(8);
            this.f5874F0.setAlpha(BitmapDescriptorFactory.HUE_RED);
            TextView textView = (TextView) this.f5874F0.findViewById(R.id.ROIP_Connection);
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        ((TextView) findViewById(R.id.network)).setVisibility(8);
        ((TextView) findViewById(R.id.activeMemoryName)).setText("Unified Radios");
        ((TextView) findViewById(R.id.activeFrequency)).setText("Ready");
        ((LinearLayout) findViewById(R.id.status)).setVisibility(0);
        CardView cardView2 = (CardView) findViewById(R.id.roip_disconnect);
        if (cardView2 != null) {
            cardView2.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.locView);
        TextView textView3 = (TextView) findViewById(R.id.sourceView);
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        ((ImageView) findViewById(R.id.imagedistance)).setVisibility(4);
        if (textView3 != null) {
            textView3.setVisibility(4);
        }
    }

    public final void o0() {
        try {
            Log.d("Unified - Main Activity", "=== SAVING TO PREFERENCES ===");
            Log.d("Unified - Main Activity", "Number of items to save: " + this.f5951p0.size());
            SharedPreferences sharedPreferences = getSharedPreferences("last_heard_prefs", 0);
            String json = new Gson().toJson((C0525p[]) this.f5951p0.toArray(new C0525p[0]));
            Log.d("Unified - Main Activity", "JSON to save (first 200 chars): " + json.substring(0, Math.min(200, json.length())));
            Log.d("Unified - Main Activity", "JSON length: " + json.length());
            Log.d("Unified - Main Activity", "Save to preferences result: ".concat(sharedPreferences.edit().putString("last_heard_data", json).commit() ? "SUCCESS" : "FAILED"));
            Log.d("Unified - Main Activity", "Verification - saved JSON length: " + sharedPreferences.getString("last_heard_data", "").length());
            Log.d("Unified - Main Activity", "=== FINISHED SAVING TO PREFERENCES ===");
        } catch (Exception e5) {
            Log.e("Unified - Main Activity", "Error saving to preferences", e5);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) throws IOException {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1001) {
            if (!getPackageManager().canRequestPackageInstalls()) {
                Toast.makeText(this, "Permission denied. Cannot install update.", 1).show();
                this.f5967u1 = null;
            } else if (this.f5967u1 != null) {
                Toast.makeText(this, "Permission granted. Installing update...", 0).show();
                a0(this.f5967u1);
                this.f5967u1 = null;
            }
        }
        if (i5 == 0) {
            if (i6 == -1) {
                this.f5919d0.d();
            }
        } else if (i5 != 1) {
            if (i5 != 2) {
                AbstractC0535a.u("Warning: Returned to LaunchActivity from unexpected request code: ", i5, "DEBUG");
            }
        } else if (i6 == -1) {
            int i7 = intent.getExtras().getInt("memoryId");
            C0 c02 = this.f5919d0;
            c02.f7949f = new C0714u0(this, i7);
            c02.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02d4  */
    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r29) {
        /*
            Method dump skipped, instructions count: 2598
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.primary.LaunchActivity.onCreate(android.os.Bundle):void");
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.d("Unified - Main Activity", "=== LaunchActivity onDestroy() starting ===");
        new Thread(new RunnableC0696l(this, 27), "DestroyCleanupThread").start();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) throws Throwable {
        super.onNewIntent(intent);
        if (intent == null || !intent.getBooleanExtra("ROIP_CONNECT", false)) {
            return;
        }
        Log.d("Unified - Main Activity", "ROIP_CONNECT flag detected in onNewIntent");
        m0();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        ThreadPoolExecutor threadPoolExecutor = this.f5922e0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
            this.f5922e0 = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03c1  */
    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onResume() {
        /*
            Method dump skipped, instructions count: 1158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.primary.LaunchActivity.onResume():void");
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onStart() {
        super.onStart();
        try {
            if (findViewById(R.id.pttButton) == null) {
                Log.w("Unified - Main Activity", "PTT Button not found, reinitializing layout");
                setContentView(R.layout.activity_main);
            }
        } catch (Exception e5) {
            com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Error ensuring views initialized: "), "Unified - Main Activity");
        }
        try {
            Intent intent = new Intent(this, (Class<?>) RadioAudioService.class);
            intent.putExtra("callsign", this.f5900U);
            intent.putExtra("squelch", this.f5899T);
            intent.putExtra("activeMemoryId", this.f5925f0);
            intent.putExtra("activeFrequencyStr", this.f5897S);
            P0("callsign", this.f5900U);
            bindService(intent, this.f5969v1, 1);
        } catch (Exception e6) {
            com.unified.ur1.SatelliteTracker.h.o(e6, new StringBuilder("Error in onStart: "), "Unified - Main Activity");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        if (z4) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void optionsClicked(View view) {
        startActivity(new Intent(this, (Class<?>) OptionsActivity.class));
    }

    public final void p0() {
        runOnUiThread(new RunnableC0691i0(1, (AppCompatButton) findViewById(R.id.scanButton)));
        if (this.f5899T == 0) {
            I0(this.f5925f0);
        }
    }

    public void playClicked(View view) {
        C0768d c0768d = new C0768d(this);
        this.f5968v = c0768d;
        c0768d.o();
        this.f5927g0 = 1;
        startActivity(new Intent(this, (Class<?>) RecordingsActivity.class));
    }

    public final void q0(int i5) {
        new Thread(new RunnableC0709s(this, i5, 3)).start();
    }

    public final void r0() {
        this.f5963t0 = new O(this, 6);
        C0432c.a(this).b(this.f5963t0, new IntentFilter("com.unified.ur1.DMR_AUDIO_TRACK_STOPPED"));
    }

    public void radioTeams(View view) {
        String strH = c.h(f5853D1);
        if (strH == null || strH.isEmpty()) {
            Toast.makeText(this, "Please set up your callsign", 1).show();
            return;
        }
        Intent intent = new Intent(this, (Class<?>) RadioTeamsManagerActivity.class);
        intent.putExtra("auto_discover", true);
        intent.putExtra("default_callsign", strH);
        startActivity(intent);
    }

    public final void s0() {
        View viewFindViewById = findViewById(R.id.activeFrequency);
        viewFindViewById.setOnClickListener(new V(this, 2));
        viewFindViewById.setOnLongClickListener(new W(this, 1));
    }

    public void scanClicked(View view) {
        w0();
    }

    public void sendButtonOverlayClicked(View view) throws Resources.NotFoundException {
        String str = this.f5900U;
        if (str == null || str.length() == 0) {
            v0();
            ((ImageButton) findViewById(R.id.sendButton)).setEnabled(false);
        }
    }

    public void sendTextClicked(View view) {
        String strTrim = ((EditText) findViewById(R.id.textChatTo)).getText().toString().trim();
        String upperCase = strTrim.length() == 0 ? "CQ" : strTrim.toUpperCase();
        ((EditText) findViewById(R.id.textChatTo)).setText(upperCase);
        String string = ((EditText) findViewById(R.id.textChatInput)).getText().toString();
        if (string.length() == 0) {
            return;
        }
        RadioAudioService radioAudioService = this.f5965u;
        if (radioAudioService != null) {
            radioAudioService.getClass();
            string.replace('|', ' ').replace('~', ' ').replace('{', ' ');
        }
        ((EditText) findViewById(R.id.textChatInput)).setText("");
        ((TextView) findViewById(R.id.textChatLog)).append(this.f5900U + " to " + upperCase + ": " + string + "\n");
        ((ScrollView) findViewById(R.id.textChatScrollView)).fullScroll(130);
        findViewById(R.id.textChatInput).requestFocus();
    }

    public void settingsClicked(View view) {
        RadioAudioService radioAudioService = this.f5965u;
        if (radioAudioService != null) {
            radioAudioService.b(true);
            if (this.f5965u != null) {
                Log.d("Unified", "SerialOutputStream is null.");
            }
        }
        Q();
        p0();
        Intent intent = new Intent("com.unified.ur1.SETTINGS_ACTION");
        intent.putExtra("requestCode", 2);
        startActivityForResult(intent, 2);
    }

    public final void t0() {
        this.f5910Z.setOnClickListener(new ViewOnClickListenerC0713u(this, 3));
        this.f5917c0.setOnClickListener(new ViewOnClickListenerC0713u(this, 4));
        this.f5912a0.setOnClickListener(new ViewOnClickListenerC0713u(this, 5));
        this.f5914b0.setOnClickListener(new ViewOnClickListenerC0713u(this, 6));
    }

    public final void u0(Spinner spinner, int i5) {
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this, i5, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
    }

    public final void v0() throws Resources.NotFoundException {
        q2.k kVarG = q2.k.g(this, findViewById(R.id.mainTopLevelLayout), "Set your callsign to send text chat", 0);
        V v4 = new V(this, 3);
        q2.h hVar = kVarG.f9462i;
        Button actionView = ((SnackbarContentLayout) hVar.getChildAt(0)).getActionView();
        q2.f fVar = null;
        if (TextUtils.isEmpty("Set now")) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            kVarG.f9477D = false;
        } else {
            kVarG.f9477D = true;
            actionView.setVisibility(0);
            actionView.setText("Set now");
            actionView.setOnClickListener(new o0(kVarG, 9, v4));
        }
        kVarG.h(getResources().getColor(R.color.primary));
        kVarG.i(getResources().getColor(R.color.medium_gray));
        ((SnackbarContentLayout) hVar.getChildAt(0)).getActionView().setTextColor(getResources().getColor(R.color.black));
        View viewFindViewById = findViewById(R.id.textChatInput);
        q2.f fVar2 = kVarG.f9465l;
        if (fVar2 != null) {
            fVar2.a();
        }
        if (viewFindViewById != null) {
            fVar = new q2.f(kVarG, viewFindViewById);
            WeakHashMap weakHashMap = O.Y.f1904a;
            if (J.b(viewFindViewById)) {
                viewFindViewById.getViewTreeObserver().addOnGlobalLayoutListener(fVar);
            }
            viewFindViewById.addOnAttachStateChangeListener(fVar);
        }
        kVarG.f9465l = fVar;
        this.f5891P = kVarG;
        ((TextView) hVar.findViewById(R.id.snackbar_action)).setTextSize(20.0f);
        ((TextView) this.f5891P.f9462i.findViewById(R.id.snackbar_text)).setTextSize(20.0f);
        this.f5891P.j();
    }

    public final void w0() {
        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Select Channel Source";
        String[] strArr = !f5855F1 ? new String[]{"Cloud Memory Channels", "Unified Repeater Directory", "Local Repeater Map"} : new String[]{"Cloud Memory Channels", "Unified Repeater Directory", "Local Repeater Map"};
        DialogInterfaceOnClickListenerC0681d0 dialogInterfaceOnClickListenerC0681d0 = new DialogInterfaceOnClickListenerC0681d0(4, this);
        c0467d.f6301p = strArr;
        c0467d.f6303r = dialogInterfaceOnClickListenerC0681d0;
        hVar.c("Cancel", null);
        hVar.b().show();
    }

    public final void x0(String str) {
        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Error";
        c0467d.f6294f = str;
        hVar.e("OK", null);
        hVar.f();
    }

    public final void y0() {
        String string = c.C(this).getString("channel_freq", "");
        long jE = c.E(this);
        long jA = c.A(this);
        int iD = c.D(f5853D1);
        int i5 = c.C(f5853D1).getInt("tx_type", 0);
        int iF = c.F(f5853D1);
        int i6 = c.C(f5853D1).getInt("rx_type", 0);
        int iB = c.B(f5853D1);
        c.C(f5853D1).getInt("contact_type", 1);
        c.v(f5853D1);
        int i7 = c.C(f5853D1).getInt("color_code", 2);
        c.C(f5853D1).getInt("inbound_slot", 0);
        runOnUiThread(new RunnableC0712t0(this, c.C(f5853D1).getInt("outbound_slot", 0), new int[]{0}, jE, jA, i6, iB, i5, iF, iD, i7, string));
    }

    public final void z0() {
        h hVar = new h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Permission Required";
        c0467d.f6294f = "To install the update, you need to allow installation from unknown sources in your device settings.";
        hVar.e("Go to Settings", new DialogInterfaceOnClickListenerC0711t(this, 2));
        hVar.c("Cancel", new DialogInterfaceOnClickListenerC0711t(this, 3));
        hVar.f();
    }
}
