package b1;

/* loaded from: classes.dex */
public enum c implements M2.c {
    REASON_UNKNOWN(0),
    MESSAGE_TOO_OLD(1),
    CACHE_FULL(2),
    PAYLOAD_TOO_BIG(3),
    MAX_RETRIES_REACHED(4),
    INVALID_PAYLOD(5),
    SERVER_ERROR(6);


    /* renamed from: j, reason: collision with root package name */
    public final int f4526j;

    c(int i5) {
        this.f4526j = i5;
    }

    @Override // M2.c
    public final int a() {
        return this.f4526j;
    }
}
