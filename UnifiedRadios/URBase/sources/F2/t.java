package F2;

import C0.A;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import d1.C0426a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import m3.C0777m;

/* loaded from: classes.dex */
public final class t implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f580a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f581b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f582c;

    /* renamed from: d, reason: collision with root package name */
    public Object f583d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f584e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f585f;

    public t(Y0.i iVar, V0.c cVar, A2.i iVar2, Y0.q qVar) {
        this.f580a = 3;
        this.f581b = iVar;
        this.f582c = "FCM_CLIENT_EVENT_LOGGING";
        this.f583d = cVar;
        this.f584e = iVar2;
        this.f585f = qVar;
    }

    public static t g(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        t tVar = new t(sharedPreferences, scheduledThreadPoolExecutor);
        synchronized (((ArrayDeque) tVar.f584e)) {
            try {
                ((ArrayDeque) tVar.f584e).clear();
                String string = ((SharedPreferences) tVar.f581b).getString((String) tVar.f582c, "");
                if (!TextUtils.isEmpty(string) && string.contains((String) tVar.f583d)) {
                    String[] strArrSplit = string.split((String) tVar.f583d, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            ((ArrayDeque) tVar.f584e).add(str);
                        }
                    }
                }
            } finally {
            }
        }
        return tVar;
    }

    @Override // F2.c
    public Object a(Class cls) {
        if (!((Set) this.f581b).contains(r.a(cls))) {
            throw new F1.b("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object objA = ((c) this.f585f).a(cls);
        if (!cls.equals(N2.b.class)) {
            return objA;
        }
        return new s();
    }

    @Override // F2.c
    public Set b(r rVar) {
        if (((Set) this.f583d).contains(rVar)) {
            return ((c) this.f585f).b(rVar);
        }
        throw new F1.b("Attempting to request an undeclared dependency Set<" + rVar + ">.");
    }

    @Override // F2.c
    public Object c(r rVar) {
        if (((Set) this.f581b).contains(rVar)) {
            return ((c) this.f585f).c(rVar);
        }
        throw new F1.b("Attempting to request an undeclared dependency " + rVar + ".");
    }

    @Override // F2.c
    public Q2.a d(r rVar) {
        if (((Set) this.f582c).contains(rVar)) {
            return ((c) this.f585f).d(rVar);
        }
        throw new F1.b("Attempting to request an undeclared dependency Provider<" + rVar + ">.");
    }

    @Override // F2.c
    public Q2.a e(Class cls) {
        return d(r.a(cls));
    }

    @Override // F2.c
    public Q2.a f(r rVar) {
        if (((Set) this.f584e).contains(rVar)) {
            return ((c) this.f585f).f(rVar);
        }
        throw new F1.b("Attempting to request an undeclared dependency Provider<Set<" + rVar + ">>.");
    }

    public void h(V0.a aVar) {
        A2.i iVar = new A2.i(15);
        Y0.i iVar2 = (Y0.i) this.f581b;
        if (iVar2 == null) {
            throw new NullPointerException("Null transportContext");
        }
        String str = (String) this.f582c;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        if (((A2.i) this.f584e) == null) {
            throw new NullPointerException("Null transformer");
        }
        V0.c cVar = (V0.c) this.f583d;
        if (cVar == null) {
            throw new NullPointerException("Null encoding");
        }
        Y0.q qVar = (Y0.q) this.f585f;
        qVar.getClass();
        V0.d dVar = V0.d.f2512j;
        L0.m mVarA = Y0.i.a();
        mVarA.o(iVar2.f2912a);
        mVarA.f1558f = dVar;
        mVarA.f1557e = iVar2.f2913b;
        Y0.i iVarD = mVarA.d();
        X2.n nVar = new X2.n();
        nVar.f2823f = new HashMap();
        nVar.f2821d = Long.valueOf(qVar.f2929a.a());
        nVar.f2822e = Long.valueOf(qVar.f2930b.a());
        nVar.f2818a = str;
        Y2.e eVar = (Y2.e) aVar.f2508a;
        eVar.getClass();
        C0777m c0777m = X2.p.f2827a;
        c0777m.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c0777m.c(eVar, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        nVar.f2820c = new Y0.m(cVar, byteArrayOutputStream.toByteArray());
        nVar.f2819b = null;
        Y0.h hVarD = nVar.d();
        C0426a c0426a = (C0426a) qVar.f2931c;
        c0426a.getClass();
        c0426a.f6103b.execute(new D0.l(c0426a, iVarD, iVar, hVarD, 1));
    }

    public String toString() {
        switch (this.f580a) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f581b) + ", mProviderPackage: " + ((String) this.f582c) + ", mQuery: " + ((String) this.f583d) + ", mCertificates:");
                int i5 = 0;
                while (true) {
                    List list = (List) this.f584e;
                    if (i5 >= list.size()) {
                        sb.append("}mCertificatesArray: 0");
                        return sb.toString();
                    }
                    sb.append(" [");
                    List list2 = (List) list.get(i5);
                    for (int i6 = 0; i6 < list2.size(); i6++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i6), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                    i5++;
                }
            default:
                return super.toString();
        }
    }

    public t(b bVar, c cVar) {
        this.f580a = 0;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (j jVar : bVar.f545c) {
            int i5 = jVar.f565c;
            boolean z4 = i5 == 0;
            int i6 = jVar.f564b;
            r rVar = jVar.f563a;
            if (z4) {
                if (i6 == 2) {
                    hashSet4.add(rVar);
                } else {
                    hashSet.add(rVar);
                }
            } else if (i5 == 2) {
                hashSet3.add(rVar);
            } else if (i6 == 2) {
                hashSet5.add(rVar);
            } else {
                hashSet2.add(rVar);
            }
        }
        if (!bVar.g.isEmpty()) {
            hashSet.add(r.a(N2.b.class));
        }
        this.f581b = Collections.unmodifiableSet(hashSet);
        this.f582c = Collections.unmodifiableSet(hashSet2);
        Collections.unmodifiableSet(hashSet3);
        this.f583d = Collections.unmodifiableSet(hashSet4);
        this.f584e = Collections.unmodifiableSet(hashSet5);
        this.f585f = cVar;
    }

    public t(g4.b bVar) {
        this.f580a = 4;
        this.f581b = new ArrayList();
        this.f582c = new k4.j();
        this.f585f = new L0.e(new A(21, this));
        this.f584e = bVar;
    }

    public t(String str, String str2, String str3, List list) {
        this.f580a = 1;
        str.getClass();
        this.f581b = str;
        str2.getClass();
        this.f582c = str2;
        this.f583d = str3;
        list.getClass();
        this.f584e = list;
        this.f585f = str + "-" + str2 + "-" + str3;
    }

    public t(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f580a = 2;
        this.f584e = new ArrayDeque();
        this.f581b = sharedPreferences;
        this.f582c = "topic_operation_queue";
        this.f583d = ",";
        this.f585f = scheduledThreadPoolExecutor;
    }
}
