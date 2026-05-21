package l4;

/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8427j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b f8428k;

    public /* synthetic */ a(b bVar, int i5) {
        this.f8427j = i5;
        this.f8428k = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        switch (this.f8427j) {
            case 0:
                break;
            default:
                this.f8428k.f8431c.start();
                return;
        }
        while (true) {
            b bVar = this.f8428k;
            long j5 = bVar.f8438l;
            bVar.getClass();
            bVar.getClass();
            long jCurrentTimeMillis = (j5 + 3500) - System.currentTimeMillis();
            if (jCurrentTimeMillis <= 0) {
                if (bVar.f8435i) {
                    return;
                }
                bVar.f8431c.setStartDelay(0L);
                bVar.f8430b.post(new a(bVar, 1));
                return;
            }
            try {
                Thread.sleep(jCurrentTimeMillis, 0);
            } catch (InterruptedException unused) {
            }
        }
    }
}
