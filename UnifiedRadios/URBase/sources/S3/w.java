package S3;

/* loaded from: classes.dex */
public final class w implements p0.e {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2421j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2422k;

    public w(String str, int i5) {
        this.f2421j = i5;
        switch (i5) {
            case 1:
                F3.i.f(str, "query");
                this.f2422k = str;
                break;
            default:
                this.f2422k = str;
                break;
        }
    }

    @Override // p0.e
    public String a() {
        return this.f2422k;
    }

    @Override // p0.e
    public void c(p0.d dVar) {
    }

    public String toString() {
        switch (this.f2421j) {
            case 0:
                return "<" + this.f2422k + '>';
            default:
                return super.toString();
        }
    }
}
