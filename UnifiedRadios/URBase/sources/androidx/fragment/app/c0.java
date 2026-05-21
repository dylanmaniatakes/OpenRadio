package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class c0 implements K.c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3780a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3781b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3782c;

    public c0() {
        this.f3780a = new ArrayList();
        this.f3781b = new HashMap();
    }

    public void a(Fragment fragment) {
        if (((ArrayList) this.f3780a).contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (((ArrayList) this.f3780a)) {
            ((ArrayList) this.f3780a).add(fragment);
        }
        fragment.mAdded = true;
    }

    public Fragment b(String str) {
        b0 b0Var = (b0) ((HashMap) this.f3781b).get(str);
        if (b0Var != null) {
            return b0Var.f3773c;
        }
        return null;
    }

    public Fragment c(String str) {
        Fragment fragmentFindFragmentByWho;
        for (b0 b0Var : ((HashMap) this.f3781b).values()) {
            if (b0Var != null && (fragmentFindFragmentByWho = b0Var.f3773c.findFragmentByWho(str)) != null) {
                return fragmentFindFragmentByWho;
            }
        }
        return null;
    }

    public ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : ((HashMap) this.f3781b).values()) {
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        return arrayList;
    }

    public ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (b0 b0Var : ((HashMap) this.f3781b).values()) {
            if (b0Var != null) {
                arrayList.add(b0Var.f3773c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List f() {
        ArrayList arrayList;
        if (((ArrayList) this.f3780a).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.f3780a)) {
            arrayList = new ArrayList((ArrayList) this.f3780a);
        }
        return arrayList;
    }

    public void g(b0 b0Var) {
        Fragment fragment = b0Var.f3773c;
        String str = fragment.mWho;
        HashMap map = (HashMap) this.f3781b;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, b0Var);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                ((W) this.f3782c).c(fragment);
            } else {
                ((W) this.f3782c).d(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void h(b0 b0Var) {
        Fragment fragment = b0Var.f3773c;
        if (fragment.mRetainInstance) {
            ((W) this.f3782c).d(fragment);
        }
        if (((b0) ((HashMap) this.f3781b).put(fragment.mWho, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    @Override // K.c
    public void onCancel() {
        View view = (View) this.f3780a;
        view.clearAnimation();
        ((ViewGroup) this.f3781b).endViewTransition(view);
        ((C0212g) this.f3782c).a();
    }

    public c0(View view, ViewGroup viewGroup, C0212g c0212g) {
        this.f3780a = view;
        this.f3781b = viewGroup;
        this.f3782c = c0212g;
    }
}
