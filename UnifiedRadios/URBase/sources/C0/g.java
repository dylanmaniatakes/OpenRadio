package C0;

import N3.InterfaceC0144s;
import androidx.work.CoroutineWorker;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public final class g extends y3.i implements E3.p {

    /* renamed from: k, reason: collision with root package name */
    public int f154k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ CoroutineWorker f155l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CoroutineWorker coroutineWorker, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f155l = coroutineWorker;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((g) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new g(this.f155l, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f154k;
        CoroutineWorker coroutineWorker = this.f155l;
        try {
            if (i5 == 0) {
                AbstractC0399v1.j(obj);
                this.f154k = 1;
                obj = coroutineWorker.f();
                if (obj == enumC0973a) {
                    return enumC0973a;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC0399v1.j(obj);
            }
            coroutineWorker.h.j((r) obj);
        } catch (Throwable th) {
            coroutineWorker.h.k(th);
        }
        return C0900j.f9694a;
    }
}
