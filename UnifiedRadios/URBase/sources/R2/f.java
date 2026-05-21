package R2;

import q1.E;

/* loaded from: classes.dex */
public final class f extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(str);
        E.g(str, "Detail message must not be empty");
    }
}
