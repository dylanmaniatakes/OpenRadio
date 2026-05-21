package H0;

import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import s3.InterfaceC0891a;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public final class h extends y3.i implements InterfaceC0891a {

    /* renamed from: k, reason: collision with root package name */
    public int f653k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Q3.f f654l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object[] f655m;

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        c cVar;
        c cVar2;
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f653k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            Q3.f fVar = this.f654l;
            c[] cVarArr = (c[]) this.f655m;
            int length = cVarArr.length;
            int i6 = 0;
            while (true) {
                cVar = a.f644a;
                if (i6 >= length) {
                    cVar2 = null;
                    break;
                }
                cVar2 = cVarArr[i6];
                if (!F3.i.a(cVar2, cVar)) {
                    break;
                }
                i6++;
            }
            if (cVar2 != null) {
                cVar = cVar2;
            }
            this.f653k = 1;
            if (fVar.a(cVar, this) == enumC0973a) {
                return enumC0973a;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0399v1.j(obj);
        }
        return C0900j.f9694a;
    }
}
