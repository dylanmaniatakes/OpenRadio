package A2;

import F2.t;
import android.content.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Q2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19c;

    public /* synthetic */ c(Context context, String str) {
        this.f17a = 2;
        this.f19c = context;
        this.f18b = str;
    }

    @Override // Q2.a
    public final Object get() {
        switch (this.f17a) {
            case 0:
                g gVar = (g) this.f18b;
                String strC = gVar.c();
                return new V2.a((Context) this.f19c, strC);
            case 1:
                F2.g gVar2 = (F2.g) this.f18b;
                gVar2.getClass();
                F2.b bVar = (F2.b) this.f19c;
                return bVar.f548f.b(new t(bVar, gVar2));
            default:
                return new O2.h((Context) this.f19c, (String) this.f18b);
        }
    }

    public /* synthetic */ c(Object obj, int i5, Object obj2) {
        this.f17a = i5;
        this.f18b = obj;
        this.f19c = obj2;
    }
}
