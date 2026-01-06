package f3;

import J1.C0113v0;
import J1.InterfaceC0054b0;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.InterfaceC0239i;
import c0.AbstractC0290b;
import c0.C0289a;
import c0.C0291c;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;
import l0.AbstractC0737m;
import l0.C0738n;
import l3.InterfaceC0748f;
import q0.C0847j;
import q1.C0862m;
import q1.C0865p;
import q1.C0866q;
import r3.InterfaceC0877a;
import s1.C0886b;

/* renamed from: f3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0513e implements InterfaceC0054b0, InterfaceC0877a, InterfaceC0748f {

    /* renamed from: f, reason: collision with root package name */
    public static C0513e f6685f;
    public static C0513e g;

    /* renamed from: c, reason: collision with root package name */
    public Object f6686c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6687d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6688e;

    public /* synthetic */ C0513e(Object obj, Object obj2, Object obj3) {
        this.f6686c = obj;
        this.f6687d = obj2;
        this.f6688e = obj3;
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        J1.D d5 = new J1.D(iArr, valueAnimator);
        valueAnimator.addListener((S1.a) this.f6688e);
        ((ArrayList) this.f6686c).add(d5);
    }

    @Override // l3.InterfaceC0748f
    public void b(String str) {
        Log.e("RadioTeamsActivity", "Auto-login failed: " + str);
        RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) this.f6688e;
        Toast.makeText(radioTeamsActivity, "Login failed: " + str, 1).show();
        int i5 = RadioTeamsActivity.f6010u;
        radioTeamsActivity.getClass();
        AlertDialog.Builder builder = new AlertDialog.Builder(radioTeamsActivity);
        LinearLayout linearLayout = new LinearLayout(radioTeamsActivity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(50, 40, 50, 10);
        EditText editText = new EditText(radioTeamsActivity);
        editText.setHint("Team ID");
        String str2 = (String) this.f6686c;
        if (str2 == null) {
            str2 = "";
        }
        editText.setText(str2);
        linearLayout.addView(editText);
        EditText editText2 = new EditText(radioTeamsActivity);
        editText2.setHint("Callsign");
        String str3 = (String) this.f6687d;
        editText2.setText(str3 != null ? str3 : "");
        linearLayout.addView(editText2);
        builder.setView(linearLayout).setTitle("Manual Login").setMessage("Auto-login failed. Please verify your credentials:").setPositiveButton("Login", new S(radioTeamsActivity, editText, editText2, 4)).setNegativeButton("Cancel", new DialogInterfaceOnClickListenerC0520k(5, radioTeamsActivity)).show();
    }

    public androidx.lifecycle.S c(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName), cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public androidx.lifecycle.S d(String str, Class cls) {
        androidx.lifecycle.S sB;
        F3.i.f(str, "key");
        androidx.lifecycle.W w4 = (androidx.lifecycle.W) this.f6686c;
        w4.getClass();
        LinkedHashMap linkedHashMap = w4.f3951a;
        androidx.lifecycle.S s4 = (androidx.lifecycle.S) linkedHashMap.get(str);
        boolean zIsInstance = cls.isInstance(s4);
        androidx.lifecycle.V v4 = (androidx.lifecycle.V) this.f6687d;
        if (!zIsInstance) {
            C0291c c0291c = new C0291c((AbstractC0290b) this.f6688e);
            c0291c.f4544a.put(androidx.lifecycle.T.f3948d, str);
            try {
                sB = v4.f(cls, c0291c);
            } catch (AbstractMethodError unused) {
                sB = v4.b(cls);
            }
            F3.i.f(sB, "viewModel");
            androidx.lifecycle.S s5 = (androidx.lifecycle.S) linkedHashMap.put(str, sB);
            if (s5 != null) {
                s5.b();
            }
            return sB;
        }
        androidx.lifecycle.P p4 = v4 instanceof androidx.lifecycle.P ? (androidx.lifecycle.P) v4 : null;
        if (p4 != null) {
            F3.i.c(s4);
            AbstractC0245o abstractC0245o = p4.f3935f;
            if (abstractC0245o != null) {
                o0.c cVar = p4.g;
                F3.i.c(cVar);
                androidx.lifecycle.M.a(s4, cVar, abstractC0245o);
            }
        }
        F3.i.d(s4, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return s4;
    }

    public C0511d e(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT * FROM app_settings WHERE `name` LIKE ? LIMIT 1");
        c0738nO.h(1, str);
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f6686c;
        abstractC0737m.b();
        C0511d c0511d = null;
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            int iH = L0.f.h(cursorM, "name");
            int iH2 = L0.f.h(cursorM, "value");
            if (cursorM.moveToFirst()) {
                C0511d c0511d2 = new C0511d();
                if (cursorM.isNull(iH)) {
                    c0511d2.f6683a = null;
                } else {
                    c0511d2.f6683a = cursorM.getString(iH);
                }
                if (cursorM.isNull(iH2)) {
                    c0511d2.f6684b = null;
                } else {
                    c0511d2.f6684b = cursorM.getString(iH2);
                }
                c0511d = c0511d2;
            }
            cursorM.close();
            c0738nO.s();
            return c0511d;
        } catch (Throwable th) {
            cursorM.close();
            c0738nO.s();
            throw th;
        }
    }

    public void f(int i5) {
        PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f6688e;
        if (wakeLock != null && !wakeLock.isHeld()) {
            try {
                ((PowerManager.WakeLock) this.f6688e).acquire(600000L);
                Log.d("VolumeControlHandler", "Wake lock reacquired");
            } catch (Exception e5) {
                com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Failed to reacquire wake lock: "), "VolumeControlHandler");
            }
        }
        AudioManager audioManager = (AudioManager) this.f6686c;
        int streamVolume = audioManager.getStreamVolume(3);
        boolean z4 = false;
        int iMin = Math.min(Math.max(i5 + streamVolume, 0), audioManager.getStreamMaxVolume(3));
        audioManager.setStreamVolume(3, iMin, i() ? 1 : 0);
        StringBuilder sb = new StringBuilder("Volume adjusted from ");
        sb.append(streamVolume);
        sb.append(" to ");
        sb.append(iMin);
        sb.append(" (Background: ");
        PowerManager.WakeLock wakeLock2 = (PowerManager.WakeLock) this.f6688e;
        if (wakeLock2 != null && wakeLock2.isHeld()) {
            z4 = true;
        }
        sb.append(z4);
        sb.append(", Screen: ");
        sb.append(i());
        sb.append(")");
        Log.d("VolumeControlHandler", sb.toString());
    }

    public void g(C0511d... c0511dArr) {
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f6686c;
        abstractC0737m.b();
        abstractC0737m.c();
        try {
            L0.b bVar = (L0.b) this.f6687d;
            bVar.getClass();
            C0847j c0847jA = bVar.a();
            try {
                for (C0511d c0511d : c0511dArr) {
                    bVar.q(c0847jA, c0511d);
                    c0847jA.a();
                }
                bVar.n(c0847jA);
                abstractC0737m.o();
            } catch (Throwable th) {
                bVar.n(c0847jA);
                throw th;
            }
        } finally {
            abstractC0737m.k();
        }
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return new Z0.d((Context) ((InterfaceC0877a) this.f6686c).get(), (h1.d) ((InterfaceC0877a) this.f6687d).get(), (h1.d) ((InterfaceC0877a) this.f6688e).get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[Catch: all -> 0x000d, TRY_ENTER, TryCatch #0 {all -> 0x000d, blocks: (B:4:0x000a, B:22:0x006b, B:25:0x008f, B:14:0x0023, B:16:0x004d, B:18:0x0058, B:20:0x0063, B:21:0x0067), top: B:30:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:4:0x000a, B:22:0x006b, B:25:0x008f, B:14:0x0023, B:16:0x004d, B:18:0x0058, B:20:0x0063, B:21:0x0067), top: B:30:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.String] */
    @Override // J1.InterfaceC0054b0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(java.lang.String r5, int r6, java.io.IOException r7, byte[] r8, java.util.Map r9) {
        /*
            r4 = this;
            java.lang.Object r5 = r4.f6688e
            J1.V1 r5 = (J1.V1) r5
            g0.AbstractC0535a.q(r5)
            r9 = 0
            if (r8 != 0) goto L10
            byte[] r8 = new byte[r9]     // Catch: java.lang.Throwable -> Ld
            goto L10
        Ld:
            r6 = move-exception
            goto La9
        L10:
            r0 = 200(0xc8, float:2.8E-43)
            java.lang.Object r1 = r4.f6687d
            J1.W1 r1 = (J1.W1) r1
            java.lang.Object r2 = r4.f6686c
            java.lang.String r2 = (java.lang.String) r2
            if (r6 == r0) goto L21
            r0 = 204(0xcc, float:2.86E-43)
            if (r6 != r0) goto L6b
            r6 = r0
        L21:
            if (r7 != 0) goto L6b
            J1.n r7 = r5.f1019e     // Catch: java.lang.Throwable -> Ld
            J1.V1.J(r7)     // Catch: java.lang.Throwable -> Ld
            long r0 = r1.f1047a     // Catch: java.lang.Throwable -> Ld
            java.lang.Long r8 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> Ld
            r7.x(r8)     // Catch: java.lang.Throwable -> Ld
            J1.Z r7 = r5.c()     // Catch: java.lang.Throwable -> Ld
            J1.X r7 = r7.f1084p     // Catch: java.lang.Throwable -> Ld
            java.lang.String r8 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Ld
            r7.c(r2, r6, r8)     // Catch: java.lang.Throwable -> Ld
            J1.g r6 = r5.d0()     // Catch: java.lang.Throwable -> Ld
            J1.G r7 = J1.H.f771M0     // Catch: java.lang.Throwable -> Ld
            r8 = 0
            boolean r6 = r6.w(r8, r7)     // Catch: java.lang.Throwable -> Ld
            if (r6 == 0) goto L67
            J1.d0 r6 = r5.f1018d     // Catch: java.lang.Throwable -> Ld
            J1.V1.J(r6)     // Catch: java.lang.Throwable -> Ld
            boolean r6 = r6.I()     // Catch: java.lang.Throwable -> Ld
            if (r6 == 0) goto L67
            J1.n r6 = r5.f1019e     // Catch: java.lang.Throwable -> Ld
            J1.V1.J(r6)     // Catch: java.lang.Throwable -> Ld
            boolean r6 = r6.I(r2)     // Catch: java.lang.Throwable -> Ld
            if (r6 == 0) goto L67
            r5.W(r2)     // Catch: java.lang.Throwable -> Ld
            goto La3
        L67:
            r5.D()     // Catch: java.lang.Throwable -> Ld
            goto La3
        L6b:
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> Ld
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> Ld
            r0.<init>(r8, r3)     // Catch: java.lang.Throwable -> Ld
            int r8 = r0.length()     // Catch: java.lang.Throwable -> Ld
            r3 = 32
            int r8 = java.lang.Math.min(r3, r8)     // Catch: java.lang.Throwable -> Ld
            java.lang.String r8 = r0.substring(r9, r8)     // Catch: java.lang.Throwable -> Ld
            J1.Z r0 = r5.c()     // Catch: java.lang.Throwable -> Ld
            J1.X r0 = r0.f1082m     // Catch: java.lang.Throwable -> Ld
            java.lang.String r3 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Ld
            if (r7 != 0) goto L8f
            r7 = r8
        L8f:
            r0.d(r3, r2, r6, r7)     // Catch: java.lang.Throwable -> Ld
            J1.n r6 = r5.f1019e     // Catch: java.lang.Throwable -> Ld
            J1.V1.J(r6)     // Catch: java.lang.Throwable -> Ld
            long r7 = r1.f1047a     // Catch: java.lang.Throwable -> Ld
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> Ld
            r6.A(r7)     // Catch: java.lang.Throwable -> Ld
            r5.D()     // Catch: java.lang.Throwable -> Ld
        La3:
            r5.f1034w = r9
            r5.A()
            return
        La9:
            r5.f1034w = r9
            r5.A()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.C0513e.h(java.lang.String, int, java.io.IOException, byte[], java.util.Map):void");
    }

    public boolean i() {
        try {
            PowerManager powerManager = (PowerManager) ((Context) this.f6687d).getSystemService("power");
            if (powerManager != null) {
                return powerManager.isInteractive();
            }
            return true;
        } catch (Exception e5) {
            com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Failed to check screen state: "), "VolumeControlHandler");
            return true;
        }
    }

    public void j(C0511d c0511d) {
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f6686c;
        abstractC0737m.b();
        abstractC0737m.c();
        try {
            L0.p pVar = (L0.p) this.f6688e;
            C0847j c0847jA = pVar.a();
            try {
                pVar.q(c0847jA, c0511d);
                c0847jA.c();
                pVar.n(c0847jA);
                abstractC0737m.o();
            } catch (Throwable th) {
                pVar.n(c0847jA);
                throw th;
            }
        } finally {
            abstractC0737m.k();
        }
    }

    public synchronized void k(int i5, int i6, long j5, long j6) {
        ((C0113v0) this.f6686c).f1421p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = (AtomicLong) this.f6688e;
        if (atomicLong.get() != -1 && jElapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        N1.r rVarE = ((C0886b) this.f6687d).e(new C0865p(0, Arrays.asList(new C0862m(36301, i5, 0, j5, j6, null, null, 0, i6))));
        J1.U u4 = new J1.U(this, jElapsedRealtime);
        rVarE.getClass();
        rVarE.a(N1.l.f1790a, u4);
    }

    @Override // l3.InterfaceC0748f
    public void m() {
        Log.d("RadioTeamsActivity", "Auto-login successful, token received");
    }

    public /* synthetic */ C0513e(Object obj, Object obj2, String str) {
        this.f6686c = str;
        this.f6687d = obj2;
        this.f6688e = obj;
    }

    public C0513e(Context context, C0113v0 c0113v0) {
        this.f6688e = new AtomicLong(-1L);
        this.f6687d = new C0886b(context, null, C0886b.f9575i, new C0866q("measurement:api"), o1.g.f8899b);
        this.f6686c = c0113v0;
    }

    public C0513e(Context context) {
        this.f6687d = context;
        this.f6686c = (AudioManager) context.getSystemService("audio");
        new Handler(Looper.getMainLooper());
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "VolumeControl:WakeLock");
                this.f6688e = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire(600000L);
                Log.d("VolumeControlHandler", "Wake lock acquired for background operation");
            }
        } catch (Exception e5) {
            com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Failed to acquire wake lock: "), "VolumeControlHandler");
        }
    }

    public C0513e(androidx.lifecycle.W w4, androidx.lifecycle.V v4, AbstractC0290b abstractC0290b) {
        F3.i.f(w4, "store");
        F3.i.f(v4, "factory");
        F3.i.f(abstractC0290b, "defaultCreationExtras");
        this.f6686c = w4;
        this.f6687d = v4;
        this.f6688e = abstractC0290b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0513e(androidx.lifecycle.W w4, androidx.lifecycle.V v4) {
        this(w4, v4, (AbstractC0290b) C0289a.f4543b);
        F3.i.f(w4, "store");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0513e(androidx.lifecycle.X x4) {
        androidx.lifecycle.V defaultViewModelProviderFactory;
        AbstractC0290b defaultViewModelCreationExtras;
        F3.i.f(x4, "owner");
        androidx.lifecycle.W viewModelStore = x4.getViewModelStore();
        boolean z4 = x4 instanceof InterfaceC0239i;
        if (z4) {
            defaultViewModelProviderFactory = ((InterfaceC0239i) x4).getDefaultViewModelProviderFactory();
        } else {
            if (androidx.lifecycle.T.f3949e == null) {
                androidx.lifecycle.T.f3949e = new androidx.lifecycle.T();
            }
            defaultViewModelProviderFactory = androidx.lifecycle.T.f3949e;
            F3.i.c(defaultViewModelProviderFactory);
        }
        if (z4) {
            defaultViewModelCreationExtras = ((InterfaceC0239i) x4).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = C0289a.f4543b;
        }
        this(viewModelStore, defaultViewModelProviderFactory, defaultViewModelCreationExtras);
    }
}
