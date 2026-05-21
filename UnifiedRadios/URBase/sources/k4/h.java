package k4;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8277a;

    public final g a(g gVar, g gVar2) {
        int i5;
        switch (this.f8277a) {
            case 0:
                if (gVar2 == null) {
                    gVar2 = new g();
                }
                if (gVar.size() != 0) {
                    int i6 = gVar.f8273k - 1;
                    int i7 = gVar.f8274l - 1;
                    gVar2.b(gVar.f8272j, i6, i7, gVar.f8275m + i6 + 1, gVar.n + i7 + 1);
                    break;
                } else {
                    gVar2.f8275m = 0;
                    break;
                }
            default:
                if (gVar2 == null) {
                    gVar2 = new g();
                }
                if (gVar.size() == 0 || gVar.f8272j - 1 < 0 || i5 > 29) {
                    gVar2.f8275m = 0;
                    break;
                } else {
                    int i8 = gVar.f8273k;
                    int i9 = gVar.f8274l;
                    int i10 = i8 + gVar.f8275m;
                    int i11 = gVar.f8276o;
                    gVar2.b(i5, i8 >> 1, i9 >> 1, (i10 % i11) >> 1, ((i9 + gVar.n) % i11) >> 1);
                    break;
                }
                break;
        }
        return gVar2;
    }
}
