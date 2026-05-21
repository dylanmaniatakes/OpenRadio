package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.util.Set;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f4209a;

    /* renamed from: b, reason: collision with root package name */
    public int f4210b;

    /* renamed from: c, reason: collision with root package name */
    public Set f4211c;

    public final b0 a(int i5) {
        SparseArray sparseArray = this.f4209a;
        b0 b0Var = (b0) sparseArray.get(i5);
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0();
        sparseArray.put(i5, b0Var2);
        return b0Var2;
    }
}
