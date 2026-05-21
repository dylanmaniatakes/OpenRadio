package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4263a;

    /* renamed from: b, reason: collision with root package name */
    public int f4264b;

    /* renamed from: c, reason: collision with root package name */
    public int f4265c;

    /* renamed from: d, reason: collision with root package name */
    public int f4266d;

    /* renamed from: e, reason: collision with root package name */
    public int f4267e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4268f;
    public boolean g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4269i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4270j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4271k;

    /* renamed from: l, reason: collision with root package name */
    public int f4272l;

    /* renamed from: m, reason: collision with root package name */
    public long f4273m;
    public int n;

    public final void a(int i5) {
        if ((this.f4266d & i5) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i5) + " but it is " + Integer.toBinaryString(this.f4266d));
    }

    public final int b() {
        return this.g ? this.f4264b - this.f4265c : this.f4267e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f4263a + ", mData=null, mItemCount=" + this.f4267e + ", mIsMeasuring=" + this.f4269i + ", mPreviousLayoutItemCount=" + this.f4264b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4265c + ", mStructureChanged=" + this.f4268f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.f4270j + ", mRunPredictiveAnimations=" + this.f4271k + '}';
    }
}
