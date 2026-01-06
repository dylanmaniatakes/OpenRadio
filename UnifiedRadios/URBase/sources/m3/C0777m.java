package m3;

import J1.InterfaceC0064e1;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import com.unified.ur1.rfmodule.DmrDatabase;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import m1.C0761b;
import r3.InterfaceC0877a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import v.C0919b;

/* renamed from: m3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0777m implements InterfaceC0064e1, InterfaceC0877a, Callback, N1.e {

    /* renamed from: c, reason: collision with root package name */
    public Object f8620c;

    /* renamed from: d, reason: collision with root package name */
    public Object f8621d;

    /* renamed from: e, reason: collision with root package name */
    public Object f8622e;

    public C0777m(androidx.viewpager2.adapter.b bVar, Fragment fragment, FrameLayout frameLayout) {
        this.f8622e = bVar;
        this.f8620c = fragment;
        this.f8621d = frameLayout;
    }

    public static boolean b(Editable editable, KeyEvent keyEvent, boolean z4) {
        androidx.emoji2.text.s[] sVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (sVarArr = (androidx.emoji2.text.s[]) editable.getSpans(selectionStart, selectionEnd, androidx.emoji2.text.s.class)) != null && sVarArr.length > 0) {
            for (androidx.emoji2.text.s sVar : sVarArr) {
                int spanStart = editable.getSpanStart(sVar);
                int spanEnd = editable.getSpanEnd(sVar);
                if ((z4 && spanStart == selectionStart) || ((!z4 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static void g() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    @Override // J1.InterfaceC0064e1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r12, java.io.IOException r13, byte[] r14) {
        /*
            r11 = this;
            java.lang.Object r14 = r11.f8620c
            J1.c1 r14 = (J1.C0058c1) r14
            r14.j()
            java.lang.Object r0 = r11.f8622e
            J1.N1 r0 = (J1.N1) r0
            r1 = 200(0xc8, float:2.8E-43)
            if (r12 == r1) goto L18
            r1 = 204(0xcc, float:2.86E-43)
            if (r12 == r1) goto L18
            r1 = 304(0x130, float:4.26E-43)
            if (r12 != r1) goto L33
            r12 = r1
        L18:
            if (r13 != 0) goto L33
            java.lang.Object r12 = r14.f84c
            J1.v0 r12 = (J1.C0113v0) r12
            J1.Z r12 = r12.f1417k
            J1.C0113v0.k(r12)
            J1.X r12 = r12.f1084p
            long r1 = r0.f903j
            java.lang.Long r13 = java.lang.Long.valueOf(r1)
            java.lang.String r1 = "[sgtm] Upload succeeded for row_id"
            r12.b(r13, r1)
            J1.i1 r12 = J1.EnumC0076i1.SUCCESS
            goto L6f
        L33:
            java.lang.Object r1 = r14.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            J1.Z r1 = r1.f1417k
            J1.C0113v0.k(r1)
            J1.X r1 = r1.f1080k
            long r2 = r0.f903j
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            java.lang.String r4 = "[sgtm] Upload failed for row_id. response, exception"
            r1.d(r4, r2, r3, r13)
            J1.G r13 = J1.H.f849u
            r1 = 0
            java.lang.Object r13 = r13.a(r1)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r1 = ","
            java.lang.String[] r13 = r13.split(r1)
            java.util.List r13 = java.util.Arrays.asList(r13)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            boolean r12 = r13.contains(r12)
            if (r12 == 0) goto L6d
            J1.i1 r12 = J1.EnumC0076i1.BACKOFF
            goto L6f
        L6d:
            J1.i1 r12 = J1.EnumC0076i1.FAILURE
        L6f:
            java.lang.Object r13 = r11.f8621d
            java.util.concurrent.atomic.AtomicReference r13 = (java.util.concurrent.atomic.AtomicReference) r13
            java.lang.Object r1 = r14.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            J1.x1 r1 = r1.r()
            J1.d r8 = new J1.d
            long r9 = r0.f903j
            int r5 = r12.f1262j
            long r6 = r0.f907o
            r2 = r8
            r3 = r9
            r2.<init>(r3, r5, r6)
            r1.j()
            r1.k()
            r0 = 1
            J1.b2 r0 = r1.x(r0)
            F0.e r2 = new F0.e
            r3 = 6
            r2.<init>(r1, r0, r8, r3)
            r1.A(r2)
            java.lang.Object r14 = r14.f84c
            J1.v0 r14 = (J1.C0113v0) r14
            J1.Z r14 = r14.f1417k
            J1.C0113v0.k(r14)
            J1.X r14 = r14.f1084p
            java.lang.Long r0 = java.lang.Long.valueOf(r9)
            java.lang.String r1 = "[sgtm] Updated status for row_id"
            r14.c(r0, r12, r1)
            monitor-enter(r13)
            r13.set(r12)     // Catch: java.lang.Throwable -> Lb9
            r13.notifyAll()     // Catch: java.lang.Throwable -> Lb9
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lb9
            return
        Lb9:
            r12 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> Lb9
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.C0777m.a(int, java.io.IOException, byte[]):void");
    }

    public void c(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        Map map = (Map) this.f8620c;
        M2.f fVar = new M2.f(byteArrayOutputStream, map, (Map) this.f8621d, (J2.d) this.f8622e);
        J2.d dVar = (J2.d) map.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, fVar);
        } else {
            throw new J2.b("No encoder for " + obj.getClass());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0204  */
    /* JADX WARN: Type inference failed for: r0v114 */
    /* JADX WARN: Type inference failed for: r0v171 */
    /* JADX WARN: Type inference failed for: r0v172 */
    /* JADX WARN: Type inference failed for: r0v89, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d() throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 1409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.C0777m.d():boolean");
    }

    public boolean e(CharSequence charSequence, int i5, int i6, androidx.emoji2.text.l lVar) {
        if (lVar.f3619c == 0) {
            androidx.emoji2.text.g gVar = (androidx.emoji2.text.g) this.f8622e;
            X.a aVarC = lVar.c();
            int iA = aVarC.a(8);
            if (iA != 0) {
                ((ByteBuffer) aVarC.f1892d).getShort(iA + aVarC.f1889a);
            }
            androidx.emoji2.text.c cVar = (androidx.emoji2.text.c) gVar;
            cVar.getClass();
            ThreadLocal threadLocal = androidx.emoji2.text.c.f3597b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i5 < i6) {
                sb.append(charSequence.charAt(i5));
                i5++;
            }
            TextPaint textPaint = cVar.f3598a;
            String string = sb.toString();
            int i7 = E.e.f423a;
            lVar.f3619c = E.d.a(textPaint, string) ? 2 : 1;
        }
        return lVar.f3619c == 2;
    }

    public boolean f(int i5, u.d dVar, x.f fVar) {
        int[] iArr = dVar.f9793p0;
        int i6 = iArr[0];
        C0919b c0919b = (C0919b) this.f8621d;
        c0919b.f9965a = i6;
        c0919b.f9966b = iArr[1];
        c0919b.f9967c = dVar.q();
        c0919b.f9968d = dVar.k();
        c0919b.f9971i = false;
        c0919b.f9972j = i5;
        boolean z4 = c0919b.f9965a == 3;
        boolean z5 = c0919b.f9966b == 3;
        boolean z6 = z4 && dVar.f9761W > BitmapDescriptorFactory.HUE_RED;
        boolean z7 = z5 && dVar.f9761W > BitmapDescriptorFactory.HUE_RED;
        int[] iArr2 = dVar.f9797t;
        if (z6 && iArr2[0] == 4) {
            c0919b.f9965a = 1;
        }
        if (z7 && iArr2[1] == 4) {
            c0919b.f9966b = 1;
        }
        fVar.b(dVar, c0919b);
        dVar.O(c0919b.f9969e);
        dVar.L(c0919b.f9970f);
        dVar.f9744E = c0919b.h;
        dVar.I(c0919b.g);
        c0919b.f9972j = 0;
        return c0919b.f9971i;
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return new f1.l(((Integer) ((InterfaceC0877a) this.f8622e).get()).intValue(), (Context) ((InterfaceC0877a) this.f8620c).get(), (String) ((InterfaceC0877a) this.f8621d).get());
    }

    public void h(u.e eVar, int i5, int i6, int i7) {
        int i8 = eVar.f9768b0;
        int i9 = eVar.f9770c0;
        eVar.f9768b0 = 0;
        eVar.f9770c0 = 0;
        eVar.O(i6);
        eVar.L(i7);
        if (i8 < 0) {
            eVar.f9768b0 = 0;
        } else {
            eVar.f9768b0 = i8;
        }
        if (i9 < 0) {
            eVar.f9770c0 = 0;
        } else {
            eVar.f9770c0 = i9;
        }
        u.e eVar2 = (u.e) this.f8622e;
        eVar2.f9819t0 = i5;
        eVar2.U();
    }

    public void i(u.e eVar) {
        ArrayList arrayList = (ArrayList) this.f8620c;
        arrayList.clear();
        int size = eVar.f9816q0.size();
        for (int i5 = 0; i5 < size; i5++) {
            u.d dVar = (u.d) eVar.f9816q0.get(i5);
            int[] iArr = dVar.f9793p0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(dVar);
            }
        }
        eVar.f9818s0.f9976b = true;
    }

    @Override // N1.e
    public void k(N1.j jVar) {
        C0761b c0761b = (C0761b) this.f8620c;
        String str = (String) this.f8621d;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f8622e;
        synchronized (c0761b.f8513a) {
            c0761b.f8513a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        ChatActivity.j((ChatActivity) this.f8622e, (List) this.f8620c);
        Runnable runnable = (Runnable) this.f8621d;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        List<Message> arrayList = new ArrayList<>();
        if (response.isSuccessful() && response.body() != null && ((MessageResponse) response.body()).getMessages() != null) {
            arrayList = ((MessageResponse) response.body()).getMessages();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll((List) this.f8620c);
        arrayList2.addAll(arrayList);
        ChatActivity.j((ChatActivity) this.f8622e, arrayList2);
        Runnable runnable = (Runnable) this.f8621d;
        if (runnable != null) {
            runnable.run();
        }
    }

    public /* synthetic */ C0777m(Object obj, Serializable serializable, Object obj2) {
        this.f8620c = obj;
        this.f8621d = serializable;
        this.f8622e = obj2;
    }

    public C0777m(DmrDatabase dmrDatabase) {
        this.f8620c = dmrDatabase;
        new L0.b(dmrDatabase, 9);
        this.f8621d = new L0.p(dmrDatabase, 5);
        new L0.h(dmrDatabase, 20);
        new L0.h(dmrDatabase, 21);
        new L0.h(dmrDatabase, 22);
        this.f8622e = new L0.h(dmrDatabase, 23);
    }

    public C0777m(ChatActivity chatActivity, List list) {
        this.f8622e = chatActivity;
        this.f8620c = list;
        this.f8621d = null;
    }
}
