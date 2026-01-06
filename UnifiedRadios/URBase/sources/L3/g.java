package L3;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1633a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1634b;

    public /* synthetic */ g(int i5, Object obj) {
        this.f1633a = i5;
        this.f1634b = obj;
    }

    @Override // L3.c
    public final Iterator iterator() {
        switch (this.f1633a) {
            case 0:
                return (Iterator) this.f1634b;
            default:
                return ((Iterable) this.f1634b).iterator();
        }
    }
}
