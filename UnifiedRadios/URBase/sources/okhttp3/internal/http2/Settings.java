package okhttp3.internal.http2;

import F3.f;
import F3.i;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        int[] iArr = this.values;
        Arrays.fill(iArr, 0, iArr.length, 0);
    }

    public final int get(int i5) {
        return this.values[i5];
    }

    public final boolean getEnablePush(boolean z4) {
        return (this.set & 4) != 0 ? this.values[2] == 1 : z4;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int i5) {
        return (this.set & 32) != 0 ? this.values[5] : i5;
    }

    public final int getMaxHeaderListSize(int i5) {
        return (this.set & 64) != 0 ? this.values[6] : i5;
    }

    public final boolean isSet(int i5) {
        return ((1 << i5) & this.set) != 0;
    }

    public final void merge(Settings settings) {
        i.f(settings, "other");
        for (int i5 = 0; i5 < 10; i5++) {
            if (settings.isSet(i5)) {
                set(i5, settings.get(i5));
            }
        }
    }

    public final Settings set(int i5, int i6) {
        if (i5 >= 0) {
            int[] iArr = this.values;
            if (i5 < iArr.length) {
                this.set = (1 << i5) | this.set;
                iArr[i5] = i6;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
