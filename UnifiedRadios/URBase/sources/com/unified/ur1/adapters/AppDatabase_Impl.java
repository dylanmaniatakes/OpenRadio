package com.unified.ur1.adapters;

import D0.t;
import F3.i;
import L0.b;
import L0.p;
import android.content.Context;
import androidx.recyclerview.widget.C0258e;
import f3.C0513e;
import f3.C0519j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l0.C0726b;
import l0.C0733i;
import p0.C0818a;
import p0.c;

/* loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: k, reason: collision with root package name */
    public volatile C0513e f5662k;

    /* renamed from: l, reason: collision with root package name */
    public volatile C0519j f5663l;

    @Override // l0.AbstractC0737m
    public final C0733i e() {
        return new C0733i(this, new HashMap(0), new HashMap(0), "app_settings", "channel_memories");
    }

    @Override // l0.AbstractC0737m
    public final c f(C0726b c0726b) {
        C0258e c0258e = new C0258e(c0726b, new t(this, 1), "862991907bde1659f05d5d9c10a88ff5", "f3d6c20c5b68ccded88768be484a0a6a");
        Context context = c0726b.f8325a;
        i.f(context, "context");
        return c0726b.f8327c.f(new C0818a(context, c0726b.f8326b, c0258e, false, false));
    }

    @Override // l0.AbstractC0737m
    public final List g(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // l0.AbstractC0737m
    public final Set i() {
        return new HashSet();
    }

    @Override // l0.AbstractC0737m
    public final Map j() {
        HashMap map = new HashMap();
        map.put(C0513e.class, Collections.emptyList());
        map.put(C0519j.class, Collections.emptyList());
        return map;
    }

    @Override // com.unified.ur1.adapters.AppDatabase
    public final C0513e q() {
        C0513e c0513e;
        if (this.f5662k != null) {
            return this.f5662k;
        }
        synchronized (this) {
            try {
                if (this.f5662k == null) {
                    C0513e c0513e2 = new C0513e();
                    c0513e2.f6686c = this;
                    c0513e2.f6687d = new b(this, 7);
                    new p(this, 1);
                    c0513e2.f6688e = new p(this, 2);
                    this.f5662k = c0513e2;
                }
                c0513e = this.f5662k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0513e;
    }

    @Override // com.unified.ur1.adapters.AppDatabase
    public final C0519j r() {
        C0519j c0519j;
        if (this.f5663l != null) {
            return this.f5663l;
        }
        synchronized (this) {
            try {
                if (this.f5663l == null) {
                    this.f5663l = new C0519j(this);
                }
                c0519j = this.f5663l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0519j;
    }
}
