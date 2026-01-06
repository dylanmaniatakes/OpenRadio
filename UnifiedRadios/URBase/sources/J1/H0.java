package J1;

/* loaded from: classes.dex */
public enum H0 {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");


    /* renamed from: j, reason: collision with root package name */
    public final String f863j;

    H0(String str) {
        this.f863j = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f863j;
    }
}
