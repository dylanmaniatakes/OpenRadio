package w0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f10069a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10070b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10071c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10072d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10073e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10074f;
    public final /* synthetic */ m g;

    public l(m mVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = mVar;
        this.f10069a = obj;
        this.f10070b = arrayList;
        this.f10071c = obj2;
        this.f10072d = arrayList2;
        this.f10073e = obj3;
        this.f10074f = arrayList3;
    }

    @Override // w0.q, w0.o
    public final void a() {
        m mVar = this.g;
        Object obj = this.f10069a;
        if (obj != null) {
            mVar.s(obj, this.f10070b, null);
        }
        Object obj2 = this.f10071c;
        if (obj2 != null) {
            mVar.s(obj2, this.f10072d, null);
        }
        Object obj3 = this.f10073e;
        if (obj3 != null) {
            mVar.s(obj3, this.f10074f, null);
        }
    }

    @Override // w0.o
    public final void e(p pVar) {
        pVar.v(this);
    }
}
