package L0;

import C0.y;
import C0.z;
import D0.w;
import D1.A;
import D1.AbstractC0019q;
import D1.BinderC0008f;
import D1.C0016n;
import D1.D;
import D1.U;
import D1.a0;
import J1.C0058c1;
import J1.C0072h0;
import J1.C0113v0;
import J1.H;
import J1.K1;
import J1.U0;
import J1.Z;
import L0.s;
import O.F0;
import O.InterfaceC0183w;
import X2.t;
import android.app.PendingIntent;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.B;
import androidx.recyclerview.widget.t0;
import com.google.android.gms.internal.measurement.C0368p;
import com.google.android.gms.internal.measurement.C0387t;
import com.google.android.gms.internal.measurement.EnumC0402w;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.InterfaceC0397v;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.LocationRequest;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.ApiResponse;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import g3.RunnableC0551b;
import h4.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import l0.AbstractC0737m;
import l0.C0738n;
import m3.C0765a;
import m3.C0766b;
import m3.C0774j;
import m3.HandlerThreadC0775k;
import m3.v;
import n1.C0788e;
import n3.C0805a;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Settings;
import org.conscrypt.FileClientSessionCache;
import org.json.JSONException;
import org.json.JSONObject;
import q1.E;
import q3.AbstractC0869a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import s.AbstractC0882e;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class s implements z, p1.o, A, InterfaceC0397v, InterfaceC0183w, Callback, N1.e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1595c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1596d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1597e;

    public /* synthetic */ s(int i5, Object obj, Object obj2, boolean z4) {
        this.f1595c = i5;
        this.f1596d = obj2;
        this.f1597e = obj;
    }

    public static void C() {
        byte[] bArr = new byte[10];
        int i5 = 0;
        bArr[0] = 104;
        bArr[1] = 46;
        bArr[2] = 1;
        bArr[3] = 1;
        bArr[6] = 0;
        bArr[7] = 1;
        bArr[8] = (byte) 8;
        bArr[9] = 16;
        for (int i6 = 1; i6 < 4; i6 += 2) {
            i5 += ((bArr[i6] & 255) << 8) | (bArr[i6 + 1] & 255);
        }
        for (int i7 = 6; i7 < 9; i7 += 2) {
            int i8 = i7 + 1;
            i5 += i8 < 9 ? (bArr[i8] & 255) | ((bArr[i7] & 255) << 8) : (bArr[i7] & 255) << 8;
        }
        while (true) {
            int i9 = i5 >> 16;
            if (i9 <= 0) {
                int i10 = i5 ^ Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                bArr[4] = (byte) (i10 >> 8);
                bArr[5] = (byte) (i10 & 255);
                HandlerThreadC0775k.a().g(AbstractC0869a.b(bArr));
                return;
            }
            i5 = (i5 & Settings.DEFAULT_INITIAL_WINDOW_SIZE) + i9;
        }
    }

    public static void v(byte[] bArr, int i5, long j5) {
        bArr[i5] = (byte) (j5 >> 24);
        bArr[i5 + 1] = (byte) (j5 >> 16);
        bArr[i5 + 2] = (byte) (j5 >> 8);
        bArr[i5 + 3] = (byte) j5;
    }

    public void A() throws Throwable {
        Context context;
        long jA;
        long jE;
        int iQ;
        int iD;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Context context2 = (Context) this.f1597e;
        f.n(context2);
        if (((C0774j) this.f1596d) == null) {
            Log.e("Unified - ProgrammingThread", "DmrBusiness instance is null");
            return;
        }
        Log.i("Unified - ProgrammingThread", "Starting DMR Programming sequence for CJ-1");
        y1.f.d("/sys/bus/platform/drivers/dmr_gpio/auctusctl");
        y1.f.d("/sys/bus/platform/drivers/dmr_gpio/dmr_pwr");
        x();
        try {
            Thread.sleep(300L);
            jA = h4.c.A(context2);
            jE = h4.c.E(context2);
            iQ = h4.c.q(context2);
            if (iQ > 9999999) {
                iQ = Integer.parseInt(String.valueOf(iQ).substring(0, 7));
            }
            h4.c.C(context2).getString("group_list", "");
            iD = h4.c.D(context2);
            i5 = h4.c.C(context2).getInt("contact_type", 1);
            i6 = h4.c.C(context2).getInt("power", 1);
            i7 = h4.c.C(context2).getInt("color_code", 2);
            i8 = h4.c.C(context2).getInt("inbound_slot", 0);
            i9 = h4.c.C(context2).getInt("outbound_slot", 0);
            i10 = h4.c.C(context2).getInt("channel_mode", 0);
            context = context2;
        } catch (Exception e5) {
            e = e5;
            context = context2;
        }
        try {
            int i11 = h4.c.C(context2).getInt("mic_gain", 3);
            if (i10 == 1) {
                i10 = 0;
            }
            Log.d("Unified - ProgrammingThread", String.format("Settings loaded - RX: %d, TX: %d", Long.valueOf(jA), Long.valueOf(jE)));
            Log.d("Unified - ProgrammingThread", String.format("Local ID: %d, TX Contact: %d", Integer.valueOf(iQ), Integer.valueOf(iD)));
            Log.d("Unified - ProgrammingThread", String.format("Contact Type: %d, Power: %d, Color Code: %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)));
            Log.d("Unified - ProgrammingThread", String.format("Slots - Inbound: %d, Outbound: %d", Integer.valueOf(i8), Integer.valueOf(i9)));
            Log.d("Unified - ProgrammingThread", String.format("Channel Mode: %d", Integer.valueOf(i10)));
            Log.d("Unified - ProgrammingThread", "Sending channel configuration command...");
            C0766b c0766b = new C0766b();
            c0766b.f8577a = (int) jA;
            c0766b.f8578b = (int) jE;
            c0766b.f8579c = iQ;
            c0766b.f8580d = iD;
            c0766b.f8581e = i5;
            c0766b.f8582f = i6;
            c0766b.g = i7;
            c0766b.h = i8;
            c0766b.f8583i = i9;
            c0766b.f8584j = 0;
            c0766b.f8585k = 2;
            c0766b.f8586l = "00000000";
            c0766b.f8587m = 2;
            c0766b.n = 8;
            c0766b.f8588o = i11;
            c0766b.f8589p = 2;
            c0766b.f8590q = new int[]{iD, iD, iD, iD, iD};
            C0774j.e(c0766b, new C0805a(3));
            Thread.sleep(100L);
            C0774j.c(new w("2E", AbstractC0869a.a(8, 2)).a(), new C0805a(4));
            C0774j.f(i11, new C0805a(5));
            f.i(context);
        } catch (Exception e6) {
            e = e6;
            f.i(context);
            Log.e("Unified - ProgrammingThread", "Error in test sequence", e);
        }
    }

    public void B() throws InterruptedException {
        Context context = (Context) this.f1597e;
        f.n(context);
        Log.i("DMR009 - DigitalProgramming", "Starting DMR Programming sequence for CJ-26");
        try {
            Thread.sleep(10L);
            long jA = h4.c.A(context);
            long jE = h4.c.E(context);
            int iQ = h4.c.q(context);
            int iD = h4.c.D(context);
            Log.d("DMR009 - DigitalProgramming", String.format("Settings loaded - RX: %d, TX: %d", Long.valueOf(jA), Long.valueOf(jE)));
            Log.d("DMR009 - DigitalProgramming", String.format("Local ID: %d, TX Contact: %d", Integer.valueOf(iQ), Integer.valueOf(iD)));
            byte[] bArr = new byte[172];
            bArr[0] = 104;
            bArr[1] = 34;
            bArr[2] = 1;
            bArr[3] = 1;
            bArr[4] = 105;
            bArr[5] = 26;
            bArr[6] = 0;
            bArr[7] = -93;
            v(bArr, 8, jA);
            v(bArr, 12, jE);
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = i5 * 4;
                bArr[i6 + 16] = (byte) (iD >> 24);
                bArr[i6 + 17] = (byte) (iD >> 16);
                bArr[i6 + 18] = (byte) (iD >> 8);
                bArr[i6 + 19] = (byte) iD;
            }
            for (int i7 = 36; i7 < 140; i7++) {
                bArr[i7] = 0;
            }
            bArr[140] = 1;
            bArr[141] = 1;
            bArr[142] = 1;
            bArr[143] = 0;
            bArr[144] = 0;
            bArr[145] = 2;
            bArr[146] = 0;
            bArr[147] = 0;
            bArr[148] = 0;
            bArr[149] = 0;
            bArr[150] = 1;
            bArr[151] = 8;
            bArr[152] = 0;
            bArr[153] = 2;
            bArr[171] = 16;
            String strB = AbstractC0869a.b(bArr);
            Log.d("DMR009 - DigitalProgramming", "Generated command: " + strB);
            if (HandlerThreadC0775k.a().g(strB)) {
                Thread.sleep(100L);
                HandlerThreadC0775k.a().g(AbstractC0869a.b(new byte[]{104, 53, 1, 1, -108, -72, 0, 1, 2, 16}));
                f.i(context);
            }
        } catch (Exception e5) {
            f.i(context);
            Log.e("DMR009 - DigitalProgramming", "Error in digital programming sequence", e5);
        }
    }

    public InterfaceC0363o D(t tVar, InterfaceC0363o interfaceC0363o) {
        Z3.i.m(tVar);
        if (!(interfaceC0363o instanceof C0368p)) {
            return interfaceC0363o;
        }
        C0368p c0368p = (C0368p) interfaceC0363o;
        ArrayList arrayList = c0368p.f5014k;
        HashMap map = (HashMap) this.f1596d;
        String str = c0368p.f5013j;
        return (map.containsKey(str) ? (C0387t) map.get(str) : (C0387t) this.f1597e).a(str, tVar, arrayList);
    }

    public void E() throws JSONException {
        C0113v0 c0113v0 = (C0113v0) ((C0058c1) this.f1597e).f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        SparseArray sparseArrayQ = c0072h0.q();
        K1 k1 = (K1) this.f1596d;
        sparseArrayQ.put(k1.f883l, Long.valueOf(k1.f882k));
        C0072h0 c0072h02 = c0113v0.f1416j;
        C0113v0.i(c0072h02);
        int[] iArr = new int[sparseArrayQ.size()];
        long[] jArr = new long[sparseArrayQ.size()];
        for (int i5 = 0; i5 < sparseArrayQ.size(); i5++) {
            iArr[i5] = sparseArrayQ.keyAt(i5);
            jArr[i5] = ((Long) sparseArrayQ.valueAt(i5)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        c0072h02.f1243q.s(bundle);
    }

    public void F(C0387t c0387t) {
        Iterator it = c0387t.f5035a.iterator();
        while (it.hasNext()) {
            ((HashMap) this.f1596d).put(Integer.valueOf(((EnumC0402w) it.next()).f5120j).toString(), c0387t);
        }
    }

    @Override // D1.A
    public androidx.emoji2.text.e a() {
        return (androidx.emoji2.text.e) this.f1596d;
    }

    @Override // D1.A
    public void b(androidx.emoji2.text.e eVar) {
        throw new IllegalStateException();
    }

    public void c() {
        int[] iArr = (int[]) this.f1596d;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f1597e = null;
    }

    public void d(int i5) {
        int[] iArr = (int[]) this.f1596d;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i5, 10) + 1];
            this.f1596d = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i5 >= iArr.length) {
            int length = iArr.length;
            while (length <= i5) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f1596d = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f1596d;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    @Override // O.InterfaceC0183w
    public F0 e(View view, F0 f02) {
        g2.o oVar = new g2.o();
        g2.o oVar2 = (g2.o) this.f1597e;
        oVar.f6950a = oVar2.f6950a;
        oVar.f6951b = oVar2.f6951b;
        oVar.f6952c = oVar2.f6952c;
        oVar.f6953d = oVar2.f6953d;
        return ((g2.n) this.f1596d).e(view, f02, oVar);
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC0397v
    public t f(InterfaceC0363o interfaceC0363o) {
        String str = (String) this.f1597e;
        t tVar = (t) this.f1596d;
        tVar.v(str, interfaceC0363o);
        return tVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory g(java.lang.String r14) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.s.g(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public File h() {
        if (((File) this.f1596d) == null) {
            synchronized (this) {
                try {
                    if (((File) this.f1596d) == null) {
                        A2.g gVar = (A2.g) this.f1597e;
                        gVar.a();
                        this.f1596d = new File(gVar.f26a.getFilesDir(), "PersistedInstallation." + ((A2.g) this.f1597e).c() + ".json");
                    }
                } finally {
                }
            }
        }
        return (File) this.f1596d;
    }

    public ArrayList i(String str) {
        C0738n c0738nO = C0738n.o(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1596d;
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

    public void j(S2.b bVar) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.f2368a);
            jSONObject.put("Status", AbstractC0882e.c(bVar.f2369b));
            jSONObject.put("AuthToken", bVar.f2370c);
            jSONObject.put("RefreshToken", bVar.f2371d);
            jSONObject.put("TokenCreationEpochInSecs", bVar.f2373f);
            jSONObject.put("ExpiresInSecs", bVar.f2372e);
            jSONObject.put("FisError", bVar.g);
            A2.g gVar = (A2.g) this.f1597e;
            gVar.a();
            File fileCreateTempFile = File.createTempFile("PersistedInstallation", "tmp", gVar.f26a.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(h())) {
            } else {
                throw new IOException("unable to rename the tmpfile to PersistedInstallation");
            }
        } catch (IOException | JSONException unused) {
        }
    }

    @Override // N1.e
    public void k(N1.j jVar) {
        ((Map) ((c) this.f1597e).f1537e).remove((N1.k) this.f1596d);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int l(int r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f1596d
            int[] r0 = (int[]) r0
            r1 = -1
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r0.length
            if (r6 < r0) goto Lc
            return r1
        Lc:
            java.lang.Object r0 = r5.f1597e
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L14
        L12:
            r0 = r1
            goto L6f
        L14:
            r2 = 0
            if (r0 != 0) goto L18
            goto L33
        L18:
            int r0 = r0.size()
            int r0 = r0 + (-1)
        L1e:
            if (r0 < 0) goto L33
            java.lang.Object r3 = r5.f1597e
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.t0 r3 = (androidx.recyclerview.widget.t0) r3
            int r4 = r3.f4332j
            if (r4 != r6) goto L30
            r2 = r3
            goto L33
        L30:
            int r0 = r0 + (-1)
            goto L1e
        L33:
            if (r2 == 0) goto L3c
            java.lang.Object r0 = r5.f1597e
            java.util.List r0 = (java.util.List) r0
            r0.remove(r2)
        L3c:
            java.lang.Object r0 = r5.f1597e
            java.util.List r0 = (java.util.List) r0
            int r0 = r0.size()
            r2 = 0
        L45:
            if (r2 >= r0) goto L59
            java.lang.Object r3 = r5.f1597e
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r2)
            androidx.recyclerview.widget.t0 r3 = (androidx.recyclerview.widget.t0) r3
            int r3 = r3.f4332j
            if (r3 < r6) goto L56
            goto L5a
        L56:
            int r2 = r2 + 1
            goto L45
        L59:
            r2 = r1
        L5a:
            if (r2 == r1) goto L12
            java.lang.Object r0 = r5.f1597e
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r2)
            androidx.recyclerview.widget.t0 r0 = (androidx.recyclerview.widget.t0) r0
            java.lang.Object r3 = r5.f1597e
            java.util.List r3 = (java.util.List) r3
            r3.remove(r2)
            int r0 = r0.f4332j
        L6f:
            if (r0 != r1) goto L7f
            java.lang.Object r0 = r5.f1596d
            int[] r0 = (int[]) r0
            int r2 = r0.length
            java.util.Arrays.fill(r0, r6, r2, r1)
            java.lang.Object r6 = r5.f1596d
            int[] r6 = (int[]) r6
            int r6 = r6.length
            return r6
        L7f:
            int r0 = r0 + 1
            java.lang.Object r2 = r5.f1596d
            int[] r2 = (int[]) r2
            int r2 = r2.length
            int r0 = java.lang.Math.min(r0, r2)
            java.lang.Object r2 = r5.f1596d
            int[] r2 = (int[]) r2
            java.util.Arrays.fill(r2, r6, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.s.l(int):int");
    }

    public synchronized void m(int i5, Exception exc, String str, Object... objArr) {
        try {
            str.getClass();
            ThreadLocal threadLocal = (ThreadLocal) this.f1596d;
            if (((String) threadLocal.get()) != null) {
                threadLocal.remove();
            }
            if (objArr.length != 0) {
                str = String.format(str, objArr);
            }
            n(str, exc);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void n(String str, Exception exc) {
        if (exc != null) {
            try {
                str = str + " : " + e4.a.n(exc);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (exc != null && str == null) {
            str = e4.a.n(exc);
        }
        if (str != null) {
            str.length();
        }
        Iterator it = ((ArrayList) this.f1597e).iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
    }

    public void o(Z3.i iVar) {
        ((B) this.f1596d).f(iVar);
        boolean z4 = iVar instanceof y;
        N0.k kVar = (N0.k) this.f1597e;
        if (z4) {
            kVar.j((y) iVar);
        } else if (iVar instanceof C0.w) {
            kVar.k(((C0.w) iVar).f179a);
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f1595c) {
            case 16:
                ChatActivity chatActivity = (ChatActivity) this.f1597e;
                chatActivity.f5739f.setRefreshing(false);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                List<Message> list = (List) this.f1596d;
                for (Message message : list) {
                    if (chatActivity.s(message)) {
                        linkedHashMap.put(Integer.valueOf(message.getId()), message);
                    }
                }
                chatActivity.n.clear();
                chatActivity.n.addAll(linkedHashMap.values());
                chatActivity.n.sort(new g3.e(chatActivity, 1));
                Log.d("ChatActivity", "Received-only load: " + list.size() + " messages, after deduplication: " + chatActivity.n.size() + " unique messages");
                chatActivity.f5743l.notifyDataSetChanged();
                if (!chatActivity.n.isEmpty()) {
                    chatActivity.f5738e.post(new RunnableC0551b(chatActivity, 0));
                }
                chatActivity.u();
                Toast.makeText(chatActivity, "Could not load sent messages", 0).show();
                break;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f1597e;
                composeMessageActivity.f5796f.setEnabled(true);
                composeMessageActivity.f5796f.setText((String) this.f1596d);
                Log.e("ComposeMessageActivity", "Network error sending message", th);
                Toast.makeText(composeMessageActivity, "Network error: " + th.getMessage(), 1).show();
                break;
            default:
                Log.e("UnifiedInbox", "❌ FCM token registration network failure", th);
                Toast.makeText((UnifiedInboxActivity) this.f1597e, "❌ Network error: " + th.getMessage(), 1).show();
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        String str;
        switch (this.f1595c) {
            case 16:
                ChatActivity chatActivity = (ChatActivity) this.f1597e;
                chatActivity.f5739f.setRefreshing(false);
                List<Message> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null && ((MessageResponse) response.body()).getMessages() != null) {
                    arrayList = ((MessageResponse) response.body()).getMessages();
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll((List) this.f1596d);
                arrayList2.addAll(arrayList);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Message message = (Message) it.next();
                    if (chatActivity.s(message)) {
                        linkedHashMap.put(Integer.valueOf(message.getId()), message);
                    }
                }
                chatActivity.n.clear();
                chatActivity.n.addAll(linkedHashMap.values());
                chatActivity.n.sort(new g3.m(this, 1));
                Log.d("ChatActivity", "Initial load: Combined " + arrayList2.size() + " messages, after deduplication: " + chatActivity.n.size() + " unique messages");
                chatActivity.f5743l.notifyDataSetChanged();
                if (!chatActivity.n.isEmpty()) {
                    chatActivity.f5738e.post(new C0.e(17, this));
                }
                chatActivity.u();
                return;
            case o1.f.API_NOT_CONNECTED /* 17 */:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f1597e;
                composeMessageActivity.f5796f.setEnabled(true);
                composeMessageActivity.f5796f.setText((String) this.f1596d);
                Log.d("ComposeMessageActivity", "Response code: " + response.code());
                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = (ApiResponse) response.body();
                    composeMessageActivity.f5813z = null;
                    composeMessageActivity.f5812y.setVisibility(8);
                    Log.d("ComposeMessageActivity", "Message sent successfully: " + apiResponse.getMessage());
                    Toast.makeText(composeMessageActivity, "reply".equals(composeMessageActivity.f5803p) ? "Reply sent successfully!" : "forward".equals(composeMessageActivity.f5803p) ? "Message forwarded successfully!" : "Message sent successfully!", 0).show();
                    composeMessageActivity.setResult(-1);
                    composeMessageActivity.finish();
                    return;
                }
                Log.e("ComposeMessageActivity", "Failed to send message: " + response.code());
                if (response.errorBody() != null) {
                    try {
                        String strString = response.errorBody().string();
                        Log.e("ComposeMessageActivity", "Error body: " + strString);
                        str = "Failed to send message. Server response: " + strString;
                    } catch (Exception e5) {
                        Log.e("ComposeMessageActivity", "Error reading error body", e5);
                    }
                } else {
                    str = "Failed to send message";
                }
                Toast.makeText(composeMessageActivity, str, 1).show();
                return;
            default:
                StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("UnifiedInbox", "=== FCM Registration Response ===", "Response Code: ");
                sbH.append(response.code());
                Log.d("UnifiedInbox", sbH.toString());
                Log.d("UnifiedInbox", "Response Message: " + response.message());
                if (call.request() != null && call.request().body() != null) {
                    Log.d("UnifiedInbox", "Request Content-Type: " + call.request().body().contentType());
                    try {
                        Log.d("UnifiedInbox", "Request Content-Length: " + call.request().body().contentLength());
                    } catch (IOException e6) {
                        throw new RuntimeException(e6);
                    }
                }
                boolean zIsSuccessful = response.isSuccessful();
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f1597e;
                if (zIsSuccessful && response.body() != null) {
                    ApiResponse apiResponse2 = (ApiResponse) response.body();
                    StringBuilder sbH2 = com.unified.ur1.SatelliteTracker.h.h("UnifiedInbox", "✅ FCM token registered successfully!", "Server response: ");
                    sbH2.append(apiResponse2.getMessage());
                    Log.d("UnifiedInbox", sbH2.toString());
                    unifiedInboxActivity.f5837k.edit().putBoolean("fcm_registered", true).putString("registered_device_id", (String) this.f1596d).putString("registered_callsign", unifiedInboxActivity.f5836j).putLong("registration_timestamp", System.currentTimeMillis()).apply();
                    Toast.makeText(unifiedInboxActivity, "✅ Push notifications enabled for: " + unifiedInboxActivity.f5836j, 0).show();
                    return;
                }
                Log.e("UnifiedInbox", "❌ Failed to register FCM token");
                Log.e("UnifiedInbox", "Response Code: " + response.code());
                Log.e("UnifiedInbox", "Response Message: " + response.message());
                Log.d("UnifiedInbox", "Response Headers: " + response.headers());
                if (response.errorBody() != null) {
                    try {
                        Log.e("UnifiedInbox", "Error Body: " + response.errorBody().string());
                    } catch (Exception e7) {
                        Log.e("UnifiedInbox", "Error reading error body", e7);
                    }
                }
                if (response.code() == 500) {
                    Log.e("UnifiedInbox", "HTTP 500 - Server Internal Error");
                    Log.e("UnifiedInbox", "This suggests a problem in the FCMService::registerToken() method");
                    Log.e("UnifiedInbox", "Check server logs for PHP errors and database issues");
                }
                Toast.makeText(unifiedInboxActivity, "❌ Server error - contact support (Code: " + response.code() + ")", 1).show();
                return;
        }
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) throws RemoteException {
        N1.k kVar = (N1.k) obj2;
        switch (this.f1595c) {
            case 2:
                Z2.c cVar = new Z2.c(kVar);
                ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) this.f1596d;
                E.j(activityTransitionRequest, "activityTransitionRequest must be specified.");
                PendingIntent pendingIntent = (PendingIntent) this.f1597e;
                E.j(pendingIntent, "PendingIntent must be specified.");
                BinderC0008f binderC0008f = new BinderC0008f(cVar);
                a0 a0Var = (a0) ((U) obj).t();
                Parcel parcelZza = a0Var.zza();
                AbstractC0019q.b(parcelZza, activityTransitionRequest);
                AbstractC0019q.b(parcelZza, pendingIntent);
                parcelZza.writeStrongBinder(binderC0008f);
                a0Var.zzc(72, parcelZza);
                break;
            case 3:
                ((D) obj).C((androidx.emoji2.text.e) this.f1596d, (DeviceOrientationRequest) this.f1597e, kVar);
                break;
            default:
                ((D) obj).J((C0016n) this.f1596d, (LocationRequest) this.f1597e, kVar);
                break;
        }
    }

    public void q(int i5, int i6) {
        int[] iArr = (int[]) this.f1596d;
        if (iArr == null || i5 >= iArr.length) {
            return;
        }
        int i7 = i5 + i6;
        d(i7);
        int[] iArr2 = (int[]) this.f1596d;
        System.arraycopy(iArr2, i5, iArr2, i7, (iArr2.length - i5) - i6);
        Arrays.fill((int[]) this.f1596d, i5, i7, -1);
        List list = (List) this.f1597e;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            t0 t0Var = (t0) ((List) this.f1597e).get(size);
            int i8 = t0Var.f4332j;
            if (i8 >= i5) {
                t0Var.f4332j = i8 + i6;
            }
        }
    }

    public void r(int i5, int i6) {
        int[] iArr = (int[]) this.f1596d;
        if (iArr == null || i5 >= iArr.length) {
            return;
        }
        int i7 = i5 + i6;
        d(i7);
        int[] iArr2 = (int[]) this.f1596d;
        System.arraycopy(iArr2, i7, iArr2, i5, (iArr2.length - i5) - i6);
        int[] iArr3 = (int[]) this.f1596d;
        Arrays.fill(iArr3, iArr3.length - i6, iArr3.length, -1);
        List list = (List) this.f1597e;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            t0 t0Var = (t0) ((List) this.f1597e).get(size);
            int i8 = t0Var.f4332j;
            if (i8 >= i5) {
                if (i8 < i7) {
                    ((List) this.f1597e).remove(size);
                } else {
                    t0Var.f4332j = i8 - i6;
                }
            }
        }
    }

    public void s(Throwable th) throws JSONException {
        int i5 = 1;
        C0058c1 c0058c1 = (C0058c1) this.f1597e;
        c0058c1.j();
        c0058c1.f1167k = false;
        C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
        int i6 = 2;
        if (c0113v0.f1415i.w(null, H.f795Z0)) {
            String message = th.getMessage();
            c0058c1.f1171p = false;
            if (message != null) {
                if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                    if (message.contains("Background")) {
                        c0058c1.f1171p = true;
                    }
                    i6 = 1;
                } else if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    i6 = 3;
                }
            }
        }
        int i7 = i6 - 1;
        K1 k1 = (K1) this.f1596d;
        Z z4 = c0113v0.f1417k;
        if (i7 == 0) {
            C0113v0.k(z4);
            z4.f1080k.c(Z.q(c0113v0.n().q()), Z.q(th.toString()), "registerTriggerAsync failed with retriable error. Will try later. App ID, throwable");
            c0058c1.f1168l = 1;
            c0058c1.H().add(k1);
            return;
        }
        if (i7 != 1) {
            C0113v0.k(z4);
            z4.h.c(Z.q(c0113v0.n().q()), th, "registerTriggerAsync failed. Dropping URI. App ID, Throwable");
            E();
            c0058c1.f1168l = 1;
            c0058c1.x();
            return;
        }
        c0058c1.H().add(k1);
        if (c0058c1.f1168l > ((Integer) H.v0.a(null)).intValue()) {
            c0058c1.f1168l = 1;
            C0113v0.k(z4);
            z4.f1080k.c(Z.q(c0113v0.n().q()), Z.q(th.toString()), "registerTriggerAsync failed. May try later. App ID, throwable");
            return;
        }
        C0113v0.k(z4);
        z4.f1080k.d("registerTriggerAsync failed. App ID, delay in seconds, throwable", Z.q(c0113v0.n().q()), Z.q(String.valueOf(c0058c1.f1168l)), Z.q(th.toString()));
        int i8 = c0058c1.f1168l;
        if (c0058c1.f1169m == null) {
            c0058c1.f1169m = new U0(c0058c1, c0113v0, i5);
        }
        c0058c1.f1169m.c(i8 * 1000);
        int i9 = c0058c1.f1168l;
        c0058c1.f1168l = i9 + i9;
    }

    public void t(L.f fVar) {
        int i5 = fVar.f1516b;
        Handler handler = (Handler) this.f1597e;
        Z2.c cVar = (Z2.c) this.f1596d;
        if (i5 != 0) {
            handler.post(new B0.r(i5, 2, cVar));
        } else {
            handler.post(new RunnableC0999a(cVar, 22, fVar.f1515a));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x022b, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(android.content.Context r12, android.content.res.XmlResourceParser r13) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L0.s.u(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public S2.b w() throws IOException {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        try {
            FileInputStream fileInputStream = new FileInputStream(h());
            while (true) {
                try {
                    int i5 = fileInputStream.read(bArr, 0, Http2.INITIAL_MAX_FRAME_SIZE);
                    if (i5 < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i5);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString("Fid", null);
        int iOptInt = jSONObject.optInt("Status", 0);
        String strOptString2 = jSONObject.optString("AuthToken", null);
        String strOptString3 = jSONObject.optString("RefreshToken", null);
        long jOptLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long jOptLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        String strOptString4 = jSONObject.optString("FisError", null);
        int[] iArr = new int[5];
        System.arraycopy(AbstractC0882e.f9558a, 0, iArr, 0, 5);
        int i6 = iArr[iOptInt];
        if (i6 == 0) {
            throw new NullPointerException("Null registrationStatus");
        }
        Long lValueOf = Long.valueOf(jOptLong);
        Long lValueOf2 = Long.valueOf(jOptLong2);
        String str = i6 == 0 ? " registrationStatus" : "";
        if (str.isEmpty()) {
            return new S2.b(strOptString, i6, strOptString2, strOptString3, lValueOf2.longValue(), lValueOf.longValue(), strOptString4);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public void x() throws InterruptedException {
        try {
            Log.d("Unified - ProgrammingThread", "=== REQUESTING VERSION NUMBER ===");
            HandlerThreadC0775k handlerThreadC0775kA = HandlerThreadC0775k.a();
            if (!handlerThreadC0775kA.isAlive()) {
                Log.d("Unified - ProgrammingThread", "Starting DmrContext thread");
                handlerThreadC0775kA.start();
                Thread.sleep(500L);
            }
            String strA = new w("34", "01").a();
            Log.d("Unified - ProgrammingThread", "Version command: " + strA);
            handlerThreadC0775kA.h("34", new v() { // from class: n3.b
                @Override // m3.v
                public final void a(w wVar) {
                    String string;
                    String strTrim;
                    int i5;
                    s sVar = this.f8883a;
                    sVar.getClass();
                    String str = (String) wVar.g;
                    if (str == null || str.isEmpty()) {
                        return;
                    }
                    try {
                        if (str.length() < 10) {
                            string = "Response too short: ".concat(str);
                        } else {
                            Log.d("Unified - ProgrammingThread", "Parsing hex data: ".concat(str));
                            if (str.contains("444D52")) {
                                int iIndexOf = str.indexOf("444D52");
                                int length = iIndexOf + 60;
                                if (str.contains("0010")) {
                                    length = str.indexOf("0010", iIndexOf);
                                }
                                if (length > str.length()) {
                                    length = str.length();
                                }
                                String strSubstring = str.substring(iIndexOf, length);
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    for (int i6 = 0; i6 < strSubstring.length(); i6 += 2) {
                                        if (i6 + 1 < strSubstring.length() && (i5 = Integer.parseInt(strSubstring.substring(i6, i6 + 2), 16)) >= 32 && i5 <= 126) {
                                            sb.append((char) i5);
                                        }
                                    }
                                    strTrim = sb.toString().trim();
                                } catch (Exception unused) {
                                    strTrim = strSubstring;
                                }
                                Log.d("Unified - ProgrammingThread", "Version hex: " + strSubstring);
                                Log.d("Unified - ProgrammingThread", "Version string: " + strTrim);
                                string = strTrim;
                            } else {
                                string = "Raw: ".concat(str);
                            }
                        }
                    } catch (Exception e5) {
                        StringBuilder sbG = h.g("Unified - ProgrammingThread", "Error parsing version", e5, "Parse error: ");
                        sbG.append(e5.getMessage());
                        string = sbG.toString();
                    }
                    c.C((Context) sVar.f1597e).edit().putString("rf_version", string).apply();
                    Log.d("SharedSettings", "RF Version saved: " + string);
                    Log.i("Unified - ProgrammingThread", "RF Version saved to SharedSettings: " + string);
                }
            });
            Log.d("Unified - ProgrammingThread", "Version command sent: " + handlerThreadC0775kA.g(strA));
        } catch (Exception e5) {
            Log.e("Unified - ProgrammingThread", "Error requesting version", e5);
        }
    }

    public void y() throws InterruptedException {
        Context context = (Context) this.f1597e;
        f.n(context);
        if (((C0774j) this.f1596d) == null) {
            Log.e("Unified - AnalogProgramming", "DmrBusiness instance is null");
            return;
        }
        x();
        Log.i("Unified - AnalogProgramming", "Starting Analog Programming sequence");
        try {
            long jA = h4.c.A(context);
            long jE = h4.c.E(context);
            int i5 = h4.c.C(context).getInt("band", 1);
            int i6 = h4.c.C(context).getInt("power", 1);
            int i7 = h4.c.C(context).getInt("squelch", 1);
            int i8 = h4.c.C(context).getInt("rx_type", 0);
            int i9 = h4.c.C(context).getInt("rx_subcode", 0);
            int i10 = h4.c.C(context).getInt("tx_type", 0);
            int i11 = h4.c.C(context).getInt("tx_subcode", 0);
            int i12 = h4.c.C(context).getInt("power_save", 2);
            int i13 = h4.c.C(context).getInt("volume", 1);
            int i14 = h4.c.C(context).getInt("monitor", 2);
            int i15 = h4.c.C(context).getInt("relay", 2);
            try {
                int i16 = h4.c.C(context).getInt("mic_gain", 3);
                Log.d("Unified - AnalogProgramming", String.format("Settings loaded - RX: %d, TX: %d", Long.valueOf(jA), Long.valueOf(jE)));
                Log.d("Unified - AnalogProgramming", String.format("Band: %d, Power: %d, Squelch: %d", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)));
                Log.d("Unified - AnalogProgramming", String.format("RX Type: %d, RX Subcode: %d", Integer.valueOf(i8), Integer.valueOf(i9)));
                Log.d("Unified - AnalogProgramming", String.format("TX Type: %d, TX Subcode: %d", Integer.valueOf(i10), Integer.valueOf(i11)));
                Log.d("Unified - AnalogProgramming", String.format("Power Save: %d, Volume: %d", Integer.valueOf(i12), Integer.valueOf(i13)));
                Log.d("Unified - AnalogProgramming", String.format("Monitor: %d, Relay: %d", Integer.valueOf(i14), Integer.valueOf(i15)));
                context = context;
                C0765a c0765a = new C0765a(context);
                c0765a.f8567b = (int) jA;
                c0765a.f8568c = (int) jE;
                c0765a.f8569d = i5;
                c0765a.f8570e = i6;
                c0765a.f8571f = i7;
                c0765a.g = i8;
                c0765a.h = i9;
                c0765a.f8572i = i10;
                c0765a.f8573j = i11;
                c0765a.f8574k = i12;
                c0765a.f8575l = 8;
                c0765a.f8576m = i14;
                c0765a.n = i15;
                C0765a c0765aA = c0765a.a();
                Log.i("Unified - AnalogProgramming", "Built AnalogInfo object, sending to radio...");
                C0774j.d(c0765aA, new C0805a(0));
                C0774j.f(i16, new C0805a(1));
                Thread.sleep(100L);
                Log.d("Unified - AnalogProgramming", "Setting volume to 5");
                C0774j.c(new w("2E", AbstractC0869a.a(8, 2)).a(), new C0805a(2));
                f.i(context);
            } catch (Exception e5) {
                e = e5;
                context = context;
                StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("Unified - AnalogProgramming", "Error in analog programming sequence", e, "Stack trace: ");
                sbG.append(Log.getStackTraceString(e));
                Log.e("Unified - AnalogProgramming", sbG.toString());
                f.i(context);
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public void z() throws InterruptedException {
        Context context = (Context) this.f1597e;
        f.n(context);
        try {
            Thread.sleep(10L);
            Log.d("DMR009 - AnalogProgramming", String.format("Settings loaded - RX: %d, TX: %d", Long.valueOf(h4.c.A(context)), Long.valueOf(h4.c.E(context))));
            byte[] bArr = new byte[28];
            int i5 = 0;
            bArr[0] = 104;
            bArr[1] = 35;
            bArr[2] = 1;
            bArr[3] = 1;
            bArr[6] = 0;
            bArr[7] = 19;
            bArr[8] = -64;
            bArr[9] = -73;
            bArr[10] = -69;
            bArr[11] = 8;
            bArr[12] = -64;
            bArr[13] = -73;
            bArr[14] = -69;
            bArr[15] = 8;
            bArr[16] = 1;
            bArr[17] = 1;
            bArr[18] = 1;
            bArr[19] = 0;
            bArr[20] = 0;
            bArr[21] = 0;
            bArr[22] = 0;
            bArr[23] = 2;
            bArr[24] = 8;
            bArr[25] = 2;
            bArr[26] = 2;
            bArr[27] = 16;
            for (int i6 = 1; i6 < 4; i6++) {
                i5 += bArr[i6] & 255;
            }
            for (int i7 = 6; i7 < 27; i7++) {
                i5 += bArr[i7] & 255;
            }
            int i8 = (~i5) + 1;
            bArr[4] = (byte) ((i8 >> 8) & 255);
            bArr[5] = (byte) (i8 & 255);
            String strB = AbstractC0869a.b(bArr);
            Log.d("DMR009 - AnalogProgramming", "Generated command: " + strB);
            if (HandlerThreadC0775k.a().g(strB)) {
                Log.d("DMR009 - AnalogProgramming", "Successfully sent analog settings");
                Thread.sleep(100L);
                C();
            } else {
                Log.e("DMR009 - AnalogProgramming", "Failed to send analog settings");
            }
            f.i(context);
        } catch (Exception e5) {
            StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("DMR009 - AnalogProgramming", "Error in DMR009 analog programming sequence", e5, "Stack trace: ");
            sbG.append(Log.getStackTraceString(e5));
            Log.e("DMR009 - AnalogProgramming", sbG.toString());
            f.i(context);
        }
    }

    @Override // D1.A
    public void zzc() {
        ((N1.k) this.f1597e).c(null);
    }

    public /* synthetic */ s(int i5, boolean z4) {
        this.f1595c = i5;
    }

    public /* synthetic */ s(Object obj, int i5, Object obj2) {
        this.f1595c = i5;
        this.f1596d = obj;
        this.f1597e = obj2;
    }

    public s(AbstractC0737m abstractC0737m) {
        this.f1595c = 0;
        this.f1596d = abstractC0737m;
        this.f1597e = new b(abstractC0737m, 6);
        new h(abstractC0737m, 19);
    }

    public s(int i5) {
        this.f1595c = i5;
        switch (i5) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                this.f1596d = new HashMap();
                this.f1597e = new C0387t(6);
                C0387t c0387t = new C0387t(0);
                ArrayList arrayList = c0387t.f5035a;
                arrayList.add(EnumC0402w.BITWISE_AND);
                arrayList.add(EnumC0402w.BITWISE_LEFT_SHIFT);
                arrayList.add(EnumC0402w.BITWISE_NOT);
                arrayList.add(EnumC0402w.BITWISE_OR);
                arrayList.add(EnumC0402w.BITWISE_RIGHT_SHIFT);
                arrayList.add(EnumC0402w.BITWISE_UNSIGNED_RIGHT_SHIFT);
                arrayList.add(EnumC0402w.BITWISE_XOR);
                F(c0387t);
                C0387t c0387t2 = new C0387t(1);
                ArrayList arrayList2 = c0387t2.f5035a;
                arrayList2.add(EnumC0402w.EQUALS);
                arrayList2.add(EnumC0402w.GREATER_THAN);
                arrayList2.add(EnumC0402w.GREATER_THAN_EQUALS);
                arrayList2.add(EnumC0402w.IDENTITY_EQUALS);
                arrayList2.add(EnumC0402w.IDENTITY_NOT_EQUALS);
                arrayList2.add(EnumC0402w.LESS_THAN);
                arrayList2.add(EnumC0402w.LESS_THAN_EQUALS);
                arrayList2.add(EnumC0402w.NOT_EQUALS);
                F(c0387t2);
                C0387t c0387t3 = new C0387t(2);
                ArrayList arrayList3 = c0387t3.f5035a;
                arrayList3.add(EnumC0402w.APPLY);
                arrayList3.add(EnumC0402w.BLOCK);
                arrayList3.add(EnumC0402w.BREAK);
                arrayList3.add(EnumC0402w.CASE);
                arrayList3.add(EnumC0402w.DEFAULT);
                arrayList3.add(EnumC0402w.CONTINUE);
                arrayList3.add(EnumC0402w.DEFINE_FUNCTION);
                arrayList3.add(EnumC0402w.FN);
                arrayList3.add(EnumC0402w.IF);
                arrayList3.add(EnumC0402w.QUOTE);
                arrayList3.add(EnumC0402w.RETURN);
                arrayList3.add(EnumC0402w.SWITCH);
                arrayList3.add(EnumC0402w.TERNARY);
                F(c0387t3);
                C0387t c0387t4 = new C0387t(3);
                ArrayList arrayList4 = c0387t4.f5035a;
                arrayList4.add(EnumC0402w.AND);
                arrayList4.add(EnumC0402w.NOT);
                arrayList4.add(EnumC0402w.OR);
                F(c0387t4);
                C0387t c0387t5 = new C0387t(4);
                ArrayList arrayList5 = c0387t5.f5035a;
                arrayList5.add(EnumC0402w.FOR_IN);
                arrayList5.add(EnumC0402w.FOR_IN_CONST);
                arrayList5.add(EnumC0402w.FOR_IN_LET);
                arrayList5.add(EnumC0402w.FOR_LET);
                arrayList5.add(EnumC0402w.FOR_OF);
                arrayList5.add(EnumC0402w.FOR_OF_CONST);
                arrayList5.add(EnumC0402w.FOR_OF_LET);
                arrayList5.add(EnumC0402w.WHILE);
                F(c0387t5);
                C0387t c0387t6 = new C0387t(5);
                ArrayList arrayList6 = c0387t6.f5035a;
                arrayList6.add(EnumC0402w.ADD);
                arrayList6.add(EnumC0402w.DIVIDE);
                arrayList6.add(EnumC0402w.MODULUS);
                arrayList6.add(EnumC0402w.MULTIPLY);
                arrayList6.add(EnumC0402w.NEGATE);
                arrayList6.add(EnumC0402w.POST_DECREMENT);
                arrayList6.add(EnumC0402w.POST_INCREMENT);
                arrayList6.add(EnumC0402w.PRE_DECREMENT);
                arrayList6.add(EnumC0402w.PRE_INCREMENT);
                arrayList6.add(EnumC0402w.SUBTRACT);
                F(c0387t6);
                C0387t c0387t7 = new C0387t(7);
                ArrayList arrayList7 = c0387t7.f5035a;
                arrayList7.add(EnumC0402w.ASSIGN);
                arrayList7.add(EnumC0402w.CONST);
                arrayList7.add(EnumC0402w.CREATE_ARRAY);
                arrayList7.add(EnumC0402w.CREATE_OBJECT);
                arrayList7.add(EnumC0402w.EXPRESSION_LIST);
                arrayList7.add(EnumC0402w.GET);
                arrayList7.add(EnumC0402w.GET_INDEX);
                arrayList7.add(EnumC0402w.GET_PROPERTY);
                arrayList7.add(EnumC0402w.NULL);
                arrayList7.add(EnumC0402w.SET_PROPERTY);
                arrayList7.add(EnumC0402w.TYPEOF);
                arrayList7.add(EnumC0402w.UNDEFINED);
                arrayList7.add(EnumC0402w.VAR);
                F(c0387t7);
                break;
            case o1.f.INTERRUPTED /* 14 */:
                this.f1596d = new ThreadLocal();
                this.f1597e = new ArrayList();
                break;
            case 23:
                C0788e c0788e = C0788e.f8738d;
                this.f1596d = new SparseIntArray();
                this.f1597e = c0788e;
                break;
            default:
                this.f1596d = new B();
                this.f1597e = new N0.k();
                o(z.f181b);
                break;
        }
    }

    public s(A2.g gVar) {
        this.f1595c = 9;
        this.f1597e = gVar;
    }

    public s(Context context) {
        this.f1595c = 10;
        this.f1597e = null;
        this.f1596d = context;
    }

    public s(l4.f fVar) {
        this.f1595c = 19;
        this.f1597e = fVar;
        this.f1596d = new LinkedList();
    }
}
