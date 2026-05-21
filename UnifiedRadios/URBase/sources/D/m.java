package D;

import D0.x;
import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.maps.model.PinConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.adapters.LocationDisplayActivity;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.adapters.RepeaterMapActivity;
import com.unified.ur1.adapters.SoundCustomizationActivity;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0494E;
import f3.C0519j;
import f3.C0524o;
import f3.C0529u;
import f3.C0532x;
import f3.D0;
import f3.DialogInterfaceOnClickListenerC0516g;
import f3.E0;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import org.conscrypt.FileClientSessionCache;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f219j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f220k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f221l;

    public /* synthetic */ m(Object obj, int i5, Object obj2) {
        this.f219j = i5;
        this.f220k = obj;
        this.f221l = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        A2.i iVar;
        int i5 = 0;
        int i6 = 1;
        switch (this.f219j) {
            case 0:
                ((b) this.f220k).h((Typeface) this.f221l);
                return;
            case 1:
                x xVar = (x) this.f220k;
                InterfaceFutureC1000b interfaceFutureC1000b = (InterfaceFutureC1000b) this.f221l;
                if (xVar.f329y.f1783j instanceof N0.a) {
                    interfaceFutureC1000b.cancel(true);
                    return;
                }
                return;
            case 2:
                E0.d dVar = (E0.d) this.f220k;
                F3.i.f(dVar, "this$0");
                D0.n nVar = (D0.n) this.f221l;
                F3.i.f(nVar, "$token");
                ((L0.e) dVar.f458c).u(nVar, 3);
                return;
            case 3:
                F2.p pVar = (F2.p) this.f220k;
                Q2.a aVar = (Q2.a) this.f221l;
                if (pVar.f577b != F2.p.f575d) {
                    throw new IllegalStateException("provide() can be called only once.");
                }
                synchronized (pVar) {
                    iVar = pVar.f576a;
                    pVar.f576a = null;
                    pVar.f577b = aVar;
                }
                iVar.getClass();
                return;
            case 4:
                F2.o oVar = (F2.o) this.f220k;
                Q2.a aVar2 = (Q2.a) this.f221l;
                synchronized (oVar) {
                    try {
                        if (oVar.f573b == null) {
                            oVar.f572a.add(aVar2);
                        } else {
                            oVar.f573b.add(aVar2.get());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 5:
                G2.a aVar3 = (G2.a) this.f220k;
                Process.setThreadPriority(aVar3.f614c);
                StrictMode.ThreadPolicy threadPolicy = aVar3.f615d;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                ((Runnable) this.f221l).run();
                return;
            case 6:
                Callable callable = (Callable) this.f220k;
                B0.l lVar = (B0.l) this.f221l;
                try {
                    ((G2.h) lVar.f110d).i(callable.call());
                    return;
                } catch (Exception e5) {
                    ((G2.h) lVar.f110d).j(e5);
                    return;
                }
            case 7:
                List list = (List) this.f220k;
                F3.i.f(list, "$listenersList");
                J0.f fVar = (J0.f) this.f221l;
                F3.i.f(fVar, "this$0");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((I0.c) it.next()).a(fVar.f690e);
                }
                return;
            case 8:
                M0.q qVar = (M0.q) this.f220k;
                N0.k kVar = (N0.k) this.f221l;
                if (qVar.f1695j.f1783j instanceof N0.a) {
                    kVar.cancel(true);
                    return;
                } else {
                    kVar.l(qVar.f1698m.a());
                    return;
                }
            case 9:
                ConstraintTrackingWorker constraintTrackingWorker = (ConstraintTrackingWorker) this.f220k;
                InterfaceFutureC1000b interfaceFutureC1000b2 = (InterfaceFutureC1000b) this.f221l;
                F3.i.f(constraintTrackingWorker, "this$0");
                F3.i.f(interfaceFutureC1000b2, "$innerFuture");
                synchronized (constraintTrackingWorker.h) {
                    try {
                        if (constraintTrackingWorker.f4504i) {
                            N0.k kVar2 = constraintTrackingWorker.f4505j;
                            F3.i.e(kVar2, "future");
                            String str = P0.a.f2062a;
                            kVar2.j(new C0.p());
                        } else {
                            constraintTrackingWorker.f4505j.l(interfaceFutureC1000b2);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            case 10:
                N1.k kVar3 = (N1.k) this.f221l;
                C0519j c0519j = FirebaseMessaging.f5540k;
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f220k;
                firebaseMessaging.getClass();
                try {
                    kVar3.a(firebaseMessaging.a());
                    return;
                } catch (Exception e6) {
                    kVar3.f1789a.l(e6);
                    return;
                }
            case 11:
                N1.k kVar4 = (N1.k) this.f221l;
                X2.o oVar2 = (X2.o) this.f220k;
                oVar2.getClass();
                try {
                    kVar4.a(oVar2.a());
                    return;
                } catch (Exception e7) {
                    kVar4.f1789a.l(e7);
                    return;
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                D0.p pVar2 = (D0.p) this.f221l;
                L0.m mVar = (L0.m) this.f220k;
                Z3.c cVar = (Z3.c) mVar.f1557e;
                try {
                    pVar2.i();
                    return;
                } catch (Exception e8) {
                    try {
                        Object objNewInstance = ((Constructor) mVar.f1556d).newInstance(e8);
                        if (objNewInstance instanceof b4.a) {
                            ((b4.a) objNewInstance).f4540a = mVar.f1558f;
                        }
                        cVar.b(objNewInstance);
                        return;
                    } catch (Exception e9) {
                        cVar.g.d(Level.SEVERE, "Original exception:", e8);
                        throw new RuntimeException("Could not create failure event", e9);
                    }
                }
            case o1.f.ERROR /* 13 */:
                int i7 = JobInfoSchedulerService.f4620c;
                ((JobInfoSchedulerService) this.f220k).jobFinished((JobParameters) this.f221l, false);
                return;
            case o1.f.INTERRUPTED /* 14 */:
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = (UnifiedOnTheAirActivity) this.f220k;
                unifiedOnTheAirActivity.f5564k.clear();
                unifiedOnTheAirActivity.f5564k.addAll((List) this.f221l);
                unifiedOnTheAirActivity.k();
                unifiedOnTheAirActivity.updateMapMarkers();
                unifiedOnTheAirActivity.s();
                return;
            case 15:
                Runnable runnable = (Runnable) this.f221l;
                M0.m mVar2 = (M0.m) this.f220k;
                mVar2.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    mVar2.a();
                }
            case 16:
                AlertDialog alertDialogCreate = new AlertDialog.Builder((Activity) this.f220k).setTitle("Callsign Results").setMessage((String) this.f221l).setPositiveButton("CLOSE", new DialogInterfaceOnClickListenerC0516g(i5)).create();
                alertDialogCreate.show();
                TextView textView = (TextView) alertDialogCreate.findViewById(R.id.message);
                if (textView != null) {
                    textView.setTextIsSelectable(true);
                    return;
                }
                return;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                LocationDisplayActivity locationDisplayActivity = (LocationDisplayActivity) ((B0.l) this.f220k).f110d;
                locationDisplayActivity.f5680p = false;
                locationDisplayActivity.o(false);
                locationDisplayActivity.j((C0529u) this.f221l);
                Toast.makeText(locationDisplayActivity, "Location updated at " + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date()), 0).show();
                Log.d("LocationDisplayActivity", "Location successfully resolved and updated");
                return;
            case 18:
                String message = ((Exception) this.f221l).getMessage();
                B0.l lVar2 = (B0.l) this.f220k;
                lVar2.getClass();
                int i8 = LocationDisplayActivity.f5669q;
                ((LocationDisplayActivity) lVar2.f110d).l("Failed to resolve location: " + message);
                return;
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                C0524o c0524o = ((MemoryChannelActivity) this.f220k).g;
                c0524o.f6769b = (List) this.f221l;
                c0524o.notifyDataSetChanged();
                return;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                ArrayList arrayList = (ArrayList) this.f221l;
                int i9 = MemoryChannelActivity.f5681l;
                MemoryChannelActivity memoryChannelActivity = (MemoryChannelActivity) this.f220k;
                memoryChannelActivity.getClass();
                try {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(memoryChannelActivity, com.unified.ur1.R.layout.spinner_dropdown_item, new ArrayList(arrayList));
                    arrayAdapter.setDropDownViewResource(com.unified.ur1.R.layout.spinner_dropdown_item);
                    Log.d("Unified - MemoryChannel", "Zone list size: " + arrayList.size());
                    Log.d("Unified - MemoryChannel", "Zone contents: " + arrayList.toString());
                    memoryChannelActivity.f5683d.setOnItemSelectedListener(null);
                    memoryChannelActivity.f5683d.setAdapter((SpinnerAdapter) null);
                    memoryChannelActivity.f5683d.setAdapter((SpinnerAdapter) arrayAdapter);
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    memoryChannelActivity.f5683d.setOnItemSelectedListener(new C0494E(memoryChannelActivity, i6));
                    memoryChannelActivity.f5683d.setSelection(0, false);
                    memoryChannelActivity.f5684e.execute(new m(memoryChannelActivity, 22, (String) arrayList.get(0)));
                    return;
                } catch (Exception e10) {
                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("Unified - MemoryChannel", "Error updating UI", e10, "Error updating zone list: ");
                    sbG.append(e10.getMessage());
                    Toast.makeText(memoryChannelActivity, sbG.toString(), 0).show();
                    return;
                }
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                int i10 = MemoryChannelActivity.f5681l;
                MemoryChannelActivity memoryChannelActivity2 = (MemoryChannelActivity) this.f220k;
                memoryChannelActivity2.getClass();
                Intent intent = new Intent(memoryChannelActivity2, (Class<?>) LaunchActivity.class);
                intent.addFlags(603979776);
                intent.putExtra("ROIP_CONNECT", true);
                if (((C0532x) this.f221l).e()) {
                    intent.putExtra("MULTI_RX_ENABLED", true);
                }
                memoryChannelActivity2.startActivity(intent);
                return;
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                int i11 = MemoryChannelActivity.f5681l;
                MemoryChannelActivity memoryChannelActivity3 = (MemoryChannelActivity) this.f220k;
                memoryChannelActivity3.getClass();
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = memoryChannelActivity3.f5685f.iterator();
                while (it2.hasNext()) {
                    C0532x c0532x = (C0532x) it2.next();
                    if (c0532x.f6829b.equals((String) this.f221l)) {
                        arrayList2.add(c0532x);
                    }
                }
                memoryChannelActivity3.runOnUiThread(new m(memoryChannelActivity3, 19, arrayList2));
                return;
            case 23:
                int i12 = MemoryChannelActivity.f5681l;
                MemoryChannelActivity memoryChannelActivity4 = (MemoryChannelActivity) this.f220k;
                memoryChannelActivity4.getClass();
                Toast.makeText(memoryChannelActivity4, "" + ((Exception) this.f221l).getMessage(), 1).show();
                return;
            case 24:
                RepeaterMapActivity repeaterMapActivity = (RepeaterMapActivity) this.f220k;
                TextView textView2 = repeaterMapActivity.f5716r;
                StringBuilder sb = new StringBuilder("Server error: ");
                String str2 = (String) this.f221l;
                sb.append(str2);
                textView2.setText(sb.toString());
                Toast.makeText(repeaterMapActivity, "Failed to load repeaters: " + str2, 1).show();
                return;
            case 25:
                RepeaterMapActivity repeaterMapActivity2 = (RepeaterMapActivity) this.f220k;
                TextView textView3 = repeaterMapActivity2.f5716r;
                StringBuilder sb2 = new StringBuilder("Network error: ");
                Exception exc = (Exception) this.f221l;
                sb2.append(exc.getMessage());
                textView3.setText(sb2.toString());
                Toast.makeText(repeaterMapActivity2, "Error loading repeaters: " + exc.getMessage(), 1).show();
                return;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                SoundCustomizationActivity.j((SoundCustomizationActivity) this.f220k, (String) this.f221l);
                return;
            case 27:
                SoundCustomizationActivity.l((SoundCustomizationActivity) this.f220k, (Exception) this.f221l);
                return;
            case 28:
                E0 e02 = (E0) this.f220k;
                if (((D0) e02.I).isFinishing()) {
                    return;
                }
                Toast.makeText((Context) e02.f6571i, "Error processing audio file: " + ((Exception) this.f221l).getMessage(), 0).show();
                return;
            default:
                ChatActivity chatActivity = (ChatActivity) this.f220k;
                if (chatActivity.f5752v) {
                    chatActivity.f5741j.setText(chatActivity.f5746p);
                } else {
                    String str3 = (String) this.f221l;
                    if (str3.isEmpty()) {
                        chatActivity.f5741j.setText(chatActivity.f5746p);
                    } else {
                        chatActivity.f5741j.setText(chatActivity.f5746p + " - " + str3);
                    }
                }
                Log.d("ChatActivity", "Updated title to: " + chatActivity.f5741j.getText().toString());
                return;
        }
    }
}
