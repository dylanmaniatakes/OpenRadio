package androidx.fragment.app;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0220o implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3852j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Fragment f3853k;

    public /* synthetic */ RunnableC0220o(Fragment fragment, int i5) {
        this.f3852j = i5;
        this.f3853k = fragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3852j) {
            case 0:
                this.f3853k.startPostponedEnterTransition();
                break;
            default:
                this.f3853k.callStartTransitionListener(false);
                break;
        }
    }
}
