package androidx.recyclerview.widget;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import g0.AbstractC0535a;
import j1.C0599a;
import java.io.File;
import java.util.ArrayList;
import l0.C0726b;
import org.conscrypt.PSKKeyManager;
import q0.C0840c;

/* renamed from: androidx.recyclerview.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0258e implements k4.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4223a;

    /* renamed from: b, reason: collision with root package name */
    public int f4224b;

    /* renamed from: c, reason: collision with root package name */
    public Object f4225c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4226d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4227e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4228f;

    public C0258e() {
        this.f4223a = 2;
        this.f4225c = new float[PSKKeyManager.MAX_KEY_LENGTH_BYTES];
    }

    public static void f(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i5 = 0;
        boolean z4 = false;
        while (i5 <= length) {
            boolean z5 = F3.i.h(str.charAt(!z4 ? i5 : length), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length--;
                }
            } else if (z5) {
                i5++;
            } else {
                z4 = true;
            }
        }
        if (str.subSequence(i5, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e5) {
            Log.w("SupportSQLite", "delete failed: ", e5);
        }
    }

    @Override // k4.n
    public void a() {
        this.f4224b = 0;
    }

    @Override // k4.n
    public void b(long j5, long j6) {
        int i5 = this.f4224b;
        int i6 = i5 + 1;
        this.f4224b = i6;
        float[] fArr = (float[]) this.f4225c;
        fArr[i5] = j5;
        int i7 = i5 + 2;
        this.f4224b = i7;
        fArr[i6] = j6;
        if (i7 >= fArr.length) {
            n();
        }
    }

    @Override // k4.n
    public void c() {
        n();
    }

    public void d(View view, int i5, boolean z4) {
        L l5 = (L) this.f4225c;
        int childCount = i5 < 0 ? l5.f4048a.getChildCount() : j(i5);
        ((J1.U) this.f4226d).f(childCount, z4);
        if (z4) {
            m(view);
        }
        RecyclerView recyclerView = l5.f4048a;
        recyclerView.addView(view, childCount);
        n0 n0VarM = RecyclerView.M(view);
        N n = recyclerView.f4123o;
        if (n != null && n0VarM != null) {
            n.onViewAttachedToWindow(n0VarM);
        }
        ArrayList arrayList = recyclerView.f4082E;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((B0.i) recyclerView.f4082E.get(size)).getClass();
                Y y4 = (Y) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) y4).width != -1 || ((ViewGroup.MarginLayoutParams) y4).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        }
    }

    public void e(View view, int i5, ViewGroup.LayoutParams layoutParams, boolean z4) {
        L l5 = (L) this.f4225c;
        int childCount = i5 < 0 ? l5.f4048a.getChildCount() : j(i5);
        ((J1.U) this.f4226d).f(childCount, z4);
        if (z4) {
            m(view);
        }
        l5.getClass();
        n0 n0VarM = RecyclerView.M(view);
        RecyclerView recyclerView = l5.f4048a;
        if (n0VarM != null) {
            if (!n0VarM.isTmpDetached() && !n0VarM.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(n0VarM);
                throw new IllegalArgumentException(AbstractC0535a.i(recyclerView, sb));
            }
            if (RecyclerView.f4067D0) {
                Log.d("RecyclerView", "reAttach " + n0VarM);
            }
            n0VarM.clearTmpDetachFlag();
        } else if (RecyclerView.f4066C0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(AbstractC0535a.i(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public void g(int i5) {
        int iJ = j(i5);
        ((J1.U) this.f4226d).g(iJ);
        RecyclerView recyclerView = ((L) this.f4225c).f4048a;
        View childAt = recyclerView.getChildAt(iJ);
        if (childAt != null) {
            n0 n0VarM = RecyclerView.M(childAt);
            if (n0VarM != null) {
                if (n0VarM.isTmpDetached() && !n0VarM.shouldIgnore()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(n0VarM);
                    throw new IllegalArgumentException(AbstractC0535a.i(recyclerView, sb));
                }
                if (RecyclerView.f4067D0) {
                    Log.d("RecyclerView", "tmpDetach " + n0VarM);
                }
                n0VarM.addFlags(PSKKeyManager.MAX_KEY_LENGTH_BYTES);
            }
        } else if (RecyclerView.f4066C0) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(iJ);
            throw new IllegalArgumentException(AbstractC0535a.i(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(iJ);
    }

    public View h(int i5) {
        return ((L) this.f4225c).f4048a.getChildAt(j(i5));
    }

    public int i() {
        return ((L) this.f4225c).f4048a.getChildCount() - ((ArrayList) this.f4227e).size();
    }

    public int j(int i5) {
        if (i5 < 0) {
            return -1;
        }
        int childCount = ((L) this.f4225c).f4048a.getChildCount();
        int i6 = i5;
        while (i6 < childCount) {
            J1.U u4 = (J1.U) this.f4226d;
            int iB = i5 - (i6 - u4.b(i6));
            if (iB == 0) {
                while (u4.e(i6)) {
                    i6++;
                }
                return i6;
            }
            i6 += iB;
        }
        return -1;
    }

    public View k(int i5) {
        return ((L) this.f4225c).f4048a.getChildAt(i5);
    }

    public int l() {
        return ((L) this.f4225c).f4048a.getChildCount();
    }

    public void m(View view) {
        ((ArrayList) this.f4227e).add(view);
        L l5 = (L) this.f4225c;
        l5.getClass();
        n0 n0VarM = RecyclerView.M(view);
        if (n0VarM != null) {
            n0VarM.onEnteredHiddenState(l5.f4048a);
        }
    }

    public void n() {
        int i5 = this.f4224b;
        if (i5 > 0) {
            int i6 = i5 / 4;
            if (i6 == 0) {
                L.h hVar = (L.h) this.f4226d;
                if (hVar != null) {
                    hVar.f1521c = 0;
                }
            } else {
                Paint paint = ((n4.a) this.f4228f).f8884a;
                float[] fArr = (float[]) this.f4225c;
                if (paint != null) {
                    int i7 = i6 * 4;
                    int i8 = 0;
                    for (int i9 = 0; i9 < i7; i9 += 4) {
                        float f5 = fArr[i9];
                        float f6 = fArr[i9 + 1];
                        float f7 = fArr[i9 + 2];
                        float f8 = fArr[i9 + 3];
                        if (f5 != f7 || f6 != f8) {
                            if (i9 != i8) {
                                System.arraycopy(fArr, i9, fArr, i8, 4);
                            }
                            i8 += 4;
                        }
                    }
                    if (i8 > 0) {
                        ((Canvas) this.f4227e).drawLines(fArr, 0, i8, paint);
                    }
                    L.h hVar2 = (L.h) this.f4226d;
                    if (hVar2 != null) {
                        hVar2.f1521c = 0;
                    }
                } else {
                    for (int i10 = 0; i10 < i6 * 4; i10 += 4) {
                        float f9 = fArr[i10];
                        float f10 = fArr[i10 + 1];
                        float f11 = fArr[i10 + 2];
                        float f12 = fArr[i10 + 3];
                        if (f9 != f11 || f10 != f12) {
                            int i11 = ((int[]) ((L.h) this.f4226d).f1522d)[i10 / 2];
                            Canvas canvas = (Canvas) this.f4227e;
                            ((n4.a) this.f4228f).getClass();
                            canvas.drawLine(f9, f10, f11, f12, null);
                        }
                    }
                    L.h hVar3 = (L.h) this.f4226d;
                    if (hVar3 != null) {
                        hVar3.f1521c = 0;
                    }
                }
            }
        }
        this.f4224b = 0;
    }

    public boolean o(View view) {
        return ((ArrayList) this.f4227e).contains(view);
    }

    public void p(C0840c c0840c) {
    }

    public void q(C0840c c0840c) throws SQLException {
        Cursor cursorX = c0840c.X("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z4 = false;
            if (cursorX.moveToFirst()) {
                if (cursorX.getInt(0) == 0) {
                    z4 = true;
                }
            }
            AbstractC0399v1.b(cursorX, null);
            X1.e eVar = (X1.e) this.f4226d;
            eVar.a(c0840c);
            if (!z4) {
                C0599a c0599aK = eVar.k(c0840c);
                if (!c0599aK.f7563b) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + c0599aK.f7564c);
                }
            }
            v(c0840c);
            eVar.h(c0840c);
        } finally {
        }
    }

    public void r(C0840c c0840c, int i5, int i6) throws SQLException {
        t(c0840c, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(q0.C0840c r7) throws android.database.SQLException {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r7.X(r0)
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L15
            r2 = 0
            if (r1 == 0) goto L18
            int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L18
            r1 = 1
            goto L19
        L15:
            r7 = move-exception
            goto L9e
        L18:
            r1 = r2
        L19:
            r3 = 0
            com.google.android.gms.internal.measurement.AbstractC0399v1.b(r0, r3)
            java.lang.Object r0 = r6.f4226d
            X1.e r0 = (X1.e) r0
            if (r1 == 0) goto L77
            S3.w r1 = new S3.w
            java.lang.String r4 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r5 = 1
            r1.<init>(r4, r5)
            android.database.Cursor r1 = r7.Y(r1)
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L3c
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L3a
            goto L3d
        L3a:
            r7 = move-exception
            goto L71
        L3c:
            r2 = r3
        L3d:
            com.google.android.gms.internal.measurement.AbstractC0399v1.b(r1, r3)
            java.lang.Object r1 = r6.f4227e
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = F3.i.a(r1, r2)
            if (r4 != 0) goto L82
            java.lang.Object r4 = r6.f4228f
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = F3.i.a(r4, r2)
            if (r4 == 0) goto L55
            goto L82
        L55:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r0.<init>(r3)
            r0.append(r1)
            java.lang.String r1 = ", found: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L71:
            throw r7     // Catch: java.lang.Throwable -> L72
        L72:
            r0 = move-exception
            com.google.android.gms.internal.measurement.AbstractC0399v1.b(r1, r7)
            throw r0
        L77:
            j1.a r1 = r0.k(r7)
            boolean r2 = r1.f7563b
            if (r2 == 0) goto L88
            r6.v(r7)
        L82:
            r0.i(r7)
            r6.f4225c = r3
            return
        L88:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.String r1 = r1.f7564c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L9e:
            throw r7     // Catch: java.lang.Throwable -> L9f
        L9f:
            r1 = move-exception
            com.google.android.gms.internal.measurement.AbstractC0399v1.b(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C0258e.s(q0.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0041 A[EDGE_INSN: B:61:0x0041->B:18:0x0041 BREAK  A[LOOP:1: B:12:0x0029->B:64:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void t(q0.C0840c r17, int r18, int r19) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C0258e.t(q0.c, int, int):void");
    }

    public String toString() {
        switch (this.f4223a) {
            case 0:
                return ((J1.U) this.f4226d).toString() + ", hidden list:" + ((ArrayList) this.f4227e).size();
            default:
                return super.toString();
        }
    }

    public void u(View view) {
        if (((ArrayList) this.f4227e).remove(view)) {
            L l5 = (L) this.f4225c;
            l5.getClass();
            n0 n0VarM = RecyclerView.M(view);
            if (n0VarM != null) {
                n0VarM.onLeftHiddenState(l5.f4048a);
            }
        }
    }

    public void v(C0840c c0840c) throws SQLException {
        c0840c.x("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        String str = (String) this.f4227e;
        F3.i.f(str, "hash");
        c0840c.x("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')");
    }

    public C0258e(C0726b c0726b, X1.e eVar, String str, String str2) {
        this.f4223a = 1;
        int i5 = eVar.f2754a;
        this.f4223a = 1;
        this.f4224b = i5;
        this.f4225c = c0726b;
        this.f4226d = eVar;
        this.f4227e = str;
        this.f4228f = str2;
    }

    public C0258e(L l5) {
        this.f4223a = 0;
        this.f4224b = 0;
        this.f4225c = l5;
        this.f4226d = new J1.U();
        this.f4227e = new ArrayList();
    }
}
