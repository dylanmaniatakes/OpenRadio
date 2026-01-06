package x2;

/* renamed from: x2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0968c extends AbstractC0967b {

    /* renamed from: j, reason: collision with root package name */
    public final Object f10440j;

    public C0968c(Object obj) {
        this.f10440j = obj;
    }

    @Override // x2.AbstractC0967b
    public final Object a() {
        return this.f10440j;
    }

    @Override // x2.AbstractC0967b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0968c) {
            return this.f10440j.equals(((C0968c) obj).f10440j);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10440j.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f10440j);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
