package n1;

import java.util.Arrays;

/* renamed from: n1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0798o extends AbstractBinderC0797n {

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f8761e;

    public BinderC0798o(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f8761e = bArr;
    }

    @Override // n1.AbstractBinderC0797n
    public final byte[] K() {
        return this.f8761e;
    }
}
