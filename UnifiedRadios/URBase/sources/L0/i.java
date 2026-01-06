package L0;

import X2.t;
import a.AbstractC0203a;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.internal.measurement.C0328h;
import com.google.android.gms.internal.measurement.C0358n;
import com.google.android.gms.internal.measurement.C0368p;
import com.google.android.gms.internal.measurement.C0376q2;
import com.google.android.gms.internal.measurement.C0384s1;
import com.google.android.gms.internal.measurement.CallableC0314e0;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.r4;
import e1.C0434b;
import e1.C0436d;
import j.C;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import l0.AbstractC0737m;
import l0.C0738n;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final class i implements InterfaceC0877a, i.a {

    /* renamed from: c, reason: collision with root package name */
    public Object f1547c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1548d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1549e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1550f;

    public i(int i5) {
        switch (i5) {
            case 8:
                break;
            case 9:
                this.f1547c = new q.b();
                this.f1548d = new SparseArray();
                this.f1549e = new q.e();
                this.f1550f = new q.b();
                break;
            default:
                s sVar = new s(12);
                this.f1547c = sVar;
                t tVar = new t((t) null, sVar);
                this.f1549e = tVar;
                this.f1548d = tVar.p();
                C0376q2 c0376q2 = new C0376q2(1);
                this.f1550f = c0376q2;
                tVar.w("require", new r4(c0376q2));
                ((HashMap) c0376q2.f5023a).put("internal.platform", new CallableC0314e0());
                tVar.w("runtime.counter", new C0328h(Double.valueOf(0.0d)));
                break;
        }
    }

    @Override // i.a
    public boolean a(i.b bVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f1547c).onActionItemClicked(f(bVar), new j.t((Context) this.f1548d, (G.a) menuItem));
    }

    @Override // i.a
    public void b(i.b bVar) {
        ((ActionMode.Callback) this.f1547c).onDestroyActionMode(f(bVar));
    }

    public void c(Runnable runnable) {
        ((M0.m) this.f1547c).execute(runnable);
    }

    @Override // i.a
    public boolean d(i.b bVar, j.m mVar) {
        i.g gVarF = f(bVar);
        q.k kVar = (q.k) this.f1550f;
        Menu c2 = (Menu) kVar.getOrDefault(mVar, null);
        if (c2 == null) {
            c2 = new C((Context) this.f1548d, mVar);
            kVar.put(mVar, c2);
        }
        return ((ActionMode.Callback) this.f1547c).onCreateActionMode(gVarF, c2);
    }

    @Override // i.a
    public boolean e(i.b bVar, Menu menu) {
        i.g gVarF = f(bVar);
        q.k kVar = (q.k) this.f1550f;
        Menu c2 = (Menu) kVar.getOrDefault(menu, null);
        if (c2 == null) {
            c2 = new C((Context) this.f1548d, (j.m) menu);
            kVar.put(menu, c2);
        }
        return ((ActionMode.Callback) this.f1547c).onPrepareActionMode(gVarF, c2);
    }

    public i.g f(i.b bVar) {
        ArrayList arrayList = (ArrayList) this.f1549e;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            i.g gVar = (i.g) arrayList.get(i5);
            if (gVar != null && gVar.f7139b == bVar) {
                return gVar;
            }
        }
        i.g gVar2 = new i.g((Context) this.f1548d, bVar);
        arrayList.add(gVar2);
        return gVar2;
    }

    public g g(j jVar) {
        C0738n c0738nO = C0738n.o(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        String str = jVar.f1551a;
        if (str == null) {
            c0738nO.t(1);
        } else {
            c0738nO.h(1, str);
        }
        c0738nO.I(2, jVar.f1552b);
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1547c;
        abstractC0737m.b();
        g gVar = null;
        String string = null;
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            int iH = f.h(cursorM, "work_spec_id");
            int iH2 = f.h(cursorM, "generation");
            int iH3 = f.h(cursorM, "system_id");
            if (cursorM.moveToFirst()) {
                if (!cursorM.isNull(iH)) {
                    string = cursorM.getString(iH);
                }
                gVar = new g(string, cursorM.getInt(iH2), cursorM.getInt(iH3));
            }
            return gVar;
        } finally {
            cursorM.close();
            c0738nO.s();
        }
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        Context context = (Context) ((InterfaceC0877a) this.f1547c).get();
        f1.d dVar = (f1.d) ((InterfaceC0877a) this.f1548d).get();
        C0434b c0434b = (C0434b) ((InterfaceC0877a) this.f1549e).get();
        return new C0436d(context, dVar, c0434b);
    }

    public void h(g gVar) {
        AbstractC0737m abstractC0737m = (AbstractC0737m) this.f1547c;
        abstractC0737m.b();
        abstractC0737m.c();
        try {
            ((b) this.f1548d).r(gVar);
            abstractC0737m.o();
        } finally {
            abstractC0737m.k();
        }
    }

    public InterfaceC0363o i(t tVar, C0384s1... c0384s1Arr) {
        InterfaceC0363o interfaceC0363oO = InterfaceC0363o.f5004b;
        for (C0384s1 c0384s1 : c0384s1Arr) {
            interfaceC0363oO = AbstractC0203a.o(c0384s1);
            Z3.i.m((t) this.f1549e);
            if ((interfaceC0363oO instanceof C0368p) || (interfaceC0363oO instanceof C0358n)) {
                interfaceC0363oO = ((s) this.f1547c).D(tVar, interfaceC0363oO);
            }
        }
        return interfaceC0363oO;
    }

    public i(Typeface typeface, X.b bVar) {
        int i5;
        int i6;
        this.f1550f = typeface;
        this.f1547c = bVar;
        this.f1549e = new androidx.emoji2.text.p(1024);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i7 = iA + bVar.f1889a;
            i5 = ((ByteBuffer) bVar.f1892d).getInt(((ByteBuffer) bVar.f1892d).getInt(i7) + i7);
        } else {
            i5 = 0;
        }
        this.f1548d = new char[i5 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i8 = iA2 + bVar.f1889a;
            i6 = ((ByteBuffer) bVar.f1892d).getInt(((ByteBuffer) bVar.f1892d).getInt(i8) + i8);
        } else {
            i6 = 0;
        }
        for (int i9 = 0; i9 < i6; i9++) {
            androidx.emoji2.text.l lVar = new androidx.emoji2.text.l(this, i9);
            X.a aVarC = lVar.c();
            int iA3 = aVarC.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarC.f1892d).getInt(iA3 + aVarC.f1889a) : 0, (char[]) this.f1548d, i9 * 2);
            h4.f.a(lVar.b() > 0, "invalid metadata codepoint length");
            ((androidx.emoji2.text.p) this.f1549e).a(lVar, 0, lVar.b() - 1);
        }
    }
}
