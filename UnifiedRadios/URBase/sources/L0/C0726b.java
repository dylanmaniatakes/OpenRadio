package l0;

import android.content.Context;
import g0.AbstractC0535a;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import p0.InterfaceC0819b;

/* renamed from: l0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0726b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8325a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8326b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0819b f8327c;

    /* renamed from: d, reason: collision with root package name */
    public final L0.l f8328d;

    /* renamed from: e, reason: collision with root package name */
    public final List f8329e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8330f;
    public final int g;
    public final Executor h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f8331i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f8332j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f8333k;

    /* renamed from: l, reason: collision with root package name */
    public final Set f8334l;

    /* renamed from: m, reason: collision with root package name */
    public final List f8335m;
    public final List n;

    public C0726b(Context context, String str, InterfaceC0819b interfaceC0819b, L0.l lVar, List list, boolean z4, int i5, Executor executor, Executor executor2, boolean z5, boolean z6, Set set, List list2, List list3) {
        F3.i.f(context, "context");
        F3.i.f(lVar, "migrationContainer");
        AbstractC0535a.p(i5, "journalMode");
        F3.i.f(executor, "queryExecutor");
        F3.i.f(executor2, "transactionExecutor");
        F3.i.f(list2, "typeConverters");
        F3.i.f(list3, "autoMigrationSpecs");
        this.f8325a = context;
        this.f8326b = str;
        this.f8327c = interfaceC0819b;
        this.f8328d = lVar;
        this.f8329e = list;
        this.f8330f = z4;
        this.g = i5;
        this.h = executor;
        this.f8331i = executor2;
        this.f8332j = z5;
        this.f8333k = z6;
        this.f8334l = set;
        this.f8335m = list2;
        this.n = list3;
    }

    public final boolean a(int i5, int i6) {
        if ((i5 > i6 && this.f8333k) || !this.f8332j) {
            return false;
        }
        Set set = this.f8334l;
        return set == null || !set.contains(Integer.valueOf(i5));
    }
}
