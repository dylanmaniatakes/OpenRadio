package H3;

import java.util.Random;

/* loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f664a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f664a) {
            case 0:
                return new Random();
            case 1:
                return new Z3.b();
            case 2:
                return Boolean.FALSE;
            default:
                return 0L;
        }
    }
}
