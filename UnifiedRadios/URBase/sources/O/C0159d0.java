package O;

import a.AbstractC0203a;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* renamed from: O.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0159d0 extends y3.h implements E3.p {

    /* renamed from: k, reason: collision with root package name */
    public int f1920k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f1921l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f1922m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0159d0(View view, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f1922m = view;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((C0159d0) create((L3.d) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        C0159d0 c0159d0 = new C0159d0(this.f1922m, interfaceC0936d);
        c0159d0.f1921l = obj;
        return c0159d0;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3 = EnumC0973a.f10448j;
        int i5 = this.f1920k;
        View view = this.f1922m;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            L3.d dVar = (L3.d) this.f1921l;
            this.f1921l = dVar;
            this.f1920k = 1;
            dVar.f1630k = view;
            dVar.f1629j = 3;
            dVar.f1632m = this;
            return obj3;
        }
        Object obj4 = C0900j.f9694a;
        if (i5 == 1) {
            L3.d dVar2 = (L3.d) this.f1921l;
            AbstractC0399v1.j(obj);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                F3.i.f(viewGroup, "<this>");
                C0157c0 c0157c0 = new C0157c0(viewGroup, null);
                this.f1921l = null;
                this.f1920k = 2;
                dVar2.getClass();
                L3.d dVar3 = new L3.d();
                dVar3.f1632m = AbstractC0203a.e(c0157c0, dVar3, dVar3);
                if (dVar3.hasNext()) {
                    dVar2.f1631l = dVar3;
                    dVar2.f1629j = 2;
                    dVar2.f1632m = this;
                    obj2 = obj3;
                } else {
                    obj2 = obj4;
                }
                if (obj2 != obj3) {
                    obj2 = obj4;
                }
                if (obj2 == obj3) {
                    return obj3;
                }
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0399v1.j(obj);
        }
        return obj4;
    }
}
