package i4;

import O.C0182v;
import k4.l;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7374j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, int i5, int i6, int i7, String str2, String[] strArr, C0182v c0182v) {
        super(str, i5, i6, i7, str2, strArr, c0182v);
        this.f7374j = 2;
    }

    @Override // i4.d
    public String d(long j5) {
        switch (this.f7374j) {
            case 0:
                return a() + ((int) (j5 >> 58)) + "/" + l.h(j5) + "/" + l.g(j5);
            case 1:
                return a() + ((int) (j5 >> 58)) + "/" + l.h(j5) + "/" + l.g(j5);
            default:
                return a() + ((int) (j5 >> 58)) + "/" + l.g(j5) + "/" + l.h(j5) + this.f7370d;
        }
    }

    @Override // i4.d
    public String toString() {
        switch (this.f7374j) {
            case 2:
                return this.f7369c;
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, int i5, int i6, int i7, String str2, String[] strArr, int i8) {
        super(str, i5, i6, i7, str2, strArr, new C0182v(0, 0));
        this.f7374j = i8;
    }
}
