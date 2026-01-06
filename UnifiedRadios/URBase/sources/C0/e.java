package C0;

import J1.D;
import N3.I;
import N3.P;
import X2.E;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.G;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.gms.maps.model.PinConfig;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.unified.ur1.R;
import com.unified.ur1.adapters.LocationDisplayActivity;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.chat.SimpleImageViewerActivity;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import e1.C0444l;
import f.DialogC0469f;
import f3.C0518i;
import f3.C0519j;
import g0.AbstractC0535a;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C0;
import k3.DialogInterfaceOnClickListenerC0681d0;
import k3.RunnableC0691i0;
import k3.T;
import k3.U;
import k3.y0;
import l0.AbstractC0737m;
import l0.C0738n;
import m3.C0768d;
import org.conscrypt.FileClientSessionCache;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f149j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f150k;

    public /* synthetic */ e(int i5, Object obj) {
        this.f149j = i5;
        this.f150k = obj;
    }

    private final void a() {
        androidx.emoji2.text.n nVar = (androidx.emoji2.text.n) this.f150k;
        synchronized (nVar.f3629f) {
            try {
                if (nVar.f3631j == null) {
                    return;
                }
                try {
                    L.i iVarC = nVar.c();
                    int i5 = iVarC.f1527e;
                    if (i5 == 2) {
                        synchronized (nVar.f3629f) {
                        }
                    }
                    if (i5 != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i5 + ")");
                    }
                    try {
                        int i6 = K.l.f1491a;
                        K.k.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        D d5 = nVar.f3628e;
                        Context context = nVar.f3626c;
                        d5.getClass();
                        Typeface typefaceE = E.g.f426a.e(context, new L.i[]{iVarC}, 0);
                        MappedByteBuffer mappedByteBufferL = h4.r.l(nVar.f3626c, iVarC.f1523a);
                        if (mappedByteBufferL == null || typefaceE == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        try {
                            K.k.a("EmojiCompat.MetadataRepo.create");
                            L0.i iVar = new L0.i(typefaceE, h4.f.k(mappedByteBufferL));
                            K.k.b();
                            K.k.b();
                            synchronized (nVar.f3629f) {
                                try {
                                    h4.d dVar = nVar.f3631j;
                                    if (dVar != null) {
                                        dVar.j(iVar);
                                    }
                                } finally {
                                }
                            }
                            nVar.a();
                        } finally {
                            int i7 = K.l.f1491a;
                            K.k.b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (nVar.f3629f) {
                        try {
                            h4.d dVar2 = nVar.f3631j;
                            if (dVar2 != null) {
                                dVar2.i(th2);
                            }
                            nVar.a();
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
        int i5 = 3;
        switch (this.f149j) {
            case 0:
                CoroutineWorker coroutineWorker = (CoroutineWorker) this.f150k;
                F3.i.f(coroutineWorker, "this$0");
                if (coroutineWorker.h.f1783j instanceof N0.a) {
                    coroutineWorker.g.c(null);
                    return;
                }
                return;
            case 1:
                View view = (View) this.f150k;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                return;
            case 2:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f150k;
                F3.i.f(constraintTrackingWorker, "this$0");
                if (constraintTrackingWorker.f4505j.f1783j instanceof N0.a) {
                    return;
                }
                Object obj = constraintTrackingWorker.f169d.f4480b.f158a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                String str = obj instanceof String ? (String) obj : null;
                t tVarD = t.d();
                F3.i.e(tVarD, "get()");
                if (str == null || str.length() == 0) {
                    tVarD.b(P0.a.f2062a, "No worker to delegate to.");
                    N0.k kVar = constraintTrackingWorker.f4505j;
                    F3.i.e(kVar, "future");
                    kVar.j(new o());
                    return;
                }
                B b5 = constraintTrackingWorker.f169d.f4483e;
                Context context = constraintTrackingWorker.f168c;
                WorkerParameters workerParameters = constraintTrackingWorker.g;
                b5.getClass();
                s sVarA = B.a(context, str, workerParameters);
                constraintTrackingWorker.f4506k = sVarA;
                if (sVarA == null) {
                    tVarD.a(P0.a.f2062a, "No worker to delegate to.");
                    N0.k kVar2 = constraintTrackingWorker.f4505j;
                    F3.i.e(kVar2, "future");
                    kVar2.j(new o());
                    return;
                }
                D0.v vVarY = D0.v.y(constraintTrackingWorker.f168c);
                L0.q qVarV = vVarY.f302c.v();
                String string = constraintTrackingWorker.f169d.f4479a.toString();
                F3.i.e(string, "id.toString()");
                L0.o oVarH = qVarV.h(string);
                if (oVarH == null) {
                    N0.k kVar3 = constraintTrackingWorker.f4505j;
                    F3.i.e(kVar3, "future");
                    String str2 = P0.a.f2062a;
                    kVar3.j(new o());
                    return;
                }
                L0.i iVar = vVarY.f307j;
                F3.i.e(iVar, "workManagerImpl.trackers");
                C0519j c0519j = new C0519j(iVar);
                I i6 = (I) vVarY.f303d.f1548d;
                F3.i.e(i6, "workManagerImpl.workTask…r.taskCoroutineDispatcher");
                constraintTrackingWorker.f4505j.a(new e(i5, H0.k.a(c0519j, oVarH, i6, constraintTrackingWorker)), new C2.c(6));
                if (!c0519j.r(oVarH)) {
                    tVarD.a(P0.a.f2062a, "Constraints not met for delegate " + str + ". Requesting retry.");
                    N0.k kVar4 = constraintTrackingWorker.f4505j;
                    F3.i.e(kVar4, "future");
                    kVar4.j(new p());
                    return;
                }
                tVarD.a(P0.a.f2062a, "Constraints met for delegate ".concat(str));
                try {
                    s sVar = constraintTrackingWorker.f4506k;
                    F3.i.c(sVar);
                    N0.k kVarD = sVar.d();
                    F3.i.e(kVarD, "delegate!!.startWork()");
                    kVarD.a(new D.m(constraintTrackingWorker, 9, kVarD), constraintTrackingWorker.f169d.f4481c);
                    return;
                } catch (Throwable th) {
                    String str3 = P0.a.f2062a;
                    String strL = AbstractC0535a.l("Delegated worker ", str, " threw exception in startWork.");
                    if (tVarD.f174a <= 3) {
                        Log.d(str3, strL, th);
                    }
                    synchronized (constraintTrackingWorker.h) {
                        try {
                            if (!constraintTrackingWorker.f4504i) {
                                N0.k kVar5 = constraintTrackingWorker.f4505j;
                                F3.i.e(kVar5, "future");
                                kVar5.j(new o());
                                return;
                            } else {
                                tVarD.a(str3, "Constraints were unmet, Retrying.");
                                N0.k kVar6 = constraintTrackingWorker.f4505j;
                                F3.i.e(kVar6, "future");
                                kVar6.j(new p());
                                return;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            case 3:
                P p4 = (P) this.f150k;
                F3.i.f(p4, "$job");
                p4.c(null);
                return;
            case 4:
                ((CarouselLayoutManager) this.f150k).h0();
                return;
            case 5:
                F2.t tVar = (F2.t) this.f150k;
                synchronized (((ArrayDeque) tVar.f584e)) {
                    SharedPreferences.Editor editorEdit = ((SharedPreferences) tVar.f581b).edit();
                    String str4 = (String) tVar.f582c;
                    StringBuilder sb = new StringBuilder();
                    Iterator it = ((ArrayDeque) tVar.f584e).iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append((String) tVar.f583d);
                    }
                    editorEdit.putString(str4, sb.toString()).commit();
                }
                return;
            case 6:
                StringBuilder sb2 = new StringBuilder("Service took too long to process intent: ");
                E e5 = (E) this.f150k;
                sb2.append(e5.f2768a.getAction());
                sb2.append(" finishing.");
                Log.w("FirebaseMessaging", sb2.toString());
                e5.f2769b.c(null);
                return;
            case 7:
                ((ComponentActivity) this.f150k).invalidateMenu();
                return;
            case 8:
                androidx.activity.k kVar7 = (androidx.activity.k) this.f150k;
                Runnable runnable = kVar7.f3233k;
                if (runnable != null) {
                    runnable.run();
                    kVar7.f3233k = null;
                    return;
                }
                return;
            case 9:
                DialogC0469f.a((DialogC0469f) this.f150k);
                return;
            case 10:
                a();
                return;
            case 11:
                G g = (G) this.f150k;
                F3.i.f(g, "this$0");
                int i7 = g.f3908d;
                C0251v c0251v = g.h;
                if (i7 == 0) {
                    g.f3909e = true;
                    c0251v.e(EnumC0243m.ON_PAUSE);
                }
                if (g.f3907c == 0 && g.f3909e) {
                    c0251v.e(EnumC0243m.ON_STOP);
                    g.f3910f = true;
                    return;
                }
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                ((com.google.android.material.timepicker.e) this.f150k).m();
                return;
            case o1.f.ERROR /* 13 */:
                C0444l c0444l = (C0444l) this.f150k;
                c0444l.getClass();
                ((f1.j) c0444l.f6193d).D(new D0.p(11, c0444l));
                return;
            case o1.f.INTERRUPTED /* 14 */:
                int i8 = LocationDisplayActivity.f5669q;
                LocationDisplayActivity locationDisplayActivity = (LocationDisplayActivity) this.f150k;
                locationDisplayActivity.getClass();
                Log.w("LocationDisplayActivity", "Location request timed out");
                locationDisplayActivity.p();
                locationDisplayActivity.q();
                return;
            case 15:
                ChatActivity chatActivity = (ChatActivity) ((g3.f) this.f150k).f6967d;
                if (chatActivity.f5750t) {
                    chatActivity.z("0");
                    chatActivity.f5750t = false;
                    return;
                }
                return;
            case 16:
                ChatActivity chatActivity2 = (ChatActivity) ((B0.l) this.f150k).f110d;
                chatActivity2.f5738e.g0(chatActivity2.n.size() - 1);
                return;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                ChatActivity chatActivity3 = (ChatActivity) ((L0.s) this.f150k).f1597e;
                chatActivity3.f5738e.g0(chatActivity3.n.size() - 1);
                return;
            case 18:
                SimpleImageViewerActivity simpleImageViewerActivity = (SimpleImageViewerActivity) this.f150k;
                int width = simpleImageViewerActivity.f5773c.getWidth();
                int height = simpleImageViewerActivity.f5773c.getHeight();
                float f5 = width;
                float width2 = simpleImageViewerActivity.f5774d.getWidth();
                float f6 = height;
                float height2 = simpleImageViewerActivity.f5774d.getHeight();
                float fMin = Math.min(f5 / width2, f6 / height2);
                simpleImageViewerActivity.g = fMin;
                Matrix matrix = simpleImageViewerActivity.f5776f;
                matrix.setScale(fMin, fMin);
                matrix.postTranslate((f5 - (width2 * fMin)) / 2.0f, (f6 - (height2 * fMin)) / 2.0f);
                simpleImageViewerActivity.f5773c.setImageMatrix(matrix);
                return;
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f150k;
                if (composeMessageActivity.f5793c.hasFocus()) {
                    return;
                }
                composeMessageActivity.n();
                return;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                ((i3.m) this.f150k).i();
                return;
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                Context context2 = LaunchActivity.f5853D1;
                Dialog dialog = (Dialog) this.f150k;
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    return;
                }
                return;
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                LaunchActivity launchActivity = ((U) this.f150k).f8056c;
                TextView textView = (TextView) launchActivity.findViewById(R.id.CallerID);
                launchActivity.f5973x = textView;
                if (textView != null) {
                    textView.setText("");
                    return;
                }
                return;
            case 23:
                LaunchActivity launchActivity2 = ((T) this.f150k).f8021k;
                TextView textView2 = launchActivity2.f5940l0;
                if (textView2 != null) {
                    int i9 = launchActivity2.f5949o1;
                    if (i9 >= 60) {
                        textView2.setText("LAST HEARD - ".concat(String.format("%d:%02d", Integer.valueOf(i9 / 60), Integer.valueOf(i9 % 60))));
                        return;
                    }
                    textView2.setText("LAST HEARD - " + launchActivity2.f5949o1 + " Seconds");
                    return;
                }
                return;
            case 24:
                ((PopupWindow) this.f150k).dismiss();
                return;
            case 25:
                LaunchActivity launchActivity3 = (LaunchActivity) ((DialogInterfaceOnClickListenerC0681d0) this.f150k).f8120d;
                if (launchActivity3.isFinishing() || launchActivity3.isDestroyed()) {
                    return;
                }
                Toast.makeText(launchActivity3, "ROIP stream resynced successfully", 0).show();
                return;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                ((y0) this.f150k).getClass();
                return;
            case 27:
                C0 c02 = (C0) this.f150k;
                c02.getClass();
                C0519j c0519jR = C0.g.r();
                c0519jR.getClass();
                C0738n c0738nO = C0738n.o(0, "SELECT * FROM channel_memories");
                AbstractC0737m abstractC0737m = (AbstractC0737m) c0519jR.f6730d;
                abstractC0737m.b();
                Cursor cursorM = abstractC0737m.m(c0738nO, null);
                try {
                    int iH = L0.f.h(cursorM, "memoryId");
                    int iH2 = L0.f.h(cursorM, "name");
                    int iH3 = L0.f.h(cursorM, "frequency");
                    int iH4 = L0.f.h(cursorM, "offset");
                    int iH5 = L0.f.h(cursorM, "tone");
                    int iH6 = L0.f.h(cursorM, "group");
                    ArrayList arrayList = new ArrayList(cursorM.getCount());
                    while (cursorM.moveToNext()) {
                        C0518i c0518i = new C0518i();
                        c0518i.f6721a = cursorM.getInt(iH);
                        if (cursorM.isNull(iH2)) {
                            c0518i.f6722b = null;
                        } else {
                            c0518i.f6722b = cursorM.getString(iH2);
                        }
                        if (cursorM.isNull(iH3)) {
                            c0518i.f6723c = null;
                        } else {
                            c0518i.f6723c = cursorM.getString(iH3);
                        }
                        c0518i.f6724d = cursorM.getInt(iH4);
                        if (cursorM.isNull(iH5)) {
                            c0518i.f6725e = null;
                        } else {
                            c0518i.f6725e = cursorM.getString(iH5);
                        }
                        if (cursorM.isNull(iH6)) {
                            c0518i.f6726f = null;
                        } else {
                            c0518i.f6726f = cursorM.getString(iH6);
                        }
                        arrayList.add(c0518i);
                    }
                    cursorM.close();
                    c0738nO.s();
                    c02.f7948e.f(arrayList);
                    e4.a aVar = c02.f7949f;
                    if (aVar != null) {
                        aVar.s();
                        return;
                    }
                    return;
                } finally {
                    cursorM.close();
                    c0738nO.s();
                }
            case 28:
                C0768d c0768d = (C0768d) this.f150k;
                c0768d.getClass();
                Process.setThreadPriority(-16);
                while (true) {
                    AtomicBoolean atomicBoolean = c0768d.f8598i;
                    if (atomicBoolean.get()) {
                        return;
                    }
                    try {
                        c0768d.j((byte[]) c0768d.f8593b.take());
                    } catch (InterruptedException e6) {
                        if (atomicBoolean.get()) {
                            return;
                        } else {
                            Log.w("DMR_RX", "Audio processing thread interrupted", e6);
                        }
                    } catch (Exception e7) {
                        Log.e("DMR_RX", "Error processing audio data", e7);
                        c0768d.h();
                    }
                }
            default:
                DmrAudioService dmrAudioService = (DmrAudioService) ((RunnableC0691i0) this.f150k).f8140k;
                try {
                    AudioRecord audioRecord = dmrAudioService.g;
                    if (audioRecord != null) {
                        audioRecord.release();
                    }
                    dmrAudioService.b();
                    AudioRecord audioRecord2 = dmrAudioService.g;
                    if (audioRecord2 != null) {
                        audioRecord2.startRecording();
                        return;
                    }
                    return;
                } catch (Exception e8) {
                    Log.e("DmrAudioService", "Failed to recreate AudioRecord", e8);
                    return;
                }
        }
    }
}
