package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class q0 extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4315a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ J f4316b;

    public q0(J j5) {
        this.f4316b = j5;
    }

    @Override // androidx.recyclerview.widget.a0
    public final void a(int i5, RecyclerView recyclerView) {
        if (i5 == 0 && this.f4315a) {
            this.f4315a = false;
            this.f4316b.h();
        }
    }

    @Override // androidx.recyclerview.widget.a0
    public final void b(RecyclerView recyclerView, int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return;
        }
        this.f4315a = true;
    }
}
