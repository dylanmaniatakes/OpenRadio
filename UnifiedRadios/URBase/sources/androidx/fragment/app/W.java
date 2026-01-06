package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class W extends androidx.lifecycle.S {

    /* renamed from: j, reason: collision with root package name */
    public static final J1.C f3725j = new J1.C(26);
    public final boolean g;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f3726d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f3727e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f3728f = new HashMap();
    public boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3729i = false;

    public W(boolean z4) {
        this.g = z4;
    }

    @Override // androidx.lifecycle.S
    public final void b() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.h = true;
    }

    public final void c(Fragment fragment) {
        if (this.f3729i) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap map = this.f3726d;
        if (map.containsKey(fragment.mWho)) {
            return;
        }
        map.put(fragment.mWho, fragment);
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void d(Fragment fragment) {
        if (this.f3729i) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f3726d.remove(fragment.mWho) == null || !Log.isLoggable("FragmentManager", 2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || W.class != obj.getClass()) {
            return false;
        }
        W w4 = (W) obj;
        return this.f3726d.equals(w4.f3726d) && this.f3727e.equals(w4.f3727e) && this.f3728f.equals(w4.f3728f);
    }

    public final int hashCode() {
        return this.f3728f.hashCode() + ((this.f3727e.hashCode() + (this.f3726d.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f3726d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f3727e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f3728f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
