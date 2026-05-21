package j1;

/* renamed from: j1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0599a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7562a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7563b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7564c;

    public /* synthetic */ C0599a(int i5, String str, boolean z4) {
        this.f7562a = i5;
        this.f7564c = str;
        this.f7563b = z4;
    }

    public String toString() {
        switch (this.f7562a) {
            case 0:
                String str = this.f7564c;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(this.f7563b);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public C0599a(String str, boolean z4) {
        this.f7562a = 1;
        this.f7563b = z4;
        this.f7564c = str;
    }
}
