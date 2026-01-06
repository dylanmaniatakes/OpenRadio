package f2;

/* renamed from: f2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0485i extends AbstractC0486j {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f6501e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AbstractC0487k f6502f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0485i(C0489m c0489m, int i5) {
        super(c0489m);
        this.f6501e = i5;
        this.f6502f = c0489m;
    }

    @Override // f2.AbstractC0486j
    public final float a() {
        switch (this.f6501e) {
            case 0:
                AbstractC0487k abstractC0487k = this.f6502f;
                return abstractC0487k.h + abstractC0487k.f6523i;
            case 1:
                AbstractC0487k abstractC0487k2 = this.f6502f;
                return abstractC0487k2.h + abstractC0487k2.f6524j;
            default:
                return this.f6502f.h;
        }
    }
}
