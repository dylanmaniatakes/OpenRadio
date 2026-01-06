package D1;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class L {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f364a;

    /* renamed from: b, reason: collision with root package name */
    public static final StringBuilder f365b;

    static {
        Locale locale = Locale.ROOT;
        f364a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        f365b = new StringBuilder(33);
    }

    public static void a(long j5, StringBuilder sb) {
        if (j5 == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z4 = false;
        if (j5 < 0) {
            sb.append("-");
            if (j5 != Long.MIN_VALUE) {
                j5 = -j5;
            } else {
                j5 = Long.MAX_VALUE;
                z4 = true;
            }
        }
        if (j5 >= 86400000) {
            sb.append(j5 / 86400000);
            sb.append("d");
            j5 %= 86400000;
        }
        if (true == z4) {
            j5 = 25975808;
        }
        if (j5 >= 3600000) {
            sb.append(j5 / 3600000);
            sb.append("h");
            j5 %= 3600000;
        }
        if (j5 >= 60000) {
            sb.append(j5 / 60000);
            sb.append("m");
            j5 %= 60000;
        }
        if (j5 >= 1000) {
            sb.append(j5 / 1000);
            sb.append("s");
            j5 %= 1000;
        }
        if (j5 > 0) {
            sb.append(j5);
            sb.append("ms");
        }
    }
}
