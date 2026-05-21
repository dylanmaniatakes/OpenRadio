package X0;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: j, reason: collision with root package name */
    public static final x f2745j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ x[] f2746k;

    static {
        x xVar = new x("DEFAULT", 0);
        f2745j = xVar;
        x xVar2 = new x("UNMETERED_ONLY", 1);
        x xVar3 = new x("UNMETERED_OR_DAILY", 2);
        x xVar4 = new x("FAST_IF_RADIO_AWAKE", 3);
        x xVar5 = new x("NEVER", 4);
        x xVar6 = new x("UNRECOGNIZED", 5);
        f2746k = new x[]{xVar, xVar2, xVar3, xVar4, xVar5, xVar6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, xVar);
        sparseArray.put(1, xVar2);
        sparseArray.put(2, xVar3);
        sparseArray.put(3, xVar4);
        sparseArray.put(4, xVar5);
        sparseArray.put(-1, xVar6);
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f2746k.clone();
    }
}
