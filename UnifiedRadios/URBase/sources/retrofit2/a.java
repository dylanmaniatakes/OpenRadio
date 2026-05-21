package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9525j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f9526k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Callback f9527l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f9528m;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Object obj, int i5) {
        this.f9525j = i5;
        this.f9526k = anonymousClass1;
        this.f9527l = callback;
        this.f9528m = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9525j) {
            case 0:
                this.f9526k.lambda$onResponse$0(this.f9527l, (Response) this.f9528m);
                break;
            default:
                this.f9526k.lambda$onFailure$1(this.f9527l, (Throwable) this.f9528m);
                break;
        }
    }
}
