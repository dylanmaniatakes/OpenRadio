package L2;

import J2.f;
import J2.g;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d implements K2.a {

    /* renamed from: f, reason: collision with root package name */
    public static final b f1615f;
    public static final b g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1616a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f1617b;

    /* renamed from: c, reason: collision with root package name */
    public final a f1618c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1619d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f1614e = new a(0);
    public static final c h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [L2.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [L2.b] */
    static {
        final int i5 = 0;
        f1615f = new f() { // from class: L2.b
            @Override // J2.a
            public final void a(Object obj, Object obj2) {
                switch (i5) {
                    case 0:
                        ((g) obj2).c((String) obj);
                        break;
                    default:
                        ((g) obj2).d(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i6 = 1;
        g = new f() { // from class: L2.b
            @Override // J2.a
            public final void a(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        ((g) obj2).c((String) obj);
                        break;
                    default:
                        ((g) obj2).d(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap map = new HashMap();
        this.f1616a = map;
        HashMap map2 = new HashMap();
        this.f1617b = map2;
        this.f1618c = f1614e;
        this.f1619d = false;
        map2.put(String.class, f1615f);
        map.remove(String.class);
        map2.put(Boolean.class, g);
        map.remove(Boolean.class);
        map2.put(Date.class, h);
        map.remove(Date.class);
    }

    public final K2.a a(Class cls, J2.d dVar) {
        this.f1616a.put(cls, dVar);
        this.f1617b.remove(cls);
        return this;
    }
}
