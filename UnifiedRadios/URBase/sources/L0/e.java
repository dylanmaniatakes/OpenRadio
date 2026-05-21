package L0;

import D1.AbstractC0019q;
import D1.BinderC0008f;
import D1.C0016n;
import D1.D;
import D1.U;
import D1.a0;
import O.C0169i0;
import O.C0182v;
import O.K;
import O.Y;
import X2.t;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.n0;
import androidx.recyclerview.widget.x0;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.internal.measurement.C0298b;
import com.google.android.gms.internal.measurement.C0303c;
import com.google.android.gms.internal.measurement.C0328h;
import com.google.android.gms.internal.measurement.C0358n;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.InterfaceC0397v;
import com.google.android.gms.internal.measurement.T1;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzb;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import f.x;
import f3.C0524o;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import l0.AbstractC0737m;
import l0.C0738n;
import m1.C0761b;
import okhttp3.ResponseBody;
import org.conscrypt.FileClientSessionCache;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q1.E;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class e implements p1.o, InterfaceC0397v, i.a, Callback, N1.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1540c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1541d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1542e;

    public /* synthetic */ e(int i5, Object obj, Object obj2, boolean z4) {
        this.f1540c = i5;
        this.f1541d = obj2;
        this.f1542e = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static L0.e g(android.content.Context r5) throws java.io.IOException {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L30 java.lang.Error -> L34 java.io.IOException -> L36
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L29 java.lang.Error -> L2c java.io.IOException -> L2e
            L0.e r2 = new L0.e     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            r3 = 9
            r2.<init>(r5, r3, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L23 java.lang.Error -> L25 java.io.IOException -> L27
            return r2
        L23:
            r2 = move-exception
            goto L38
        L25:
            r2 = move-exception
            goto L38
        L27:
            r2 = move-exception
            goto L38
        L29:
            r2 = move-exception
        L2a:
            r0 = r1
            goto L38
        L2c:
            r2 = move-exception
            goto L2a
        L2e:
            r2 = move-exception
            goto L2a
        L30:
            r2 = move-exception
        L31:
            r5 = r1
            r0 = r5
            goto L38
        L34:
            r2 = move-exception
            goto L31
        L36:
            r2 = move-exception
            goto L31
        L38:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L44
            r0.release()     // Catch: java.io.IOException -> L44
        L44:
            if (r5 == 0) goto L49
            r5.close()     // Catch: java.io.IOException -> L49
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.e.g(android.content.Context):L0.e");
    }

    public static int k(int i5, int i6) {
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i5; i9++) {
            i7++;
            if (i7 == i6) {
                i8++;
                i7 = 0;
            } else if (i7 > i6) {
                i8++;
                i7 = 1;
            }
        }
        return i7 + 1 > i6 ? i8 + 1 : i8;
    }

    @Override // i.a
    public boolean a(i.b bVar, MenuItem menuItem) {
        return ((i.a) this.f1541d).a(bVar, menuItem);
    }

    @Override // i.a
    public void b(i.b bVar) {
        ((i.a) this.f1541d).b(bVar);
        x xVar = (x) this.f1542e;
        if (xVar.f6434y != null) {
            xVar.n.getDecorView().removeCallbacks(xVar.f6435z);
        }
        if (xVar.f6433x != null) {
            C0169i0 c0169i0 = xVar.f6388A;
            if (c0169i0 != null) {
                c0169i0.b();
            }
            C0169i0 c0169i0A = Y.a(xVar.f6433x);
            c0169i0A.a(BitmapDescriptorFactory.HUE_RED);
            xVar.f6388A = c0169i0A;
            c0169i0A.d(new f.p(2, this));
        }
        f.j jVar = xVar.f6425p;
        if (jVar != null) {
            jVar.onSupportActionModeFinished(xVar.f6432w);
        }
        xVar.f6432w = null;
        ViewGroup viewGroup = xVar.f6390C;
        WeakHashMap weakHashMap = Y.f1904a;
        K.c(viewGroup);
        xVar.J();
    }

    @Override // N1.b
    public Object c(N1.j jVar) {
        Bundle bundle;
        C0761b c0761b = (C0761b) this.f1541d;
        c0761b.getClass();
        return (jVar.f() && (bundle = (Bundle) jVar.d()) != null && bundle.containsKey("google.messenger")) ? c0761b.a((Bundle) this.f1542e).k(m1.h.f8527l, m1.d.f8522f) : jVar;
    }

    @Override // i.a
    public boolean d(i.b bVar, j.m mVar) {
        return ((i.a) this.f1541d).d(bVar, mVar);
    }

    @Override // i.a
    public boolean e(i.b bVar, Menu menu) {
        ViewGroup viewGroup = ((x) this.f1542e).f6390C;
        WeakHashMap weakHashMap = Y.f1904a;
        K.c(viewGroup);
        return ((i.a) this.f1541d).e(bVar, menu);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC0397v
    public t f(InterfaceC0363o interfaceC0363o) {
        t tVarP = ((t) this.f1541d).p();
        tVarP.v((String) this.f1542e, interfaceC0363o);
        return tVarP;
    }

    public void h(n0 n0Var, C0182v c0182v) {
        q.k kVar = (q.k) this.f1541d;
        x0 x0VarA = (x0) kVar.getOrDefault(n0Var, null);
        if (x0VarA == null) {
            x0VarA = x0.a();
            kVar.put(n0Var, x0VarA);
        }
        x0VarA.f4391c = c0182v;
        x0VarA.f4389a |= 8;
    }

    public void i() {
        if (((AtomicBoolean) this.f1541d).getAndSet(true)) {
            return;
        }
        Thread thread = new Thread(new k4.c(this));
        thread.setName("GarbageCollector");
        thread.setPriority(1);
        thread.start();
    }

    public Long j(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT long_value FROM Preference where `key`=?");
        c0738nO.h(1, str);
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1541d;
        abstractC0737m.b();
        Long lValueOf = null;
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            if (cursorM.moveToFirst() && !cursorM.isNull(0)) {
                lValueOf = Long.valueOf(cursorM.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorM.close();
            c0738nO.s();
        }
    }

    public String l(String str) {
        String str2 = (String) this.f1542e;
        Resources resources = (Resources) this.f1541d;
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public void m(d dVar) {
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1541d;
        abstractC0737m.b();
        abstractC0737m.c();
        try {
            ((b) this.f1542e).r(dVar);
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
        }
    }

    public void n() {
        ((SparseIntArray) this.f1541d).clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019d A[LOOP:0: B:3:0x0004->B:92:0x019d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public D1.C0016n o(R0.f r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.e.o(R0.f):D1.n");
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f1540c) {
            case 16:
                Log.e("ChatActivity", "Failed to fetch team messages: " + th.getMessage());
                Runnable runnable = (Runnable) this.f1541d;
                if (runnable != null) {
                    runnable.run();
                    break;
                }
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                Log.e("ComposeMessageActivity", "Quick validation network error", th);
                Toast.makeText((ComposeMessageActivity) this.f1542e, "Network error during validation", 0).show();
                break;
            default:
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f1542e;
                unifiedInboxActivity.f5831c.setVisibility(8);
                Toast.makeText(unifiedInboxActivity, "Network error updating message", 0).show();
                Log.e("UnifiedInbox", "Failed to toggle read status", th);
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) throws JSONException {
        C0524o c0524o;
        switch (this.f1540c) {
            case 16:
                List<Message> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null && ((MessageResponse) response.body()).getMessages() != null) {
                    arrayList = ((MessageResponse) response.body()).getMessages();
                    Log.d("ChatActivity", "Fetched " + arrayList.size() + " team messages");
                }
                ChatActivity.j((ChatActivity) this.f1542e, arrayList);
                Runnable runnable = (Runnable) this.f1541d;
                if (runnable != null) {
                    runnable.run();
                    break;
                }
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f1542e;
                try {
                    if (!response.isSuccessful() || response.body() == null) {
                        Toast.makeText(composeMessageActivity, "Validation failed - please select from suggestions", 0).show();
                        break;
                    } else {
                        String strString = ((ResponseBody) response.body()).string();
                        Log.d("ComposeMessageActivity", "Quick validation response: " + strString);
                        JSONObject jSONObject = new JSONObject(strString);
                        if (!jSONObject.getBoolean("success") || !jSONObject.has("data")) {
                            Toast.makeText(composeMessageActivity, "Cannot validate user - please try again", 0).show();
                            break;
                        } else {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            if (jSONObject2.has("users")) {
                                JSONArray jSONArray = jSONObject2.getJSONArray("users");
                                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                    if (jSONArray.getJSONObject(i5).optString("callsign", "").equalsIgnoreCase(((String) this.f1541d).trim())) {
                                        composeMessageActivity.f5809v = true;
                                        composeMessageActivity.q();
                                        break;
                                    }
                                }
                                Toast.makeText(composeMessageActivity, "Callsign not found - please select from suggestions", 0).show();
                                composeMessageActivity.f5793c.requestFocus();
                                break;
                            } else {
                                Toast.makeText(composeMessageActivity, "No users found", 0).show();
                                break;
                            }
                        }
                    }
                } catch (Exception e5) {
                    Log.e("ComposeMessageActivity", "Exception in quick validation", e5);
                    Toast.makeText(composeMessageActivity, "Validation error - please try again", 0).show();
                    return;
                }
                break;
            default:
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f1542e;
                unifiedInboxActivity.f5831c.setVisibility(8);
                if (response.isSuccessful()) {
                    Message message = (Message) this.f1541d;
                    message.setRead(!message.isRead());
                    int iIndexOf = unifiedInboxActivity.f5835i.indexOf(message);
                    if (iIndexOf != -1 && (c0524o = unifiedInboxActivity.g) != null) {
                        c0524o.notifyItemChanged(iIndexOf);
                    }
                    unifiedInboxActivity.u();
                    String str = message.isRead() ? "read" : "unread";
                    Toast.makeText(unifiedInboxActivity, "Message marked as ".concat(str), 0).show();
                    Log.d("UnifiedInbox", "Message " + message.getId() + " marked as " + str);
                    break;
                } else {
                    Toast.makeText(unifiedInboxActivity, "Failed to update message status", 0).show();
                    Log.e("UnifiedInbox", "Failed to toggle read status. Response code: " + response.code());
                    break;
                }
                break;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        N1.k kVar = (N1.k) obj2;
        switch (this.f1540c) {
            case 3:
                Z2.c cVar = new Z2.c(kVar);
                zzb zzbVar = (zzb) this.f1541d;
                E.j(zzbVar, "ActivityRecognitionRequest can't be null.");
                PendingIntent pendingIntent = (PendingIntent) this.f1542e;
                E.j(pendingIntent, "PendingIntent must be specified.");
                BinderC0008f binderC0008f = new BinderC0008f(cVar);
                a0 a0Var = (a0) ((U) obj).t();
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, zzbVar);
                AbstractC0019q.b(parcelZza, pendingIntent);
                parcelZza.writeStrongBinder(binderC0008f);
                a0Var.zzc(70, parcelZza);
                break;
            case 4:
                ((D) obj).I((C0016n) this.f1541d, (LocationRequest) this.f1542e, kVar);
                break;
            default:
                ((D) obj).E((GeofencingRequest) this.f1541d, (PendingIntent) this.f1542e, kVar);
                break;
        }
    }

    public C0182v q(n0 n0Var, int i5) {
        x0 x0Var;
        C0182v c0182v;
        q.k kVar = (q.k) this.f1541d;
        int iE = kVar.e(n0Var);
        if (iE >= 0 && (x0Var = (x0) kVar.j(iE)) != null) {
            int i6 = x0Var.f4389a;
            if ((i6 & i5) != 0) {
                int i7 = i6 & (~i5);
                x0Var.f4389a = i7;
                if (i5 == 4) {
                    c0182v = x0Var.f4390b;
                } else {
                    if (i5 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    c0182v = x0Var.f4391c;
                }
                if ((i7 & 12) == 0) {
                    kVar.i(iE);
                    x0Var.f4389a = 0;
                    x0Var.f4390b = null;
                    x0Var.f4391c = null;
                    x0.f4388d.c(x0Var);
                }
                return c0182v;
            }
        }
        return null;
    }

    public void r() throws IOException {
        try {
            ((FileLock) this.f1542e).release();
            ((FileChannel) this.f1541d).close();
        } catch (IOException e5) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e5);
        }
    }

    public void s(n0 n0Var) {
        x0 x0Var = (x0) ((q.k) this.f1541d).getOrDefault(n0Var, null);
        if (x0Var == null) {
            return;
        }
        x0Var.f4389a &= -2;
    }

    public void t(n0 n0Var) {
        q.e eVar = (q.e) this.f1542e;
        int iH = eVar.h() - 1;
        while (true) {
            if (iH < 0) {
                break;
            }
            if (n0Var == eVar.i(iH)) {
                Object[] objArr = eVar.f9255l;
                Object obj = objArr[iH];
                Object obj2 = q.e.n;
                if (obj != obj2) {
                    objArr[iH] = obj2;
                    eVar.f9253j = true;
                }
            } else {
                iH--;
            }
        }
        x0 x0Var = (x0) ((q.k) this.f1541d).remove(n0Var);
        if (x0Var != null) {
            x0Var.f4389a = 0;
            x0Var.f4390b = null;
            x0Var.f4391c = null;
            x0.f4388d.c(x0Var);
        }
    }

    public void u(D0.n nVar, int i5) {
        F3.i.f(nVar, "workSpecId");
        ((i) this.f1542e).c(new M0.n((D0.h) this.f1541d, nVar, false, i5));
    }

    public void v(t tVar, C0303c c0303c) {
        T1 t12 = new T1(c0303c);
        TreeMap treeMap = (TreeMap) this.f1541d;
        for (Integer num : treeMap.keySet()) {
            C0298b c0298bClone = c0303c.f4908b.clone();
            InterfaceC0363o interfaceC0363oC = ((C0358n) treeMap.get(num)).c(tVar, Collections.singletonList(t12));
            int iL = interfaceC0363oC instanceof C0328h ? Z3.i.l(((C0328h) interfaceC0363oC).f4944j.doubleValue()) : -1;
            if (iL == 2 || iL == -1) {
                c0303c.f4908b = c0298bClone;
            }
        }
        TreeMap treeMap2 = (TreeMap) this.f1542e;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            InterfaceC0363o interfaceC0363oC2 = ((C0358n) treeMap2.get((Integer) it.next())).c(tVar, Collections.singletonList(t12));
            if (interfaceC0363oC2 instanceof C0328h) {
                Z3.i.l(((C0328h) interfaceC0363oC2).f4944j.doubleValue());
            }
        }
    }

    public /* synthetic */ e(int i5, boolean z4) {
        this.f1540c = i5;
    }

    public /* synthetic */ e(Object obj, int i5, Object obj2) {
        this.f1540c = i5;
        this.f1541d = obj;
        this.f1542e = obj2;
    }

    public e(Context context) {
        this.f1540c = 23;
        E.i(context);
        Resources resources = context.getResources();
        this.f1541d = resources;
        this.f1542e = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public e(Runnable runnable) {
        this.f1540c = 19;
        this.f1541d = new AtomicBoolean(false);
        this.f1542e = runnable;
    }

    public e(WorkDatabase workDatabase) {
        this.f1540c = 0;
        this.f1541d = workDatabase;
        this.f1542e = new b(workDatabase, 1);
    }

    public e(D0.h hVar, i iVar) {
        this.f1540c = 2;
        F3.i.f(hVar, "processor");
        F3.i.f(iVar, "workTaskExecutor");
        this.f1541d = hVar;
        this.f1542e = iVar;
    }

    public e(J1.D d5) {
        this.f1540c = 8;
        R0.a aVar = new R0.a();
        this.f1541d = d5;
        this.f1542e = aVar;
    }

    public e(ArrayList arrayList, ArrayList arrayList2) {
        this.f1540c = 1;
        int size = arrayList.size();
        this.f1541d = new int[size];
        this.f1542e = new float[size];
        for (int i5 = 0; i5 < size; i5++) {
            ((int[]) this.f1541d)[i5] = ((Integer) arrayList.get(i5)).intValue();
            ((float[]) this.f1542e)[i5] = ((Float) arrayList2.get(i5)).floatValue();
        }
    }

    public e(int i5, int i6) {
        this.f1540c = 1;
        this.f1541d = new int[]{i5, i6};
        this.f1542e = new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f};
    }

    public e(int i5, int i6, int i7) {
        this.f1540c = 1;
        this.f1541d = new int[]{i5, i6, i7};
        this.f1542e = new float[]{BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f};
    }

    public e(ChatActivity chatActivity) {
        this.f1540c = 16;
        this.f1542e = chatActivity;
        this.f1541d = null;
    }

    public e(int i5) {
        this.f1540c = i5;
        switch (i5) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                this.f1541d = new q.k();
                this.f1542e = new q.e();
                break;
            case o1.f.ERROR /* 13 */:
            default:
                this.f1541d = new SparseIntArray();
                this.f1542e = new SparseIntArray();
                break;
            case o1.f.INTERRUPTED /* 14 */:
                this.f1541d = new TreeMap();
                this.f1542e = new TreeMap();
                break;
        }
    }
}
