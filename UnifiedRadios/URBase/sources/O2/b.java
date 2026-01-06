package O2;

import F2.r;
import F2.t;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements F2.e {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2024c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r f2025d;

    public /* synthetic */ b(r rVar, int i5) {
        this.f2024c = i5;
        this.f2025d = rVar;
    }

    @Override // F2.e
    public final Object b(t tVar) {
        switch (this.f2024c) {
            case 0:
                return new d((Context) tVar.a(Context.class), ((A2.g) tVar.a(A2.g.class)).c(), tVar.b(r.a(e.class)), tVar.e(Z2.b.class), (Executor) tVar.c(this.f2025d));
            default:
                return FirebaseMessagingRegistrar.lambda$getComponents$0(this.f2025d, tVar);
        }
    }
}
