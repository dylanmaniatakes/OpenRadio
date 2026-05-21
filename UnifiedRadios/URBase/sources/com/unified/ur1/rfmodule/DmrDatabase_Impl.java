package com.unified.ur1.rfmodule;

import D0.t;
import F3.i;
import android.content.Context;
import androidx.recyclerview.widget.C0258e;
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
import m3.C0777m;
import p0.C0818a;
import p0.c;

/* loaded from: classes.dex */
public final class DmrDatabase_Impl extends DmrDatabase {

    /* renamed from: l, reason: collision with root package name */
    public volatile C0777m f6051l;

    @Override // l0.AbstractC0737m
    public final C0733i e() {
        return new C0733i(this, new HashMap(0), new HashMap(0), "recordings");
    }

    @Override // l0.AbstractC0737m
    public final c f(C0726b c0726b) {
        C0258e c0258e = new C0258e(c0726b, new t(this, 2), "dc6bd07a0b4e2e6591f4494432739c35", "8fcd4fe0839bbb89618511b0b6d80bd6");
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
        map.put(C0777m.class, Collections.emptyList());
        return map;
    }

    @Override // com.unified.ur1.rfmodule.DmrDatabase
    public final C0777m r() {
        C0777m c0777m;
        if (this.f6051l != null) {
            return this.f6051l;
        }
        synchronized (this) {
            try {
                if (this.f6051l == null) {
                    this.f6051l = new C0777m(this);
                }
                c0777m = this.f6051l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0777m;
    }
}
