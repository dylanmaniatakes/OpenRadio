package D;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f225a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f226b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f227c = new Object();

    public static Typeface a(Context context, int i5) {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i5, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface b(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, D.b r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.p.b(android.content.Context, int, android.util.TypedValue, int, D.b, boolean, boolean):android.graphics.Typeface");
    }
}
