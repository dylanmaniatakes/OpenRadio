package D0;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f248a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f249b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f250c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f251d;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i5) {
        this.f248a = i5;
        this.f249b = obj;
        this.f250c = obj2;
        this.f251d = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f248a) {
            case 0:
                WorkDatabase workDatabase = ((h) this.f249b).f265e;
                L0.s sVarW = workDatabase.w();
                String str = (String) this.f251d;
                ((ArrayList) this.f250c).addAll(sVarW.i(str));
                return workDatabase.v().h(str);
            default:
                G2.f fVar = (G2.f) this.f249b;
                fVar.getClass();
                return fVar.f631j.submit(new D.m((Callable) this.f250c, 6, (B0.l) this.f251d));
        }
    }
}
