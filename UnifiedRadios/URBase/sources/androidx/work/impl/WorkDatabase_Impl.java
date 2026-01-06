package androidx.work.impl;

import D0.d;
import D0.t;
import L0.b;
import L0.c;
import L0.e;
import L0.f;
import L0.h;
import L0.i;
import L0.l;
import L0.m;
import L0.q;
import L0.s;
import android.content.Context;
import androidx.recyclerview.widget.C0258e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l0.AbstractC0737m;
import l0.C0726b;
import l0.C0733i;
import p0.C0818a;

/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: k, reason: collision with root package name */
    public volatile q f4484k;

    /* renamed from: l, reason: collision with root package name */
    public volatile c f4485l;

    /* renamed from: m, reason: collision with root package name */
    public volatile s f4486m;
    public volatile i n;

    /* renamed from: o, reason: collision with root package name */
    public volatile l f4487o;

    /* renamed from: p, reason: collision with root package name */
    public volatile m f4488p;

    /* renamed from: q, reason: collision with root package name */
    public volatile e f4489q;

    @Override // l0.AbstractC0737m
    public final C0733i e() {
        return new C0733i(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // l0.AbstractC0737m
    public final p0.c f(C0726b c0726b) {
        C0258e c0258e = new C0258e(c0726b, new t(this), "7d73d21f1bd82c9e5268b6dcf9fde2cb", "3071c8717539de5d5353f4c8cd59a032");
        Context context = c0726b.f8325a;
        F3.i.f(context, "context");
        return c0726b.f8327c.f(new C0818a(context, c0726b.f8326b, c0258e, false, false));
    }

    @Override // l0.AbstractC0737m
    public final List g(LinkedHashMap linkedHashMap) {
        return Arrays.asList(new d(13, 14, 10), new D0.s(0), new d(16, 17, 11), new d(17, 18, 12), new d(18, 19, 13), new D0.s(1));
    }

    @Override // l0.AbstractC0737m
    public final Set i() {
        return new HashSet();
    }

    @Override // l0.AbstractC0737m
    public final Map j() {
        HashMap map = new HashMap();
        map.put(q.class, Collections.emptyList());
        map.put(c.class, Collections.emptyList());
        map.put(s.class, Collections.emptyList());
        map.put(i.class, Collections.emptyList());
        map.put(l.class, Collections.emptyList());
        map.put(m.class, Collections.emptyList());
        map.put(e.class, Collections.emptyList());
        map.put(f.class, Collections.emptyList());
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final c q() {
        c cVar;
        if (this.f4485l != null) {
            return this.f4485l;
        }
        synchronized (this) {
            try {
                if (this.f4485l == null) {
                    this.f4485l = new c((AbstractC0737m) this);
                }
                cVar = this.f4485l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final e r() {
        e eVar;
        if (this.f4489q != null) {
            return this.f4489q;
        }
        synchronized (this) {
            try {
                if (this.f4489q == null) {
                    this.f4489q = new e(this);
                }
                eVar = this.f4489q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final i s() {
        i iVar;
        if (this.n != null) {
            return this.n;
        }
        synchronized (this) {
            try {
                if (this.n == null) {
                    i iVar2 = new i();
                    iVar2.f1547c = this;
                    iVar2.f1548d = new b(this, 2);
                    iVar2.f1549e = new h(this, 0);
                    iVar2.f1550f = new h(this, 1);
                    this.n = iVar2;
                }
                iVar = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final l t() {
        l lVar;
        if (this.f4487o != null) {
            return this.f4487o;
        }
        synchronized (this) {
            try {
                if (this.f4487o == null) {
                    this.f4487o = new l((AbstractC0737m) this);
                }
                lVar = this.f4487o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final m u() {
        m mVar;
        if (this.f4488p != null) {
            return this.f4488p;
        }
        synchronized (this) {
            try {
                if (this.f4488p == null) {
                    this.f4488p = new m(this);
                }
                mVar = this.f4488p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final q v() {
        q qVar;
        if (this.f4484k != null) {
            return this.f4484k;
        }
        synchronized (this) {
            try {
                if (this.f4484k == null) {
                    this.f4484k = new q(this);
                }
                qVar = this.f4484k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final s w() {
        s sVar;
        if (this.f4486m != null) {
            return this.f4486m;
        }
        synchronized (this) {
            try {
                if (this.f4486m == null) {
                    this.f4486m = new s(this);
                }
                sVar = this.f4486m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }
}
