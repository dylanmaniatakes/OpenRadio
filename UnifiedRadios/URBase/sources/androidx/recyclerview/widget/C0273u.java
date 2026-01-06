package androidx.recyclerview.widget;

/* renamed from: androidx.recyclerview.widget.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0273u extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0276x f4336a;

    public C0273u(C0276x c0276x) {
        this.f4336a = c0276x;
    }

    @Override // androidx.recyclerview.widget.a0
    public final void b(RecyclerView recyclerView, int i5, int i6) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        C0276x c0276x = this.f4336a;
        int iComputeVerticalScrollRange = c0276x.f4380s.computeVerticalScrollRange();
        int i7 = c0276x.f4379r;
        int i8 = iComputeVerticalScrollRange - i7;
        int i9 = c0276x.f4365a;
        c0276x.f4381t = i8 > 0 && i7 >= i9;
        int iComputeHorizontalScrollRange = c0276x.f4380s.computeHorizontalScrollRange();
        int i10 = c0276x.f4378q;
        boolean z4 = iComputeHorizontalScrollRange - i10 > 0 && i10 >= i9;
        c0276x.f4382u = z4;
        boolean z5 = c0276x.f4381t;
        if (!z5 && !z4) {
            if (c0276x.f4383v != 0) {
                c0276x.f(0);
                return;
            }
            return;
        }
        if (z5) {
            float f5 = i7;
            c0276x.f4374l = (int) ((((f5 / 2.0f) + iComputeVerticalScrollOffset) * f5) / iComputeVerticalScrollRange);
            c0276x.f4373k = Math.min(i7, (i7 * i7) / iComputeVerticalScrollRange);
        }
        if (c0276x.f4382u) {
            float f6 = iComputeHorizontalScrollOffset;
            float f7 = i10;
            c0276x.f4376o = (int) ((((f7 / 2.0f) + f6) * f7) / iComputeHorizontalScrollRange);
            c0276x.n = Math.min(i10, (i10 * i10) / iComputeHorizontalScrollRange);
        }
        int i11 = c0276x.f4383v;
        if (i11 == 0 || i11 == 1) {
            c0276x.f(1);
        }
    }
}
