package U3;

import N3.AbstractC0146u;

/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f2493l;

    public j(Runnable runnable, long j5, i iVar) {
        super(j5, iVar);
        this.f2493l = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2493l.run();
        } finally {
            this.f2491k.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f2493l;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC0146u.e(runnable));
        sb.append(", ");
        sb.append(this.f2490j);
        sb.append(", ");
        sb.append(this.f2491k);
        sb.append(']');
        return sb.toString();
    }
}
