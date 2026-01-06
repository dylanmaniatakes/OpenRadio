package k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import com.unified.ur1.R;
import f3.C0519j;
import j.InterfaceC0581A;
import java.util.ArrayList;

/* renamed from: k.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0637j implements j.z {

    /* renamed from: A, reason: collision with root package name */
    public int f7788A;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7789c;

    /* renamed from: d, reason: collision with root package name */
    public Context f7790d;

    /* renamed from: e, reason: collision with root package name */
    public j.m f7791e;

    /* renamed from: f, reason: collision with root package name */
    public final LayoutInflater f7792f;
    public j.y g;

    /* renamed from: j, reason: collision with root package name */
    public j.B f7794j;

    /* renamed from: k, reason: collision with root package name */
    public int f7795k;

    /* renamed from: l, reason: collision with root package name */
    public C0633h f7796l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f7797m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7798o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7799p;

    /* renamed from: q, reason: collision with root package name */
    public int f7800q;

    /* renamed from: r, reason: collision with root package name */
    public int f7801r;

    /* renamed from: s, reason: collision with root package name */
    public int f7802s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7803t;

    /* renamed from: v, reason: collision with root package name */
    public C0627e f7805v;

    /* renamed from: w, reason: collision with root package name */
    public C0627e f7806w;

    /* renamed from: x, reason: collision with root package name */
    public RunnableC0631g f7807x;

    /* renamed from: y, reason: collision with root package name */
    public C0629f f7808y;
    public final int h = R.layout.abc_action_menu_layout;

    /* renamed from: i, reason: collision with root package name */
    public final int f7793i = R.layout.abc_action_menu_item_layout;

    /* renamed from: u, reason: collision with root package name */
    public final SparseBooleanArray f7804u = new SparseBooleanArray();

    /* renamed from: z, reason: collision with root package name */
    public final C0519j f7809z = new C0519j(21, this);

    public C0637j(Context context) {
        this.f7789c = context;
        this.f7792f = LayoutInflater.from(context);
    }

    @Override // j.z
    public final void a(j.m mVar, boolean z4) {
        c();
        C0627e c0627e = this.f7806w;
        if (c0627e != null && c0627e.b()) {
            c0627e.f7523j.dismiss();
        }
        j.y yVar = this.g;
        if (yVar != null) {
            yVar.a(mVar, z4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [j.A] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View b(j.o oVar, View view, ViewGroup viewGroup) {
        View actionView = oVar.getActionView();
        if (actionView == null || oVar.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof InterfaceC0581A ? (InterfaceC0581A) view : (InterfaceC0581A) this.f7792f.inflate(this.f7793i, viewGroup, false);
            actionMenuItemView.c(oVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f7794j);
            if (this.f7808y == null) {
                this.f7808y = new C0629f(this);
            }
            actionMenuItemView2.setPopupCallback(this.f7808y);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(oVar.f7480C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C0641l)) {
            actionView.setLayoutParams(ActionMenuView.m(layoutParams));
        }
        return actionView;
    }

    public final boolean c() {
        Object obj;
        RunnableC0631g runnableC0631g = this.f7807x;
        if (runnableC0631g != null && (obj = this.f7794j) != null) {
            ((View) obj).removeCallbacks(runnableC0631g);
            this.f7807x = null;
            return true;
        }
        C0627e c0627e = this.f7805v;
        if (c0627e == null) {
            return false;
        }
        if (c0627e.b()) {
            c0627e.f7523j.dismiss();
        }
        return true;
    }

    @Override // j.z
    public final boolean d(j.o oVar) {
        return false;
    }

    @Override // j.z
    public final void e(Parcelable parcelable) {
        int i5;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof C0635i) && (i5 = ((C0635i) parcelable).f7785j) > 0 && (menuItemFindItem = this.f7791e.findItem(i5)) != null) {
            m((j.F) menuItemFindItem.getSubMenu());
        }
    }

    public final boolean f() {
        C0627e c0627e = this.f7805v;
        return c0627e != null && c0627e.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j.z
    public final void g(boolean z4) {
        int i5;
        ViewGroup viewGroup = (ViewGroup) this.f7794j;
        ArrayList arrayList = null;
        boolean z5 = false;
        if (viewGroup != null) {
            j.m mVar = this.f7791e;
            if (mVar != null) {
                mVar.i();
                ArrayList arrayListL = this.f7791e.l();
                int size = arrayListL.size();
                i5 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    j.o oVar = (j.o) arrayListL.get(i6);
                    if (oVar.f()) {
                        View childAt = viewGroup.getChildAt(i5);
                        j.o itemData = childAt instanceof InterfaceC0581A ? ((InterfaceC0581A) childAt).getItemData() : null;
                        View viewB = b(oVar, childAt, viewGroup);
                        if (oVar != itemData) {
                            viewB.setPressed(false);
                            viewB.jumpDrawablesToCurrentState();
                        }
                        if (viewB != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewB.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewB);
                            }
                            ((ViewGroup) this.f7794j).addView(viewB, i5);
                        }
                        i5++;
                    }
                }
            } else {
                i5 = 0;
            }
            while (i5 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i5) == this.f7796l) {
                    i5++;
                } else {
                    viewGroup.removeViewAt(i5);
                }
            }
        }
        ((View) this.f7794j).requestLayout();
        j.m mVar2 = this.f7791e;
        if (mVar2 != null) {
            mVar2.i();
            ArrayList arrayList2 = mVar2.f7460i;
            int size2 = arrayList2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                j.p pVar = ((j.o) arrayList2.get(i7)).f7478A;
            }
        }
        j.m mVar3 = this.f7791e;
        if (mVar3 != null) {
            mVar3.i();
            arrayList = mVar3.f7461j;
        }
        if (this.f7798o && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z5 = !((j.o) arrayList.get(0)).f7480C;
            } else if (size3 > 0) {
                z5 = true;
            }
        }
        if (z5) {
            if (this.f7796l == null) {
                this.f7796l = new C0633h(this, this.f7789c);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f7796l.getParent();
            if (viewGroup3 != this.f7794j) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f7796l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f7794j;
                C0633h c0633h = this.f7796l;
                actionMenuView.getClass();
                C0641l c0641lL = ActionMenuView.l();
                c0641lL.f7815a = true;
                actionMenuView.addView(c0633h, c0641lL);
            }
        } else {
            C0633h c0633h2 = this.f7796l;
            if (c0633h2 != null) {
                Object parent = c0633h2.getParent();
                Object obj = this.f7794j;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f7796l);
                }
            }
        }
        ((ActionMenuView) this.f7794j).setOverflowReserved(this.f7798o);
    }

    @Override // j.z
    public final int getId() {
        return this.f7795k;
    }

    @Override // j.z
    public final void h(Context context, j.m mVar) {
        this.f7790d = context;
        LayoutInflater.from(context);
        this.f7791e = mVar;
        Resources resources = context.getResources();
        if (!this.f7799p) {
            this.f7798o = true;
        }
        int i5 = 2;
        this.f7800q = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i6 = configuration.screenWidthDp;
        int i7 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i6 > 600 || ((i6 > 960 && i7 > 720) || (i6 > 720 && i7 > 960))) {
            i5 = 5;
        } else if (i6 >= 500 || ((i6 > 640 && i7 > 480) || (i6 > 480 && i7 > 640))) {
            i5 = 4;
        } else if (i6 >= 360) {
            i5 = 3;
        }
        this.f7802s = i5;
        int measuredWidth = this.f7800q;
        if (this.f7798o) {
            if (this.f7796l == null) {
                C0633h c0633h = new C0633h(this, this.f7789c);
                this.f7796l = c0633h;
                if (this.n) {
                    c0633h.setImageDrawable(this.f7797m);
                    this.f7797m = null;
                    this.n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f7796l.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f7796l.getMeasuredWidth();
        } else {
            this.f7796l = null;
        }
        this.f7801r = measuredWidth;
        float f5 = resources.getDisplayMetrics().density;
    }

    @Override // j.z
    public final boolean i() {
        int size;
        ArrayList arrayListL;
        int i5;
        boolean z4;
        j.m mVar = this.f7791e;
        if (mVar != null) {
            arrayListL = mVar.l();
            size = arrayListL.size();
        } else {
            size = 0;
            arrayListL = null;
        }
        int i6 = this.f7802s;
        int i7 = this.f7801r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f7794j;
        int i8 = 0;
        boolean z5 = false;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i5 = 2;
            z4 = true;
            if (i8 >= size) {
                break;
            }
            j.o oVar = (j.o) arrayListL.get(i8);
            int i11 = oVar.f7502y;
            if ((i11 & 2) == 2) {
                i9++;
            } else if ((i11 & 1) == 1) {
                i10++;
            } else {
                z5 = true;
            }
            if (this.f7803t && oVar.f7480C) {
                i6 = 0;
            }
            i8++;
        }
        if (this.f7798o && (z5 || i10 + i9 > i6)) {
            i6--;
        }
        int i12 = i6 - i9;
        SparseBooleanArray sparseBooleanArray = this.f7804u;
        sparseBooleanArray.clear();
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            j.o oVar2 = (j.o) arrayListL.get(i13);
            int i15 = oVar2.f7502y;
            boolean z6 = (i15 & 2) == i5 ? z4 : false;
            int i16 = oVar2.f7482b;
            if (z6) {
                View viewB = b(oVar2, null, viewGroup);
                viewB.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewB.getMeasuredWidth();
                i7 -= measuredWidth;
                if (i14 == 0) {
                    i14 = measuredWidth;
                }
                if (i16 != 0) {
                    sparseBooleanArray.put(i16, z4);
                }
                oVar2.h(z4);
            } else if ((i15 & 1) == z4) {
                boolean z7 = sparseBooleanArray.get(i16);
                boolean z8 = ((i12 > 0 || z7) && i7 > 0) ? z4 : false;
                if (z8) {
                    View viewB2 = b(oVar2, null, viewGroup);
                    viewB2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewB2.getMeasuredWidth();
                    i7 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z8 &= i7 + i14 > 0;
                }
                if (z8 && i16 != 0) {
                    sparseBooleanArray.put(i16, true);
                } else if (z7) {
                    sparseBooleanArray.put(i16, false);
                    for (int i17 = 0; i17 < i13; i17++) {
                        j.o oVar3 = (j.o) arrayListL.get(i17);
                        if (oVar3.f7482b == i16) {
                            if (oVar3.f()) {
                                i12++;
                            }
                            oVar3.h(false);
                        }
                    }
                }
                if (z8) {
                    i12--;
                }
                oVar2.h(z8);
            } else {
                oVar2.h(false);
                i13++;
                i5 = 2;
                z4 = true;
            }
            i13++;
            i5 = 2;
            z4 = true;
        }
        return z4;
    }

    @Override // j.z
    public final Parcelable j() {
        C0635i c0635i = new C0635i();
        c0635i.f7785j = this.f7788A;
        return c0635i;
    }

    @Override // j.z
    public final boolean k(j.o oVar) {
        return false;
    }

    @Override // j.z
    public final void l(j.y yVar) {
        this.g = yVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // j.z
    public final boolean m(j.F f5) {
        boolean z4;
        if (!f5.hasVisibleItems()) {
            return false;
        }
        j.F f6 = f5;
        while (true) {
            j.m mVar = f6.f7397z;
            if (mVar == this.f7791e) {
                break;
            }
            f6 = (j.F) mVar;
        }
        ViewGroup viewGroup = (ViewGroup) this.f7794j;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i5);
                if ((childAt instanceof InterfaceC0581A) && ((InterfaceC0581A) childAt).getItemData() == f6.f7396A) {
                    view = childAt;
                    break;
                }
                i5++;
            }
        }
        if (view == null) {
            return false;
        }
        this.f7788A = f5.f7396A.f7481a;
        int size = f5.f7459f.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                z4 = false;
                break;
            }
            MenuItem item = f5.getItem(i6);
            if (item.isVisible() && item.getIcon() != null) {
                z4 = true;
                break;
            }
            i6++;
        }
        C0627e c0627e = new C0627e(this, this.f7790d, f5, view);
        this.f7806w = c0627e;
        c0627e.h = z4;
        j.u uVar = c0627e.f7523j;
        if (uVar != null) {
            uVar.q(z4);
        }
        C0627e c0627e2 = this.f7806w;
        if (!c0627e2.b()) {
            if (c0627e2.f7521f == null) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
            c0627e2.d(0, 0, false, false);
        }
        j.y yVar = this.g;
        if (yVar != null) {
            yVar.i(f5);
        }
        return true;
    }

    public final boolean n() {
        j.m mVar;
        if (!this.f7798o || f() || (mVar = this.f7791e) == null || this.f7794j == null || this.f7807x != null) {
            return false;
        }
        mVar.i();
        if (mVar.f7461j.isEmpty()) {
            return false;
        }
        RunnableC0631g runnableC0631g = new RunnableC0631g(this, new C0627e(this, this.f7790d, this.f7791e, this.f7796l));
        this.f7807x = runnableC0631g;
        ((View) this.f7794j).post(runnableC0631g);
        return true;
    }
}
