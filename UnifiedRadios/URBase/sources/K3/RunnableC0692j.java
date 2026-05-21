package k3;

import android.media.AudioTrack;
import android.util.Log;
import com.unified.ur1.primary.DTMFKeypad;
import java.util.HashMap;
import p3.C0836b;

/* renamed from: k3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0692j implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8141j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DTMFKeypad f8142k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0836b f8143l;

    public /* synthetic */ RunnableC0692j(DTMFKeypad dTMFKeypad, C0836b c0836b, int i5) {
        this.f8141j = i5;
        this.f8142k = dTMFKeypad;
        this.f8143l = c0836b;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        int i5 = 2;
        int i6 = 1;
        C0836b c0836b = this.f8143l;
        DTMFKeypad dTMFKeypad = this.f8142k;
        switch (this.f8141j) {
            case 0:
                HashMap map = DTMFKeypad.f5846k;
                dTMFKeypad.getClass();
                if (c0836b != null) {
                    Log.d("DTMFKeypad", "Starting TX transmission");
                    c0836b.d(true);
                    if (c0836b.g.get()) {
                        Log.d("DTMFKeypad", "TX already transmitting, stopping first");
                        c0836b.f();
                        dTMFKeypad.f5849e.postDelayed(new RunnableC0692j(dTMFKeypad, c0836b, i6), 200L);
                    } else {
                        c0836b.e();
                        dTMFKeypad.f5849e.postDelayed(new RunnableC0692j(dTMFKeypad, c0836b, i5), 300L);
                    }
                } else {
                    Log.e("DTMFKeypad", "TX instance is null");
                    dTMFKeypad.g = false;
                }
                AudioTrack audioTrack = dTMFKeypad.f5850f;
                if (audioTrack != null && audioTrack.getState() == 1) {
                    try {
                        dTMFKeypad.f5850f.play();
                        Log.d("DTMFKeypad", "AudioTrack playback started for local feedback");
                        break;
                    } catch (Exception e5) {
                        Log.e("DTMFKeypad", "Failed to start AudioTrack playback", e5);
                        return;
                    }
                }
                break;
            case 1:
                HashMap map2 = DTMFKeypad.f5846k;
                dTMFKeypad.getClass();
                c0836b.d(true);
                c0836b.e();
                dTMFKeypad.f5849e.postDelayed(new RunnableC0692j(dTMFKeypad, c0836b, i5), 300L);
                break;
            case 2:
                HashMap map3 = DTMFKeypad.f5846k;
                dTMFKeypad.getClass();
                boolean z4 = c0836b.g.get();
                Log.d("DTMFKeypad", "TX transmission status after start: " + z4);
                if (!z4) {
                    Log.w("DTMFKeypad", "TX failed to start, retrying with state reset...");
                    c0836b.d(true);
                    c0836b.e();
                    dTMFKeypad.f5849e.postDelayed(new RunnableC0692j(dTMFKeypad, c0836b, 3), 300L);
                    break;
                }
                break;
            default:
                HashMap map4 = DTMFKeypad.f5846k;
                dTMFKeypad.getClass();
                boolean z5 = c0836b.g.get();
                Log.d("DTMFKeypad", "TX final state after retry: " + z5);
                if (!z5) {
                    Log.e("DTMFKeypad", "TX failed to start after retry, resetting local state");
                    dTMFKeypad.g = false;
                    break;
                }
                break;
        }
    }
}
