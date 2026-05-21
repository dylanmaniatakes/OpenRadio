package I3;

import F3.i;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public final class a extends H3.a {
    @Override // H3.a
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        i.e(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
