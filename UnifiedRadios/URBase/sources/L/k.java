package L;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class k implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1529a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1530b;

    /* renamed from: c, reason: collision with root package name */
    public String f1531c;

    public /* synthetic */ k() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f1529a) {
            case 0:
                return new j(runnable, this.f1531c, this.f1530b);
            default:
                Thread thread = new Thread(runnable);
                thread.setPriority(this.f1530b);
                String str = this.f1531c;
                if (str != null) {
                    thread.setName(str);
                }
                return thread;
        }
    }

    public k(int i5, String str) {
        this.f1530b = i5;
        this.f1531c = str;
    }
}
