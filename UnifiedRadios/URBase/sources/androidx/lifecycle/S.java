package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class S {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3940a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f3941b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f3942c = false;

    public static void a(Object obj) throws IOException {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    public void b() {
    }
}
