package androidx.fragment.app;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.EnumC0244n;
import androidx.lifecycle.InterfaceC0249t;
import com.unified.ur1.R;
import f3.C0513e;
import g0.AbstractC0535a;
import i3.C0579h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class T {

    /* renamed from: A, reason: collision with root package name */
    public boolean f3687A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f3688B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f3689C;

    /* renamed from: D, reason: collision with root package name */
    public ArrayList f3690D;

    /* renamed from: E, reason: collision with root package name */
    public ArrayList f3691E;

    /* renamed from: F, reason: collision with root package name */
    public ArrayList f3692F;

    /* renamed from: G, reason: collision with root package name */
    public W f3693G;

    /* renamed from: H, reason: collision with root package name */
    public final RunnableC0210e f3694H;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3696b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f3698d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3699e;
    public androidx.activity.u g;

    /* renamed from: l, reason: collision with root package name */
    public final A f3704l;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList f3705m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public F f3706o;

    /* renamed from: p, reason: collision with root package name */
    public D f3707p;

    /* renamed from: q, reason: collision with root package name */
    public Fragment f3708q;

    /* renamed from: r, reason: collision with root package name */
    public Fragment f3709r;

    /* renamed from: s, reason: collision with root package name */
    public final L f3710s;

    /* renamed from: t, reason: collision with root package name */
    public final J1.D f3711t;

    /* renamed from: u, reason: collision with root package name */
    public androidx.activity.result.d f3712u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.activity.result.d f3713v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.activity.result.d f3714w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayDeque f3715x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f3716y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f3717z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3695a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final c0 f3697c = new c0();

    /* renamed from: f, reason: collision with root package name */
    public final H f3700f = new H(this);
    public final K h = new K(this);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f3701i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f3702j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map f3703k = Collections.synchronizedMap(new HashMap());

    public T() {
        Collections.synchronizedMap(new HashMap());
        new J1.C(this);
        this.f3704l = new A(this);
        this.f3705m = new CopyOnWriteArrayList();
        this.n = -1;
        this.f3710s = new L(this);
        this.f3711t = new J1.D(25);
        this.f3715x = new ArrayDeque();
        this.f3694H = new RunnableC0210e(5, this);
    }

    public static boolean C(Fragment fragment) {
        if (!fragment.mHasMenu || !fragment.mMenuVisible) {
            Iterator it = fragment.mChildFragmentManager.f3697c.e().iterator();
            boolean zC = false;
            while (it.hasNext()) {
                Fragment fragment2 = (Fragment) it.next();
                if (fragment2 != null) {
                    zC = C(fragment2);
                }
                if (zC) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean D(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        T t4 = fragment.mFragmentManager;
        return fragment.equals(t4.f3709r) && D(t4.f3708q);
    }

    public static void V(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final J1.D A() {
        Fragment fragment = this.f3708q;
        return fragment != null ? fragment.mFragmentManager.A() : this.f3711t;
    }

    public final void B(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        U(fragment);
    }

    public final boolean E() {
        return this.f3717z || this.f3687A;
    }

    public final void F(int i5, boolean z4) {
        HashMap map;
        F f5;
        if (this.f3706o == null && i5 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z4 || i5 != this.n) {
            this.n = i5;
            c0 c0Var = this.f3697c;
            Iterator it = ((ArrayList) c0Var.f3780a).iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = (HashMap) c0Var.f3781b;
                if (!zHasNext) {
                    break;
                }
                b0 b0Var = (b0) map.get(((Fragment) it.next()).mWho);
                if (b0Var != null) {
                    b0Var.k();
                }
            }
            for (b0 b0Var2 : map.values()) {
                if (b0Var2 != null) {
                    b0Var2.k();
                    Fragment fragment = b0Var2.f3773c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        c0Var.h(b0Var2);
                    }
                }
            }
            W();
            if (this.f3716y && (f5 = this.f3706o) != null && this.n == 7) {
                ((C0229y) f5).g.supportInvalidateOptionsMenu();
                this.f3716y = false;
            }
        }
    }

    public final void G() {
        if (this.f3706o == null) {
            return;
        }
        this.f3717z = false;
        this.f3687A = false;
        this.f3693G.f3729i = false;
        for (Fragment fragment : this.f3697c.f()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean H() {
        s(false);
        r(true);
        Fragment fragment = this.f3709r;
        if (fragment != null && fragment.getChildFragmentManager().H()) {
            return true;
        }
        boolean zI = I(this.f3690D, this.f3691E, -1, 0);
        if (zI) {
            this.f3696b = true;
            try {
                L(this.f3690D, this.f3691E);
            } finally {
                d();
            }
        }
        Y();
        if (this.f3689C) {
            this.f3689C = false;
            W();
        }
        ((HashMap) this.f3697c.f3781b).values().removeAll(Collections.singleton(null));
        return zI;
    }

    public final boolean I(ArrayList arrayList, ArrayList arrayList2, int i5, int i6) {
        int size;
        C0206a c0206a;
        ArrayList arrayList3 = this.f3698d;
        if (arrayList3 == null) {
            return false;
        }
        if (i5 >= 0 || (i6 & 1) != 0) {
            if (i5 >= 0) {
                size = arrayList3.size() - 1;
                while (size >= 0) {
                    C0206a c0206a2 = (C0206a) this.f3698d.get(size);
                    if (i5 >= 0 && i5 == c0206a2.f3756r) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i6 & 1) != 0) {
                    do {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        c0206a = (C0206a) this.f3698d.get(size);
                        if (i5 < 0) {
                            break;
                        }
                    } while (i5 == c0206a.f3756r);
                }
            } else {
                size = -1;
            }
            if (size == this.f3698d.size() - 1) {
                return false;
            }
            for (int size2 = this.f3698d.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f3698d.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        } else {
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                return false;
            }
            arrayList.add(this.f3698d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void J(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            X(new IllegalStateException(AbstractC0535a.k("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void K(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z4 = !fragment.isInBackStack();
        if (!fragment.mDetached || z4) {
            c0 c0Var = this.f3697c;
            synchronized (((ArrayList) c0Var.f3780a)) {
                ((ArrayList) c0Var.f3780a).remove(fragment);
            }
            fragment.mAdded = false;
            if (C(fragment)) {
                this.f3716y = true;
            }
            fragment.mRemoving = true;
            U(fragment);
        }
    }

    public final void L(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            if (!((C0206a) arrayList.get(i5)).f3753o) {
                if (i6 != i5) {
                    u(arrayList, arrayList2, i6, i5);
                }
                i6 = i5 + 1;
                if (((Boolean) arrayList2.get(i5)).booleanValue()) {
                    while (i6 < size && ((Boolean) arrayList2.get(i6)).booleanValue() && !((C0206a) arrayList.get(i6)).f3753o) {
                        i6++;
                    }
                }
                u(arrayList, arrayList2, i5, i6);
                i5 = i6 - 1;
            }
            i5++;
        }
        if (i6 != size) {
            u(arrayList, arrayList2, i6, size);
        }
    }

    public final void M(Parcelable parcelable) {
        int i5;
        A a2;
        int i6;
        b0 b0Var;
        if (parcelable == null) {
            return;
        }
        V v4 = (V) parcelable;
        if (v4.f3718j == null) {
            return;
        }
        c0 c0Var = this.f3697c;
        ((HashMap) c0Var.f3781b).clear();
        Iterator it = v4.f3718j.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            i5 = 2;
            a2 = this.f3704l;
            if (!zHasNext) {
                break;
            }
            Z z4 = (Z) it.next();
            if (z4 != null) {
                Fragment fragment = (Fragment) this.f3693G.f3726d.get(z4.f3731k);
                if (fragment != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    b0Var = new b0(a2, c0Var, fragment, z4);
                } else {
                    b0Var = new b0(this.f3704l, this.f3697c, this.f3706o.f3652d.getClassLoader(), z(), z4);
                }
                Fragment fragment2 = b0Var.f3773c;
                fragment2.mFragmentManager = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                b0Var.m(this.f3706o.f3652d.getClassLoader());
                c0Var.g(b0Var);
                b0Var.f3775e = this.n;
            }
        }
        W w4 = this.f3693G;
        w4.getClass();
        Iterator it2 = new ArrayList(w4.f3726d.values()).iterator();
        while (it2.hasNext()) {
            Fragment fragment3 = (Fragment) it2.next();
            if (!(((HashMap) c0Var.f3781b).get(fragment3.mWho) != null)) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + v4.f3718j);
                }
                this.f3693G.d(fragment3);
                fragment3.mFragmentManager = this;
                b0 b0Var2 = new b0(a2, c0Var, fragment3);
                b0Var2.f3775e = 1;
                b0Var2.k();
                fragment3.mRemoving = true;
                b0Var2.k();
            }
        }
        ArrayList<String> arrayList = v4.f3719k;
        ((ArrayList) c0Var.f3780a).clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                Fragment fragmentB = c0Var.b(str);
                if (fragmentB == null) {
                    throw new IllegalStateException(AbstractC0535a.l("No instantiated fragment for (", str, ")"));
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentB);
                }
                c0Var.a(fragmentB);
            }
        }
        Fragment fragment4 = null;
        if (v4.f3720l != null) {
            this.f3698d = new ArrayList(v4.f3720l.length);
            int i7 = 0;
            while (true) {
                C0207b[] c0207bArr = v4.f3720l;
                if (i7 >= c0207bArr.length) {
                    break;
                }
                C0207b c0207b = c0207bArr[i7];
                c0207b.getClass();
                C0206a c0206a = new C0206a(this);
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    int[] iArr = c0207b.f3758j;
                    if (i8 >= iArr.length) {
                        break;
                    }
                    d0 d0Var = new d0();
                    int i10 = i8 + 1;
                    d0Var.f3788a = iArr[i8];
                    if (Log.isLoggable("FragmentManager", i5)) {
                        Log.v("FragmentManager", "Instantiate " + c0206a + " op #" + i9 + " base fragment #" + iArr[i10]);
                    }
                    String str2 = (String) c0207b.f3759k.get(i9);
                    if (str2 != null) {
                        d0Var.f3789b = c0Var.b(str2);
                    } else {
                        d0Var.f3789b = fragment4;
                    }
                    d0Var.g = EnumC0244n.values()[c0207b.f3760l[i9]];
                    d0Var.h = EnumC0244n.values()[c0207b.f3761m[i9]];
                    int i11 = iArr[i10];
                    d0Var.f3790c = i11;
                    int i12 = iArr[i8 + 2];
                    d0Var.f3791d = i12;
                    int i13 = i8 + 4;
                    int i14 = iArr[i8 + 3];
                    d0Var.f3792e = i14;
                    i8 += 5;
                    int i15 = iArr[i13];
                    d0Var.f3793f = i15;
                    c0206a.f3743b = i11;
                    c0206a.f3744c = i12;
                    c0206a.f3745d = i14;
                    c0206a.f3746e = i15;
                    c0206a.b(d0Var);
                    i9++;
                    fragment4 = null;
                    i5 = 2;
                }
                c0206a.f3747f = c0207b.n;
                c0206a.h = c0207b.f3762o;
                c0206a.f3756r = c0207b.f3763p;
                c0206a.g = true;
                c0206a.f3748i = c0207b.f3764q;
                c0206a.f3749j = c0207b.f3765r;
                c0206a.f3750k = c0207b.f3766s;
                c0206a.f3751l = c0207b.f3767t;
                c0206a.f3752m = c0207b.f3768u;
                c0206a.n = c0207b.f3769v;
                c0206a.f3753o = c0207b.f3770w;
                c0206a.c(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("restoreAllState: back stack #", i7, " (index ");
                    sbF.append(c0206a.f3756r);
                    sbF.append("): ");
                    sbF.append(c0206a);
                    Log.v("FragmentManager", sbF.toString());
                    PrintWriter printWriter = new PrintWriter(new n0());
                    c0206a.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3698d.add(c0206a);
                i7++;
                i5 = 2;
                fragment4 = null;
            }
            i6 = 0;
        } else {
            i6 = 0;
            this.f3698d = null;
        }
        this.f3701i.set(v4.f3721m);
        String str3 = v4.n;
        if (str3 != null) {
            Fragment fragmentB2 = c0Var.b(str3);
            this.f3709r = fragmentB2;
            m(fragmentB2);
        }
        ArrayList arrayList2 = v4.f3722o;
        if (arrayList2 != null) {
            while (i6 < arrayList2.size()) {
                Bundle bundle = (Bundle) v4.f3723p.get(i6);
                bundle.setClassLoader(this.f3706o.f3652d.getClassLoader());
                this.f3702j.put(arrayList2.get(i6), bundle);
                i6++;
            }
        }
        this.f3715x = new ArrayDeque(v4.f3724q);
    }

    public final V N() {
        int i5;
        ArrayList arrayList;
        C0207b[] c0207bArr;
        int size;
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0215j c0215j = (C0215j) it.next();
            if (c0215j.f3824e) {
                c0215j.f3824e = false;
                c0215j.d();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((C0215j) it2.next()).g();
        }
        s(true);
        this.f3717z = true;
        this.f3693G.f3729i = true;
        c0 c0Var = this.f3697c;
        c0Var.getClass();
        HashMap map = (HashMap) c0Var.f3781b;
        ArrayList arrayList2 = new ArrayList(map.size());
        for (b0 b0Var : map.values()) {
            if (b0Var != null) {
                Fragment fragment = b0Var.f3773c;
                Z z4 = new Z(fragment);
                if (fragment.mState <= -1 || z4.f3741v != null) {
                    z4.f3741v = fragment.mSavedFragmentState;
                } else {
                    Bundle bundleO = b0Var.o();
                    z4.f3741v = bundleO;
                    if (fragment.mTargetWho != null) {
                        if (bundleO == null) {
                            z4.f3741v = new Bundle();
                        }
                        z4.f3741v.putString("android:target_state", fragment.mTargetWho);
                        int i6 = fragment.mTargetRequestCode;
                        if (i6 != 0) {
                            z4.f3741v.putInt("android:target_req_state", i6);
                        }
                    }
                }
                arrayList2.add(z4);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + z4.f3741v);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        c0 c0Var2 = this.f3697c;
        synchronized (((ArrayList) c0Var2.f3780a)) {
            try {
                if (((ArrayList) c0Var2.f3780a).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(((ArrayList) c0Var2.f3780a).size());
                    Iterator it3 = ((ArrayList) c0Var2.f3780a).iterator();
                    while (it3.hasNext()) {
                        Fragment fragment2 = (Fragment) it3.next();
                        arrayList.add(fragment2.mWho);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = this.f3698d;
        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
            c0207bArr = null;
        } else {
            c0207bArr = new C0207b[size];
            for (i5 = 0; i5 < size; i5++) {
                c0207bArr[i5] = new C0207b((C0206a) this.f3698d.get(i5));
                if (Log.isLoggable("FragmentManager", 2)) {
                    StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("saveAllState: adding back stack #", i5, ": ");
                    sbF.append(this.f3698d.get(i5));
                    Log.v("FragmentManager", sbF.toString());
                }
            }
        }
        V v4 = new V();
        v4.n = null;
        ArrayList arrayList4 = new ArrayList();
        v4.f3722o = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        v4.f3723p = arrayList5;
        v4.f3718j = arrayList2;
        v4.f3719k = arrayList;
        v4.f3720l = c0207bArr;
        v4.f3721m = this.f3701i.get();
        Fragment fragment3 = this.f3709r;
        if (fragment3 != null) {
            v4.n = fragment3.mWho;
        }
        arrayList4.addAll(this.f3702j.keySet());
        arrayList5.addAll(this.f3702j.values());
        v4.f3724q = new ArrayList(this.f3715x);
        return v4;
    }

    public final C0226v O(Fragment fragment) {
        Bundle bundleO;
        b0 b0Var = (b0) ((HashMap) this.f3697c.f3781b).get(fragment.mWho);
        if (b0Var != null) {
            Fragment fragment2 = b0Var.f3773c;
            if (fragment2.equals(fragment)) {
                if (fragment2.mState <= -1 || (bundleO = b0Var.o()) == null) {
                    return null;
                }
                return new C0226v(bundleO);
            }
        }
        X(new IllegalStateException(AbstractC0535a.k("Fragment ", fragment, " is not currently in the FragmentManager")));
        throw null;
    }

    public final void P() {
        synchronized (this.f3695a) {
            try {
                if (this.f3695a.size() == 1) {
                    this.f3706o.f3653e.removeCallbacks(this.f3694H);
                    this.f3706o.f3653e.post(this.f3694H);
                    Y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Q(Fragment fragment, boolean z4) {
        ViewGroup viewGroupY = y(fragment);
        if (viewGroupY == null || !(viewGroupY instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupY).setDrawDisappearingViewsLast(!z4);
    }

    public final void R(InterfaceC0249t interfaceC0249t, final C0579h c0579h) {
        final AbstractC0245o lifecycle = interfaceC0249t.getLifecycle();
        if (((C0251v) lifecycle).f3971c == EnumC0244n.f3961j) {
            return;
        }
        androidx.lifecycle.r rVar = new androidx.lifecycle.r() { // from class: androidx.fragment.app.FragmentManager$6

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ String f3660j = "message_details_result";

            @Override // androidx.lifecycle.r
            public final void a(InterfaceC0249t interfaceC0249t2, EnumC0243m enumC0243m) {
                Bundle bundle;
                EnumC0243m enumC0243m2 = EnumC0243m.ON_START;
                T t4 = this.f3663m;
                String str = this.f3660j;
                if (enumC0243m == enumC0243m2 && (bundle = (Bundle) t4.f3702j.get(str)) != null) {
                    c0579h.a(bundle, str);
                    t4.f3702j.remove(str);
                }
                if (enumC0243m == EnumC0243m.ON_DESTROY) {
                    lifecycle.b(this);
                    t4.f3703k.remove(str);
                }
            }
        };
        lifecycle.a(rVar);
        P p4 = (P) this.f3703k.put("message_details_result", new P(lifecycle, c0579h, rVar));
        if (p4 != null) {
            p4.f3681c.b(p4.f3683e);
        }
    }

    public final void S(Fragment fragment, EnumC0244n enumC0244n) {
        if (fragment.equals(this.f3697c.b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = enumC0244n;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void T(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f3697c.b(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.f3709r;
        this.f3709r = fragment;
        m(fragment2);
        m(this.f3709r);
    }

    public final void U(Fragment fragment) {
        ViewGroup viewGroupY = y(fragment);
        if (viewGroupY != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (viewGroupY.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupY.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) viewGroupY.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void W() {
        Iterator it = this.f3697c.d().iterator();
        while (it.hasNext()) {
            b0 b0Var = (b0) it.next();
            Fragment fragment = b0Var.f3773c;
            if (fragment.mDeferStart) {
                if (this.f3696b) {
                    this.f3689C = true;
                } else {
                    fragment.mDeferStart = false;
                    b0Var.k();
                }
            }
        }
    }

    public final void X(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new n0());
        F f5 = this.f3706o;
        if (f5 == null) {
            try {
                p("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e5) {
                Log.e("FragmentManager", "Failed dumping state", e5);
                throw illegalStateException;
            }
        }
        try {
            ((C0229y) f5).g.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e6) {
            Log.e("FragmentManager", "Failed dumping state", e6);
            throw illegalStateException;
        }
    }

    public final void Y() {
        synchronized (this.f3695a) {
            try {
                if (!this.f3695a.isEmpty()) {
                    K k5 = this.h;
                    k5.f3671a = true;
                    E3.a aVar = k5.f3673c;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    return;
                }
                K k6 = this.h;
                ArrayList arrayList = this.f3698d;
                k6.f3671a = (arrayList != null ? arrayList.size() : 0) > 0 && D(this.f3708q);
                E3.a aVar2 = k6.f3673c;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final b0 a(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        b0 b0VarF = f(fragment);
        fragment.mFragmentManager = this;
        c0 c0Var = this.f3697c;
        c0Var.g(b0VarF);
        if (!fragment.mDetached) {
            c0Var.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (C(fragment)) {
                this.f3716y = true;
            }
        }
        return b0VarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(F f5, D d5, Fragment fragment) {
        if (this.f3706o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3706o = f5;
        this.f3707p = d5;
        this.f3708q = fragment;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f3705m;
        if (fragment != null) {
            copyOnWriteArrayList.add(new M(fragment));
        } else if (f5 instanceof X) {
            copyOnWriteArrayList.add((X) f5);
        }
        if (this.f3708q != null) {
            Y();
        }
        if (f5 instanceof androidx.activity.v) {
            androidx.activity.v vVar = (androidx.activity.v) f5;
            androidx.activity.u onBackPressedDispatcher = vVar.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher;
            InterfaceC0249t interfaceC0249t = vVar;
            if (fragment != null) {
                interfaceC0249t = fragment;
            }
            onBackPressedDispatcher.a(interfaceC0249t, this.h);
        }
        if (fragment != null) {
            W w4 = fragment.mFragmentManager.f3693G;
            HashMap map = w4.f3727e;
            W w5 = (W) map.get(fragment.mWho);
            if (w5 == null) {
                w5 = new W(w4.g);
                map.put(fragment.mWho, w5);
            }
            this.f3693G = w5;
        } else if (f5 instanceof androidx.lifecycle.X) {
            this.f3693G = (W) new C0513e(((androidx.lifecycle.X) f5).getViewModelStore(), W.f3725j).c(W.class);
        } else {
            this.f3693G = new W(false);
        }
        this.f3693G.f3729i = E();
        this.f3697c.f3782c = this.f3693G;
        Object obj = this.f3706o;
        if (obj instanceof androidx.activity.result.h) {
            androidx.activity.result.g activityResultRegistry = ((androidx.activity.result.h) obj).getActivityResultRegistry();
            String strS = com.unified.ur1.SatelliteTracker.h.s("FragmentManager:", fragment != null ? com.unified.ur1.SatelliteTracker.h.e(new StringBuilder(), fragment.mWho, ":") : "");
            this.f3712u = activityResultRegistry.d(com.unified.ur1.SatelliteTracker.h.b(strS, "StartActivityForResult"), new N(2), new J(this, 2));
            this.f3713v = activityResultRegistry.d(com.unified.ur1.SatelliteTracker.h.b(strS, "StartIntentSenderForResult"), new N(0), new J(this, 0));
            this.f3714w = activityResultRegistry.d(com.unified.ur1.SatelliteTracker.h.b(strS, "RequestPermissions"), new N(1), new J(this, 1));
        }
    }

    public final void c(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f3697c.a(fragment);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (C(fragment)) {
                this.f3716y = true;
            }
        }
    }

    public final void d() {
        this.f3696b = false;
        this.f3691E.clear();
        this.f3690D.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f3697c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((b0) it.next()).f3773c.mContainer;
            if (viewGroup != null) {
                hashSet.add(C0215j.h(viewGroup, A()));
            }
        }
        return hashSet;
    }

    public final b0 f(Fragment fragment) {
        String str = fragment.mWho;
        c0 c0Var = this.f3697c;
        b0 b0Var = (b0) ((HashMap) c0Var.f3781b).get(str);
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0(this.f3704l, c0Var, fragment);
        b0Var2.m(this.f3706o.f3652d.getClassLoader());
        b0Var2.f3775e = this.n;
        return b0Var2;
    }

    public final void g(Fragment fragment) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            c0 c0Var = this.f3697c;
            synchronized (((ArrayList) c0Var.f3780a)) {
                ((ArrayList) c0Var.f3780a).remove(fragment);
            }
            fragment.mAdded = false;
            if (C(fragment)) {
                this.f3716y = true;
            }
            U(fragment);
        }
    }

    public final boolean h(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f3697c.f()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(Menu menu, MenuInflater menuInflater) {
        if (this.n < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z4 = false;
        for (Fragment fragment : this.f3697c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z4 = true;
            }
        }
        if (this.f3699e != null) {
            for (int i5 = 0; i5 < this.f3699e.size(); i5++) {
                Fragment fragment2 = (Fragment) this.f3699e.get(i5);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f3699e = arrayList;
        return z4;
    }

    public final void j() {
        this.f3688B = true;
        s(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((C0215j) it.next()).g();
        }
        o(-1);
        this.f3706o = null;
        this.f3707p = null;
        this.f3708q = null;
        if (this.g != null) {
            Iterator it2 = this.h.f3672b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.c) it2.next()).cancel();
            }
            this.g = null;
        }
        androidx.activity.result.d dVar = this.f3712u;
        if (dVar != null) {
            dVar.b();
            this.f3713v.b();
            this.f3714w.b();
        }
    }

    public final boolean k(MenuItem menuItem) {
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f3697c.f()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void l(Menu menu) {
        if (this.n < 1) {
            return;
        }
        for (Fragment fragment : this.f3697c.f()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void m(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f3697c.b(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final boolean n(Menu menu) {
        boolean z4 = false;
        if (this.n < 1) {
            return false;
        }
        for (Fragment fragment : this.f3697c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z4 = true;
            }
        }
        return z4;
    }

    public final void o(int i5) {
        try {
            this.f3696b = true;
            for (b0 b0Var : ((HashMap) this.f3697c.f3781b).values()) {
                if (b0Var != null) {
                    b0Var.f3775e = i5;
                }
            }
            F(i5, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((C0215j) it.next()).g();
            }
            this.f3696b = false;
            s(true);
        } catch (Throwable th) {
            this.f3696b = false;
            throw th;
        }
    }

    public final void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strB = com.unified.ur1.SatelliteTracker.h.b(str, "    ");
        c0 c0Var = this.f3697c;
        c0Var.getClass();
        String str2 = str + "    ";
        HashMap map = (HashMap) c0Var.f3781b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (b0 b0Var : map.values()) {
                printWriter.print(str);
                if (b0Var != null) {
                    Fragment fragment = b0Var.f3773c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) c0Var.f3780a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i5 = 0; i5 < size3; i5++) {
                Fragment fragment2 = (Fragment) arrayList.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.f3699e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i6 = 0; i6 < size2; i6++) {
                Fragment fragment3 = (Fragment) this.f3699e.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.f3698d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i7 = 0; i7 < size; i7++) {
                C0206a c0206a = (C0206a) this.f3698d.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(c0206a.toString());
                c0206a.f(strB, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3701i.get());
        synchronized (this.f3695a) {
            try {
                int size4 = this.f3695a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i8 = 0; i8 < size4; i8++) {
                        Object obj = (Q) this.f3695a.get(i8);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i8);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3706o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3707p);
        if (this.f3708q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3708q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3717z);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3687A);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3688B);
        if (this.f3716y) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3716y);
        }
    }

    public final void q(Q q4, boolean z4) {
        if (!z4) {
            if (this.f3706o == null) {
                if (!this.f3688B) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (E()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f3695a) {
            try {
                if (this.f3706o == null) {
                    if (!z4) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f3695a.add(q4);
                    P();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r(boolean z4) {
        if (this.f3696b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3706o == null) {
            if (!this.f3688B) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3706o.f3653e.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z4 && E()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3690D == null) {
            this.f3690D = new ArrayList();
            this.f3691E = new ArrayList();
        }
        this.f3696b = false;
    }

    public final boolean s(boolean z4) {
        boolean zA;
        r(z4);
        boolean z5 = false;
        while (true) {
            ArrayList arrayList = this.f3690D;
            ArrayList arrayList2 = this.f3691E;
            synchronized (this.f3695a) {
                try {
                    if (this.f3695a.isEmpty()) {
                        zA = false;
                    } else {
                        int size = this.f3695a.size();
                        zA = false;
                        for (int i5 = 0; i5 < size; i5++) {
                            zA |= ((Q) this.f3695a.get(i5)).a(arrayList, arrayList2);
                        }
                        this.f3695a.clear();
                        this.f3706o.f3653e.removeCallbacks(this.f3694H);
                    }
                } finally {
                }
            }
            if (!zA) {
                break;
            }
            z5 = true;
            this.f3696b = true;
            try {
                L(this.f3690D, this.f3691E);
            } finally {
                d();
            }
        }
        Y();
        if (this.f3689C) {
            this.f3689C = false;
            W();
        }
        ((HashMap) this.f3697c.f3781b).values().removeAll(Collections.singleton(null));
        return z5;
    }

    public final void t(Q q4, boolean z4) {
        if (z4 && (this.f3706o == null || this.f3688B)) {
            return;
        }
        r(z4);
        if (q4.a(this.f3690D, this.f3691E)) {
            this.f3696b = true;
            try {
                L(this.f3690D, this.f3691E);
            } finally {
                d();
            }
        }
        Y();
        if (this.f3689C) {
            this.f3689C = false;
            W();
        }
        ((HashMap) this.f3697c.f3781b).values().removeAll(Collections.singleton(null));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3708q;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3708q)));
            sb.append("}");
        } else {
            F f5 = this.f3706o;
            if (f5 != null) {
                sb.append(f5.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3706o)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.util.ArrayList r21, java.util.ArrayList r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.T.u(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final void v(ArrayList arrayList, ArrayList arrayList2) {
    }

    public final Fragment w(int i5) {
        c0 c0Var = this.f3697c;
        ArrayList arrayList = (ArrayList) c0Var.f3780a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i5) {
                return fragment;
            }
        }
        for (b0 b0Var : ((HashMap) c0Var.f3781b).values()) {
            if (b0Var != null) {
                Fragment fragment2 = b0Var.f3773c;
                if (fragment2.mFragmentId == i5) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment x(String str) {
        c0 c0Var = this.f3697c;
        ArrayList arrayList = (ArrayList) c0Var.f3780a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && str.equals(fragment.mTag)) {
                return fragment;
            }
        }
        for (b0 b0Var : ((HashMap) c0Var.f3781b).values()) {
            if (b0Var != null) {
                Fragment fragment2 = b0Var.f3773c;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final ViewGroup y(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f3707p.c()) {
            View viewB = this.f3707p.b(fragment.mContainerId);
            if (viewB instanceof ViewGroup) {
                return (ViewGroup) viewB;
            }
        }
        return null;
    }

    public final L z() {
        Fragment fragment = this.f3708q;
        return fragment != null ? fragment.mFragmentManager.z() : this.f3710s;
    }
}
