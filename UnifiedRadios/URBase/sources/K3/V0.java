package k3;

import com.unified.ur1.primary.OptionsActivity;
import j0.RunnableC0588a;

/* loaded from: classes.dex */
public final class V0 implements m3.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8060a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f8061b;

    public V0(OptionsActivity optionsActivity, int i5) {
        this.f8061b = optionsActivity;
        this.f8060a = i5;
    }

    @Override // m3.v
    public final void a(D0.w wVar) {
        this.f8061b.runOnUiThread(new RunnableC0588a(this, wVar, this.f8060a, 3));
    }
}
