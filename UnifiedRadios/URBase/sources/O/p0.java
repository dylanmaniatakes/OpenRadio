package O;

import J1.P0;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class p0 extends WindowInsetsAnimation$Callback {

    /* renamed from: a, reason: collision with root package name */
    public final V1.e f1951a;

    /* renamed from: b, reason: collision with root package name */
    public List f1952b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f1953c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f1954d;

    public p0(V1.e eVar) {
        super(0);
        this.f1954d = new HashMap();
        this.f1951a = eVar;
    }

    public final s0 a(WindowInsetsAnimation windowInsetsAnimation) {
        s0 s0Var = (s0) this.f1954d.get(windowInsetsAnimation);
        if (s0Var == null) {
            s0Var = new s0(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                s0Var.f1965a = new q0(windowInsetsAnimation);
            }
            this.f1954d.put(windowInsetsAnimation, s0Var);
        }
        return s0Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        V1.e eVar = this.f1951a;
        a(windowInsetsAnimation);
        ((View) eVar.f2532d).setTranslationY(BitmapDescriptorFactory.HUE_RED);
        this.f1954d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        V1.e eVar = this.f1951a;
        a(windowInsetsAnimation);
        View view = (View) eVar.f2532d;
        int[] iArr = (int[]) eVar.f2533e;
        view.getLocationOnScreen(iArr);
        eVar.f2529a = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f1953c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f1953c = arrayList2;
            this.f1952b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationM = P0.m(list.get(size));
            s0 s0VarA = a(windowInsetsAnimationM);
            s0VarA.f1965a.d(windowInsetsAnimationM.getFraction());
            this.f1953c.add(s0VarA);
        }
        V1.e eVar = this.f1951a;
        F0 f0G = F0.g(null, windowInsets);
        eVar.e(f0G, this.f1952b);
        return f0G.f();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        V1.e eVar = this.f1951a;
        a(windowInsetsAnimation);
        E.c cVarC = E.c.c(bounds.getLowerBound());
        E.c cVarC2 = E.c.c(bounds.getUpperBound());
        View view = (View) eVar.f2532d;
        int[] iArr = (int[]) eVar.f2533e;
        view.getLocationOnScreen(iArr);
        int i5 = eVar.f2529a - iArr[1];
        eVar.f2530b = i5;
        view.setTranslationY(i5);
        P0.p();
        return P0.k(cVarC.d(), cVarC2.d());
    }
}
