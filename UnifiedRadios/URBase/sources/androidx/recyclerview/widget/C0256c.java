package androidx.recyclerview.widget;

/* renamed from: androidx.recyclerview.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0256c implements H {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4208a;

    @Override // androidx.recyclerview.widget.H
    public void a(int i5, int i6) {
        ((N) this.f4208a).notifyItemRangeRemoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.H
    public void b(int i5, int i6) {
        ((N) this.f4208a).notifyItemMoved(i5, i6);
    }

    @Override // androidx.recyclerview.widget.H
    public void c(int i5, int i6) {
        ((N) this.f4208a).notifyItemRangeInserted(i5, i6);
    }

    @Override // androidx.recyclerview.widget.H
    public void d(int i5, int i6, Object obj) {
        ((N) this.f4208a).notifyItemRangeChanged(i5, i6, obj);
    }
}
