package N0;

/* loaded from: classes.dex */
public final class b extends Throwable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1763j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i5) {
        super(str);
        this.f1763j = i5;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        int i5 = this.f1763j;
        synchronized (this) {
            switch (i5) {
            }
            return this;
        }
    }
}
