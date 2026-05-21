package l0;

import android.app.ActivityManager;
import android.content.Context;
import h1.C0559c;
import i0.ExecutorC0566c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import l.C0722a;
import m0.AbstractC0759a;
import p0.InterfaceC0819b;
import t3.r;

/* renamed from: l0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0736l {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8352a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f8353b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8354c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f8355d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f8356e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f8357f;
    public Executor g;
    public Executor h;

    /* renamed from: i, reason: collision with root package name */
    public InterfaceC0819b f8358i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8359j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8360k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8361l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8362m;
    public final long n;

    /* renamed from: o, reason: collision with root package name */
    public final L0.l f8363o;

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashSet f8364p;

    /* renamed from: q, reason: collision with root package name */
    public HashSet f8365q;

    public C0736l(Context context, Class cls, String str) {
        F3.i.f(context, "context");
        this.f8352a = context;
        this.f8353b = cls;
        this.f8354c = str;
        this.f8355d = new ArrayList();
        this.f8356e = new ArrayList();
        this.f8357f = new ArrayList();
        this.f8360k = 1;
        this.f8361l = true;
        this.n = -1L;
        this.f8363o = new L0.l(28);
        this.f8364p = new LinkedHashSet();
    }

    public final void a(AbstractC0759a... abstractC0759aArr) {
        if (this.f8365q == null) {
            this.f8365q = new HashSet();
        }
        for (AbstractC0759a abstractC0759a : abstractC0759aArr) {
            HashSet hashSet = this.f8365q;
            F3.i.c(hashSet);
            hashSet.add(Integer.valueOf(abstractC0759a.f8508a));
            HashSet hashSet2 = this.f8365q;
            F3.i.c(hashSet2);
            hashSet2.add(Integer.valueOf(abstractC0759a.f8509b));
        }
        this.f8363o.s((AbstractC0759a[]) Arrays.copyOf(abstractC0759aArr, abstractC0759aArr.length));
    }

    public final AbstractC0737m b() throws ClassNotFoundException {
        int i5;
        Executor executor = this.g;
        if (executor == null && this.h == null) {
            ExecutorC0566c executorC0566c = C0722a.f8319c;
            this.h = executorC0566c;
            this.g = executorC0566c;
        } else if (executor != null && this.h == null) {
            this.h = executor;
        } else if (executor == null) {
            this.g = this.h;
        }
        HashSet hashSet = this.f8365q;
        LinkedHashSet linkedHashSet = this.f8364p;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (!(!linkedHashSet.contains(Integer.valueOf(iIntValue)))) {
                    throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ").toString());
                }
            }
        }
        InterfaceC0819b c0559c = this.f8358i;
        if (c0559c == null) {
            c0559c = new C0559c();
        }
        InterfaceC0819b interfaceC0819b = c0559c;
        if (this.n > 0) {
            if (this.f8354c != null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
        }
        ArrayList arrayList = this.f8355d;
        boolean z4 = this.f8359j;
        int i6 = this.f8360k;
        if (i6 == 0) {
            throw null;
        }
        Context context = this.f8352a;
        F3.i.f(context, "context");
        if (i6 != 1) {
            i5 = i6;
        } else {
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager == null || activityManager.isLowRamDevice()) {
                i6 = 2;
                i5 = i6;
            } else {
                i5 = 3;
            }
        }
        Executor executor2 = this.g;
        if (executor2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        Executor executor3 = this.h;
        if (executor3 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        C0726b c0726b = new C0726b(context, this.f8354c, interfaceC0819b, this.f8363o, arrayList, z4, i5, executor2, executor3, this.f8361l, this.f8362m, linkedHashSet, this.f8356e, this.f8357f);
        Class cls = this.f8353b;
        F3.i.f(cls, "klass");
        Package r32 = cls.getPackage();
        F3.i.c(r32);
        String name = r32.getName();
        String canonicalName = cls.getCanonicalName();
        F3.i.c(canonicalName);
        F3.i.e(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            F3.i.e(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String strConcat = M3.m.u(canonicalName, '.', '_').concat("_Impl");
        try {
            Class<?> cls2 = Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, cls.getClassLoader());
            F3.i.d(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            AbstractC0737m abstractC0737m = (AbstractC0737m) cls2.getDeclaredConstructor(null).newInstance(null);
            abstractC0737m.getClass();
            abstractC0737m.f8368c = abstractC0737m.f(c0726b);
            Set setI = abstractC0737m.i();
            BitSet bitSet = new BitSet();
            Iterator it2 = setI.iterator();
            while (true) {
                boolean zHasNext = it2.hasNext();
                LinkedHashMap linkedHashMap = abstractC0737m.g;
                int i7 = -1;
                List list = c0726b.n;
                if (zHasNext) {
                    Class cls3 = (Class) it2.next();
                    int size = list.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i8 = size - 1;
                            if (cls3.isAssignableFrom(list.get(size).getClass())) {
                                bitSet.set(size);
                                i7 = size;
                                break;
                            }
                            if (i8 < 0) {
                                break;
                            }
                            size = i8;
                        }
                    }
                    if (i7 < 0) {
                        throw new IllegalArgumentException(("A required auto migration spec (" + cls3.getCanonicalName() + ") is missing in the database configuration.").toString());
                    }
                    linkedHashMap.put(cls3, list.get(i7));
                } else {
                    int size2 = list.size() - 1;
                    if (size2 >= 0) {
                        while (true) {
                            int i9 = size2 - 1;
                            if (!bitSet.get(size2)) {
                                throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
                            }
                            if (i9 < 0) {
                                break;
                            }
                            size2 = i9;
                        }
                    }
                    Iterator it3 = abstractC0737m.g(linkedHashMap).iterator();
                    while (true) {
                        boolean zContainsKey = false;
                        if (!it3.hasNext()) {
                            break;
                        }
                        AbstractC0759a abstractC0759a = (AbstractC0759a) it3.next();
                        int i10 = abstractC0759a.f8508a;
                        L0.l lVar = c0726b.f8328d;
                        LinkedHashMap linkedHashMap2 = (LinkedHashMap) lVar.f1554d;
                        if (linkedHashMap2.containsKey(Integer.valueOf(i10))) {
                            Map map = (Map) linkedHashMap2.get(Integer.valueOf(i10));
                            if (map == null) {
                                map = r.f9712j;
                            }
                            zContainsKey = map.containsKey(Integer.valueOf(abstractC0759a.f8509b));
                        }
                        if (!zContainsKey) {
                            lVar.s(abstractC0759a);
                        }
                    }
                    abstractC0737m.h().setWriteAheadLoggingEnabled(c0726b.g == 3);
                    abstractC0737m.f8371f = c0726b.f8329e;
                    abstractC0737m.f8367b = c0726b.h;
                    F3.i.f(c0726b.f8331i, "executor");
                    new ArrayDeque();
                    abstractC0737m.f8370e = c0726b.f8330f;
                    Map mapJ = abstractC0737m.j();
                    BitSet bitSet2 = new BitSet();
                    Iterator it4 = mapJ.entrySet().iterator();
                    while (true) {
                        boolean zHasNext2 = it4.hasNext();
                        List list2 = c0726b.f8335m;
                        if (!zHasNext2) {
                            int size3 = list2.size() - 1;
                            if (size3 >= 0) {
                                while (true) {
                                    int i11 = size3 - 1;
                                    if (!bitSet2.get(size3)) {
                                        throw new IllegalArgumentException("Unexpected type converter " + list2.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                                    }
                                    if (i11 < 0) {
                                        break;
                                    }
                                    size3 = i11;
                                }
                            }
                            return abstractC0737m;
                        }
                        Map.Entry entry = (Map.Entry) it4.next();
                        Class cls4 = (Class) entry.getKey();
                        for (Class cls5 : (List) entry.getValue()) {
                            int size4 = list2.size() - 1;
                            if (size4 >= 0) {
                                while (true) {
                                    int i12 = size4 - 1;
                                    if (cls5.isAssignableFrom(list2.get(size4).getClass())) {
                                        bitSet2.set(size4);
                                        break;
                                    }
                                    if (i12 < 0) {
                                        break;
                                    }
                                    size4 = i12;
                                }
                            } else {
                                size4 = -1;
                            }
                            if (!(size4 >= 0)) {
                                throw new IllegalArgumentException(("A required type converter (" + cls5 + ") for " + cls4.getCanonicalName() + " is missing in the database configuration.").toString());
                            }
                            abstractC0737m.f8373j.put(cls5, list2.get(size4));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + strConcat + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }
}
