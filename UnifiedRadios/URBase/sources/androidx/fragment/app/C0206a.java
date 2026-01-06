package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.EnumC0244n;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0206a implements Q {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3742a;

    /* renamed from: b, reason: collision with root package name */
    public int f3743b;

    /* renamed from: c, reason: collision with root package name */
    public int f3744c;

    /* renamed from: d, reason: collision with root package name */
    public int f3745d;

    /* renamed from: e, reason: collision with root package name */
    public int f3746e;

    /* renamed from: f, reason: collision with root package name */
    public int f3747f;
    public boolean g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public int f3748i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f3749j;

    /* renamed from: k, reason: collision with root package name */
    public int f3750k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f3751l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f3752m;
    public ArrayList n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3753o;

    /* renamed from: p, reason: collision with root package name */
    public final T f3754p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3755q;

    /* renamed from: r, reason: collision with root package name */
    public int f3756r;

    public C0206a(T t4) {
        t4.z();
        F f5 = t4.f3706o;
        if (f5 != null) {
            f5.f3652d.getClassLoader();
        }
        this.f3742a = new ArrayList();
        this.f3753o = false;
        this.f3756r = -1;
        this.f3754p = t4;
    }

    @Override // androidx.fragment.app.Q
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        T t4 = this.f3754p;
        if (t4.f3698d == null) {
            t4.f3698d = new ArrayList();
        }
        t4.f3698d.add(this);
        return true;
    }

    public final void b(d0 d0Var) {
        this.f3742a.add(d0Var);
        d0Var.f3790c = this.f3743b;
        d0Var.f3791d = this.f3744c;
        d0Var.f3792e = this.f3745d;
        d0Var.f3793f = this.f3746e;
    }

    public final void c(int i5) {
        if (this.g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i5);
            }
            ArrayList arrayList = this.f3742a;
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                d0 d0Var = (d0) arrayList.get(i6);
                Fragment fragment = d0Var.f3789b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i5;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Bump nesting of " + d0Var.f3789b + " to " + d0Var.f3789b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int d(boolean z4) {
        if (this.f3755q) {
            throw new IllegalStateException("commit already called");
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new n0());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.f3755q = true;
        boolean z5 = this.g;
        T t4 = this.f3754p;
        if (z5) {
            this.f3756r = t4.f3701i.getAndIncrement();
        } else {
            this.f3756r = -1;
        }
        t4.q(this, z4);
        return this.f3756r;
    }

    public final void e(int i5, Fragment fragment, String str, int i6) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i5 != 0) {
            if (i5 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i7 = fragment.mFragmentId;
            if (i7 != 0 && i7 != i5) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i5);
            }
            fragment.mFragmentId = i5;
            fragment.mContainerId = i5;
        }
        b(new d0(fragment, i6));
        fragment.mFragmentManager = this.f3754p;
    }

    public final void f(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3756r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3755q);
            if (this.f3747f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3747f));
            }
            if (this.f3743b != 0 || this.f3744c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3743b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3744c));
            }
            if (this.f3745d != 0 || this.f3746e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3745d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3746e));
            }
            if (this.f3748i != 0 || this.f3749j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3748i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3749j);
            }
            if (this.f3750k != 0 || this.f3751l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3750k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3751l);
            }
        }
        ArrayList arrayList = this.f3742a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            d0 d0Var = (d0) arrayList.get(i5);
            switch (d0Var.f3788a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + d0Var.f3788a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i5);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(d0Var.f3789b);
            if (z4) {
                if (d0Var.f3790c != 0 || d0Var.f3791d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(d0Var.f3790c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(d0Var.f3791d));
                }
                if (d0Var.f3792e != 0 || d0Var.f3793f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(d0Var.f3792e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(d0Var.f3793f));
                }
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f3742a;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            d0 d0Var = (d0) arrayList.get(i5);
            Fragment fragment = d0Var.f3789b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f3747f);
                fragment.setSharedElementNames(this.f3752m, this.n);
            }
            int i6 = d0Var.f3788a;
            T t4 = this.f3754p;
            switch (i6) {
                case 1:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.Q(fragment, false);
                    t4.a(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + d0Var.f3788a);
                case 3:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.K(fragment);
                    break;
                case 4:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.B(fragment);
                    break;
                case 5:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.Q(fragment, false);
                    T.V(fragment);
                    break;
                case 6:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.g(fragment);
                    break;
                case 7:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.Q(fragment, false);
                    t4.c(fragment);
                    break;
                case 8:
                    t4.T(fragment);
                    break;
                case 9:
                    t4.T(null);
                    break;
                case 10:
                    t4.S(fragment, d0Var.h);
                    break;
            }
        }
    }

    public final void h() {
        ArrayList arrayList = this.f3742a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d0 d0Var = (d0) arrayList.get(size);
            Fragment fragment = d0Var.f3789b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                int i5 = this.f3747f;
                fragment.setNextTransition(i5 != 4097 ? i5 != 4099 ? i5 != 8194 ? 0 : 4097 : 4099 : 8194);
                fragment.setSharedElementNames(this.n, this.f3752m);
            }
            int i6 = d0Var.f3788a;
            T t4 = this.f3754p;
            switch (i6) {
                case 1:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.Q(fragment, true);
                    t4.K(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + d0Var.f3788a);
                case 3:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.a(fragment);
                    break;
                case 4:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.getClass();
                    T.V(fragment);
                    break;
                case 5:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.Q(fragment, true);
                    t4.B(fragment);
                    break;
                case 6:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.c(fragment);
                    break;
                case 7:
                    fragment.setAnimations(d0Var.f3790c, d0Var.f3791d, d0Var.f3792e, d0Var.f3793f);
                    t4.Q(fragment, true);
                    t4.g(fragment);
                    break;
                case 8:
                    t4.T(null);
                    break;
                case 9:
                    t4.T(fragment);
                    break;
                case 10:
                    t4.S(fragment, d0Var.g);
                    break;
            }
        }
    }

    public final void i(Fragment fragment) {
        T t4 = fragment.mFragmentManager;
        if (t4 == null || t4 == this.f3754p) {
            b(new d0(fragment, 3));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final void j(Fragment fragment, EnumC0244n enumC0244n) {
        T t4 = fragment.mFragmentManager;
        T t5 = this.f3754p;
        if (t4 != t5) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + t5);
        }
        if (enumC0244n == EnumC0244n.f3962k && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + enumC0244n + " after the Fragment has been created");
        }
        if (enumC0244n == EnumC0244n.f3961j) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + enumC0244n + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        d0 d0Var = new d0();
        d0Var.f3788a = 10;
        d0Var.f3789b = fragment;
        d0Var.g = fragment.mMaxState;
        d0Var.h = enumC0244n;
        b(d0Var);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3756r >= 0) {
            sb.append(" #");
            sb.append(this.f3756r);
        }
        if (this.h != null) {
            sb.append(" ");
            sb.append(this.h);
        }
        sb.append("}");
        return sb.toString();
    }
}
