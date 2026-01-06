package y2;

/* renamed from: y2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0986e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10494a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10495b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10496c;

    public C0986e(Object obj, Object obj2, Object obj3) {
        this.f10494a = obj;
        this.f10495b = obj2;
        this.f10496c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f10494a;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.f10495b);
        String strValueOf3 = String.valueOf(obj);
        String strValueOf4 = String.valueOf(this.f10496c);
        StringBuilder sb = new StringBuilder(strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 39);
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }
}
