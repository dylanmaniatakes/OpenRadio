package i3;

import O.Y;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import e.AbstractC0429a;
import f.AbstractActivityC0472i;
import f3.C0524o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.AbstractC0636i0;
import k.W0;
import k3.RunnableC0677b0;
import k3.RunnableC0709s;
import n1.C0785b;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import w1.AbstractC0930a;
import y2.C0986e;

/* renamed from: i3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0573b implements Callback, okhttp3.Callback {

    /* renamed from: f, reason: collision with root package name */
    public static C0573b f7294f;

    /* renamed from: c, reason: collision with root package name */
    public int f7295c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7296d;

    /* renamed from: e, reason: collision with root package name */
    public Object f7297e;

    public /* synthetic */ C0573b(AbstractActivityC0472i abstractActivityC0472i, int i5, Object obj) {
        this.f7297e = abstractActivityC0472i;
        this.f7295c = i5;
        this.f7296d = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f1, code lost:
    
        if (r5 == 1) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01f3, code lost:
    
        if (r5 == 2) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f5, code lost:
    
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f7, code lost:
    
        r17 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01fa, code lost:
    
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01fd, code lost:
    
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0200, code lost:
    
        r1 = 0;
        r3 = new android.graphics.LinearGradient(r11, r27, r26, r25, (int[]) r0.f1541d, (float[]) r0.f1542e, r17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0217, code lost:
    
        r1 = 0;
        r3 = new android.graphics.SweepGradient(r22, r23, (int[]) r0.f1541d, (float[]) r0.f1542e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x022a, code lost:
    
        r9 = r22;
        r15 = r23;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0232, code lost:
    
        if (r24 <= com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0237, code lost:
    
        if (r5 == 1) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x023a, code lost:
    
        if (r5 == 2) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x023c, code lost:
    
        r2 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0241, code lost:
    
        r2 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0244, code lost:
    
        r2 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0247, code lost:
    
        r3 = new android.graphics.RadialGradient(r9, r15, r24, (int[]) r0.f1541d, (float[]) r0.f1542e, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0264, code lost:
    
        return new i3.C0573b(r3, (android.content.res.ColorStateList) null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x026c, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cf, code lost:
    
        if (r14.size() <= 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d1, code lost:
    
        r0 = new L0.e(r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d7, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d8, code lost:
    
        if (r0 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01dc, code lost:
    
        if (r19 == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01de, code lost:
    
        r0 = new L0.e(r6, r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e4, code lost:
    
        r0 = new L0.e(r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ea, code lost:
    
        if (r8 == 1) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ed, code lost:
    
        if (r8 == 2) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static i3.C0573b e(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.C0573b.e(android.content.res.Resources, int, android.content.res.Resources$Theme):i3.b");
    }

    public static void f(C0573b c0573b, Y3.a aVar) {
        int length = ((int[]) c0573b.f7297e).length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            ((int[]) c0573b.f7297e)[i6] = i5;
            Y3.d.f(c0573b.f7295c, (int[]) c0573b.f7296d, i5, aVar);
            i5 += 1080;
        }
    }

    public static synchronized C0573b g(Context context) {
        try {
            if (f7294f == null) {
                C0573b c0573b = new C0573b();
                c0573b.f7295c = 0;
                c0573b.f7297e = new ArrayList();
                context.getApplicationContext();
                SharedPreferences sharedPreferences = context.getSharedPreferences("badge_prefs", 0);
                c0573b.f7296d = sharedPreferences;
                c0573b.f7295c = sharedPreferences.getInt("unread_count", 0);
                f7294f = c0573b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7294f;
    }

    public void a(InterfaceC0572a interfaceC0572a) {
        ArrayList arrayList = (ArrayList) this.f7297e;
        if (arrayList.contains(interfaceC0572a)) {
            return;
        }
        arrayList.add(interfaceC0572a);
        int i5 = this.f7295c;
        LaunchActivity launchActivity = (LaunchActivity) interfaceC0572a;
        launchActivity.getClass();
        launchActivity.runOnUiThread(new RunnableC0709s(launchActivity, i5, 0));
    }

    public void b() {
        W0 w02;
        ImageView imageView = (ImageView) this.f7296d;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            AbstractC0636i0.a(drawable);
        }
        if (drawable == null || (w02 = (W0) this.f7297e) == null) {
            return;
        }
        k.r.e(drawable, w02, imageView.getDrawableState());
    }

    public T2.b c() {
        String str = ((Long) this.f7297e) == null ? " tokenExpirationTimestamp" : "";
        if (str.isEmpty()) {
            return new T2.b(this.f7295c, (String) this.f7296d, ((Long) this.f7297e).longValue());
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public y2.m d() {
        C0986e c0986e = (C0986e) this.f7297e;
        if (c0986e != null) {
            throw c0986e.a();
        }
        y2.m mVarA = y2.m.a(this.f7295c, (Object[]) this.f7296d, this);
        C0986e c0986e2 = (C0986e) this.f7297e;
        if (c0986e2 == null) {
            return mVarA;
        }
        throw c0986e2.a();
    }

    public boolean h() {
        ColorStateList colorStateList;
        return ((Shader) this.f7296d) == null && (colorStateList = (ColorStateList) this.f7297e) != null && colorStateList.isStateful();
    }

    public void i(AttributeSet attributeSet, int i5) {
        int resourceId;
        ImageView imageView = (ImageView) this.f7296d;
        Context context = imageView.getContext();
        int[] iArr = AbstractC0429a.f6120f;
        L0.m mVarK = L0.m.k(context, attributeSet, iArr, i5, 0);
        Y.j(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) mVarK.f1557e, i5);
        try {
            Drawable drawable = imageView.getDrawable();
            TypedArray typedArray = (TypedArray) mVarK.f1557e;
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = AbstractC0930a.k(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                AbstractC0636i0.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                S.f.c(imageView, mVarK.f(2));
            }
            if (typedArray.hasValue(3)) {
                S.f.d(imageView, AbstractC0636i0.b(typedArray.getInt(3, -1), null));
            }
            mVarK.n();
        } catch (Throwable th) {
            mVarK.n();
            throw th;
        }
    }

    public void j(Object obj, Object obj2) {
        int i5 = (this.f7295c + 1) * 2;
        Object[] objArr = (Object[]) this.f7296d;
        if (i5 > objArr.length) {
            this.f7296d = Arrays.copyOf(objArr, AbstractC0409x1.c(objArr.length, i5));
        }
        android.support.v4.media.session.b.c(obj, obj2);
        Object[] objArr2 = (Object[]) this.f7296d;
        int i6 = this.f7295c;
        int i7 = i6 * 2;
        objArr2[i7] = obj;
        objArr2[i7 + 1] = obj2;
        this.f7295c = i6 + 1;
    }

    public void k(Collection collection) {
        if (collection instanceof Collection) {
            int size = (collection.size() + this.f7295c) * 2;
            Object[] objArr = (Object[]) this.f7296d;
            if (size > objArr.length) {
                this.f7296d = Arrays.copyOf(objArr, AbstractC0409x1.c(objArr.length, size));
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j(entry.getKey(), entry.getValue());
        }
    }

    public void l(InterfaceC0572a interfaceC0572a) {
        ((ArrayList) this.f7297e).remove(interfaceC0572a);
    }

    public void m(int i5) {
        ImageView imageView = (ImageView) this.f7296d;
        if (i5 != 0) {
            Drawable drawableK = AbstractC0930a.k(imageView.getContext(), i5);
            if (drawableK != null) {
                AbstractC0636i0.a(drawableK);
            }
            imageView.setImageDrawable(drawableK);
        } else {
            imageView.setImageDrawable(null);
        }
        b();
    }

    public void n(TextView textView) {
        if (textView == null) {
            return;
        }
        int i5 = this.f7295c;
        if (i5 <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(String.valueOf(i5));
            textView.setVisibility(0);
        }
    }

    public void o(int i5) {
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = this.f7295c;
        this.f7295c = i5;
        ((SharedPreferences) this.f7296d).edit().putInt("unread_count", i5).putLong("last_update", System.currentTimeMillis()).apply();
        Log.d("BadgeManager", "Badge count updated: " + i6 + " -> " + i5);
        Iterator it = ((ArrayList) this.f7297e).iterator();
        while (it.hasNext()) {
            try {
                LaunchActivity launchActivity = (LaunchActivity) ((InterfaceC0572a) it.next());
                launchActivity.getClass();
                launchActivity.runOnUiThread(new RunnableC0709s(launchActivity, i5, 0));
            } catch (Exception e5) {
                Log.e("BadgeManager", "Error notifying badge listener", e5);
            }
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f7297e;
        unifiedInboxActivity.f5831c.setVisibility(8);
        C0524o c0524o = unifiedInboxActivity.g;
        if (c0524o != null) {
            c0524o.notifyItemChanged(this.f7295c);
        }
        Toast.makeText(unifiedInboxActivity, "Network error deleting message: " + th.getMessage(), 1).show();
        Log.e("UnifiedInbox", "Network error deleting message", th);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        String str;
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f7297e;
        unifiedInboxActivity.f5831c.setVisibility(8);
        boolean zIsSuccessful = response.isSuccessful();
        int i5 = this.f7295c;
        if (zIsSuccessful && response.body() != null) {
            C0524o c0524o = unifiedInboxActivity.g;
            if (c0524o != null) {
                if (i5 >= 0) {
                    List list = c0524o.f6769b;
                    if (i5 < list.size()) {
                        list.remove(i5);
                        c0524o.notifyItemRemoved(i5);
                        c0524o.notifyItemRangeChanged(i5, list.size());
                    }
                } else {
                    c0524o.getClass();
                }
            }
            unifiedInboxActivity.getClass();
            unifiedInboxActivity.u();
            Toast.makeText(unifiedInboxActivity, "Message deleted", 0).show();
            unifiedInboxActivity.m();
            Log.d("UnifiedInbox", "Message marked as deleted successfully: " + ((Message) this.f7296d).getId());
            return;
        }
        C0524o c0524o2 = unifiedInboxActivity.g;
        if (c0524o2 != null) {
            c0524o2.notifyItemChanged(i5);
        }
        if (response.errorBody() != null) {
            try {
                String strString = response.errorBody().string();
                Log.e("UnifiedInbox", "Delete error: " + strString);
                str = "Failed to delete message: " + strString;
            } catch (Exception e5) {
                Log.e("UnifiedInbox", "Error reading error body", e5);
            }
        } else {
            str = "Failed to delete message";
        }
        Toast.makeText(unifiedInboxActivity, str, 1).show();
        Log.e("UnifiedInbox", "Failed to delete message. Response code: " + response.code());
    }

    public void p(p1.q qVar) {
        Map map = (Map) this.f7296d;
        if (map.containsKey("ConnectionlessLifecycleHelper")) {
            throw new IllegalArgumentException("LifecycleCallback with tag ConnectionlessLifecycleHelper already added to this fragment.");
        }
        map.put("ConnectionlessLifecycleHelper", qVar);
        if (this.f7295c > 0) {
            new A1.f(Looper.getMainLooper(), 2).post(new F0.e(this, qVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x000c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(int r10, int r11, android.content.Intent r12) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f7296d
            java.util.Map r0 = (java.util.Map) r0
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        Lc:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L95
            java.lang.Object r1 = r0.next()
            p1.q r1 = (p1.q) r1
            java.util.concurrent.atomic.AtomicReference r2 = r1.f9132e
            java.lang.Object r2 = r2.get()
            p1.G r2 = (p1.G) r2
            r3 = 3
            r4 = 0
            p1.h r5 = r1.f9134i
            java.util.concurrent.atomic.AtomicReference r6 = r1.f9132e
            r7 = 1
            if (r10 == r7) goto L55
            r7 = 2
            if (r10 == r7) goto L2d
            goto L87
        L2d:
            android.app.Activity r7 = r1.a()
            int r8 = n1.C0789f.f8739a
            n1.e r1 = r1.g
            int r1 = r1.c(r7, r8)
            if (r1 != 0) goto L48
            r6.set(r4)
            A1.f r1 = r5.n
            android.os.Message r2 = r1.obtainMessage(r3)
            r1.sendMessage(r2)
            goto Lc
        L48:
            if (r2 == 0) goto Lc
            n1.b r3 = r2.f9099b
            int r3 = r3.f8728k
            r7 = 18
            if (r3 != r7) goto L87
            if (r1 != r7) goto L87
            goto Lc
        L55:
            r1 = -1
            if (r11 != r1) goto L65
            r6.set(r4)
            A1.f r1 = r5.n
            android.os.Message r2 = r1.obtainMessage(r3)
            r1.sendMessage(r2)
            goto Lc
        L65:
            if (r11 != 0) goto L87
            if (r2 == 0) goto Lc
            r1 = 13
            if (r12 == 0) goto L73
            java.lang.String r3 = "<<ResolutionFailureErrorDetail>>"
            int r1 = r12.getIntExtra(r3, r1)
        L73:
            n1.b r3 = new n1.b
            n1.b r8 = r2.f9099b
            java.lang.String r8 = r8.toString()
            r3.<init>(r7, r1, r4, r8)
            r6.set(r4)
            int r1 = r2.f9098a
            r5.h(r3, r1)
            goto Lc
        L87:
            if (r2 == 0) goto Lc
            r6.set(r4)
            n1.b r1 = r2.f9099b
            int r2 = r2.f9098a
            r5.h(r1, r2)
            goto Lc
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.C0573b.q(int, int, android.content.Intent):void");
    }

    public void r(Bundle bundle) {
        this.f7295c = 1;
        this.f7297e = bundle;
        for (Map.Entry entry : ((Map) this.f7296d).entrySet()) {
            ((p1.q) entry.getValue()).b(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public void s(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : ((Map) this.f7296d).entrySet()) {
            Bundle bundle2 = new Bundle();
            p1.G g = (p1.G) ((p1.q) entry.getValue()).f9132e.get();
            if (g != null) {
                bundle2.putBoolean("resolving_error", true);
                bundle2.putInt("failed_client_id", g.f9098a);
                C0785b c0785b = g.f9099b;
                bundle2.putInt("failed_status", c0785b.f8728k);
                bundle2.putParcelable("failed_resolution", c0785b.f8729l);
            }
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    public C0573b() {
        this.f7296d = Collections.synchronizedMap(new q.b());
        this.f7295c = 0;
    }

    public C0573b(ImageView imageView) {
        this.f7295c = 0;
        this.f7296d = imageView;
    }

    public C0573b(Shader shader, ColorStateList colorStateList, int i5) {
        this.f7296d = shader;
        this.f7297e = colorStateList;
        this.f7295c = i5;
    }

    @Override // okhttp3.Callback
    public void onFailure(okhttp3.Call call, IOException iOException) {
        StringBuilder sb = new StringBuilder("HTTP request failed for radioId: ");
        int i5 = this.f7295c;
        sb.append(i5);
        Log.e("Unified - Main Activity", sb.toString(), iOException);
        Log.e("Unified - Main Activity", "Error type: ".concat(iOException.getClass().getSimpleName()));
        Log.e("Unified - Main Activity", "Error message: " + iOException.getMessage());
        ((Handler) this.f7296d).post(new RunnableC0677b0(this, i5, 2));
    }

    public C0573b(int i5) {
        this.f7296d = new Object[i5 * 2];
        this.f7295c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x022e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[Catch: Exception -> 0x01e0, JSONException -> 0x01e2, SYNTHETIC, TRY_LEAVE, TryCatch #10 {JSONException -> 0x01e2, Exception -> 0x01e0, blocks: (B:27:0x01db, B:53:0x0237, B:52:0x0234, B:48:0x022e), top: B:71:0x0069, inners: #2 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // okhttp3.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResponse(okhttp3.Call r35, okhttp3.Response r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.C0573b.onResponse(okhttp3.Call, okhttp3.Response):void");
    }
}
