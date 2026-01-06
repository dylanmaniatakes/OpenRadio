package C0;

import N3.C0131e;
import N3.InterfaceC0130d;
import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import i0.C0565b;
import java.util.concurrent.CancellationException;
import s3.C0900j;

/* loaded from: classes.dex */
public final class m extends F3.j implements E3.l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f163j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f164k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i5, Object obj) {
        super(1);
        this.f163j = i5;
        this.f164k = obj;
    }

    @Override // E3.l
    public final Object invoke(Object obj) {
        switch (this.f163j) {
            case 0:
                Throwable th = (Throwable) obj;
                n nVar = (n) this.f164k;
                if (th == null) {
                    if (!nVar.f165j.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else if (th instanceof CancellationException) {
                    nVar.f165j.cancel(true);
                } else {
                    N0.k kVar = nVar.f165j;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    kVar.k(th);
                }
                return C0900j.f9694a;
            case 1:
                J3.c cVar = (J3.c) obj;
                F3.i.f(cVar, "it");
                CharSequence charSequence = (CharSequence) this.f164k;
                F3.i.f(charSequence, "<this>");
                return charSequence.subSequence(cVar.f1475j, cVar.f1476k + 1).toString();
            case 2:
                C0900j c0900j = C0900j.f9694a;
                ((C0131e) ((InterfaceC0130d) this.f164k)).resumeWith(c0900j);
                return c0900j;
            case 3:
                F3.i.f((Context) obj, "it");
                Context context = (Context) this.f164k;
                F3.i.f(context, "context");
                MeasurementManager measurementManager = MeasurementManager.get(context);
                F3.i.e(measurementManager, "get(context)");
                return new C0565b(measurementManager);
            default:
                return obj == ((t3.c) this.f164k) ? "(this Collection)" : String.valueOf(obj);
        }
    }
}
