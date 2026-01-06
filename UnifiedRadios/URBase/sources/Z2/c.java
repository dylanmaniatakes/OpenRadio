package Z2;

import D1.AbstractC0019q;
import D1.B;
import D1.BinderC0023v;
import D1.D;
import D1.a0;
import J1.C0093o0;
import J1.C0113v0;
import J1.EnumC0071h;
import J1.J0;
import J1.RunnableC0122y0;
import J1.X;
import J1.Z;
import L.h;
import L0.l;
import N1.k;
import O.F0;
import O.InterfaceC0183w;
import P.u;
import X2.t;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.unified.ur1.chat.NewMessageActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageApiService;
import com.unified.ur1.inbox.MessageDetailActivity;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import f.x;
import h1.C0558b;
import i3.DialogInterfaceOnClickListenerC0580i;
import i3.I;
import i3.s;
import j.C0587f;
import j.y;
import j3.e;
import j3.f;
import j3.g;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k.InterfaceC0643m;
import k.InterfaceC0669z0;
import l3.InterfaceC0748f;
import m3.C0774j;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p1.InterfaceC0830f;
import p1.m;
import p1.o;
import q1.E;
import q2.i;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class c implements u, InterfaceC0830f, o, m, y, Callback, s, InterfaceC0669z0, f, InterfaceC0643m, InterfaceC0748f, InterfaceC0183w {

    /* renamed from: e, reason: collision with root package name */
    public static volatile c f3145e;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3146c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3147d;

    public /* synthetic */ c(int i5, Object obj) {
        this.f3146c = i5;
        this.f3147d = obj;
    }

    @Override // j.y
    public void a(j.m mVar, boolean z4) {
        ((x) this.f3147d).s(mVar);
    }

    @Override // j3.f
    public void b(String str) throws JSONException {
        switch (this.f3146c) {
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                Log.w("WeatherDataManager", "OpenWeatherMap failed, trying WeatherAPI: " + str);
                e eVar = (e) this.f3147d;
                C0558b c0558b = eVar.f7615f;
                double d5 = eVar.f7613d;
                double d6 = eVar.f7614e;
                l lVar = new l(26, this);
                c0558b.getClass();
                lVar.b("WeatherAPI key not configured");
                break;
            default:
                Toast.makeText((RadioTeamsActivity) this.f3147d, "Login failed: " + str, 1).show();
                break;
        }
    }

    @Override // j3.f
    public void c(g gVar) {
        e eVar = (e) this.f3147d;
        eVar.f7615f.getClass();
        C0558b.a(gVar);
        eVar.f7612c.c(gVar);
    }

    @Override // P.u
    public boolean d(View view) {
        int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
        ViewPager2 viewPager2 = (ViewPager2) ((t) this.f3147d).f2836f;
        if (viewPager2.f4474t) {
            viewPager2.c(currentItem, true);
        }
        return true;
    }

    @Override // O.InterfaceC0183w
    public F0 e(View view, F0 f02) {
        int iA = f02.a();
        i iVar = (i) this.f3147d;
        iVar.n = iA;
        iVar.f9467o = f02.b();
        iVar.f9468p = f02.c();
        iVar.f();
        return f02;
    }

    @Override // i3.s
    public void f(Message message, int i5) {
        int i6 = UnifiedInboxActivity.f5830m;
        ((UnifiedInboxActivity) this.f3147d).s(message, i5);
    }

    @Override // k.InterfaceC0669z0
    public void g(j.m mVar, j.o oVar) {
        ((j.g) this.f3147d).f7426i.removeCallbacksAndMessages(mVar);
    }

    @Override // i3.s
    public void h(Message message) {
        int i5 = 1;
        int i6 = UnifiedInboxActivity.f5830m;
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f3147d;
        unifiedInboxActivity.getClass();
        new AlertDialog.Builder(unifiedInboxActivity).setTitle("Message Options").setItems(message.isRead() ? new String[]{"Mark as Unread", "Delete", "Forward", "Reply"} : new String[]{"Mark as Read", "Delete", "Forward", "Reply"}, new DialogInterfaceOnClickListenerC0580i(unifiedInboxActivity, i5, message)).show();
    }

    @Override // j.y
    public boolean i(j.m mVar) {
        Window.Callback callback = ((x) this.f3147d).n.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, mVar);
        return true;
    }

    @Override // p1.m
    public /* synthetic */ void j(Object obj) {
        ((B) this.f3147d).f331c.zzc();
    }

    @Override // k.InterfaceC0669z0
    public void k(j.m mVar, j.o oVar) {
        j.g gVar = (j.g) this.f3147d;
        gVar.f7426i.removeCallbacksAndMessages(null);
        ArrayList arrayList = gVar.f7428k;
        int size = arrayList.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (mVar == ((C0587f) arrayList.get(i5)).f7418b) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 == -1) {
            return;
        }
        int i6 = i5 + 1;
        gVar.f7426i.postAtTime(new RunnableC0122y0(this, i6 < arrayList.size() ? (C0587f) arrayList.get(i6) : null, oVar, mVar, 9), mVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // i3.s
    public void l(Message message) {
        int i5 = UnifiedInboxActivity.f5830m;
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f3147d;
        unifiedInboxActivity.getClass();
        Intent intent = new Intent(unifiedInboxActivity, (Class<?>) MessageDetailActivity.class);
        intent.putExtra("message_id", message.getId());
        unifiedInboxActivity.startActivity(intent);
        if (message.isRead()) {
            return;
        }
        int id = message.getId();
        unifiedInboxActivity.h.markAsRead("mark_read", id).enqueue(new h(id, unifiedInboxActivity));
    }

    @Override // l3.InterfaceC0748f
    public void m() {
        Toast.makeText((RadioTeamsActivity) this.f3147d, "Login successful!", 0).show();
    }

    @Override // p1.InterfaceC0830f
    public /* synthetic */ void n(Object obj) {
        h4.f.m((Status) obj, null, (k) this.f3147d);
    }

    @Override // i3.s
    public void o(Message message) {
        ((UnifiedInboxActivity) this.f3147d).t(message);
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f3146c) {
            case 18:
                int i5 = NewMessageActivity.f5757u;
                ((NewMessageActivity) this.f3147d).l();
                break;
            default:
                String str = "Network error: " + th.getMessage();
                int i6 = MessageDetailActivity.f5814p;
                ((MessageDetailActivity) this.f3147d).k(str);
                Log.e("MessageDetailActivity", "Network error loading message", th);
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) throws JSONException {
        Message next;
        String string;
        switch (this.f3146c) {
            case 18:
                NewMessageActivity newMessageActivity = (NewMessageActivity) this.f3147d;
                try {
                    if (!response.isSuccessful() || response.body() == null) {
                        int i5 = NewMessageActivity.f5757u;
                        newMessageActivity.l();
                        break;
                    } else {
                        JSONObject jSONObject = new JSONObject(((ResponseBody) response.body()).string());
                        if (!jSONObject.getBoolean("success") || !jSONObject.has("data")) {
                            int i6 = NewMessageActivity.f5757u;
                            newMessageActivity.l();
                            break;
                        } else {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            if (jSONObject2.has("users")) {
                                JSONArray jSONArray = jSONObject2.getJSONArray("users");
                                ArrayList arrayList = new ArrayList();
                                for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                    JSONObject jSONObject3 = jSONArray.getJSONObject(i7);
                                    arrayList.add(new I(jSONObject3.optString("callsign", ""), jSONObject3.optString("first_name", ""), jSONObject3.optString("last_name", "")));
                                }
                                newMessageActivity.f5768p.clear();
                                newMessageActivity.f5768p.addAll(arrayList);
                                newMessageActivity.n.notifyDataSetChanged();
                                newMessageActivity.g.setVisibility(0);
                                break;
                            } else {
                                int i8 = NewMessageActivity.f5757u;
                                newMessageActivity.l();
                                break;
                            }
                        }
                    }
                } catch (Exception unused) {
                    int i9 = NewMessageActivity.f5757u;
                    newMessageActivity.l();
                    return;
                }
            default:
                boolean zIsSuccessful = response.isSuccessful();
                MessageDetailActivity messageDetailActivity = (MessageDetailActivity) this.f3147d;
                if (!zIsSuccessful || response.body() == null) {
                    int i10 = MessageDetailActivity.f5814p;
                    messageDetailActivity.k("Failed to load message details");
                    Log.e("MessageDetailActivity", "API response error: " + response.code());
                    break;
                } else {
                    Iterator<Message> it = ((MessageResponse) response.body()).getMessages().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (next.getId() == messageDetailActivity.f5823m) {
                            }
                        } else {
                            next = null;
                        }
                    }
                    if (next == null) {
                        int i11 = MessageDetailActivity.f5814p;
                        messageDetailActivity.k("Message not found");
                        break;
                    } else {
                        messageDetailActivity.f5824o = next;
                        if (messageDetailActivity.n) {
                            StringBuilder sb = new StringBuilder("To: ");
                            sb.append(next.getToCallsign() != null ? next.getToCallsign() : "Unknown");
                            string = sb.toString();
                        } else {
                            StringBuilder sb2 = new StringBuilder("From: ");
                            sb2.append(next.getFromCallsign() != null ? next.getFromCallsign() : "Unknown");
                            string = sb2.toString();
                        }
                        messageDetailActivity.f5815c.setText(string);
                        messageDetailActivity.f5816d.setText((next.getSubject() == null || next.getSubject().trim().isEmpty()) ? "No Subject" : next.getSubject());
                        String createdAt = next.getCreatedAt();
                        if (createdAt == null || createdAt.trim().isEmpty()) {
                            createdAt = "Unknown Date";
                        } else {
                            try {
                                new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a", Locale.getDefault());
                            } catch (Exception e5) {
                                Log.w("MessageDetailActivity", "Error formatting date: ".concat(createdAt), e5);
                            }
                        }
                        messageDetailActivity.f5817e.setText(createdAt);
                        messageDetailActivity.f5818f.setText((next.getMessageBody() == null || next.getMessageBody().trim().isEmpty()) ? "No message content" : next.getMessageBody());
                        LinearLayout linearLayout = messageDetailActivity.g;
                        if (linearLayout == null) {
                            Log.w("MessageDetailActivity", "imageContainer is null");
                        } else {
                            linearLayout.removeAllViews();
                            try {
                                if (!next.isHasAttachments() || next.getAttachments() == null) {
                                    messageDetailActivity.g.setVisibility(8);
                                    Log.d("MessageDetailActivity", "No attachments found (hasAttachments: " + next.isHasAttachments() + ")");
                                } else {
                                    List<Message.Attachment> attachments = next.getAttachments();
                                    Log.d("MessageDetailActivity", "Attachments object type: ".concat(attachments.getClass().getSimpleName()));
                                    Log.d("MessageDetailActivity", "Processing " + attachments.size() + " attachments");
                                    boolean z4 = false;
                                    for (Object obj : attachments) {
                                        if (obj instanceof Message.Attachment) {
                                            Message.Attachment attachment = (Message.Attachment) obj;
                                            if (messageDetailActivity.j(attachment.getType(), attachment.getData())) {
                                                z4 = true;
                                            }
                                        } else if (obj instanceof Map) {
                                            Map map = (Map) obj;
                                            String str = (String) map.get("type");
                                            String str2 = (String) map.get("data");
                                            Log.d("MessageDetailActivity", "Attachment type from map: " + str);
                                            if (messageDetailActivity.j(str, str2)) {
                                                z4 = true;
                                            }
                                        } else {
                                            Log.w("MessageDetailActivity", "Unexpected attachment object type: " + obj.getClass().getSimpleName());
                                        }
                                    }
                                    messageDetailActivity.g.setVisibility(z4 ? 0 : 8);
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Image container visibility: ");
                                    sb3.append(z4 ? "VISIBLE" : "GONE");
                                    Log.d("MessageDetailActivity", sb3.toString());
                                }
                            } catch (Exception e6) {
                                Log.e("MessageDetailActivity", "Error displaying image attachments: " + e6.getMessage(), e6);
                                messageDetailActivity.g.setVisibility(8);
                            }
                        }
                        LinearLayout linearLayout2 = messageDetailActivity.h;
                        if (linearLayout2 != null) {
                            if (messageDetailActivity.n) {
                                linearLayout2.setVisibility(8);
                            } else {
                                linearLayout2.setVisibility(0);
                            }
                        }
                        if (messageDetailActivity.getSupportActionBar() != null && next.getSubject() != null && !next.getSubject().trim().isEmpty()) {
                            messageDetailActivity.getSupportActionBar().p(next.getSubject());
                        }
                        StringBuilder sb4 = new StringBuilder("Message displayed successfully - ID: ");
                        sb4.append(next.getId());
                        sb4.append(", Type: ");
                        com.unified.ur1.SatelliteTracker.h.q(sb4, messageDetailActivity.n ? "Sent" : "Received", "MessageDetailActivity");
                        if (!messageDetailActivity.n && !next.isRead()) {
                            int i12 = messageDetailActivity.f5823m;
                            MessageApiService messageApiService = messageDetailActivity.f5821k;
                            if (messageApiService == null) {
                                Log.w("MessageDetailActivity", "Cannot mark message as read - API service not available");
                                break;
                            } else {
                                messageApiService.markAsRead("mark_read", i12).enqueue(new B0.l(17, messageDetailActivity));
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        k kVar = (k) obj2;
        D d5 = (D) obj;
        switch (this.f3146c) {
            case 3:
                d5.H((LastLocationRequest) this.f3147d, kVar);
                break;
            case 4:
                d5.N((PendingIntent) this.f3147d, kVar);
                break;
            default:
                LocationSettingsRequest locationSettingsRequest = (LocationSettingsRequest) this.f3147d;
                E.b(locationSettingsRequest != null, "locationSettingsRequest can't be null");
                a0 a0Var = (a0) d5.t();
                BinderC0023v binderC0023v = new BinderC0023v(kVar);
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, locationSettingsRequest);
                parcelZza.writeStrongBinder(binderC0023v.asBinder());
                parcelZza.writeString(null);
                a0Var.zzc(63, parcelZza);
                break;
        }
    }

    @Override // i3.s
    public void q(Message message) {
        ((UnifiedInboxActivity) this.f3147d).l(message);
    }

    @Override // i3.s
    public void r(Message message) {
        ((UnifiedInboxActivity) this.f3147d).n(message);
    }

    public boolean s(File file) throws InterruptedException, IOException {
        byte bA;
        m3.s sVar = (m3.s) this.f3147d;
        try {
            C0774j c0774j = new C0774j();
            sVar.b();
            sVar.d(Arrays.copyOf(Arrays.copyOf((file.getName() + (char) 0 + file.length()).getBytes(), 128), 128), c0774j);
            Thread.sleep(20L);
            sVar.c(new DataInputStream(new FileInputStream(file)), c0774j, new byte[1024]);
            Thread.sleep(20L);
            for (int i5 = 0; i5 < 10; i5++) {
                OutputStream outputStream = sVar.f8631c;
                outputStream.write(4);
                outputStream.flush();
                try {
                    bA = sVar.a();
                } catch (Exception unused) {
                }
                if (bA == 6) {
                    break;
                }
                if (bA == 24) {
                    throw new IOException("Transmission terminated");
                }
            }
            Thread.sleep(20L);
            sVar.e();
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public void t(int i5, String str, List list, boolean z4, boolean z5) {
        X x4;
        int i6 = i5 - 1;
        C0093o0 c0093o0 = (C0093o0) this.f3147d;
        if (i6 == 0) {
            Z z6 = ((C0113v0) c0093o0.f84c).f1417k;
            C0113v0.k(z6);
            x4 = z6.f1083o;
        } else if (i6 != 1) {
            if (i6 == 3) {
                Z z7 = ((C0113v0) c0093o0.f84c).f1417k;
                C0113v0.k(z7);
                x4 = z7.f1084p;
            } else if (i6 != 4) {
                Z z8 = ((C0113v0) c0093o0.f84c).f1417k;
                C0113v0.k(z8);
                x4 = z8.n;
            } else if (z4) {
                Z z9 = ((C0113v0) c0093o0.f84c).f1417k;
                C0113v0.k(z9);
                x4 = z9.f1081l;
            } else if (z5) {
                Z z10 = ((C0113v0) c0093o0.f84c).f1417k;
                C0113v0.k(z10);
                x4 = z10.f1080k;
            } else {
                Z z11 = ((C0113v0) c0093o0.f84c).f1417k;
                C0113v0.k(z11);
                x4 = z11.f1082m;
            }
        } else if (z4) {
            Z z12 = ((C0113v0) c0093o0.f84c).f1417k;
            C0113v0.k(z12);
            x4 = z12.f1078i;
        } else if (z5) {
            Z z13 = ((C0113v0) c0093o0.f84c).f1417k;
            C0113v0.k(z13);
            x4 = z13.h;
        } else {
            Z z14 = ((C0113v0) c0093o0.f84c).f1417k;
            C0113v0.k(z14);
            x4 = z14.f1079j;
        }
        int size = list.size();
        if (size == 1) {
            x4.b(list.get(0), str);
            return;
        }
        if (size == 2) {
            x4.c(list.get(0), list.get(1), str);
        } else if (size != 3) {
            x4.a(str);
        } else {
            x4.d(str, list.get(0), list.get(1), list.get(2));
        }
    }

    public String toString() {
        switch (this.f3146c) {
            case 8:
                StringBuilder sb = new StringBuilder("1");
                for (J0 j02 : J0.values()) {
                    EnumC0071h enumC0071h = (EnumC0071h) ((EnumMap) this.f3147d).get(j02);
                    if (enumC0071h == null) {
                        enumC0071h = EnumC0071h.UNSET;
                    }
                    sb.append(enumC0071h.f1230j);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(J1.J0 r3, int r4) {
        /*
            r2 = this;
            J1.h r0 = J1.EnumC0071h.UNSET
            r1 = -30
            if (r4 == r1) goto L1e
            r1 = -20
            if (r4 == r1) goto L1b
            r1 = -10
            if (r4 == r1) goto L18
            if (r4 == 0) goto L1b
            r1 = 30
            if (r4 == r1) goto L15
            goto L20
        L15:
            J1.h r0 = J1.EnumC0071h.INITIALIZATION
            goto L20
        L18:
            J1.h r0 = J1.EnumC0071h.MANIFEST
            goto L20
        L1b:
            J1.h r0 = J1.EnumC0071h.API
            goto L20
        L1e:
            J1.h r0 = J1.EnumC0071h.TCF
        L20:
            java.lang.Object r4 = r2.f3147d
            java.util.EnumMap r4 = (java.util.EnumMap) r4
            r4.put(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.c.u(J1.J0, int):void");
    }

    public void v(J0 j02, EnumC0071h enumC0071h) {
        ((EnumMap) this.f3147d).put((EnumMap) j02, (J0) enumC0071h);
    }

    public /* synthetic */ c(int i5, boolean z4) {
        this.f3146c = i5;
    }

    public c(k kVar) {
        this.f3146c = 2;
        E.i(kVar);
        this.f3147d = kVar;
    }

    public c(EnumMap enumMap) {
        this.f3146c = 8;
        EnumMap enumMap2 = new EnumMap(J0.class);
        this.f3147d = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public c(int i5) {
        this.f3146c = i5;
        switch (i5) {
            case 8:
                this.f3147d = new EnumMap(J0.class);
                break;
            default:
                this.f3147d = new HashSet();
                break;
        }
    }

    public c(TextView textView) {
        this.f3146c = 13;
        h4.f.c(textView, "textView cannot be null");
        this.f3147d = new Y.g(textView);
    }
}
