package k3;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.media.AudioRecord;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import com.unified.ur1.rfmodule.RadioAudioService;
import f3.C0518i;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import l0.AbstractC0732h;
import l0.C0733i;
import l3.RunnableC0743a;
import m.C0754b;
import n1.C0785b;
import p1.BinderC0823D;
import q0.C0840c;
import q0.C0847j;
import u3.C0917h;

/* renamed from: k3.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0691i0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8139j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f8140k;

    public /* synthetic */ RunnableC0691i0(int i5, Object obj) {
        this.f8139j = i5;
        this.f8140k = obj;
    }

    public C0917h a() {
        C0733i c0733i = (C0733i) this.f8140k;
        C0917h c0917h = new C0917h();
        Cursor cursorM = c0733i.f8340a.m(new S3.w("SELECT * FROM room_table_modification_log WHERE invalidated = 1;", 1), null);
        while (cursorM.moveToNext()) {
            try {
                c0917h.add(Integer.valueOf(cursorM.getInt(0)));
            } finally {
            }
        }
        AbstractC0399v1.b(cursorM, null);
        C0917h c0917hA = h4.c.a(c0917h);
        if (!c0917hA.f9964j.isEmpty()) {
            if (((C0733i) this.f8140k).g == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            C0847j c0847j = ((C0733i) this.f8140k).g;
            if (c0847j == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            c0847j.c();
        }
        return c0917hA;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        Set setA;
        int i5 = 0;
        int i6 = 1;
        switch (this.f8139j) {
            case 0:
                RunnableC0693j0 runnableC0693j0 = (RunnableC0693j0) this.f8140k;
                float f5 = (runnableC0693j0.f8144j + 128.0f) / 256.0f;
                ImageView imageView = (ImageView) runnableC0693j0.f8145k.findViewById(R.id.txAudioCircle);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                RadioAudioService radioAudioService = runnableC0693j0.f8145k.f5965u;
                int i7 = radioAudioService != null ? radioAudioService.f6086f : -1;
                byte b5 = runnableC0693j0.f8144j;
                marginLayoutParams.width = (b5 == -128 || i7 == 0) ? 0 : ((int) (LaunchActivity.G1 * f5)) + LaunchActivity.f5856H1;
                if (b5 != -128 && i7 != 0) {
                    i5 = LaunchActivity.f5856H1 + ((int) (LaunchActivity.G1 * f5));
                }
                marginLayoutParams.height = i5;
                imageView.setLayoutParams(marginLayoutParams);
                return;
            case 1:
                ((AppCompatButton) this.f8140k).setText("CHANNELS");
                return;
            case 2:
                C0714u0 c0714u0 = (C0714u0) this.f8140k;
                Object obj = c0714u0.f8221c.f5919d0.f7948e.f3899e;
                if (obj == androidx.lifecycle.A.f3894k) {
                    obj = null;
                }
                List list = (List) obj;
                for (int i8 = 0; i8 < list.size(); i8++) {
                    if (((C0518i) list.get(i8)).f6721a == c0714u0.f8220b) {
                        C0 c02 = c0714u0.f8221c.f5919d0;
                        c02.c();
                        RadioAudioService radioAudioService2 = c0714u0.f8221c.f5965u;
                        if (radioAudioService2 != null) {
                            radioAudioService2.g((C0518i) list.get(i8), c0714u0.f8221c.f5899T, false);
                        }
                        c0714u0.f8221c.I0(((C0518i) list.get(i8)).f6721a);
                    }
                }
                c0714u0.f8221c.f5919d0.f7949f = null;
                return;
            case 3:
                int i9 = OptionsActivity.f5981H;
                OptionsActivity optionsActivity = (OptionsActivity) this.f8140k;
                if (!optionsActivity.s() || optionsActivity.isFinishing()) {
                    return;
                }
                if (optionsActivity.s() && optionsActivity.f6006w != null && DMRBridge.f6068o) {
                    optionsActivity.B("UpdateAGCStatus", new E0(optionsActivity, i6));
                }
                optionsActivity.f6007x.postDelayed(this, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
                return;
            case 4:
                ReentrantReadWriteLock.ReadLock lock = ((C0733i) this.f8140k).f8340a.h.readLock();
                F3.i.e(lock, "readWriteLock.readLock()");
                lock.lock();
                try {
                    try {
                    } finally {
                        lock.unlock();
                        ((C0733i) this.f8140k).getClass();
                    }
                } catch (SQLiteException e5) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e5);
                    setA = t3.s.f9713j;
                } catch (IllegalStateException e6) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e6);
                    setA = t3.s.f9713j;
                }
                if (((C0733i) this.f8140k).a() && ((C0733i) this.f8140k).f8344e.compareAndSet(true, false) && !((C0733i) this.f8140k).f8340a.h().Q().V()) {
                    C0840c c0840cQ = ((C0733i) this.f8140k).f8340a.h().Q();
                    c0840cQ.c();
                    try {
                        setA = a();
                        c0840cQ.a0();
                        if (!setA.isEmpty()) {
                            C0733i c0733i = (C0733i) this.f8140k;
                            synchronized (c0733i.f8346i) {
                                Iterator it = c0733i.f8346i.iterator();
                                while (true) {
                                    C0754b c0754b = (C0754b) it;
                                    if (c0754b.hasNext()) {
                                        ((AbstractC0732h) ((Map.Entry) c0754b.next()).getValue()).a(setA);
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    } finally {
                        c0840cQ.s();
                    }
                }
                return;
            case 5:
                RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) this.f8140k;
                if (radioTeamsActivity.f6017k != null) {
                    radioTeamsActivity.f6023r.execute(new RunnableC0743a(radioTeamsActivity, 4));
                }
                radioTeamsActivity.f6024s.postDelayed(this, 15000L);
                return;
            case 6:
                if (((N1.k) this.f8140k).b(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                    return;
                }
                return;
            case 7:
                if (((DmrAudioService) this.f8140k).f6038f.get() && ((DmrAudioService) this.f8140k).f6042l) {
                    AudioRecord audioRecord = ((DmrAudioService) this.f8140k).g;
                    if (audioRecord != null && audioRecord.getRecordingState() != 3) {
                        Log.w("DmrAudioService", "AudioRecord not recording when it should be, restarting");
                        try {
                            AudioRecord audioRecord2 = ((DmrAudioService) this.f8140k).g;
                            if (audioRecord2 != null) {
                                audioRecord2.startRecording();
                                Log.d("DmrAudioService", "Successfully restarted AudioRecord");
                            }
                        } catch (Exception e7) {
                            Log.e("DmrAudioService", "Failed to restart recording", e7);
                            ((DmrAudioService) this.f8140k).f6037e.execute(new C0.e(29, this));
                        }
                    }
                    if (((DmrAudioService) this.f8140k).f6038f.get()) {
                        ((DmrAudioService) this.f8140k).f6036d.postDelayed(this, 1000L);
                        return;
                    }
                    return;
                }
                return;
            case 8:
                ((p1.t) this.f8140k).h();
                return;
            case 9:
                o1.c cVar = ((p1.t) ((p1.s) this.f8140k).f9136c).f9138d;
                cVar.e(cVar.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 10:
                ((BinderC0823D) this.f8140k).f9091j.a(new C0785b(4));
                return;
            default:
                CheckableImageButton checkableImageButton = ((TextInputLayout) this.f8140k).f5445e.f9614i;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
        }
    }
}
