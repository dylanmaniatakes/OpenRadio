package O;

import a.AbstractC0203a;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* renamed from: O.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0157c0 extends y3.h implements E3.p {

    /* renamed from: k, reason: collision with root package name */
    public ViewGroup f1914k;

    /* renamed from: l, reason: collision with root package name */
    public View f1915l;

    /* renamed from: m, reason: collision with root package name */
    public int f1916m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f1917o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f1918p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1919q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0157c0(ViewGroup viewGroup, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f1919q = viewGroup;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((C0157c0) create((L3.d) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        C0157c0 c0157c0 = new C0157c0(this.f1919q, interfaceC0936d);
        c0157c0.f1918p = obj;
        return c0157c0;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        L3.d dVar;
        ViewGroup viewGroup;
        int childCount;
        int i5;
        int i6;
        Object obj2;
        int i7;
        ViewGroup viewGroup2;
        L3.d dVar2;
        Object obj3 = EnumC0973a.f10448j;
        int i8 = this.f1917o;
        Object obj4 = C0900j.f9694a;
        if (i8 != 0) {
            if (i8 == 1) {
                childCount = this.n;
                i6 = this.f1916m;
                View view = this.f1915l;
                viewGroup = this.f1914k;
                dVar = (L3.d) this.f1918p;
                AbstractC0399v1.j(obj);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) view;
                    F3.i.f(viewGroup3, "<this>");
                    C0157c0 c0157c0 = new C0157c0(viewGroup3, null);
                    this.f1918p = dVar;
                    this.f1914k = viewGroup;
                    this.f1915l = null;
                    this.f1916m = i6;
                    this.n = childCount;
                    this.f1917o = 2;
                    dVar.getClass();
                    L3.d dVar3 = new L3.d();
                    dVar3.f1632m = AbstractC0203a.e(c0157c0, dVar3, dVar3);
                    if (dVar3.hasNext()) {
                        dVar.f1631l = dVar3;
                        dVar.f1629j = 2;
                        dVar.f1632m = this;
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
                    i7 = i6;
                    viewGroup2 = viewGroup;
                    dVar2 = dVar;
                }
                i5 = i6 + 1;
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                childCount = this.n;
                i7 = this.f1916m;
                viewGroup2 = this.f1914k;
                dVar2 = (L3.d) this.f1918p;
                AbstractC0399v1.j(obj);
            }
            viewGroup = viewGroup2;
            dVar = dVar2;
            i6 = i7;
            i5 = i6 + 1;
        } else {
            AbstractC0399v1.j(obj);
            dVar = (L3.d) this.f1918p;
            viewGroup = this.f1919q;
            childCount = viewGroup.getChildCount();
            i5 = 0;
        }
        if (i5 >= childCount) {
            return obj4;
        }
        View childAt = viewGroup.getChildAt(i5);
        F3.i.e(childAt, "getChildAt(index)");
        this.f1918p = dVar;
        this.f1914k = viewGroup;
        this.f1915l = childAt;
        this.f1916m = i5;
        this.n = childCount;
        this.f1917o = 1;
        dVar.f1630k = childAt;
        dVar.f1629j = 3;
        dVar.f1632m = this;
        return obj3;
    }
}
