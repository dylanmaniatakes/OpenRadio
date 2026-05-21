package w0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name */
    public final View f10114b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10113a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f10115c = new ArrayList();

    public v(View view) {
        this.f10114b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f10114b == vVar.f10114b && this.f10113a.equals(vVar.f10113a);
    }

    public final int hashCode() {
        return this.f10113a.hashCode() + (this.f10114b.hashCode() * 31);
    }

    public final String toString() {
        String strB = com.unified.ur1.SatelliteTracker.h.b(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f10114b + "\n", "    values:");
        HashMap map = this.f10113a;
        for (String str : map.keySet()) {
            strB = strB + "    " + str + ": " + map.get(str) + "\n";
        }
        return strB;
    }
}
