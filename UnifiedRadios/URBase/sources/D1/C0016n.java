package D1;

import J1.C0072h0;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* renamed from: D1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0016n implements p1.o, A {

    /* renamed from: c, reason: collision with root package name */
    public boolean f394c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f395d;

    /* renamed from: e, reason: collision with root package name */
    public Object f396e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f397f;

    public C0016n(C0017o c0017o, androidx.emoji2.text.e eVar, InterfaceC0015m interfaceC0015m) {
        this.f397f = c0017o;
        this.f394c = true;
        this.f396e = eVar;
        this.f395d = interfaceC0015m;
    }

    @Override // D1.A
    public synchronized androidx.emoji2.text.e a() {
        return (androidx.emoji2.text.e) this.f396e;
    }

    @Override // D1.A
    public synchronized void b(androidx.emoji2.text.e eVar) {
        androidx.emoji2.text.e eVar2 = (androidx.emoji2.text.e) this.f396e;
        if (eVar2 != eVar) {
            eVar2.a();
            this.f396e = eVar;
        }
    }

    public int[] c() {
        synchronized (this) {
            try {
                if (!this.f394c) {
                    return null;
                }
                long[] jArr = (long[]) this.f395d;
                int length = jArr.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    int i7 = i6 + 1;
                    int i8 = 1;
                    boolean z4 = jArr[i5] > 0;
                    boolean[] zArr = (boolean[]) this.f396e;
                    if (z4 != zArr[i6]) {
                        int[] iArr = (int[]) this.f397f;
                        if (!z4) {
                            i8 = 2;
                        }
                        iArr[i6] = i8;
                    } else {
                        ((int[]) this.f397f)[i6] = 0;
                    }
                    zArr[i6] = z4;
                    i5++;
                    i6 = i7;
                }
                this.f394c = false;
                return (int[]) ((int[]) this.f397f).clone();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void d() {
        try {
            if (this.f394c) {
                return;
            }
            Boolean boolF = f();
            this.f396e = boolF;
            if (boolF == null) {
                A2.i iVar = new A2.i(14);
                F2.l lVar = (F2.l) ((N2.c) this.f395d);
                lVar.a(lVar.f568c, iVar);
            }
            this.f394c = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean e() {
        boolean z4;
        boolean zBooleanValue;
        try {
            d();
            Boolean bool = (Boolean) this.f396e;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                A2.g gVar = ((FirebaseMessaging) this.f397f).f5543a;
                gVar.a();
                V2.a aVar = (V2.a) gVar.g.get();
                synchronized (aVar) {
                    z4 = aVar.f2534a;
                }
                zBooleanValue = z4;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public Boolean f() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        A2.g gVar = ((FirebaseMessaging) this.f397f).f5543a;
        gVar.a();
        Context context = gVar.f26a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String g() {
        if (!this.f394c) {
            this.f394c = true;
            this.f396e = ((C0072h0) this.f397f).p().getString((String) this.f395d, null);
        }
        return (String) this.f396e;
    }

    public void h(String str) {
        SharedPreferences.Editor editorEdit = ((C0072h0) this.f397f).p().edit();
        editorEdit.putString((String) this.f395d, str);
        editorEdit.apply();
        this.f396e = str;
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) {
        p1.l lVar;
        boolean z4;
        D d5 = (D) obj;
        N1.k kVar = (N1.k) obj2;
        synchronized (this) {
            lVar = (p1.l) ((androidx.emoji2.text.e) this.f396e).f3602c;
            z4 = this.f394c;
            ((androidx.emoji2.text.e) this.f396e).a();
        }
        if (lVar == null) {
            kVar.a(Boolean.FALSE);
        } else {
            ((InterfaceC0015m) this.f395d).d(d5, lVar, z4, kVar);
        }
    }

    @Override // D1.A
    public void zzc() {
        p1.l lVar;
        synchronized (this) {
            this.f394c = false;
            lVar = (p1.l) ((androidx.emoji2.text.e) this.f396e).f3602c;
        }
        if (lVar != null) {
            ((C0017o) this.f397f).c(lVar, 2441);
        }
    }

    public C0016n(C0072h0 c0072h0, String str) {
        this.f397f = c0072h0;
        q1.E.f(str);
        this.f395d = str;
    }

    public C0016n(JSONObject jSONObject, Q0.b bVar) {
        this.f394c = false;
        this.f395d = jSONObject;
        this.f396e = bVar;
        this.f397f = null;
    }

    public C0016n(Q0.l lVar) {
        this.f394c = false;
        this.f395d = null;
        this.f396e = null;
        this.f397f = lVar;
    }

    public C0016n(byte[] bArr, Map map, List list, boolean z4) {
        this.f395d = bArr;
        this.f396e = map;
        if (list == null) {
            this.f397f = null;
        } else {
            this.f397f = Collections.unmodifiableList(list);
        }
        this.f394c = z4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public C0016n(int i5, byte[] bArr, boolean z4, long j5, List list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Q0.f fVar = (Q0.f) it.next();
                treeMap.put(fVar.f2143a, fVar.f2144b);
            }
        }
        this(bArr, treeMap, list, z4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public C0016n(byte[] bArr, Map map) {
        ?? arrayList;
        if (map == null) {
            arrayList = 0;
        } else if (map.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new Q0.f((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(bArr, map, arrayList, false);
    }

    public C0016n(int i5) {
        this.f395d = new long[i5];
        this.f396e = new boolean[i5];
        this.f397f = new int[i5];
    }

    public C0016n(FirebaseMessaging firebaseMessaging, N2.c cVar) {
        this.f397f = firebaseMessaging;
        this.f395d = cVar;
    }
}
