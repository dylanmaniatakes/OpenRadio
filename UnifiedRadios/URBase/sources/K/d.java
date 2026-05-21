package K;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1483a;

    /* renamed from: b, reason: collision with root package name */
    public c f1484b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1485c;

    public final void a() {
        synchronized (this) {
            try {
                if (this.f1483a) {
                    return;
                }
                this.f1483a = true;
                this.f1485c = true;
                c cVar = this.f1484b;
                if (cVar != null) {
                    try {
                        cVar.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f1485c = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                synchronized (this) {
                    this.f1485c = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void b(c cVar) {
        synchronized (this) {
            while (this.f1485c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f1484b == cVar) {
                return;
            }
            this.f1484b = cVar;
            if (this.f1483a) {
                cVar.onCancel();
            }
        }
    }
}
