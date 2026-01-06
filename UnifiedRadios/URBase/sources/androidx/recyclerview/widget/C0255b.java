package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import e.AbstractC0429a;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import k.AbstractC0636i0;
import k.W0;

/* renamed from: androidx.recyclerview.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0255b {

    /* renamed from: a, reason: collision with root package name */
    public int f4198a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4199b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4200c;

    /* renamed from: d, reason: collision with root package name */
    public Object f4201d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4202e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4203f;

    public C0255b(View view) {
        this.f4198a = -1;
        this.f4199b = view;
        this.f4200c = k.r.a();
    }

    public void a() {
        View view = (View) this.f4199b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((W0) this.f4201d) != null) {
                if (((W0) this.f4203f) == null) {
                    this.f4203f = new W0();
                }
                W0 w02 = (W0) this.f4203f;
                w02.f7724a = null;
                w02.f7727d = false;
                w02.f7725b = null;
                w02.f7726c = false;
                WeakHashMap weakHashMap = O.Y.f1904a;
                ColorStateList colorStateListG = O.M.g(view);
                if (colorStateListG != null) {
                    w02.f7727d = true;
                    w02.f7724a = colorStateListG;
                }
                PorterDuff.Mode modeH = O.M.h(view);
                if (modeH != null) {
                    w02.f7726c = true;
                    w02.f7725b = modeH;
                }
                if (w02.f7727d || w02.f7726c) {
                    k.r.e(background, w02, view.getDrawableState());
                    return;
                }
            }
            W0 w03 = (W0) this.f4202e;
            if (w03 != null) {
                k.r.e(background, w03, view.getDrawableState());
                return;
            }
            W0 w04 = (W0) this.f4201d;
            if (w04 != null) {
                k.r.e(background, w04, view.getDrawableState());
            }
        }
    }

    public boolean b(int i5) {
        ArrayList arrayList = (ArrayList) this.f4201d;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C0254a c0254a = (C0254a) arrayList.get(i6);
            int i7 = c0254a.f4194a;
            if (i7 == 8) {
                if (g(c0254a.f4197d, i6 + 1) == i5) {
                    return true;
                }
            } else if (i7 == 1) {
                int i8 = c0254a.f4195b;
                int i9 = c0254a.f4197d + i8;
                while (i8 < i9) {
                    if (g(i8, i6 + 1) == i5) {
                        return true;
                    }
                    i8++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void c() {
        ArrayList arrayList = (ArrayList) this.f4201d;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((L) this.f4202e).a((C0254a) arrayList.get(i5));
        }
        q(arrayList);
        this.f4198a = 0;
    }

    public void d() {
        c();
        ArrayList arrayList = (ArrayList) this.f4200c;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0254a c0254a = (C0254a) arrayList.get(i5);
            int i6 = c0254a.f4194a;
            L l5 = (L) this.f4202e;
            if (i6 == 1) {
                l5.a(c0254a);
                l5.d(c0254a.f4195b, c0254a.f4197d);
            } else if (i6 == 2) {
                l5.a(c0254a);
                int i7 = c0254a.f4195b;
                int i8 = c0254a.f4197d;
                RecyclerView recyclerView = l5.f4048a;
                recyclerView.S(i7, i8, true);
                recyclerView.f4121m0 = true;
                recyclerView.f4115j0.f4265c += i8;
            } else if (i6 == 4) {
                l5.a(c0254a);
                l5.c(c0254a.f4195b, c0254a.f4197d, c0254a.f4196c);
            } else if (i6 == 8) {
                l5.a(c0254a);
                l5.e(c0254a.f4195b, c0254a.f4197d);
            }
        }
        q(arrayList);
        this.f4198a = 0;
    }

    public void e(C0254a c0254a) {
        int i5;
        N.c cVar;
        int i6 = c0254a.f4194a;
        if (i6 == 1 || i6 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iU = u(c0254a.f4195b, i6);
        int i7 = c0254a.f4195b;
        int i8 = c0254a.f4194a;
        if (i8 == 2) {
            i5 = 0;
        } else {
            if (i8 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c0254a);
            }
            i5 = 1;
        }
        int i9 = 1;
        int i10 = 1;
        while (true) {
            int i11 = c0254a.f4197d;
            cVar = (N.c) this.f4199b;
            if (i9 >= i11) {
                break;
            }
            int iU2 = u((i5 * i9) + c0254a.f4195b, c0254a.f4194a);
            int i12 = c0254a.f4194a;
            if (i12 == 2 ? iU2 != iU : !(i12 == 4 && iU2 == iU + 1)) {
                C0254a c0254aL = l(c0254a.f4196c, i12, iU, i10);
                f(c0254aL, i7);
                c0254aL.f4196c = null;
                cVar.c(c0254aL);
                if (c0254a.f4194a == 4) {
                    i7 += i10;
                }
                i10 = 1;
                iU = iU2;
            } else {
                i10++;
            }
            i9++;
        }
        Object obj = c0254a.f4196c;
        c0254a.f4196c = null;
        cVar.c(c0254a);
        if (i10 > 0) {
            C0254a c0254aL2 = l(obj, c0254a.f4194a, iU, i10);
            f(c0254aL2, i7);
            c0254aL2.f4196c = null;
            cVar.c(c0254aL2);
        }
    }

    public void f(C0254a c0254a, int i5) {
        L l5 = (L) this.f4202e;
        l5.a(c0254a);
        int i6 = c0254a.f4194a;
        if (i6 != 2) {
            if (i6 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            l5.c(i5, c0254a.f4197d, c0254a.f4196c);
        } else {
            int i7 = c0254a.f4197d;
            RecyclerView recyclerView = l5.f4048a;
            recyclerView.S(i5, i7, true);
            recyclerView.f4121m0 = true;
            recyclerView.f4115j0.f4265c += i7;
        }
    }

    public int g(int i5, int i6) {
        ArrayList arrayList = (ArrayList) this.f4201d;
        int size = arrayList.size();
        while (i6 < size) {
            C0254a c0254a = (C0254a) arrayList.get(i6);
            int i7 = c0254a.f4194a;
            if (i7 == 8) {
                int i8 = c0254a.f4195b;
                if (i8 == i5) {
                    i5 = c0254a.f4197d;
                } else {
                    if (i8 < i5) {
                        i5--;
                    }
                    if (c0254a.f4197d <= i5) {
                        i5++;
                    }
                }
            } else {
                int i9 = c0254a.f4195b;
                if (i9 > i5) {
                    continue;
                } else if (i7 == 2) {
                    int i10 = c0254a.f4197d;
                    if (i5 < i9 + i10) {
                        return -1;
                    }
                    i5 -= i10;
                } else if (i7 == 1) {
                    i5 += c0254a.f4197d;
                }
            }
            i6++;
        }
        return i5;
    }

    public ColorStateList h() {
        W0 w02 = (W0) this.f4202e;
        if (w02 != null) {
            return w02.f7724a;
        }
        return null;
    }

    public PorterDuff.Mode i() {
        W0 w02 = (W0) this.f4202e;
        if (w02 != null) {
            return w02.f7725b;
        }
        return null;
    }

    public boolean j() {
        return ((ArrayList) this.f4200c).size() > 0;
    }

    public void k(AttributeSet attributeSet, int i5) {
        ColorStateList colorStateListH;
        View view = (View) this.f4199b;
        Context context = view.getContext();
        int[] iArr = AbstractC0429a.f6137z;
        L0.m mVarK = L0.m.k(context, attributeSet, iArr, i5, 0);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        View view2 = (View) this.f4199b;
        O.Y.j(view2, view2.getContext(), iArr, attributeSet, (TypedArray) mVarK.f1557e, i5);
        try {
            if (typedArray.hasValue(0)) {
                this.f4198a = typedArray.getResourceId(0, -1);
                k.r rVar = (k.r) this.f4200c;
                Context context2 = view.getContext();
                int i6 = this.f4198a;
                synchronized (rVar) {
                    colorStateListH = rVar.f7855a.h(context2, i6);
                }
                if (colorStateListH != null) {
                    r(colorStateListH);
                }
            }
            if (typedArray.hasValue(1)) {
                O.M.q(view, mVarK.f(1));
            }
            if (typedArray.hasValue(2)) {
                O.M.r(view, AbstractC0636i0.b(typedArray.getInt(2, -1), null));
            }
            mVarK.n();
        } catch (Throwable th) {
            mVarK.n();
            throw th;
        }
    }

    public C0254a l(Object obj, int i5, int i6, int i7) {
        C0254a c0254a = (C0254a) ((N.c) this.f4199b).a();
        if (c0254a != null) {
            c0254a.f4194a = i5;
            c0254a.f4195b = i6;
            c0254a.f4197d = i7;
            c0254a.f4196c = obj;
            return c0254a;
        }
        C0254a c0254a2 = new C0254a();
        c0254a2.f4194a = i5;
        c0254a2.f4195b = i6;
        c0254a2.f4197d = i7;
        c0254a2.f4196c = obj;
        return c0254a2;
    }

    public void m() {
        this.f4198a = -1;
        r(null);
        a();
    }

    public void n(int i5) {
        ColorStateList colorStateListH;
        this.f4198a = i5;
        k.r rVar = (k.r) this.f4200c;
        if (rVar != null) {
            Context context = ((View) this.f4199b).getContext();
            synchronized (rVar) {
                colorStateListH = rVar.f7855a.h(context, i5);
            }
        } else {
            colorStateListH = null;
        }
        r(colorStateListH);
        a();
    }

    public void o(C0254a c0254a) {
        ((ArrayList) this.f4201d).add(c0254a);
        int i5 = c0254a.f4194a;
        L l5 = (L) this.f4202e;
        if (i5 == 1) {
            l5.d(c0254a.f4195b, c0254a.f4197d);
            return;
        }
        if (i5 == 2) {
            int i6 = c0254a.f4195b;
            int i7 = c0254a.f4197d;
            RecyclerView recyclerView = l5.f4048a;
            recyclerView.S(i6, i7, false);
            recyclerView.f4121m0 = true;
            return;
        }
        if (i5 == 4) {
            l5.c(c0254a.f4195b, c0254a.f4197d, c0254a.f4196c);
        } else if (i5 == 8) {
            l5.e(c0254a.f4195b, c0254a.f4197d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + c0254a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p() {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C0255b.p():void");
    }

    public void q(List list) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0254a c0254a = (C0254a) list.get(i5);
            c0254a.f4196c = null;
            ((N.c) this.f4199b).c(c0254a);
        }
        list.clear();
    }

    public void r(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((W0) this.f4201d) == null) {
                this.f4201d = new W0();
            }
            W0 w02 = (W0) this.f4201d;
            w02.f7724a = colorStateList;
            w02.f7727d = true;
        } else {
            this.f4201d = null;
        }
        a();
    }

    public void s(ColorStateList colorStateList) {
        if (((W0) this.f4202e) == null) {
            this.f4202e = new W0();
        }
        W0 w02 = (W0) this.f4202e;
        w02.f7724a = colorStateList;
        w02.f7727d = true;
        a();
    }

    public void t(PorterDuff.Mode mode) {
        if (((W0) this.f4202e) == null) {
            this.f4202e = new W0();
        }
        W0 w02 = (W0) this.f4202e;
        w02.f7725b = mode;
        w02.f7726c = true;
        a();
    }

    public int u(int i5, int i6) {
        int i7;
        int i8;
        ArrayList arrayList = (ArrayList) this.f4201d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0254a c0254a = (C0254a) arrayList.get(size);
            int i9 = c0254a.f4194a;
            if (i9 == 8) {
                int i10 = c0254a.f4195b;
                int i11 = c0254a.f4197d;
                if (i10 < i11) {
                    i8 = i10;
                    i7 = i11;
                } else {
                    i7 = i10;
                    i8 = i11;
                }
                if (i5 < i8 || i5 > i7) {
                    if (i5 < i10) {
                        if (i6 == 1) {
                            c0254a.f4195b = i10 + 1;
                            c0254a.f4197d = i11 + 1;
                        } else if (i6 == 2) {
                            c0254a.f4195b = i10 - 1;
                            c0254a.f4197d = i11 - 1;
                        }
                    }
                } else if (i8 == i10) {
                    if (i6 == 1) {
                        c0254a.f4197d = i11 + 1;
                    } else if (i6 == 2) {
                        c0254a.f4197d = i11 - 1;
                    }
                    i5++;
                } else {
                    if (i6 == 1) {
                        c0254a.f4195b = i10 + 1;
                    } else if (i6 == 2) {
                        c0254a.f4195b = i10 - 1;
                    }
                    i5--;
                }
            } else {
                int i12 = c0254a.f4195b;
                if (i12 <= i5) {
                    if (i9 == 1) {
                        i5 -= c0254a.f4197d;
                    } else if (i9 == 2) {
                        i5 += c0254a.f4197d;
                    }
                } else if (i6 == 1) {
                    c0254a.f4195b = i12 + 1;
                } else if (i6 == 2) {
                    c0254a.f4195b = i12 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            C0254a c0254a2 = (C0254a) arrayList.get(size2);
            int i13 = c0254a2.f4194a;
            N.c cVar = (N.c) this.f4199b;
            if (i13 == 8) {
                int i14 = c0254a2.f4197d;
                if (i14 == c0254a2.f4195b || i14 < 0) {
                    arrayList.remove(size2);
                    c0254a2.f4196c = null;
                    cVar.c(c0254a2);
                }
            } else if (c0254a2.f4197d <= 0) {
                arrayList.remove(size2);
                c0254a2.f4196c = null;
                cVar.c(c0254a2);
            }
        }
        return i5;
    }

    public C0255b(L l5) {
        this.f4199b = new N.c(30);
        this.f4200c = new ArrayList();
        this.f4201d = new ArrayList();
        this.f4198a = 0;
        this.f4202e = l5;
        this.f4203f = new C0256c(this);
    }
}
