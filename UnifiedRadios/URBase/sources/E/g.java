package E;

import android.content.res.Resources;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final h4.f f426a;

    /* renamed from: b, reason: collision with root package name */
    public static final q.f f427b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f426a = new i();
        } else {
            f426a = new h();
        }
        f427b = new q.f(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r16, D.e r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, D.b r23, boolean r24) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E.g.a(android.content.Context, D.e, android.content.res.Resources, int, java.lang.String, int, int, D.b, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i5, String str, int i6, int i7) {
        return resources.getResourcePackageName(i5) + '-' + str + '-' + i6 + '-' + i5 + '-' + i7;
    }
}
