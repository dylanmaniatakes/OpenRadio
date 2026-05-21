package q1;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import n1.C0788e;

/* renamed from: q1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0858i extends AbstractC0854e implements o1.c {

    /* renamed from: y, reason: collision with root package name */
    public final Set f9388y;

    /* renamed from: z, reason: collision with root package name */
    public final Account f9389z;

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC0858i(Context context, Looper looper, int i5, D0.w wVar, o1.i iVar, o1.j jVar) {
        P pA = P.a(context);
        C0788e c0788e = C0788e.f8738d;
        E.i(iVar);
        E.i(jVar);
        super(context, looper, pA, c0788e, i5, new C0863n(iVar), new C0863n(jVar), (String) wVar.f313f);
        this.f9389z = (Account) wVar.f309b;
        Set set = (Set) wVar.f311d;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f9388y = set;
    }

    @Override // o1.c
    public final Set d() {
        return m() ? this.f9388y : Collections.emptySet();
    }

    @Override // q1.AbstractC0854e
    public final Account p() {
        return this.f9389z;
    }

    @Override // q1.AbstractC0854e
    public final Set s() {
        return this.f9388y;
    }
}
