package X2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Trace;
import e1.C0442j;
import f1.C0475a;
import f1.C0476b;
import f3.InterfaceC0512d0;
import f3.f0;
import f3.m0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* renamed from: X2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0202f implements N1.e, N1.b, F2.e, g1.b, f1.h, InterfaceC0512d0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2794c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2795d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2796e;

    public /* synthetic */ C0202f(Object obj, int i5, Object obj2) {
        this.f2794c = i5;
        this.f2795d = obj;
        this.f2796e = obj2;
    }

    @Override // f3.InterfaceC0512d0
    public void a(String str) {
        f0 f0Var = (f0) this.f2795d;
        if (str == null) {
            f0Var.getClass();
        } else {
            f0Var.d(str);
            f0Var.g((m0) this.f2796e);
        }
    }

    @Override // f1.h
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        f1.j jVar = (f1.j) this.f2795d;
        C0475a c0475a = jVar.f6464m;
        int i5 = c0475a.f6445b;
        Y0.i iVar = (Y0.i) this.f2796e;
        ArrayList arrayListS = jVar.s(sQLiteDatabase, iVar, i5);
        for (V0.d dVar : V0.d.values()) {
            if (dVar != iVar.f2914c) {
                int size = c0475a.f6445b - arrayListS.size();
                if (size <= 0) {
                    break;
                }
                L0.m mVarA = Y0.i.a();
                mVarA.o(iVar.f2912a);
                if (dVar == null) {
                    throw new NullPointerException("Null priority");
                }
                mVarA.f1558f = dVar;
                mVarA.f1557e = iVar.f2913b;
                arrayListS.addAll(jVar.s(sQLiteDatabase, mVarA.d(), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i6 = 0; i6 < arrayListS.size(); i6++) {
            sb.append(((C0476b) arrayListS.get(i6)).f6449a);
            if (i6 < arrayListS.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j5 = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j5));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j5), hashSet);
                }
                hashSet.add(new f1.i(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListS.listIterator();
        while (listIterator.hasNext()) {
            C0476b c0476b = (C0476b) listIterator.next();
            if (map.containsKey(Long.valueOf(c0476b.f6449a))) {
                n nVarC = c0476b.f6451c.c();
                long j6 = c0476b.f6449a;
                for (f1.i iVar2 : (Set) map.get(Long.valueOf(j6))) {
                    nVarC.a(iVar2.f6458a, iVar2.f6459b);
                }
                listIterator.set(new C0476b(j6, c0476b.f6450b, nVarC.d()));
            }
        }
        return arrayListS;
    }

    @Override // F2.e
    public Object b(F2.t tVar) {
        switch (this.f2794c) {
            case 2:
                return new Z2.a((String) this.f2795d, ((A2.i) this.f2796e).a((Context) tVar.a(Context.class)));
            default:
                String str = (String) this.f2795d;
                F2.b bVar = (F2.b) this.f2796e;
                try {
                    Trace.beginSection(str);
                    return bVar.f548f.b(tVar);
                } finally {
                    Trace.endSection();
                }
        }
    }

    @Override // N1.b
    public Object c(N1.j jVar) {
        j jVar2 = (j) this.f2795d;
        String str = (String) this.f2796e;
        synchronized (jVar2) {
            ((q.b) jVar2.f2809b).remove(str);
        }
        return jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.C0202f.d():void");
    }

    @Override // g1.b
    public Object execute() {
        switch (this.f2794c) {
            case 4:
                f1.j jVar = (f1.j) ((C0442j) this.f2795d).f6178c;
                jVar.getClass();
                Iterable iterable = (Iterable) this.f2796e;
                if (iterable.iterator().hasNext()) {
                    jVar.a().compileStatement("DELETE FROM events WHERE _id in " + f1.j.V(iterable)).execute();
                    break;
                }
                break;
            default:
                C0442j c0442j = (C0442j) this.f2795d;
                c0442j.getClass();
                Iterator it = ((Map) this.f2796e).entrySet().iterator();
                while (it.hasNext()) {
                    ((f1.j) c0442j.f6182i).x(((Integer) r2.getValue()).intValue(), b1.c.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
                }
                break;
        }
        return null;
    }

    @Override // N1.e
    public void k(N1.j jVar) {
        ((g) this.f2795d).a((Intent) this.f2796e);
    }
}
