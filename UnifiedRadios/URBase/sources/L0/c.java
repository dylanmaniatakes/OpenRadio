package L0;

import D0.w;
import D1.AbstractC0019q;
import D1.BinderC0008f;
import D1.C0009g;
import D1.D;
import D1.U;
import D1.a0;
import J1.RunnableC0116w0;
import X2.t;
import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.V;
import androidx.recyclerview.widget.w0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.measurement.AbstractC0389t1;
import com.google.android.gms.internal.measurement.AbstractC0394u1;
import com.google.android.gms.internal.measurement.C0404w1;
import com.google.android.gms.internal.measurement.C1;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.InterfaceC0397v;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.SleepSegmentRequest;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0524o;
import g0.AbstractC0535a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import l0.AbstractC0737m;
import l0.C0738n;
import q1.E;
import r3.InterfaceC0877a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s.AbstractC0882e;
import s.C0883f;
import s3.C0900j;
import w3.InterfaceC0936d;

/* loaded from: classes.dex */
public class c implements p1.o, Q3.f, InterfaceC0877a, InterfaceC0397v, Callback, N1.e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1535c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1536d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1537e;

    public /* synthetic */ c(int i5, Object obj) {
        this.f1535c = i5;
        this.f1537e = obj;
    }

    @Override // Q3.f
    public Object a(Object obj, InterfaceC0936d interfaceC0936d) {
        ((H0.e) this.f1536d).c((o) this.f1537e, (H0.c) obj);
        return C0900j.f9694a;
    }

    public void b(Object obj, String str) {
        ((ArrayList) this.f1536d).add(str + "=" + String.valueOf(obj));
    }

    public boolean c(j jVar) {
        boolean zContainsKey;
        synchronized (this.f1536d) {
            zContainsKey = ((LinkedHashMap) this.f1537e).containsKey(jVar);
        }
        return zContainsKey;
    }

    public View d(int i5, int i6, int i7, int i8) {
        V v4 = (V) this.f1536d;
        int iE = v4.e();
        int iD = v4.d();
        int i9 = i6 > i5 ? 1 : -1;
        View view = null;
        while (i5 != i6) {
            View viewA = v4.a(i5);
            int iC = v4.c(viewA);
            int iB = v4.b(viewA);
            w0 w0Var = (w0) this.f1537e;
            w0Var.f4357b = iE;
            w0Var.f4358c = iD;
            w0Var.f4359d = iC;
            w0Var.f4360e = iB;
            if (i7 != 0) {
                w0Var.f4356a = i7;
                if (w0Var.a()) {
                    return viewA;
                }
            }
            if (i8 != 0) {
                w0Var.f4356a = i8;
                if (w0Var.a()) {
                    view = viewA;
                }
            }
            i5 += i9;
        }
        return view;
    }

    public File e() {
        if (((File) this.f1536d) == null) {
            this.f1536d = new File(((Context) this.f1537e).getCacheDir(), "volley");
        }
        return (File) this.f1536d;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC0397v
    public t f(InterfaceC0363o interfaceC0363o) {
        t tVarP = ((t) this.f1536d).p();
        String str = (String) this.f1537e;
        tVarP.v(str, interfaceC0363o);
        ((HashMap) tVarP.f2836f).put(str, Boolean.TRUE);
        return tVarP;
    }

    public ArrayList g(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1536d;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.isNull(0) ? null : cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            c0738nO.s();
        }
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return new Z0.e((Context) ((InterfaceC0877a) this.f1536d).get(), (Z0.d) ((InterfaceC0877a) this.f1537e).get());
    }

    public boolean h(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1536d;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            boolean z4 = false;
            if (cursorM.moveToFirst()) {
                z4 = cursorM.getInt(0) != 0;
            }
            return z4;
        } finally {
            cursorM.close();
            c0738nO.s();
        }
    }

    public boolean i(View view) {
        V v4 = (V) this.f1536d;
        int iE = v4.e();
        int iD = v4.d();
        int iC = v4.c(view);
        int iB = v4.b(view);
        w0 w0Var = (w0) this.f1537e;
        w0Var.f4357b = iE;
        w0Var.f4358c = iD;
        w0Var.f4359d = iC;
        w0Var.f4360e = iB;
        w0Var.f4356a = 24579;
        return w0Var.a();
    }

    public D0.n j(j jVar) {
        D0.n nVar;
        F3.i.f(jVar, "id");
        synchronized (this.f1536d) {
            nVar = (D0.n) ((LinkedHashMap) this.f1537e).remove(jVar);
        }
        return nVar;
    }

    @Override // N1.e
    public void k(N1.j jVar) {
        String strConcat;
        String str;
        if (!jVar.f()) {
            Log.w("Unified - Main Activity", "Fetching FCM registration token failed", jVar.c());
            return;
        }
        String str2 = (String) jVar.d();
        AbstractC0535a.v("FCM Token obtained: ", str2, "Unified - Main Activity");
        Context context = LaunchActivity.f5853D1;
        LaunchActivity launchActivity = (LaunchActivity) this.f1537e;
        SharedPreferences sharedPreferences = launchActivity.getSharedPreferences("user_prefs", 0);
        String string = sharedPreferences.getString("device_id", null);
        if (string == null || string.isEmpty()) {
            try {
                String string2 = Settings.Secure.getString(launchActivity.getContentResolver(), "android_id");
                if (string2 == null || string2.isEmpty() || "9774d56d682e549c".equals(string2)) {
                    strConcat = "uuid_" + UUID.randomUUID().toString();
                } else {
                    strConcat = "android_".concat(string2);
                }
                sharedPreferences.edit().putString("device_id", strConcat).apply();
            } catch (Exception unused) {
                strConcat = "fallback_" + System.currentTimeMillis();
                sharedPreferences.edit().putString("device_id", strConcat).apply();
            }
            str = strConcat;
        } else {
            str = string;
        }
        new Thread(new RunnableC0116w0((String) this.f1536d, str2, str, Build.MANUFACTURER + " " + Build.MODEL, sharedPreferences, 4)).start();
    }

    public List l(String str) {
        List listH;
        F3.i.f(str, "workSpecId");
        synchronized (this.f1536d) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.f1537e;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (F3.i.a(((j) entry.getKey()).f1551a, str)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    ((LinkedHashMap) this.f1537e).remove((j) it.next());
                }
                listH = t3.i.H(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return listH;
    }

    public void m(int i5, int i6, int i7, int i8) {
        CardView cardView = (CardView) this.f1537e;
        cardView.f3493f.set(i5, i6, i7, i8);
        Rect rect = cardView.f3492e;
        super/*android.view.View*/.setPadding(i5 + rect.left, i6 + rect.top, i7 + rect.right, i8 + rect.bottom);
    }

    public D0.n n(j jVar) {
        D0.n nVar;
        synchronized (this.f1536d) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.f1537e;
                Object nVar2 = linkedHashMap.get(jVar);
                if (nVar2 == null) {
                    nVar2 = new D0.n(jVar);
                    linkedHashMap.put(jVar, nVar2);
                }
                nVar = (D0.n) nVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public void o(boolean z4, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f1536d)) {
            map = new HashMap((Map) this.f1536d);
        }
        synchronized (((Map) this.f1537e)) {
            map2 = new HashMap((Map) this.f1537e);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((N1.k) entry2.getKey()).b(new o1.e(status));
            }
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f1535c) {
            case 16:
                Log.w("ChatActivity", "Failed to send team typing status: " + th.getMessage());
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                Log.w("ChatActivity", "Failed to mark message as read: " + th.getMessage());
                break;
            default:
                i3.m mVar = (i3.m) this.f1537e;
                mVar.f7318e.setRefreshing(false);
                if (mVar.getContext() != null) {
                    Toast.makeText(mVar.getContext(), "Network error: " + th.getMessage(), 0).show();
                    break;
                }
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        String str;
        switch (this.f1535c) {
            case 16:
                StringBuilder sb = new StringBuilder("Team typing status sent: ");
                sb.append((String) this.f1536d);
                sb.append(" for team: ");
                com.unified.ur1.SatelliteTracker.h.q(sb, ((ChatActivity) this.f1537e).f5751u, "ChatActivity");
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                if (response.isSuccessful()) {
                    ((Message) this.f1536d).setRead(true);
                    ChatActivity chatActivity = (ChatActivity) this.f1537e;
                    chatActivity.f5743l.notifyDataSetChanged();
                    chatActivity.v();
                    break;
                }
                break;
            default:
                i3.m mVar = (i3.m) this.f1537e;
                mVar.f7318e.setRefreshing(false);
                if (!response.isSuccessful() || response.body() == null) {
                    Toast.makeText(mVar.getContext(), "Failed to load messages", 0).show();
                    break;
                } else {
                    List<Message> messages = ((MessageResponse) response.body()).getMessages();
                    if (messages != null) {
                        mVar.h.clear();
                        HashMap map = new HashMap();
                        Iterator<Message> it = messages.iterator();
                        while (true) {
                            boolean zHasNext = it.hasNext();
                            String str2 = (String) this.f1536d;
                            if (!zHasNext) {
                                ArrayList arrayList = new ArrayList();
                                for (Map.Entry entry : map.entrySet()) {
                                    String str3 = (String) entry.getKey();
                                    Message message = (Message) entry.getValue();
                                    Message message2 = new Message();
                                    message2.setId(message.getId());
                                    message2.setCreatedAt(message.getCreatedAt());
                                    message2.setMessageBody(message.getMessageBody());
                                    message2.setRead(message.getFromCallsign().equals(str2) ? true : message.isRead());
                                    message2.setHasAttachments(message.isHasAttachments());
                                    if (str3.startsWith("TEAM:")) {
                                        String strSubstring = str3.substring(5);
                                        message2.setTeamId(strSubstring);
                                        message2.setFromCallsign("Teams: " + strSubstring);
                                        message2.setDisplayTime("TEAM:" + strSubstring);
                                        String strH = i3.m.h(message.getMessageBody());
                                        if (message.getFromCallsign().equals(str2)) {
                                            message2.setSubject("You: " + strH);
                                        } else {
                                            message2.setSubject(message.getFromCallsign() + ": " + strH);
                                        }
                                    } else {
                                        String strSubstring2 = str3.substring(7);
                                        message2.setFromCallsign(strSubstring2);
                                        message2.setDisplayTime(strSubstring2);
                                        String strH2 = i3.m.h(message.getMessageBody());
                                        if (message.getFromCallsign().equals(str2)) {
                                            message2.setSubject("You: " + strH2);
                                        } else {
                                            message2.setSubject(strH2);
                                        }
                                    }
                                    arrayList.add(message2);
                                }
                                arrayList.sort(new L.a(2));
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    Message message3 = (Message) it2.next();
                                    if (!message3.isDeleted()) {
                                        mVar.h.add(message3);
                                    }
                                }
                                C0524o c0524o = mVar.g;
                                if (c0524o != null) {
                                    c0524o.notifyDataSetChanged();
                                }
                                ArrayList arrayList2 = mVar.h;
                                if (arrayList2 != null && mVar.f7319f != null && mVar.f7317d != null) {
                                    if (arrayList2.isEmpty()) {
                                        mVar.f7319f.setVisibility(0);
                                        mVar.f7317d.setVisibility(8);
                                    } else {
                                        mVar.f7319f.setVisibility(8);
                                        mVar.f7317d.setVisibility(0);
                                    }
                                }
                                i3.l lVar = mVar.f7320i;
                                if (lVar != null) {
                                    ((UnifiedInboxActivity) lVar).u();
                                    break;
                                }
                            } else {
                                Message next = it.next();
                                if (!next.isDeleted()) {
                                    if (next.isTeamMessage()) {
                                        str = "TEAM:" + next.getTeamId();
                                    } else if (next.getFromCallsign().equals(str2)) {
                                        str = "DIRECT:" + next.getToCallsign();
                                    } else {
                                        str = "DIRECT:" + next.getFromCallsign();
                                    }
                                    Message message4 = (Message) map.get(str);
                                    if (message4 != null) {
                                        try {
                                            if (Long.parseLong(next.getCreatedAt()) > Long.parseLong(message4.getCreatedAt())) {
                                            }
                                        } catch (Exception unused) {
                                            if (next.getCreatedAt().compareTo(message4.getCreatedAt()) > 0) {
                                            }
                                        }
                                    }
                                    map.put(str, next);
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        N1.k kVar = (N1.k) obj2;
        switch (this.f1535c) {
            case 3:
                BinderC0008f binderC0008f = new BinderC0008f(kVar);
                a0 a0Var = (a0) ((U) obj).t();
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, (PendingIntent) this.f1536d);
                AbstractC0019q.b(parcelZza, (SleepSegmentRequest) this.f1537e);
                parcelZza.writeStrongBinder(binderC0008f);
                a0Var.zzc(79, parcelZza);
                break;
            case 4:
                ((D) obj).K((PendingIntent) this.f1536d, (LocationRequest) this.f1537e, kVar);
                break;
            default:
                ((D) obj).C((androidx.emoji2.text.e) this.f1536d, (DeviceOrientationRequest) this.f1537e, kVar);
                break;
        }
    }

    public Object q() {
        String string;
        C1 c1 = (C1) this.f1536d;
        String str = (String) this.f1537e;
        Context context = (Context) c1.f4663b;
        context.getClass();
        ContentResolver contentResolver = context.getContentResolver();
        w wVar = AbstractC0389t1.f5037a;
        if (contentResolver == null) {
            wVar.getClass();
            throw new IllegalStateException("ContentResolver needed with GservicesDelegateSupplier.init()");
        }
        synchronized (wVar) {
            try {
                if (((HashMap) wVar.f310c) == null) {
                    ((AtomicBoolean) wVar.f309b).set(false);
                    wVar.f310c = new HashMap(16, 1.0f);
                    wVar.h = new Object();
                    contentResolver.registerContentObserver(AbstractC0394u1.f5052a, true, new T.a(1, wVar));
                } else if (((AtomicBoolean) wVar.f309b).getAndSet(false)) {
                    ((HashMap) wVar.f310c).clear();
                    ((HashMap) wVar.f311d).clear();
                    ((HashMap) wVar.f312e).clear();
                    ((HashMap) wVar.f313f).clear();
                    ((HashMap) wVar.g).clear();
                    wVar.h = new Object();
                }
                Object obj = wVar.h;
                String str2 = null;
                if (((HashMap) wVar.f310c).containsKey(str)) {
                    String str3 = (String) ((HashMap) wVar.f310c).get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return str2;
                }
                try {
                    Uri uri = AbstractC0394u1.f5052a;
                    ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                    try {
                        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                            throw new C0404w1("Unable to acquire ContentProviderClient");
                        }
                        try {
                            Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, null, new String[]{str}, null);
                            try {
                                if (cursorQuery == null) {
                                    throw new C0404w1("ContentProvider query returned null cursor");
                                }
                                if (cursorQuery.moveToFirst()) {
                                    string = cursorQuery.getString(1);
                                    cursorQuery.close();
                                } else {
                                    cursorQuery.close();
                                    string = null;
                                }
                                if (string != null && string.equals(null)) {
                                    string = null;
                                }
                                synchronized (wVar) {
                                    try {
                                        if (obj == wVar.h) {
                                            ((HashMap) wVar.f310c).put(str, string);
                                        }
                                    } finally {
                                    }
                                }
                                if (string != null) {
                                    return string;
                                }
                                return null;
                            } catch (Throwable th) {
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (RemoteException e5) {
                            throw new C0404w1("ContentProvider query failed", e5);
                        }
                    } finally {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    }
                } catch (C0404w1 unused) {
                    return null;
                }
            } finally {
            }
        }
    }

    public String toString() {
        switch (this.f1535c) {
            case 8:
                return "Bounds{lower=" + ((E.c) this.f1536d) + " upper=" + ((E.c) this.f1537e) + "}";
            case 23:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.f1537e.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f1536d;
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    sb.append((String) arrayList.get(i5));
                    if (i5 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            case 24:
                String string = "[ ";
                if (((C0883f) this.f1536d) != null) {
                    for (int i6 = 0; i6 < 9; i6++) {
                        StringBuilder sbB = AbstractC0882e.b(string);
                        sbB.append(((C0883f) this.f1536d).f9565q[i6]);
                        sbB.append(" ");
                        string = sbB.toString();
                    }
                }
                return string + "] " + ((C0883f) this.f1536d);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ c(int i5, Object obj, Object obj2, boolean z4) {
        this.f1535c = i5;
        this.f1536d = obj;
        this.f1537e = obj2;
    }

    public /* synthetic */ c(C0009g c0009g, PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest) {
        this.f1535c = 3;
        this.f1536d = pendingIntent;
        this.f1537e = sleepSegmentRequest;
    }

    public c(EditText editText) {
        this.f1535c = 10;
        this.f1536d = editText;
        Y.i iVar = new Y.i(editText);
        this.f1537e = iVar;
        editText.addTextChangedListener(iVar);
        if (Y.a.f2866b == null) {
            synchronized (Y.a.f2865a) {
                try {
                    if (Y.a.f2866b == null) {
                        Y.a aVar = new Y.a();
                        try {
                            Y.a.f2867c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, Y.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        Y.a.f2866b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(Y.a.f2866b);
    }

    public /* synthetic */ c(Object obj, int i5, Object obj2) {
        this.f1535c = i5;
        this.f1537e = obj;
        this.f1536d = obj2;
    }

    public c(IBinder iBinder) throws RemoteException {
        this.f1535c = 20;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f1536d = new Messenger(iBinder);
            this.f1537e = null;
        } else if (Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
            this.f1537e = new m1.g(iBinder);
            this.f1536d = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    public /* synthetic */ c(Object obj) {
        this.f1535c = 23;
        E.i(obj);
        this.f1537e = obj;
        this.f1536d = new ArrayList();
    }

    public c(AbstractC0737m abstractC0737m) {
        this.f1535c = 0;
        this.f1536d = abstractC0737m;
        this.f1537e = new b(abstractC0737m, 0);
    }

    public c(int i5) {
        this.f1535c = i5;
        switch (i5) {
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                this.f1536d = Collections.synchronizedMap(new WeakHashMap());
                this.f1537e = Collections.synchronizedMap(new WeakHashMap());
                break;
            case 25:
                break;
            default:
                this.f1536d = new Object();
                this.f1537e = new LinkedHashMap();
                break;
        }
    }

    public c(Context context) {
        this.f1535c = 9;
        this.f1537e = context;
        this.f1536d = null;
    }

    public c(V v4) {
        this.f1535c = 12;
        this.f1536d = v4;
        w0 w0Var = new w0();
        w0Var.f4356a = 0;
        this.f1537e = w0Var;
    }
}
