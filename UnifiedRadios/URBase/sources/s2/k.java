package s2;

import android.content.res.TypedArray;
import android.util.SparseArray;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f9606a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final l f9607b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9608c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9609d;

    public k(l lVar, L0.m mVar) {
        this.f9607b = lVar;
        TypedArray typedArray = (TypedArray) mVar.f1557e;
        this.f9608c = typedArray.getResourceId(28, 0);
        this.f9609d = typedArray.getResourceId(52, 0);
    }
}
