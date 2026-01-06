package v3;

import F3.i;
import java.util.Comparator;

/* renamed from: v3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0922a implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final C0922a f10029b = new C0922a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final C0922a f10030c = new C0922a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10031a;

    public /* synthetic */ C0922a(int i5) {
        this.f10031a = i5;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f10031a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                i.f(comparable, "a");
                i.f(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                i.f(comparable3, "a");
                i.f(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f10031a) {
            case 0:
                return f10030c;
            default:
                return f10029b;
        }
    }
}
