package retrofit2;

import E3.l;
import F3.j;
import s3.C0900j;

/* loaded from: classes.dex */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends j implements l {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    @Override // E3.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return C0900j.f9694a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
