package com.unified.ur1.primary;

import C0.A;
import D0.f;
import android.content.Context;
import android.content.Intent;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import com.google.android.material.datepicker.l;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.rfmodule.DmrAudioService;
import g3.ViewOnTouchListenerC0549B;
import h1.C0558b;
import java.util.HashMap;
import k3.RunnableC0688h;
import k3.RunnableC0692j;
import k3.ViewOnTouchListenerC0694k;
import p3.C0836b;

/* loaded from: classes.dex */
public class DTMFKeypad extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap f5846k;

    /* renamed from: c, reason: collision with root package name */
    public A f5847c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f5848d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f5849e;

    /* renamed from: f, reason: collision with root package name */
    public final AudioTrack f5850f;
    public boolean g;
    public final C0558b h;

    /* renamed from: i, reason: collision with root package name */
    public final Button[] f5851i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f5852j;

    static {
        HashMap map = new HashMap();
        f5846k = map;
        map.put("1", new int[]{697, 1209});
        map.put("2", new int[]{697, 1336});
        map.put("3", new int[]{697, 1477});
        map.put("A", new int[]{697, 1633});
        map.put("4", new int[]{770, 1209});
        map.put("5", new int[]{770, 1336});
        map.put("6", new int[]{770, 1477});
        map.put("B", new int[]{770, 1633});
        map.put("7", new int[]{852, 1209});
        map.put("8", new int[]{852, 1336});
        map.put("9", new int[]{852, 1477});
        map.put("C", new int[]{852, 1633});
        map.put("*", new int[]{941, 1209});
        map.put("0", new int[]{941, 1336});
        map.put("#", new int[]{941, 1477});
        map.put("D", new int[]{941, 1633});
    }

    public DTMFKeypad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = false;
        this.f5851i = new Button[16];
        this.f5852j = new String[]{"1", "2", "3", "A", "4", "5", "6", "B", "7", "8", "9", "C", "*", "0", "#", "D"};
        this.f5848d = context;
        this.f5849e = new Handler(Looper.getMainLooper());
        this.h = new C0558b(5);
        setOrientation(1);
        GridLayout gridLayout = new GridLayout(this.f5848d);
        gridLayout.setRowCount(4);
        gridLayout.setColumnCount(4);
        gridLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int i5 = 0;
        while (true) {
            String[] strArr = this.f5852j;
            if (i5 >= strArr.length) {
                addView(gridLayout);
                LinearLayout linearLayout = new LinearLayout(this.f5848d);
                linearLayout.setOrientation(0);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                Button button = new Button(this.f5848d);
                button.setText("PTT");
                button.setOnTouchListener(new ViewOnTouchListenerC0549B(2, this));
                Button button2 = new Button(this.f5848d);
                button2.setText("STOP");
                button2.setOnClickListener(new l(3, this));
                linearLayout.addView(button);
                linearLayout.addView(button2);
                addView(linearLayout);
                try {
                    int minBufferSize = AudioTrack.getMinBufferSize(8000, 4, 2);
                    this.f5850f = new AudioTrack(3, 8000, 4, 2, minBufferSize * 2, 1);
                    Log.d("DTMFKeypad", "AudioTrack initialized with buffer size: " + minBufferSize);
                    return;
                } catch (Exception e5) {
                    Log.e("DTMFKeypad", "Failed to initialize AudioTrack", e5);
                    return;
                }
            }
            Button button3 = new Button(this.f5848d);
            button3.setText(strArr[i5]);
            button3.setTextSize(18.0f);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = 0;
            layoutParams.height = -2;
            layoutParams.columnSpec = GridLayout.spec(Integer.MIN_VALUE, 1.0f);
            layoutParams.setMargins(4, 4, 4, 4);
            button3.setLayoutParams(layoutParams);
            button3.setOnTouchListener(new ViewOnTouchListenerC0694k(this, strArr[i5]));
            this.f5851i[i5] = button3;
            gridLayout.addView(button3);
            i5++;
        }
    }

    public final void a(String str) {
        HashMap map = f5846k;
        if (!map.containsKey(str)) {
            Log.w("DTMFKeypad", "Unknown DTMF key: " + str);
            return;
        }
        int[] iArr = (int[]) map.get(str);
        if (iArr != null && iArr.length == 2) {
            new Thread(new f(this, iArr, str, 8), "DTMF-Tone-Thread").start();
            return;
        }
        Log.w("DTMFKeypad", "Invalid frequencies for key: " + str);
    }

    public final void b(short[] sArr) {
        AudioTrack audioTrack = this.f5850f;
        if (audioTrack == null || audioTrack.getState() != 1) {
            return;
        }
        try {
            if (this.f5850f.getPlayState() != 3) {
                this.f5850f.play();
            }
            Log.d("DTMFKeypad", "Local DTMF tone written: " + this.f5850f.write(sArr, 0, sArr.length) + " samples");
            this.f5850f.write(new short[1600], 0, 1600);
        } catch (Exception e5) {
            Log.e("DTMFKeypad", "Error playing local DTMF tone", e5);
        }
    }

    public final void c(C0836b c0836b, short[] sArr) {
        int length = sArr.length * 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < sArr.length; i5++) {
            int i6 = i5 * 2;
            short s4 = sArr[i5];
            bArr[i6] = (byte) (s4 & 255);
            bArr[i6 + 1] = (byte) ((s4 >> 8) & 255);
        }
        StringBuilder sbF = h.f("Sending DTMF: ", length, " bytes in ");
        sbF.append((length / 320) + 1);
        sbF.append(" frames");
        Log.d("DTMFKeypad", sbF.toString());
        new Thread(new f(this, c0836b, bArr, 7), "DTMF-RF-Thread").start();
    }

    public final void d(short[] sArr) {
        try {
            C0836b c0836bB = C0836b.b(this.f5848d);
            if (c0836bB == null) {
                Log.e("DTMFKeypad", "TX instance is null");
                return;
            }
            boolean z4 = c0836bB.g.get();
            Log.d("DTMFKeypad", "TX transmitting state: " + z4);
            if (z4) {
                c(c0836bB, sArr);
                return;
            }
            Log.w("DTMFKeypad", "TX not transmitting, DTMF tone not sent to radio");
            if (this.g) {
                Log.d("DTMFKeypad", "Local isTransmitting=true but TX not transmitting, attempting to start TX");
                c0836bB.e();
                this.f5849e.postDelayed(new f(this, c0836bB, sArr, 9), 200L);
            }
        } catch (Exception e5) {
            Log.e("DTMFKeypad", "Error sending DTMF tone to radio", e5);
        }
    }

    public final void e() {
        StringBuilder sbH = h.h("DTMFKeypad", "Starting PTT transmission sequence", "Current state - isTransmitting: ");
        sbH.append(this.g);
        Log.d("DTMFKeypad", sbH.toString());
        C0836b c0836bB = C0836b.b(this.f5848d);
        if (c0836bB != null) {
            Log.d("DTMFKeypad", "TX state before start: " + c0836bB.g.get());
            c0836bB.d(true);
            Log.d("DTMFKeypad", "TX transmission allowed set to true");
        } else {
            Log.e("DTMFKeypad", "TX instance is null in startPtt");
        }
        if (!this.g) {
            this.g = true;
            this.f5848d.startForegroundService(new Intent(this.f5848d, (Class<?>) DmrAudioService.class));
            this.f5849e.postDelayed(new RunnableC0692j(this, c0836bB, 0), 100L);
            Log.d("DTMFKeypad", "PTT transmission sequence initiated");
            return;
        }
        Log.d("DTMFKeypad", "Already transmitting locally");
        if (c0836bB == null || c0836bB.g.get()) {
            return;
        }
        Log.d("DTMFKeypad", "Local transmitting but TX not transmitting, starting TX");
        c0836bB.d(true);
        c0836bB.e();
    }

    public final void f() {
        Log.d("DTMFKeypad", "Stopping PTT transmission");
        if (!this.g) {
            Log.d("DTMFKeypad", "Not transmitting");
            return;
        }
        this.g = false;
        A a2 = this.f5847c;
        if (a2 != null) {
            this.f5849e.removeCallbacks(a2);
            this.f5847c = null;
        }
        AudioTrack audioTrack = this.f5850f;
        if (audioTrack != null) {
            try {
                if (audioTrack.getPlayState() == 3) {
                    this.f5850f.pause();
                    this.f5850f.flush();
                }
                Log.d("DTMFKeypad", "AudioTrack stopped");
            } catch (Exception e5) {
                Log.e("DTMFKeypad", "Error stopping AudioTrack", e5);
            }
        }
        C0836b c0836bB = C0836b.b(this.f5848d);
        if (c0836bB != null) {
            try {
                Log.d("DTMFKeypad", "TX state before stop: " + c0836bB.g.get());
                c0836bB.f();
                this.f5849e.postDelayed(new RunnableC0688h(c0836bB, 0), 200L);
            } catch (Exception e6) {
                Log.e("DTMFKeypad", "Error stopping TX transmission", e6);
            }
        } else {
            Log.e("DTMFKeypad", "TX instance is null when stopping");
        }
        Log.d("DTMFKeypad", "PTT transmission stopped");
    }

    public String getTransmissionStatus() {
        C0836b c0836bB = C0836b.b(this.f5848d);
        return "Local: " + this.g + ", RF: " + (c0836bB != null && c0836bB.g.get());
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        for (Button button : this.f5851i) {
            if (button != null) {
                button.setEnabled(z4);
            }
        }
    }
}
