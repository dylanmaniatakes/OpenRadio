package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public final class n0 extends Writer {

    /* renamed from: k, reason: collision with root package name */
    public final StringBuilder f3851k = new StringBuilder(128);

    /* renamed from: j, reason: collision with root package name */
    public final String f3850j = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f3851k;
        if (sb.length() > 0) {
            Log.d(this.f3850j, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            char c2 = cArr[i5 + i7];
            if (c2 == '\n') {
                a();
            } else {
                this.f3851k.append(c2);
            }
        }
    }
}
